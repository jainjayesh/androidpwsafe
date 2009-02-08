#!/usr/bin/python2.4

import mox
import os
import os.path
import unittest

import create_symlinks_to_third_party_java_files


class CreateSymlinksTestCase(unittest.TestCase):
  def testCreateSymlinkWhenFromFileDoesNotExist(self):
    expected = False

    from_file = 'from-file'
    to_file = 'to-file'

    mox_factory = mox.Mox()

    path_mock = mox_factory.CreateMock(os.path)
    path_mock.exists(from_file).AndReturn(False)

    mox_factory.ReplayAll()

    observed = (
        create_symlinks_to_third_party_java_files.CreateSymlink(
            from_file, to_file, path=path_mock))

    mox_factory.VerifyAll()
    self.assertEqual(expected, observed)

  def testCreateSymlinkWhenToFileExists(self):
    expected = False

    from_file = 'from-file'
    to_file = 'to-file'

    mox_factory = mox.Mox()

    path_mock = mox_factory.CreateMock(os.path)
    path_mock.exists(from_file).AndReturn(True)
    path_mock.exists(to_file).AndReturn(True)

    mox_factory.ReplayAll()

    observed = (
        create_symlinks_to_third_party_java_files.CreateSymlink(
            from_file, to_file, path=path_mock))

    mox_factory.VerifyAll()
    self.assertEqual(expected, observed)

  def testCreateSymlinkWhenToDirExists(self):
    expected = True

    from_file = 'from/file'
    to_file = 'to/file'
    to_dir = 'to'

    mox_factory = mox.Mox()

    path_mock = mox_factory.CreateMock(os.path)
    path_mock.exists(from_file).AndReturn(True)
    path_mock.exists(to_file).AndReturn(False)
    path_mock.dirname(to_file).AndReturn(to_dir)
    path_mock.exists(to_dir).AndReturn(True)

    file_system_mock = mox_factory.CreateMock(os)
    file_system_mock.symlink(from_file, to_file)

    mox_factory.ReplayAll()

    observed = create_symlinks_to_third_party_java_files.CreateSymlink(
        from_file, to_file, path=path_mock, file_system=file_system_mock)

    mox_factory.VerifyAll()
    self.assertEqual(expected, observed)

  def testCreateSymlinkWhenToDirDoesNotExist(self):
    expected = True

    from_file = 'from/file'
    to_file = 'to/file'
    to_dir = 'to'

    mox_factory = mox.Mox()

    path_mock = mox_factory.CreateMock(os.path)
    path_mock.exists(from_file).AndReturn(True)
    path_mock.exists(to_file).AndReturn(False)
    path_mock.dirname(to_file).AndReturn(to_dir)
    path_mock.exists(to_dir).AndReturn(False)

    file_system_mock = mox_factory.CreateMock(os)
    file_system_mock.makedirs(to_dir)
    file_system_mock.symlink(from_file, to_file)

    mox_factory.ReplayAll()

    observed = create_symlinks_to_third_party_java_files.CreateSymlink(
        from_file, to_file, path=path_mock, file_system=file_system_mock)

    mox_factory.VerifyAll()
    self.assertEqual(expected, observed)


class SyntaxParserTestCase(unittest.TestCase):
  def testProcessRootPackageClassnameWhenFromFileExists(self):
    expected = ('/root', 'package', 'Class.java')

    mox_factory = mox.Mox()

    mox_factory.StubOutWithMock(
        create_symlinks_to_third_party_java_files, 'CreateSymlink')
    create_symlinks_to_third_party_java_files.CreateSymlink(
        '/root/package/Class.java', 'package/Class.java').AndReturn(expected)

    path_mock = mox_factory.CreateMock(os.path)
    path_mock.join('package', 'Class.java').AndReturn('package/Class.java')
    path_mock.join(
        '/root', 'package/Class.java').AndReturn('/root/package/Class.java')

    mox_factory.ReplayAll()

    SyntaxParser = create_symlinks_to_third_party_java_files.SyntaxParser
    observed = SyntaxParser._ProcessRootPackageClassname(
        '/root', 'package', 'Class', path=path_mock)

    mox_factory.VerifyAll()
    self.assertEqual(expected, observed)

    mox_factory.UnsetStubs()

  def testProcessRootPackageClassnameWhenFromFileDoesNotExist(self):
    expected = None

    mox_factory = mox.Mox()

    mox_factory.StubOutWithMock(
        create_symlinks_to_third_party_java_files, 'CreateSymlink')
    create_symlinks_to_third_party_java_files.CreateSymlink(
        '/root/package/Class.java', 'package/Class.java').AndReturn(expected)

    path_mock = mox_factory.CreateMock(os.path)
    path_mock.join('package', 'Class.java').AndReturn('package/Class.java')
    path_mock.join(
        '/root', 'package/Class.java').AndReturn('/root/package/Class.java')

    mox_factory.ReplayAll()

    SyntaxParser = create_symlinks_to_third_party_java_files.SyntaxParser
    observed = SyntaxParser._ProcessRootPackageClassname(
        '/root', 'package', 'Class', path=path_mock)

    mox_factory.VerifyAll()
    self.assertEqual(expected, observed)

    mox_factory.UnsetStubs()


class FunctionDefinitionParserTestCase(unittest.TestCase):
  def testMatchConstructor(self):
    function_definition_parser = (
        create_symlinks_to_third_party_java_files.FunctionDefinitionParser())

    observed = (
        function_definition_parser.Matches('  public ClassA(ClassB classB) {'))

    self.assertTrue(observed)

  def testMatchFunction(self):
    function_definition_parser = (
        create_symlinks_to_third_party_java_files.FunctionDefinitionParser())

    observed = (
        function_definition_parser.Matches('  public void method(Class class) {'))

    self.assertTrue(observed)

  def testNoMatch(self):
    function_definition_parser = (
      create_symlinks_to_third_party_java_files.FunctionDefinitionParser())

    observed = function_definition_parser.Matches('// no match')

    self.assertFalse(observed)

  def testNewFiles(self):
    expected = [('/root', 'package', 'Class.java'),
                ('/root', 'pakcage', 'ClassB.java')]

    line = 'void Method(ClassA classA, ClassB classB) {'

    function_definition_parser = (
      create_symlinks_to_third_party_java_files.FunctionDefinitionParser())
    function_definition_parser._matches = (
        create_symlinks_to_third_party_java_files.FunctionDefinitionParser.RE.search(
            line))

    mox_factory = mox.Mox()

    SyntaxParser = create_symlinks_to_third_party_java_files.SyntaxParser
    mox_factory.StubOutWithMock(SyntaxParser, '_ProcessRootPackageClassname')
    SyntaxParser._ProcessRootPackageClassname(
        '/root', 'package', 'ClassA').AndReturn(expected[0])
    SyntaxParser._ProcessRootPackageClassname(
        '/root', 'package', 'ClassB').AndReturn(expected[1])

    mox_factory.ReplayAll()

    observed = function_definition_parser.NewFiles('/root', 'package')

    mox_factory.VerifyAll()
    self.assertEqual(expected, observed)

    mox_factory.UnsetStubs()


class ImportParserTestCase(unittest.TestCase):
  def testMatch(self):
    import_parser = create_symlinks_to_third_party_java_files.ImportParser([])

    observed = import_parser.Matches('import Class')

    self.assertTrue(observed)

  def testNoMatch(self):
    import_parser = create_symlinks_to_third_party_java_files.ImportParser([])

    observed = import_parser.Matches('// no match')

    self.assertFalse(observed)

  def testNewFilesWhenClassIsIn1stDirectoryInClasspath(self):
    expected = [('/root-0', 'package', 'Class.java')]

    import_line = 'import package.Class;'
    classpath = ['/root-0', '/root-1']

    import_parser = (
        create_symlinks_to_third_party_java_files.ImportParser(classpath))
    import_parser._line = 'import package.Class;'

    mox_factory = mox.Mox()

    SyntaxParser = create_symlinks_to_third_party_java_files.SyntaxParser
    mox_factory.StubOutWithMock(SyntaxParser, '_ProcessRootPackageClassname')
    SyntaxParser._ProcessRootPackageClassname(
        '/root-0', 'package', 'Class').AndReturn(expected[0])

    mox_factory.ReplayAll()

    observed = import_parser.NewFiles(None, None)

    mox_factory.VerifyAll()
    self.assertEqual(expected, observed)

    mox_factory.UnsetStubs()

  def testNewFilesWhenClassIsInNthDirectoryInClasspath(self):
    expected = [('/root-1', 'package', 'Class.java')]

    import_line = 'import package.Class;'
    classpath = ['/root-0', '/root-1']

    import_parser = (
        create_symlinks_to_third_party_java_files.ImportParser(classpath))
    import_parser._line = 'import package.Class;'

    mox_factory = mox.Mox()

    SyntaxParser = create_symlinks_to_third_party_java_files.SyntaxParser
    mox_factory.StubOutWithMock(SyntaxParser, '_ProcessRootPackageClassname')
    SyntaxParser._ProcessRootPackageClassname(
        '/root-0', 'package', 'Class').AndReturn(None)
    SyntaxParser._ProcessRootPackageClassname(
        '/root-1', 'package', 'Class').AndReturn(expected[0])

    mox_factory.ReplayAll()

    observed = import_parser.NewFiles(None, None)

    mox_factory.VerifyAll()
    self.assertEqual(expected, observed)

    mox_factory.UnsetStubs()


class ExtendsParserTestCase(unittest.TestCase):
  def testMatch(self):
    extends_parser = (
        create_symlinks_to_third_party_java_files.ExtendsParser())

    observed = extends_parser.Matches('ClassA extends ClassB {')

    self.assertTrue(observed)

  def testNoMatch(self):
    extends_parser = (
        create_symlinks_to_third_party_java_files.ExtendsParser())

    observed = extends_parser.Matches('// no match')

    self.assertFalse(observed)

  def testNewFiles(self):
    expected = [('/root', 'package', 'ClassB.java')]

    line = 'ClassA extends ClassB {'

    ExtendsParser = (
        create_symlinks_to_third_party_java_files.ExtendsParser)
    extends_parser = ExtendsParser()
    extends_parser._matches = ExtendsParser.RE.search(line)

    mox_factory = mox.Mox()

    SyntaxParser = create_symlinks_to_third_party_java_files.SyntaxParser
    mox_factory.StubOutWithMock(SyntaxParser, '_ProcessRootPackageClassname')
    SyntaxParser._ProcessRootPackageClassname(
        '/root', 'package', 'ClassB').AndReturn(expected[0])

    mox_factory.ReplayAll()

    observed = extends_parser.NewFiles('/root', 'package')

    mox_factory.VerifyAll()
    self.assertEqual(expected, observed)

    mox_factory.UnsetStubs()


class ImplementsParserTestCase(unittest.TestCase):
  def testMatch(self):
    implements_parser = (
        create_symlinks_to_third_party_java_files.ImplementsParser())

    observed = implements_parser.Matches('ClassA implements ClassB {')

    self.assertTrue(observed)

  def testNoMatch(self):
    implements_parser = (
        create_symlinks_to_third_party_java_files.ImplementsParser())

    observed = implements_parser.Matches('// no match')

    self.assertFalse(observed)

  def testNewFiles(self):
    expected = [('/root', 'package', 'ClassB.java')]

    line = 'ClassA implements ClassB {'

    ImplementsParser = (
        create_symlinks_to_third_party_java_files.ImplementsParser)
    implements_parser = ImplementsParser()
    implements_parser._matches = ImplementsParser.RE.search(line)

    mox_factory = mox.Mox()

    SyntaxParser = create_symlinks_to_third_party_java_files.SyntaxParser
    mox_factory.StubOutWithMock(SyntaxParser, '_ProcessRootPackageClassname')
    SyntaxParser._ProcessRootPackageClassname(
        '/root', 'package', 'ClassB').AndReturn(expected[0])

    mox_factory.ReplayAll()

    observed = implements_parser.NewFiles('/root', 'package')

    mox_factory.VerifyAll()
    self.assertEqual(expected, observed)

    mox_factory.UnsetStubs()


class NewParserTestCase(unittest.TestCase):
  def testMatch(self):
    new_parser = create_symlinks_to_third_party_java_files.NewParser()

    observed = new_parser.Matches('classA = new ClassA();')

    self.assertTrue(observed)

  def testMatchNested(self):
    new_parser = create_symlinks_to_third_party_java_files.NewParser()

    observed = new_parser.Matches(' new ClassA(new ClassB())')

    self.assertTrue(observed)

  def testNoMatch(self):
    new_parser = (
        create_symlinks_to_third_party_java_files.NewParser())

    observed = new_parser.Matches('// no match')

    self.assertFalse(observed)

  def testNewFiles(self):
    expected = [
        ('/root', 'package', 'ClassA.java'),
        ('/root', 'package', 'ClassB.java')]

    line = ' new ClassA(new ClassB())'

    NewParser = (
        create_symlinks_to_third_party_java_files.NewParser)
    new_parser = NewParser()
    new_parser._matches = NewParser.RE.search(line)

    mox_factory = mox.Mox()

    SyntaxParser = create_symlinks_to_third_party_java_files.SyntaxParser
    mox_factory.StubOutWithMock(SyntaxParser, '_ProcessRootPackageClassname')
    SyntaxParser._ProcessRootPackageClassname(
        '/root', 'package', 'ClassA').AndReturn(expected[0])
    SyntaxParser._ProcessRootPackageClassname(
        '/root', 'package', 'ClassB').AndReturn(expected[1])

    mox_factory.ReplayAll()

    observed = new_parser.NewFiles('/root', 'package')

    mox_factory.VerifyAll()
    self.assertEqual(expected, observed)

    mox_factory.UnsetStubs()


class ThrowsParserTestCase(unittest.TestCase):
  def testMatch(self):
    throws_parser = create_symlinks_to_third_party_java_files.ThrowsParser()

    observed = throws_parser.Matches('void Method() throws Class {')

    self.assertTrue(observed)

  def testNoMatch(self):
    throws_parser = create_symlinks_to_third_party_java_files.ThrowsParser()

    observed = throws_parser.Matches('// no match')

    self.assertFalse(observed)

  def testNewFiles(self):
    expected = [('/root', 'package', 'ClassA.java'),
                ('/root', 'pakcage', 'ClassB.java')]

    line = 'void Method() throws ClassA, ClassB {'

    throws_parser = create_symlinks_to_third_party_java_files.ThrowsParser()
    throws_parser._matches = (
        create_symlinks_to_third_party_java_files.ThrowsParser.RE.search(line))

    mox_factory = mox.Mox()

    SyntaxParser = create_symlinks_to_third_party_java_files.SyntaxParser
    mox_factory.StubOutWithMock(SyntaxParser, '_ProcessRootPackageClassname')
    SyntaxParser._ProcessRootPackageClassname(
        '/root', 'package', 'ClassA').AndReturn(expected[0])
    SyntaxParser._ProcessRootPackageClassname(
        '/root', 'package', 'ClassB').AndReturn(expected[1])

    mox_factory.ReplayAll()

    observed = throws_parser.NewFiles('/root', 'package')

    mox_factory.VerifyAll()
    self.assertEqual(expected, observed)

    mox_factory.UnsetStubs()


class StaticParserTestCase(unittest.TestCase):
  def testMatch(self):
    static_parser = create_symlinks_to_third_party_java_files.StaticParser()

    observed = (
        static_parser.Matches('ClassA classA = ClassB.Method();'))

    self.assertTrue(observed)

  def testNoMatch(self):
    static_parser = create_symlinks_to_third_party_java_files.StaticParser()

    observed = static_parser.Matches('// no match')

    self.assertFalse(observed)

  def testNewFiles(self):
    expected = [('/root', 'package', 'ClassB.java')]

    line = 'ClassA classA = ClassB.Method();'

    static_parser = create_symlinks_to_third_party_java_files.StaticParser()
    static_parser._matches = (
        create_symlinks_to_third_party_java_files.StaticParser.RE.search(line))

    mox_factory = mox.Mox()

    SyntaxParser = create_symlinks_to_third_party_java_files.SyntaxParser
    mox_factory.StubOutWithMock(SyntaxParser, '_ProcessRootPackageClassname')
    SyntaxParser._ProcessRootPackageClassname(
        '/root', 'package', 'ClassB').AndReturn(expected[0])

    mox_factory.ReplayAll()

    observed = static_parser.NewFiles('/root', 'package')

    mox_factory.VerifyAll()
    self.assertEqual(expected, observed)

    mox_factory.UnsetStubs()


class LineProcessorTestCase(unittest.TestCase):
  def testFilterOutNone(self):
    expected = ['not None 0', 'not None 1']

    observed = (
        create_symlinks_to_third_party_java_files.LineProcessor._FilterOutNone(
            [None, 'not None 0', None, 'not None 1', None]))

    self.assertEqual(expected, observed)

  def testRegister(self):
    class ParserDummy(object):
      pass

    parser_dummy = ParserDummy()

    expected = [parser_dummy]

    line_processor = create_symlinks_to_third_party_java_files.LineProcessor()
    line_processor.Register(parser_dummy)

    observed = line_processor._parsers

    self.assertEquals(expected, observed)

  def testProcessWithMatch(self):
    expected = [('/root', 'package', 'Class.java')]

    mox_factory = mox.Mox()

    line = '// matches parser_mock_1'

    parser_mock_0 = mox_factory.CreateMock(
        create_symlinks_to_third_party_java_files.SyntaxParser)
    parser_mock_0.Matches(line).AndReturn(False)
    parser_mock_1 = mox_factory.CreateMock(
        create_symlinks_to_third_party_java_files.SyntaxParser)
    parser_mock_1.Matches(line).AndReturn(True)
    parser_mock_1.NewFiles('/root', 'package').AndReturn(expected)
    parser_mock_2 = mox_factory.CreateMock(
        create_symlinks_to_third_party_java_files.SyntaxParser)

    line_processor = create_symlinks_to_third_party_java_files.LineProcessor()
    line_processor._parsers = [parser_mock_0, parser_mock_1, parser_mock_2]

    mox_factory.ReplayAll()

    observed = line_processor.Process('/root', 'package', line)

    mox_factory.VerifyAll()
    self.assertEquals(expected, observed)

  def testProcessWithNoMatch(self):
    expected = []

    mox_factory = mox.Mox()

    line = '// no match'

    parser_mock_0 = mox_factory.CreateMock(
        create_symlinks_to_third_party_java_files.SyntaxParser)
    parser_mock_0.Matches(line).AndReturn(False)

    line_processor = create_symlinks_to_third_party_java_files.LineProcessor()
    line_processor._parsers = [parser_mock_0]

    mox_factory.ReplayAll()

    observed = line_processor.Process(None, None, line)

    mox_factory.VerifyAll()
    self.assertEquals(expected, observed)


class FileProcessorTestCase(unittest.TestCase):
  def testProcessLines(self):
    class FileProcessorSpy(
        create_symlinks_to_third_party_java_files.FileProcessor):
      def __init__(self, line_processor):
        super(FileProcessorSpy, self).__init__(line_processor)
        self._process_files_args = []

      def Process(self, files):
        self._process_files_args.append(files)

    expected = [[], [('/root', 'package', 'Class.java')]]

    line0 = '// no match'
    line1 = 'import package.Class;'
    lines = [line0, line1]

    mox_factory = mox.Mox()

    line_processor = mox_factory.CreateMock(
        create_symlinks_to_third_party_java_files.LineProcessor)
    line_processor.Process('/root', 'package', line0).AndReturn([])
    line_processor.Process('/root', 'package', line1).AndReturn(
        [('/root', 'package', 'Class.java')])

    file_processor_spy = FileProcessorSpy(line_processor)

    mox_factory.ReplayAll()

    file_processor_spy._ProcessLines('/root', 'package', lines)

    observed = file_processor_spy._process_files_args

    mox_factory.VerifyAll()
    self.assertEqual(expected, observed)

  def testProcess(self):
    class FileProcessorSpy(
        create_symlinks_to_third_party_java_files.FileProcessor):
      def __init__(self, line_processor):
        super(FileProcessorSpy, self).__init__(line_processor)
        self._process_lines_args = []

      def _ProcessLines(self, root, package, lines):
        self._process_lines_args.append((root, package, lines))

    class FileStub(object):
      def xreadlines(self):
        return ['// no match']

    expected = [('/root-0', 'package', ['// no match']),
                ('/root-1', 'package', ['// no match'])]

    file0 = ('/root-0', 'package', 'ClassA.java')
    file1 = ('/root-1', 'package', 'ClassB.java')
    files = [file0, file1]

    mox_factory = mox.Mox()

    builtins_mock = mox_factory.CreateMock(__builtins__)
    builtins_mock.file('/root-0/package/ClassA.java').AndReturn(FileStub())
    builtins_mock.file('/root-1/package/ClassB.java').AndReturn(FileStub())

    path_mock = mox_factory.CreateMock(os.path)
    path_mock.join(
        file0[0], file0[1], file0[2]).AndReturn('/root-0/package/ClassA.java')
    path_mock.join(
        file1[0], file1[1], file1[2]).AndReturn('/root-1/package/ClassB.java')

    file_processor_spy = FileProcessorSpy(None)

    mox_factory.ReplayAll()

    file_processor_spy.Process(
        files, file_creator=builtins_mock.file, path=path_mock)

    observed = file_processor_spy._process_lines_args

    mox_factory.VerifyAll()
    self.assertEqual(expected, observed)


if __name__ == '__main__':
  unittest.main()
