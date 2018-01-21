package com.example.nu.myapplication.webview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.nu.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Web_med_Fragment extends Fragment {

    WebView webView;


    public Web_med_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_web_med, container, false);

        webView = view.findViewById(R.id.web_contact);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.med.nu.ac.th/fom/th/nuh2015/");


        return view;


    }

}
