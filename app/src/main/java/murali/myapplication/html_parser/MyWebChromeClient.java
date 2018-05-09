package murali.myapplication.html_parser;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

/**
 * Created by shyleenrodrigues on 2/8/18.
 */

public class MyWebChromeClient extends WebChromeClient {

    LoadingProgressInterface loadingProgressInterface;

    public MyWebChromeClient(LoadingProgressInterface loadingProgressInterface) {
        this.loadingProgressInterface = loadingProgressInterface;
    }

    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        super.onProgressChanged(view, newProgress);
        loadingProgressInterface.loadingProgressCount(newProgress);
    }

    public interface LoadingProgressInterface {
        public void loadingProgressCount(int percentLoaded);
    }
}