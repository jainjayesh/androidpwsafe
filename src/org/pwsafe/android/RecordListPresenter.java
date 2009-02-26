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
import org.pwsafe.lib.file.PwsFile;
import org.pwsafe.lib.file.PwsFileFactory;
import org.pwsafe.lib.file.PwsFileStorage;
import org.pwsafe.lib.file.PwsRecord;
import org.pwsafe.lib.file.PwsRecordV3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

import android.app.Activity;
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
 * RecordListPresenter presents a list of existing Password Safe records.
 *
 * @author Noel Yap
 */
public class RecordListPresenter {
    // TODO: Extract class so it can be tested.
    /**
     * ArrayAdapterPwsRecord is an ArrayAdapter that sorts its elements by URL.
     */
    private class ArrayAdapterPwsRecord extends ArrayAdapter<PwsRecordWrapper> {
        private int mTextViewResourceId;

        // TODO: Make public so it can be tested.
        /**
         * ComparePwsRecord is a Comparator that compares records by URL.
         */
        private class ComparePwsRecord implements Comparator<Object> {
            public int compare(Object o1, Object o2) {
                PwsRecordWrapper pwsRecord1 = (PwsRecordWrapper) o1;
                PwsRecordWrapper pwsRecord2 = (PwsRecordWrapper) o2;
                String url1 = pwsRecord1.getUrl();
                String url2 = pwsRecord2.getUrl();

                return url1.compareTo(url2);
            }
        }

        // TODO: Refactor to make it testable.
        /**
         * Populates list.
         *
         * @param context
         * @param textViewResourceId
         * @param pwsRecords  PwsRecord objects to populate list
         */
        public ArrayAdapterPwsRecord(
                Context context,
                int textViewResourceId,
                PwsRecordWrapper[] pwsRecords) {
            super(context, textViewResourceId);

            mTextViewResourceId = textViewResourceId;

            Arrays.sort(pwsRecords, new ComparePwsRecord());

            for (int i = 0; i != pwsRecords.length; ++i) {
                super.add(pwsRecords[i]);
            }
        }

        /**
         * Adds record to correct place in list.
         *
         * @param pwsRecord  PwsRecord object to add to list
         */
        @Override
        public void add(PwsRecordWrapper pwsRecord) {
            String recordUrl = pwsRecord.getUrl();
            int index = lowerBound(recordUrl);

            insert(pwsRecord, index);
        }

        /**
         * Returns index for insertion point.
         *
         * @param url  URL to insert into list
         */
        private int lowerBound(String url) {
            int lowerBoundIndex = 0;
            int upperBoundIndex = getCount();

            while (true) {
                if (lowerBoundIndex == upperBoundIndex) {
                    return lowerBoundIndex;
                }

                PwsRecordWrapper lowerBoundItem = getItem(lowerBoundIndex);
                String lowerBoundUrl = lowerBoundItem.getUrl();

                if (url.compareTo(lowerBoundUrl) < 0) {
                    return lowerBoundIndex;
                }

                PwsRecordWrapper upperBoundItem = getItem(upperBoundIndex-1);
                String upperBoundUrl= upperBoundItem.getUrl();

                if (upperBoundUrl.compareTo(url) < 0) {
                    return upperBoundIndex;
                }

                int midPointIndex = (lowerBoundIndex+upperBoundIndex)/2;
                PwsRecordWrapper midPointItem = getItem(midPointIndex);
                String midPointUrl = midPointItem.getUrl();

                if (url.compareTo(midPointUrl) < 0) {
                    upperBoundIndex = midPointIndex;
                } else {
                    lowerBoundIndex = midPointIndex;
                }
            }
        }

        /**
         * Creates text view for element.
         *
         * @param position  index in the list
         * @param convertView  the list element view
         * @param parent the list view
         * @return  the list element view with URL as its text
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = (TextView) convertView;

            if (textView == null) {
                LayoutInflater inflate =
                        (LayoutInflater) mView.getSystemService(
                                Context.LAYOUT_INFLATER_SERVICE);

                textView =
                        (TextView) inflate.inflate(mTextViewResourceId, null);
            }

            final PwsRecordWrapper pwsRecord = getItem(position);

            textView.setOnClickListener(
                    new View.OnClickListener() {
                        public void onClick(View view) {
                            mPwsRecord = pwsRecord;

                            Intent intent =
                                    new Intent(mView, RecordEditView.class);

                            intent.putExtra(
                                    RecordUtil.NOTES_FIELD,
                                    pwsRecord.getNotes());
                            intent.putExtra(
                                    RecordUtil.PASSPHRASE_FIELD,
                                    pwsRecord.getPassword());
                            intent.putExtra(
                                    RecordUtil.URL_FIELD,
                                    pwsRecord.getUrl());
                            intent.putExtra(
                                    RecordUtil.USERNAME_FIELD,
                                    pwsRecord.getUsername());

                            mView.startActivityForResult(
                                intent, ACTIVITY_MODIFY);
                        }
                    });
            textView.setOnLongClickListener(
                    new View.OnLongClickListener() {
                        public boolean onLongClick(View view) {
                            mPwsRecord = pwsRecord;

                            return false;
                        }
                    });
            textView.setText(pwsRecord.getUrl());

            return textView;
        }
    }

    public static final int ACTIVITY_CREATE = 0;
    public static final int ACTIVITY_DELETE = 1;
    public static final int ACTIVITY_MODIFY = 2;

    private static final int MENU_ITEM_DELETE_RECORD = Menu.FIRST;

    private RecordListView mView;

    private PwsFile mPwsFile;
    private PwsRecordWrapper mPwsRecord;

    public RecordListPresenter(RecordListView view) {
        mView = view;
    }

    public void onCreate(Bundle savedInstanceState) {
        mView.setContentView(R.layout.record_list);
        Button addRecordButton = (Button) mView.findViewById(R.id.add_record);

        addRecordButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                createRecord();
            }
        });

        String databaseFilepath =
                getStringField(
                        savedInstanceState,
                        DatabaseUtil.DATABASE_FILEPATH_FIELD);
        String databasePassphrase =
                getStringField(
                        savedInstanceState,
                        DatabaseUtil.DATABASE_PASSPHRASE_FIELD);

        loadDatabase(databaseFilepath, databasePassphrase);
    }

    /**
     * Loads records.
     *
     * @param databaseFilepath  filesystem path of database
     * @param databasePassphrase  passphrase to decrypt/encrypt database
     */
    private void loadDatabase(String databaseFilepath, String databasePassphrase) {
        try {
            mPwsFile = PwsFileFactory.loadFile(databaseFilepath, databasePassphrase);
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

    /**
     * Fills list with records.
     */
    public void fillData() {
        int pwsFileRecordCount = mPwsFile.getRecordCount();
        PwsRecordWrapper[] pwsRecords =
                new PwsRecordWrapper[pwsFileRecordCount];

        Iterator<PwsRecord> iter = mPwsFile.getRecords();
        for (int i = 0; i != pwsFileRecordCount; ++i) {
            pwsRecords[i] =
                    new PwsRecordWrapper(mPwsFile, (PwsRecordV3) iter.next());
        }

        ListView recordList = (ListView) mView.findViewById(R.id.record_list);

        recordList.setAdapter(
                new ArrayAdapterPwsRecord(
                        mView,
                        R.layout.list_row,
                        pwsRecords));
        recordList.setOnCreateContextMenuListener(
            new View.OnCreateContextMenuListener() {
                public void onCreateContextMenu(
                        ContextMenu menu,
                        View v,
                        ContextMenu.ContextMenuInfo menuInfo) {
                    menu.add(
                        0,
                        MENU_ITEM_DELETE_RECORD,
                        0,
                        R.string.delete_record);
                }
            });
        recordList.setTextFilterEnabled(true);
    }

    /**
     * Starts activity for record creation.
     */
    private void createRecord() {
        Intent intent = new Intent(mView, RecordEditView.class);

        mPwsRecord = new PwsRecordWrapper(mPwsFile, (PwsRecordV3) mPwsFile.newRecord());

        mView.startActivityForResult(intent, ACTIVITY_CREATE);
    }

    /**
     * Adds PwsRecord to database and updates list.
     *
     * @param listAdapter  ListAdapter object to be modified
     * @param pwsRecord  PwsRecord object whose fields will be set
     */
    private void addPwsRecord(
            ArrayAdapterPwsRecord listAdapter, PwsRecordWrapper pwsRecord) {
        pwsRecord.add();
        listAdapter.add(pwsRecord);
    }

    /**
     * Deletes PwsRecord and updates list.
     *
     * @param listAdapter  ListAdapter object to be modified
     * @param pwsRecord  PwsRecord object whose fields will be set
     */
    private void deletePwsRecord(
            ArrayAdapterPwsRecord listAdapter, PwsRecordWrapper pwsRecord) {
        pwsRecord.delete();
        listAdapter.remove(pwsRecord);
    }

    /**
     * Edits PwsRecord and updates list.
     *
     * @param listAdapter  ListAdapter object to be modified
     * @param pwsRecord  PwsRecord object whose fields will be set
     */
    private void editPwsRecord(
            ArrayAdapterPwsRecord listAdapter, PwsRecordWrapper pwsRecord) {
        // TODO: Remove/add from list iff URL has changed.
        listAdapter.remove(pwsRecord);
        listAdapter.add(pwsRecord);
    }

    /**
     * Handles result of activity (add, edit, delete) and saves database.
     */
    protected void onActivityResult(
            int requestCode, int resultCode, Intent data) {
        // TODO: Extract method to make it more testable.
        if (resultCode == Activity.RESULT_OK) {
            try {
                ListView recordList =
                        (ListView) mView.findViewById(R.id.record_list);
                ArrayAdapterPwsRecord listAdapter =
                        (ArrayAdapterPwsRecord) recordList.getAdapter();

                long activity = data.getIntExtra("activity", -1);

                if (activity == ACTIVITY_DELETE) {
                    deletePwsRecord(listAdapter, mPwsRecord);
                } else {
                    mPwsRecord.setNotes(
                            data.getStringExtra(RecordUtil.NOTES_FIELD));
                    mPwsRecord.setPassword(
                            data.getStringExtra(RecordUtil.PASSPHRASE_FIELD));
                    mPwsRecord.setUrl(
                            data.getStringExtra(RecordUtil.URL_FIELD));
                    mPwsRecord.setUsername(
                            data.getStringExtra(RecordUtil.USERNAME_FIELD));

                    if (requestCode == ACTIVITY_CREATE) {
                        addPwsRecord(listAdapter, mPwsRecord);
                    } else {
                        editPwsRecord(listAdapter, mPwsRecord);
                    }
                }

                mPwsFile.save();
                // TODO: simplify the following by adding methods to jpwsafe
                (new File(((PwsFileStorage) mPwsFile.getStorage()).getFilename() + "~")).delete();
            } catch (NoSuchAlgorithmException e) {
                // TODO: Popup error dialog.
                e.printStackTrace();
            } catch (IOException e) {
                // TODO: Popup error dialog.
                e.printStackTrace();
            }
        }
    }

    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_ITEM_DELETE_RECORD: {
                try {
                    ListView recordList =
                            (ListView) mView.findViewById(R.id.record_list);
                    ArrayAdapterPwsRecord listAdapter =
                            (ArrayAdapterPwsRecord) recordList.getAdapter();

                    deletePwsRecord(listAdapter, mPwsRecord);
                    mPwsFile.save();
                } catch (NoSuchAlgorithmException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                return true;
            }

            default: {
                return false;
            }
        }
    }
}
