package me.williamlin.mylayoutapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.ToggleButton;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScrollViewLayoutActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "extraMessage";

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
        DatePicker editDate = findViewById(R.id.datePicker);
        RatingBar ratingCS = findViewById(R.id.ratingCS);
        ToggleButton toggleBtn = findViewById(R.id.toggleBtn1);
        CheckBox checkBox = findViewById(R.id.checkBox1);

        Calendar date = Calendar.getInstance();
        date.set(editDate.getYear(), editDate.getMonth(), editDate.getDayOfMonth());
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, YYYY");
        String dateStr = dateFormat.format(date.getTime()).toString();


        String data = "";
        data += editName.getText().toString() + '\n';
        data += editEmail.getText().toString() + '\n';
        data += PhoneNumberUtils.formatNumber(editPhone.getText().toString(), "US") + '\n';
        data += choosenGender.getText().toString() + '\n';
        data += dateStr + '\n';
        data += "Rating: " + ratingCS.getRating() + " stars\n";
        data += "Cellphone: " + (toggleBtn.isChecked() ? "Yes" : "No") + '\n';
        data += "Wants an A: " + (checkBox.isChecked() ? "Yes" : "No") + '\n';

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(EXTRA_NAME, data);
        startActivity(intent);
    }

    public void onCancelClicked(View v) {
        super.onBackPressed();
    }
}
