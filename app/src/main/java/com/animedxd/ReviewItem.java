package com.animedxd;

public class ReviewItem {
    private int imageResId;
    private String name;
    private float rating;
    private String reviewText;

    // Constructor
    public ReviewItem(int imageResId, String name, float rating, String reviewText) {
        this.imageResId = imageResId;
        this.name = name;
        this.rating = rating;
        this.reviewText = reviewText;
    }

    // Getters
    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }

    public float getRating() {
        return rating;
    }

    public String getReviewText() {
        return reviewText;
    }
}
