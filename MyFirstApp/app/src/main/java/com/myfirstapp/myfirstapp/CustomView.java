package com.myfirstapp.myfirstapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomView extends FrameLayout {

    private ImageView imageView;
    private TextView textView;

    public CustomView(final Context context) {
        this(context, null);
    }

    public CustomView(final Context context, final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        final View view = LayoutInflater.from(context)
                .inflate(R.layout.custom_view, this, true);

        imageView = (ImageView) view.findViewById(R.id.imageView);
        textView = (TextView) view.findViewById(R.id.textView);
    }

    public void setImage(int imageResId) {
        imageView.setImageResource(imageResId);
    }

    public void setText(final String text) {
        textView.setText(text);
    }
}
