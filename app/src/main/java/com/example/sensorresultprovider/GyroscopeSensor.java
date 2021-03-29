package com.example.sensorresultprovider;

import android.content.Context;
import android.graphics.Color;
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
import android.widget.Toast;

import java.util.Objects;

public class GyroscopeSensor extends Fragment implements SensorEventListener {

    TextView xValueTV,yValueTV,zValueTV;

    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener sensorEventListener;

    public GyroscopeSensor() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gyroscope_sensor, container, false);

        xValueTV = view.findViewById(R.id.xValue);
        yValueTV = view.findViewById(R.id.yValue);
        zValueTV = view.findViewById(R.id.zValue);


        sensorManager = (SensorManager) Objects.requireNonNull(getActivity()).getSystemService(Context.SENSOR_SERVICE);
        final  Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);



        if (sensor!=null){

            sensorManager.registerListener((SensorEventListener) this,sensor,SensorManager.SENSOR_DELAY_NORMAL);

        }
        else {
            xValueTV.setText("Gro  not supported");
            yValueTV.setText("Gro  not supported");
            yValueTV.setText("Gro not supported");
        }




        return view;

    }


    @Override
    public void onResume() {
        super.onResume();

        sensorManager.registerListener(sensorEventListener,sensor,SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    public void onPause() {
        super.onPause();
        sensorManager.unregisterListener(sensorEventListener);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        if (sensor.getType()==Sensor.TYPE_GYROSCOPE){
            xValueTV.setText("xValue: "+event.values[0]);
            yValueTV.setText("yValue: "+event.values[1]);
            zValueTV.setText("xValue: "+event.values[2]);
        }else {
            xValueTV.setText("Gro  not supported");
            yValueTV.setText("Gro  not supported");
            yValueTV.setText("Gro not supported");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
