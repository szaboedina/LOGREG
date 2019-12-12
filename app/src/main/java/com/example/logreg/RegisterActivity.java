package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private AdatbazisSegito adatbazisSegito;
    private EditText editTextEmail, editTextUserName, editTextPassword, editTextName;
    private Button buttonRegisztral, buttonVissza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        buttonVissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        buttonRegisztral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adatRogzites();

            }
        });
    }

    public void init() {
        adatbazisSegito=new AdatbazisSegito(this);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextUserName = findViewById(R.id.editTextUserName);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextName = findViewById(R.id.editTextName);
        buttonRegisztral = findViewById(R.id.buttonRegisztral);
        buttonVissza = findViewById(R.id.buttonVissza);
    }

    public void adatRogzites() {
        String email = editTextEmail.getText().toString();
        String felhnev = editTextUserName.getText().toString();
        String jelszo = editTextPassword.getText().toString();
        String teljesnev = editTextName.getText().toString();

        Boolean eredmeny = adatbazisSegito.adatRogzites(email, felhnev, jelszo, teljesnev);
        if (eredmeny)
            Toast.makeText(this, "Sikeres regisztráció!", Toast.LENGTH_SHORT).show();

        else
            Toast.makeText(this, "Sikertelen regisztráció!", Toast.LENGTH_SHORT).show();


    }

}
