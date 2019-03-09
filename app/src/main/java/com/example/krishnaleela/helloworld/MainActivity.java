package com.example.krishnaleela.helloworld;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText etName,etPassword;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         etName=findViewById(R.id.editTextName);
         etPassword=findViewById(R.id.editTextPassword);
         sharedPreferences=getSharedPreferences("mypref", Context.MODE_PRIVATE);
         String userName=sharedPreferences.getString("username","");
        Toast.makeText(this,"Welcome:"+userName,Toast.LENGTH_SHORT).show();
    }
    public void btnCick(View view){

        Toast.makeText(this,"Welcome:"+etName.getText()+" succesfully logged in",Toast.LENGTH_SHORT).show();
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("username",etName.getText().toString());
        editor.putString("password",etPassword.getText().toString());
        editor.commit();
    }
}
