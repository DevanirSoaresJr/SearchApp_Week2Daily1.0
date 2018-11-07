package com.example.deva_.searchapp_week2daily1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivity";
    private TextView textView;
    private WebView webView;
    String Online = "https://www.google.com/search?q=";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        //binding views
        textView = findViewById(R.id.searchOnline);

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = getSharedPreferences("url", Context.MODE_PRIVATE);
        String Url = sharedPreferences.getString("url","");
        webView = findViewById(R.id.webView);
        WebViewClient webViewClient = new WebViewClient();
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(webViewClient);
        webView.loadUrl(Online + Url);
    }
}
