/*
 * Copyright (c) 2008 Noel Yap <noel.yap+code.google.com+com.pwsafe.android@gmail.com>.
 * All rights reserved. Use of the code is allowed under the
 * Artistic License 2.0 terms, as specified in the LICENSE file
 * distributed with this code, or available from
 * http://www.opensource.org/licenses/artistic-license-2.0.php
 */
package org.pwsafe.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * RecordListView delegates to {@link RecordListPresenter}.
 *
 * @author Noel Yap
 */
public class RecordListView extends Activity {
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
     * Delegates to {@link RecordListPresenter#onActivityResult(int, int, Intent)}.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mPresenter.onActivityResult(requestCode, resultCode, data);
    }
}
