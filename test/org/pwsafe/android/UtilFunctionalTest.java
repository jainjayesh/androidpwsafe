/*
 * Copyright (c) 2009 Noel Yap <noel.yap+code.google.com+com.pwsafe.android@gmail.com>.
 * All rights reserved. Use of the code is allowed under the
 * Artistic License 2.0 terms, as specified in the LICENSE file
 * distributed with this code, or available from
 * http://www.opensource.org/licenses/artistic-license-2.0.php
 */
package org.pwsafe.android;

import junit.framework.Assert;
import org.junit.Test;

public class UtilFunctionalTest {
    @Test
    public void testDecodeEncode() {
        String expected = TestUtil.createAnonymousText();

        String observed = Util.decode(Util.encode(expected));

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testEncodeDecode() {
        String expected = TestUtil.createAnonymousHexString();

        String observed = Util.encode(Util.decode(expected));

        Assert.assertEquals(expected, observed);
    }
}
