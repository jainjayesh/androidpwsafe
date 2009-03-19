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

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class BundleUtilUnitTest {
    @Test
    public void testGetStringFieldFromSavedInstanceState() {
        String expected = TestUtil.createAnonymousText();

        String fieldName = TestUtil.createAnonymousText();

        Bundle savedInstanceState = EasyMock.createMock(Bundle.class);
        EasyMock.expect(savedInstanceState.getString(fieldName))
                .andReturn(expected);
        EasyMock.replay(savedInstanceState);

        String observed =
                BundleUtil.getStringField(savedInstanceState, null, fieldName);

        Assert.assertEquals(expected, observed);
        EasyMock.verify(savedInstanceState);
    }

    @Test
    public void testGetStringFieldFromNonNullExtras() {
        String expected = TestUtil.createAnonymousText();

        String fieldName = TestUtil.createAnonymousText();

        Bundle extras = EasyMock.createMock(Bundle.class);
        EasyMock.expect(extras.getString(fieldName))
                .andReturn(expected);
        EasyMock.replay(extras);

        String observed =
                BundleUtil.getStringField(null, extras, fieldName);

        Assert.assertEquals(expected, observed);
        EasyMock.verify(extras);
    }

    @Test
    public void testGetStringFieldFromNullExtras() {
        String fieldName = TestUtil.createAnonymousText();

        String observed =
                BundleUtil.getStringField(null, null, fieldName);

        Assert.assertNull(observed);
    }
}
