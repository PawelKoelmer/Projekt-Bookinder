package com.example.pkoelme.bookinder;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.pkoelme.bookinder.DB_Interfaces.UserI;

public class Wyswietl extends ListActivity {

        private BookinderDBAdapter db;
        ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wyswietl);
        db = new BookinderDBAdapter(this);
        db.open();
        filldata();
   }

    private void filldata() {
        Cursor itemsCursor = db.showAllUsers();
        startManagingCursor(itemsCursor);
        String[] from = new String[] {UserI.LOGIN_DESCRIPTION,UserI.EMAIL_DESCRIPTION,UserI.PASSWORD_DESCRIPTION};
        int[] to = new int[]{R.id.loginDB,R.id.emailDB,R.id.passwordDB};
        SimpleCursorAdapter items = new SimpleCursorAdapter(this,R.layout.row, itemsCursor, from, to);
        setListAdapter(items);
    }
}
