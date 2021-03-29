package com.example.sensorresultprovider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Service;
import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.security.Provider;

public class MainActivity extends AppCompatActivity {



    CardView lightCV,proximitCV,accleramiterCV,gyroscopeCV;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lightCV = findViewById(R.id.lightSensorCV);
        proximitCV = findViewById(R.id.proximitCV);
        accleramiterCV = findViewById(R.id.accleramiterCV);
        gyroscopeCV = findViewById(R.id.gyroscopeCV);

        frameLayout = findViewById(R.id.framLayout);

        lightCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lightCV.setVisibility(View.INVISIBLE);
                accleramiterCV.setVisibility(View.INVISIBLE);
                gyroscopeCV.setVisibility(View.INVISIBLE);
                proximitCV.setVisibility(View.INVISIBLE);
                frameLayout.setVisibility(View.VISIBLE);
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                fragmentTransaction1.replace(R.id.framLayout,new LightSensor());
                fragmentTransaction1.commit();
            }
        });

        proximitCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lightCV.setVisibility(View.INVISIBLE);
                accleramiterCV.setVisibility(View.INVISIBLE);
                gyroscopeCV.setVisibility(View.INVISIBLE);
                proximitCV.setVisibility(View.INVISIBLE);
                frameLayout.setVisibility(View.VISIBLE);
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                fragmentTransaction1.replace(R.id.framLayout,new ProximitSensor());
                fragmentTransaction1.commit();
            }
        });

        accleramiterCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lightCV.setVisibility(View.INVISIBLE);
                accleramiterCV.setVisibility(View.INVISIBLE);
                gyroscopeCV.setVisibility(View.INVISIBLE);
                proximitCV.setVisibility(View.INVISIBLE);
                frameLayout.setVisibility(View.VISIBLE);
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                fragmentTransaction1.replace(R.id.framLayout,new AcceleratorSensor());
                fragmentTransaction1.commit();
            }
        });

        gyroscopeCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lightCV.setVisibility(View.INVISIBLE);
                accleramiterCV.setVisibility(View.INVISIBLE);
                gyroscopeCV.setVisibility(View.INVISIBLE);
                proximitCV.setVisibility(View.INVISIBLE);
                frameLayout.setVisibility(View.VISIBLE);
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                fragmentTransaction1.replace(R.id.framLayout,new GyroscopeSensor());
                fragmentTransaction1.commit();
            }
        });


   }

}