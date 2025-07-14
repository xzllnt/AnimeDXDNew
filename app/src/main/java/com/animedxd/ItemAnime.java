//package com.animedxd;
//
//import android.os.Bundle;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ItemAnime extends AppCompatActivity {
//
//    private RecyclerView recyclerRecent; // ganti sesuai id RecyclerView kamu
//    private AnimeAdapter animeAdapter;
//    private List<Anime> animeList;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_item_anime);
//
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//
//        // 🔽 1. Inisialisasi RecyclerView
//        recyclerRecent = findViewById(R.id.recyclerRecent); // pastikan ID sama seperti di XML kamu
//        recyclerRecent.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//
//        // 🔽 2. Buat list data anime
//        animeList = new ArrayList<>();
//        animeList.add(new Anime("Assassination Classroom", "Action, Comedy, School, Sci-fi", "Siswa ditugaskan membunuh guru alien sebelum ia hancurkan Bumi, sambil belajar arti kehidupan.", R.drawable.assassinatio));
//        animeList.add(new Anime("Tensei Shitara Slime Datta Ken", "Isekai, Fantasy, Adventure", "Pria bereinkarnasi jadi slime dan membangun kerajaan di dunia fantasi.", R.drawable.slime));
//        animeList.add(new Anime("Your Name", "Romance, Drama, Supernatural", "Kisah dua remaja yang bertukar tubuh dan mencari satu sama lain di waktu berbeda.", R.drawable.yourname));
//        animeList.add(new Anime("Naruto", "Action, Ninja", "Petualangan seorang ninja bernama Naruto yang bercita-cita jadi Hokage.", R.drawable.naruto));
//
//        // 🔽 3. Buat adapter dan sambungkan
//        animeAdapter = new AnimeAdapter(this, animeList);
//        recyclerRecent.setAdapter(animeAdapter);
//    }
//}
