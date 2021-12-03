package com.example.appdemo.LoginRegister;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appdemo.R;
import com.example.appdemo.helper.DBHelper;


public class Register extends AppCompatActivity implements View.OnClickListener {

    private EditText edtname , edtuser, emailedt, edtpassword, edtrpassword;

    private Button btnsubmit;
    private TextView txtlogin;



    private DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtname = findViewById(R.id.edtname);
        edtuser = findViewById(R.id.edtuser);
        emailedt = findViewById(R.id.emailedt);
        edtpassword = findViewById(R.id.edtpassword);
        edtrpassword = findViewById(R.id.edtrpassword);
        btnsubmit = findViewById(R.id.btnsubmit);
        txtlogin = findViewById(R.id.txtlogin);

        btnsubmit.setOnClickListener(this);
        dbHelper = new DBHelper(this);


        txtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent   intent = new Intent(Register.this ,MainActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onClick(View v) {

        validate();
    }

    private void validate() {

        /*String name = edtname.getText().toString();
        String email = emailedt.getText().toString();
        String password = edtuser.getText().toString();
        String confirmPassword = edtpassword.getText().toString();
        String phoneNumber = edtpassword.getText().toString();

        if (name.matches(""))
        {
            Toast.makeText(this,"Enter Name ",Toast.LENGTH_SHORT).show();
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            Toast.makeText(this,"Enter Email-ID ",Toast.LENGTH_SHORT).show();
        }
        else if (!password.equals(confirmPassword))
        {
            Toast.makeText(this,"Password Not Matching ",Toast.LENGTH_SHORT).show();
        }
        else if (password.matches("") && confirmPassword.matches(""))
        {
            Toast.makeText(this,"Enter Password ",Toast.LENGTH_SHORT).show();
        }
        else if (!Patterns.PHONE.matcher(phoneNumber).matches())
        {
            Toast.makeText(this,"Enter Phone Number ",Toast.LENGTH_SHORT).show();
        }
        else
        {
            if (!databaseHelper.checkUser(emailedt.getText().toString().trim()))
            {
                user.setName(edtname.getText().toString().trim());
                user.setEmail(emailedt.getText().toString().trim());
                user.setPassword(edtuser.getText().toString().trim());
                user.setPhoneNumber(Integer.parseInt(edtpassword.getText().toString().trim()));

                databaseHelper.addUser(user);


                Toast.makeText(this,"Successfully Register ",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Register.this , MainActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "Enter Record  ", Toast.LENGTH_SHORT).show();
            }


        }*/

        String username = edtuser.getText().toString();
        String password = edtpassword.getText().toString();
        String rpassword = edtrpassword.getText().toString();
        String name = edtname.getText().toString();
        String email = emailedt.getText().toString();


        if (username.equals("") || password.equals("") || name.equals("") || email.equals("")) {
            Toast.makeText(this, "Enter All Field ", Toast.LENGTH_SHORT).show();
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Enter Proper Email-ID ", Toast.LENGTH_SHORT).show();
        }else {
            if (password.equals(rpassword)) {
                boolean checkuser = dbHelper.checkUsername(username);
                if (checkuser == false) {
                    boolean insert = dbHelper.insertData(username, password);
                    if (insert == true) {
                        Toast.makeText(this, "Register Successfully ", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(this, MainActivity.class);
                        emptyEditText();
                        startActivity(intent);
                    } else {
                        Toast.makeText(this, "Registeration Failed", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Intent intent = new Intent(this,MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(this, "User Already Exists Please Login", Toast.LENGTH_SHORT).show();
                }

            } else {

                Toast.makeText(this, "Password Not Matched", Toast.LENGTH_SHORT).show();

            }
        }
    }

    private void emptyEditText() {

        edtname .setText(null);
        edtuser.setText(null);
        edtrpassword.setText(null);
        edtpassword.setText(null);
        emailedt.setText(null);
    }

}