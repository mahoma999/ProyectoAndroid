package com.example.uberclon.activities.driver;


import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.uberclon.R;
import com.example.uberclon.includes.MyToolbar;

import com.example.uberclon.models.Driver;
import com.example.uberclon.provides.AuthProvides;
import com.example.uberclon.provides.ClientProvides;
import com.example.uberclon.provides.DriverProvides;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterDriverActivity extends AppCompatActivity {
    DriverProvides mDriverProvides;
    AuthProvides mAuthProvides;
    ClientProvides mClientProvides;

    //registrar a la vase de datos
    Button mButtonRegister;
    TextInputEditText mTextInputEmail;
    TextInputEditText mTextInputPassword;
    TextInputEditText mTextInputName;
    TextInputEditText mTextInputVehicleBrand;
    TextInputEditText mTextInputVehiclePlate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_driver);
        MyToolbar.show(this,"Registrar usuario",true);
        mAuthProvides=new AuthProvides();
        mClientProvides=new ClientProvides();
        //DEBE DE LLAMACER typeUser DEFINIDO EN EL MainActivity

        mButtonRegister=findViewById(R.id.btnRegister);
        mTextInputEmail=findViewById(R.id.textInputEmail);
        mTextInputPassword=findViewById(R.id.textInputPassword);
        mTextInputName=findViewById(R.id.textInputName);
        mTextInputVehicleBrand=findViewById(R.id.textInputVehicleBrand);
        mTextInputVehiclePlate=findViewById(R.id.textInputVehiclePlate);

        //Toast.makeText(this,"El ususario que seleccion :"+selectedUser,Toast.LENGTH_SHORT).show();
        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickRegister();
            }
        });

    }

    private void clickRegister() {
        String name =mTextInputName.getText().toString();
        String email=mTextInputEmail.getText().toString();
        String password=mTextInputPassword.getText().toString();
        final String vehicleBrand=mTextInputVehicleBrand.getText().toString();
        final String vehiclePlate=mTextInputVehiclePlate.getText().toString();

        if(!name.isEmpty() && !email.isEmpty() && !password.isEmpty() && !vehiclePlate.isEmpty() && !vehicleBrand.isEmpty()){
            if(password.length() >6){
                register(name,email,password,vehicleBrand,vehiclePlate);
            }else{
                Toast.makeText(this,"la contraseña debe tener al menos seis caracteres",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,"Ingrese todos los valores",Toast.LENGTH_SHORT).show();
        }
    }

    private void register(final String  name ,final String email,String password,String vehicleBrand,String vehiclePlate) {
        mAuthProvides.register(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //si la tare fue exitoso
                if(task.isSuccessful()){
                    //obtenemos el id del usuario de la base de datos
                    String id= FirebaseAuth.getInstance().getCurrentUser().getUid();
                    Driver driver=new Driver(id,name,email,password,vehicleBrand,vehiclePlate);

                    //guardar el ususario que registres en la base de datos real
                    create(driver);

                }else {
                    Toast.makeText(RegisterDriverActivity.this,"No se pudo registrar el ususario",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    void create(Driver driver){
        mDriverProvides.create(driver).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(RegisterDriverActivity.this,driver.getName()+" "+driver.getEmail(),Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(RegisterDriverActivity.this,"No se pudo registrar el ususario",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}