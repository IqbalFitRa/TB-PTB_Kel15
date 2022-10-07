package com.kelompok_15.tb_ptb.models;

public class Logbook {
    String agenda;
    String tanggal;

    public Logbook(){}

    public Logbook(String agenda, String tanggal) {
        this.agenda = agenda;
        this.tanggal = tanggal;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
