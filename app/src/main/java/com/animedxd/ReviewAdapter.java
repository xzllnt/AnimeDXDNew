package com.animedxd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {

    private List<ReviewItem> reviewList;

    public ReviewAdapter(List<ReviewItem> reviewList) {
        this.reviewList = reviewList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_review, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ReviewItem item = reviewList.get(position);
        holder.imgReviewer.setImageResource(item.getImageResId());
        holder.txtName.setText(item.getName());
        holder.txtRating.setText(item.getRating() + " ★★★★★");
        holder.txtReview.setText(item.getReviewText());
    }   

    @Override
    public int getItemCount() {
        return reviewList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgReviewer;
        TextView txtName, txtRating, txtReview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgReviewer = itemView.findViewById(R.id.imgReviewer);
            txtName = itemView.findViewById(R.id.txtName);
            txtRating = itemView.findViewById(R.id.txtRating);
            txtReview = itemView.findViewById(R.id.txtReview);
        }
    }
}
