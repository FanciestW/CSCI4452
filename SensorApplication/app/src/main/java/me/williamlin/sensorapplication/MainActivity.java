package me.williamlin.sensorapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SensorManager mgr;
    ListView listview;
    List<String> liststring ;
    List<Sensor> sensors;
    ArrayAdapter<String> adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mgr = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensors = mgr.getSensorList(Sensor.TYPE_ALL);
        displaySensorList();
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if(position == 3){
                    startActivity(new Intent(getApplicationContext(), ShakeActivity.class));
                } else if(position == 4){
                    startActivity(new Intent(getApplicationContext(), SensorActivity.class));
                } else {
                    Toast.makeText(MainActivity.this, liststring.get(position), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    void displaySensorList(){
        listview=(ListView) findViewById(R.id.listview1);

        liststring = new ArrayList<String>();

        //liststring Array is populated with sensor names as values
        for (Sensor sensor : sensors) {
            Log.d("Sensors", "" + sensor.getName());
            liststring.add(sensor.getName());

        }

        adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_2,
                android.R.id.text1, liststring
        );
        listview.setAdapter(adapter);
    }
}

