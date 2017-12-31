package com.appinspire.imagedesigns;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Bilal Rashid on 12/28/2017.
 */

class AppUtils {
    public static boolean isInternetAvailable(final Context context) {
        ConnectivityManager conn = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = conn.getActiveNetworkInfo();
        if (activeNetworkInfo != null
                && activeNetworkInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }
}
