package com.example.pkoelme.bookinder.DB_Interfaces;

public interface BookI {

    int DB_VERSION = 1;
    String DB_NAME = "Bookinder.db";
    String DEBUG_TAG = "SqLiteBookinderManager";
    String TABLE_NAME = "book";

    String KEY_ID = "_id";
    String ID_OPTION = "INTEGER PRIMARY KEY AUTOINCREMENT";

    String BOOK_NAME ="book_name";
    String BOOK_OPTION = "TEXT NOT NULL";

    String CONNECTED_USER_ID = "User_ID";
    String CONNECTED_USER_ID_OPTION = "INTEGER";

    String BOOK_AUTHOR = "Autor";
    String BOOK_AUTOR_OPTION = "TEXT NOT NULL";

    String BOOK_DESCRIPTION = "Opis";
    String BOOK_DESCRIPTION_OPTION = "TEXT NOT NULL";

    String BOOK_SCORE = "Ocena";
    String BOOK_SCORE_OPTION = "FLOAT";

    String BOOK_IMAGE = "Zdjecie";
    String BOOK_IMAGE_OPTION = "TEXT NOT NULL";
}
