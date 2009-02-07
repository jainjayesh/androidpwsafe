#!/usr/bin/python2.4

"""Creates symlinks to directly used third-party Java code.

Android projects require source code (not jar files) to third-party
dependencies and will bake in all available code into the .apk file thereby
bloating it.  This script will go through source files and the classpath
given on the command line in order to create the minimal set of files needed
for the project.

Note that rather than using Java reflection, simple regexp
matches are done on the code.  While not perfect, it works (for now) with the
current dependencies.

Usage:
  cd $HOME/androidpwsafe/src
  create_symlinks_to_third_party_java_files.py --classpath=$HOME/blowfish/src:$HOME/bouncyclastle:$HOME/jpwsafe/PasswordSafeLib/src org/pwsafe/android/*.java
"""

import glob
import optparse
import os
import os.path
import re


def CreateSymlink(from_file, to_file, path=None, file_system=None):
  """Conditionally creates symlink.

  Returns: whether or not symlink is created.
  """
  if file_system is None: file_system = os
  if path is None: path = os.path

  result = False

  if path.exists(from_file):
    if not path.exists(to_file):
      to_dirname = path.dirname(to_file)

      if not path.exists(to_dirname):
        file_system.makedirs(to_dirname)
      file_system.symlink(from_file, to_file)

      result = True

  return result


class SyntaxParser(object):
  def Matches(self, line):
    """Returns whether or not the parser groks the line."""
    return False

  def NewFiles(self, root, package):
    """Returns list of new file tuples found through parsing."""
    return []

  @staticmethod
  def _ProcessRootPackageClassname(root, package, classname, path=None):
    """Conditionally creates symlink."""
    if path is None: path = os.path

    result = None

    java = '%s.java' % classname
    java_path = path.join(package, java)
    java_absolute_path = path.join(root, java_path)
    if CreateSymlink(java_absolute_path, java_path):
      result = (root, package, java)

    return result


class ExtendsOrNewParser(SyntaxParser):

  """Parses lines with an 'extends' clause or calling 'new'."""

  RE = re.compile(' (extends|new) ([a-zA-Z0-9_]+)')

  def Matches(self, line):
    self._matches = self.RE.search(line)
    print 'YAPN: %s, %s' % (line, self._matches is not None)

    return self._matches is not None

  def NewFiles(self, root, package):
    return [
        self._ProcessRootPackageClassname(
            root, package, self._matches.group(2))]


class FunctionDefinitionParser(SyntaxParser):

  """Parses first line of function definitions."""

  RE = re.compile(' ([a-zA-Z0-9_]+ )?([a-zA-Z0-9_]+)\( *([^{]*) *[^;]')

  def Matches(self, line):
    self._matches = self.RE.search(line)

    return self._matches is not None

  def NewFiles(self, root, package):
    return [
        self._ProcessRootPackageClassname(
            root, package, classname.split(' ')[0].strip())
        for classname in self._matches.group(3).split(', ')]


class ImportParser(SyntaxParser):

  """Parses import lines."""

  def __init__(self, classpath):
    self._classpath = classpath

  def Matches(self, line):
    self._line = line

    return line.startswith('import ')

  def NewFiles(self, root, package):
    result = []

    fqcn = self._line[:self._line.rindex(';')][len('import '):]
    classname = fqcn[fqcn.rindex('.')+1:]
    package = fqcn.replace('.', '/')[:fqcn.rindex('.')]

    for root in self._classpath:
      result = [self._ProcessRootPackageClassname(root, package, classname)]

      if result[0]:
        break

    return result


class ThrowsParser(SyntaxParser):

  """Parses lines with a 'throws' clause."""

  RE = re.compile(' throws ([^{]*)')

  def Matches(self, line):
    self._matches = self.RE.search(line)

    return self._matches is not None

  def NewFiles(self, root, package):
    return [
        self._ProcessRootPackageClassname(root, package, classname.strip())
        for classname in self._matches.group(1).split(', ')]


class StaticParser(SyntaxParser):

  """Parses lines using static class members or methods."""

  RE = re.compile(' ([A-Z][a-zA-Z0-9_]+)\.')

  def Matches(self, line):
    self._matches = self.RE.search(line)

    return self._matches is not None

  def NewFiles(self, root, package):
    return [
        self._ProcessRootPackageClassname(
            root, package, self._matches.group(1))]


class LineProcessor(object):
  def __init__(self):
    self._parsers = []

  @staticmethod
  def _FilterOutNone(l):
    """Filters out None from list argument."""
    return [e
            for e in l
            if e is not None]

  def Register(self, parser):
    """Registers SyntaxParser to be used for processing lines."""
    self._parsers.append(parser)

  def Process(self, root, package, line):
    """Processes line.

    Returns: list of new file tuples.
    """
    result = []

    for parser in self._parsers:
      if parser.Matches(line):
        result = self._FilterOutNone(parser.NewFiles(root, package))

        break

    return result


class FileProcessor(object):
  def __init__(self, line_processor):
    self._line_processor = line_processor

  def Process(self, files, file_creator=None, path=None):
    """Processes files."""
    if file_creator is None: file_creator = __builtins__.file
    if path is None: path = os.path

    for (root, package, file) in files:
      self._ProcessLines(
          root,
          package,
          file_creator(path.join(root, package, file)).xreadlines())

  def _ProcessLines(self, root, package, lines):
    for line in lines:
      self.Process(self._line_processor.Process(root, package, line))


def main():
  option_parser = optparse.OptionParser()
  option_parser.add_option(
      '',
      '--classpath',
      dest='classpath',
      help='CLASSPATH used to find Java files.')

  (options, args) = option_parser.parse_args()

  files = [(os.getcwd(), os.path.dirname(arg), os.path.basename(arg))
           for arg in args]
  classpath = options.classpath.split(':')

  line_processor = LineProcessor()
  line_processor.Register(ImportParser(classpath))
  line_processor.Register(ExtendsOrNewParser())
  line_processor.Register(FunctionDefinitionParser())
  line_processor.Register(ThrowsParser())
  line_processor.Register(StaticParser())

  file_processor = FileProcessor(line_processor)
  file_processor.Process(files)


if __name__ == '__main__':
  main()
