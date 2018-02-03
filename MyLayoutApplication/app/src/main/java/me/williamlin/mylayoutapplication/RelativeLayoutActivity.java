package me.williamlin.mylayoutapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class RelativeLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);
    }

    public void onClickConan(View v) {
        Toast.makeText(getApplicationContext(), R.string.ui_conans_message, Toast.LENGTH_LONG).show();
    }

    public void onGoBackClicked(View v) {
        super.onBackPressed();
    }
}
