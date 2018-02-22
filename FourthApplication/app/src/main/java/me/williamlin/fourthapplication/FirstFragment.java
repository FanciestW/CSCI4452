package me.williamlin.fourthapplication;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
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

public class FirstFragment extends Fragment {

    ListView.OnItemClickListener mItemClickListener;

    public final String NAMES[] = {"William Lin", "Brad Pitt", "Chuck Norris", "Kanye West",
            "Bill Gates", "Elon Musk", "Tony Hseih", "Larry Page", "Sergey Brin",
            "Mark Zuckerberg", "Brian Chesky", "Jeff Bezos", "Gordan Moore",
            "Nikolai Tesla", "Thomas Edison", "Steve Jobs", "Steve Wozniak", "Charles Flint",
            "Thomas Watson", "Jack Ma"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Arrays.sort(NAMES);
        View rootView = inflater.inflate(R.layout.activity_fragment1, container, false);

        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, NAMES);
        ListView myListView = rootView.findViewById(R.id.listViewNames);

        myListView.setOnItemClickListener(new ListView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id){

            }
        });
        myListView.setAdapter(mAdapter);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {

        }
    }
}
