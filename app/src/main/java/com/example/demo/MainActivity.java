package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.demo.leak.LeakActivity;
import com.example.demo.room.RoomActivity;
import com.example.demo.string.StringActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnRoom;
    private Button btnString;
    private Button btnLeak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRoom = findViewById(R.id.btn_room);
        btnString = findViewById(R.id.btn_string);
        btnLeak = findViewById(R.id.btn_leak);

        btnRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RoomActivity.class));
            }
        });

        btnString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StringActivity.class));
            }
        });

        btnLeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LeakActivity.class));
            }
        });
    }
}