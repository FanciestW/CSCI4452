package me.williamlin.firstclassapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Toast;
import android.support.design.widget.Snackbar;

public class MainActivity extends AppCompatActivity {

    private int clickNum = 0;
    private int clickNum2 = 0;
    private Toast toast;
    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnClickMe_Clicked(View view) {
        if(toast != null) toast.cancel();
        clickNum++;
        String text = "You Clicked " + clickNum + " Times";
        toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
        toast.setText(text);
        toast.show();
    }

    public void btnNoClickMe_Clicked(View view) {
        if(snackbar != null) {
            if(snackbar.isShown()) snackbar.dismiss();
        }
        clickNum2++;
        String text = "You Clicked " + clickNum2 + " Times";
        snackbar = Snackbar.make(view, text, Snackbar.LENGTH_SHORT);
        snackbar.setAction(Html.fromHtml("<font color=\"#ffffff\">Dismiss</font>"), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
        snackbar.show();
    }
}
