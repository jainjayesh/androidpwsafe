/*
 * Copyright (c) 2009 Noel Yap <noel.yap+code.google.com+com.pwsafe.android@gmail.com>.
 * All rights reserved. Use of the code is allowed under the
 * Artistic License 2.0 terms, as specified in the LICENSE file
 * distributed with this code, or available from
 * http://www.opensource.org/licenses/artistic-license-2.0.php
 */
package org.pwsafe.android;

/**
 * RecordUtil contains utility functions for record handling.
 *
 * @author Noel Yap
 */
public class PwsRecordUtil {
    public static final String GROUP_FIELD = "record-group";
    public static final String NOTES_FIELD = "record-notes";
    public static final String PASSPHRASE_FIELD = "record-passphrase";
    public static final String TITLE_FIELD = "record-title";
    public static final String URL_FIELD = "record-url";
    public static final String USERNAME_FIELD = "record-username";

    public static String getDisplayString(PwsRecordWrapper pwsRecord) {
        String title = pwsRecord.getTitle();

        if ("".compareTo(title) == 0) {
            return pwsRecord.getUrl();
        } else {
            String group = pwsRecord.getGroup();

            if ("".compareTo(group) == 0) {
                return title;
            } else {
                StringBuffer result = new StringBuffer(group);

                result.append("|");
                result.append(title);

                return result.toString();
            }
        }
    }
}
