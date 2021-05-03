package com.example.demo.room.database;

import android.content.Context;

import androidx.room.Database;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;


import com.example.demo.room.database.converter.EnumConverter;
import com.example.demo.room.database.dao.HistoryDao;
import com.example.demo.room.database.entity.HistoryEntity;

// 指名数据库的实体有哪些，数据库的版本是多少
@Database(entities = {HistoryEntity.class}, version = 1)
// 指名类型转换器TypeConverter有哪些
@TypeConverters(EnumConverter.class)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase instance;

    // 获取historyDao的方法
    public abstract HistoryDao historyDao();

    // 数据库升级1->2
    private static final Migration migration1To2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // 通过执行SQL语句来改变数据库的“型”
            database.execSQL("ALTER TABLE historyTable ADD url TEXT");
        }
    };

    public static AppDataBase getInstance(Context context) {
        if (instance == null) {
            synchronized (AppDataBase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDataBase.class, "app.db")
                            .addMigrations(migration1To2)
                            .build();
                }
            }
        }
        return instance;
    }
}
