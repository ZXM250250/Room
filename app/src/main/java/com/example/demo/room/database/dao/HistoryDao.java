package com.example.demo.room.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.demo.room.database.entity.HistoryEntity;

import java.util.List;

@Dao
public interface HistoryDao {
    // 执行SQL语句，查询所有历史记录，返回可以是数组也可以是List
    @Query("SELECT * FROM historyTable")
    List<HistoryEntity> getAllHistory();

    // 执行SQL语句，查询给定时间戳的历史记录
    @Query("SELECT * FROM historyTable WHERE timeStamp = :timeStamp")
    List<HistoryEntity> getHistoryByTimeStamp(long timeStamp);

    // 查询的时候传递一组参数, 查询所有name值在传入的List里面的行（数据）
    @Query("SELECT name, timeStamp FROM historyTable WHERE name IN (:names)")
    List<HistoryEntity> getHistory(List<String> names);

    // 插入一条历史记录，onConflict指的是在插入时发生冲突该怎么办
    // public @interface OnConflictStrategy {
    //    // 替换旧的数据
    //    int REPLACE = 1;
    //    // 回滚事务，相当于啥也没做，被废弃，用ABORT替代
    //    int ROLLBACK = 2;
    //    // 回滚事务
    //    int ABORT = 3;
    //    // 使事务失败(Does not work as expected. The transaction is rolled back.)，被废弃，用ABORT替代
    //    int FAIL = 4;
    //    // 忽略冲突
    //    int IGNORE = 5;
    // }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertHistory(HistoryEntity entity);

    // 删除一条历史记录，会根据参数里面的PrimaryKey做删除操作
    @Delete
    void deleteHistory(HistoryEntity entity);
    // 删除也可以通过Query实现，如下
    @Query("DELETE FROM historyTable WHERE name = :name")
    void deleteHistory2(String name);
    // 删除所有数据
    @Query("DELETE FROM historyTable")
    void deleteAllHistory();

    // 更新一条历史记录的数据，会根据参数里面的PrimaryKey做更新操作
    @Update
    void updateHistory(HistoryEntity entity);
}
