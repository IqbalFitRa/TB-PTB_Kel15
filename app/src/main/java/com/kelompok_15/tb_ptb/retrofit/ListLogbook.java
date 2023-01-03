package com.kelompok_15.tb_ptb.retrofit;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ListLogbook implements Serializable {

    @SerializedName("count")
    private int count;

    @SerializedName("logbooks")
    private List<LogbooksItem> logbooks;

    @SerializedName("status")
    private String status;

    public int getCount(){
        return count;
    }

    public List<LogbooksItem> getLogbooks(){
        return logbooks;
    }

    public String getStatus(){
        return status;
    }
}