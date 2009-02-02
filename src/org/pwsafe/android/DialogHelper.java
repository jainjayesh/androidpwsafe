/*
 * Copyright (c) 2009 Noel Yap <noel.yap+code.google.com+com.pwsafe.android@gmail.com>.
 * All rights reserved. Use of the code is allowed under the
 * Artistic License 2.0 terms, as specified in the LICENSE file
 * distributed with this code, or available from
 * http://www.opensource.org/licenses/artistic-license-2.0.php
 */
package org.pwsafe.android;

import android.app.Activity;
import android.app.Dialog;

public abstract class DialogHelper {
    private Activity mActivity;

    public DialogHelper(Activity activity) {
        mActivity = activity;
    }

    public Activity GetActivity() {
        return mActivity;
    }

    public abstract Dialog onCreateDialog();

    public void onPrepareDialog(Dialog dialog) {
    }
}
