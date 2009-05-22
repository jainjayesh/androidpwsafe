/*
 * Copyright (c) 2008 Noel Yap <noel.yap+code.google.com+com.pwsafe.android@gmail.com>.
 * All rights reserved. Use of the code is allowed under the
 * Artistic License 2.0 terms, as specified in the LICENSE file
 * distributed with this code, or available from
 * http://www.opensource.org/licenses/artistic-license-2.0.php
 */
package org.pwsafe.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * RecordEditView delegates to {@link RecordEditPresenter}.
 *
 * @author Noel Yap
 */
public class RecordEditView extends Activity {
    private RecordEditPresenter mPresenter = new RecordEditPresenter(this);

    /**
     * Delegates to {@link RecordEditView#onCreate(Bundle)}.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.onCreate(savedInstanceState);
    }

    /**
     * Delegates to {@link RecordEditView#onCreateOptionsMenu(Menu)}.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean result = super.onCreateOptionsMenu(menu);

        result &= mPresenter.onCreateOptionsMenu(menu);

        return result;
    }

    /**
     * Delegates to {@link RecordEditView#onOptionsItemSelected(MenuItem)}.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return (
                mPresenter.onOptionsItemSelected(item)
                || super.onOptionsItemSelected(item));
    }
}
