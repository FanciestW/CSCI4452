package me.williamlin.dynamicui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Communicator {

    public String[] myArray = { "Lecture 1", "Lecture 2", "Lecture 3", "Lecture 4", "Lecture 5" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void respondList(int position) {

    }

    @Override
    public void respondLink(int poisiton) {

    }

}