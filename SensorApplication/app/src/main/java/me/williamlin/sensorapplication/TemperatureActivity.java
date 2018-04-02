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

public class TemperatureActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager smg;
    private Sensor sensor;
    private float temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        smg = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = smg.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        smg.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        temp = event.values[0];
    }

    public void getTemp(View view) {
        TextView tempText = findViewById(R.id.textTempValue);
        tempText.setText(Float.toString(temp));
    }
}
