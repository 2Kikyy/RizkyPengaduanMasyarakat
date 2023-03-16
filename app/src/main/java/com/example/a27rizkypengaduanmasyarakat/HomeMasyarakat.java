package com.example.a27rizkypengaduanmasyarakat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeMasyarakat extends AppCompatActivity {

    CardView cvComplaint, cvDitanggapi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_masyarakat);

        cvComplaint = findViewById(R.id.complaint);
        cvDitanggapi = findViewById(R.id.ditanggapi);

        cvComplaint.setOnClickListener((View view) -> {
            startActivity(new Intent(HomeMasyarakat.this, PengaduanMasyarakat.class));
        });

        cvDitanggapi.setOnClickListener((View view) -> {
            startActivity(new Intent(HomeMasyarakat.this, DitanggapiMasyarakat.class));
        });
    }
}