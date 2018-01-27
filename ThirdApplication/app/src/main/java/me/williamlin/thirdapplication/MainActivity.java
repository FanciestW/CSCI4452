package me.williamlin.thirdapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "SecondApplication";
    public final static String EXTRA_MESSAGE = "me.williamlin.secondapplication.MainActivity";
    static final int PICK_REQUEST = 1; // Request Code

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView  = findViewById(R.id.text);

        // Get Message from the intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(DisplayMessageActivity.EXTRA_MESSAGE);

        Log.d(TAG, "Got Intent");

        if(message!= null) textView.setText(message);

        Button requestBtn = findViewById(R.id.requestBtn);
        requestBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DisplayMessageActivity.class);
                startActivityForResult(intent, PICK_REQUEST);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart" +
            this.getLocalClassName().toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart " +
            this.getLocalClassName().toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume " +
            this.getLocalClassName().toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause " +
            getLocalClassName().toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop " +
            getLocalClassName().toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy" +
            getLocalClassName().toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            // Make sure the request was successful
            Log.d("Request Code Check", "Valid Request Code");
        }
        if (resultCode == RESULT_OK) {
            String result = data.getStringExtra("result");
            Toast.makeText(getApplicationContext(), "From Second Activity: " + result, Toast.LENGTH_LONG).show();
            textView.setText(result);
        } else if (resultCode == RESULT_CANCELED) {
            // No Results
        } else {
            // Anything else.
        }
    }

    public void sendMessage(View view) {
        Log.d(TAG, "Send Message");

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}