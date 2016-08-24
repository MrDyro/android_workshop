package com.myfirstapp.myfirstapp;

public class CustomModel {

    private final int imageResId;
    private final String text;

    public CustomModel(final String text, int imageResId) {
        this.text = text;
        this.imageResId = imageResId;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getText() {
        return text;
    }
}
