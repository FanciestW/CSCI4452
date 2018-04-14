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

public class PressureActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager smg;
    private Sensor sensor;
    private float pressure = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);

        smg = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = smg.getDefaultSensor(Sensor.TYPE_PRESSURE);
        smg.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        pressure = event.values[0];
    }

    public void getPressure(View view) {
        TextView textPressure = findViewById(R.id.textPressureValue);
        textPressure.setText(Float.toString(pressure));
    }
}
