package com.kelompok_15.tb_ptb.retrofit;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ListJadwal {

    @SerializedName("count")
    private int count;

    @SerializedName("seminars")
    private List<ListJadwalSidangItem> seminars;

    @SerializedName("status")
    private String status;

    public int getCount(){
        return count;
    }

    public List<ListJadwalSidangItem> getSeminars(){
        return seminars;
    }

    public String getStatus(){
        return status;
    }
}

