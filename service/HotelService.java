package Service;

import java.util.ArrayList;
import java.util.List;

import model.Kamar;
import model.KamarDeluxe;
import model.KamarStandar;
import model.KamarSuite;
import model.Raservasi;
import model.Tamu;

public class HotelService {
    private List<Kamar> daftarKamar;
    private List<Raservasi> daftarRaservasi;

    public HotelService() {
        daftarKamar = new ArrayList<>();
        daftarRaservasi = new ArrayList<>();
        inisialisasiKamar();
    }

    private void inisialisasiKamar() {
        daftarKamar.add(new KamarStandar("101"));
        daftarKamar.add(new KamarStandar("102"));
        daftarKamar.add(new KamarDeluxe("201"));
        daftarKamar.add(new KamarDeluxe("202"));
        daftarKamar.add(new KamarSuite("301"));

    }

    public void tampilkanSemuaKamar(){
        System.out.println("\n--- DAFTAR KAMAR HOTEL ---");
        for (Kamar kamar : daftarKamar) {
            System.out.println(kamar.toString() + " | " + kamar.getDetailFasilitas() );
        }
    }

    /** 
   * @param 
   * @return
    */

    public Kamar cariKamarKosong(String tipe) {
        for (Kamar kamar : daftarKamar) {
            if (kamar.getTipeKamar().equalsIgnoreCase(tipe) && kamar.getStatus().equals("Kosong")) {
                return kamar;
            }
        }
        return null;
    }
    public boolean buatRaservasi(Tamu tamu, String tipeKamar, int jumlahMalam) {
        Kamar kamarTersedia = cariKamarKosong(tipeKamar);

        if (kamarTersedia != null) {
            String kode = "RES" + (daftarRaservasi.size() + 1);
            Raservasi raservasiBaru = new Raservasi(kode, tamu, kamarTersedia, jumlahMalam);
            kamarTersedia.setStatus("Terisi");
            daftarRaservasi.add(raservasiBaru);
            System.out.println("\n✅ RESERVASI BERHASIL DIBUAT!");
            System.out.println(raservasiBaru.getDetailRaservasi());
            return true;
            
        } else {
            System.out.println("\n❌ RESERVASI GAGAL! Kamar tipe " + tipeKamar + " sedang Penuh.");
            return false;
        }
    }
    public void tampilkanSemuaRaservasi() {
        if (daftarRaservasi.isEmpty()) {
            System.out.println("\nTidak ada reservasi aktif saat ini.");
            return;
            
        }
        System.out.println("\n--- DAFTAR RESERVASI AKTIF ---");
        for (Raservasi res : daftarRaservasi) {
            System.out.println("================================");
            System.out.println(res.getDetailRaservasi());
        }
    }
    public boolean checkOut(String kodeRaservasi) {
        for (Raservasi res : daftarRaservasi){
            if (res.getKodeRaservasi().equalsIgnoreCase(kodeRaservasi) && res.getStatusPembayaran().equals("Belum Lunas")) {
                res.setStatusPembayaran("LUNAS");
                res.getKamar().setStatus("Kosong");
                System.out.println("\n✅ CHECK-OUT BERHASIL!");
                System.out.println("Kamar " + res.getKamar().getNomorKamar() + " telah dikosongkan.");
                System.out.println("Total Biaya: Rp " + String.format("%.0f", res.getTotalBiaya()) + " (LUNAS)");
                return true;
                
            }
        }
        System.out.println("\n❌ CHECK-OUT GAGAL! Kode reservasi tidak ditemukan atau sudah lunas.");
        return false;
    }
    
}
