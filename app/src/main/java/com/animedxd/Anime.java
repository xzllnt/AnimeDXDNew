package com.animedxd;

import java.util.List;

public class Anime {
    public int id;
    public String title;
    public String genre;
    public String shortDesc;
    public String longDesc;
    public int yearReleased;
    public String season;
    public int episodes;
    public String studio;
    public float rating;
    public List<Review> reviews;
    public int imageResId;
    public int bannerImageResId;

    public Anime(int id, String title, String genre, String shortDesc, String longDesc,
                 int yearReleased, String season, int episodes, String studio,
                 float rating, List<Review> reviews,
                 int imageResId, int bannerImageResId) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.yearReleased = yearReleased;
        this.season = season;
        this.episodes = episodes;
        this.studio = studio;
        this.rating = rating;
        this.reviews = reviews;
        this.imageResId = imageResId;
        this.bannerImageResId = bannerImageResId;
    }

    // ✅ Tambahkan getter
    public int getId() {
        return id;
    }

    public String getLongDesc() {
        return longDesc;
    }

    // Kalau kamu pakai field lain di tempat lain, kamu juga bisa tambahkan getter-nya:
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public int getYear() { return yearReleased; }
    public String getSeason() { return season; }
    public int getEpisodes() { return episodes; }
    public String getStudio() { return studio; }
    public double getRating() { return rating; }
    public int getImageResId() { return imageResId; }
    public int getBannerResId() { return bannerImageResId; }

    public static class Review {

        public String name;
        public double rating;
        public String testimoni;

        public Review(String name, double rating, String testimoni) {
            this.name = name;
            this.rating = rating;
            this.testimoni = testimoni;
        }
    }
}

