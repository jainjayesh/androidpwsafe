/*
 * Copyright (c) 2008 Noel Yap <noel.yap+code.google.com+com.pwsafe.android@gmail.com>.
 * All rights reserved. Use of the code is allowed under the
 * Artistic License 2.0 terms, as specified in the LICENSE file
 * distributed with this code, or available from
 * http://www.opensource.org/licenses/artistic-license-2.0.php
 */
package org.pwsafe.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * DatabaseListArrayAdapter is an ArrayAdapter whose elements pop up a
 * dialog upon a long click.
 */
public class DatabaseListArrayAdapter extends ArrayAdapter<String> {
    private PasswordSafePresenter mPresenter;

    private int mTextViewResourceId;

    public DatabaseListArrayAdapter(
            PasswordSafePresenter presenter,
            int textViewResourceId,
            String[] objects) {
        super(presenter.getView(), textViewResourceId, objects);

        mPresenter = presenter;
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
        TextView textView = (TextView) convertView;

        if (textView == null) {
            LayoutInflater inflate =
                    (LayoutInflater) mPresenter.getView().getSystemService(
                            Context.LAYOUT_INFLATER_SERVICE);

            textView =
                    (TextView) inflate.inflate(mTextViewResourceId, null);
        }

        final String databaseName = getItem(position);

        textView.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        mPresenter.setDatabaseName(databaseName);

                        mPresenter.getView().showDialog(
                                PasswordSafePresenter.ACTIVITY_OPEN);
                    }
                });
        textView.setOnLongClickListener(
                new View.OnLongClickListener() {
                    public boolean onLongClick(View view) {
                        mPresenter.setDatabaseName(databaseName);

                        return false;
                    }
                });
        textView.setText(databaseName);

        return textView;
    }
}
