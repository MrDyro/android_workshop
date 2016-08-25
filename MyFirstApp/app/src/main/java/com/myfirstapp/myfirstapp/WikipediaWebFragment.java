package com.myfirstapp.myfirstapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WikipediaWebFragment extends Fragment {

    private WebView webView;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater,
                             @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {

        final View view = inflater
                .inflate(R.layout.fragment_web_view, container, false);
        webView = (WebView) view.findViewById(R.id.wikipediaWebView);

        return view;
    }

    @Override
    public void onViewCreated(final View view,
                              @Nullable final Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        final String query = getArguments().getString(Constants.QUERY);
        webView.loadUrl("https://en.wikipedia.org/wiki/" + query);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(final WebView view,
                                                    final WebResourceRequest request) {

                return false;
            }
        });
    }
}
