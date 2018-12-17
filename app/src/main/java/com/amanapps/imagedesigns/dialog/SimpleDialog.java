package com.amanapps.imagedesigns.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
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
        if(mTitle.equals("Privacy Policy")){
            String htmlString="<u><h5>Scroll down to view full privacy policy</h5></u><br><p>latest and fancy Ring Designs (\"us\", \"we\", or \"our\") operates the latest and fancy Ring Designs mobile application (the \"Service\").</p>" +
                    "<br>" +
                    "<p>This page informs you of our policies regarding the collection, use, and disclosure of personal data when you use our Service and the choices you have associated with that data. </p>" +
                    "<br>" +
                    "<p>We use your data to provide and improve the Service. By using the Service, you agree to the collection and use of information in accordance with this policy. Unless otherwise defined in this Privacy Policy, terms used in this Privacy Policy have the same meanings as in our Terms and Conditions.</p>" +
                    "<br>" +
                    "<h2>Information Collection and Use</h2>" +
                    "<br>" +
                    "<p>We collect several different types of information for various purposes to provide and improve our Service to you.</p>" +
                    "<br>" +
                    "<h3>Types of Data Collected</h3>" +"<br>"+
                    "<h4>Personal Data</h4>" +
                    "<p>While using our Service, we may ask you to provide us with certain personally identifiable information that can be used to contact or identify you (\"Personal Data\"). Personally identifiable information may include, but is not limited to:</p>" +
                    "•Email address" +"<br>"+
                    "•Cookies and Usage Data" +
                    "<br>" +
                    "<br/>" +
                    "<h4>Usage Data</h4>" +
                    "<p>When you access the Service by or through a mobile device, we may collect certain information automatically, including, but not limited to, the type of mobile device you use, your mobile device unique ID, the IP address of your mobile device, your mobile operating system, the type of mobile Internet browser you use, unique device identifiers and other diagnostic data (\"Usage Data\").</p>" +
                    "<br>" +
                    "<h4>Tracking & Cookies Data</h4>" +
                    "<p>We use cookies and similar tracking technologies to track the activity on our Service and hold certain information.</p>" +
                    "<br>" +
                    "<p>Cookies are files with small amount of data which may include an anonymous unique identifier. Cookies are sent to your browser from a website and stored on your device. Tracking technologies also used are beacons, tags, and scripts to collect and track information and to improve and analyze our Service.</p>" +
                    "<br>" +
                    "<p>You can instruct your browser to refuse all cookies or to indicate when a cookie is being sent. However, if you do not accept cookies, you may not be able to use some portions of our Service.</p>" +
                    "<br>" +
                    "<h4>Examples of Cookies we use:</h4>" +
                    "•<b>Session Cookies.</b> We use Session Cookies to operate our Service.<br>"+
                    "•<b>Preference Cookies..</b> We use Preference Cookies to remember your preferences and various settings.<br>"+
                    "•<b>Security Cookies.</b> We use Security Cookies for security purposes.<br>" +
                    "<br>" +
                    "<h3>Use of Data</h3><br>" +
                    "<p>latest and fancy Ring Designs uses the collected data for various purposes:</p>" +
                    "<br>" +
                    "•To provide and maintain the Service<br>"+
                    "•To notify you about changes to our Service<br>"+
                    "•To allow you to participate in interactive features of our Service when you choose to do so<br>"+
                    "•To provide customer care and support<br>"+
                    "•To provide analysis or valuable information so that we can improve the Service<br>"+
                    "•To monitor the usage of the Service<br>"+
                    "•To detect, prevent and address technical issues<br>" +
                    "<br>" +
                    "<h3>Transfer Of Data</h3><br>" +
                    "<p>Your information, including Personal Data, may be transferred to and maintained on computers located outside of your state, province, country or other governmental jurisdiction where the data protection laws may differ than those from your jurisdiction.</p><br>" +
                    "<p>If you are located outside Pakistan and choose to provide information to us, please note that we transfer the data, including Personal Data, to Pakistan and process it there.</p><br>"+
                    "<p>Your consent to this Privacy Policy followed by your submission of such information represents your agreement to that transfer.</p><br>"+
                    "<p>latest and fancy Ring Designs will take all steps reasonably necessary to ensure that your data is treated securely and in accordance with this Privacy Policy and no transfer of your Personal Data will take place to an organization or a country unless there are adequate controls in place including the security of your data and other personal information.</p><br>" +
                    "<h3>Disclosure Of Data</h3><br>" +
                    "<h4>Legal Requirements</h4><br>" +
                    "<p>latest and fancy Ring Designs may disclose your Personal Data in the good faith belief that such action is necessary to:</p><br>" +
                    "•To comply with a legal obligation<br>"+
                    "•To protect and defend the rights or property of latest and fancy Ring Designs<br>"+
                    "•To prevent or investigate possible wrongdoing in connection with the Service<br>"+
                    "•To protect the personal safety of users of the Service or the public<br>"+
                    "•To protect against legal liability<br>" +
                    "<h3>Security Of Data</h3><br>" +
                    "<p>The security of your data is important to us, but remember that no method of transmission over the Internet, or method of electronic storage is 100% secure. While we strive to use commercially acceptable means to protect your Personal Data, we cannot guarantee its absolute security.</p><br>" +
                    "<h3>Service Providers</h3><br>" +
                    "<p>We may employ third party companies and individuals to facilitate our Service (\"Service Providers\"), to provide the Service on our behalf, to perform Service-related services or to assist us in analyzing how our Service is used.</p><br>"+
                    "<p>These third parties have access to your Personal Data only to perform these tasks on our behalf and are obligated not to disclose or use it for any other purpose.</p><br>" +
                    "<h3>Analytics</h3><br>" +
                    "<p>We may use third-party Service Providers to monitor and analyze the use of our Service.</p><br>" +
                    "<h4>Google Analytics</h4><br>" +
                    "<p>Google Analytics is a web analytics service offered by Google that tracks and reports website traffic. Google uses the data collected to track and monitor the use of our Service. This data is shared with other Google services. Google may use the collected data to contextualize and personalize the ads of its own advertising network.</p><br>"+
                    "<p>You may opt-out of certain Google Analytics features through your mobile device settings, such as your device advertising settings or by following the instructions provided by Google in their Privacy Policy: <u>https://policies.google.com/privacy?hl=en</u></p><br>"+
                    "<p>For more information on the privacy practices of Google, please visit the Google Privacy & Terms web page: <u>https://policies.google.com/privacy?hl=en</u></p><br>" +
                    "<h3>Links To Other Sites</h3><br>" +
                    "<p>Our Service may contain links to other sites that are not operated by us. If you click on a third party link, you will be directed to that third party's site. We strongly advise you to review the Privacy Policy of every site you visit.</p><br>"+
                    "<p>We have no control over and assume no responsibility for the content, privacy policies or practices of any third party sites or services.</p><br>"+
                    "<h3>Children's Privacy</h3><br>" +
                    "<p>Our Service does not address anyone under the age of 18 (\"Children\").</p><br>"+
                    "<p>We do not knowingly collect personally identifiable information from anyone under the age of 18. If you are a parent or guardian and you are aware that your Children has provided us with Personal Data, please contact us. If we become aware that we have collected Personal Data from children without verification of parental consent, we take steps to remove that information from our servers.</p><br>"+
                    "<h3>Changes To This Privacy Policy</h3><br>" +
                    "<p>We may update our Privacy Policy from time to time. We will notify you of any changes by posting the new Privacy Policy on this page.</p><br>"+
                    "<p>We will let you know via email and/or a prominent notice on our Service, prior to the change becoming effective and update the \"effective date\" at the top of this Privacy Policy.</p><br>"+
                    "<p>You are advised to review this Privacy Policy periodically for any changes. Changes to this Privacy Policy are effective when they are posted on this page.</p><br>" +
                    "<h3>Contact Us</h3><br>" +
                    "<p>If you have any questions about this Privacy Policy, please contact us:</p><br>" +
                    "•By email: <b>optimisedapps@gmail.com</b>";
//            Log.d("TAAAG",""+htmlString.substring(0,htmlString.length()/2));
//            Log.d("TAAAG2",""+htmlString.substring(htmlString.length()/2,htmlString.length()-1));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                messageText.setText(Html.fromHtml(mMessage, Html.FROM_HTML_MODE_COMPACT));
            } else {
                messageText.setText(Html.fromHtml(mMessage));
            }
            messageText.setVisibility(View.VISIBLE);
        }
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
//        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }
}