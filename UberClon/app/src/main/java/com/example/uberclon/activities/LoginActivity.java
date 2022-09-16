package com.example.uberclon.activities;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.uberclon.R;
import com.example.uberclon.includes.MyToolbar;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText mTextInputEmail;
    TextInputEditText mTextInputPassword;
    Button mButtonLogin;
    FirebaseAuth mAuth;
    DatabaseReference mDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mTextInputEmail=findViewById(R.id.txtInputEmail);
        mTextInputPassword=findViewById(R.id.txtInputPassword);
        mButtonLogin=findViewById(R.id.btnLogin);
        mAuth=FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference();
        //mostrar toolbar
        MyToolbar.show(this,"login",true);
        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });
    }

    private void Login(){
        String email=mTextInputEmail.getText().toString();
        String password=mTextInputPassword.getText().toString();
        if(!email.isEmpty() && !password.isEmpty()){
            if(password.length() >=6){
                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //si la tare fue exitoso osea que el login se realizo correctamente
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this,"El login se realizo correctamente",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(LoginActivity.this,"La contraseña o email son  incorrectos",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }else{
                Toast.makeText(LoginActivity.this,"La contraseña debe ser mayor a seis caracteres",Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(LoginActivity.this,"El email y password son obligatorios",Toast.LENGTH_SHORT).show();
        }
    }
}