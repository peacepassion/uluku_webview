package org.peace.allinone.ui;

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

public class SubActivity extends AppCompatActivity {

  //String url = "http://www.sogou.com";

  @InjectView(R.id.web_view) protected WebView webView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ButterKnife.inject(this);
    webView.post(new Runnable() {
      @Override public void run() {
        try {
          String url;
          String m3u8 =
              "http://139.224.32.32:9110/real.m3u8?channel_idx=1&device_id=Ub0000000542866896QB&duration=3600&from_ip=180.168.39.42&is_shared=1&rate=700&user_name=1000&ver=&token=-L-izAjxbeqWjRXrYam57AY87boewetQp6eHPZjtvqorYMRtSmpG0yucKZBL7FWypW0gDMRo5jNgjUpYVFkqVA&v_width=0&v_height=0&valid_time=1466162095";
          url = "http://mobi.ulucu.com/m3u8.html?m3u8Url=" + URLEncoder.encode(m3u8, "UTF-8");

          url = "http://devimages.apple.com/iphone/samples/bipbopgear1.html";

          url = "http://mobi.ulucu.com/m3u8.html?m3u8Url=http%3a%2f%2f139.224.32.32%3a9110%2freal.m3u8%3fchannel_idx%3d1%26device_id%3dUb0000000542866896QB%26duration%3d3600%26from_ip%3d115.159.86.201%26is_shared%3d1%26rate%3d700%26user_name%3d1000%26ver%3d%26token%3dXGIQnP7fyuW40Ivb7cDNTJmhLh5hHCJJAKUA9_MNlWW-Dqf-CXedmXaaDLz-i--aeASQNCjWWjTakJH4hQ6sfg%26v_width%3d0%26v_height%3d0%26valid_time%3d1466227514";

          init(url);
        } catch (Exception e) {
          e.printStackTrace();
        }

      }
    });
  }

  @OnClick({ R.id.start_btn }) public void onClick(View v) {
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
