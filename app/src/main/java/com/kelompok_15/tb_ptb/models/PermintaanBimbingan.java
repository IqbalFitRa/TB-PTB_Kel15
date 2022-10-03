package com.kelompok_15.tb_ptb.models;

public class PermintaanBimbingan {

    String profil;
    String nama;
    String nim;

    public PermintaanBimbingan(){

    }

    public PermintaanBimbingan(String profil, String nama, String nim) {
        this.profil = profil;
        this.nama = nama;
        this.nim = nim;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }
}
