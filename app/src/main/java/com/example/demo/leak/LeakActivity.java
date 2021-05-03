package com.example.demo.leak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.LruCache;

import com.example.demo.R;

import java.util.LinkedHashMap;

public class LeakActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak);
//        String
//        LinkedHashMap
//        LruCache
        // 造成内存泄漏
        LeakDemo.activity = this;
    }
}