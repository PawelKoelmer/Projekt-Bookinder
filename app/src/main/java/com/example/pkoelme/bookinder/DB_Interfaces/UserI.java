package com.example.pkoelme.bookinder.DB_Interfaces;

public interface UserI {
     int DB_VERSION = 1;
    String DB_NAME ="BOOKINDE.db";
   String DEBUG_TAG = "SqLiteBookinderManager";
   String DB_USER_TABLE = "User";

   String KEY_ID = "_id" ;
   String ID_OPTIONS = "INTEGER PRIMARY KEY AUTOINCREMENT";
   int ID_COLUMN = 0;
   String LOGIN_DESCRIPTION = "Login";
   String LOGIN_OPTION = "TEXT NOT NULL";
   int LOGIN_COLUMN = 1;
   String PASSWORD_DESCRIPTION = "password";
   String PASSWORD_OPTION = "TEXT NOT NULL";
   int PASSWORD_COLUMN = 2;
   String EMAIL_DESCRIPTION = "Email";
   String EMAIL_OPTION = "TEXT NOT NULL";
   int EMAIL_COLUMN = 4;

   String USER_TABLE_CREATE =
            " CREATE TABLE "  + DB_USER_TABLE +
                    "(" + KEY_ID + " " + ID_OPTIONS + ", "
                    + LOGIN_DESCRIPTION + " " + LOGIN_OPTION + ", "
                    + PASSWORD_DESCRIPTION + " " + PASSWORD_OPTION + ", "
                    + EMAIL_DESCRIPTION + " " + EMAIL_OPTION
                    + ");";

   String SEARCH_LOGIN = "SELECT * FROM " + DB_USER_TABLE + " WHERE " + LOGIN_DESCRIPTION + " LIKE " ;
}
