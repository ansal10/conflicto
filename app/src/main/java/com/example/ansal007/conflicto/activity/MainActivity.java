package com.example.ansal007.conflicto.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ansal007.conflicto.R;

public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private static final int NEW_ACTIVITY_TIMEOUT = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, SigninActivity.class);
                startActivity(intent);
                finish();
            }
        }, NEW_ACTIVITY_TIMEOUT);
    }


}
