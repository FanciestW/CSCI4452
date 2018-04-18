package me.williamlin.sensorsqlapp;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class AccelerometerMeasurement extends AppCompatActivity implements SensorEventListener {

    static final String EXTRA_RESPONSE = "result";
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float[] values = { event.values[0], event.values[1], event.values[2] };

        mSensorManager.unregisterListener(this);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_RESPONSE, values);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onResume() {
        // Register a listener for the sensor
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Be sure to unregister the sensor when the activity pauses
        mSensorManager.unregisterListener(this);
    }
}
