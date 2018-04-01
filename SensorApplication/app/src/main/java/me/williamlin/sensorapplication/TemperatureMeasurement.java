package me.williamlin.sensorapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TemperatureMeasurement extends Activity implements SensorEventListener {

    static final String EXTRA_RESPONSE = "result";
    private SensorManager mSensorManager;
    private Sensor mTemp;
    String result="";
    int nr=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mTemp = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float temp_measurement = event.values[0];
        result += "\n" + temp_measurement;

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
        mSensorManager.registerListener(this, mTemp, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Be sure to unregister the sensor when the activity
        // pauses.super.onPause();
        mSensorManager.unregisterListener(this);
    }
}
