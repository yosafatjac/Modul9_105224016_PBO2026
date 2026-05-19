public class Mobil {
    private String merkMobil;
    private String nomorSeri;

    // Mesin dibuat di dalam constructor Mobil - Composition
    private Mesin mesin;

    // Ban dipasang dari luar, tetap hidup jika Mobil mati - Aggregation
    private Ban[] setBan;

    public Mobil(String merkMobil, String nomorSeri, int kapasitasCC) {
        this.merkMobil = merkMobil;
        this.nomorSeri = nomorSeri;

        // Mesin langsung dibuat saat Mobil dibuat - Composition
        this.mesin = new Mesin("MSN-" + nomorSeri, kapasitasCC);

        this.setBan = new Ban[4];
    }

    // Pasang ban ke mobil, bisa dilakukan setelah mobil dibuat - Aggregation
    public void pasangSetBan(Ban[] setBan) {
        for (int i = 0; i < setBan.length && i < 4; i++) {
            this.setBan[i] = setBan[i];
        }
        System.out.println("\n4 ban berhasil dipasang ke " + merkMobil);
    }

    public void tampilkanSpesifikasi() {
        System.out.println("\nSpesifikasi Mobil ");
        System.out.println("Merk     : " + merkMobil);
        System.out.println("No. Seri : " + nomorSeri);
        System.out.println("Mesin    : " + mesin);
        System.out.print("Ban:      ");
        for (int i = 0; i < setBan.length; i++) {
            if (setBan[i] != null) {
                if (i == 0)
                    System.out.println("[" + (i+1) + "] " + setBan[i]);
                else
                    System.out.println("          [" + (i+1) + "] " + setBan[i]);
            }
        }
    }
}