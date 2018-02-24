package me.williamlin.fifthapplication;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by william on 2/23/18.
 */

public class SecondFragment extends Fragment {
    private TextView text;
    private Activity activity;

    public String[] DESC = {"Java Class", "Android Class", "C++ Class", "Python Class"};

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_fragment2,
                container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        text = (TextView) activity.findViewById(R.id.textView1);
    }

    public void change(int data) {
        Resources res = getResources();
        String[] desc = res.getStringArray(R.array.descriptions);
        text.setText(desc[data]);
    }
}
