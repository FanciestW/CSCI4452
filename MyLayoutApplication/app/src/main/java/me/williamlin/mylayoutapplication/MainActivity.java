package me.williamlin.mylayoutapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLinearLayoutClicked(View v) {
        Intent intent = new Intent(this, LinearLayoutActivity.class);
        startActivity(intent);
    }

    public void onRelativeLayoutClicked(View v) {
        Intent intent = new Intent(this, RelativeLayoutActivity.class);
        startActivity(intent);
    }

    public void onScrollLayoutClicked(View v) {
        Intent intent = new Intent(this, ScrollViewLayoutActivity.class);
        startActivity(intent);
    }

}
