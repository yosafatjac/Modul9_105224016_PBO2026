public class Dokter {
    private String nama;
    private String spesialisasi;

    // Konstruktor untuk inisialisasi dokter dengan nama dan spesialisasi
    public Dokter(String nama, String spesialisasi) {
        this.nama = nama;
        this.spesialisasi = spesialisasi;
    }
    // Kita buat method untuk memeriksa pasien, yang menampilkan rekam jejak pemeriksaan dokter dan pasien
    public void periksaPasien(Pasien pasien) {
        System.out.println("\nRekam Jejak Pemeriksaan");
        System.out.println("Dokter  : " + nama + " (" + spesialisasi + ")");
        System.out.println("Pasien  : " + pasien.getNama() + ", Umur: " + pasien.getUmur() + " tahun");
    }
    public String getNama() { return nama; }
    public String getSpesialisasi() { return spesialisasi; }

    @Override
    public String toString() {
        return "Dr. " + nama + " - " + spesialisasi;
    }
}
