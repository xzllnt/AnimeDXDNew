package com.animedxd;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class ListFragment extends Fragment {

    private RecyclerView recyclerRecent, recyclerFavorite;

    private ImageView bannerBackground;
    private TextView bannerTitle, bannerDesc;

    public ListFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        // 1. Ambil referensi dari XML
        bannerBackground = view.findViewById(R.id.bannerBackground);
        bannerTitle = view.findViewById(R.id.bannerTitle);
        bannerDesc = view.findViewById(R.id.bannerDesc);

        // 2. Ambil data anime ID 11
        Anime anime = AnimeData.getAnimeById(11);
        if (anime != null) {
            bannerTitle.setText(anime.title);
            bannerDesc.setText(anime.shortDesc);
            bannerBackground.setImageResource(R.drawable.scene_kiminonawa);
        }

        // 3. Buat banner bisa diklik → buka DetailPage
        FrameLayout bannerLayout = view.findViewById(R.id.bannerContainer);
        bannerLayout.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), DetailPage.class);
            intent.putExtra("anime_id", 11);
            startActivity(intent);
        });

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerRecent = view.findViewById(R.id.recyclerRecent);
        recyclerFavorite = view.findViewById(R.id.recyclerFavorite);

        Anime kimiNoNawa = AnimeData.getAnimeById(11);
        if (kimiNoNawa != null) {
            bannerBackground.setImageResource(kimiNoNawa.bannerImageResId);
            bannerTitle.setText(kimiNoNawa.title);
            bannerDesc.setText(kimiNoNawa.shortDesc);
        }

        // Adapter & layout untuk Most Recent
        AnimeAdapter adapterRecent = new AnimeAdapter(getContext(), AnimeData.getMostRecentAnimes());
        recyclerRecent.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerRecent.setAdapter(adapterRecent);

        // Adapter & layout untuk Favorite
        AnimeAdapter adapterFavorite = new AnimeAdapter(getContext(), AnimeData.getFavoriteAnimes());
        recyclerFavorite.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerFavorite.setAdapter(adapterFavorite);
    }
}
