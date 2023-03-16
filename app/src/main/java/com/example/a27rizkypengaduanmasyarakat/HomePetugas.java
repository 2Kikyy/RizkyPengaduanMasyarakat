package com.example.a27rizkypengaduanmasyarakat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomePetugas extends AppCompatActivity {

    CardView cvAduanMasuk, cvInginMenanggapi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_petugas);

        cvAduanMasuk = findViewById(R.id.aduanMasukD);
        cvInginMenanggapi = findViewById(R.id.inginMenanggapiD);

        cvAduanMasuk.setOnClickListener((View view) -> {
            startActivity(new Intent(HomePetugas.this, AduanMasukAdminPetugas.class));
        });

        cvInginMenanggapi.setOnClickListener((View view) -> {
            startActivity(new Intent(HomePetugas.this, BuatTanggapanAdminPetugas.class));
        });
    }
}