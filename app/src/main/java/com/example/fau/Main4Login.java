package com.example.fau;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main4Login extends AppCompatActivity {
    TextView register, login;
    EditText user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4_login);

        user = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);
        login = (TextView) findViewById(R.id.textView);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameKey =user.getText().toString();
                String passwordKey = pass.getText().toString();

                if (usernameKey.equals("1234") && passwordKey.equals("1234")){
                    Intent intent = new Intent(Main4Login.this, AfterLogin.class);
                    startActivity(intent);
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Main4Login.this);
                    builder.setMessage("username atau password anda salah.. !").setNegativeButton(
                            "Retry..", null).create().show();
                }
            }
        });


        register = (TextView) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main4Login.this, Main5Register.class);
                startActivity(intent);
            }
        });

    }

}
