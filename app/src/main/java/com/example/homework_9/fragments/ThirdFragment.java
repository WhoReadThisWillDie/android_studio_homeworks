package com.example.homework_9.fragments;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.homework_9.databinding.FragmentThirdBinding;

public class ThirdFragment extends Fragment implements SensorEventListener {

    FragmentThirdBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentThirdBinding.inflate(inflater, container, false);
        SensorManager sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_UI);
        return binding.getRoot();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        binding.text1.setText("X" + sensorEvent.values[0]);
        binding.text2.setText("Y" + sensorEvent.values[1]);
        binding.text3.setText("Z" + sensorEvent.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
