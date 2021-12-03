package com.example.appdemo.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.appdemo.Unused.User;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper  extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "UserManager.db";

    private static final String TABLE_USER = "user";

    private  static final String COLUMN_USER_ID = "user_id";
    private  static final String COLUMN_USER_NAME = "user_name";
    private  static final String COLUMN_USER_EMAIL = "user_email";
    private  static final String COLUMN_USER_PASSWORD = "user_password";
    private  static final String COLUMN_USER_PHONE_NUMBER = "user_phonenumber";

    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "(" + COLUMN_USER_ID  +
            " INTEGER PRIMARY KEY AUTOINCREMENT , " + COLUMN_USER_NAME + " TEXT, " + COLUMN_USER_EMAIL +
            " TEXT ," + COLUMN_USER_PASSWORD + " TEXT, " + COLUMN_USER_PHONE_NUMBER + " INTERGER "  + ")" ;

    private String DROP_USER_TABLE = " DROP TABLE IF EXISTS " + TABLE_USER;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_USER_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DROP_USER_TABLE);
        onCreate(db);

    }

    public void addUser(User user)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_USER_NAME ,user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD,user.getPassword());
        values.put(COLUMN_USER_PHONE_NUMBER,user.getPhoneNumber());

        db.insert(TABLE_USER,null,values);
        /*db.close();*/
    }


    public List<User> getAlluser()
    {
        String[] columns = {
                COLUMN_USER_ID,
                COLUMN_USER_NAME,
                COLUMN_USER_EMAIL,
                COLUMN_USER_PASSWORD,
                COLUMN_USER_PHONE_NUMBER
        };

        String sortOrder = COLUMN_USER_NAME + "ASC";

        List<User> userList = new ArrayList<User>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(TABLE_USER,
                columns,
                null,
                null,
                null,
                null,sortOrder);
        if (cursor.moveToFirst())
        {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID))));
                user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));
                user.setPhoneNumber(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD))));
                userList.add(user);
            }while (cursor.moveToNext());


        }
        cursor.close();
        sqLiteDatabase.close();
        return userList;
    }
    public void deleteUser(User user)
    {
        SQLiteDatabase db =this.getWritableDatabase();

        db.delete(TABLE_USER , COLUMN_USER_ID + " = ? ",
                new String[] {String.valueOf(user.getId())});
        db.close();
    }

    public void updateUser(User user)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME,user.getName());
        values.put(COLUMN_USER_EMAIL,user.getEmail());
        values.put(COLUMN_USER_PASSWORD,user.getPassword());
        values.put(COLUMN_USER_PHONE_NUMBER,user.getPhoneNumber());

        db.update(TABLE_USER,values,COLUMN_USER_ID + " =? ",
                new String[]{String.valueOf(user.getId())});
    }

    public boolean checkUser(String email)
    {
        String[] columns = {
                COLUMN_USER_ID
        };

        SQLiteDatabase db = this.getReadableDatabase();

        String selectionuser = COLUMN_USER_EMAIL + " = ? ";
        String[] selectionArg  = {email};

        Cursor cursor = db.query(TABLE_USER ,
                columns,
                selectionuser,
                selectionArg,
                null,
                null,
                null);
        int cusrorcount = cursor.getCount();
        cursor.close();

        /*db.close();*/

        if (cusrorcount > 0 )
        {
            return true;

        }
        return false;

    }

    public boolean checkUser(String email , String password)
    {
        String[] columns  = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        String selectionUser = COLUMN_USER_EMAIL + " = ? " + " AND " +  COLUMN_USER_PASSWORD + "= ?";

        String[] selectionArg = {email , password};

        Cursor cursor = db.query(TABLE_USER ,
                columns,
                selectionUser ,
                selectionArg,
                null,
                null,
                null);

        int cursorCount = cursor.getCount();

        cursor.close();

        /*db.close();*/

        if (cursorCount > 0)
        {
            return true;
        }
        return false;
    }


}
