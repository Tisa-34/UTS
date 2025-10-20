package Main;
//public class MainHotel {}
import model.*;
import Service.*;
import java.util.Scanner;

public class MainHotel {
    private static HotelService hotelService = new HotelService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            tampilkanMenuUtama();
            System.out.print("Pilih Menu: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    tampilkanKamar();
                    break;
                case "2":
                    prosesReservasi();
                    break;
                case "3":
                    tampilkanRaservasi();
                    break;
                case "4":
                    prosesCheckOut();
                    break;
                case "5":
                    running = false;
                    System.out.println("\nTerima kasih telah menggunakan Aplikasi Reservasi Hotel. Sampai jumpa!");
                    break;
                default:
                    System.out.println("\nPilihan tidak valid. Silakan coba lagi.");
            }
            System.out.println("\n");
        }
        scanner.close();
    }

    private static void tampilkanMenuUtama() {
        System.out.println("========================================");
        System.out.println("  APLIKASI RESERVASI HOTEL (CONSOLE)  ");
        System.out.println("========================================");
        System.out.println("1. Tampilkan Daftar Kamar");
        System.out.println("2. Buat Reservasi Baru");
        System.out.println("3. Lihat Daftar Reservasi Aktif");
        System.out.println("4. Proses Check-Out");
        System.out.println("5. Keluar");
        System.out.println("========================================");
    }
    
    private static void tampilkanKamar() {
        hotelService.tampilkanSemuaKamar();
    }

    private static void prosesReservasi() {
        System.out.println("\n--- FORM RESERVASI ---");
        System.out.print("Masukkan NIK Tamu: ");
        String nik = scanner.nextLine();
        System.out.print("Masukkan Nama Tamu: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan No. Telepon: ");
        String telepon = scanner.nextLine();
        Tamu tamuBaru = new Tamu(nik, nama, telepon);

        System.out.println("\nTersedia Tipe Kamar: Standar, Deluxe, Suite");
        System.out.print("Pilih Tipe Kamar: ");
        String tipe = scanner.nextLine();
        
        int jumlahMalam = -1;
        while(jumlahMalam <= 0) {
            System.out.print("Lama Menginap (malam): ");
            try {
                jumlahMalam = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka.");
            }
        }

        hotelService.buatRaservasi(tamuBaru, tipe, jumlahMalam);
    }

    private static void tampilkanRaservasi() {
        hotelService.tampilkanSemuaRaservasi();
    }

    private static void prosesCheckOut() {
        System.out.println("\n--- FORM CHECK-OUT ---");
        System.out.print("Masukkan Kode Reservasi (cth: RES1): ");
        String kode = scanner.nextLine();
        hotelService.checkOut(kode);
    }
}


