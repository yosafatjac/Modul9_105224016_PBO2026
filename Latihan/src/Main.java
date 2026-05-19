public class Main {
    public static void main(String[] args) {

        // Membuat objek dokter dan pasien
        Dokter dokter1 = new Dokter("Dwi Setiawan", "Kardiologi");
        Dokter dokter2 = new Dokter("Pradana Akbar Razan", "Neurologi");

        Pasien pasien1 = new Pasien("Arif", 19);
        Pasien pasien2 = new Pasien("Fatin", 20);

        // Kita buat simulasi pemeriksaan untuk menunjukkan rekam jejak dokter dan pasien
        System.out.println("\nSimulasi Pemeriksaan:");
        dokter1.periksaPasien(pasien1);
        dokter2.periksaPasien(pasien2);

        // Membuat objek rumah sakit dan menambahkan dokter ke dalamnya
        RumahSakit rs = new RumahSakit("RS Sehat Selalu");

        rs.tambahDokter(dokter1);
        rs.tambahDokter(dokter2);

        rs.tampilkanRuangan();
        rs.tampilkanDokter();

        // Sekarang kita akan menghancurkan rumah sakit dengan membuat referensi rs menjadi null
        rs = null;

        System.out.println("\n rs = null dieksekusi.");
        System.out.println();

        // Kita coba akses dokter1 dan dokter2 untuk membuktikan 
        // bahwa mereka masih hidup meskipun rumah sakit sudah dihancurkan
        System.out.println("Bukti dokter1 masih hidup: " + dokter1.getNama());
        System.out.println("Bukti dokter2 masih hidup: " + dokter2.getNama());

    }
}
