package com.animedxd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.ViewGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

public class HomeActivity extends AppCompatActivity {

    private ConstraintLayout mainLayout;

    private ImageView homeIcon;
    private ImageView bookIcon;
    private ImageView infoIcon;

    private ImageView navSelector;
    private ImageButton menuButton;
    private ImageView closeDropdown;
    private ConstraintLayout dropdownMenu;
    private TextView logoutText;

    private View overlayView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mainLayout = findViewById(R.id.main);
        menuButton = findViewById(R.id.menuButton);
        closeDropdown = findViewById(R.id.closeDropdown);
        dropdownMenu = findViewById(R.id.dropdownMenu);
        logoutText = findViewById(R.id.logoutText);

        navSelector = findViewById(R.id.navSelector);
        overlayView = findViewById(R.id.overlayView);

        menuButton.setOnClickListener(v -> {
            overlayView.setVisibility(View.VISIBLE);
            dropdownMenu.setVisibility(View.VISIBLE);
            dropdownMenu.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_down));
        });

        closeDropdown.setOnClickListener(v -> closeDropdownWithAnimation());

        overlayView.setOnClickListener(v -> closeDropdownWithAnimation());

        logoutText.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });

        mainLayout.setOnTouchListener((v, event) -> {
            if (dropdownMenu.getVisibility() == View.VISIBLE) {
                closeDropdownWithAnimation();
                return true;
            }
            return false;
        });

        homeIcon = findViewById(R.id.homeIcon);
        bookIcon = findViewById(R.id.bookIcon);
        infoIcon = findViewById(R.id.infoIcon);

        homeIcon.setOnClickListener(v -> {
            loadFragment(new HomeFragment());
            setActiveNav("home");
        });

        bookIcon.setOnClickListener(v -> {
            loadFragment(new ListFragment());
            setActiveNav("book");
        });

        infoIcon.setOnClickListener(v -> {
            loadFragment(new AboutFragment());
            setActiveNav("info");
        });

        loadFragment(new HomeFragment());
        setActiveNav("home");
    }

    private void closeDropdownWithAnimation() {
        Animation slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        slideUp.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                dropdownMenu.setVisibility(View.GONE);
                overlayView.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
        dropdownMenu.startAnimation(slideUp);
    }

    private void setActiveNav(String active) {
        ImageView homeIcon = findViewById(R.id.homeIcon);
        ImageView bookIcon = findViewById(R.id.bookIcon);
        ImageView infoIcon = findViewById(R.id.infoIcon);

        homeIcon.setImageResource(R.drawable.nav_home_selector);
        bookIcon.setImageResource(R.drawable.ic_book);
        infoIcon.setImageResource(R.drawable.ic_info);
        homeIcon.setBackground(null);
        bookIcon.setBackground(null);
        infoIcon.setBackground(null);

        homeIcon.setTranslationY(80);
        bookIcon.setTranslationY(0);
        infoIcon.setTranslationY(0);

        int activeSize = (int) (88 * getResources().getDisplayMetrics().density);
        int notactiveSize = (int) (60 * getResources().getDisplayMetrics().density);

        ViewGroup.LayoutParams homeParams = homeIcon.getLayoutParams();
        ViewGroup.LayoutParams bookParams = bookIcon.getLayoutParams();
        ViewGroup.LayoutParams infoParams = infoIcon.getLayoutParams();

        homeParams.width = notactiveSize + 20;
        homeParams.height = notactiveSize + 20;
        bookParams.width = notactiveSize;
        bookParams.height = notactiveSize;
        infoParams.width = notactiveSize;
        infoParams.height = notactiveSize;

        switch (active) {
            case "home":
                homeIcon.setImageResource(R.drawable.ic_home);
                homeIcon.animate().translationY(-20).setDuration(200).start();
                homeParams.width = activeSize;
                homeParams.height = activeSize;
                homeIcon.post(() -> moveSelectorTo(homeIcon));
                break;
            case "book":
                bookIcon.setImageResource(R.drawable.book_active);
                bookIcon.animate().translationY(-40).setDuration(200).start();
                bookParams.width = activeSize;
                bookParams.height = activeSize;
                bookIcon.post(() -> moveSelectorTo(bookIcon));
                break;
            case "info":
                infoIcon.setImageResource(R.drawable.info_active);
                infoIcon.animate().translationY(-107).setDuration(200).start();
                infoParams.width = activeSize;
                infoParams.height = activeSize;
                infoIcon.post(() -> moveSelectorTo(infoIcon));
                break;
        }

        homeIcon.setLayoutParams(homeParams);
        bookIcon.setLayoutParams(bookParams);
        infoIcon.setLayoutParams(infoParams);
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }

    private void moveSelectorTo(View target) {
        navSelector.animate()
                .x(target.getX() + target.getWidth() / 2f - navSelector.getWidth() / 2f)
                .setDuration(300)
                .start();
    }
}
