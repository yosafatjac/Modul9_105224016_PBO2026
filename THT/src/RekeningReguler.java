// Inheritance RekeningReguler ini adalah turunan dari Rekening
public class RekeningReguler extends Rekening {
    private final double biayaAdmin = 2500;

    // Constructor RekeningReguler memanggil constructor parent class Rekening
    public RekeningReguler(String nomorRekening, String namaPemilik, double saldoAwal, String pin) {
        super(nomorRekening, namaPemilik, saldoAwal, pin);
    }

    // Polymorphism override method ini tarik khusus untuk rekening reguler
    @Override
    public void tarik(double jumlah) {
        double totalPotongan = jumlah + biayaAdmin;

        if (jumlah <= 0) {
            System.out.println("Penarikan gagal: jumlah harus lebih dari 0");
        } else if (getSaldo() < totalPotongan) {
            System.out.println("Penarikan gagal: saldo tidak cukup karena ada biaya admin Rp " + biayaAdmin);
        } else {
            kurangiSaldo(totalPotongan);
            catatMutasi("Tarik tunai Rp " + jumlah + " dengan biaya admin Rp " + biayaAdmin +
                    ". Saldo sekarang Rp " + getSaldo());
        }
    }
}