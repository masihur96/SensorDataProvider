package com.example.sensorresultprovider;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Objects;


public class AcceleratorSensor extends Fragment implements SensorEventListener {

    TextView xValueTV,yValueTV,zValueTV;
    SensorManager sensorManager;
    Sensor sensor;

    public AcceleratorSensor() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_accelerator_sensor, container, false);

        xValueTV = view.findViewById(R.id.xValue);
        yValueTV = view.findViewById(R.id.yValue);
        zValueTV = view.findViewById(R.id.zValue);


        sensorManager = (SensorManager) Objects.requireNonNull(getActivity()).getSystemService(Context.SENSOR_SERVICE);
        final  Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);




        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);






    return view;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        xValueTV.setText("xValue: "+event.values[0]);
        yValueTV.setText("yValue: "+event.values[1]);
        zValueTV.setText("zValue: "+event.values[2]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}