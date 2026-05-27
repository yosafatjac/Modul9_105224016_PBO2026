import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner digunakan untuk input dari pengguna
        Scanner input = new Scanner(System.in);

        // Objek nasabah awalnya null karena belum ada registrasi
        Nasabah nasabah = null;

        // Objek CustomerService berdiri sendiri, digunakan untuk asosiasi
        CustomerService cs = new CustomerService("CS01", "Yosafat");

        // Menyimpan rekening yang sedang login
        Rekening rekeningAktif = null;

        // Array ini digunakan untuk membuktikan agregasi
        // Rekening tetap disimpan di sistem pusat meskipun Nasabah dihapus
        Rekening[] bankDataPusat = new Rekening[10];
        int jumlahDataPusat = 0;

        int pilihan;

        do {
            // Menu utama program NeoBank
            System.out.println("\n=== SISTEM NEOBANK ===");
            System.out.println("1. Registrasi Nasabah");
            System.out.println("2. Buka Rekening");
            System.out.println("3. Login Rekening");
            System.out.println("4. Setor Tunai");
            System.out.println("5. Tarik Tunai");
            System.out.println("6. Tampilkan Profil Nasabah");
            System.out.println("7. Hubungi Customer Service");
            System.out.println("8. Tutup Paksa Profil Nasabah");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    // Membuat objek Nasabah baru
                    System.out.print("Masukkan ID Nasabah: ");
                    String id = input.nextLine();

                    System.out.print("Masukkan Nama Nasabah: ");
                    String nama = input.nextLine();

                    nasabah = new Nasabah(id, nama);
                    System.out.println("Registrasi nasabah berhasil.");
                    break;

                case 2:
                    // Validasi nasabah ini harus ada sebelum membuka rekening
                    if (nasabah == null) {
                        System.out.println("Gagal: registrasikan nasabah terlebih dahulu.");
                        break;
                    }

                    System.out.println("Jenis Rekening:");
                    System.out.println("1. Rekening Reguler");
                    System.out.println("2. Rekening Prioritas");
                    System.out.print("Pilih jenis: ");
                    int jenis = input.nextInt();
                    input.nextLine();

                    System.out.print("Masukkan Nomor Rekening: ");
                    String noRek = input.nextLine();

                    System.out.print("Masukkan Saldo Awal: ");
                    double saldoAwal = input.nextDouble();
                    input.nextLine();

                    System.out.print("Buat PIN: ");
                    String pin = input.nextLine();

                    // Polymorphism variabel bertipe Rekening ini dapat menampung child class
                    Rekening rekeningBaru;

                    if (jenis == 1) {
                        rekeningBaru = new RekeningReguler(noRek, nasabah.nama, saldoAwal, pin);
                    } else if (jenis == 2) {
                        rekeningBaru = new RekeningPrioritas(noRek, nasabah.nama, saldoAwal, pin);
                    } else {
                        System.out.println("Jenis rekening tidak valid.");
                        break;
                    }

                    // Aggregation rekening ini dimasukkan ke profil nasabah
                    nasabah.tambahRekening(rekeningBaru);

                    // Rekening juga disimpan di bank data pusat
                    if (jumlahDataPusat < bankDataPusat.length) {
                        bankDataPusat[jumlahDataPusat] = rekeningBaru;
                        jumlahDataPusat++;
                    }

                    break;

                case 3:
                    // Login rekening ini menggunakan nomor rekening dan PIN
                    if (nasabah == null) {
                        System.out.println("Gagal: nasabah belum terdaftar.");
                        break;
                    }

                    System.out.print("Masukkan Nomor Rekening: ");
                    String nomorLogin = input.nextLine();

                    Rekening ditemukan = nasabah.cariRekening(nomorLogin);

                    if (ditemukan == null) {
                        System.out.println("Login gagal: rekening tidak ditemukan.");
                        break;
                    }

                    System.out.print("Masukkan PIN: ");
                    String pinLogin = input.nextLine();

                    if (ditemukan.verifikasiPIN(pinLogin)) {
                        rekeningAktif = ditemukan;
                        System.out.println("Login berhasil. Rekening aktif: " + rekeningAktif.getNomorRekening());
                    } else {
                        System.out.println("Login gagal: PIN salah.");
                    }
                    break;

                case 4:
                    // Setor hanya bisa dilakukan setelah login
                    if (rekeningAktif == null) {
                        System.out.println("Gagal: login rekening terlebih dahulu.");
                        break;
                    }

                    System.out.print("Masukkan jumlah setor: ");
                    double setor = input.nextDouble();
                    input.nextLine();

                    rekeningAktif.setor(setor);
                    break;

                case 5:
                    // Tarik hanya bisa dilakukan setelah login
                    if (rekeningAktif == null) {
                        System.out.println("Gagal: login rekening terlebih dahulu.");
                        break;
                    }

                    System.out.print("Masukkan jumlah tarik: ");
                    double tarik = input.nextDouble();
                    input.nextLine();

                    // Polymorphism, tarik() berjalan sesuai jenis rekening aktif
                    rekeningAktif.tarik(tarik);
                    break;

                case 6:
                    // Menampilkan profil nasabah dan daftar rekening
                    if (nasabah == null) {
                        System.out.println("Profil nasabah belum ada.");
                    } else {
                        System.out.println("\nID Nasabah: " + nasabah.idNasabah);
                        System.out.println("Nama      : " + nasabah.nama);
                        nasabah.tampilkanRekening();
                    }
                    break;

                case 7:
                    // Association nasabah untuk berinteraksi dengan CustomerService
                    if (nasabah == null) {
                        System.out.println("Gagal: nasabah belum terdaftar.");
                        break;
                    }

                    System.out.print("Tulis keluhan Anda: ");
                    String keluhan = input.nextLine();

                    nasabah.laporKeluhan(cs, keluhan);
                    break;

                case 8:
                    // Menghapus profil nasabah dari sistem
                    nasabah = null;
                    rekeningAktif = null;

                    System.out.println("Profil nasabah telah ditutup paksa dan di-set null.");

                    // Pembuktian agregasi karena rekening masih ada di bankDataPusat
                    System.out.println("\nPembuktian Agregasi:");
                    if (jumlahDataPusat > 0 && bankDataPusat[0] != null) {
                        System.out.println("Rekening pertama masih ada di bank data pusat:");
                        bankDataPusat[0].tampilkanInfo();
                    } else {
                        System.out.println("Belum ada rekening di bank data pusat.");
                    }

                    System.out.println("\nAnalisis:");
                    System.out.println("- Nasabah dihapus, tetapi rekening tetap bisa ada karena relasinya agregasi.");
                    System.out.println("- BukuMutasi adalah komposisi di dalam Rekening.");
                    System.out.println("- Jika objek Rekening ikut dihapus dan tidak punya referensi lain, BukuMutasi ikut hilang.");
                    System.out.println("- CustomerService tetap ada karena hanya berasosiasi dengan Nasabah.");
                    break;

                case 0:
                    // Keluar dari program
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 0);

        input.close();
    }
}