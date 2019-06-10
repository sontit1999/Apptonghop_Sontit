package com.example.sonnewspaper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class DetailPost extends AppCompatActivity {
    WebView webView;
    String link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_post);
        setuptoolbar();
        anhxa();
        Intent intent = getIntent();
        link = intent.getStringExtra("link");
        setupwwebview();
    }
    private void anhxa()
    {
        webView = (WebView) findViewById(R.id.webview);
    }
    // setup webview
    private  void setupwwebview()
    {
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl(link);
    }
    // set up toolbar
        private void setuptoolbar()
        {

        }
        // get doccument

}
