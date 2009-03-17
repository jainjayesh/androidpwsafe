/*
 * Copyright (c) 2008 Noel Yap <noel.yap+code.google.com+com.pwsafe.android@gmail.com>.
 * All rights reserved. Use of the code is allowed under the
 * Artistic License 2.0 terms, as specified in the LICENSE file
 * distributed with this code, or available from
 * http://www.opensource.org/licenses/artistic-license-2.0.php
 */
package org.pwsafe.android;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * ViewUtil contains some utility functions for Android views.
 */
public class ViewUtil {
    public static View getView(
            View view, Activity activity, int resourceId) {
        if (view == null) {
            LayoutInflater layoutInflater =
                    (LayoutInflater) activity.getSystemService(
                            Context.LAYOUT_INFLATER_SERVICE);

            view = layoutInflater.inflate(resourceId, null);
        }

        return view;
    }
}
