package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Atividade2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.sendButtonId);
        button.setOnClickListener(v-> {
            Intent i = new Intent(this, Atividade2_2.class);
            String text = ((EditText) findViewById(R.id.inputId)).getText().toString();
            i.putExtra("STRING_TO_SHOW", text);
            startActivity(i);
        });

        final Button returnButton = findViewById(R.id.returnButtonId);
        returnButton.setOnClickListener(v -> {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        });
    }
}