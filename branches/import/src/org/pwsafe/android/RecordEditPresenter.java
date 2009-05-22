/*
 * Copyright (c) 2008 Noel Yap <noel.yap+code.google.com+com.pwsafe.android@gmail.com>.
 * All rights reserved. Use of the code is allowed under the
 * Artistic License 2.0 terms, as specified in the LICENSE file
 * distributed with this code, or available from
 * http://www.opensource.org/licenses/artistic-license-2.0.php
 */
package org.pwsafe.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

/**
 * RecordEditPresenter presents a form to edit Password Safe records.
 *
 * @author Noel Yap
 */
public class RecordEditPresenter {
    private static final int SAVE_ID = Menu.FIRST;

    private RecordEditView mView;

    private EditText mRecordGroupText;
    private EditText mRecordNotesText;
    private EditText mRecordPassphraseText;
    private EditText mRecordTitleText;
    private EditText mRecordUrlText;
    private EditText mRecordUsernameText;

    public RecordEditPresenter(RecordEditView view) {
        mView = view;
    }

    private String safeGetStringField(Bundle savedInstanceState, String fieldName) {
        Bundle extras = mView.getIntent().getExtras();
        String result =
                BundleUtil.getStringField(
                        savedInstanceState, extras, fieldName);

        return (result == null)
                ? ""
                : result;
    }

    /**
     * Creates form or fields for record.
     */
    protected void onCreate(Bundle savedInstanceState) {
        mView.setContentView(R.layout.record_edit);

        mRecordGroupText =
                (EditText) mView.findViewById(R.id.record_group);
        mRecordGroupText.setText(
                safeGetStringField(
                        savedInstanceState, PwsRecordUtil.GROUP_FIELD));

        mRecordNotesText =
                (EditText) mView.findViewById(R.id.record_notes);
        mRecordNotesText.setText(
                safeGetStringField(
                        savedInstanceState, PwsRecordUtil.NOTES_FIELD));

        mRecordPassphraseText =
                (EditText) mView.findViewById(R.id.record_passphrase);
        mRecordPassphraseText.setText(
                safeGetStringField(
                        savedInstanceState, PwsRecordUtil.PASSPHRASE_FIELD));

        mRecordTitleText =
            (EditText) mView.findViewById(R.id.record_title);
        mRecordTitleText.setText(
                safeGetStringField(
                        savedInstanceState, PwsRecordUtil.TITLE_FIELD));

        mRecordUrlText =
                (EditText) mView.findViewById(R.id.record_url);
        mRecordUrlText.setText(safeGetStringField(
                    savedInstanceState, PwsRecordUtil.URL_FIELD));

        mRecordUsernameText =
                (EditText) mView.findViewById(R.id.record_username);
        mRecordUsernameText.setText(
                safeGetStringField(
                        savedInstanceState, PwsRecordUtil.USERNAME_FIELD));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, SAVE_ID, 0, R.string.save)
                .setIcon(android.R.drawable.ic_menu_save);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case SAVE_ID: {
                saveRecord();

                return true;
            }

            default: {
                return false;
            }
        }
    }

    /**
     * Saves record.
     */
    private void saveRecord() {
        Intent intent = new Intent();

        intent.putExtra(
                        PwsRecordUtil.GROUP_FIELD,
                        mRecordGroupText.getText().toString());
        intent.putExtra(
                        PwsRecordUtil.NOTES_FIELD,
                        mRecordNotesText.getText().toString());
        intent.putExtra(
                        PwsRecordUtil.PASSPHRASE_FIELD,
                        mRecordPassphraseText.getText().toString());
        intent.putExtra(
                        PwsRecordUtil.TITLE_FIELD,
                        mRecordTitleText.getText().toString());
        intent.putExtra(
                        PwsRecordUtil.URL_FIELD,
                        mRecordUrlText.getText().toString());
        intent.putExtra(
                        PwsRecordUtil.USERNAME_FIELD,
                        mRecordUsernameText.getText().toString());

        mView.setResult(Activity.RESULT_OK, intent);
        mView.finish();
    }
}
