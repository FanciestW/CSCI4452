package me.williamlin.mylayoutapplication;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewLayoutActivity extends ListActivity {

    static final String[] STATES = new String[] { "Alabama", "Alaska",
            "Arizona","Arkansas", "California", "Colorado", "Connecticut",
            "Delaware", "Florida","Georgia", "Hawaii", "Idaho", "Illinois",
            "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine",
            "Maryland", "Massachusetts", "Michigan","Minnesota", "Mississippi",
            "Missouri", "Montana", "Nebraska", "Nevada","New Hampshire",
            "New Jersey", "New Mexico", "New York", "North Carolina",
            "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania",
            "Rhode Island","South Carolina", "South Dakota", "Tennessee", "Texas",
            "Utah", "Vermont", "Virginia", "Washington", "West Virginia",
            "Wisconsin", "Wyoming"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_list_view_layout);

        // Define new adapter
        ArrayAdapter<String> mAdpater = new ArrayAdapter<String>(this, R.layout.activity_list_view_layout, STATES);

        AdapterView.OnItemClickListener mListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), ((TextView) view).getText() + " is one of the North America States!", Toast.LENGTH_SHORT).show();
            }
        };

        ListView listView = getListView();
        listView.setAdapter(mAdpater);
        listView.setOnItemClickListener(mListener);
    }
}
