package com.animedxd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MangaAdapter extends RecyclerView.Adapter<MangaAdapter.MangaViewHolder> {

    protected List<MangaItem> mangaList;

    public MangaAdapter(List<MangaItem> mangaList) {
        this.mangaList = mangaList;
    }

    public void updateData(List<MangaItem> newList) {
        this.mangaList = newList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MangaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_manga, parent, false);
        return new MangaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MangaViewHolder holder, int position) {
        MangaItem item = mangaList.get(position);
        holder.mangaImage.setImageResource(item.imageResId);
        holder.mangaTitle.setText(item.title);
        holder.mangaDescription.setText(item.description);
    }

    @Override
    public int getItemCount() {
        return mangaList.size();
    }

    public static class MangaViewHolder extends RecyclerView.ViewHolder {
        ImageView mangaImage;
        TextView mangaTitle, mangaDescription;

        public MangaViewHolder(@NonNull View itemView) {
            super(itemView);
            mangaImage = itemView.findViewById(R.id.mangaImage);
            mangaTitle = itemView.findViewById(R.id.mangaTitle);
            mangaDescription = itemView.findViewById(R.id.mangaDescription);
        }
    }
}
