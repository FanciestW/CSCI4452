package me.williamlin.dynamicui;

import android.support.v4.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by william on 3/1/18.
 */

public class WebFragment extends Fragment {

    WebView mWebView;
    int position;
    String url;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.web_fragment_layout, container, false);
        mWebView = view.findViewById(R.id.webview);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstance) {
        super.onActivityCreated(savedInstance);
        Bundle bundle = this.getArguments();

        // Set whether the WebView should load image resources.
        mWebView.getSettings().setLoadsImagesAutomatically(true);

        // If the web page you plan to load in your WebView uses
        // Javascript, you must enable Javascript for your WebView
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        if(bundle == null) {
            mWebView.loadUrl("https://newhaven.edu");
        } else {
            position = bundle.getInt("url");
            Log.d("position web", "position: " + position);
            url = getContent(position);

            mWebView.loadUrl(url);
        }

        // to open links clicked by the user, simply provide a
        // WebViewClient for your WebView, using setWebViewClient().
        mWebView.setWebViewClient(new WebViewClient());
    }

    public String getContent(int data) {
        Resources res = getResources();
        String[] desc = res.getStringArray(R.array.urls);
        return desc[data];
    }

}