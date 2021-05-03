package com.example.demo.room.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

// 存储历史记录的表，表名叫historyTable，每一个变量对应一列
@Entity(tableName = "historyTable")
public class HistoryEntity {
    // 主键（主码），通过主键可以唯一找到一行数据，在数据库中主键不能重复
    @PrimaryKey
    @NonNull
    public String name;

    // 明确指名列名是timeStamp
    @ColumnInfo(name = "timeStamp")
    public long timeStamp;

    // 告诉数据库不储存这个
    @Ignore
    public String ignoreString;

    @Override
    public String toString() {
        return "HistoryEntity{" +
                "name='" + name + '\'' +
                ", timeStamp=" + timeStamp +
                ", ignoreString='" + ignoreString + '\'' +
                '}';
    }
}
