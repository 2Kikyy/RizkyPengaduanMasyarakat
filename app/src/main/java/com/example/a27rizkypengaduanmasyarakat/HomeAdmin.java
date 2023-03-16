package com.example.a27rizkypengaduanmasyarakat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeAdmin extends AppCompatActivity {

    CardView cvAduanMasuk, cvInginMenanggapi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);

        cvAduanMasuk = findViewById(R.id.aduanMasuk);
        cvInginMenanggapi = findViewById(R.id.inginMenanggapi);

        cvAduanMasuk.setOnClickListener((View view) -> {
            startActivity(new Intent(HomeAdmin.this, AduanMasukAdminPetugas.class));
        });

        cvInginMenanggapi.setOnClickListener((View view) ->{
           startActivity(new Intent(HomeAdmin.this, BuatTanggapanAdminPetugas.class));
        });
    }
}