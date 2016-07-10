package com.example.ansal007.conflicto;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private final int TIME_OUT = 1000;
    private ProgressDialog dialog;
    private Handler handler;
    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupProgressDialogue();
        setupProgressBar();
        handler = new Handler();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
//        dialog.show();
        spinner.setVisibility(View.VISIBLE);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
//              dialog.hide();
                spinner.setVisibility(View.GONE);
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        }, TIME_OUT);
    }

    public void setupProgressDialogue(){
        dialog = new ProgressDialog(this); // this = YourActivity
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Loading. Please wait...");
        dialog.setIndeterminate(true);
        dialog.setCanceledOnTouchOutside(true);
    }

    public void setupProgressBar(){
        spinner  = (ProgressBar) findViewById(R.id.progress_bar);
    }
}
