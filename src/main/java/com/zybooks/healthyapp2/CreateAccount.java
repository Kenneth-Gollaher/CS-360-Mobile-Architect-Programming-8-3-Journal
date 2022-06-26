package com.zybooks.healthyapp2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//import com.zybooks.healthyapp2.LoginDB;

public class CreateAccount extends AppCompatActivity {
    Button saveProfile;
    EditText username, password;
    LoginDB DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        DB = new LoginDB(this);
        // get Instance
        saveProfile = findViewById(R.id.saveProfile);
        saveProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openActivity_main5();
                String user = username.getText().toString();
                String pass = password.getText().toString();

                Boolean checkuser = DB.checkusername(user);
                if(!checkuser){
                    Boolean insert = DB.insertData(user, pass);
                    if(insert){
                        Toast.makeText(CreateAccount.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),LoginScreen.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(CreateAccount.this, "Registration failed", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(CreateAccount.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void openActivity_main5() {
        Intent intent = new Intent(this, homeScreen.class);
        startActivity(intent);
    }
}