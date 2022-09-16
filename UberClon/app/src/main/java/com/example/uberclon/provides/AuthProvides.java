package com.example.uberclon.provides;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AuthProvides {
    FirebaseAuth mAuth;
    public AuthProvides(){
        //inicializamos para la base de datos
        mAuth= FirebaseAuth.getInstance();
    }

    public Task<AuthResult> register(String email , String password){
        return mAuth.createUserWithEmailAndPassword(email,password);
    }

    public Task<AuthResult> login(String email , String password){
        return mAuth.signInWithEmailAndPassword(email,password);
    }
}
