/*
 * Copyright (c) 2008 Noel Yap <noel.yap+code.google.com+com.pwsafe.android@gmail.com>.
 * All rights reserved. Use of the code is allowed under the
 * Artistic License 2.0 terms, as specified in the LICENSE file
 * distributed with this code, or available from
 * http://www.opensource.org/licenses/artistic-license-2.0.php
 */
package org.pwsafe.android;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

/**
 * PasswordSafePresenter presents a list of existing Password Safe databases.
 *
 * @author Noel Yap
 */
public class PasswordSafePresenter {
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
                LayoutInflater inflate =
                        (LayoutInflater) mView.getSystemService(
                                Context.LAYOUT_INFLATER_SERVICE);

                textView =
                        (TextView) inflate.inflate(mTextViewResourceId, null);
            }

            final String databaseName = getItem(position);

            textView.setOnClickListener(
                    new View.OnClickListener() {
                        public void onClick(View view) {
                            mDatabaseName = databaseName;

                            mView.showDialog(ACTIVITY_OPEN);
                        }
                    });
            textView.setOnLongClickListener(
                    new View.OnLongClickListener() {
                        public boolean onLongClick(View view) {
                            mDatabaseName = databaseName;

                            return false;
                        }
                    });
            textView.setText(databaseName);

            return textView;
        }
    }

    private static final int ACTIVITY_ABOUT = 0;
    private static final int ACTIVITY_CREATE = 1;
    private static final int ACTIVITY_OPEN = 2;
    private static final int ACTIVITY_DESTROY = 3;

    private static final int MENU_ITEM_ABOUT = Menu.FIRST;
    private static final int MENU_ITEM_DESTROY_DATABASE = Menu.FIRST+1;

    private static final String DATABASE_NAME = "database-name";

    private PasswordSafeView mView;

    private String mDatabaseName;
    private Map<Integer, DialogHelper> mDialogs = new HashMap<Integer, DialogHelper>();

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
    public void fillData() {
        mView.setContentView(R.layout.main);
        Button createDatabaseButton = (Button) mView.findViewById(R.id.create_database);

        createDatabaseButton.setOnClickListener(new View.OnClickListener() {
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

        ListView databaseList =
                (ListView) mView.findViewById(R.id.database_list);

        databaseList.setAdapter(
            new ArrayAdapterWithLongClick(
                mView,
                R.layout.list_row,
                decodedDatabases));
        databaseList.setOnCreateContextMenuListener(
            new View.OnCreateContextMenuListener() {
                public void onCreateContextMenu(
                        ContextMenu menu,
                        View v,
                        ContextMenu.ContextMenuInfo menuInfo) {
                    menu.add(
                        0,
                        MENU_ITEM_DESTROY_DATABASE,
                        0,
                        R.string.destroy_database);
                }
            });
        databaseList.setTextFilterEnabled(true);
    }

    /**
     * Shows the dialog for database destruction.
     */
    private void destroyDatabase() {
        mView.showDialog(ACTIVITY_DESTROY);
    }

    private DialogHelper getDialogHelper(Integer id) {
        DialogHelper result;

        if (!mDialogs.containsKey(id)) {
            switch (id) {
                case ACTIVITY_ABOUT: {
                    result = new AboutPasswordSafeDialogHelper(mView);

                    break;
                }

                case ACTIVITY_DESTROY: {
                    result =
                            new DestroyDatabaseDialogHelper(
                                    mView, this, mDatabaseName);

                    break;
                }

                case ACTIVITY_OPEN: {
                    result =
                            new OpenDatabaseDialogHelper(
                                    mView, this, mDatabaseName);

                    break;
                }

                default: {
                    result = null;
                }
            }

            mDialogs.put(id, result);
        } else {
            result = mDialogs.get(id);
        }

        return result;
    }

    /**
     * Pops up the correct dialog.
     */
    protected Dialog onCreateDialog(int id) {
        return getDialogHelper(new Integer(id)).onCreateDialog();
    }

    /**
     * Blanks out password before dialog is opened.
     */
    protected void onPrepareDialog(int id, Dialog dialog) {
        getDialogHelper(new Integer(id)).onPrepareDialog(dialog);
    }

    /**
     * Starts RecordList activity.
     *
     * @param databaseFilepath  filesystem path of database
     * @param databasePassphrase  passphrase to decrypt/encrypt database
     */
    public void openDatabase(
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
            case MENU_ITEM_DESTROY_DATABASE: {
                destroyDatabase();
                return true;
            }

            default: {
                return false;
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_ITEM_ABOUT, 0, R.string.about)
            .setIcon(android.R.drawable.ic_menu_info_details);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_ITEM_ABOUT: {
                mView.showDialog(ACTIVITY_ABOUT);

                return true;
            }

            default: {
                return false;
            }
        }
    }
}
