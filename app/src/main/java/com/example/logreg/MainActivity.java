package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnReg, btnLog;
    private EditText editFelh, editPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent insert = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(insert);
                finish();
            }
        });

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editFelh.getText().equals("admin") && editPass.getText().equals("asdf")){
                    Intent insert = new Intent(MainActivity.this, LoggedInActivity.class);
                    startActivity(insert);
                    finish();
                }
                else if (editFelh.getText().equals("") && editPass.getText().equals("")){
                    Toast.makeText(MainActivity.this, "Üresen hagyott mezők!!",
                            Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Hibás adatok!",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }




    private void init(){
        btnReg = findViewById(R.id.regisztracio);
        btnLog = findViewById(R.id.bejelentkezes);
        editFelh = findViewById(R.id.felhasznalo);
        editPass = findViewById(R.id.jelszo);
    }
}