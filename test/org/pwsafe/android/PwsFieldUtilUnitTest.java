/*
 * Copyright (c) 2009 Noel Yap <noel.yap+code.google.com+com.pwsafe.android@gmail.com>.
 * All rights reserved. Use of the code is allowed under the
 * Artistic License 2.0 terms, as specified in the LICENSE file
 * distributed with this code, or available from
 * http://www.opensource.org/licenses/artistic-license-2.0.php
 */
package org.pwsafe.android;

import junit.framework.Assert;
import org.easymock.classextension.EasyMock;
import org.junit.Test;
import org.pwsafe.lib.file.PwsField;

import android.content.Context;

class PwsFieldSubclass extends PwsField {
    public PwsFieldSubclass(int type, String value) {
        super(type, value);
    }

    public byte[] getBytes() {
        throw new UnsupportedOperationException();
    }

    public int compareTo(Object rhs) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object rhs) {
        return getType() == ((PwsField) rhs).getType()
            &&  getValue().equals(((PwsField) rhs).getValue());
    }
}

public class PwsFieldUtilUnitTest {
    @Test
    public void testConvertFieldToStringWhenPwsFieldIsNull() {
        String expected = "";

        String observed = PwsFieldUtil.convertFieldToString(null);

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testConvertFieldToStringWhenPwsFieldIsNotNull() {
        String expected = TestUtil.createAnonymousText();

        String observed = PwsFieldUtil.convertFieldToString(
                new PwsFieldSubclass(0, expected));

        Assert.assertEquals(expected, observed);
    }

    @Test
    public void testConvertStringToField() {
        String value = "aoeu"; //TestUtil.createAnonymousText();
        PwsField expected = new PwsFieldSubclass(0, value);

        PwsField observed = PwsFieldUtil.convertStringToField(0, value);

        Assert.assertEquals(expected, observed);
    }
}
