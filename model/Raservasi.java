package model;


public class Raservasi {
    private String KodeRaservasi;
    private Tamu tamu;
    private Kamar kamar;
    private int jumlahMalam;
    private double totalBiaya;
    private String statusPembayaran;


    public Raservasi(String KodeRaservasi, Tamu tamu, Kamar kamar, int jumlahMalam) {
        this.KodeRaservasi = KodeRaservasi;
        this.tamu = tamu;
        this.kamar = kamar;
        this.jumlahMalam = jumlahMalam;
        this.totalBiaya = kamar.hitungHargaTotal(jumlahMalam);
        this.statusPembayaran = "Belum DiBayar";
    }
    

    public String getKodeRaservasi(){
        return KodeRaservasi;
    }
    public Tamu getTamu(){
        return tamu;
    }
    public Kamar getKamar(){
        return kamar;
    }
    public int getJumlahMalam(){
        return jumlahMalam;
    }
    public double getTotalBiaya(){
        return totalBiaya;
    }
    public String getStatusPembayaran(){
        return statusPembayaran;
    }

    public void setStatusPembayaran (String statusPembayaran){
        this.statusPembayaran = statusPembayaran;
    }

    public String getDetailRaservasi(){
        return  "\n--- Detail Raservasi " + KodeRaservasi + " ---" +
                "\n" + tamu.toString() +
                "\nKamar Dipilih: " + kamar.getNomorKamar() + " (" + kamar.getTipeKamar() + ")" +
                "\n" + kamar.getDetailFasilitas() + // Menampilkan fasilitas spesifik kamar (Polimorfisme)
                "\nLama Menginap: " + jumlahMalam + " malam" +
                "\nTotal Biaya: Rp " + String.format("%.0f", totalBiaya) +
                "\nStatus: " + statusPembayaran;
    }
}
