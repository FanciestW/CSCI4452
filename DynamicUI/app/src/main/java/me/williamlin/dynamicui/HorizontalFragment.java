package me.williamlin.dynamicui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by william on 3/4/18.
 */

public class HorizontalFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceStaned) {
        View view = inflater.inflate(R.layout.horizontal_fragment_layout, container, false);
        return view;
    }
}
