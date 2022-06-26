package com.zybooks.healthyapp2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//import com.zybooks.healthyapp2.LoginDB;

public class LoginScreen extends AppCompatActivity {
    EditText username, password;
    Button submit;
    Button newUser;
    LoginDB DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username1);
        password = findViewById(R.id.password1);
        submit = findViewById(R.id.submit);
        newUser = findViewById(R.id.newUser);
        DB = new LoginDB(this);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals(""))
                    Toast.makeText(LoginScreen.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if (checkuserpass) {
                        Toast.makeText(LoginScreen.this, "Sign in successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), homeScreen.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginScreen.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_main2();
            }
        });
    }
        public void openActivity_main2() {
            Intent intent = new Intent(this, CreateAccount.class);
            startActivity(intent);
        }
    }