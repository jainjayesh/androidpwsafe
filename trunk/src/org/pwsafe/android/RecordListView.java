/*
 * Copyright (c) 2008 Noel Yap <noel.yap+code.google.com+com.pwsafe.android@gmail.com>.
 * All rights reserved. Use of the code is allowed under the
 * Artistic License 2.0 terms, as specified in the LICENSE file
 * distributed with this code, or available from
 * http://www.opensource.org/licenses/artistic-license-2.0.php
 */
package org.pwsafe.android;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

/**
 * RecordListView delegates to {@link RecordListPresenter}.
 *
 * @author Noel Yap
 */
public class RecordListView extends ListActivity {
    private RecordListPresenter mPresenter = new RecordListPresenter(this);

    /**
     * Delegates to {@link RecordListPresenter#onCreate(Bundle)}.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.onCreate(savedInstanceState);
    }

    /**
     * Delegates to {@link RecordListPresenter#onResume()}.
     */
    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    /**
     * Delegates to {@link RecordListPresenter#onCreateOptionsMenu(Menu)}.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean result = super.onCreateOptionsMenu(menu);

        result &= mPresenter.onCreateOptionsMenu(menu);

        return result;
    }

    /**
     * Delegates to {@link RecordListPresenter#onOptionsItemSelected(MenuItem)}.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return (
                mPresenter.onOptionsItemSelected(item)
                || super.onOptionsItemSelected(item));
    }

    /**
     * Delegates to {@link RecordListPresenter#onActivityResult(int, int, Intent)}.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mPresenter.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * Delegates to {@link RecordListPresenter#onListItemClick(ListView, View, int, long)}.
     */
    @Override
    protected void onListItemClick(ListView list, View view, int position, long id) {
        super.onListItemClick(list, view, position, id);
        mPresenter.onListItemClick(list, view, position, id);
    }
}
