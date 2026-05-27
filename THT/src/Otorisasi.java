// Interface untuk aturan keamanan rekening
public interface Otorisasi {

    // Method ini wajib diimplementasikan oleh class yang memakai interface Otorisasi
    boolean verifikasiPIN(String inputPIN);
}