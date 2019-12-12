package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AdatbazisSegito adatbazisSegito;
    private EditText editTextFelh, editTextJelszo;
    private Button buttonBej,buttonReg;
   // private boolean nemtom=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonBej.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                bejelentkezes();

                    Intent intent = new Intent(MainActivity.this,LoggedInActivity.class);
                    startActivity(intent);
                    finish();

                }

        });
    }

    public void init(){
        adatbazisSegito= new AdatbazisSegito(this);
        editTextFelh = findViewById(R.id.editTextFelh);
        editTextJelszo = findViewById(R.id.editTextJelszo);
        buttonBej = findViewById(R.id.buttonBej);
        buttonReg=findViewById(R.id.buttonReg);
    }
    public void bejelentkezes(){
        Cursor eredmeny= adatbazisSegito.bejeletkezes();

        StringBuffer stringBuffer=new StringBuffer();
        if (eredmeny!= null&&eredmeny.getCount()>0){
            while (eredmeny.moveToNext()){
                stringBuffer.append("ID: "+eredmeny.getString(0)+"\n");
                stringBuffer.append("E-mail: "+eredmeny.getString(1)+"\n");
                stringBuffer.append("Felhasználónév: "+eredmeny.getString(2)+"\n");
                stringBuffer.append("Jelszó: "+eredmeny.getString(3)+"\n\n");
            }
            Toast.makeText(this,"Bejelentkezés sikeres!",Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "Rossz felhasználónéz vagy jelszó!", Toast.LENGTH_SHORT).show();
       // nemtom=false;

    }
}
