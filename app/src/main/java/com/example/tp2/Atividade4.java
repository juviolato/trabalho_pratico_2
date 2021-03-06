package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Atividade4 extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor light;
    private Sensor temperature;
    private EditText luminosityInfo;
    private EditText latitudeInfo;
    private EditText longitudeInfo;
    private EditText temperatureInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        luminosityInfo = findViewById(R.id.luminosityInfoId);
        latitudeInfo = findViewById(R.id.latitudeInfoId);
        longitudeInfo = findViewById(R.id.longitudeInfoId);
        temperatureInfo = findViewById(R.id.temperatureInfoId);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if (light != null)
        {
            sensorManager.registerListener(Atividade4.this, light, SensorManager.SENSOR_DELAY_NORMAL);
        }

        temperature = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        if (temperature != null)
        {
            sensorManager.registerListener(Atividade4.this, temperature, SensorManager.SENSOR_DELAY_NORMAL);
        }

        final Button GPSButton = findViewById(R.id.updateGPSButtonId);
        ActivityCompat.requestPermissions(Atividade4.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 123);
        GPSButton.setOnClickListener(v -> {
            GPSTracker g = new GPSTracker(getApplicationContext());
            Location l = g.getLocation();
            if (l != null)
            {
                latitudeInfo.setText("LAT: " + Double.toString(l.getLatitude()));
                longitudeInfo.setText("LONG: " + Double.toString(l.getLongitude()));
            }
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
        if (sensor.getType() == Sensor.TYPE_LIGHT)
        {
            luminosityInfo.setText("Light: " + event.values[0]);
        }

        if (sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE)
        {
            temperatureInfo.setText("Temp.: " + event.values[0]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {

    }
}