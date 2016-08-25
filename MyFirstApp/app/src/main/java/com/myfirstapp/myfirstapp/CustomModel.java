package com.myfirstapp.myfirstapp;

public class CustomModel {

    private final String imageUrl;
    private final String query;
    private final String text;

    public CustomModel(final String text,
                       final String imageUrl,
                       final String query) {

        this.text = text;
        this.imageUrl = imageUrl;
        this.query = query;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getQuery() {
        return query;
    }

    public String getText() {
        return text;
    }
}
