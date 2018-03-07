package me.williamlin.dynamicui;

import android.support.v4.app.FragmentManager;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements Communicator {

    public String[] myArray = { "Lecture 1", "Lecture 2", "Lecture 3", "Lecture 4", "Lecture 5" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration config = this.getResources().getConfiguration();
        if(config.orientation == Configuration.ORIENTATION_PORTRAIT) {
            portraitMode();
        } else if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            landscapeMode();
        }
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.d("Config Changed", "Orientation Landscape");
            landscapeMode();
        } else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.d("Config Changed", "Orientation Portrait");
            portraitMode();
        } else {
            Log.d("Config Change", "Else");
        }
    }

    @Override
    public void respondList(int position) {

    }

    @Override
    public void respondLink(int position) {
        WebFragment webFragment = new WebFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("url", position);
        webFragment.setArguments(bundle);
        // Continue
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container, webFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        ToggleButton btn = findViewById(R.id.button1);
        btn.setChecked(false);
    }

    void portraitMode() {
        VerticalFragment secondFragment = new VerticalFragment();
        Bundle args = new Bundle();
        secondFragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, secondFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
    }

    void landscapeMode() {
        HorizontalFragment firstFragment = new HorizontalFragment();
        Bundle args = new Bundle();
        firstFragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, firstFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
    }

    public void listToggle(View view) {
        ToggleButton button = (ToggleButton)findViewById(R.id.button1);
        LinksListFragment fragment = new LinksListFragment();

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (button.isChecked()){
            transaction.add(R.id.fragment_container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        } else {
            transaction.remove(fragment);
            transaction.commit();
            manager.popBackStack();
        }
    }

    void callFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}