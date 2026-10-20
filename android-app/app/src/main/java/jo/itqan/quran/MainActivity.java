package jo.itqan.quran;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.graphics.Color;
import android.webkit.DownloadListener;
import android.app.DownloadManager;
import android.net.Uri;
import android.content.Context;
import android.os.Environment;
public class MainActivity extends Activity {
 private WebView web;
 @Override public void onCreate(Bundle state){
 super.onCreate(state);
 web=new WebView(this); web.setBackgroundColor(Color.rgb(245,245,239));
 setContentView(web);
 WebSettings s=web.getSettings(); s.setJavaScriptEnabled(true); s.setDomStorageEnabled(true); s.setMediaPlaybackRequiresUserGesture(true); s.setAllowFileAccess(false);
 web.setWebViewClient(new WebViewClient());
 web.setWebChromeClient(new WebChromeClient());
 web.setDownloadListener((url,userAgent,contentDisposition,mimeType,contentLength)->{
   try { DownloadManager.Request req=new DownloadManager.Request(Uri.parse(url)); req.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED); req.setDestinationInExternalFilesDir(this,Environment.DIRECTORY_DOWNLOADS,"itqan-results.json"); ((DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE)).enqueue(req); } catch(Exception e){}
 });
 web.loadUrl("https://rabeerabee733-eng.github.io/itqan-quran/");
 }
 @Override public void onBackPressed(){if(web.canGoBack())web.goBack();else super.onBackPressed();}
 @Override protected void onDestroy(){web.destroy();super.onDestroy();}
}
