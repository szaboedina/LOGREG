package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoggedInActivity extends AppCompatActivity {
    private AdatbazisSegito adatbazisSegito;
    private Button buttonKij;
    private TextView textTeljesnev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
        init();
        buttonKij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoggedInActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void init(){
        buttonKij = findViewById(R.id.buttonKij);
        textTeljesnev=findViewById(R.id.textTeljesnev);
    }
}
