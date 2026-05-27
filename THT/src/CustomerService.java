// Class CustomerService mewakili petugas layanan nasabah
public class CustomerService {
    String idCS;
    String nama;

    // Constructor untuk membuat objek CustomerService
    public CustomerService(String idCS, String nama) {
        this.idCS = idCS;
        this.nama = nama;
    }

    // Association CustomerService ini hanya berinteraksi dengan Nasabah tanpa memilikinya
    public void tanganiKeluhan(Nasabah nasabah, String keluhan) {
        System.out.println("Customer Service " + nama + " menerima keluhan dari " + nasabah.nama);
        System.out.println("Keluhan: " + keluhan);
    }
}