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

import static android.app.Activity.RESULT_OK;

public class LightMeasurement extends Activity implements SensorEventListener {
    static final String EXTRA_RESPONSE ="result";
    private SensorManager mSensorManager;
    private Sensor mLight;
    String result="";
    int nr=0;

    @Override
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get an instance of the sensor service,
        // and use that to get an instance of a particular sensor.
        mSensorManager = (SensorManager)
                getSystemService(Context.SENSOR_SERVICE);
        mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
    }

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
    }
    @Override
    public final void onSensorChanged(SensorEvent event) {
        float light_intensity = event.values[0];
        result += "\n" + light_intensity;

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
        mSensorManager.registerListener(
                this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Be sure to unregister the sensor when the activity
        // pauses.super.onPause();
        mSensorManager.unregisterListener(this);
    }
}
