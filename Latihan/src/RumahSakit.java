public class RumahSakit {
    private String nama;

    private Ruangan[] ruangan;

    private Dokter[] daftarDokter;
    private int jumlahDokter;

    // Konstruktor untuk inisialisasi rumah sakit dengan nama, ruangan, dan daftar dokter
    public RumahSakit(String nama) {
        this.nama = nama;

        this.ruangan = new Ruangan[2];
        this.ruangan[0] = new Ruangan("R-01", 10);
        this.ruangan[1] = new Ruangan("R-02", 8);

        this.daftarDokter = new Dokter[10];
        this.jumlahDokter = 0;
    }
    // Method untuk menambahkan dokter ke dalam rumah sakit, dengan pengecekan kapasitas dokter
    public void tambahDokter(Dokter dokter) {
        if (jumlahDokter < daftarDokter.length) {
            daftarDokter[jumlahDokter++] = dokter;
            System.out.println(dokter.getNama() + " ditugaskan ke " + nama);
        } else {
            System.out.println("Kapasitas dokter penuh!");
        }
    }

    public void tampilkanRuangan() {
        System.out.println("\n Daftar Ruangan " + nama + " ");
        for (Ruangan r : ruangan) {
            System.out.println("  " + r);
        }
    }

    public void tampilkanDokter() {
        System.out.println("\n Daftar Dokter " + nama + " ");
        for (int i = 0; i < jumlahDokter; i++) {
            System.out.println("  " + daftarDokter[i]);
        }
    }
}
