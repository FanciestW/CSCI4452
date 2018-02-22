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

import java.util.Arrays;

public class SimpleListViewActivity extends AppCompatActivity {

    private final String NAMES[] = {"William Lin", "Brad Pitt", "Chuck Norris", "Kanye West",
            "Bill Gates", "Elon Musk", "Tony Hseih", "Larry Page", "Sergey Brin",
            "Mark Zuckerberg", "Brian Chesky", "Jeff Bezos", "Gordan Moore",
            "Nikolai Tesla", "Thomas Edison", "Steve Jobs", "Steve Wozniak", "Charles Flint",
            "Thomas Watson", "Jack Ma"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_view);

        // Define new adapter
        Arrays.sort(NAMES);
        ArrayAdapter<String> mAdpater = new ArrayAdapter<String>(this, R.layout.simple_list_item, R.id.simple_list_textView, NAMES);

        AdapterView.OnItemClickListener mListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView nameTextView = (TextView)view.findViewById(R.id.simple_list_textView);
                String fullName = nameTextView.getText().toString();
                String firstName = fullName.split(" ")[0];
                String lastName = fullName.split(" ")[1];
                Toast.makeText(getApplicationContext(), "First Name: " + firstName + " Last Name: " + lastName, Toast.LENGTH_SHORT).show();
            }
        };

        ListView listView = (ListView)findViewById(R.id.simpleListView);
        listView.setAdapter(mAdpater);
        listView.setOnItemClickListener(mListener);
    }
}
