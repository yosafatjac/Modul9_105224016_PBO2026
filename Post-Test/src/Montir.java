public class Montir {
    private String idMontir;
    private String nama;

    public Montir(String idMontir, String nama) {
        this.idMontir = idMontir;
        this.nama = nama;
    }

    // Montir hanya berinteraksi sesaat dengan Mobil - Association
    public void lakukanQualityControl(Mobil m) {
        System.out.println("\nQuality Control oleh Montir " + nama + " [" + idMontir + "]");
        m.tampilkanSpesifikasi();
        System.out.println("\nStatus: Lulus inspeksi awal.");
    }
    
    public String getNama() { return nama; }
}