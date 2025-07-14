package com.animedxd;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

    private RecyclerView recyclerRecent, recyclerFavorite;
    private AnimeAdapter animeAdapter;
    private List<Anime> animeList, favoriteList;

    public ListFragment() {
        // Konstruktor kosong
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate layout fragment_list.xml
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        // 1. Cari RecyclerView
        recyclerRecent = view.findViewById(R.id.recyclerRecent);
        recyclerRecent.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        // 2. Buat data anime
        animeList = new ArrayList<>();
        animeList.add(new Anime("Assassination Classroom", "Genre: Action, Comedy, School, Sci-fi", "Siswa ditugaskan membunuh guru alien sebelum ia hancurkan Bumi, sambil belajar arti kehidupan.", R.drawable.poster_assassinationclassroom));
        animeList.add(new Anime("Tensei Shitara Slime Datta Ken", "Genre: Isekai, Fantasy, Adventure", "Pria bereinkarnasi jadi slime dan membangun kerajaan di dunia fantasi.", R.drawable.poster_tenseishitara));
        animeList.add(new Anime("Kyoukai no Kanata", "Genre: Action, Fantasy, Supernatural", "Pemuda bertemu gadis pengguna darah sebagai senjata dan terlibat konflik supernatural.", R.drawable.poster_kyokainokanata));
        animeList.add(new Anime("Kemono Jihen", "Genre: Action, Supernatural, Mystery", "Anak setengah monster jadi detektif makhluk gaib sambil mencari jati dirinya.", R.drawable.poster_kemonojihen));
        animeList.add(new Anime("Mashle", "Genre: Action, Comedy, Fantasy", "Di dunia sihir, Mash gunakan otot untuk bersaing di sekolah sihir elit", R.drawable.poster_mashle));
        // 3. Set adapter ke RecyclerView
        animeAdapter = new AnimeAdapter(getContext(), animeList);
        recyclerRecent.setAdapter(animeAdapter);

        // Favorite
        recyclerFavorite = view.findViewById(R.id.recyclerFavorite);
        recyclerFavorite.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        favoriteList = new ArrayList<>();
        favoriteList.add(new Anime("Black Clover", "Genre: Action, Fantasy, Magic", "Asta, anak tanpa sihir, bertekad jadi Kaisar Sihir bersama saingannya, Yuno.", R.drawable.poster_blackclover));
        favoriteList.add(new Anime("Dr. Stone", "Genre: Sci-Fi, Adventure, Shounen", "Senku bangkit di dunia batu dan membangun kembali peradaban dengan ilmu sains.", R.drawable.poster_drstone2));
        favoriteList.add(new Anime("Boku no Hero Academia", "Genre: Action, Superhero, Sci-Fi", "Midoriya, anak tanpa kekuatan, mewarisi quirk dan bercita-cita jadi pahlawan top.", R.drawable.poster_bnh));
        favoriteList.add(new Anime("One Piece", "Genre: Action, Adventure, Fantasy", "Luffy dan kru mencari harta karun legendaris demi jadi Raja Bajak Laut.", R.drawable.poster_onepiece2));
        favoriteList.add(new Anime("Jujutsu Kaisen", "Genre: Action, Supernatural, Shounen", "Itadori bergabung dengan sekolah Jujutsu setelah menelan roh terkutuk Sukuna.", R.drawable.poster_jujutsukaisen2));
        AnimeAdapter favoriteAdapter = new AnimeAdapter(getContext(), favoriteList);
        recyclerFavorite.setAdapter(favoriteAdapter);

        return view;
    }
}
