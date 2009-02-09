/*
 * Copyright (c) 2009 Noel Yap <noel.yap+code.google.com+com.pwsafe.android@gmail.com>.
 * All rights reserved. Use of the code is allowed under the
 * Artistic License 2.0 terms, as specified in the LICENSE file
 * distributed with this code, or available from
 * http://www.opensource.org/licenses/artistic-license-2.0.php
 */
package org.pwsafe.android;

import org.pwsafe.lib.file.PwsRecord;
import org.pwsafe.lib.file.PwsRecordV3;
import org.pwsafe.lib.file.PwsStringUnicodeField;

/**
 * RecordEditView delegates to {@link RecordEditPresenter}.
 *
 * @author Noel Yap
 */
public class RecordUtil {
    public static final String PASSPHRASE_FIELD = "record-passphrase";
    public static final String URL_FIELD = "record-url";
    public static final String USERNAME_FIELD = "record-username";

    private PwsRecord mPwsRecord;
    
    private String mPassphrase;
    private String mUrl;
    private String mUsername;
	
    public RecordUtil(PwsRecord pwsRecord) {
        mPwsRecord = pwsRecord;
    }
    
    public RecordUtil(
            PwsRecord pwsRecord,
            String passphrase,
            String url,
            String username) {
        this(pwsRecord);
        mPassphrase = passphrase;
        mUrl = url;
        mUsername = username;
    }

    public void setFields() {
    	mPwsRecord.setField(new PwsStringUnicodeField(PwsRecordV3.PASSWORD, mPassphrase));
    	mPwsRecord.setField(new PwsStringUnicodeField(PwsRecordV3.URL, mUrl));
    	mPwsRecord.setField(new PwsStringUnicodeField(PwsRecordV3.USERNAME, mUsername));
    }

    public PwsRecord getPwsRecord() {
        return mPwsRecord;
    }

    public String getUrl() {
        return mUrl;
    }
}
