package model;

public class KamarStandar extends Kamar{
    private static final double DISKON = 0.0;

    public KamarStandar(String nomorKamar){
        super(nomorKamar, "Standar", 250000.0);
    }
    
    @Override
    public double hitungHargaTotal(int jumlahMalam) {
        return (hargaPerMalam * jumlahMalam) * (1 - DISKON);
    }

    @Override
    public String getDetailFasilitas() {
        return "Fasilitas: 1 Kasur Double, AC, Kamar Mandi Dalam.";
    }
}
