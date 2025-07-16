package com.animedxd;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class DetailPage extends AppCompatActivity implements ReviewFragment.OnPostReviewClickListener {

    TabLayout tabLayout;
    ViewPager2 viewPager;
    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_page);

        // Ambil animeId dari Intent
        int animeId = getIntent().getIntExtra("anime_id", -1);

        // Ambil objek Anime berdasarkan ID
        Anime anime = AnimeData.getAnimeById(animeId);
        if (anime != null) {
            // Pasang data ke layout activity_detail_page.xml
            TextView titleView = findViewById(R.id.textView3);
            TextView yearView = findViewById(R.id.tvYear);
            TextView genreView = findViewById(R.id.tvGenre);
            TextView seasonView = findViewById(R.id.tvSeason);
            TextView episodeView = findViewById(R.id.tvEpisodes);
            TextView studioView = findViewById(R.id.tvStudio);
            TextView ratingTextView = findViewById(R.id.tvRating);
            RatingBar ratingBar = findViewById(R.id.ratingBar);
            ImageView coverView = findViewById(R.id.imageView12);
            ImageView bannerView = findViewById(R.id.imageView11);

            titleView.setText(anime.title);
            yearView.setText("Year: " + anime.yearReleased);
            genreView.setText("Genre: " + anime.genre);
            seasonView.setText("Season: " + anime.season);
            episodeView.setText("Episodes: " + anime.episodes);
            studioView.setText("Studio: " + anime.studio);
            ratingTextView.setText("Rating: " + anime.rating);
            ratingBar.setRating(anime.rating);

            coverView.setImageResource(anime.imageResId);
            if(titleView.getText() == "Kimi no Na wa") {
                bannerView.setImageResource(R.drawable.scene_kiminonawa);
            } else {
                bannerView.setImageResource(anime.bannerImageResId);
            }

        }

        // Handle Window Insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Setup ViewPager dan TabLayout
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        adapter = new ViewPagerAdapter(this, animeId); // Kirim ID ke adapter
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            if (position == 0) {
                tab.setText("Synopsis");
            } else if (position == 1) {
                tab.setText("Review");
            }
        }).attach();

        // Tombol Back
        FrameLayout backButtonContainer = findViewById(R.id.frameLayout);
        backButtonContainer.setOnClickListener(v -> {
            finish();
        });
    }

    @Override
    public void onPostReviewClicked() {
        showPostReviewDialog();
    }

    private void showPostReviewDialog() {
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.popup_post_review, null);

        EditText etRating = dialogView.findViewById(R.id.etRating);
        EditText etReview = dialogView.findViewById(R.id.etReview);
        Button btnPostDialog = dialogView.findViewById(R.id.btnPostDialog);

        AlertDialog.Builder builder = new AlertDialog.Builder(DetailPage.this);
        builder.setView(dialogView);
        AlertDialog dialog = builder.create();

        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }

        btnPostDialog.setOnClickListener(view -> {
            String rating = etRating.getText().toString().trim();
            String review = etReview.getText().toString().trim();

            if (rating.isEmpty() || review.isEmpty()) {
                Toast.makeText(DetailPage.this, "Please fill both fields.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(DetailPage.this, "Rating: " + rating + "\nReview: " + review, Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
