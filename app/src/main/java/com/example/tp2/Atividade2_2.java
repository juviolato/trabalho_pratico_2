package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Atividade2_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String textToShow;
        if (savedInstanceState == null)
        {
            Bundle extras = getIntent().getExtras();
            if (extras == null)
            {
                textToShow = null;
            }
            else
            {
                textToShow = extras.getString("STRING_TO_SHOW");
            }
        }
        else
        {
            textToShow = (String) savedInstanceState.getSerializable("STRING_TO_SHOW");
        }
        ((TextView) findViewById(R.id.textViewId)).setText(textToShow);

        final Button returnButton = findViewById(R.id.returnButtonId);
        returnButton.setOnClickListener(v -> {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        });
    }
}