package me.williamlin.sensorsqlapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.InputType;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView xvalueTxt, yvalueTxt, zvalueTxt, scrollText;
    String x ,y ,z = "0";
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
        db.execSQL("CREATE TABLE IF NOT EXISTS data(x TEXT, y TEXT, z TEXT);");
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

                x = String.format ("%,.2f", values[0]);
                y = String.format ("%,.2f", values[1]);
                z = String.format ("%,.2f", values[2]);

                xvalueTxt.setText(Html.fromHtml(x + "m/s<sup>2</sup>"));
                yvalueTxt.setText(Html.fromHtml(y + "m/s<sup>2</sup>"));
                zvalueTxt.setText(Html.fromHtml(z + "m/s<sup>2</sup>"));
            }
        }
    }

    public void onInsertClick(View view) {
        getDataClick(getCurrentFocus());
        db.execSQL("INSERT INTO data VALUES ('" + x + "','" + y + "','" + z + "')");
    }

    public void onDeleteClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete Data by ID");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    String id = input.getText().toString();
                    db.execSQL("DELETE FROM data WHERE rowid = " + id + ";");
                } catch (Exception e) {
                    Log.d("Exception Caught", e.getMessage());
                }
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        builder.create().show();
    }

    public void onRetrieveAll(View view) {
        String query = "SELECT rowid, * FROM data LIMIT 1000";
        Cursor c = db.rawQuery(query, null);
        if(c.getCount() == 0) {
            scrollText.setText("No Records");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while(c.moveToNext()) {
            buffer.append(c.getString(0) + "\t\t");
            buffer.append("x: " + c.getString(1) + "\t\t");
            buffer.append("y: " + c.getString(2) + "\t\t");
            buffer.append("z: " + c.getString(3) + "\n");
        }
        scrollText.setText(buffer.toString());
    }

    public void onDeleteAll(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Everything will be gone!").setTitle("Delete All Data?");

        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                db.execSQL("DELETE FROM data");
                dialogInterface.dismiss();
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        builder.create().show();
    }
}
