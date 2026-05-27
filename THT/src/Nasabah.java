// Class Nasabah menyimpan data nasabah dan daftar rekening
public class Nasabah {
    String idNasabah;
    String nama;

    // Aggregation Rekening ini dibuat di luar Nasabah, lalu dimasukkan ke array ini
    // jika Nasabah dihapus, Rekening masih bisa tetap ada di sistem pusat
    Rekening[] daftarRekening = new Rekening[3];
    int jumlahRekening = 0;

    // Constructor untuk membuat objek Nasabah
    public Nasabah(String idNasabah, String nama) {
        this.idNasabah = idNasabah;
        this.nama = nama;
    }

    // Method untuk menambahkan rekening ke profil nasabah
    public void tambahRekening(Rekening rekening) {
        if (jumlahRekening < daftarRekening.length) {
            daftarRekening[jumlahRekening] = rekening;
            jumlahRekening++;
            System.out.println("Rekening berhasil ditambahkan ke profil nasabah.");
        } else {
            System.out.println("Gagal: maksimal hanya boleh 3 rekening.");
        }
    }

    // Method untuk menampilkan semua rekening milik nasabah
    public void tampilkanRekening() {
        System.out.println("\nDaftar Rekening Milik " + nama + ":");

        if (jumlahRekening == 0) {
            System.out.println("Belum ada rekening.");
            return;
        }

        for (int i = 0; i < jumlahRekening; i++) {
            System.out.println("\nRekening ke-" + (i + 1));
            daftarRekening[i].tampilkanInfo();
        }
    }

    // Method untuk mencari rekening berdasarkan nomor rekening
    public Rekening cariRekening(String nomorRekening) {
        for (int i = 0; i < jumlahRekening; i++) {
            if (daftarRekening[i].getNomorRekening().equals(nomorRekening)) {
                return daftarRekening[i];
            }
        }
        return null;
    }

    // Association nasabah ini hanya berinteraksi dengan CustomerService melalui method
    public void laporKeluhan(CustomerService cs, String keluhan) {
        cs.tanganiKeluhan(this, keluhan);
    }
}