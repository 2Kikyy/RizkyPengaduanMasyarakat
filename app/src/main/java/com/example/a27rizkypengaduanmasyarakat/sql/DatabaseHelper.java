package com.example.a27rizkypengaduanmasyarakat.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.a27rizkypengaduanmasyarakat.UserMasyarakat;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database version
    private static final int DATABASE_VERSION = 1;
    // Database name
    private static final String DATABASE_NAME = "UserManager.db";

    // User table name
    private static final String TABLE_MASYARAKAT_USER = "masyarakat";

    // User table column names
    private static final String COLUMN_MASYARAKAT_NIK = "masyarakat_nik";
    private static final String COLUMN_MASYARAKAT_NAMA = "masyarakat_nama";
    private static final String COLUMN_MASYARAKAT_USERNAME = "masyarakat_username";
    private static final String COLUMN_MASYARAKAT_PASSWORD = "masyarakat_password";
    private static final String COLUMN_MASYARAKAT_TELP = "masyarakat_telp";

    // Create table SQL Query
    private static final String CREATE_MASYARAKAT_TABLE = "CREATE TABLE " + TABLE_MASYARAKAT_USER + "("
            + COLUMN_MASYARAKAT_NIK + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_MASYARAKAT_NAMA + " TEXT,"
            + COLUMN_MASYARAKAT_USERNAME + " TEXT," + COLUMN_MASYARAKAT_PASSWORD + " TEXT,"
            + COLUMN_MASYARAKAT_TELP + " TEXT" + ")";

    // Drop table SQL Query
    private String DROP_MASYARAKAT_TABLE = "DROP TABLE IF EXISTS " + TABLE_MASYARAKAT_USER;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_MASYARAKAT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop masyarakat table if exist
        db.execSQL(DROP_MASYARAKAT_TABLE);

        // Create tables again
        onCreate(db);
    }

    public void addUserMasyarakat(UserMasyarakat userMasyarakat) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_MASYARAKAT_NIK, userMasyarakat.getNik());
        values.put(COLUMN_MASYARAKAT_NAMA, userMasyarakat.getName());
        values.put(COLUMN_MASYARAKAT_USERNAME, userMasyarakat.getUsername());
        values.put(COLUMN_MASYARAKAT_PASSWORD, userMasyarakat.getPassword());

        // Inserting row
        db.insert(TABLE_MASYARAKAT_USER, null, values);
        db.close();
    }

    public List<UserMasyarakat> getAllUser() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_MASYARAKAT_NIK,
                COLUMN_MASYARAKAT_NAMA,
                COLUMN_MASYARAKAT_USERNAME,
                COLUMN_MASYARAKAT_PASSWORD
        };
        // sorting orders
        String sortOrder =
                COLUMN_MASYARAKAT_USERNAME + " ASC";
        List<UserMasyarakat> userList = new ArrayList<UserMasyarakat>();
        SQLiteDatabase db = this.getReadableDatabase();
        // query the user table
        /**
         * Here query function is used to fetch records from masyarakat user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_MASYARAKAT_USER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order
        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                UserMasyarakat userMasyarakat = new UserMasyarakat();
                userMasyarakat.setNik(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_MASYARAKAT_NIK))));
                userMasyarakat.setName(cursor.getString(cursor.getColumnIndex(COLUMN_MASYARAKAT_NAMA)));
                userMasyarakat.setUsername(cursor.getString(cursor.getColumnIndex(COLUMN_MASYARAKAT_USERNAME)));
                userMasyarakat.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_MASYARAKAT_PASSWORD)));
                // Adding user record to list
                userList.add(userMasyarakat);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        // return user list
        return userList;
    }

    public void updateUserMasyarakat(UserMasyarakat userMasyarakat) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_MASYARAKAT_NIK, userMasyarakat.getNik());
        values.put(COLUMN_MASYARAKAT_NAMA, userMasyarakat.getName());
        values.put(COLUMN_MASYARAKAT_USERNAME, userMasyarakat.getUsername());
        values.put(COLUMN_MASYARAKAT_PASSWORD, userMasyarakat.getPassword());

        // Inserting row
        db.update(TABLE_MASYARAKAT_USER, values, COLUMN_MASYARAKAT_NIK + " = ?", new String[]{String.valueOf(userMasyarakat.getNik())});
        db.close();
    }

    public void deleteUserMasyarakat(UserMasyarakat userMasyarakat) {
        SQLiteDatabase db = this.getWritableDatabase();

        // delete masyarakat user record by nik
        db.delete(TABLE_MASYARAKAT_USER, COLUMN_MASYARAKAT_NIK + " = ?", new String[]{String.valueOf(userMasyarakat.getNik())});
        db.close();
    }
}
