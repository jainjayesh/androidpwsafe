/*
 * Copyright (c) 2009 Noel Yap <noel.yap+code.google.com+com.pwsafe.android@gmail.com>.
 * All rights reserved. Use of the code is allowed under the
 * Artistic License 2.0 terms, as specified in the LICENSE file
 * distributed with this code, or available from
 * http://www.opensource.org/licenses/artistic-license-2.0.php
 */
package org.pwsafe.android;

import java.io.File;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class OpenDatabaseDialogHelper extends DialogHelper {
    private PasswordSafePresenter mPresenter;

    public OpenDatabaseDialogHelper(Activity activity, PasswordSafePresenter presenter) {
        super(activity);

        mPresenter = presenter;
    }

    @Override
    public Dialog onCreateDialog() {
        LayoutInflater factory = LayoutInflater.from(GetActivity());

        final View textEntryView = (
                factory.inflate(
                        R.layout.passphrase_entry, null));

        DialogInterface.OnClickListener onClickListener =
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        EditText editText = (EditText) textEntryView.findViewById(R.id.database_passphrase);
                        String passphrase = editText.getText().toString();
                        
                        File database =
                        	new File(
                        			Util.getDatabaseDir(GetActivity()),
                        			Util.encode(mPresenter.getDatabaseName()));

                        mPresenter.openDatabase(database.getAbsolutePath(), passphrase);
                    }
                };

        return new AlertDialog.Builder(GetActivity())
            .setView(textEntryView)
            .setPositiveButton(R.string.confirm, onClickListener)
            .create();
    }

    @Override
    public void onPrepareDialog(Dialog dialog) {
        EditText editText =
                (EditText) dialog.findViewById(R.id.database_passphrase);

        editText.setText("");
    }
}
