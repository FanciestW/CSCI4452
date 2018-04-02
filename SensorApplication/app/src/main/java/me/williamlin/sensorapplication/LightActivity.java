package me.williamlin.sensorapplication;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LightActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager smg;
    private Sensor mSensor;
    private float light = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);

        smg = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = smg.getDefaultSensor(Sensor.TYPE_LIGHT);
        smg.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        light = event.values[0];
    }

    public void getLight(View view) {
        TextView tempText = findViewById(R.id.textLightValue);
        tempText.setText(Float.toString(light));
    }
}
