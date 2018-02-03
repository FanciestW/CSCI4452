package me.williamlin.mylayoutapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.ToggleButton;

public class ScrollViewLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view_layout);
    }

    public void onSaveClicked(View v) {
        EditText editName = findViewById(R.id.editName);
        EditText editEmail = findViewById(R.id.editEmail);
        EditText editPhone = findViewById(R.id.editPhone);
        RadioGroup radioGender = findViewById(R.id.radioGender);
        RadioButton choosenGender = findViewById(radioGender.getCheckedRadioButtonId());
        EditText editDate = findViewById(R.id.editDate);
        RatingBar ratingCS = findViewById(R.id.ratingCS);
        ToggleButton toggleBtn = findViewById(R.id.toggleBtn1);
        CheckBox checkBox = findViewById(R.id.checkBox1);



        String data = "";
        data += editName.getText().toString() + '\n';
        data += editEmail.getText().toString() + '\n';
        data += editPhone.getText().toString() + '\n';
        data += choosenGender.getText().toString() + '\n';
        data += editDate.getText().toString() + '\n';
        data += "Rating: " + ratingCS.getRating() + '\n';
        data += "Cellphone: " + (toggleBtn.isChecked() ? "Yes" : "No") + '\n';
        data += "Want an A? " + (checkBox.isChecked() ? "Yes" : "No") + '\n';

        Log.d("Msg", data);
    }

    public void onCancelClicked(View v) {
        super.onBackPressed();
    }
}
