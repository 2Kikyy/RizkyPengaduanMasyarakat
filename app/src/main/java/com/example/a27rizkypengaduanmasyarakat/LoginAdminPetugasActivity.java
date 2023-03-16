package com.example.a27rizkypengaduanmasyarakat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginAdminPetugasActivity extends AppCompatActivity {

    TextView loginMasyarakat, belumRegisterAdminPetugas;
    Button bLoginD;
    EditText etUsername, etPassword, etLevel;

    private SQLiteDatabase db;
    private SQLiteOpenHelper openHelper;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin_petugas);

        loginMasyarakat = findViewById(R.id.login_masyarakat);
        belumRegisterAdminPetugas = findViewById(R.id.belum_register_admin_petugas);
        etUsername = findViewById(R.id.editTextUsernameD);
        etPassword = findViewById(R.id.editTextPasswordD);
        etLevel = findViewById(R.id.editTextLevelD);
        bLoginD = findViewById(R.id.btnLoginD);

        loginMasyarakat.setOnClickListener((View view) -> {
            Intent i = new Intent(LoginAdminPetugasActivity.this, LoginMasyarakatActivity.class);
            startActivity(i);
        });

        belumRegisterAdminPetugas.setOnClickListener((View view) -> {
            Intent i = new Intent(LoginAdminPetugasActivity.this, RegistrasiAdmin.class);
            startActivity(i);
        });

        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();

        bLoginD.setOnClickListener((View view) -> {
            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            String level = etLevel.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty() || level.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Harap isi semua kolom!", Toast.LENGTH_SHORT).show();
            } else {
                cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.PETUGAS_TABLE + " WHERE username = ? AND password = ?", new String[]{username, password});
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        if (level.equalsIgnoreCase("petugas")) {
                            cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.PETUGAS_TABLE + " WHERE level = ?", new String[]{level});
                            startActivity(new Intent(LoginAdminPetugasActivity.this, HomePetugas.class));
                            Toast.makeText(getApplicationContext(), "Login berhasil!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Login gagal!", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else if (level.equalsIgnoreCase("admin")) {
                    cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.PETUGAS_TABLE + " WHERE username = ? AND password = ?", new String[]{username, password});
                    if (cursor != null) {
                        if (cursor.getCount() > 0) {
                            if (level.equalsIgnoreCase("admin")) {
                                cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.PETUGAS_TABLE + " WHERE level = ?", new String[]{level});
                                startActivity(new Intent(LoginAdminPetugasActivity.this, HomeAdmin.class));
                                Toast.makeText(getApplicationContext(), "Login berhasil!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "Login gagal!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            }
        });
    }
}