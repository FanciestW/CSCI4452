package me.williamlin.fourthapplication;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;

/**
 * Created by william on 2/16/18.
 */

public class FirstFragment extends ListFragment {

    public final String NAMES[] = {"William Lin", "Brad Pitt", "Chuck Norris", "Kanye West",
            "Bill Gates", "Elon Musk", "Tony Hseih", "Larry Page", "Sergey Brin",
            "Mark Zuckerberg", "Brian Chesky", "Jeff Bezos", "Gordan Moore",
            "Nikolai Tesla", "Thomas Edison", "Steve Jobs", "Steve Wozniak", "Charles Flint",
            "Thomas Watson", "Jack Ma"};

    public final String DESC[] = {"UNH Student", "Famous Actor", "Round House Kick", "Rapper",
            "Rich Guy", "Launched a Rocket", "Zappos CEO", "Founder of Google", "Went to Stanford",
            "Created Facebook", "Co-founded AirBnb", "Amazon Founder", "Intel Co-founder",
            "Famous Inventor", "Created the lightbulb", "Apple Co-founder", "Co-founded Apple", "Founder of IBM",
            "IBM Watson was named after Thomas Watson", "Founder of Alibaba" };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_fragment1, container, false);

        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, NAMES);

        setListAdapter(mAdapter);

        return rootView;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        SecondFragment fragment2 = (SecondFragment) getFragmentManager().findFragmentById(R.id.fragment2);

        fragment2.setText(NAMES[position], DESC[position]);
    }
}
