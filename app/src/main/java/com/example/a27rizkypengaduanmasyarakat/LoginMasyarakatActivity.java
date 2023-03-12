package com.example.a27rizkypengaduanmasyarakat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginMasyarakatActivity extends AppCompatActivity {

    Connection connect;
    String ConnectionResult = "";
    String usernameDB = "";
    String passwordDB = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_masyarakat);

        EditText username = findViewById(R.id.editTextUsernameD);
        EditText password = findViewById(R.id.editTextPasswordD);
        Button btnLogin = findViewById(R.id.btnLoginD);

        btnLogin.setOnClickListener((View view) -> {

            String usernames = String.valueOf(username);
            String passwords = String.valueOf(password);

            if (username.equals("")) {
                Toast.makeText(getApplicationContext(), "Username harus diisi!", Toast.LENGTH_SHORT).show();
                username.requestFocus();
            } else if (password.equals("")) {
                Toast.makeText(getApplicationContext(), "Password harus diisi!", Toast.LENGTH_SHORT).show();
                password.requestFocus();
            } else {
                try {
                    ConnectionHelper connectionHelper = new ConnectionHelper();
                    connect = connectionHelper.connectionClass();
                    if (connect != null) {
                        String query = "SELECT * FROM masyarakat where username = '" + username.getText() + "' AND password = '" + password.getText() +"'";
                        Statement st = connect.createStatement();
                        ResultSet rs = st.executeQuery(query);

                        while (rs.next()) {
                            usernameDB = rs.getString(3);
                            passwordDB = rs.getString(4);
                            if (usernames.equalsIgnoreCase(usernameDB) && passwords.equalsIgnoreCase(passwordDB)) {
                                Toast.makeText(getApplicationContext(), "Login anda berhasil!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(view.getContext(), HomeMasyarakat.class));
                            } else {
                                Toast.makeText(getApplicationContext(), "Username/Password salah!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    } else {
                        ConnectionResult = "Check Connection!";
                    }
                } catch(Exception ex) {
                    Log.e("Error ", ex.getMessage());
                }
            }
        });
    }
}