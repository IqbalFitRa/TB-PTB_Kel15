package com.kelompok_15.tb_ptb.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    //public abstract PassDao PassDao();

    //public abstract PassDao passDao();
}
