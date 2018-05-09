package murali.myapplication.html_parser;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import murali.myapplication.R;

public class Main5Activity extends AppCompatActivity implements MyWebViewClient.LoadingCallBackInterface, MyWebChromeClient.LoadingProgressInterface {

    EditText urlEditText;
    Button downloadHtmlBtn;
    WebView browserWebView;

    ProgressBar loadingProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        urlEditText = (EditText) findViewById(R.id.site_url);
        downloadHtmlBtn = (Button) findViewById(R.id.download_html);
        browserWebView = (WebView) findViewById(R.id.browser_webview);
        loadingProgress = (ProgressBar) findViewById(R.id.loading_progress);

        browserWebView.getSettings().setJavaScriptEnabled(true);

        browserWebView.setWebViewClient(new MyWebViewClient(Main5Activity.this));
        browserWebView.setWebChromeClient(new MyWebChromeClient(Main5Activity.this));

        downloadHtmlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                browserWebView.loadUrl(urlEditText.getText().toString());
            }
        });
    }

    @Override
    public void loadingStarted() {
        loadingProgress.setVisibility(View.VISIBLE);
        loadingProgress.setProgress(0);
    }

    @Override
    public void loadingCompleted() {
        loadingProgress.setProgress(100);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loadingProgress.setVisibility(View.INVISIBLE);
    }

    @Override
    public void receivedError(String reason) {
        loadingCompleted();
    }

    @Override
    public void loadingProgressCount(int percentLoaded) {
        loadingProgress.setProgress(percentLoaded);
    }
}