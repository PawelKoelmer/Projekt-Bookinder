package com.example.pkoelme.bookinder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.util.Log;

import com.example.pkoelme.bookinder.DB_Interfaces.UserI;
import com.example.pkoelme.bookinder.DB_OPERATIONS.User;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class BookinderDBAdapter {
    private DatabaseHelper dbHelper;
    private SQLiteDatabase SQLDb;
    private final Context ctx;

    public BookinderDBAdapter(Context ctx) {
        this.ctx = ctx;
    }


    public BookinderDBAdapter open() throws SQLException {
        dbHelper = new DatabaseHelper(ctx);
        SQLDb = dbHelper.getReadableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public Long insertUser(String login, String email, String password) {
        ContentValues newUser = new ContentValues();
        newUser.put(UserI.LOGIN_DESCRIPTION, login);
        newUser.put(UserI.EMAIL_DESCRIPTION, email);
        newUser.put(UserI.PASSWORD_DESCRIPTION, password);
        return SQLDb.insert(UserI.DB_USER_TABLE, null, newUser);
    }

    public Cursor showAllUsers() {
        return SQLDb.query(UserI.DB_USER_TABLE, new String[]{UserI.KEY_ID, UserI.LOGIN_DESCRIPTION, UserI.PASSWORD_DESCRIPTION, UserI.EMAIL_DESCRIPTION}, null, null, null, null, null);
    }

    public Cursor getLogin(String login){
        return SQLDb.query(UserI.DB_USER_TABLE,new String[]{UserI.LOGIN_DESCRIPTION},UserI.LOGIN_DESCRIPTION + "=?",new String[]{login},null,null,null);
    }
    public Cursor getEmail(String email){
        return SQLDb.query(UserI.DB_USER_TABLE,new String[]{UserI.EMAIL_DESCRIPTION},UserI.EMAIL_DESCRIPTION + "=?",new String[]{email},null,null,null);
    }

}


