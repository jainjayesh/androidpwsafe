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

/**
 * DatabaseCreateView delegates calls to {@link DatabaseCreatePresenter}.
 *
 * @author Noel Yap
 */
public class DatabaseCreateView extends Activity {
    private DatabaseCreatePresenter mPresenter = new DatabaseCreatePresenter(this);

    /**
     * Delegates to {@link DatabaseCreatePresenter#onCreate(Bundle)}.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.onCreate(savedInstanceState);
    }

    /**
     * Delegates to {@link DatabaseCreatePresenter#onPause(Bundle)}.
     */
    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.onPause();
    }
}
