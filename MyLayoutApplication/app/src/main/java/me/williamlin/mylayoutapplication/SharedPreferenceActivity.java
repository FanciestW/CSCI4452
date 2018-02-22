package me.williamlin.mylayoutapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SharedPreferenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);

        loadUserData();
    }

    public void onSaveClicked(View v) {
        saveUserData();
    }

    public void onCancelClicked(View v) {
        Toast.makeText(getApplicationContext(),
                getString(R.string.cancel_message), Toast.LENGTH_SHORT).show();

        startActivity(new Intent(this, MainActivity.class));
    }

    private void saveUserData() {
        Log.d("DEBUG", "saveUserData()");

        // Getting the shared preferences editor

        String mKey = getString(R.string.preference_name);
        SharedPreferences mPrefs = getSharedPreferences(mKey, MODE_PRIVATE);

        SharedPreferences.Editor mEditor = mPrefs.edit();
        mEditor.clear();

        // Save email information

        mKey = getString(R.string.preference_key_profile_email);
        String mValue = (String) ((EditText) findViewById(R.id.editEmail))
                .getText().toString();
        mEditor.putString(mKey, mValue);

        // Read which index the radio is checked.

        // edit this out and use as a debug example
        // interesting bug because you try and write an int to a string

        mKey = getString(R.string.preference_key_profile_gender);

        RadioGroup mRadioGroup = (RadioGroup) findViewById(R.id.radioGender);
        int mIntValue = mRadioGroup.indexOfChild(findViewById(mRadioGroup
                .getCheckedRadioButtonId()));
        mEditor.putInt(mKey, mIntValue);

        // Commit all the changes into the shared preference
        mEditor.commit();

        Toast.makeText(getApplicationContext(), "saved name: " + mValue,
                Toast.LENGTH_SHORT).show();

    }

    private void loadUserData() {
        Log.d("DEBUG", "loadUserData()");

        String mKey = getString(R.string.preference_name);
        SharedPreferences mPrefs = getSharedPreferences(mKey, MODE_PRIVATE);

        // Load the user email

        mKey = getString(R.string.preference_key_profile_email);
        String mValue = mPrefs.getString(mKey, " ");
        ((EditText) findViewById(R.id.editEmail)).setText(mValue);

        mKey = getString(R.string.preference_key_profile_gender);

        int mIntValue = mPrefs.getInt(mKey, -1);
        // In case there isn't one saved before:
        if (mIntValue >= 0) {
            // Find the radio button that should be checked.
            RadioButton radioBtn = (RadioButton) ((RadioGroup)
                    findViewById(R.id.radioGender))
                    .getChildAt(mIntValue);
            // Check the button.
            radioBtn.setChecked(true);
            Toast.makeText(getApplicationContext(),
                    "number of the radioButton is : " + mIntValue,
                    Toast.LENGTH_SHORT).show();
        }

    }
}
