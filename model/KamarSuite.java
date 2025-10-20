package model;


public class KamarSuite extends Kamar{
    private static final double DISKON_JIKA_LEBIH_DARI_3_MALAM = 0.10;

    public KamarSuite (String nomorKamar) {
        super (nomorKamar, "Suite", 750000.0);
    }
    @Override
    public double hitungHargaTotal (int jumlahMalam) {
        double harga = hargaPerMalam * jumlahMalam;
        if (jumlahMalam > 3) {
            harga *= (1 - DISKON_JIKA_LEBIH_DARI_3_MALAM);
            
        }
        return harga;
    }

    @Override
    public String getDetailFasilitas() {
        return "Fasilitas: Ruang Tamu, Dapur Kecil, 2 Kamar Tidur, Jacuzzi Pribadi, Sarapan Gratis.";
    }
    
}
