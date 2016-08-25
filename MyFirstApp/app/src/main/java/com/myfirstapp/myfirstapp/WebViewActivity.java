package com.myfirstapp.myfirstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        final String query = getIntent().getStringExtra(Constants.QUERY);

        final WikipediaWebFragment fragment = new WikipediaWebFragment();
        final Bundle bundle = new Bundle();
        bundle.putString(Constants.QUERY, query);
        fragment.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, fragment)
                .commit();
    }
}
