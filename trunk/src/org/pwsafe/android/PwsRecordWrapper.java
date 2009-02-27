/*
 * Copyright (c) 2009 Noel Yap <noel.yap+code.google.com+com.pwsafe.android@gmail.com>.
 * All rights reserved. Use of the code is allowed under the
 * Artistic License 2.0 terms, as specified in the LICENSE file
 * distributed with this code, or available from
 * http://www.opensource.org/licenses/artistic-license-2.0.php
 */
package org.pwsafe.android;

import org.pwsafe.lib.exception.PasswordSafeException;
import org.pwsafe.lib.file.PwsField;
import org.pwsafe.lib.file.PwsFile;
import org.pwsafe.lib.file.PwsRecordV3;
import org.pwsafe.lib.file.PwsStringUnicodeField;

public class PwsRecordWrapper {
    private PwsFile mPwsFile;
    private PwsRecordV3 mPwsRecord;

    public PwsRecordWrapper(PwsFile pwsFile, PwsRecordV3 pwsRecord) {
        mPwsFile = pwsFile;
        mPwsRecord = pwsRecord;
    }

    public void add() {
        try {
            mPwsFile.add(mPwsRecord);
        } catch (PasswordSafeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void delete() {
        mPwsRecord.delete();
    }

    public String getGroup() {
        return PwsFieldUtil.convertFieldToString(
                mPwsRecord.getField(PwsRecordV3.GROUP));
    }

    public void setGroup(String group) {
        mPwsRecord.setField(
                PwsFieldUtil.convertStringToField(PwsRecordV3.GROUP, group));
    }

    public String getNotes() {
        return PwsFieldUtil.convertFieldToString(
                mPwsRecord.getField(PwsRecordV3.NOTES));
    }

    public void setNotes(String notes) {
        mPwsRecord.setField(
                PwsFieldUtil.convertStringToField(PwsRecordV3.NOTES, notes));
    }

    public String getPassword() {
        return PwsFieldUtil.convertFieldToString(
                mPwsRecord.getField(PwsRecordV3.PASSWORD));
    }

    public void setPassword(String password) {
        mPwsRecord.setField(
                PwsFieldUtil.convertStringToField(
                        PwsRecordV3.PASSWORD, password));
    }

    public String getTitle() {
        return PwsFieldUtil.convertFieldToString(
                mPwsRecord.getField(PwsRecordV3.TITLE));
    }

    public void setTitle(String title) {
        mPwsRecord.setField(
                PwsFieldUtil.convertStringToField(PwsRecordV3.TITLE, title));
    }

    public String getUrl() {
        return PwsFieldUtil.convertFieldToString(
                mPwsRecord.getField(PwsRecordV3.URL));
    }

    public void setUrl(String url) {
        mPwsRecord.setField(
                PwsFieldUtil.convertStringToField(PwsRecordV3.URL, url));
    }

    public String getUsername() {
        return PwsFieldUtil.convertFieldToString(
                mPwsRecord.getField(PwsRecordV3.USERNAME));
    }

    public void setUsername(String username) {
        mPwsRecord.setField(
                PwsFieldUtil.convertStringToField(
                        PwsRecordV3.USERNAME, username));
    }
}
