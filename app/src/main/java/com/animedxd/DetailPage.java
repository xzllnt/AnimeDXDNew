package com.animedxd;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class DetailPage extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager;
    ViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        // ✅ Set adapter
        adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        // ✅ Hubungkan TabLayout dengan ViewPager
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            if (position == 0) {
                tab.setText("Synopsis");
            } else if (position == 1) {
                tab.setText("Review");
            }
        }).attach();
    }

    private void showPostReviewDialog() {
        // Inflate dialog layout
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_post_review, null);

        // Ambil komponen dalam dialog
        EditText etRating = dialogView.findViewById(R.id.etRating);
        EditText etReview = dialogView.findViewById(R.id.etReview);
        Button btnPostDialog = dialogView.findViewById(R.id.btnPostDialog);

        // Buat dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(DetailActivity.this);
        builder.setView(dialogView);
        AlertDialog dialog = builder.create();

        // Biar transparan (hilang frame putih)
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }

        // Handle tombol "Post" di dialog
        btnPostDialog.setOnClickListener(view -> {
            String rating = etRating.getText().toString().trim();
            String review = etReview.getText().toString().trim();

            if (rating.isEmpty() || review.isEmpty()) {
                Toast.makeText(DetailActivity.this, "Please fill both fields.", Toast.LENGTH_SHORT).show();
            } else {
                // Bisa simpan ke database atau kirim ke server di sini
                Toast.makeText(DetailActivity.this, "Rating: " + rating + "\nReview: " + review, Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}