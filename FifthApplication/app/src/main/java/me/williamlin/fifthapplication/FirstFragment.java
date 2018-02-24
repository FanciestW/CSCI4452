package me.williamlin.fifthapplication;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by william on 2/23/18.
 */

public class FirstFragment extends Fragment {

    private ListView list;
    private Communicator comm;
    public String[] myArray = {"Lecture1", "Lecture2", "Lecture3", "Lecture4"};

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        comm = (Communicator) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_fragment1, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        list = (ListView) getActivity().findViewById(R.id.frag1List);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getContext(), android.R.layout.simple_list_item_1, myArray );
        list.setAdapter(adapter);

        // list.setOnItemClickListener(this);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,View view,
                                    int position, long id) {
                listItemClicked(view,position);
            }
        });


    }

    void  listItemClicked(View v, int position){
        comm.respond(position);

    }

}
