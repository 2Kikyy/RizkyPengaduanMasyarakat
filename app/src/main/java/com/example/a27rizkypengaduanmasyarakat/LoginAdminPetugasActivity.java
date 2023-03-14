package com.example.a27rizkypengaduanmasyarakat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginAdminPetugasActivity extends AppCompatActivity {

    TextView loginMasyarakat, belumRegisterAdminPetugas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin_petugas);

        loginMasyarakat = findViewById(R.id.login_masyarakat);
        belumRegisterAdminPetugas = findViewById(R.id.belum_register_admin_petugas);

        loginMasyarakat.setOnClickListener((View view) -> {
            Intent i = new Intent(LoginAdminPetugasActivity.this, LoginMasyarakatActivity.class);
            startActivity(i);
        });

        belumRegisterAdminPetugas.setOnClickListener((View view) -> {
            Intent i = new Intent(LoginAdminPetugasActivity.this, RegistrasiAdmin.class);
            startActivity(i);
        });
    }
}