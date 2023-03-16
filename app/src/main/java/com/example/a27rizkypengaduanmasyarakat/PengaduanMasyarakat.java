package com.example.a27rizkypengaduanmasyarakat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PengaduanMasyarakat extends AppCompatActivity {

    FloatingActionButton fabTambahPengaduan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaduan_masyarakat);

        fabTambahPengaduan = findViewById(R.id.fabTambahPengaduanD);

        fabTambahPengaduan.setOnClickListener((View view) -> {
            startActivity(new Intent(PengaduanMasyarakat.this, BuatPengaduanMasyarakat.class));
        });
    }
}