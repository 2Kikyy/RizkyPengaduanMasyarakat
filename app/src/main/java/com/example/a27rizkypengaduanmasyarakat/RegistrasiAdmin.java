package com.example.a27rizkypengaduanmasyarakat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RegistrasiAdmin extends AppCompatActivity {

    TextView sudahRegisterAdmin, loginMasyarakat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi_admin);

        sudahRegisterAdmin = findViewById(R.id.sudah_register_admin);
        loginMasyarakat = findViewById(R.id.login_masyarakat);

        sudahRegisterAdmin.setOnClickListener((View view) -> {
            Intent i = new Intent(RegistrasiAdmin.this, LoginAdminPetugasActivity.class);
            startActivity(i);
        });

        loginMasyarakat.setOnClickListener((View view) -> {
            Intent i = new Intent(RegistrasiAdmin.this, LoginMasyarakatActivity.class);
            startActivity(i);
        });
    }
}