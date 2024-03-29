/*
 * Copyright (c) 2008 Noel Yap <noel.yap+code.google.com+com.pwsafe.android@gmail.com>.
 * All rights reserved. Use of the code is allowed under the
 * Artistic License 2.0 terms, as specified in the LICENSE file
 * distributed with this code, or available from
 * http://www.opensource.org/licenses/artistic-license-2.0.php
 */
package org.pwsafe.android;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * PasswordSafeView delegates to {@link PasswordSafePresenter}.
 *
 * @author Noel Yap
 */
public class PasswordSafeView extends Activity {
    private PasswordSafePresenter mPresenter = new PasswordSafePresenter(this);

    /**
     * Delegates to {@link PasswordSafePresenter#onCreate(Bundle)}.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.onCreate(savedInstanceState);
    }

    /**
     * Delegates to {@link PasswordSafePresenter#onSaveInstanceState(Bundle)}.
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        mPresenter.onSaveInstanceState(outState);
    }

    /**
     * Delegates to {@link PasswordSafePresenter#onCreateOptionsMenu(Menu)}.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean result = super.onCreateOptionsMenu(menu);

        result &= mPresenter.onCreateOptionsMenu(menu);

        return result;
    }

    /**
     * Delegates to {@link PasswordSafePresenter#onOptionsItemSelected(MenuItem)}.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return (
                mPresenter.onOptionsItemSelected(item)
                || super.onOptionsItemSelected(item));
    }

    /**
     * Delegates to {@link PasswordSafePresenter#onCreateDialog(int)}.
     */
    @Override
    protected Dialog onCreateDialog(int id) {
        Dialog result = mPresenter.onCreateDialog(id);

        if (result == null) {
            result = super.onCreateDialog(id);
        }

        return result;
    }

    /**
     * Delegates to {@link PasswordSafePresenter#onPrepareDialog(int, Dialog)}.
     */
    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        mPresenter.onPrepareDialog(id, dialog);
    }

    /**
     * Delegates to {@link PasswordSafePresenter#onActivityResult(int, int, Intent)}.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        mPresenter.onActivityResult(requestCode, resultCode, intent);
    }

    /**
     * Delegates to {@link PasswordSafePresenter#onContextItemSelected(MenuItem)}.
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return (
                mPresenter.onContextItemSelected(item)
                || super.onContextItemSelected(item));
    }
}
