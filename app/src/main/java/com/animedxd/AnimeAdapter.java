package com.animedxd;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.ViewHolder> {
    private Context context;
    private List<Anime> animeList;

    public AnimeAdapter(Context context, List<Anime> animeList) {
        this.context = context;
        this.animeList = animeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_anime, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Anime anime = animeList.get(position);
        android.util.Log.d("DEBUG_AnimeAdapter", "onBindViewHolder: " + anime.title);
        holder.txtTitle.setText(anime.title);
        holder.txtGenre.setText("Genre: " + anime.genre);
        holder.txtDesc.setText(anime.shortDesc);
        holder.imgAnime.setImageResource(anime.imageResId);




        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailPage.class);
            intent.putExtra("anime_id", anime.getId());  // ✅ Kirim ID anime
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return animeList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAnime;
        TextView txtTitle, txtGenre, txtDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAnime = itemView.findViewById(R.id.animeImage);
            txtTitle = itemView.findViewById(R.id.txtTitleitem);
            txtGenre = itemView.findViewById(R.id.txtGenreitem);
            txtDesc = itemView.findViewById(R.id.txtDescitem);
        }
    }
}
