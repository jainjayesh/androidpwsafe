/*
 * Copyright (c) 2008 Noel Yap <noel.yap+code.google.com+com.pwsafe.android@gmail.com>.
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
import java.util.Arrays;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

/**
 * PasswordSafePresenter presents a list of existing Password Safe databases.
 *
 * @author Noel Yap
 */
public class PasswordSafePresenter
    implements OnClickListener, OnCreateContextMenuListener, OnLongClickListener {
    // TODO: Extract out this class so it can be tested.
    /**
     * ArrayAdapterWithLongClick is an ArrayAdapter whose elements pop up a
     * dialog upon a long click.
     */
    private class ArrayAdapterWithLongClick extends ArrayAdapter<String> {
        private int mTextViewResourceId;

        public ArrayAdapterWithLongClick(Context context, int textViewResourceId, String[] objects) {
            super(context, textViewResourceId, objects);

            mTextViewResourceId = textViewResourceId;
        }

        // FIXME: Handle trackball clicks.
        /**
         * Sets listeners on ArrayAdapter elements.
         *
         * @param position  index in the list
         * @param convertView  the list element view
         * @param parent the list view
         * @return  the list element view with listeners
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ListView listView = (ListView) parent;
            TextView textView = (TextView) convertView;

            if (textView == null) {
                LayoutInflater inflate = (LayoutInflater) mView.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                textView = (TextView) inflate.inflate(mTextViewResourceId, null);
            }

            listView.setOnCreateContextMenuListener(mView);
            textView.setOnLongClickListener(mView);
            textView.setOnClickListener(mView);
            textView.setText(getItem(position));

            return textView;
        }
    }

    private static final int ACTIVITY_CREATE = 0;
    private static final int ACTIVITY_OPEN = 1;
    private static final int ACTIVITY_DESTROY = 2;

    private static final int MENU_ITEM_DELETE_ITEM = Menu.FIRST;

    private static final String DATABASE_NAME = "database-name";

    private PasswordSafeView mView;

    private String mDatabaseName;

    public PasswordSafePresenter(PasswordSafeView view) {
        mView = view;
    }

    public void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mDatabaseName = savedInstanceState.getString(DATABASE_NAME);
        }

        fillData();
    }

    /**
     * Saves internal state.
     */
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(DATABASE_NAME, mDatabaseName);
    }

    /**
     * Fills the list of database names.
     */
    private void fillData() {
        mView.setContentView(R.layout.main);
        Button addDatabaseButton = (Button) mView.findViewById(R.id.add_database);

        addDatabaseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(mView, DatabaseCreateView.class);
                mView.startActivityForResult(intent, ACTIVITY_CREATE);
            }
        });

        File dataDir = Util.getDatabaseDir(mView);
        String[] encodedDatabases = dataDir.list();
        String[] decodedDatabases = new String[encodedDatabases.length];

        for (int i = 0; i != encodedDatabases.length; ++i) {
            try {
                decodedDatabases[i] = Util.decode(encodedDatabases[i]);
            } catch (NumberFormatException e) {
                File corruptDatabase = new File(dataDir, encodedDatabases[i]);

                corruptDatabase.delete();
                fillData();
                return;
            }
        }

        Arrays.sort(decodedDatabases);

        ListView databaseList = (ListView) mView.findViewById(R.id.database_list);

        databaseList.setAdapter(
            new ArrayAdapterWithLongClick(
                mView,
                R.layout.list_row,
                decodedDatabases));
        databaseList.setTextFilterEnabled(true);
    }

    /**
     * Starts the activity for database creation.
     */
    private void createDatabase() {
        Intent intent = new Intent(mView, DatabaseCreateView.class);
        mView.startActivityForResult(intent, ACTIVITY_CREATE);
    }

    /**
     * Shows the dialog for database destruction.
     */
    private void destroyDatabase() {
        mView.showDialog(ACTIVITY_DESTROY);
    }

    /**
     * Pops up the correct dialog.
     */
    protected Dialog onCreateDialog(int id) {
        LayoutInflater factory = LayoutInflater.from(mView);

        final File database = (
                new File(
                    Util.getDatabaseDir(mView),
                    Util.encode(mDatabaseName)));
        final View textEntryView = (
                factory.inflate(
                        R.layout.passphrase_entry, null));

        DialogInterface.OnClickListener onClickListener;

        switch (id) {
            // TODO: Extract method.
            case ACTIVITY_DESTROY: {
                onClickListener =
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            EditText editText = (EditText) textEntryView.findViewById(R.id.database_passphrase);
                            String passphrase = editText.getText().toString();

                            try {
                                PwsFileFactory.loadFile(database.getAbsolutePath(), passphrase);
                                database.delete();
                                fillData();
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

                break;
            }

            // TODO: Extract method.
            case ACTIVITY_OPEN: {
                onClickListener =
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            EditText editText = (EditText) textEntryView.findViewById(R.id.database_passphrase);
                            String passphrase = editText.getText().toString();

                            openDatabase(database.getAbsolutePath(), passphrase);
                        }
                    };

                break;
            }

            default: {
                return null;
            }
        }

        return new AlertDialog.Builder(mView)
            .setView(textEntryView)
            .setPositiveButton(R.string.confirm, onClickListener)
            .create();
    }

    /**
     * Blanks out password before dialog is opened.
     */
    protected void onPrepareDialog(int id, Dialog dialog) {
        EditText editText = (EditText) dialog.findViewById(
            R.id.database_passphrase);

        editText.setText("");
    }

    /**
     * Starts RecordList activity.
     *
     * @param databaseFilepath  filesystem path of database
     * @param databasePassphrase  passphrase to decrypt/encrypt database
     */
    private void openDatabase(
        String databaseFilepath, String databasePassphrase) {
        Intent intent = new Intent(mView, RecordListView.class);

        intent.putExtra(Util.DATABASE_FILEPATH_FIELD, databaseFilepath);
        intent.putExtra(Util.DATABASE_PASSPHRASE_FIELD, databasePassphrase);

        mView.startActivityForResult(intent, ACTIVITY_OPEN);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        fillData();
    }

    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_ITEM_DELETE_ITEM: {
                destroyDatabase();
                return true;
            }

            default: {
                return false;
            }
        }
    }

    public void onClick(View v) {
        TextView textView = (TextView) v;

        mDatabaseName = textView.getText().toString();

        mView.showDialog(ACTIVITY_OPEN);
    }

    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenuInfo menuInfo) {
        menu.add(0, MENU_ITEM_DELETE_ITEM, 0, R.string.menu_delete);
    }

    public boolean onLongClick(View v) {
        TextView textView = (TextView) v;

        mDatabaseName = textView.getText().toString();

        return false;
    }
}
