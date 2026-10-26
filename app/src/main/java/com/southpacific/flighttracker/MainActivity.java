package com.southpacific.flighttracker;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;
import android.webkit.JavascriptInterface;
import android.os.Build;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
 WebView web;
 @Override public void onCreate(Bundle b){ super.onCreate(b);
 web=new WebView(this); setContentView(web);
 WebSettings s=web.getSettings(); s.setJavaScriptEnabled(true); s.setDomStorageEnabled(true);
 s.setAllowFileAccess(true); s.setAllowContentAccess(false);
 if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN){s.setAllowFileAccessFromFileURLs(false);s.setAllowUniversalAccessFromFileURLs(false);}
 web.setWebChromeClient(new WebChromeClient());
 web.setWebViewClient(new WebViewClient());
 web.loadUrl("file:///android_asset/index.html");
 }
 @Override public void onBackPressed(){if(web!=null && web.canGoBack())web.goBack();else super.onBackPressed();}
}
