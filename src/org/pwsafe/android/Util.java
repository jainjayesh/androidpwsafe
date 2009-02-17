/*
 * Copyright (c) 2008 Noel Yap <noel.yap+code.google.com+com.pwsafe.android@gmail.com>.
 * All rights reserved. Use of the code is allowed under the
 * Artistic License 2.0 terms, as specified in the LICENSE file
 * distributed with this code, or available from
 * http://www.opensource.org/licenses/artistic-license-2.0.php
 */
package org.pwsafe.android;

import java.io.File;

import android.content.Context;

/**
 * Util contains utility functions.
 *
 * @author Noel Yap
 */
// TODO: Rename Util class to be more descriptive.
public class Util {
    public static final String DATABASE_FILEPATH_FIELD = "database-filepath";
    public static final String DATABASE_PASSPHRASE_FIELD = "database-passphrase";

    /**
     * Decodes database name.
     *
     * @param text  text to decode
     * @return Human readable database name.
     */
    public static String decode(String text) {
        int length = text.length();

        if (length % 2 == 1) {
            throw new NumberFormatException();
        }

        char[] result = new char[length/2];

        for (int i = 0; i != length; i += 2) {
            String hexAscii = text.substring(i, i + 2);
            result[i/2] = (char) Integer.parseInt(hexAscii, 16);
        }

        return new String(result);
    }

    /**
     * Encodes database name.
     *
     * @param text  text to encode
     * @return Hex ascii encoded database name.
     */
    public static String encode(String text) {
        int length = text.length();

        char[] result = new char[2*length];

        for (int i = 0, n = length; i != n; ++i) {
            String hexAscii = String.format("%02x", (byte) text.charAt(i));
            result[2*i] = hexAscii.charAt(0);
            result[2*i+1] = hexAscii.charAt(1);
        }

        return new String(result);
    }

    /**
     * Returns directory in which databases are stored.
     *
     * @param context  Context object that owns the directory
     * @return File object of the database directory
     */
    public static File getDatabaseDir(Context context) {
      return context.getDir("DATABASES", 0);
    }
}
