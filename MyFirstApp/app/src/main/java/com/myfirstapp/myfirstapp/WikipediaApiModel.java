package com.myfirstapp.myfirstapp;

import com.google.gson.annotations.SerializedName;

public class WikipediaApiModel {

    public static class Thumbnail {

        @SerializedName("source")
        private String imageUrl;

        public String getImageUrl() {
            return imageUrl;
        }
    }

    private String extract;
    private Thumbnail thumbnail;
    private String title;

    public String getExtract() {
        return extract;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public String getTitle() {
        return title;
    }
}

