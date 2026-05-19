public class Main {
    public static void main(String[] args) {

        Ban ban1 = new Ban("Bridgestone", 23);
        Ban ban2 = new Ban("Michelin", 23);
        Ban ban3 = new Ban("Continental", 23);
        Ban ban4 = new Ban("Pirelli P Zero", 23);

        // Buat mobil dengan mesin - Composition
        Mobil mobil = new Mobil("Brabus G800 Super Black", "G800SB-2026", 3982);
        // Pasang ban ke mobil
        Ban[] setban = {ban1, ban2, ban3, ban4};
        mobil.pasangSetBan(setban);

        // 1 montir inspeksi - Association
        Montir montir = new Montir("M-072", "Yosafat");
        montir.lakukanQualityControl(mobil);

        // Jika mobil gagal uji kelayakan, maka dihancurkan
        mobil = null;
        System.out.println("\nMobil gagal uji kelayakan, di-set null.");

        /*
            Pembuktian konsep:
            
            Mesin : Musnah - Composition. Mesin hanya direferensikan
            dari dalam objek Mobil. Saat mobil = null, Mesin ikut hilang.

            Ban : Selamat - Aggregation. ban1-ban4 punya referensi
            sendiri di luar Mobil, sehingga tetap ada di memori.
         */

        System.out.println("\nBukti ban masih ada:\n");
        System.out.println("  " + ban1);
        System.out.println("  " + ban2);
        System.out.println("  " + ban3);
        System.out.println("  " + ban4);

        // mobil.tampilkanSpesifikasi(); menjadi NullPointerException, bukti Mobil+Mesin sudah musnah
    }
}