package com.example.demo.string;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;

import com.example.demo.R;

public class StringActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string);

        String s = "test";
        String s2 = "test";
        Log.d("StringActivity", s.concat(s2));

        Log.d("StringActivity", String.format("浮点型" + "%f, 整型" + " %d, 字符串" + "%s", 1.0f, 1, "stringVar"));
        Log.d("StringActivity", getString(R.string.str, 10, 2.0f));

        String s0 = s;
        Log.d("StringActivity", "赋值前" + String.valueOf(s == s0));
        s = "123";
        Log.d("StringActivity", "赋值后" + String.valueOf(s == s0));
    }
}