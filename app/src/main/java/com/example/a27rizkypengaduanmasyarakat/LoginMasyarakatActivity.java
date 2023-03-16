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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginMasyarakatActivity extends AppCompatActivity {

    Button show, btnLogin;
    EditText hideUsername, hidePassword, etUsername, etPassword;

    private SQLiteDatabase db;
    private SQLiteOpenHelper openHelper;
    private Cursor cursor;
    ImageView bg1;
    TextView belumRegisterMasyarakat, loginAdminPetugas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_masyarakat);

        belumRegisterMasyarakat = findViewById(R.id.belum_register_masyarakat);
        loginAdminPetugas = findViewById(R.id.login_admin_petugas);

        belumRegisterMasyarakat.setOnClickListener((View view) -> {
            Intent intent = new Intent(LoginMasyarakatActivity.this, RegistrasiMasyarakat.class);
            startActivity(intent);
        });

        loginAdminPetugas.setOnClickListener((View view) ->{
            Intent intent = new Intent(LoginMasyarakatActivity.this, LoginAdminPetugasActivity.class);
            startActivity(intent);
        });

        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();
        etUsername = findViewById(R.id.editTextUsernameD);
        etPassword = findViewById(R.id.editTextPasswordD);
        btnLogin = findViewById(R.id.btnLoginD);

        btnLogin.setOnClickListener((View view) ->{
           String username = etUsername.getText().toString().trim();
           String password = etPassword.getText().toString().trim();
           if(username.isEmpty() || password.isEmpty()) {
               Toast.makeText(LoginMasyarakatActivity.this, "Enter your username and password to login!", Toast.LENGTH_SHORT).show();
           } else {
               cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.MASYARAKAT_TABLE + " WHERE + username = ? AND password = ?", new String[]{username, password});
               if (cursor != null) {
                   if (cursor.getCount() > 0) {
                       startActivity(new Intent(LoginMasyarakatActivity.this, HomeMasyarakat.class));
                       Toast.makeText(getApplicationContext(), "Login sukses!", Toast.LENGTH_SHORT).show();
                   } else {
                       Toast.makeText(getApplicationContext(), "Login Error", Toast.LENGTH_SHORT).show();
                   }
               }
           }
        });

//        EditText username = findViewById(R.id.editTextUsernameD);
//        EditText password = findViewById(R.id.editTextPasswordD);
//        Button btnLogin = findViewById(R.id.btnLoginD);
//        bg1 = findViewById(R.id.imgBgApp);
//        hideUsername = findViewById(R.id.editTextUsernameD);
//        hidePassword = findViewById(R.id.editTextPasswordD);
//
//        hideUsername.setOnClickListener((View view) -> {
//            bg1.setVisibility(View.INVISIBLE);
//        });
//
//        hidePassword.setOnClickListener((View view) -> {
//            bg1.setVisibility(View.INVISIBLE);
//        });

    }

//    @Override
//    public void onBackPressed() {
//        bg1 = findViewById(R.id.imgBgApp);
//        bg1.setVisibility(View.VISIBLE);
//    }
}