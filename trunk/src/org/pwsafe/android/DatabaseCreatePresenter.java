/*
 * Copyright (c) 2008 Noel Yap <noel.yap+code.google.com+com.pwsafe.android@gmail.com>.
 * All rights reserved. Use of the code is allowed under the
 * Artistic License 2.0 terms, as specified in the LICENSE file
 * distributed with this code, or available from
 * http://www.opensource.org/licenses/artistic-license-2.0.php
 */
package org.pwsafe.android;

import org.pwsafe.lib.file.PwsFile;
import org.pwsafe.lib.file.PwsFileFactory;
import org.pwsafe.lib.file.PwsFileStorage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * DatabaseCreatePresenter presents a form to create a new Password Safe
 * database.
 *
 * @author Noel Yap
 */
public class DatabaseCreatePresenter {
    private DatabaseCreateView mView;

    private EditText mDatabaseNameText;
    private EditText mDatabasePassphraseText;

    public DatabaseCreatePresenter(DatabaseCreateView view) {
        mView = view;
    }

    /**
     * Creates form for fields for new database.
     */
    protected void onCreate(Bundle savedInstanceState) {
        mView.setContentView(R.layout.database_create);

        mDatabaseNameText = (EditText) mView.findViewById(R.id.database_name);
        mDatabasePassphraseText = (EditText) mView.findViewById(R.id.database_passphrase);

        Button saveButton = (Button) mView.findViewById(R.id.save);

        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mView.setResult(Activity.RESULT_OK);
                mView.finish();
            }
        });
    }

    // TODO: Should onPause() really create a new database?  Or should it just
    //       save the current field values?
    protected void onPause() {
        saveState();
    }

    /**
     * Creates a new database.
     */
    private void saveState() {
        try {
            String databaseFilename =
                    DatabaseUtil.encode(mDatabaseNameText.getText().toString());
            String databasePassphrase =
                    mDatabasePassphraseText.getText().toString();

            File database = new File(DatabaseUtil.getDatabaseDir(mView), databaseFilename);
            if (!database.exists()) {
                PwsFile pwsFile = PwsFileFactory.newFile();

                pwsFile.setStorage(
		new PwsFileStorage(database.getAbsolutePath()));
                pwsFile.setPassphrase(databasePassphrase);

                pwsFile.save();
            } else {
                // TODO: Present error dialog
            }
        } catch (FileNotFoundException e) {
            // TODO: Present error dialog.
            e.printStackTrace();
            throw(new RuntimeException(e));
        } catch (IOException e) {
            // TODO: Present error dialog.
            e.printStackTrace();
            throw(new RuntimeException(e));
        } catch (NoSuchAlgorithmException e) {
            // TODO: Present error dialog.
            e.printStackTrace();
            throw(new RuntimeException(e));
        }
    }
}
