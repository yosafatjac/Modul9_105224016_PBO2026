class KomputerServer {

    private String namaServer;

    private Harddisk harddisk;

    private Monitor[] monitors;

    public KomputerServer(String namaServer, String merkHDD, int kapasitasHDD, Monitor[] monitors) {
        this.namaServer = namaServer;

        this.harddisk = new Harddisk(merkHDD, kapasitasHDD);

        this.monitors = monitors;
    }
}
