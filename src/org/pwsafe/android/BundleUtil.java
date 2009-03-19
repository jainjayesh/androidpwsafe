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
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

/**
 * BundleUtil contains some utility functions for Android Bundles.
 */
public class BundleUtil {
    public static String getStringField(
            Bundle savedInstanceState, Bundle extras, String fieldName) {
        String result = (savedInstanceState != null
                ? savedInstanceState.getString(fieldName)
                : null);

        if (result == null) {
            result = (extras != null
                    ? extras.getString(fieldName)
                    : null);
        }

        return result;
    }
}
