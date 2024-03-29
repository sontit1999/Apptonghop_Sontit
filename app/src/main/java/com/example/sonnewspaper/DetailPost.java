package com.example.sonnewspaper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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
        Log.d("vongdoi","oncreatDetailPost");
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
        // vòng đời
        @Override
        protected void onStart() {
            super.onStart();
            Log.d("vongdoi","OnStartDetailPost");
        }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("vongdoi","OnresumeDetailPost");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("vongdoi","OnPauseDetailPost");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("vongdoi","OnStopDetailPost");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("vongdoi","OnrestartDetailPost");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("vongdoi","OnDestroyDetailPost");
    }
}
