/*
 * Copyright (c) 2009 Noel Yap <noel.yap+code.google.com+com.pwsafe.android@gmail.com>.
 * All rights reserved. Use of the code is allowed under the
 * Artistic License 2.0 terms, as specified in the LICENSE file
 * distributed with this code, or available from
 * http://www.opensource.org/licenses/artistic-license-2.0.php
 */
package org.pwsafe.android;

import org.pwsafe.lib.file.PwsField;
import org.pwsafe.lib.file.PwsStringUnicodeField;

public class PwsFieldUtil {
    public static String convertFieldToString(PwsField pwsField) {
        return (pwsField == null)
                ? ""
                : (String) pwsField.getValue();
    }

    public static PwsField convertStringToField(int type, String value) {
        return (value.compareTo("") == 0)
                ? null
                : new PwsStringUnicodeField(type, value);
    }
}
