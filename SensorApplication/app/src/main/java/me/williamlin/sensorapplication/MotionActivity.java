package me.williamlin.sensorapplication;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MotionActivity extends AppCompatActivity implements SensorEventListener {

    private TextView x, y, z;

    private SensorManager smg;
    private Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion);

        x = findViewById(R.id.xvalue);
        y = findViewById(R.id.yvalue);
        z = findViewById(R.id.zvalue);

        smg = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = smg.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        smg.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        x.setText(Float.toString(event.values[0]));
        y.setText(Float.toString(event.values[1]));
        z.setText(Float.toString(event.values[2]));
    }
}
