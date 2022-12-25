package com.kelompok_15.tb_ptb.models;

import com.kelompok_15.tb_ptb.SeminarMahasiswaActivity;

public class SeminarMahasiswa {

    String wujud;
    String nama;
    String nim;

    public SeminarMahasiswa(){}

    public SeminarMahasiswa(String wujud, String nama, String nim)
    {
        this.wujud=wujud;
        this.nama=nama;
        this.nim=nim;

    }

    public String getWujud ()
    {
        return wujud;
    }
    public void setWujud (String wujud)
    {
        this.wujud=wujud;
    }

    public String getNama()
    {
        return nama;
    }

    public void setNama (String nama)
    {
        this.nama=nama;
    }

    public String getNim()
    {
        return nim;
    }

    public void setNim (String nim)
    {
        this.nim=nim;
    }

}
