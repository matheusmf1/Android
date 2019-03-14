package com.example.snackbar;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//The SnackBar is a new Widget introduced as a replacement Toast
//A Toast message don’t have action button, but Snackbar may have action button optionally.

    public void clicaTela(View view) {

//        Toast.makeText(getApplicationContext(),
//                "Hello World", Toast.LENGTH_LONG).show();
        Snackbar meuSnack;
        meuSnack = (Snackbar) Snackbar.make(view,"Hello Snack Bar", Snackbar.LENGTH_LONG);
        meuSnack.show();

        meuSnack.setAction("Snack Action", new View.OnClickListener() {
            @Override
            public void onClick(View v){
            }
        });


    }
}