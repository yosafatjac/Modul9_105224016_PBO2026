public class Main {
    public static void main(String[] args) {
        Monitor[] monitors = {
            new Monitor("LG", 24.0),
            new Monitor("Samsung", 27.0)
        };

        KomputerServer server = new KomputerServer("Server-01", "Seagate", 2000, monitors);

        
    }
}