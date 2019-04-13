import info.debatty.java.stringsimilarity.Levenshtein;
import info.debatty.java.stringsimilarity.NGram;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String[] nonFormalWords = {
                "Nerjang", "Nuduh", "Nerima", "negur", "mukul", "Mimpin", "nyoba", "nyiram", "Nyuruh", "Nyimpen",
                "Nyebrang", "Nganggep", "Ngamuk", "Ngambil", "Ngebuka", "Ngebantu", "Ngelepas", "Kebayang",
                "Keinjek", "Kekabul", "Kepergok", "Ketipu", "Keulang", "Kewujud", "Critain", "Betulin", "Manjain",
                "Gangguin", "Gantian", "Ikutan", "Musuhan", "Sabunan", "Temenan", "Tukeran", "nanyain", "nunjukin",
                "mentingin", "megangin", "nyelametin", "nyempetin", "ngorbanin", "ngadepin", "ngebuktiin", "ngewarnain",
                "Kedengeran", "ketemuan", "beneran", "ginian", "kawinan", "mainan", "parkiran", "duluan", "gendutan",
                "karatan", "palingan", "sabaran", "kebagusan", "sanaan", "cepetan", "sepagian"
        };

        String[] validRootWords = {
                "Terjang", "Tuduh", "Terima", "Tegur", "Pukul", "Pimpin", "Coba", "Siram", "Suruh", "Simpan", "Sebrang",
                "Anggap", "Amuk", "Ambil", "Buka", "Bantu", "Lepas", "Bayang", "Injak", "Kabul", "Pergok", "Tipu",
                "Ulang", "Wujud", "Cerita", "Betul", "Manja", "Ganggu", "Ganti", "Ikut", "Musuh", "Sabun", "Teman",
                "Tukar", "Tanya", "Tunjuk", "penting", "Pegang", "Selamat", "Sempat", "Korban", "Hadap", "Bukti",
                "Warna", "Dengar", "Temu", "Benar", "Begini", "Kawin", "Main", "Parkir", "Dulu", "Gendut", "Karat",
                "Paling", "Sabar", "Bagus", "Sana", "Cepat", "Pagi"
        };

        String[] formalRootPUBG = {
                "candu", "game", "memang", "kerap", "picu", "tindak", "yang", "tidak", "puji", "dan", "bahkan",
                "rugi", "orang", "lain", "seperti", "laku", "pria", "asal", "ini", "yang", "tega", "tinggal",
                "istri", "yang", "tengah", "hamil", "demi", "lewat", "laman", "sang", "istri", "cerita", "runut",
                "jadi", "suami", "minggat", "dari", "rumah", "tinggal", "diri", "anak", "usia", "tiga", "tahun",
                "dan", "calon", "bayi", "usia", "empat", "bulan", "yang", "tengah", "kandung", "awal", "mula",
                "suami", "doyan", "main", "telah", "kenal", "saudara", "lambat", "laun", "sang", "suami", "begitu",
                "ranjing", "game", "ini", "tak", "jarang", "picu", "tengkar", "hebat", "antara", "pasang",
                "suami-istri", "sebut", "alas", "sang", "suami", "kerap", "main", "game", "itu", "panjang", "malam",
                "sehingga", "sulit", "bangun", "pagi", "imbas", "kerja", "dan", "bisnis", "jadi", "bengkalai",
                "begitu", "ingat", "sang", "suami", "malah", "cap", "diri", "istilah", "untuk", "orang", "istri",
                "yang", "tidak", "dukung", "suami", "puncak", "sang", "suami", "akhir", "minggat", "dari", "rumah",
                "dan", "belum", "kembali", "hingga", "kini", "Kisah", "itu", "pun", "kini", "jadi", "demikian",
                "sudah", "bulan", "sejak", "dia", "tinggal", "kami", "kami", "sekarang", "tidak", "punya", "pilih",
                "selain", "berdikari", "lalu", "sulit", "apa", "pun", "yang", "mungkin", "datang", "tulis", "sang",
                "istri", "seperti", "lansir", "dari", "Senin", "belum", "dia", "mulai", "main", "pribadi", "jauh",
                "lebih", "bisa", "toleransi", "namun", "situasi", "angsur", "tambah", "buruk", "sejak", "pertama",
                "kali", "mulai", "main", "game", "empat", "tahun", "lalu", "Tolong", "doa", "dia", "akan", "kembali",
                "keluarga", "kami", "pungkas",
        };

        String[] formalRootTwitter = {
                "marak",
                "hingga",
                "ujar",
                "benci",
                "edar",
                "media",
                "sosial",
                "buat",
                "badan",
                "siber",
                "sandi",
                "negara",
                "gerah",
                "lembaga",
                "punya",
                "jalur",
                "khusus",
                "dalam",
                "tangkal",
                "sampai",
                "jalur",
                "khusus",
                "sebut",
                "buat",
                "telah",
                "laku",
                "temu",
                "antara",
                "jumat",
                "koordinasi",
                "dengan",
                "media",
                "sosial",
                "ini",
                "langsung",
                "tutup",
                "di",
                "mana",
                "belum",
                "juga",
                "undang",
                "tetapi",
                "tidak",
                "hadir",
                "sekretaris",
                "utama",
                "jelas",
                "temu",
                "dengan",
                "wakil",
                "bicara",
                "kena",
                "proses",
                "bisnis",
                "media",
                "sosial",
                "logo",
                "burung",
                "tanah",
                "air",
                "adapun",
                "ada",
                "dua",
                "poin",
                "yang",
                "pakat",
                "hasil",
                "kembang",
                "cakap",
                "sebut",
                "yang",
                "pertama",
                "tawar",
                "adalah",
                "ini",
                "perlu",
                "untuk",
                "bisa",
                "laku",
                "lapor",
                "yang",
                "efektif",
                "kepada",
                "kemudian",
                "yang",
                "dua",
                "ada",
                "butuh",
                "khusus",
                "yang",
                "minta",
                "nanti",
                "dapat",
                "sesuai",
                "dengan",
                "minta",
                "nanti",
                "akan",
                "fungsi",
                "dan",
                "spesifik",
                "lagi",
                "lalu",
                "tutur",
                "di",
                "kantor",
                "tahu",
                "yang",
                "maksud",
                "adalah",
                "kerja",
                "sama",
                "dalam",
                "bagi",
                "personil",
                "dalam",
                "tingkat",
                "respons",
                "layan",
                "informasi",
                "kepada",
                "publik",
                "sejati",
                "sudah",
                "ada",
                "kanal",
                "lapor",
                "publik",
                "lalu",
                "yang",
                "kelola",
                "kait",
                "ada",
                "konten",
                "negatif",
                "yang",
                "temu",
                "di",
                "platform",
                "besut",
                "itu",
                "sementara",
                "lewat",
                "ini",
                "akan",
                "lebih",
                "tingkat",
                "koordinasi",
                "dengan",
                "bagai",
                "lembaga",
                "perintah",
                "untuk",
                "hindar",
                "duplikasi",
                "lapor",
                "yang",
                "masuk",
                "ke",
                "platform",
                "sementara",
                "dari",
                "satu",
                "sisi",
                "lain",
                "pihak",
                "terus",
                "jalin",
                "koordinasi",
                "dengan",
                "para",
                "sedia",
                "platform",
                "media",
                "sosial",
                "dalam",
                "tangkal",
                "laju",
                "sisi",
                "lain",
                "lagi",
                "aku",
                "terus",
                "inisiasi",
                "yang",
                "kait",
                "dengan",
                "tanggulang",
                "konten",
                "negatif",
                "di",
                "dunia",
                "maya",
                "saya",
                "pikir",
                "kita",
                "sudah",
                "banyak",
                "inisiasi",
                "kait",
                "dengan",
                "tanggulang",
                "konten",
                "negatif",
                "hingga",
                "ujar",
                "benci",
                "dan",
                "ini",
                "memang",
                "tidak",
                "bisa",
                "laku",
                "sendiri",
                "harus",
                "laku",
                "koordinasi",
                "pungkas"
        };

        String[] formalRootIphone = {
                "telah",
                "coba",
                "berapa",
                "cara",
                "untuk",
                "semarak",
                "lagi",
                "jual",
                "di",
                "salah",
                "satu",
                "pasar",
                "paling",
                "penting",
                "namun",
                "jauh",
                "ini",
                "strategi",
                "usaha",
                "yang",
                "komando",
                "itu",
                "pandang",
                "masih",
                "belum",
                "mujarab",
                "pada",
                "bulan",
                "akhir",
                "jual",
                "anjlok",
                "banding",
                "tahun",
                "belum",
                "pun",
                "gelar",
                "pangkas",
                "harga",
                "serta",
                "tawar",
                "skema",
                "cicil",
                "tanpa",
                "bunga",
                "bagi",
                "warga",
                "negeri",
                "pangkas",
                "harga",
                "berapa",
                "kali",
                "tidak",
                "henti",
                "tren",
                "cari",
                "lemah",
                "lebih",
                "lanjut",
                "kata",
                "analis",
                "dari",
                "yang",
                "kutip",
                "dari",
                "sedang",
                "dari",
                "suplier",
                "komponen",
                "di",
                "antara",
                "lapor",
                "jual",
                "yang",
                "buruk",
                "tengara",
                "tarik",
                "pada",
                "makin",
                "lemah",
                "dari",
                "tahun",
                "ke",
                "tahun",
                "antara",
                "lain",
                "dengan",
                "makin",
                "turun",
                "cari",
                "soal",
                "di",
                "maupun",
                "dapat",
                "nada",
                "muka",
                "oleh",
                "dari",
                "usaha",
                "sudah",
                "coba",
                "taktik",
                "harga",
                "variasi",
                "untuk",
                "bangkit",
                "jual",
                "namun",
                "tampak",
                "hanya",
                "minimal",
                "rusa",
                "tulis",
                "dia",
                "berapa",
                "analis",
                "pun",
                "prediksi",
                "jual",
                "iphone",
                "belum",
                "benar",
                "pulih",
                "sampai",
                "keluar",
                "model",
                "baru",
                "jelang",
                "akhir",
                "tahun",
                "ini",
                "itu",
                "dengan",
                "catat",
                "anyar",
                "benar",
                "mampu",
                "tarik",
                "minat",
                "jual",
                "turun",
                "tengara",
                "karena",
                "harga",
                "mahal",
                "dan",
                "makin",
                "minim",
                "inovasi",
                "belum",
                "lagi",
                "smartphone",
                "besut",
                "vendor",
                "asal",
                "makin",
                "kualitas",
                "serta",
                "berani",
                "pasang",
                "harga",
                "murah"
        };

        String formalDocumentPUBG = "Kecanduan game memang kerap memicu tindakan yang tidak terpuji dan bahkan " +
                "merugikan orang lain Seperti dilakukan pria asal ini yang tega meninggalkan istrinya yang " +
                "tengah hamil demi Lewat laman sang Istri menceritakan " +
                "runut kejadian suaminya minggat dari rumah meninggalkan dirinya anak berusia tiga tahun dan calon " +
                "bayi berusia empat bulan yang tengah dikandung Awal mula suami doyan bermain setelah " +
                "dikenalkan saudaranya Lambat laun sang suami begitu keranjingan game ini Tak jarang memicu " +
                "pertengkaran hebat antara pasangan suami-istri tersebut Alasannya sang suami kerap bermain game " +
                "itu sepanjang malam sehingga sulit bangun pagi Imbasnya pekerjaan dan bisnisnya jadi terbengkalai " +
                "Begitu diingatkan sang suami malah mencap dirinya istilah untuk seorang istri yang tidak " +
                "mendukung suaminya Puncaknya sang suami akhirnya minggat dari rumah dan belum kembali hingga kini " +
                "Kisah itu pun kini jadi sedemikian Sudah sebulan sejak dia meninggalkan kami Kami sekarang " +
                "tidak punya pilihan selain berdikari melalui kesulitan apa pun yang mungkin datang tulis sang istri " +
                "seperti dilansir dari Senin Sebelum dia mulai bermain kepribadiannya jauh lebih " +
                "bisa ditoleransi Namun situasinya berangsur-angsur bertambah buruk sejak pertama kali mulai bermain " +
                "game empat tahun lalu Tolong doakan dia akan kembali keluarga kami pungkasnya";

        String formalDocumentTwitter = "Maraknya hingga ujaran kebencian beredar media sosial membuat Badan Siber Sandi " +
                "Negara gerah Lembaga mempunyai jalur khusus dalam menangkal Disampaikan jalur khusus tersebut dibuat " +
                "setelah dilakukannya pertemuan antara Jumat Koordinasi dengan media sosial ini berlangsung tertutup di " +
                "mana sebelumnya juga mengundang tetapi tidak hadir Sekretaris Utama menjelaskan pertemuan dengan " +
                "perwakilan berbicara mengenai proses bisnis media sosial berlogo burung Tanah Air Adapun ada dua poin " +
                "yang disepakati hasil pengembangan percakapan tersebut Yang pertama ditawarkan adalah Ini diperlukan " +
                "untuk bisa melakukan pelaporan yang efektif kepada Kemudian yang kedua ada kebutuhan-kebutuhan khusus " +
                "yang dimintakan nanti mendapatkan sesuai dengan permintaan Nanti akan difungsikan dan dispesifikan lagi " +
                "melalui tutur di kantor Diketahui yang dimaksud adalah kerja sama   dalam bagi personil dalam " +
                "meningkatkan respons layanan informasi kepada publik Sejatinya sudah ada kanal pelaporan publik melalui" +
                " yang dikelola terkait adanya konten negatif yang ditemukan di platform besutan itu Sementara lewat ini" +
                " akan lebih meningkatkan koordinasi dengan berbagai lembaga pemerintah untuk menghindari duplikasi " +
                "laporan yang masuk ke platform Sementara dari satu sisi lain pihaknya terus menjalin koordinasi dengan" +
                " para penyedia platform media sosial dalam menangkal laju sisi lainnya lagi mengaku terus menginisiasi" +
                " yang berkaitan dengan penanggulangan konten negatif di dunia maya Saya pikir kita sudah banyak" +
                " menginisiasi berkaitan dengan penanggulangan konten negatif hingga ujaran kebencian dan ini memang" +
                " tidak bisa dilakukan sendiri harus melakukan koordinasi pungkasnya";

        String formalDocumentIphone = "telah mencoba beberapa cara untuk menyemarakkan lagi penjualan di salah satu " +
                "pasar paling penting Namun sejauh ini strategi perusahaan yang dikomandoi itu dipandang masih belum " +
                "mujarab Pada bulan terakhir penjualan anjlok dibandingkan tahun sebelumnya pun menggelar pemangkasan " +
                "harga serta menawarkan skema cicilan tanpa bunga bagi warga Negeri Pemangkasan harga beberapa kali " +
                "tidak menghentikan tren pencarian melemah lebih lanjut kata analis dari yang dikutip dari Sedangkan " +
                "dari suplier komponen di antaranya melaporkan penjualan yang memburuk menengarai ketertarikan pada " +
                "makin melemah dari tahun ke tahun antara lain dengan makin turunnya pencarian soal di maupun Pendapat" +
                " senada dikemukakan oleh dari Perusahaan sudah mencoba taktik harga bervariasi untuk membangkitkan " +
                "penjualan namun tampaknya hanya meminimalisir kerusakan tulis dia Beberapa analis pun memprediksi" +
                " penjualan iPhone belum benar-benar pulih sampai keluarnya model baru menjelang akhir tahun ini Itupun" +
                " dengan catatan anyar benar-benar mampu menarik minat Penjualan turun ditengarai karena harga mahal dan" +
                " makin minim inovasi Belum lagi smartphone besutan vendor asal  makin berkualitas serta berani pasang" +
                " harga murah";

        String[] tokenizedFormalDoc = SastrawiWrapper.getInstance().getTokenizer().tokenize(formalDocumentIphone);
        System.out.println(tokenizedFormalDoc.length);

//        for (String docWord:
//                tokenizedFormalDoc) {
//            System.out.println(SastrawiWrapper.getInstance().getLemmatizer().lemmatize(docWord.toLowerCase()));
//        }

//        System.out.println("Formal Word stemming");
//        double wrong = 0;
//        double correct = 0;
//        double TP = 0;
//        double TN = 0;
//        double FP = 0;
//        double FN = 0;
//
//        for (int i = 0; i < tokenizedFormalDoc.length; i++) {
//            String docWord = tokenizedFormalDoc[i];
//            String rootWord = formalRootIphone[i];
//            String stemmingResult = SastrawiWrapper.getInstance().getLemmatizer().lemmatize(docWord);
//            boolean isValid = rootWord.toLowerCase().equals(stemmingResult.toLowerCase());
//
//            if (isValid) {
//                correct++;
//            } else {
//                wrong++;
//            }
//
//
//            //Di stemming benar TP
//            if (!stemmingResult.equals(docWord) && stemmingResult.equals(rootWord)) {
//                TP++;
//            }
//
//            //Di stemming tidak benar FP
//            if (!stemmingResult.equals(docWord) && !stemmingResult.equals(rootWord)) {
//                FN++;
//            }
//
//            //Tidak di stemming benar tapi di stemming FN
//            if (!stemmingResult.equals(rootWord) && rootWord.equals(docWord)) {
//                FP++;
//            }
//
//            //Tidak di stemming dan benar
//            if (docWord.equals(rootWord)) {
//                TN++;
//            }
//
//
//            System.out.println(stemmingResult + " " + isValid);
//        }
//
////        System.out.println("TP: " + TP);
////        System.out.println("FN: " + FN);
////        System.out.println("FP: " + TP);
////        System.out.println("TN: " + TN);
//        System.out.println("correct: " + correct + " wrong: " + wrong);
//        System.out.println("accuracy: " + correct/tokenizedFormalDoc.length);

//
//        System.out.println("Non Formal Word\tStemming Result\tValidRootWord\tisValid");
//        double wrong = 0;
//        double correct = 0;
//        double TP = 0;
//        double FP = 0;
//        double TN = 0;
//        double FN = 0;
//        for (int i = 0; i < validRootWords.length; i++) {
//
//
//            String nonFormalWord = nonFormalWords[i].toLowerCase();
//            String validRootWord = validRootWords[i].toLowerCase();
//            String stemmingResult = SastrawiWrapper.getInstance().getLemmatizer().lemmatize(nonFormalWord).toLowerCase();
////                String stemmingResult = stemmingNaziefAndriani.KataDasar(nonFormalWord);
//
//            boolean isValid = validRootWord.toLowerCase().equals(stemmingResult.toLowerCase());
//
//            if (isValid) {
//                correct++;
//            } else {
//                wrong++;
//            }
//
//            //Di stemming benar TP
//            if (!stemmingResult.equals(nonFormalWord) && stemmingResult.equals(validRootWord)) {
//                TP++;
//            }
//
//            //Di stemming tidak benar FP
//            if (!stemmingResult.equals(nonFormalWord) && !stemmingResult.equals(validRootWord)) {
//                FN++;
//            } else if (stemmingResult.equals(nonFormalWord) && !stemmingResult.equals(validRootWord)) {
//                FN++;
//            }
//
//            //Tidak di stemming benar tapi di stemming FN
//            if (!stemmingResult.equals(validRootWord) && validRootWord.equals(nonFormalWord)) {
//                FP++;
//            }
//
//            //Tidak di stemming dan benar
//            if (nonFormalWord.equals(validRootWord)) {
//                TN++;
//            }
//
//
//            System.out.println(nonFormalWord + "\t" + stemmingResult + "\t" + validRootWord + "\t" + isValid);
//        }
//
////        System.out.println("TP: " + TP);
////        System.out.println("FN: " + FN);
////        System.out.println("FP: " + FP);
////        System.out.println("TN: " + TN);
//        System.out.println("correct: " + correct + " wrong: " + wrong);
//        System.out.println("accuracy: " + correct / nonFormalWords.length);
        System.out.println("stemming result: " + SastrawiWrapper.getInstance().getLemmatizer().lemmatize("nyimpen"));


//        System.out.println("----------- non-formal affix stemming NA --------------------");
//        double startTime = System.currentTimeMillis();
//        System.out.println(SastrawiWrapper.getInstance().getLemmatizer().lemmatize("diselipin"));
//        System.out.println(SastrawiWrapper.getInstance().getNonformalDetector().isNonFormal("temenan"));
//        double endTime = System.currentTimeMillis();
//        System.out.println("code duration: " + ((endTime - startTime)/1000));
//
//        Levenshtein levenshtein = new Levenshtein();
//        System.out.println("distance " + levenshtein.distance("temen", "teman"));
//
//        NGram nGram = new NGram(2);
//        System.out.println("ngram " + nGram.distance("crita", "cerita"));
//        System.out.println("ngram " + nGram.distance("crita", "cita"));
    }
}
