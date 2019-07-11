package com.example.pkoelme.bookinder;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.pkoelme.bookinder.DB_Interfaces.UserI;
import com.example.pkoelme.bookinder.DB_OPERATIONS.User;

import java.util.List;

public class Regiestration extends AppCompatActivity {

    private BookinderDBAdapter db;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiestration);

        db = new BookinderDBAdapter(this);
        db.open();

        final Context context = getApplicationContext();

        Button register = (Button) findViewById(R.id.register);
        final EditText log = (EditText) findViewById(R.id.login);
        final EditText pass = (EditText) findViewById(R.id.password);
        final EditText mail = (EditText) findViewById(R.id.email);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = log.getText().toString();
                String email = mail.getText().toString();
                String password = pass.getText().toString();
                Cursor cursor;
                String tmplogin="";
                String tmpEmail="";
                if (login.length() != 0 && email.length() != 0 && password.length() != 0) {

                    cursor = db.getEmail(email);
                    if(cursor.moveToFirst()){
                        tmpEmail = cursor.getString(cursor.getColumnIndex(UserI.EMAIL_DESCRIPTION));
                    }
                    if(!tmpEmail.equals(email)) {

                        cursor = db.getLogin(login);
                        if (cursor.moveToFirst()) {
                            tmplogin = cursor.getString(cursor.getColumnIndex(UserI.LOGIN_DESCRIPTION));
                        }

                        if (!tmplogin.equals(login)) {
                            db.insertUser(login, email, password);
                        } else Toast.makeText(context,"Istnieje użytkownik o podanym loginie",Toast.LENGTH_LONG).show();

                    }   else Toast.makeText(context,"Istnieje już użytkownik o podanym adresie E-Mail",Toast.LENGTH_LONG).show();



                } else
                    Toast.makeText(context, "Brak danych", Toast.LENGTH_LONG).show();
            }

        });
    }
}

