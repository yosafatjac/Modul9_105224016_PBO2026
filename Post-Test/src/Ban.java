public class Ban {
    private String merk;
    private int ukuranRing;
    // Ban punya atribut sederhana, tidak ada referensi ke objek lain
    public Ban(String merk, int ukuranRing) {
        this.merk = merk;
        this.ukuranRing = ukuranRing;
    }

    // Getters untuk Ban
    public String getMerk() { return merk; }
    public int getUkuranRing() { return ukuranRing; }

    //Ini untuk mencetak informasi ban saat ditampilkan
    @Override
    public String toString() {
        return "Ban " + merk + " Ring-" + ukuranRing;
    }
}