package me.williamlin.secondapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    private static final String TAG = "SecondApplication";
    public static final String EXTRA_MESSAGE = "me.williamlin.secondapplication.DisplayMessageActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get Message from the intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        Log.d(TAG, "Got Intent");

        TextView textView = (TextView)findViewById(R.id.text2);
        if(message!= null) textView.setText(message);
    }

    public void sendMessage(View view) {
        Log.d(TAG, "Send Message");

        Intent intent = new Intent(this, MainActivity.class);
        EditText editText = (EditText)findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}