package com.kelompok_15.tb_ptb;

public class mahasiswaCard {
    String namaMahasiswa;
    String nimMahasiswa;
    int image;

    public mahasiswaCard(String namaMahasiswa, String nimMahasiswa, int image) {
        this.namaMahasiswa = namaMahasiswa;
        this.nimMahasiswa = nimMahasiswa;
        this.image = image;
    }

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public String getNimMahasiswa() {
        return nimMahasiswa;
    }

    public int getImage() {
        return image;
    }
}
