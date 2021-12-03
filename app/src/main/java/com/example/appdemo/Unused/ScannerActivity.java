package com.example.appdemo.Unused;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appdemo.FragmentsPage.ScannerViewActivity;
import com.example.appdemo.R;

public class ScannerActivity extends AppCompatActivity {

    private Button btnscan;
    public  static TextView scantext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        btnscan = findViewById(R.id.btnscan);
        scantext = findViewById(R.id.scantext);


        btnscan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(getApplicationContext(), ScannerViewActivity.class));
            }
        });
    }
}