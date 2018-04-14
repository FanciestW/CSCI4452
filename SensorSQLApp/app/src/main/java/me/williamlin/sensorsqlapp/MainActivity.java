package me.williamlin.sensorsqlapp;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView xvalueTxt;
    private TextView yvalueTxt;
    private TextView zvalueTxt;
    private TextView scrollText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xvalueTxt = findViewById(R.id.xValueText);
        yvalueTxt = findViewById(R.id.yValueText);
        zvalueTxt = findViewById(R.id.zValueText);
        scrollText = findViewById(R.id.scrollTextView);

        scrollText.setMovementMethod(new ScrollingMovementMethod());
    }

    public void getDataClick(View view) {
        Intent intent = new Intent(MainActivity.this, AccelerometerMeasurement.class);
        startActivityForResult(intent, 0);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 0) {
            if(resultCode == RESULT_OK) {
                float[] values = data.getFloatArrayExtra(AccelerometerMeasurement.EXTRA_RESPONSE);
                xvalueTxt.setText(Html.fromHtml(values[0] + "m/s<sup>2</sup>"));
                yvalueTxt.setText(Html.fromHtml(values[1] + "m/s<sup>2</sup>"));
                zvalueTxt.setText(Html.fromHtml(values[2] + "m/s<sup>2</sup>"));
            }
        }
    }
}
