/*
 * Copyright (c) 2009 Noel Yap <noel.yap+code.google.com+com.pwsafe.android@gmail.com>.
 * All rights reserved. Use of the code is allowed under the
 * Artistic License 2.0 terms, as specified in the LICENSE file
 * distributed with this code, or available from
 * http://www.opensource.org/licenses/artistic-license-2.0.php
 */
package org.pwsafe.android;

import org.pwsafe.lib.exception.EndOfFileException;
import org.pwsafe.lib.exception.InvalidPassphraseException;
import org.pwsafe.lib.exception.UnsupportedFileVersionException;
import org.pwsafe.lib.file.PwsFileFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class DestroyDatabaseDialogHelper extends DialogHelper {
    private PasswordSafePresenter mPresenter;

    public DestroyDatabaseDialogHelper(Activity activity, PasswordSafePresenter presenter) {
        super(activity);

        mPresenter = presenter;
    }

    @Override
    public Dialog onCreateDialog() {
        LayoutInflater factory = LayoutInflater.from(GetActivity());

        final View textEntryView =
                factory.inflate(
                        R.layout.passphrase_entry, null);

        DialogInterface.OnClickListener onClickListener =
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        EditText editText = (EditText) textEntryView.findViewById(R.id.database_passphrase);
                        String passphrase = editText.getText().toString();
                        
                        File database = 
                        	    new File(
                        	    		Util.getDatabaseDir(GetActivity()),
                        	    		Util.encode(mPresenter.getDatabaseName()));

                        try {
                            PwsFileFactory.loadFile(database.getAbsolutePath(), passphrase);
                            database.delete();
                            mPresenter.fillData();
                        } catch (FileNotFoundException e) {
                            // TODO: Present error dialog.
                            e.printStackTrace();
                        } catch (NoSuchAlgorithmException e) {
                            // TODO: Present error dialog.
                            e.printStackTrace();
                        } catch (EndOfFileException e) {
                            // TODO: Present error dialog.
                            e.printStackTrace();
                        } catch (InvalidPassphraseException e) {
                            // TODO: Present error dialog.
                            e.printStackTrace();
                        } catch (IOException e) {
                            // TODO: Present error dialog.
                            e.printStackTrace();
                        } catch (UnsupportedFileVersionException e) {
                            // TODO: Present error dialog.
                            e.printStackTrace();
                        }
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
