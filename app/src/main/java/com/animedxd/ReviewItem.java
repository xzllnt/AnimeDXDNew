package com.animedxd;

public class ReviewItem {
    public int profileImageResId;
    public String reviewerName;
    public float rating;
    public String reviewText;

    public ReviewItem(int profileImageResId, String reviewerName, float rating, String reviewText) {
        this.profileImageResId = profileImageResId;
        this.reviewerName = reviewerName;
        this.rating = rating;
        this.reviewText = reviewText;
    }
}
