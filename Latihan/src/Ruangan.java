public class Ruangan {
    private String nomorRegistrasi;
    private int kapasitasMaksimal;
    // Konstruktor untuk inisialisasi ruangan dengan nomor registrasi dan kapasitas maksimal pasien
    public Ruangan(String nomorRegistrasi, int kapasitasMaksimal) {
        this.nomorRegistrasi = nomorRegistrasi;
        this.kapasitasMaksimal = kapasitasMaksimal;
    }

    @Override
    public String toString() {
        return "Ruangan " + nomorRegistrasi + " | Kapasitas: " + kapasitasMaksimal + " pasien";
    }
}
