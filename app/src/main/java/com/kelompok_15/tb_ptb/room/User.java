package com.kelompok_15.tb_ptb.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {
    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "no_hp")
    public String no_hp;
}