package com.myfirstapp.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private EditText input;

    @Override
    public void onClick(final CustomModel model) {
        final Intent intent = new Intent(MainActivity.this,
                                         WebViewActivity.class);
        intent.putExtra(Constants.QUERY, model.getQuery());
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.editTextInput);
        final Button button = (Button) findViewById(R.id.button);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        final CustomRecyclerAdapter adapter = new CustomRecyclerAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        final WikipediaApi wikipediaApi = new WikipediaApiManager().createApiEndpoint();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final String text = input.getText().toString();

                wikipediaApi.fetchSummary(text).enqueue(new Callback<WikipediaApiModel>() {
                    @Override
                    public void onFailure(final Call<WikipediaApiModel> call,
                                          final Throwable t) {

                        Toast.makeText(MainActivity.this, "Ups, something went wrong...",
                                       Toast.LENGTH_SHORT)
                                .show();
                    }

                    @Override
                    public void onResponse(final Call<WikipediaApiModel> call,
                                           final Response<WikipediaApiModel> response) {

                        try {
                            final WikipediaApiModel model = response.body();
                            adapter.addData(new CustomModel(model.getExtract(),
                                                            model.getThumbnail().getImageUrl(),
                                                            text));
                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(MainActivity.this, "Can't find " + text,
                                           Toast.LENGTH_SHORT)
                                    .show();
                        }
                    }
                });
            }
        });
    }
}
