package com.example.uberclon.provides;

import com.example.uberclon.models.Client;
import com.example.uberclon.models.Driver;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DriverProvides {
    DatabaseReference mDatabase;

    public DriverProvides() {
        //hacemos referencia al nodo principal de la base de datos de firebase
        mDatabase= FirebaseDatabase.getInstance().getReference().child("User").child("Drivers");
    }

    public Task<Void> create(Driver driver){
        return  mDatabase.child(driver.getId()).setValue(driver);
    }
}
