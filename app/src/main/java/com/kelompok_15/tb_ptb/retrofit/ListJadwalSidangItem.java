package com.kelompok_15.tb_ptb.retrofit;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ListJadwalSidangItem implements Serializable {

        @SerializedName("MahasiswaItem")
        private MahasiswaItem mahasiswaItem;

        @SerializedName("mahasiswa_id")
        private int mahasiswaId;

        @SerializedName("method")
        private int method;

        @SerializedName("seminar_at")
        private String seminarAt;

        @SerializedName("room_id")
        private int roomId;

        @SerializedName("online_url")
        private Object onlineUrl;

        @SerializedName("file_report")
        private String fileReport;

        @SerializedName("file_slide")
        private String fileSlide;

        @SerializedName("file_journal")
        private String fileJournal;

        @SerializedName("file_attendance")
        private Object fileAttendance;

        @SerializedName("recommendation")
        private Object recommendation;

        @SerializedName("description")
        private Object description;

        @SerializedName("registered_at")
        private String registeredAt;

        @SerializedName("created_at")
        private String createdAt;

        @SerializedName("updated_at")
        private String updatedAt;

        @SerializedName("id")
        private int id;

        @SerializedName("thesis_id")
        private int thesisId;

        @SerializedName("status")
        private int status;

        public MahasiswaItem getMahasiswaItem(){
                return mahasiswaItem;
        }

        public int getMahasiswaIdId(){
                return mahasiswaId;
        }

        public int getMethod(){
                return method;
        }

        public String getSeminarAt(){
                return seminarAt;
        }

        public int getRoomId(){
                return roomId;
        }

        public Object getOnlineUrl(){
                return onlineUrl;
        }

        public String getFileReport(){
                return fileReport;
        }

        public String getFileSlide(){
                return fileSlide;
        }

        public String getFileJournal(){
                return fileJournal;
        }

        public Object getFileAttendance(){
                return fileAttendance;
        }

        public Object getRecommendation(){
                return recommendation;
        }

        public Object getDescription(){
                return description;
        }

        public int getId(){
                return id;
        }

        public int getThesisId(){
                return thesisId;
        }

        public int getStatus(){
                return status;
        }
}
