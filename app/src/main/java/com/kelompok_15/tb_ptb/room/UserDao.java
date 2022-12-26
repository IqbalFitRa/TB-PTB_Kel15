package com.kelompok_15.tb_ptb.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM users")
    List<User> getAll();

    @Insert
    void insert(User user);

    @Delete
    void delete(User user);
}