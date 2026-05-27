// Abstract class sebagai induk dari RekeningReguler dan RekeningPrioritas 
// dan class ini mengimplementasikan interface Otorisasi
public abstract class Rekening implements Otorisasi {
    protected String nomorRekening;
    protected String namaPemilik;

    // Encapsulation ini membuat saldo dan pin dibuat private agar 
    // tidak bisa diakses langsung dari luar class
    private double saldo;
    private String pin;

    // Composition BukuMutasi ini dibuat langsung di dalam Rekening
    // jika Rekening hilang, BukuMutasi juga ikut hilang secara logis
    private BukuMutasi bukuMutasi;

    // Constructor untuk mengisi data awal rekening
    public Rekening(String nomorRekening, String namaPemilik, double saldoAwal, String pin) {
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.saldo = saldoAwal;
        this.pin = pin;
        this.bukuMutasi = new BukuMutasi();

        bukuMutasi.catat("Rekening " + nomorRekening + " dibuat dengan saldo awal Rp " + saldoAwal);
    }

    // Implementasi method dari interface Otorisasi
    @Override
    public boolean verifikasiPIN(String inputPIN) {
        return this.pin.equals(inputPIN);
    }

    // Method untuk menambah saldo rekening
    public void setor(double jumlah) {
        if (jumlah <= 0) {
            System.out.println("Setoran gagal: jumlah harus lebih dari 0");
            return;
        }

        saldo += jumlah;
        bukuMutasi.catat("Setor tunai Rp " + jumlah + ". Saldo sekarang Rp " + saldo);
    }

    // Abstract method: aturan tarik berbeda pada setiap jenis rekening
    public abstract void tarik(double jumlah);

    // Getter saldo untuk digunakan oleh subclass
    protected double getSaldo() {
        return saldo;
    }

    // Method protected agar saldo hanya bisa dikurangi secara terkontrol oleh subclass
    protected void kurangiSaldo(double jumlah) {
        saldo -= jumlah;
    }

    // Method untuk mencatat mutasi dari subclass
    protected void catatMutasi(String aktivitas) {
        bukuMutasi.catat(aktivitas);
    }

    // Getter nomor rekening untuk pencarian rekening
    public String getNomorRekening() {
        return nomorRekening;
    }

    // Method untuk menampilkan informasi rekening
    public void tampilkanInfo() {
        System.out.println("No Rekening : " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo       : Rp " + saldo);
        System.out.println("Jenis       : " + getClass().getSimpleName());
    }
}