package me.williamlin.fourthapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by william on 2/16/18.
 */

public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_fragment2, container, false);
    }

    public void setText(String name, String desc) {
        TextView textView1 = (TextView)getView().findViewById(R.id.textView1);
        TextView textView2 = (TextView)getView().findViewById(R.id.textView2);
        textView1.setText(name);
        textView2.setText(desc);
    }
}
