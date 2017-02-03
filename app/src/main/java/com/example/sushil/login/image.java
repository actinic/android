package com.example.sushil.login;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class image extends AppCompatActivity {

    @Override
    public void onBackPressed()
    {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(image.this);
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
        setContentView(R.layout.activity_image3);
        //makes <- arrow on action bar make clickable
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setHomeButtonEnabled(true);



        //display image in app name
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo1);

        Intent intent = getIntent();
        String easyPuzzle1 = intent.getExtras().getString("easy");

        String cont="welcome "+easyPuzzle1+" !!!";
        TextView textView4=(TextView)findViewById(R.id.textView4);
        textView4.setText(cont);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.contacts:
                Toast.makeText(getApplicationContext(),"contacts selected",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.service_Tasks:
                Toast.makeText(getApplicationContext(), "service_Tasks selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.setting:
                Toast.makeText(getApplicationContext(), "setting selected", Toast.LENGTH_SHORT).show();
                return true;
            case android.R.id.home:
                Toast.makeText(getApplicationContext(), "home selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
