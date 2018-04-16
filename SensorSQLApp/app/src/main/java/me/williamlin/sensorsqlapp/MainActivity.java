package me.williamlin.sensorsqlapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

    TextView xvalueTxt, yvalueTxt, zvalueTxt, scrollText;
    float x ,y ,z = 0;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xvalueTxt = findViewById(R.id.xValueText);
        yvalueTxt = findViewById(R.id.yValueText);
        zvalueTxt = findViewById(R.id.zValueText);
        scrollText = findViewById(R.id.scrollTextView);

        scrollText.setMovementMethod(new ScrollingMovementMethod());

        db = openOrCreateDatabase("SensorDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS data(x REAL, y REAL, z REAL);");
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

                x = values[0];
                y = values[1];
                z = values[2];
            }
        }
    }

    public void onInsertClick(View view) {
        db.execSQL("INSERT INTO data VALUES ('" + x + "," + y + "," + z + ")");
    }

    public void onDeleteClick(View view) {

    }

    public void onRetrieveAll(View view) {
        String query = "SELECT * FROM data LIMIT 1000";
        Cursor c = db.rawQuery(query, null);
        if(c.getCount() == 0) {
            scrollText.setText("No Records");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while(c.moveToNext()) {
            buffer.append("x: " + c.getString(0) + "\n");
            buffer.append("y: " + c.getString(1) + "\n");
            buffer.append("z: " + c.getString(2) + "\n");
        }
        scrollText.setText(buffer.toString());
    }
}
