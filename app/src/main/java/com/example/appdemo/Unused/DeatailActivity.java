package com.example.appdemo.Unused;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appdemo.R;

public class DeatailActivity extends AppCompatActivity {

    TextView txtid1,txturl1;
    ResponseModel responseModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deatail);

        txtid1 = findViewById(R.id.txtid1);
        txturl1 = findViewById(R.id.txturl1);



    }
}