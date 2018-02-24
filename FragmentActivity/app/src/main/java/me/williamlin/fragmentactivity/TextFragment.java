package me.williamlin.fragmentactivity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by william on 2/23/18.
 */

public class TextFragment extends Fragment {

    private static TextView textview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.text_fragment,
                container, false);
        textview=(TextView)view.findViewById(R.id.textView1);

        return view;
    }

    public void changeTextProperties(int fontsize, String text){
           //. . .
    }
}

