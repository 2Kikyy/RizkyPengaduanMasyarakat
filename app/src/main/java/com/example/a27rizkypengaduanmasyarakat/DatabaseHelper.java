package com.example.a27rizkypengaduanmasyarakat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.StrictMode;
import android.util.Log;

import androidx.annotation.Nullable;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "pengaduan_masyarakat.db";
    public static final String MASYARAKAT_TABLE = "user_masyarakat";
    public static final String PETUGAS_TABLE = "user_petugas";
    public static final String ADMIN_TABLE = "user_admin";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + MASYARAKAT_TABLE + " (nik text(16) primary key, namaLengkap text(35), username text(25), password text(32), telp text(13))");
        db.execSQL("INSERT INTO " + MASYARAKAT_TABLE + " VALUES ('00123', 'rizky', 'rizky123', '123', '08977523111')");

        db.execSQL("CREATE TABLE " + PETUGAS_TABLE + " (id_petugas text(11) primary key, nama_petugas text(35), username text(25), password text(32), telp text(13), level text(10))");
        db.execSQL("INSERT INTO " + PETUGAS_TABLE + " VALUES ('02001', 'andria permani', 'andria12', '123', '08977342122', 'petugas')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + MASYARAKAT_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + PETUGAS_TABLE);
        onCreate(db);
    }
}
