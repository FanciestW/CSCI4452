package me.williamlin.mylayoutapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * Created by william on 2/9/18.
 */

public class CustomListArrayAdapter extends ArrayAdapter<State> {

    public CustomListArrayAdapter(Context context, ArrayList<State> states) {
        super(context, 0, states);
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        // Get the data item for this position
        final State state = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_item_layout, parent, false);
        }
        // Lookup view for data population
        TextView stateName = (TextView) convertView.findViewById(R.id.stateNameText);
        TextView statePopulation = (TextView) convertView.findViewById(R.id.statePopulationText);

        // Populate the data into the template view using the data object
        stateName.setText(state.name);
        statePopulation.setText("Population: " + state.population);

        // Add on "Fun Fact" button click listener
        Button btnFunFact = (Button) convertView.findViewById(R.id.btnFunFact);
        btnFunFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fact = state.name + " is about the size of the country of " + state.country_sized;
                final Snackbar mySnackbar = Snackbar.make(parent, fact, Snackbar.LENGTH_LONG);
                mySnackbar.setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mySnackbar.dismiss();
                    }
                });
                mySnackbar.show();
            }
        });

        // Add click area listener
        LinearLayout clickArea = (LinearLayout) convertView.findViewById(R.id.clickArea);
        clickArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stateName = state.name;
                int rep_size = state.rep_size;
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext(), android.R.style.Theme_DeviceDefault_Dialog_Alert);
                builder.setTitle(stateName + " Fact")
                        .setMessage(stateName + " has " + rep_size + " House " + (rep_size == 1 ? "Representative" : "Representatives"))
                        .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });

        // Return the completed view to render on screen
        return convertView;
    }
}
