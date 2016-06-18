package org.peace.allinone.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import java.net.URLEncoder;
import org.peace.allinone.R;

public class MainActivity extends AppCompatActivity {

  //String url = "http://www.sogou.com";

  @InjectView(R.id.web_view) protected WebView webView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ButterKnife.inject(this);
  }

  @OnClick({ R.id.start_btn }) public void onClick(View v) {
    startActivity(new Intent(this, SubActivity.class));
  }

  private void init(String url) {
    WebSettings webSettings = webView.getSettings();
    webSettings.setJavaScriptEnabled(true);
    webSettings.setDefaultTextEncodingName("GBK");
    webSettings.setAllowFileAccess(true);
    webSettings.setAllowFileAccess(true);
    webSettings.setAllowContentAccess(true);
    //WebView加载web资源
    webView.loadUrl(url);
    //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
    webView.setWebViewClient(new WebViewClient() {
      @Override
      public boolean shouldOverrideUrlLoading(WebView view, String url) {
        // TODO Auto-generated method stub
        //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
        view.loadUrl(url);
        return true;
      }
    });
  }
}
