// Inheritance RekeningPrioritas untuk turunan dari Rekening
public class RekeningPrioritas extends Rekening {
    private final double minimalPenarikan = 100000;

    // Constructor RekeningPrioritas ini memanggil constructor parent class Rekening
    public RekeningPrioritas(String nomorRekening, String namaPemilik, double saldoAwal, String pin) {
        super(nomorRekening, namaPemilik, saldoAwal, pin);
    }

    // Polymorphism override method ini tarik khusus untuk rekening prioritas
    @Override
    public void tarik(double jumlah) {
        if (jumlah < minimalPenarikan) {
            System.out.println("Penarikan gagal: rekening prioritas minimal tarik Rp " + minimalPenarikan);
        } else if (getSaldo() < jumlah) {
            System.out.println("Penarikan gagal: saldo tidak cukup");
        } else {
            kurangiSaldo(jumlah);
            catatMutasi("Tarik tunai Rp " + jumlah + " tanpa biaya admin. Saldo sekarang Rp " + getSaldo());
        }
    }
}