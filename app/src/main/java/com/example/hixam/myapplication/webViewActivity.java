package com.example.hixam.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        String qrCode;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                qrCode= null;
            } else {
                qrCode= extras.getString("qrCode");
            }
        } else {
            qrCode= (String) savedInstanceState.getSerializable("qrCode");
        }
        WebView myWebView = (WebView) this.findViewById(R.id.webView);

        myWebView.setPadding(0, 0, 0, 0);

        myWebView.getSettings().setDomStorageEnabled(true);
        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 16) {
            myWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        myWebView.getSettings().setAllowFileAccess(true);
        myWebView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //webview.loadUrl("file:///android_asset/file.html");
        if(qrCode==null)
        myWebView.loadUrl("https://www.w3schools.com/w3css/tryw3css_templates_pizza.htm");
        else
            myWebView.loadUrl("http://92.187.253.184:8080/pideya/test/"+qrCode);

    }

}
