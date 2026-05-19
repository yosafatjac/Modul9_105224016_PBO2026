public class Mesin {
    private String nomorSeri;
    private int kapasitasCC;

    // Constructor untuk Mesin, hanya bisa dibuat melalui Mobil - Composition 
    public Mesin(String nomorSeri, int kapasitasCC) {
        this.nomorSeri = nomorSeri;
        this.kapasitasCC = kapasitasCC;
    }

    @Override
    public String toString() {
        return "Mesin [SN: " + nomorSeri + " | " + kapasitasCC + "CC]";
    }
}