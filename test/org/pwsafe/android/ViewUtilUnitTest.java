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
import android.view.LayoutInflater;
import android.widget.TextView;

public class ViewUtilUnitTest {
    @Test
    public void testGetTextViewWithNonNullTextView() {
        TextView expected = EasyMock.createMock(TextView.class);
        EasyMock.replay(expected);

        TextView observed = ViewUtil.getTextView(expected, null, 0);

        Assert.assertEquals(expected, observed);
        EasyMock.verify(expected);
    }

    @Test
    public void testGetTextViewWithNullTextView() {
        TextView expected = EasyMock.createMock(TextView.class);
        EasyMock.replay(expected);

        int resourceId = TestUtil.createAnonymousInt();

        LayoutInflater layoutInflater =
                EasyMock.createMock(LayoutInflater.class);
        EasyMock.expect(layoutInflater.inflate(resourceId, null))
                .andReturn(expected);
        EasyMock.replay(layoutInflater);

        Activity activity = EasyMock.createMock(Activity.class);
        EasyMock.expect(
                activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .andReturn(layoutInflater);
        EasyMock.replay(activity);

        TextView observed = ViewUtil.getTextView(null, activity, resourceId);

        Assert.assertEquals(expected, observed);
        EasyMock.verify(activity);
        EasyMock.verify(layoutInflater);
        EasyMock.verify(expected);
    }
}
