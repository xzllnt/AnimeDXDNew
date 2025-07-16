package com.animedxd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnimeData {
    public static List<Anime> animeList = new ArrayList<>();

    static {
        animeList.add(new Anime(
                1,
                "Assassination Classroom",
                "Genre: Action, Comedy, School, Sci-fi",
                "Siswa ditugaskan membunuh guru alien sebelum ia hancurkan Bumi, sambil belajar arti kehidupan.",
                "Di sebuah sekolah menengah bernama Kunugigaoka, kelas 3-E terkenal sebagai tempat pembuangan bagi siswa yang dianggap gagal secara akademik atau perilaku. Suatu hari, kelas ini mendapatkan guru baru yang sangat tidak biasa: makhluk misterius berbentuk gurita berwarna kuning dengan kecepatan luar biasa dan kekuatan destruktif yang dahsyat. Makhluk tersebut, yang kemudian dijuluki “Koro-sensei,” mengklaim telah menghancurkan sebagian besar bulan dan berencana melakukan hal yang sama terhadap Bumi dalam waktu satu tahun. Namun, sebelum itu terjadi, ia memberikan kesempatan kepada para siswa kelas 3-E untuk membunuhnya — sambil mengajarkan mereka sebagai guru yang tulus dan penuh perhatian.\n" +
                        "\n" +
                        "Meski memiliki penampilan dan ancaman yang mengerikan, Koro-sensei justru menjadi guru terbaik yang pernah dimiliki para siswa kelas 3-E. Ia mengajarkan mereka tidak hanya pelajaran akademis dan teknik membunuh, tetapi juga nilai-nilai kehidupan, kepercayaan diri, dan pentingnya kerja sama tim. Seiring waktu, hubungan antara Koro-sensei dan para muridnya tumbuh menjadi ikatan yang sangat emosional dan dalam. Para siswa pun mulai menghadapi dilema batin: antara tugas mereka untuk membunuh gurunya demi menyelamatkan dunia, atau mempertahankan satu-satunya sosok yang benar-benar mempercayai mereka.\n" +
                        "\n" +
                        "Assassination Classroom menyajikan perpaduan unik antara komedi, aksi, dan drama emosional yang menyentuh hati. Anime ini menggali berbagai tema mendalam seperti pendidikan, pengorbanan, penerimaan diri, dan arti sebenarnya dari pertumbuhan. Dengan alur cerita yang kuat, karakter-karakter yang berkembang pesat, dan pesan moral yang menggugah, Assassination Classroom menjadi salah satu anime yang tak hanya menghibur, tetapi juga meninggalkan kesan mendalam bagi para penontonnya.",
                2015,
                "Winter",
                22,
                "Lerche",
                4.0f,
                Arrays.asList(
                        new Anime.Review("Yuki", 5.0, "Cerita dan karakternya sangat menyentuh hati!"),
                        new Anime.Review("Taro", 4.8, "Konflik batinnya dalam, bikin mikir.")
                ),
                R.drawable.poster_assassinationclassroom,
                R.drawable.scene_assassinationclassroom
        ));

        animeList.add(new Anime(
                2,
                "Tensei Shitara Slime Datta Ken",
                "Genre: Isekai, Fantasy, Action",
                "Seorang pria bereinkarnasi sebagai slime dan membangun kerajaan monster damai.",
                "Satoru Mikami, seorang pekerja kantoran biasa, terbunuh secara tragis dan bereinkarnasi di dunia lain sebagai slime dengan kemampuan unik untuk meniru kekuatan makhluk lain. Kini bernama Rimuru Tempest, ia memulai petualangan untuk menciptakan tempat di mana semua makhluk dapat hidup bersama secara damai.\n" +
                        "\n" +
                        "Dengan kecerdasan dan kekuatannya, Rimuru membentuk aliansi dengan berbagai ras monster, mendirikan negara Tempest, dan menjadi pemimpin karismatik. Namun, ambisinya untuk perdamaian tidak datang tanpa tantangan — ia harus menghadapi musuh kuat, politik kerajaan, dan ancaman dunia lain.\n" +
                        "\n" +
                        "Anime ini menampilkan pertumbuhan karakter yang kuat, dunia fantasi yang luas, dan pertarungan epik. Melalui petualangan Rimuru, penonton diajak menyelami tema tentang toleransi, persahabatan, dan makna kekuasaan sejati dalam membangun masa depan yang lebih baik.",
                2018,
                "Fall",
                24,
                "Eight Bit",
                4.2f,
                Arrays.asList(
                        new Anime.Review("Mika", 5.0, "Dunianya luas dan sangat menarik."),
                        new Anime.Review("Ryo", 4.5, "Slime OP tapi seru banget!")
                ),
                R.drawable.poster_tenseishitara,
                R.drawable.scene_tenseishitara
        ));

        animeList.add(new Anime(
                3,
                "Kyoukai no Kanata",
                "Genre: Fantasy, Supernatural, Drama",
                "Pemburu roh bertemu pemuda abadi dalam konflik antara manusia dan youmu.",
                "Mirai Kuriyama adalah gadis pemalu yang berasal dari klan pemburu youmu dan memiliki kemampuan mengendalikan darah. Ia bertemu Akihito Kanbara, seorang setengah-youmu yang tidak bisa mati, dan awalnya mencoba membunuhnya. Namun, pertemuan ini menjadi awal dari hubungan yang lebih dalam.\n" +
                        "\n" +
                        "Seiring mereka terlibat dalam pertempuran melawan youmu yang kuat, Mirai dan Akihito menghadapi konflik emosional dan trauma masa lalu. Persahabatan mereka tumbuh menjadi kasih sayang, meskipun takdir mereka tampaknya terus membawa kesedihan.\n" +
                        "\n" +
                        "Anime ini memadukan aksi supernatural dengan drama emosional yang kuat, disertai animasi memukau khas Kyoto Animation. Kyoukai no Kanata menyentuh tema penerimaan diri, kehilangan, dan pengorbanan dengan narasi yang mendalam dan estetika yang indah.",
                2013,
                "Fall",
                12,
                "Kyoto Animation",
                3.6f,
                Arrays.asList(
                        new Anime.Review("Aya", 4.3, "Visualnya cantik banget dan endingnya menyentuh."),
                        new Anime.Review("Ren", 3.5, "Ceritanya agak mellow tapi tetap keren.")
                ),
                R.drawable.poster_kyokainokanata,
                R.drawable.scene_kyokainokanata
        ));

        animeList.add(new Anime(
                4,
                "Kemono Jihen",
                "Genre: Supernatural, Mystery, Action",
                "Anak setengah youkai bergabung dalam agensi untuk menyelesaikan kasus misteri makhluk gaib.",
                "Di sebuah desa terpencil, seorang detektif bernama Inugami datang untuk menyelidiki kematian hewan yang mencurigakan. Ia bertemu dengan Kabane, seorang anak pendiam dan dijauhi yang ternyata merupakan setengah youkai. Inugami membawa Kabane ke Tokyo untuk bekerja di agensi detektif khusus kasus supernatural.\n" +
                        "\n" +
                        "Kabane dan rekan-rekan barunya menghadapi berbagai makhluk gaib dan konspirasi yang berakar pada masa lalu kelam mereka. Dalam tiap misi, mereka bukan hanya menyelesaikan kasus, tetapi juga mengungkap jati diri dan mempelajari arti keluarga dan kebersamaan.\n" +
                        "\n" +
                        "Anime ini memadukan aksi, misteri, dan emosi dengan visual gelap namun stylish. Kemono Jihen adalah kisah tentang keterasingan, penerimaan diri, dan perjuangan menjadi manusia meski darah monster mengalir dalam diri.",
                2021,
                "Winter",
                12,
                "Ajia-do",
                3.4f,
                Arrays.asList(
                        new Anime.Review("Shino", 4.0, "Unik dan menyentuh, apalagi kisah masa kecil Kabane."),
                        new Anime.Review("Leo", 3.8, "Animasinya oke dan jalan ceritanya bikin penasaran.")
                ),
                R.drawable.poster_kemonojihen,
                R.drawable.scene_kemonojihen
        ));

        animeList.add(new Anime(
                5,
                "Mashle",
                "Genre: Action, Comedy, Fantasy",
                "Pemuda tanpa sihir menantang sistem sihir dengan kekuatan otot.",
                "Mash Burnedead hidup di dunia yang menilai semua orang dari kekuatan sihir, padahal ia tak punya sedikit pun kemampuan sihir. Untuk melindungi hidup damainya, Mash masuk akademi sihir dengan misi menjadi Divine Visionary — posisi tertinggi dalam dunia sihir.\n" +
                        "\n" +
                        "Dengan kekuatan fisik yang luar biasa, Mash menghadapi ujian akademik, duel antar penyihir, dan diskriminasi sistemik. Namun ia tetap tenang, kocak, dan teguh pada prinsip, membuat teman sekaligus musuh heran.\n" +
                        "\n" +
                        "Mashle menyajikan aksi dan komedi absurd dalam satu paket, seperti kombinasi One Punch Man dan Harry Potter. Anime ini merayakan pentingnya tekad dan keberanian dalam melawan sistem yang tidak adil.",
                2023,
                "Spring",
                12,
                "A-1 Pictures",
                3.5f,
                Arrays.asList(
                        new Anime.Review("Fumi", 4.0, "Lucu dan penuh semangat, Mash karakter yang ikonik."),
                        new Anime.Review("Kenji", 3.2, "Suka gaya bertarung anti-mainstream-nya!")
                ),
                R.drawable.poster_mashle,
                R.drawable.scene_mashle
        ));


        animeList.add(new Anime(
                6,
                "Black Clover",
                "Genre: Action, Fantasy, Magic, Shounen",
                "Dua anak yatim bersaing menjadi Raja Penyihir meski satu tanpa sihir.",
                "Asta dan Yuno adalah dua anak yatim yang tumbuh di gereja desa terpencil dan bermimpi menjadi Raja Penyihir. Yuno berbakat dalam sihir, sedangkan Asta tidak memiliki kekuatan sihir sama sekali. Namun, Asta bertekad keras dan berlatih fisik dengan gigih.\n" +
                        "\n" +
                        "Saat mereka menerima grimoire, Yuno mendapatkan buku semanggi empat daun yang langka, sedangkan Asta mendapatkan buku semanggi lima daun misterius yang menyimpan kekuatan anti-sihir. Mereka memulai perjalanan sebagai Ksatria Sihir, menghadapi iblis, kerajaan, dan organisasi rahasia.\n" +
                        "\n" +
                        "Black Clover menawarkan pertarungan intens, pertumbuhan karakter yang konsisten, dan persaingan yang sehat penuh motivasi. Ini adalah kisah klasik tentang usaha, persahabatan, dan mimpi besar di tengah ketidakmungkinan.",
                2017,
                "Fall",
                170,
                "Studio Pierrot",
                2.1f,
                Arrays.asList(
                        new Anime.Review("Naoki", 4.0, "Pertarungannya epik banget, Asta luar biasa!"),
                        new Anime.Review("Mina", 2.5, "Slow start tapi makin lama makin seru.")
                ),
                R.drawable.poster_blackclover,
                R.drawable.scene_blackclover
        ));

        animeList.add(new Anime(
                7,
                "Dr. Stone",
                "Genre: Adventure, Sci-fi, Shounen",
                "Ilmuwan muda membangun kembali peradaban dari zaman batu dengan sains.",
                "Setelah fenomena misterius mengubah seluruh umat manusia menjadi batu, ribuan tahun kemudian Senku Ishigami terbangun dan bertekad mengembalikan peradaban dengan kekuatan sains.\n" +
                        "\n" +
                        "Senku memulai proyek ambisius untuk menciptakan kembali teknologi dari awal — mulai dari sabun hingga listrik — dan menyatukan kembali umat manusia yang terpecah. Namun, ia juga harus menghadapi musuh yang lebih memilih dunia primitif tanpa sains.\n" +
                        "\n" +
                        "Dr. Stone adalah perpaduan aksi, edukasi, dan petualangan dengan konsep unik dan karakter penuh semangat. Menunjukkan bagaimana ilmu pengetahuan bisa menjadi kekuatan yang membangun, bukan menghancurkan.",
                2019,
                "Summer",
                24,
                "TMS Entertainment",
                5f,
                Arrays.asList(
                        new Anime.Review("Hiro", 4.8, "Inspiratif dan edukatif, Senku itu jenius!"),
                        new Anime.Review("Rika", 3.0, "Belajar sains sambil nonton anime? Seru banget!")
                ),
                R.drawable.poster_drstone2,
                R.drawable.scene_drstone
        ));

        animeList.add(new Anime(
                8,
                "Boku no Hero Academia",
                "Genre: Action, Super Power, School, Shounen",
                "Remaja tanpa kekuatan mewarisi kekuatan terbesar dan berlatih jadi pahlawan.",
                "Izuku Midoriya lahir tanpa kekuatan di dunia di mana 80% manusia memilikinya, namun tetap bercita-cita menjadi pahlawan. Hidupnya berubah saat ia mewarisi One For All dari pahlawan legendaris All Might.\n" +
                        "\n" +
                        "Izuku masuk UA High School, sekolah para calon pahlawan, dan menjalani pelatihan berat serta menghadapi berbagai ancaman dari para villain. Bersama teman-temannya, ia belajar apa arti tanggung jawab sebagai pahlawan sejati.\n" +
                        "\n" +
                        "Anime ini penuh aksi seru, konflik emosional, dan perkembangan karakter yang dalam. Boku no Hero Academia adalah kisah perjuangan anak biasa dalam dunia luar biasa.",
                2016,
                "Spring",
                13,
                "Bones",
                3.3f,
                Arrays.asList(
                        new Anime.Review("DekuFan", 3.5, "Gak pernah bosen nonton ulang, Deku luar biasa!"),
                        new Anime.Review("Yuzu", 2.5, "Makin lama ceritanya makin dalem.")
                ),
                R.drawable.poster_bokunoheroacademia,
                R.drawable.scene_bokunoheroacademia
        ));


        animeList.add(new Anime(
                9,
                "One Piece",
                "Genre: Action, Adventure, Fantasy, Comedy",
                "Pemuda karet mengarungi lautan untuk menjadi Raja Bajak Laut.",
                "Monkey D. Luffy adalah remaja ceria yang memakan Buah Iblis dan menjadi manusia karet. Ia memulai petualangan besar mengarungi Grand Line untuk mencari harta karun legendaris One Piece dan menjadi Raja Bajak Laut.\n" +
                        "\n" +
                        "Bersama kru Topi Jerami yang ia kumpulkan dari berbagai latar belakang — termasuk pedang, navigator, dokter, dan koki — Luffy menghadapi angkatan laut, bajak laut lain, hingga pemerintah dunia. Masing-masing kru memiliki mimpi yang ingin mereka wujudkan.\n" +
                        "\n" +
                        "One Piece menyajikan dunia luas, cerita penuh misteri, dan tema tentang mimpi, persahabatan, dan kebebasan. Meski panjang, anime ini konsisten menghadirkan emosi, aksi, dan komedi dalam satu kesatuan yang solid.",
                1999,
                "Fall",
                1000,
                "Toei Animation",
                4.7f,
                Arrays.asList(
                        new Anime.Review("Zoro92", 5.0, "Petualangan terbaik yang pernah ada!"),
                        new Anime.Review("Lina", 4.0, "Gak kerasa udah nonton 500 episode. Worth it!")
                ),
                R.drawable.poster_onepiece2,
                R.drawable.scene_onepiece
        ));

        animeList.add(new Anime(
                10,
                "Jujutsu Kaisen",
                "Genre: Action, Supernatural, Dark Fantasy",
                "Remaja bertarung dengan kutukan setelah menelan jari iblis berbahaya.",
                "Yuji Itadori adalah siswa SMA biasa dengan fisik luar biasa. Suatu hari, ia menelan jari Sukuna, roh kutukan terkuat, untuk menyelamatkan temannya — menjadikannya wadah sang raja kutukan.\n" +
                        "\n" +
                        "Yuji bergabung dengan sekolah Jujutsu di bawah bimbingan Gojo Satoru dan bertarung melawan makhluk kutukan yang mengancam manusia. Ia harus menyeimbangkan kehidupan remaja, pelatihan keras, dan misi-misi berbahaya.\n" +
                        "\n" +
                        "Jujutsu Kaisen menonjol lewat animasi pertarungan luar biasa, karakter kompleks, dan nuansa gelap yang tetap menyelipkan humor. Dengan pacing cepat dan cerita menarik, anime ini menjadi favorit banyak penonton baru dan lama.",
                2020,
                "Fall",
                24,
                "MAPPA",
                4.6f,
                Arrays.asList(
                        new Anime.Review("Megumi", 4.2, "Satu kata: hype! Semua episodenya solid."),
                        new Anime.Review("Sora", 3.8, "Suka chemistry antara karakter dan dunia kutukannya.")
                ),
                R.drawable.poster_jujutsukaisen2,
                R.drawable.scene_jujutsukaisen
        ));

        animeList.add(new Anime(
                11,
                "Kimi no Na wa",
                "Genre: Drama, Supernatural, Romance",
                "Dua remaja bertukar tubuh lintas ruang dan waktu, mengubah takdir satu sama lain.",
                "Mitsuha Miyamizu adalah seorang siswi SMA di desa Itomori yang bosan dengan kehidupan pedesaannya dan berharap bisa hidup sebagai pria tampan di Tokyo. Taki Tachibana adalah siswa SMA di Tokyo yang menjalani kehidupan sibuk sebagai pelayan paruh waktu. Suatu hari, keduanya mulai mengalami fenomena aneh — mereka saling bertukar tubuh dalam tidur mereka.\n" +
                        "\n" +
                        "Melalui pesan yang ditinggalkan satu sama lain, mereka mulai membentuk hubungan unik dan akrab, meski belum pernah bertemu langsung. Namun, suatu hari fenomena itu berhenti, dan Taki menyadari ada lebih dari sekadar pertukaran tubuh — ternyata mereka hidup dalam waktu yang berbeda, dan Mitsuha berada dalam bahaya besar.\n" +
                        "\n" +
                        "Kimi no Na wa. adalah film yang menggabungkan romansa, drama, dan elemen supernatural dalam balutan visual menawan dan musik emosional dari RADWIMPS. Anime ini menggugah perasaan dengan kisah tentang koneksi manusia, takdir, dan harapan yang melampaui waktu.",
                2016,
                "Summer",
                1,
                "CoMix Wave Films",
                4.9f,
                Arrays.asList(
                        new Anime.Review("Aoi", 4.7, "Bikin nangis. Visual dan musiknya ngena banget."),
                        new Anime.Review("Ken", 4.3, "Ceritanya unik dan menyentuh, salah satu anime terbaik sepanjang masa.")
                ),
                R.drawable.header_kiminonawa,
                R.drawable.kiminonawa_back
        ));

    }

    public static List<Anime> getMostRecentAnimes() {
        List<Anime> result = new ArrayList<>();
        for (Anime anime : animeList) {
            if (anime.getId() >= 1 && anime.getId() <= 4) {
                result.add(anime);
            }
        }
        return result;
    }

    public static List<Anime> getFavoriteAnimes() {
        List<Anime> result = new ArrayList<>();
        for (Anime anime : animeList) {
            if (anime.getId() >= 5 && anime.getId() <= 8) {
                result.add(anime);
            }
        }
        return result;
    }

    public static Anime getAnimeById(int id) {
        for (Anime anime : animeList) {
            if (anime.id == id) {
                return anime;
            }
        }
        return null;
    }
}
