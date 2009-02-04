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
    private static final int DELETE_ID = Menu.FIRST;

    private RecordEditView mView;

    private EditText mRecordUrlText;
    private EditText mRecordPassphraseText;
    private EditText mRecordUsernameText;

    public RecordEditPresenter(RecordEditView view) {
        mView = view;
    }

    // TODO: Extract method.
    /**
     * Creates form or fields for record.
     */
    protected void onCreate(Bundle savedInstanceState) {
        mView.setContentView(R.layout.record_edit);

        mRecordPassphraseText = (EditText) mView.findViewById(R.id.record_passphrase);
        mRecordUrlText = (EditText) mView.findViewById(R.id.record_url);
        mRecordUsernameText = (EditText) mView.findViewById(R.id.record_username);

        String recordPassphrase = getStringField(savedInstanceState, Util.RECORD_PASSPHRASE_FIELD);
        if (recordPassphrase != null) {
            mRecordPassphraseText.setText(recordPassphrase);
        }

        String recordUrl = getStringField(savedInstanceState, Util.RECORD_URL_FIELD);
        if (recordUrl != null) {
            mRecordUrlText.setText(recordUrl);
        }

        String recordUsername = getStringField(savedInstanceState, Util.RECORD_USERNAME_FIELD);
        if (recordUsername != null) {
            mRecordUsernameText.setText(recordUsername);
        }

        Button saveButton = (Button) mView.findViewById(R.id.save);

        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();

                intent.putExtra(Util.RECORD_PASSPHRASE_FIELD, mRecordPassphraseText.getText().toString());
                intent.putExtra(Util.RECORD_URL_FIELD, mRecordUrlText.getText().toString());
                intent.putExtra(Util.RECORD_USERNAME_FIELD, mRecordUsernameText.getText().toString());

                mView.setResult(Activity.RESULT_OK, intent);
                mView.finish();
            }
        });
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

        intent.putExtra(Util.RECORD_PASSPHRASE_FIELD, (String) null);
        intent.putExtra(Util.RECORD_URL_FIELD, (String) null);
        intent.putExtra(Util.RECORD_USERNAME_FIELD, (String) null);

        mView.setResult(Activity.RESULT_OK, intent);
        mView.finish();
    }
}
