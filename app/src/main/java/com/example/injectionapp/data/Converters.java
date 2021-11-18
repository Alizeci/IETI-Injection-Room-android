package com.example.injectionapp.data;

import androidx.room.TypeConverter;

import java.util.Date;

/*To store a custom data type in a single database column*/
public class Converters {
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
