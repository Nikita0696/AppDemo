package com.example.appdemo.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = " LoginUser.db ";
    public DBHelper(Context context) {
        super(context, " LoginUser.db ", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table users (username TEXT primary key , password Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop Table if exists users");

    }

    public boolean insertData(String username , String password)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username" , username);
        values.put("password" , password);

        long result = sqLiteDatabase.insert("users", null, values);
        if (result == -1 )
            return false;
        else
            return true;
    }

    public boolean checkUsername(String username)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from users where username = ?", new String[]{username});
        if(cursor.getCount() > 0 )
            return true;
        else
            return false;
    }

    public boolean checkUsernamepassword(String username , String password)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from users where username = ? and password = ?", new String[]{username , password});
        if (cursor.getCount() > 0 )
            return true;
        else
            return false;




    }
}
