package com.kelompok_15.tb_ptb.models;

public class JadwalSeminardanSidang {

    String gambar;
    String nama_mahasiswa;
    String nim;
    String tanggal;

    public JadwalSeminardanSidang(){}

    public JadwalSeminardanSidang(String gambar, String nama_mahasiswa, String nim, String tanggal) {
        this.gambar = gambar;
        this.nama_mahasiswa = nama_mahasiswa;
        this.nim = nim;
        this.tanggal = tanggal;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getNama_mahasiswa() {
        return nama_mahasiswa;
    }

    public void setNama_mahasiswa(String nama_mahasiswa) {
        this.nama_mahasiswa = nama_mahasiswa;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}

