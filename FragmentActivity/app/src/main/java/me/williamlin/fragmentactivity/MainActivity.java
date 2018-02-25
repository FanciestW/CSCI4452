package me.williamlin.fragmentactivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Comm {

    private int fontsize=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Nullable
    @Override
    public void onButtonClick(int size, String text) {
        TextFragment text_fragment = (TextFragment)getFragmentManager().findFragmentById(R.id.fragment2);
        text_fragment.changeTextProperties(fontsize, text);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuitem_font10:
                fontsize=10;
                Toast.makeText(this, "Font 10",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuitem_font50:
                fontsize=20;
                Toast.makeText(this, "Font 50",
                        Toast.LENGTH_SHORT).show();
                return true;

        }

        return false;
    }

}
