package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button1 = findViewById(R.id.atv1ButtonId);
        button1.setOnClickListener(v -> {
            Intent i = new Intent(this, Atividade1.class);
            startActivity(i);
        });

        final Button button2 = findViewById(R.id.atv2ButtonId);
        button2.setOnClickListener(v -> {
            Intent i = new Intent(this, Atividade2.class);
            startActivity(i);
        });

        final Button button3 = findViewById(R.id.atv3ButtonId);
        button3.setOnClickListener(v -> {
            Intent i = new Intent(this, Atividade3.class);
            startActivity(i);
        });

        final Button button4 = findViewById(R.id.atvpt2ButtonId);
        button4.setOnClickListener(v -> {
            Intent i = new Intent(this, Atividade4.class);
            startActivity(i);
        });
    }
}