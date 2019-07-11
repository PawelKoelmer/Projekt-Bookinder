package com.example.pkoelme.bookinder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.pkoelme.bookinder.DB_Interfaces.UserI;



class DatabaseHelper extends SQLiteOpenHelper {
    private SQLiteDatabase SQLDb;

    DatabaseHelper(Context context){
        super(context, UserI.DB_NAME,null,UserI.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserI.USER_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("Drop table if exists " + UserI.DB_USER_TABLE);
        onCreate(db);
    }


}