package me.williamlin.dynamicui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by william on 3/4/18.
 */

public class VerticalFragment extends Fragment {

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vertical_fragment_layout, container, false);
        return view;
    }
}
