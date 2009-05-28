/*
 * Copyright (c) 2008 Noel Yap <noel.yap+code.google.com+com.pwsafe.android@gmail.com>.
 * All rights reserved. Use of the code is allowed under the
 * Artistic License 2.0 terms, as specified in the LICENSE file
 * distributed with this code, or available from
 * http://www.opensource.org/licenses/artistic-license-2.0.php
 */
package org.pwsafe.android;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

/**
 * PasswordSafePresenter presents a list of existing Password Safe databases.
 *
 * @author Noel Yap
 */
public class PasswordSafePresenter {
    public static final int ACTIVITY_ABOUT = 0;
    public static final int ACTIVITY_CREATE = 1;
    public static final int ACTIVITY_DESTROY = 2;
    public static final int ACTIVITY_HELP = 3;
    public static final int ACTIVITY_OPEN = 4;
    public static final int ACTIVITY_IMPORT = 5;
    public static final int ACTIVITY_EXPORT = 5;

    private static final int MENU_ITEM_ABOUT = Menu.FIRST;
    private static final int MENU_ITEM_DESTROY_DATABASE = Menu.FIRST+1;
    private static final int MENU_ITEM_HELP = Menu.FIRST+2;
    private static final int MENU_ITEM_IMPORT = Menu.FIRST+3;
    private static final int MENU_ITEM_EXPORT = Menu.FIRST+4;

    private static final String DATABASE_NAME = "database-name";

    private PasswordSafeView mView;

    private String mDatabaseName;
    private DialogHelper mDialogHelper;

    public PasswordSafePresenter(PasswordSafeView view) {
        mView = view;
    }

    public String getDatabaseName() {
	return mDatabaseName;
    }

    public void setDatabaseName(String databaseName) {
        mDatabaseName = databaseName;
    }

    public PasswordSafeView getView() {
        return mView;
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

        File dataDir = DatabaseUtil.getDatabaseDir(mView);
        String[] encodedDatabases = dataDir.list();
        String[] decodedDatabases = new String[encodedDatabases.length];

        for (int i = 0; i != encodedDatabases.length; ++i) {
            try {
                decodedDatabases[i] = DatabaseUtil.decode(encodedDatabases[i]);
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
            new DatabaseListArrayAdapter(
                this,
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

    private DialogHelper createDialogHelper(Integer id) {
        DialogHelper result;

        switch (id) {
            case ACTIVITY_ABOUT: {
                result = new AboutPasswordSafeDialogHelper(mView);

                break;
            }

            case ACTIVITY_DESTROY: {
                result = new DestroyDatabaseDialogHelper(mView, this);

                break;
            }

            case ACTIVITY_HELP: {
                result = new HelpPasswordSafeDialogHelper(mView);

                break;
            }

            case ACTIVITY_OPEN: {
                result = new OpenDatabaseDialogHelper(mView, this);

                break;
            }

            case ACTIVITY_IMPORT: {
                result = new ImportPasswordSafeDialogHelper(mView);

                break;
            }

            default: {
                result = null;
            }
        }

        return result;
    }

    /**
     * Pops up the correct dialog.
     */
    protected Dialog onCreateDialog(int id) {
        mDialogHelper = createDialogHelper(new Integer(id));

        return mDialogHelper.onCreateDialog();
    }

    /**
     * Blanks out password before dialog is opened.
     */
    protected void onPrepareDialog(int id, Dialog dialog) {
        mDialogHelper.onPrepareDialog(dialog);
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

        intent.putExtra(DatabaseUtil.DATABASE_FILEPATH_FIELD, databaseFilepath);
        intent.putExtra(DatabaseUtil.DATABASE_PASSPHRASE_FIELD, databasePassphrase);

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
        menu.add(0, MENU_ITEM_HELP, 0, R.string.help)
            .setIcon(android.R.drawable.ic_menu_help);
        menu.add(0, MENU_ITEM_ABOUT, 1, R.string.about)
            .setIcon(android.R.drawable.ic_menu_info_details);
        menu.add(0, MENU_ITEM_IMPORT, 2, R.string.importdb)
            .setIcon(android.R.drawable.ic_menu_add);
        menu.add(0, MENU_ITEM_EXPORT, 2, R.string.exportdb)
            .setIcon(android.R.drawable.ic_menu_edit);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_ITEM_ABOUT: {
                mView.showDialog(ACTIVITY_ABOUT);

                return true;
            }

            case MENU_ITEM_HELP: {
                mView.showDialog(ACTIVITY_HELP);

                return true;
            }

            case MENU_ITEM_IMPORT: {
                mView.showDialog(ACTIVITY_IMPORT);
                /* copy from /sdcard/*psafe3 */

                File sdCardDir = new File("/sdcard");
                String[] sdCardDatabases = sdCardDir.list();

                for (int i = 0; i < sdCardDatabases.length; ++i) {
                    if (sdCardDatabases[i].endsWith(".psafe3")) {
                        try {
                            File sdCardDatabase = new File(sdCardDir, sdCardDatabases[i]);
                            FileInputStream sdCardDB = new FileInputStream(sdCardDatabase);
                            File privateDatabase = new File(DatabaseUtil.getDatabaseDir(mView),
                                    DatabaseUtil.encode(sdCardDatabases[i].replace(".psafe3","")));

                            FileOutputStream privateDB = new FileOutputStream(privateDatabase);
                            byte[] dataBuffer = new byte[64*1024];
                            int len;
                            while ((len = sdCardDB.read(dataBuffer)) > 0) {
                                privateDB.write(dataBuffer, 0, len);
                            }
                            sdCardDB.close();
                            privateDB.close();
                            sdCardDatabase.delete();
                        } catch(java.io.FileNotFoundException e) {
                            /* TODO(shawn.ledbetter): catch if files not found */
                        } catch(java.io.IOException e) {
                            /* TODO(shawn.ledbetter): catch if IO errors */
                        }
                    }
                }

                fillData();
                mView.dismissDialog(ACTIVITY_IMPORT);
                return true;
            }

            case MENU_ITEM_EXPORT: {
                mView.showDialog(ACTIVITY_EXPORT);

                File sdCardDir = new File("/sdcard");
                File dataDir = DatabaseUtil.getDatabaseDir(mView);
                String[] encodedDatabases = dataDir.list();

                for (int i = 0; i < encodedDatabases.length; ++i) {
                    try {
                        File sdCardDatabase = new File(sdCardDir, DatabaseUtil.decode(encodedDatabases[i]) + ".psafe3");

                        /* Delete existing file on sdcard */
                        sdCardDatabase.delete();
                        FileOutputStream sdCardDB = new FileOutputStream(sdCardDatabase);
                        File privateDatabase = new File(DatabaseUtil.getDatabaseDir(mView),
                                                        encodedDatabases[i]);

                        FileInputStream privateDB = new FileInputStream(privateDatabase);
                        byte[] dataBuffer = new byte[64*1024];
                        int len;
                        while ((len = privateDB.read(dataBuffer)) > 0) {
                                sdCardDB.write(dataBuffer, 0, len);
                        }
                        sdCardDB.close();
                        privateDB.close();
                    } catch(java.io.FileNotFoundException e) {
                        /* TODO(shawn.ledbetter): catch if files not found */
                    } catch(java.io.IOException e) {
                        /* TODO(shawn.ledbetter): catch if IO errors */
                    }
                }

                mView.dismissDialog(ACTIVITY_EXPORT);

                return true;
            }
            default: {
                return false;
            }
        }
    }
}
