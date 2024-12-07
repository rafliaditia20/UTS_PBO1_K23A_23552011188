import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LaporanPolis laporanPolis = new LaporanPolis();

        while (true) {
            System.out.println("\n=== Aplikasi Manajemen Asuransi ===");
            System.out.println("1. Registrasi Nasabah");
            System.out.println("2. Laporan Polis");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            int menu = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            if (menu == 1) {
                // Registrasi Nasabah
                System.out.print("Masukkan nama nasabah: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan alamat nasabah: ");
                String alamat = scanner.nextLine();
                System.out.print("Masukkan nomor polis: ");
                int nomorPolis = scanner.nextInt();

                Nasabah nasabah = new Nasabah(nama, alamat, nomorPolis);

                System.out.println("\nPilih jenis asuransi:");
                System.out.println("1. Asuransi Kesehatan");
                System.out.println("2. Asuransi Jiwa");
                System.out.print("Pilihan: ");
                int pilihan = scanner.nextInt();

                Asuransi asuransi = null;
                if (pilihan == 1) {
                    System.out.print("Masukkan usia: ");
                    int usia = scanner.nextInt();
                    System.out.print("Apakah memiliki penyakit? (true/false): ");
                    boolean memilikiPenyakit = scanner.nextBoolean();
                    asuransi = new AsuransiKesehatan("Asuransi Kesehatan", 200, usia, memilikiPenyakit);
                } else if (pilihan == 2) {
                    System.out.print("Masukkan usia: ");
                    int usia = scanner.nextInt();
                    asuransi = new AsuransiJiwa("Asuransi Jiwa", 300, usia);
                }

                if (asuransi != null) {
                    String laporan = String.format(
                        "Nasabah: %s, Alamat: %s, Nomor Polis: %s, Produk: %s, Premi: %.2f",
                        nasabah.getNama(),
                        nasabah.getAlamat(),
                        nasabah.getNomorPolis(),
                        asuransi.namaProduk,
                        asuransi.hitungPremi()
                    );
                    laporanPolis.tambahPolis(laporan);

                    asuransi.daftarPolis();
                    System.out.println("Premi yang harus dibayar: " + asuransi.hitungPremi());
                    asuransi.klaim();
                } else {
                    System.out.println("Pilihan tidak valid.");
                }
            } else if (menu == 2) {
                // Laporan Polis
                laporanPolis.tampilkanLaporan();
            } else if (menu == 3) {
                System.out.println("Terima kasih telah menggunakan aplikasi ini!");
                break;
            } else {
                System.out.println("Menu tidak valid. Coba lagi.");
            }
        }

        scanner.close();
    }
}
