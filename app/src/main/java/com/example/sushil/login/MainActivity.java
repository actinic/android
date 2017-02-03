package com.example.sushil.login;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MyDBHandler dbHandler;
    public static String namee,passs;
    private Cursor c;
    String dbpass;
    public int time=3;

    @Override
    public void onBackPressed()
    {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Confirm cancel...");
        alertDialog.setMessage("Are you sure you want cancel?");
        alertDialog.setIcon(R.drawable.logo1);
        alertDialog.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        alertDialog.setNegativeButton("NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        alertDialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //dbHandler = new MyDBHandler(this, null, null, 1);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo1);

        TextView number = (TextView) findViewById(R.id.no);
        String timee = String.valueOf(time);
        number.setText(timee);

        Button clo = (Button) findViewById(R.id.button2);
        clo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time--;
                String timee = String.valueOf(time);
                TextView number = (TextView) findViewById(R.id.no);
                number.setText(timee);

                EditText name = (EditText) findViewById(R.id.editText);
                EditText pass = (EditText) findViewById(R.id.editText2);

                namee = name.getText().toString();
                passs = pass.getText().toString();
                //dbname = "s";
                dbpass = "s";
                    //String dbString  = dbHandler.databaseToString(namee);
                    //dbpass=dbString;
                    //if ((passs.equals(dbpass)) && (namee.equals(dbname))) {
                    if (passs.equals(dbpass)) {
                        Intent in = new Intent(MainActivity.this, Splash.class);
                        in.putExtra("epuzzle", namee);
                        startActivity(in);
                        finish();
                    } else if (time <= 0) {
                        Toast.makeText(getApplicationContext(), "login UNsuccessful", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Username or Password Miss-match", Toast.LENGTH_SHORT).show();
                    }

            }
        });

        Button button22 = (Button) findViewById(R.id.button2);
        button22.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Confirm cancel...");
                alertDialog.setMessage("Are you sure you want cancel?");
                alertDialog.setIcon(R.drawable.logo1);
                alertDialog.setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                alertDialog.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                alertDialog.show();
            }
        });


        //for register
        TextView register= (TextView) findViewById(R.id.register);
        register.setPaintFlags(register.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Register.class);
                startActivity(intent);
                finish();
            }
        });

    }

}
