package me.williamlin.mylayoutapplication;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class DateAndTimeActivity extends AppCompatActivity {

    private Calendar mDateAndTime = Calendar.getInstance();
    private TextView mDisplayDateTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_and_time);
        mDisplayDateTime = (TextView) findViewById(R.id.dateTextView);
        updateDateAndTimeDisplay();
    }

    public void onSetDateClicked(View v) {
        DatePickerDialog.OnDateSetListener mDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                mDateAndTime.set(Calendar.YEAR, year);
                mDateAndTime.set(Calendar.MONTH, month);
                mDateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateDateAndTimeDisplay();
            }
        };

        new DatePickerDialog(DateAndTimeActivity.this, mDateListener,
                mDateAndTime.get(Calendar.YEAR),
                mDateAndTime.get(Calendar.MONTH),
                mDateAndTime.get(Calendar.DAY_OF_MONTH)).show();
    }

    public void onSetTimeClicked(View v) {
        TimePickerDialog.OnTimeSetListener mTimeListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                mDateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
                mDateAndTime.set(Calendar.MINUTE, minute);
                updateDateAndTimeDisplay();
            }
        };

        new TimePickerDialog(DateAndTimeActivity.this, mTimeListener,
                mDateAndTime.get(Calendar.HOUR_OF_DAY),
                mDateAndTime.get(Calendar.MINUTE), true).show();
    }

    private void updateDateAndTimeDisplay() {
        mDisplayDateTime.setText(DateUtils.formatDateTime(this, mDateAndTime.getTimeInMillis(), DateUtils.FORMAT_SHOW_DATE
                        | DateUtils.FORMAT_SHOW_TIME));

    }
}
