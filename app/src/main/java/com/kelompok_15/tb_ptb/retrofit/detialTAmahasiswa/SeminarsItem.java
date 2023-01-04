package com.kelompok_15.tb_ptb.retrofit.detialTAmahasiswa;

import com.google.gson.annotations.SerializedName;

public class SeminarsItem{

    @SerializedName("room_id")
    private int roomId;

    @SerializedName("thesis_id")
    private int thesisId;

    @SerializedName("file_slide")
    private Object fileSlide;

    @SerializedName("registered_at")
    private Object registeredAt;

    @SerializedName("method")
    private int method;

    @SerializedName("file_report")
    private Object fileReport;

    @SerializedName("recommendation")
    private int recommendation;

    @SerializedName("description")
    private String description;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("seminar_at")
    private String seminarAt;

    @SerializedName("file_journal")
    private Object fileJournal;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("id")
    private int id;

    @SerializedName("file_attendance")
    private Object fileAttendance;

    @SerializedName("online_url")
    private String onlineUrl;

    @SerializedName("status")
    private int status;

    public int getRoomId(){
        return roomId;
    }

    public int getThesisId(){
        return thesisId;
    }

    public Object getFileSlide(){
        return fileSlide;
    }

    public Object getRegisteredAt(){
        return registeredAt;
    }

    public int getMethod(){
        return method;
    }

    public Object getFileReport(){
        return fileReport;
    }

    public int getRecommendation(){
        return recommendation;
    }

    public String getDescription(){
        return description;
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public String getSeminarAt(){
        return seminarAt;
    }

    public Object getFileJournal(){
        return fileJournal;
    }

    public String getUpdatedAt(){
        return updatedAt;
    }

    public int getId(){
        return id;
    }

    public Object getFileAttendance(){
        return fileAttendance;
    }

    public String getOnlineUrl(){
        return onlineUrl;
    }

    public int getStatus(){
        return status;
    }
}