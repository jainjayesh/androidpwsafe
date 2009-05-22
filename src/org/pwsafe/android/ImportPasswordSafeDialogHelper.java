/*
 * Copyright (c) 2009 Noel Yap <noel.yap+code.google.com+com.pwsafe.android@gmail.com>.
 * All rights reserved. Use of the code is allowed under the
 * Artistic License 2.0 terms, as specified in the LICENSE file
 * distributed with this code, or available from
 * http://www.opensource.org/licenses/artistic-license-2.0.php
 */
package org.pwsafe.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;

public class ImportPasswordSafeDialogHelper extends DialogHelper {
    public ImportPasswordSafeDialogHelper(Activity activity) {
        super(activity);
    }

    @Override
    public Dialog onCreateDialog() {
        return new AlertDialog.Builder(GetActivity())
                .setIcon(android.R.drawable.ic_dialog_info)
                .setMessage(R.string.import_text)
                .setTitle(R.string.importdb)
                .create();
    }
}
