/*
 * Copyright (c) 2009 Noel Yap <noel.yap+code.google.com+com.pwsafe.android@gmail.com>.
 * All rights reserved. Use of the code is allowed under the
 * Artistic License 2.0 terms, as specified in the LICENSE file
 * distributed with this code, or available from
 * http://www.opensource.org/licenses/artistic-license-2.0.php
 */
package org.pwsafe.android;

import edu.cornell.lassp.houle.RngPack.RandomElement;
import edu.cornell.lassp.houle.RngPack.Ranmar;
import edu.cornell.lassp.houle.RngPack.RanMT;

public class TestUtil {
    private static RandomElement mCharacterPrng = new Ranmar();
    private static RandomElement mLengthPrng = new RanMT();

    public static String createAnonymousHexString() {
        int length = 2*mLengthPrng.choose(256);

        char[] result = new char[length];

        for (int i = 0; i != length; ++i) {
            int hex = mCharacterPrng.choose(16)-1;

            if (hex < 10) {
                result[i] = (char) ('0' + hex);
            } else {
                result[i] = (char) ('a' + (hex - 10));
            }
        }

        return new String(result);
    }

    public static String createAnonymousText() {
        int length = mLengthPrng.choose(256);

        char[] result = new char[length];

        for (int i = 0; i != length; ++i) {
            result[i] = (char) (mCharacterPrng.choose(256)-1);
        }

        return new String(result);
    }
}
