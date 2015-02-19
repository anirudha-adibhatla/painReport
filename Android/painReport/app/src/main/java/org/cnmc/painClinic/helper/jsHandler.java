package org.cnmc.painClinic.helper;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

/**
 * Created by aniPC on 2/10/2015.
 */
public class jsHandler {

    Activity activity;
    String TAG = "jsHandler";
    WebView webView;
    private String pin="";
    private boolean receivedPIN=false;
    public jsHandler(Activity _contxt,WebView _webView) {
        activity = _contxt;
        webView = _webView;
    }
    /**
     * This function handles call from JS
     */
    @JavascriptInterface
    public void jsFnCall(String jsString) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(activity);
        SharedPreferences.Editor editor=sharedPrefs.edit();
        editor.putString("PIN", jsString);
        editor.commit();
    }

    /**
     * This function handles call from Android-Java
     */
    public void javaFnCall(String jsString) {

        final String webUrl = "javascript:diplayJavaMsg()";
        // Add this to avoid android.view.windowmanager$badtokenexception unable to add window
        if(!activity.isFinishing())
            // loadurl on UI main thread
            activity.runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    webView.loadUrl(webUrl);
                }
            });
    }

    /**
     * function shows Android-Native Alert Dialog

    public void showDialog(String msg){

        AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
        alertDialog.setTitle("jsBridge");
        alertDialog.setMessage(msg);
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE,"OK", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();
            }
        });
        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE,"Cancel", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }*/
}
