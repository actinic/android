package com.example.sushil.login;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText reg_fullname;
    EditText reg_email;
    EditText reg_password;
    Button btnRegister;
    MyDBHandler dbHandler;

    @Override
    public void onBackPressed()
    {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Register.this);
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
        setContentView(R.layout.activity_register);

        btnRegister = (Button)findViewById(R.id.btnRegister);
        reg_fullname = (EditText)findViewById(R.id.reg_fullname);
        reg_email = (EditText)findViewById(R.id.reg_email);
        reg_password = (EditText)findViewById(R.id.reg_password);

        dbHandler = new MyDBHandler(this, null, null, 1);

        TextView link_to_login=(TextView) findViewById(R.id.link_to_login);
        link_to_login.setPaintFlags(link_to_login.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        link_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String product1 = reg_fullname.getText().toString();
                String product2 = reg_email.getText().toString();
                String product3 = reg_password.getText().toString();
                Products p = new Products(product1,product2,product3);
                dbHandler.addProduct(p);
                Toast.makeText(getApplicationContext(), "Added successfully", Toast.LENGTH_SHORT).show();
                reg_fullname.setText("");
                reg_email.setText("");
                reg_password.setText("");
            }
        });
    }
}
