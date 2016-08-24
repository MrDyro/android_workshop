package com.myfirstapp.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private EditText input;

    @Override
    public void onClick(final CustomModel model) {
        final Intent intent = new Intent(MainActivity.this,
                                         AnimalImageActivity.class);
        intent.putExtra(Constants.IMAGE_RES_ID, model.getImageResId());
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

        final Random random = new Random();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final String text = input.getText().toString();

                final int imageResId;
                if (random.nextInt(2) == 0) {
                    imageResId = R.drawable.cat;
                } else {
                    imageResId = R.drawable.dog;
                }

                adapter.addData(new CustomModel(text, imageResId));
            }
        });
    }
}
