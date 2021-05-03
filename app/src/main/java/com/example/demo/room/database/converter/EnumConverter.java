package com.example.demo.room.database.converter;

import androidx.room.TypeConverter;

import com.example.demo.room.database.EnumDemo;

public class EnumConverter {
    // int转枚举
    @TypeConverter
    public EnumDemo intToEnum(int status) {
        return EnumDemo.values()[status];
    }

    // 枚举转int
    @TypeConverter
    public int enumToInt(EnumDemo enumDemo) {
        return enumDemo.ordinal();
    }
}
