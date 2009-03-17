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
import android.view.View;

public class PwsRecordUtilUnitTest {
    @Test
    public void testGetDisplayStringFromTitle() {
        String title = TestUtil.createAnonymousText();
        String expected = title;

        PwsRecordWrapper pwsRecord = EasyMock.createMock(PwsRecordWrapper.class);
        EasyMock.expect(pwsRecord.getTitle())
                .andReturn(title);
        EasyMock.expect(pwsRecord.getGroup())
                .andReturn("");
        EasyMock.replay(pwsRecord);

        String observed = PwsRecordUtil.getDisplayString(pwsRecord);

        Assert.assertEquals(expected, observed);
        EasyMock.verify(pwsRecord);
    }

    @Test
    public void testGetDisplayStringFromTitleAndGroup() {
        String group = TestUtil.createAnonymousText();
        String title = TestUtil.createAnonymousText();
        String expected = group + "|" + title;

        PwsRecordWrapper pwsRecord = EasyMock.createMock(PwsRecordWrapper.class);
        EasyMock.expect(pwsRecord.getTitle())
                .andReturn(title);
        EasyMock.expect(pwsRecord.getGroup())
                .andReturn(group);
        EasyMock.replay(pwsRecord);

        String observed = PwsRecordUtil.getDisplayString(pwsRecord);

        Assert.assertEquals(expected, observed);
        EasyMock.verify(pwsRecord);
    }

    @Test
    public void testGetDisplayStringFromUrl() {
        String url = TestUtil.createAnonymousText();
        String expected = url;

        PwsRecordWrapper pwsRecord = EasyMock.createMock(PwsRecordWrapper.class);
        EasyMock.expect(pwsRecord.getTitle())
                .andReturn("");
        EasyMock.expect(pwsRecord.getUrl())
                .andReturn(url);
        EasyMock.replay(pwsRecord);

        String observed = PwsRecordUtil.getDisplayString(pwsRecord);

        Assert.assertEquals(expected, observed);
        EasyMock.verify(pwsRecord);
    }
}
