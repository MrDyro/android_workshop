package com.myfirstapp.myfirstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class AnimalImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_image);

        final int firstImageResId = getIntent().getIntExtra(Constants.IMAGE_RES_ID, 0);
        final int secondImageResId;

        if (firstImageResId == R.drawable.cat) {
            secondImageResId = R.drawable.dog;
        } else {
            secondImageResId = R.drawable.cat;
        }

        final Bundle bundleOne = new Bundle();
        bundleOne.putInt(Constants.IMAGE_RES_ID, firstImageResId);

        final AnimalImageFragment fragmentOne = new AnimalImageFragment();
        fragmentOne.setArguments(bundleOne);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.containerOne, fragmentOne)
                .commit();

        final Bundle bundleTwo = new Bundle();
        bundleTwo.putInt(Constants.IMAGE_RES_ID, secondImageResId);

        final AnimalImageFragment fragmentTwo = new AnimalImageFragment();
        fragmentTwo.setArguments(bundleTwo);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.containerTwo, fragmentTwo)
                .commit();
    }
}
