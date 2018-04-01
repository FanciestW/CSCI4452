package me.williamlin.sensorapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

public class PressureMeasurement extends Activity implements SensorEventListener{

    static final String EXTRA_RESPONSE ="result";
    private SensorManager mSensorManager;
    private Sensor mPressure;
    String result="";
    int nr=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mPressure = mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
    }

    @Override
    public void onAccuracyChanged(Sensor sen, int i) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float millibars_of_pressure = event.values[0];
        result += "\n" + millibars_of_pressure;

        mSensorManager.unregisterListener(this);
        Intent intent = new Intent(this, SensorActivity.class);
        intent.putExtra(EXTRA_RESPONSE, result);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onResume() {
        // Register a listener for the sensor.
        super.onResume();
        mSensorManager.registerListener(this, mPressure, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Be sure to unregister the sensor when the activity
        // pauses.super.onPause();
        mSensorManager.unregisterListener(this);
    }
}
