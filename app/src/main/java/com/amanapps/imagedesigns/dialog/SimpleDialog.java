package com.amanapps.imagedesigns.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.amanapps.imagedesigns.R;

/**
 * Created by Bilal Rashid on 1/2/2018.
 */

public class SimpleDialog extends Dialog {
    private String mTitle;
    private String mMessage;
    private String mPositiveButtonText;
    private String mNegativeButtonText;
    private View.OnClickListener mOnClickListener;

    public SimpleDialog(Context context, String title, String message, String negativeButtonText, String positiveButtonText, View.OnClickListener onClickListener) {
        super(context);
        this.mTitle = title;
        this.mMessage = message;
        this.mPositiveButtonText = positiveButtonText;
        this.mNegativeButtonText = negativeButtonText;
        this.mOnClickListener = onClickListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_simple);
        TextView titleText = (TextView) findViewById(R.id.text_title);
        TextView messageText = (TextView) findViewById(R.id.text_message);
        Button negativeButton = (Button) findViewById(R.id.button_negative);
        Button positiveButton = (Button) findViewById(R.id.button_positive);
        negativeButton.setTransformationMethod(null);
        positiveButton.setTransformationMethod(null);
        if (mTitle != null) {
            titleText.setText(mTitle);
            titleText.setVisibility(View.VISIBLE);
        }
        if (mMessage != null) {
            messageText.setText(mMessage);
            messageText.setVisibility(View.VISIBLE);
        }
        if (mNegativeButtonText != null) {
            negativeButton.setText(mNegativeButtonText);
            negativeButton.setVisibility(View.VISIBLE);
            negativeButton.setOnClickListener(mOnClickListener);
        }
        if (mPositiveButtonText != null) {
            positiveButton.setText(mPositiveButtonText);
            positiveButton.setVisibility(View.VISIBLE);
            positiveButton.setOnClickListener(mOnClickListener);
        }
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
//        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }
}