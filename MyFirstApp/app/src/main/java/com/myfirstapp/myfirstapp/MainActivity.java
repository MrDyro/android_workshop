package com.myfirstapp.myfirstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView output = (TextView) findViewById(R.id.textViewOutput);
        final EditText input = (EditText) findViewById(R.id.editTextInput);
        final Button button = (Button) findViewById(R.id.button);
        final ImageView catImage = (ImageView) findViewById(R.id.imageViewCat);

        final String password = "cat";

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final String text = input.getText().toString();

                if (password.equals(text)) {
                    output.setText(text);
                    catImage.setVisibility(View.VISIBLE);
                } else {
                    output.setText("Hallo World!");
                    catImage.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "The password is wrong", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }
}
