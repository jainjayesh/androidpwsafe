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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * RecordEditPresenter presents a form to edit Password Safe records.
 *
 * @author Noel Yap
 */
public class RecordEditPresenter {
    private static final int SAVE_ID = Menu.FIRST;
    private static final int DELETE_ID = Menu.FIRST+1;

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
        String result = getStringField(savedInstanceState, fieldName);

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
        mRecordGroupText.setText(safeGetStringField(savedInstanceState, RecordUtil.GROUP_FIELD));

        mRecordNotesText =
                (EditText) mView.findViewById(R.id.record_notes);
        mRecordNotesText.setText(safeGetStringField(savedInstanceState, RecordUtil.NOTES_FIELD));

        mRecordPassphraseText =
                (EditText) mView.findViewById(R.id.record_passphrase);
        mRecordPassphraseText.setText(
                safeGetStringField(
                        savedInstanceState, RecordUtil.PASSPHRASE_FIELD));

        mRecordTitleText =
            (EditText) mView.findViewById(R.id.record_title);
        mRecordTitleText.setText(
                safeGetStringField(savedInstanceState, RecordUtil.TITLE_FIELD));

        mRecordUrlText =
                (EditText) mView.findViewById(R.id.record_url);
        mRecordUrlText.setText(safeGetStringField(
                    savedInstanceState, RecordUtil.URL_FIELD));

        mRecordUsernameText =
                (EditText) mView.findViewById(R.id.record_username);
        mRecordUsernameText.setText(
                safeGetStringField(
                        savedInstanceState, RecordUtil.USERNAME_FIELD));
    }

    // TODO: Extract method so it can be reused.
    /**
     * Retrieves saved field value.
     *
     * @param savedInstanceState  holds stored fields
     * @param fieldName  name of field to retrieve
     * @return  value of field
     */
    private String getStringField(Bundle savedInstanceState, String fieldName) {
        String result = (savedInstanceState != null
                ? savedInstanceState.getString(fieldName)
                : null);

        if (result == null) {
            Bundle extras = mView.getIntent().getExtras();

            result = (extras != null
                    ? extras.getString(fieldName)
                    : null);
        }

        if (result == null) {
            // TODO: Popup error dialog.
        }

        return result;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, SAVE_ID, 0, R.string.save)
                .setIcon(android.R.drawable.ic_menu_save);
        menu.add(0, DELETE_ID, 0, R.string.delete_record)
                .setIcon(android.R.drawable.ic_menu_delete);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case DELETE_ID: {
                deleteRecord();

                return true;
            }
                
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
     * Deletes record.
     */
    private void deleteRecord() {
        Intent intent = new Intent();

        intent.putExtra("activity", RecordListPresenter.ACTIVITY_DELETE);

        mView.setResult(Activity.RESULT_OK, intent);
        mView.finish();
    }
    
    /**
     * Saves record.
     */
    private void saveRecord() {
        Intent intent = new Intent();
        
        intent.putExtra(
                        "activity",
                        RecordListPresenter.ACTIVITY_MODIFY);
        intent.putExtra(
                        RecordUtil.GROUP_FIELD,
                        mRecordGroupText.getText().toString());
        intent.putExtra(
                        RecordUtil.NOTES_FIELD,
                        mRecordNotesText.getText().toString());
        intent.putExtra(
                        RecordUtil.PASSPHRASE_FIELD,
                        mRecordPassphraseText.getText().toString());
        intent.putExtra(
                        RecordUtil.TITLE_FIELD,
                        mRecordTitleText.getText().toString());
        intent.putExtra(
                        RecordUtil.URL_FIELD,
                        mRecordUrlText.getText().toString());
        intent.putExtra(
                        RecordUtil.USERNAME_FIELD,
                        mRecordUsernameText.getText().toString());
        
        mView.setResult(Activity.RESULT_OK, intent);
        mView.finish();
    }
}
