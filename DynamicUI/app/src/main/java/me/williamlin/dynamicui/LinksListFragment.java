package me.williamlin.dynamicui;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by william on 3/1/18.
 */

public class LinksListFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment_layout, container, false);

        String[] links = getResources().getStringArray(R.array.description);
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, links);
        setListAdapter(mAdapter);
        return view;
    }

}