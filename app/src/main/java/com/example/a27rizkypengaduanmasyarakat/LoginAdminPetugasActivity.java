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
    private Cursor cursor, cursor2;

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
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String level = etLevel.getText().toString().trim();
        cursor2 = db.rawQuery("SELECT * FROM " + DatabaseHelper.PETUGAS_TABLE + " WHERE username = ? AND password = ?", new String[]{username, password});

        bLoginD.setOnClickListener((View view) -> {
            if (cursor2.getCount() == 1) {
                cursor2.moveToPosition(0);
                String namaLengkapSqlite = cursor2.getString(1).toString();
                String levelSqlite = cursor2.getString(6).toString();
                if (level.equalsIgnoreCase("petugas")) {
                    Toast.makeText(getApplicationContext(), "Berhasil masuk!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginAdminPetugasActivity.this, HomePetugas.class);
                    intent.putExtra("namaLengkap", namaLengkapSqlite);
                    startActivity(intent);
                    finish();
                } else if (level.equalsIgnoreCase("admin")) {
                    Toast.makeText(getApplicationContext(), "Berhasil masuk!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginAdminPetugasActivity.this, HomeAdmin.class);
                    intent.putExtra("namaLengkap", namaLengkapSqlite);
                    startActivity(intent);
                    finish();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Nama pengguna atau Kata sandi salah !", Toast.LENGTH_SHORT).show();
            }
        });
    }
}