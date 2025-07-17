package com.animedxd;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.HorizontalScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private Button newsButton, mangaButton;
    private FrameLayout tabContent;
    private RecyclerView mangaRecyclerView;

    private List<Integer> newsImages;
    private List<MangaItem> mangaList;

    private Handler sliderHandler = new Handler(Looper.getMainLooper());
    private Runnable sliderRunnable;
    private int currentPage = 0;

    private TextView greetingText;
    private TextView mangaTrendingSection;
    private HorizontalScrollView mangaScroll;
    private View bannerControls;
    private ViewPager2 bannerViewPager;
    private ImageButton prevButton, nextButton;

    private MangaAdapter mangaAdapter;

    public HomeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        greetingText = view.findViewById(R.id.greetingText);
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "User");
        greetingText.setText("Welcome, " + username);

        newsButton = view.findViewById(R.id.newsButton1);
        mangaButton = view.findViewById(R.id.mangaButton1);
        tabContent = view.findViewById(R.id.tabContent1);

        mangaTrendingSection = view.findViewById(R.id.mangaTrendingSection);
        mangaScroll = view.findViewById(R.id.mangaScroll);
        bannerControls = view.findViewById(R.id.bannerControls);
        bannerViewPager = view.findViewById(R.id.bannerViewPager);
        prevButton = view.findViewById(R.id.prevButton);
        nextButton = view.findViewById(R.id.nextButton);

        initNewsData();
        initMangaData();

        setupNewsTab();
        setTabState(true);
        showTrendingViews(true);

        newsButton.setOnClickListener(v -> {
            setupNewsTab();
            setTabState(true);
            showTrendingViews(true);
        });

        mangaButton.setOnClickListener(v -> {
            setupMangaTab();
            setTabState(false);
            showTrendingViews(false);
        });

        setupBannerCarousel();
    }

    private void initNewsData() {
        newsImages = new ArrayList<>();
        newsImages.add(R.drawable.ss1);
        newsImages.add(R.drawable.ss2);
        newsImages.add(R.drawable.ss3);
    }

    private void initMangaData() {
        mangaList = new ArrayList<>();
        mangaList.add(new MangaItem(R.drawable.manga_onepiece, "One Piece", "Petualangan Luffy mencari harta karun legendaris One Piece."));
        mangaList.add(new MangaItem(R.drawable.manga_jujutsu, "Jujutsu Kaisen", "Itadori Yuji bertarung melawan kutukan demi teman-temannya."));
        mangaList.add(new MangaItem(R.drawable.manga_drstone, "Dr. Stone", "Senku bangkitkan dunia dengan ilmu sains."));
        mangaList.add(new MangaItem(R.drawable.manga_bokunohero, "My Hero Academia", "Manusia bertahan hidup dari raksasa pemakan manusia."));
        mangaList.add(new MangaItem(R.drawable.manga_blackclover, "Black Clover", "Asta dan Yuno berjuang menjadi Kaisar Sihir."));
    }

    private void setupNewsTab() {
        tabContent.removeAllViews();
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    private void setupMangaTab() {
        tabContent.removeAllViews();
        sliderHandler.removeCallbacks(sliderRunnable);

        mangaRecyclerView = new RecyclerView(requireContext());
        mangaRecyclerView.setLayoutParams(new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        mangaRecyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        mangaAdapter = new MangaAdapter(mangaList);
        mangaRecyclerView.setAdapter(mangaAdapter);

        tabContent.addView(mangaRecyclerView);
    }

    private void setTabState(boolean isNewsSelected) {
        if (isNewsSelected) {
            newsButton.setBackgroundResource(R.drawable.bg_tab_selected_left);
            mangaButton.setBackgroundResource(R.drawable.bg_tab_unselected_right);
        } else {
            newsButton.setBackgroundResource(R.drawable.bg_tab_unselected_left);
            mangaButton.setBackgroundResource(R.drawable.bg_tab_selected_right);
        }
    }

    private void showTrendingViews(boolean show) {
        int visibility = show ? View.VISIBLE : View.GONE;

        if (mangaTrendingSection != null)
            mangaTrendingSection.setVisibility(visibility);
        if (mangaScroll != null)
            mangaScroll.setVisibility(visibility);
        if (bannerControls != null)
            bannerControls.setVisibility(visibility);
        if (bannerViewPager != null)
            bannerViewPager.setVisibility(visibility);
    }

    private void setupBannerCarousel() {
        NewsAdapter newsAdapter = new NewsAdapter(newsImages);
        bannerViewPager.setAdapter(newsAdapter);

        prevButton.setOnClickListener(v -> {
            int current = bannerViewPager.getCurrentItem();
            int prev = current - 1 < 0 ? newsImages.size() - 1 : current - 1;
            bannerViewPager.setCurrentItem(prev, true);
        });

        nextButton.setOnClickListener(v -> {
            int current = bannerViewPager.getCurrentItem();
            int next = (current + 1) % newsImages.size();
            bannerViewPager.setCurrentItem(next, true);
        });

        sliderRunnable = new Runnable() {
            @Override
            public void run() {
                int next = (bannerViewPager.getCurrentItem() + 1) % newsImages.size();
                bannerViewPager.setCurrentItem(next, true);
                sliderHandler.postDelayed(this, 3000);
            }
        };
        sliderHandler.postDelayed(sliderRunnable, 3000);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        sliderHandler.removeCallbacks(sliderRunnable);
    }
}
