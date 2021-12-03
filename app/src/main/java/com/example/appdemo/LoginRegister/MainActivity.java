package com.example.appdemo.LoginRegister;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appdemo.FragmentsPage.MenuActivity;
import com.example.appdemo.R;
import com.example.appdemo.helper.DBHelper;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnlogin;
    private EditText edtusername, edtpass;
    private TextView txtregister, showcredential;


    private DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtregister = findViewById(R.id.txtregister);
        edtusername = findViewById(R.id.edtusername);
        edtpass = findViewById(R.id.edtpass);
        btnlogin = findViewById(R.id.btnlogin);
        txtregister = findViewById(R.id.txtregister);
        showcredential = findViewById(R.id.showcredential);

        btnlogin.setOnClickListener(this);
        txtregister.setOnClickListener(this);


        dbHelper = new DBHelper(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case (R.id.btnlogin):
                validationInput();

                break;
            case (R.id.txtregister):
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
                break;
        }


    }

    private void validationInput() {

        String username = edtusername.getText().toString();
        String password = edtpass.getText().toString();

        if (username.equals("") || password.equals(""))
            Toast.makeText(MainActivity.this, "Enter All Field ", Toast.LENGTH_SHORT).show();
        else {
            boolean checkuserpass  = dbHelper.checkUsernamepassword(username ,password);
                if (checkuserpass == true)
                {
                    Toast.makeText(MainActivity.this, "sign in Successfully ", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(this, MenuActivity.class);
                    emptyEditText();
                    startActivity(intent);
                    showcredential.setText("");


                }
                else
                {
                    showcredential.setText("Invalid Credentials");
                    Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();

                }

        }



       /* if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Enter Email-ID ", Toast.LENGTH_SHORT).show();
        } else if (password.matches("")) {
            Toast.makeText(this, "Enter Password ", Toast.LENGTH_SHORT).show();
        } else {
            if (databaseHelper.checkUser(edtusername.getText().toString().trim(), edtpass.getText().toString().trim())) {

                Intent intenthome = new Intent(this, home.class);
                intenthome.putExtra("Email", edtusername.getText().toString().trim());
                startActivity(intenthome);

            } else {
                Toast.makeText(this, "Enter Record is Wrong ", Toast.LENGTH_SHORT).show();
            }

        }*/


    }

    private void emptyEditText() {

        edtpass.setText(null);
        edtusername.setText(null);
    }

}