/*
 * Copyright (c) 2008 Noel Yap <noel.yap+code.google.com+com.pwsafe.android@gmail.com>.
 * All rights reserved. Use of the code is allowed under the
 * Artistic License 2.0 terms, as specified in the LICENSE file
 * distributed with this code, or available from
 * http://www.opensource.org/licenses/artistic-license-2.0.php
 */
package org.pwsafe.android;

import java.util.Arrays;
import java.util.Comparator;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * RecordListArrayAdapter is an ArrayAdapter for PasswordSafePresenter.
 *
 * @author Noel Yap
 */
public class RecordListArrayAdapter extends ArrayAdapter<PwsRecordWrapper> {
    private RecordListPresenter mPresenter;

    private int mTextViewResourceId;

    // TODO: Make public so it can be tested.
    /**
     * ComparePwsRecord is a Comparator that compares records by URL.
     */
    private class ComparePwsRecord implements Comparator<Object> {
        public int compare(Object o1, Object o2) {
            PwsRecordWrapper pwsRecord1 = (PwsRecordWrapper) o1;
            PwsRecordWrapper pwsRecord2 = (PwsRecordWrapper) o2;
            String display1 = PwsRecordUtil.getDisplayString(pwsRecord1);
            String display2 = PwsRecordUtil.getDisplayString(pwsRecord2);

            return display1.compareTo(display2);
        }
    }

    // TODO: Refactor to make it testable.
    /**
     * Populates list.
     *
     * @param presenter
     * @param textViewResourceId
     * @param pwsRecords  PwsRecord objects to populate list
     */
    public RecordListArrayAdapter(
            RecordListPresenter presenter,
            int textViewResourceId,
            PwsRecordWrapper[] pwsRecords) {
        super(presenter.getView(), textViewResourceId);

        mPresenter = presenter;
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
        String recordDisplay = PwsRecordUtil.getDisplayString(pwsRecord);
        int index = lowerBound(recordDisplay);

        insert(pwsRecord, index);
    }

    /**
     * Returns index for insertion point.
     *
     * @param url  URL to insert into list
     */
    private int lowerBound(String display) {
        int lowerBoundIndex = 0;
        int upperBoundIndex = getCount();

        while (true) {
            if (lowerBoundIndex == upperBoundIndex) {
                return lowerBoundIndex;
            }

            PwsRecordWrapper lowerBoundItem = getItem(lowerBoundIndex);
            String lowerBoundDisplay = PwsRecordUtil.getDisplayString(lowerBoundItem);

            if (display.compareTo(lowerBoundDisplay) < 0) {
                return lowerBoundIndex;
            }

            PwsRecordWrapper upperBoundItem = getItem(upperBoundIndex-1);
            String upperBoundDisplay= PwsRecordUtil.getDisplayString(upperBoundItem);

            if (upperBoundDisplay.compareTo(display) < 0) {
                return upperBoundIndex;
            }

            int midPointIndex = (lowerBoundIndex+upperBoundIndex)/2;
            PwsRecordWrapper midPointItem = getItem(midPointIndex);
            String midPointDisplay = PwsRecordUtil.getDisplayString(midPointItem);

            if (display.compareTo(midPointDisplay) < 0) {
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
        TextView textView =
                (TextView) ViewUtil.getView(
                        convertView, mPresenter.getView(), mTextViewResourceId);

        final PwsRecordWrapper pwsRecord = getItem(position);

        textView.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        mPresenter.setPwsRecord(pwsRecord);

                        Intent intent =
                                new Intent(mPresenter.getView(), RecordEditView.class);

                        intent.putExtra(
                                PwsRecordUtil.NOTES_FIELD,
                                pwsRecord.getNotes());
                        intent.putExtra(
                                PwsRecordUtil.GROUP_FIELD,
                                pwsRecord.getGroup());
                        intent.putExtra(
                                PwsRecordUtil.PASSPHRASE_FIELD,
                                pwsRecord.getPassword());
                        intent.putExtra(
                                PwsRecordUtil.TITLE_FIELD,
                                pwsRecord.getTitle());
                        intent.putExtra(
                                PwsRecordUtil.URL_FIELD,
                                pwsRecord.getUrl());
                        intent.putExtra(
                                PwsRecordUtil.USERNAME_FIELD,
                                pwsRecord.getUsername());

                        mPresenter.getView().startActivityForResult(
                            intent, RecordListPresenter.ACTIVITY_MODIFY);
                    }
                });
        textView.setOnLongClickListener(
                new View.OnLongClickListener() {
                    public boolean onLongClick(View view) {
                        mPresenter.setPwsRecord(pwsRecord);

                        return false;
                    }
                });
        textView.setText(PwsRecordUtil.getDisplayString(pwsRecord));

        return textView;
    }
}
