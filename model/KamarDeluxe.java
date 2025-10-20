package model;

public class KamarDeluxe extends Kamar{
    private static final double SURCHARGE = 50000.0;

    public KamarDeluxe(String nomorKamar) {
        super (nomorKamar, "Deluxe", 400000.0);

    }

    @Override 
    public double hitungHargaTotal (int jumlahMalam) {
        return (hargaPerMalam + SURCHARGE) * jumlahMalam;
    }

    @Override
    public String getDetailFasilitas() {
        return "Fasilitas: 1 Kasur King Size, AC, Kamar Mandi Dalam, TV Kabel, Kulkas Mini.";
    }
    
}
