package com.example.a27rizkypengaduanmasyarakat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginMasyarakatActivity extends AppCompatActivity {

    Button show;
    EditText hideUsername, hidePassword;
    ImageView bg1;
    TextView belumRegisterMasyarakat, loginAdminPetugas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_masyarakat);

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