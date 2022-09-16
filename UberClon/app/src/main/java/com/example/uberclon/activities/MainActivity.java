package com.example.uberclon.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.uberclon.R;

public class MainActivity extends AppCompatActivity {
    Button mButtonIAmClient;
    Button mButtonIAmDriver;
    SharedPreferences mPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //para saber que tipos de ususarios
        mPref=getApplicationContext().getSharedPreferences("typeUser",MODE_PRIVATE);
        SharedPreferences.Editor editor=mPref.edit();

        mButtonIAmClient = findViewById(R.id.btnIAmClient);
        mButtonIAmDriver = findViewById(R.id.btnIAmDriver);

        mButtonIAmClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //seleccionamos el tipo de ususario cliente
                editor.putString("user","client");
                editor.apply();
                goToSelectAuth();
            }
        });

        mButtonIAmDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //seleccionamos el tipo de ususario driver
                editor.putString("user","driver");
                editor.apply();
                goToSelectAuth();
            }
        });
    }

    private void goToSelectAuth() {
        Intent intent=new Intent(MainActivity.this,SelectOptionAuthActivity.class);
        startActivity(intent);
    }
}