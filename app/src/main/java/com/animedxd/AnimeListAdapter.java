package com.animedxd;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnimeListAdapter extends RecyclerView.Adapter<AnimeListAdapter.AnimeViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Anime anime);
    }

    private final Context context;
    private final List<Anime> animeList;
    private final OnItemClickListener listener;

    // Constructor utama
    public AnimeListAdapter(Context context, List<Anime> animeList) {
        this.context = context;
        this.animeList = animeList;
        this.listener = anime -> {
            Intent intent = new Intent(context, DetailPage.class);
            intent.putExtra("anime_id", anime.id);  // pastikan class Anime punya `public int id`
            context.startActivity(intent);
        };
    }

    @NonNull
    @Override
    public AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_anime, parent, false);
        return new AnimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeViewHolder holder, int position) {
        holder.bind(animeList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return animeList.size();
    }

    static class AnimeViewHolder extends RecyclerView.ViewHolder {
        TextView titleText, genreText;
        ImageView imageView;
        TextView descText;
        public AnimeViewHolder(@NonNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.txtTitleitem);
            genreText = itemView.findViewById(R.id.txtGenreitem);
            imageView = itemView.findViewById(R.id.animeImage);
            descText = itemView.findViewById(R.id.txtDescitem);
        }

        public void bind(final Anime anime, final OnItemClickListener listener) {
            titleText.setText(anime.title);
            genreText.setText("Genre: " + anime.genre);

            imageView.setImageResource(anime.imageResId); // Make sure mainImageResId is valid drawable
            itemView.setOnClickListener(v -> {
                // Simpan animeId ke SharedPreferences
                SharedPreferences prefs = itemView.getContext().getSharedPreferences("AnimePrefs", Context.MODE_PRIVATE);
                prefs.edit().putInt("selected_anime_id", anime.id).apply();

                // Lanjut ke DetailPage
                Intent intent = new Intent(itemView.getContext(), DetailPage.class);
                itemView.getContext().startActivity(intent);
            });
            descText.setText(anime.shortDesc);
        }
    }
}
