package com.example.injectionapp.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.injectionapp.data.dao.UserDao;
import com.example.injectionapp.data.entity.User;
/*Create DB*/
@Database(entities = {User.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
