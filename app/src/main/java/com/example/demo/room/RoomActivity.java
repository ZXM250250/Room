package com.example.demo.room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.demo.R;
import com.example.demo.room.database.AppDataBase;
import com.example.demo.room.database.entity.HistoryEntity;

import java.util.List;

public class RoomActivity extends AppCompatActivity {
    private Button btnInsert;
    private Button btnGetAll;
    private Button btnUpdate;
    private Button btnDelete;
    private Button btnDeleteAll;
    private TextView tvData;
    private int cnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        btnInsert = findViewById(R.id.btn_insert);
        btnGetAll = findViewById(R.id.btn_get_all);
        btnUpdate = findViewById(R.id.btn_update);
        btnDelete = findViewById(R.id.btn_delete);
        btnDeleteAll = findViewById(R.id.btn_delete_all);
        tvData = findViewById(R.id.tv_data);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        HistoryEntity entity = new HistoryEntity();
                        entity.name = "历史记录" + cnt++;
                        entity.timeStamp = System.currentTimeMillis();
                        AppDataBase.getInstance(RoomActivity.this).historyDao().insertHistory(entity);
                    }
                }).start();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        HistoryEntity entity = new HistoryEntity();
                        // 更新“历史记录0”的时间戳
                        entity.name = "历史记录" + (cnt - 1);
                        entity.timeStamp = System.currentTimeMillis();
                        AppDataBase.getInstance(RoomActivity.this).historyDao().updateHistory(entity);
                    }
                }).start();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        HistoryEntity entity = new HistoryEntity();
                        // 删除“历史记录0”这一项
                        entity.name = "历史记录" + --cnt;
                        entity.timeStamp = System.currentTimeMillis();
                        AppDataBase.getInstance(RoomActivity.this).historyDao().deleteHistory(entity);
                        // 或者下面的写法也可以
                        // AppDataBase.getInstance(RoomActivity.this).historyDao().deleteHistory2("历史记录" + --cnt);
                    }
                }).start();
            }
        });

        btnDeleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        AppDataBase.getInstance(RoomActivity.this).historyDao().deleteAllHistory();
                    }
                }).start();
            }
        });

        btnGetAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        List<HistoryEntity> list = AppDataBase.getInstance(RoomActivity.this)
                                .historyDao().getAllHistory();
                        cnt = list.size();
                        final String data = list.toString();
                        RoomActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tvData.setText(data);
                            }
                        });
                    }
                }).start();
            }
        });
    }
}