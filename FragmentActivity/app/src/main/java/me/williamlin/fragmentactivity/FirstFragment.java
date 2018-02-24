package me.williamlin.fragmentactivity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by william on 2/23/18.
 */

public class FirstFragment extends Fragment {

    private static EditText edittext;
    private int fontsize=10;
    Comm activityCallback;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            activityCallback = (Comm) activity;
        } catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + "must implement the listener");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment1, container, false);

        edittext = (EditText) view.findViewById(R.id.editText1);
        final Button button = (Button) view.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonClicked(v);

            }
        });

        return view;
    }

    void buttonClicked(View v){
        //. . .
    }
}

