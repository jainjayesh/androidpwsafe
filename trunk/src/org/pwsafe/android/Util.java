/*
 * Copyright (c) 2008 Noel Yap <noel.yap+code.google.com+com.pwsafe.android@gmail.com>.
 * All rights reserved. Use of the code is allowed under the
 * Artistic License 2.0 terms, as specified in the LICENSE file
 * distributed with this code, or available from
 * http://www.opensource.org/licenses/artistic-license-2.0.php
 */
package org.pwsafe.android;

import java.io.File;

import android.app.Activity;

/**
 * Util contains utility functions.
 *
 * @author Noel Yap
 */
// TODO: Rename Util class to be more descriptive.
public class Util {
    public static final String DATABASE_FILEPATH_FIELD = "database-filepath";
    public static final String DATABASE_PASSPHRASE_FIELD = "database-passphrase";
    public static final String RECORD_PASSPHRASE_FIELD = "record-passphrase";
    public static final String RECORD_URL_FIELD = "record-url";
    public static final String RECORD_USERNAME_FIELD = "record-username";

    // TODO: Write unit tests for this.
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

        byte[] textInByte = new byte[length/2];

        for (int i = 0; i != text.length(); i += 2) {
            String hex_ascii = text.substring(i, i + 2);
            textInByte[i/2] = Byte.parseByte(hex_ascii, 16);
        }

        return new String(textInByte);
    }

    // TODO: Write unit tests for this.
    /**
     * Encodes database name.
     *
     * @param text  text to encode
     * @return Hex ascii encoded database name.
     */
    public static String encode(String text) {
        StringBuffer result = new StringBuffer();

        byte[] bytes = text.getBytes();

        for (int i = 0, n = bytes.length; i != n; ++i) {
            byte b = bytes[i];

            if (b < 0x10) {
                result.append("0");
            }

            result.append(Integer.toHexString(bytes[i]));
        }

        return result.toString();
    }

    /**
     * Returns directory in which databases are stored.
     *
     * @param activity  Activity object that owns the directory
     * @return File object of the database directory
     */
    public static File getDatabaseDir(Activity activity) {
      return activity.getDir("DATABASES", 0);
    }
}
