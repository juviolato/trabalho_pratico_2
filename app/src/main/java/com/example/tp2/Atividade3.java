package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Atividade3 extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer;
    private EditText XAxis, YAxis, ZAxis;
    private Float [] gravity = new Float[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        XAxis = findViewById(R.id.xInputId);
        YAxis = findViewById(R.id.yInputId);
        ZAxis = findViewById(R.id.zInputId);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if(accelerometer != null)
        {
            sensorManager.registerListener(Atividade3.this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }

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

    @Override
    public void onSensorChanged(SensorEvent event)
    {
        Sensor sensor = event.sensor;
        if (sensor.getType() == Sensor.TYPE_GRAVITY)
        {
            gravity[0] = event.values[0];
            gravity[1] = event.values[1];
            gravity[2] = event.values[2];
        }

        if (sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            final Float alpha = Float.parseFloat("0.8");

            // Isolate the force of gravity with the low-pass filter.
            gravity[0] = alpha * gravity[0] + (1 - alpha) * event.values[0];
            gravity[1] = alpha * gravity[1] + (1 - alpha) * event.values[1];
            gravity[2] = alpha * gravity[2] + (1 - alpha) * event.values[2];

            Float newX = event.values[0] - gravity[0];
            Float newY = event.values[1] - gravity[1];
            Float newZ = event.values[2] - gravity[2];

            XAxis.setText(Float.toString(newX));
            YAxis.setText(Float.toString(newY));
            ZAxis.setText(Float.toString(newZ));

            if (newX >= 10 && newX <= 20)
            {
                Intent i = new Intent(this, Atividade3_3.class);
                startActivity(i);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {

    }
}