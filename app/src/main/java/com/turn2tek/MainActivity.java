package com.turn2tek;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends ActionBarActivity {
    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView = (WebView) findViewById(R.id.activity_main_webview);

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Other webview options
        webSettings.setLoadWithOverviewMode(true);

        // webSettings.setBuiltInZoomControls(true);
        // webSettings.setPluginState(PluginState.ON);
        webSettings.setAllowFileAccess(true);
        webSettings.setSupportZoom(true);
        // Force links and redirects to open in the WebView instead of in a browser
        // mWebView.setWebViewClient(new WebViewClient());
        // Below required for geolocation
        webSettings.setGeolocationEnabled(true);

        final ProgressDialog mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("Loading...");
        //   mWebView.setWebChromeClient(new GeoWebChromeClient());

        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

                if (!mProgressDialog.isShowing()) {
                    mProgressDialog.show();
                }

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                if (mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                }
            }

        });

        mWebView.loadUrl("http://www.turn2tek.com");
    }


   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
