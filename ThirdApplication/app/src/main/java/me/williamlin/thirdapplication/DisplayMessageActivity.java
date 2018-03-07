package me.williamlin.thirdapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    private static final String TAG = "SecondApplication";
    public static final String EXTRA_MESSAGE = "me.williamlin.secondapplication.DisplayMessageActivity";

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        editText = findViewById(R.id.edit_message);

        Button sendBackBtn = findViewById(R.id.sendBackBtn);
        sendBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result", editText.getText().toString());
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });


        // Get Message from the intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        Log.d(TAG, "Got Intent");

        TextView textView = findViewById(R.id.text2);
        if(message!= null) textView.setText(message);
    }

    public void sendMessage(View view) {
        Log.d(TAG, "Send Message");

        Intent intent = new Intent(this, MainActivity.class);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}