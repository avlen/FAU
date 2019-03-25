package com.example.fau;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class OrderActivity extends AppCompatActivity {
    private Spinner makanan;
    private TextView waktu;
    private TimePickerDialog timePickerDialog;
    private EditText alamatcs;
    private CardView finalorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        makanan = (Spinner) findViewById(R.id.pilihmenu);
        String spinner = (String) makanan.getSelectedItem();

        alamatcs = (EditText) findViewById(R.id.alamat);

        finalorder = (CardView) findViewById(R.id.buatorder);

        waktu = (TextView) findViewById(R.id.waktu);
        waktu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimeDialog();
            }
        });

        makanan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String pilihan = makanan.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        finalorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this, OrderResult.class);
                intent.putExtra("Menu yang dipesan :", makanan.getSelectedItem().toString());
                intent.putExtra("Waktu Pengantaran :", waktu.getText().toString());
                intent.putExtra("Alamat :", alamatcs.getText().toString());
                startActivity(intent);
            }
        });
    }

    private void showTimeDialog() {

        Calendar calendar = Calendar.getInstance();

        timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                waktu.setText("Waktu Pengantaran Pesanan : "+hourOfDay+":"+minute);
            }
        },
                calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE),
                DateFormat.is24HourFormat(this));
        timePickerDialog.show();
    }

}
