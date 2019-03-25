package com.example.fau;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.TextKeyListener;
import android.widget.TextView;

public class OrderResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_result);

        TextView menuresult = (TextView) findViewById(R.id.menuresult);
        TextView wakturesult = (TextView) findViewById(R.id.wakturesult);
        TextView alamatresult = (TextView) findViewById(R.id.alamatresult);

        if (getIntent().getExtras() != null){
            menuresult.setText(getIntent().getStringExtra("Menu yang dipesan :"));
            wakturesult.setText(getIntent().getStringExtra("Waktu Pengantaran :"));
            alamatresult.setText(getIntent().getStringExtra("Alamat :"));
        }
    }
}
