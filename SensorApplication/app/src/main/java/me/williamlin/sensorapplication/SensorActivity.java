package me.williamlin.sensorapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SensorActivity extends AppCompatActivity {

    static final int LIGHT_REQUEST = 1;
    static final int PRESSURE_REQUEST = 2;
    static final int TEMPERATURE_REQUEST = 3;
    Button btn1,btn2,btn3;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        textView=(TextView)findViewById(R.id.textview);
        btn1= (Button)findViewById(R.id.Light);
        btn2= (Button)findViewById(R.id.Pressure);
        btn1= (Button)findViewById(R.id.Temperature);
    }

    public void LightData(View view) {
        Intent lightIntent=new
                Intent(SensorActivity.this, LightMeasurement.class);
        startActivityForResult(lightIntent,LIGHT_REQUEST );
        startActivity(lightIntent);
    }

    public void PressureData(View view) {
        Intent pressureIntent=new
                Intent(SensorActivity.this, PressureMeasurement.class);
        startActivityForResult(pressureIntent,PRESSURE_REQUEST );
        startActivity(pressureIntent);
    }

    public void TemperatureData(View view) {
        Intent temperatureIntent=new
                Intent(SensorActivity.this, TemperatureMeasurement.class);
        startActivityForResult(temperatureIntent,TEMPERATURE_REQUEST );
        startActivity(temperatureIntent);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        // Check which request we're responding to
        if(requestCode == LIGHT_REQUEST) {
            // Make sure the request was successful
            if(resultCode == RESULT_OK) {
                textView.setText(data.getStringExtra(LightMeasurement.EXTRA_RESPONSE));
            }
        }
        else if(requestCode == PRESSURE_REQUEST) {
            if(resultCode == RESULT_OK) {
                textView.setText(data.getStringExtra(PressureMeasurement.EXTRA_RESPONSE));
            }
        }
        else if(requestCode == TEMPERATURE_REQUEST) {
            if(resultCode == RESULT_OK) {
                textView.setText(data.getStringExtra(TemperatureMeasurement.EXTRA_RESPONSE));
            }
        }
    }
}
