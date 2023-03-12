package com.example.a27rizkypengaduanmasyarakat;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {
    Connection conn;
    String uname, pass, ip, port, database;

    @SuppressLint("NewApi")
    public Connection connectionClass() {
        ip = "172.1.1.0";
        database = "pengaduan_masyarakat";
        uname = "sa";
        pass = "kiky17";
        port = "1433";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String ConnectionURL = null;

        try {
            Class.forName("net.sourceforge.jdts.jdbc.Driver");
            ConnectionURL = "jdbc:jdts:sqlserver://" + ip + ":" + port + ";" + "databasename = " + database + ";user = " + uname + ";password = " + pass + ";";
            connection = DriverManager.getConnection(ConnectionURL);
        } catch (Exception ex) {
            Log.e("Error ", ex.getMessage());
        }

        return connection;
    }
}
