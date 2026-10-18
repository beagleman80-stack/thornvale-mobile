package com.thornvale.mobile;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.webkit.WebViewAssetLoader;
import androidx.webkit.WebViewClientCompat;
import androidx.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;

public class MainActivity extends Activity {
 private WebView web;
 @Override public void onCreate(Bundle state){super.onCreate(state);
  getWindow().getDecorView().setSystemUiVisibility(5894|1024|512);
  web=new WebView(this);setContentView(web);
  WebSettings settings=web.getSettings();settings.setJavaScriptEnabled(true);settings.setDomStorageEnabled(true);
  settings.setAllowFileAccess(false);settings.setAllowContentAccess(false);settings.setMediaPlaybackRequiresUserGesture(false);
  WebViewAssetLoader loader=new WebViewAssetLoader.Builder().addPathHandler("/assets/",new WebViewAssetLoader.AssetsPathHandler(this)).build();
  web.setWebViewClient(new WebViewClientCompat(){@Override public WebResourceResponse shouldInterceptRequest(WebView v,WebResourceRequest request){return loader.shouldInterceptRequest(request.getUrl());}});
  web.setWebChromeClient(new WebChromeClient());
  web.loadUrl("https://appassets.androidplatform.net/assets/game/index.html");
 }
 private void saveNow(){if(web!=null)web.evaluateJavascript("try{if(typeof save==='function')save()}catch(e){}",null);}
 @Override protected void onPause(){saveNow();super.onPause();}
 @Override protected void onStop(){saveNow();super.onStop();}
 @Override protected void onDestroy(){saveNow();if(web!=null){web.destroy();web=null;}super.onDestroy();}
 @Override public void onBackPressed(){if(web!=null&&web.canGoBack())web.goBack();else super.onBackPressed();}
}
