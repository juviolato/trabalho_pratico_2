package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Atividade1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.sumButtonId);
        button.setOnClickListener(v -> {
            EditText A = findViewById(R.id.inputAId);
            EditText B = findViewById(R.id.inputBId);
            TextView C = findViewById(R.id.textViewId);

            int i = Integer.parseInt(A.getText().toString());
            int j = Integer.parseInt(B.getText().toString());

            C.setText(Integer.toString(i + j));
        });

        final Button returnButton = findViewById(R.id.returnButtonId);
        returnButton.setOnClickListener(v -> {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        });
    }
}