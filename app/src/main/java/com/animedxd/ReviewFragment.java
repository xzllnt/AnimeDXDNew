package com.animedxd;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReviewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReviewFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ReviewFragment() {
        // Required empty public constructor
    }

    public interface OnPostReviewClickListener {
        void onPostReviewClicked();
    }

    private OnPostReviewClickListener callback;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnPostReviewClickListener) {
            callback = (OnPostReviewClickListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnPostReviewClickListener");
        }
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ReviewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ReviewFragment newInstance(String param1, String param2) {
        ReviewFragment fragment = new ReviewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    RecyclerView reviewRecyclerView;
    ReviewAdapter reviewAdapter;
    List<ReviewItem> reviewList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_review, container, false);

        reviewRecyclerView = view.findViewById(R.id.reviewRecyclerView);
        reviewRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Dummy data
        reviewList = new ArrayList<>();
        reviewList.add(new ReviewItem(R.drawable.logo, "Shean", 4.5f, "Lorem ipsum dolor sit amet, consectetur adipiscing"));
        reviewList.add(new ReviewItem(R.drawable.logo, "Excel", 3.0f, "Lorem ipsum dolor sit amet, consectetur adipiscing"));
        reviewList.add(new ReviewItem(R.drawable.logo, "Eric", 5.0f, "Lorem ipsum dolor sit amet, consectetur adipiscing"));
        reviewList.add(new ReviewItem(R.drawable.logo, "Yehuda", 4.0f, "Lorem ipsum dolor sit amet, consectetur adipiscing"));

        reviewAdapter = new ReviewAdapter(reviewList);
        reviewRecyclerView.setAdapter(reviewAdapter);

        Button btnPostReview = view.findViewById(R.id.btnPostReview);
        btnPostReview.setOnClickListener(v -> {
            if (callback != null) {
                showReviewOverlay();
            }
        });

        return view;
    }

    private void showReviewOverlay() {
        LayoutInflater inflater = LayoutInflater.from(requireContext());
        View overlayView = inflater.inflate(R.layout.popup_post_review, null);

        // Ini bagian penting untuk dapatkan root view dari activity
        ViewGroup rootView = (ViewGroup) requireActivity().getWindow().getDecorView().getRootView();
        rootView.addView(overlayView);

        // Klik luar (area gelap)
        overlayView.setOnTouchListener((v, event) -> {
            View dialogCard = overlayView.findViewById(R.id.dialogCard);
            if (isTouchOutsideView(dialogCard, event)) {
                rootView.removeView(overlayView);
                return true;
            }
            return false;
        });

        // Cegah klik dalam dialog menutup overlay
        View dialogCard = overlayView.findViewById(R.id.dialogCard);
        dialogCard.setOnClickListener(v -> {
            // Jangan biarkan klik masuk propagate
        });

        // Tombol X
        ImageView closeBtn = overlayView.findViewById(R.id.btnCloseDialog);


        closeBtn.setOnClickListener(v -> {
            rootView.removeView(overlayView);
        });

        // Tombol Post
        Button postBtn = overlayView.findViewById(R.id.btnPostDialog);
        postBtn.setOnClickListener(v -> {
            EditText etRating = overlayView.findViewById(R.id.etRating);
            EditText etReview = overlayView.findViewById(R.id.etReview);
            TextView tvRatingError = overlayView.findViewById(R.id.tvRatingError);
            TextView tvReviewError = overlayView.findViewById(R.id.tvReviewError);

            String ratingStr = etRating.getText().toString().trim();
            String review = etReview.getText().toString().trim();

            boolean isValid = true;
            tvRatingError.setVisibility(View.GONE);
            tvReviewError.setVisibility(View.GONE);

            if (ratingStr.isEmpty()) {
                tvRatingError.setText("Rating cannot be null");
                tvRatingError.setVisibility(View.VISIBLE);
                isValid = false;
            } else {
                try {
                    float rating = Float.parseFloat(ratingStr);
                    if (rating < 1 || rating > 5) {
                        tvRatingError.setText("Rating must be between 1 and 5");
                        tvRatingError.setVisibility(View.VISIBLE);
                        isValid = false;
                    }
                } catch (NumberFormatException e) {
                    tvRatingError.setText("Rating must be a number");
                    tvRatingError.setVisibility(View.VISIBLE);
                    isValid = false;
                }
            }

            if (review.isEmpty()) {
                tvReviewError.setText("Review cannot be null");
                tvReviewError.setVisibility(View.VISIBLE);
                isValid = false;
            }

            if (isValid) {
                float rating = Float.parseFloat(ratingStr);
                ReviewItem newItem = new ReviewItem(
                        R.drawable.logo, // Ganti dengan user profile image kalau ada
                        "You", // Ganti sesuai nama user
                        rating,
                        review
                );

                reviewList.add(newItem);
                reviewAdapter.notifyItemInserted(reviewList.size() - 1);
                reviewRecyclerView.scrollToPosition(reviewList.size() - 1);

                Toast.makeText(requireContext(), "Posted!\nRating: " + ratingStr + "\nReview: " + review, Toast.LENGTH_SHORT).show();
                rootView.removeView(overlayView);
            }
        });
    }
    private boolean isTouchOutsideView(View view, MotionEvent event) {
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        float x = event.getRawX();
        float y = event.getRawY();

        return !(x >= location[0] && x <= location[0] + view.getWidth() &&
                y >= location[1] && y <= location[1] + view.getHeight());
    }

}