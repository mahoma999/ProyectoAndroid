package com.example.uberclon.provides;

import com.example.uberclon.models.Client;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class ClientProvides {
    DatabaseReference mDatabase;

    public ClientProvides() {
        //hacemos referencia al nodo principal de la base de datos de firebase
        mDatabase=FirebaseDatabase.getInstance().getReference().child("User").child("Clients");
    }

    public Task<Void> create(Client client){
        //para que no apatesca el id
        Map<String,Object> map= new HashMap<>();
        map.put("name",client.getName());
        map.put("email",client.getEmail());
        return  mDatabase.child(client.getId()).setValue(map);
    }
}
