package murali.myapplication.html_parser;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by shyleenrodrigues on 2/8/18.
 */

public class MyWebViewClient extends WebViewClient {

    LoadingCallBackInterface loadingCallBackInterface;

    public MyWebViewClient(LoadingCallBackInterface loadingCallBackInterface) {
        this.loadingCallBackInterface = loadingCallBackInterface;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        loadingCallBackInterface.loadingStarted();
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        loadingCallBackInterface.loadingCompleted();
    }

    @Override
    @TargetApi(Build.VERSION_CODES.M)
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);
        Log.e("error", error.getDescription().toString());
        loadingCallBackInterface.receivedError(error.getDescription().toString());
    }

    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
        Log.e("error", description);
        loadingCallBackInterface.receivedError(description);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        return super.shouldOverrideUrlLoading(view, request);
    }

    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        //view.stopLoading();
        return super.shouldInterceptRequest(view, request);
    }

    public interface LoadingCallBackInterface {

        public void loadingStarted();

        public void loadingCompleted();

        public void receivedError(String reason);

    }
}