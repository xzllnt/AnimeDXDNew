package com.animedxd;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SynopsisFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SynopsisFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters

    private int animeId;
    private Anime anime;


    public SynopsisFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static SynopsisFragment newInstance(int animeId) {
        SynopsisFragment fragment = new SynopsisFragment();
        Bundle args = new Bundle();
        args.putInt("anime_id", animeId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Ambil animeId dari Bundle
        if (getArguments() != null) {
            animeId = getArguments().getInt("anime_id", -1);
            anime = AnimeData.getAnimeById(animeId);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_synopsis, container, false);

        TextView synopsisTextView = view.findViewById(R.id.txtSynopsis);
        Anime anime = AnimeData.getAnimeById(animeId);

        if (anime != null) {
            synopsisTextView.setText(anime.longDesc);
        }

        return view;
    }

}