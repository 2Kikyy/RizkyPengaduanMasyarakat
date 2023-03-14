package com.example.a27rizkypengaduanmasyarakat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RegistrasiMasyarakat extends AppCompatActivity {

    TextView sudahRegisterMasyarakat, loginAdminPetugas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi_masyarakat);

        sudahRegisterMasyarakat = findViewById(R.id.sudah_register_masyarakat);
        loginAdminPetugas = findViewById(R.id.login_admin_petugas);

        sudahRegisterMasyarakat.setOnClickListener((View view) ->{
            Intent i = new Intent(RegistrasiMasyarakat.this, LoginMasyarakatActivity.class);
            startActivity(i);
        });

        loginAdminPetugas.setOnClickListener((View view) -> {
            Intent i = new Intent(RegistrasiMasyarakat.this, LoginAdminPetugasActivity.class);
            startActivity(i);
        });
    }
}