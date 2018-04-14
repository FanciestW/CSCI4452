package me.williamlin.sensorapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SensorResultActivity extends AppCompatActivity {

    TextView value, unit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_result);

        value = findViewById(R.id.sensor_value);
        unit = findViewById(R.id.sensor_unit);

        int sensor = getIntent().getIntExtra("sensor", -1);
        switch(sensor) {

            case 0:
                startActivityForResult(new Intent(getApplicationContext(), LightMeasurement.class), sensor);
                unit.setText("Lux");
                break;

            case 1:
                startActivityForResult(new Intent(getApplicationContext(), TemperatureMeasurement.class), sensor);
                unit.setText((char) 0x00B0 + "C");
                break;

            case 2:
                startActivityForResult(new Intent(getApplicationContext(), PressureMeasurement.class), sensor);
                unit.setText("hPA");
                break;

            default:
                Log.d("Error", "Sensor Error");
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode) {
            case 0:
                if(resultCode == RESULT_OK) {
                    value.setText(data.getStringExtra(LightMeasurement.EXTRA_RESPONSE).trim());
                }
                break;

            case 1:
                if(resultCode == RESULT_OK) {
                    value.setText(data.getStringExtra(TemperatureMeasurement.EXTRA_RESPONSE).trim());
                }
                break;

            case 2:
                if(resultCode == RESULT_OK) {
                    value.setText(data.getStringExtra(PressureMeasurement.EXTRA_RESPONSE).trim());
                }
                break;

            default:
                Log.d("Error", "No Result");
                break;
        }
    }
}
