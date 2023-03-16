package com.example.a27rizkypengaduanmasyarakat;

import static com.example.a27rizkypengaduanmasyarakat.DatabaseHelper.MASYARAKAT_TABLE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrasiMasyarakat extends AppCompatActivity {

    TextView sudahRegisterMasyarakat, loginAdminPetugas;
    private Button btnRegister;
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private EditText etNik, etNamaLengkap, etTelepon, etUsername, etPassword;

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

        openHelper = new DatabaseHelper(this);

        btnRegister = findViewById(R.id.btnRegisterD);
        etNik = findViewById(R.id.editTextNikD);
        etNamaLengkap = findViewById(R.id.editTextNamaLengkapD);
        etUsername = findViewById(R.id.editTextUsernameD);
        etPassword = findViewById(R.id.editTextPasswordD);
        etTelepon = findViewById(R.id.editTextTeleponD);

        btnRegister.setOnClickListener((View view) -> {
            db = openHelper.getWritableDatabase();
            String nik = etNik.getText().toString().trim();
            String namaLengkap = etNamaLengkap.getText().toString().trim();
            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            String telepon = etTelepon.getText().toString().trim();

            if (nik.isEmpty() || namaLengkap.isEmpty() || username.isEmpty() || password.isEmpty() || telepon.isEmpty()) {
                Toast.makeText(RegistrasiMasyarakat.this, "Harap isi semua field yang ada!", Toast.LENGTH_SHORT).show();
            } else {

                db.execSQL("INSERT INTO " + MASYARAKAT_TABLE + " VALUES (" + nik + ", '" + namaLengkap + "', '" + username + "', '" + password + "', '" + telepon + "');");

                Toast.makeText(RegistrasiMasyarakat.this, "Registrasi berhasil!", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(RegistrasiMasyarakat.this, LoginMasyarakatActivity.class));
            }
        });
    }
}