package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private Button regisztralas, vissza;
    private EditText felhasznalonev, jelszo, email, teljesNev;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();

        regisztralas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (felhasznalonev.getText().equals("") || jelszo.getText().equals("") ||
                        email.getText().equals("") || teljesNev.getText().equals("")){
                    Toast.makeText(RegisterActivity.this, "Üresen hagyott mezők!!",
                            Toast.LENGTH_SHORT).show();
                }
                else{
                    String felhNev = felhasznalonev.getText().toString().trim();
                    String pass = jelszo.getText().toString().trim();
                    String mail = email.getText().toString().trim();
                    String nev = teljesNev.getText().toString().trim();


                    if (db.rogzites(mail, felhNev, pass, nev)){
                        Toast.makeText(getApplicationContext(), "Sikeres rögzítés",
                                Toast.LENGTH_SHORT).show();
                    } else{
                        Toast.makeText(getApplicationContext(), "Sikeretelen rögzítés",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        vissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent insert = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(insert);
                finish();
            }
        });

    }


    private void init(){
        regisztralas = findViewById(R.id.RegRegister);
        vissza = findViewById(R.id.regVisszaButton);
        felhasznalonev = findViewById(R.id.regFelh);
        jelszo = findViewById(R.id.regPass);
        email = findViewById(R.id.regEmail);
        teljesNev = findViewById(R.id.regTeljesNev);
    }
}