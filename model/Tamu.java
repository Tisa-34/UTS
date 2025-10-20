package model;


public class Tamu {
    
    private String nik;
    private String nama;
    private String telepon;


    public Tamu (String nik, String nama, String telepon){
        this.nik = nik;
        this.nama = nama;
        this.telepon = telepon;
    }

    public String getNik(){
        return nik;
    }

    public String getNama(){
        return nama;
    }

    public String getTelepon(){
        return telepon;
    }

    @Override
    public String toString(){
        return "NIK: " + nik + " | Nama: " + nama + " | Telepon: " + telepon;
    }
}
