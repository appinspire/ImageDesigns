package com.appinspire.imagedesigns;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by Bilal Rashid on 12/28/2017.
 */

class ActivityUtils {
    public static void startActivity(Activity context, Class<?> class_, boolean isFinish) {
        Intent intent = new Intent(context, class_);
        context.startActivity(intent);
        if (isFinish)
            context.finish();
    }
}
