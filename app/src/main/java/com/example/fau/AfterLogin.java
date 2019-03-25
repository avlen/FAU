package com.example.fau;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class AfterLogin extends AppCompatActivity {

    private LinearLayout lMenu, lOrder, lEvent, lAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AfterLogin.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        lMenu = (LinearLayout) findViewById(R.id.menu);
        lOrder = (LinearLayout) findViewById(R.id.order);

        lOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(AfterLogin.this, OrderActivity.class);
                startActivity(i2);
            }
        });

        lMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(AfterLogin.this, Main2Activity.class);
                startActivity(i1);
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
}
