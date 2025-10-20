package model;

public abstract class Kamar {
    protected String nomorKamar;
    protected String tipeKamar;
    protected double hargaPerMalam;
    protected String status;



    public Kamar(String nomorKamar, String tipeKamar, double hargaPerMalam){
        this.nomorKamar = nomorKamar;
        this.tipeKamar = tipeKamar;
        this.hargaPerMalam = hargaPerMalam;
        this.status = "Kosong";
    }

    public abstract double hitungHargaTotal(int jumlahMalam);
    public abstract String getDetailFasilitas();


    public String getNomorKamar(){
        return nomorKamar;
    }

    public String getTipeKamar(){
        return tipeKamar;
    }

    public double getHargaPerMalam(){
        return hargaPerMalam;
    }

    public String getStatus(){
        return status;
    }


    public void setStatus(String status){
        this.status = status;
    }


    public String toString(){
        return "No. Kamar: " + nomorKamar +
                " | Tipe: " + tipeKamar + 
                " | Harga/Malam: " + hargaPerMalam +
                " | Status: " + status;
    }

    
}
