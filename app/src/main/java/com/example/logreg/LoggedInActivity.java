package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class LoggedInActivity extends AppCompatActivity {
    private Button btnLogOut;
    private TextView txtNev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        init();

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent insert = new Intent(LoggedInActivity.this, MainActivity.class);
                startActivity(insert);
                finish();
            }
        });
    }

    private void init(){
        btnLogOut = findViewById(R.id.kijelentkezes);
        txtNev = findViewById(R.id.teljesnev);
    }
}