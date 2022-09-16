package com.example.uberclon.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.uberclon.R;
import com.example.uberclon.activities.client.RegisterActivity;
import com.example.uberclon.activities.driver.RegisterDriverActivity;
import com.example.uberclon.includes.MyToolbar;

public class SelectOptionAuthActivity extends AppCompatActivity {
    SharedPreferences mPref;
    Button mButtonGoToLogin;
    Button mButtonGoToRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_option_auth);
        mPref=getApplicationContext().getSharedPreferences("typeUser",MODE_PRIVATE);
        MyToolbar.show(this,"Selecciona una opcion",true);
        mButtonGoToLogin=findViewById(R.id.btnGoToLogin);
        mButtonGoToRegister=findViewById(R.id.btnGoToRegister);
        mButtonGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLogin();
            }
        });

        mButtonGoToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRegister();
            }
        });
    }

    private void goToLogin() {
        Intent intent=new Intent(SelectOptionAuthActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    private void goToRegister() {
        String typeUser=mPref.getString("user","");
        if(typeUser.equals("client")){
        Intent intent=new Intent(SelectOptionAuthActivity.this, RegisterActivity.class);
        startActivity(intent);
        } else if (typeUser.equals("driver")) {
            Intent intent=new Intent(SelectOptionAuthActivity.this, RegisterDriverActivity.class);
            startActivity(intent);

        }
    }
}