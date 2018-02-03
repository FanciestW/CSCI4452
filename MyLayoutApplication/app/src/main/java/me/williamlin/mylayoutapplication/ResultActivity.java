package me.williamlin.mylayoutapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String message = getIntent().getStringExtra(ScrollViewLayoutActivity.EXTRA_NAME);
        TextView view = new TextView(getApplicationContext());
        view.setText(message);
        view.setTextSize(24);
        view.setPadding(10, 10, 10, 10);
        this.setContentView(view);
    }
}
