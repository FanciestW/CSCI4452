package me.williamlin.mylayoutapplication;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

public class CustomListViewLayoutActivity extends ListActivity {

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
            "Wisconsin", "Wyoming" };

    static final String[] POPULATION = new String[] { "4,874,747", "739,795",
            "7,016,270", "3,004,279", "39,536,653", "5,607,154", "3,588,184",
            "961,939", "20,984,400", "10,429,379", "1,427,538", "1,716,943", "12,802,023",
            "6,666,818", "3,145,711", "2,913,123", "4,454,189", "4,684,333", "1,335,907",
            "6,052,177", "6,859,819", "9,962,311", "5,576,606", "2,984,100",
            "6,113,532", "1,050,493", "1,920,076", "2,998,039", "1,342,795",
            "9,005,644", "2,088,070", "19,849,399", "10,273,419",
            "755,393", "11,658,609", "3,930,864", "4,142,776", "12,805,537",
            "1,059,639", "5,024,369", "869,666", "6,715,984", "28,304,596",
            "3,101,833", "623,657", "8,470,020", "7,405,743", "1,815,857",
            "5,795,483", "579,315" };

    static final String[] COUNTRY_SIZE = new String[] { "New Zealand", "Guyana",
            "Serbia", "Armenia", "Poland", "Singapore", "Moldova",
            "Djibouti", "Montenegro", "Niger", "Burundi", "Bahrain", "Kosovo", "South Sudan",
            "El Salvador", "Mongolia", "Lithuania", "Oman", "Estonia",
            "Lebanon", "Paraguay", "Sweden", "Finland", "Albania",
            "Lebanon", "Djibouti", "Latvia", "Armenia", "Estonia",
            "Honduras", "Slovenia", "Romania", "Portugal",
            "Guyana", "South Sudan", "Mauritania", "Oman", "South Sudan",
            "Djibouti", "Eritrea", "Cyprus", "El Salvador", "Ghana",
            "Mongolia", "Montenegro", "Switzerland", "Hong Kong", "Latvia",
            "Denmark", "Montenegro" };

    static final int[] HOUSE_REP_NUM = new int[] { 7, 1, 9, 4, 53, 7, 5, 1, 27, 14, 2, 2, 18, 9, 4,
            4, 6, 6, 2, 8, 9, 14, 8, 4, 8, 1, 3, 4, 2, 12, 3, 27, 13, 1, 16, 5, 5, 18, 2, 7, 1, 9,
            36, 4, 1, 11, 10, 3, 8, 1 };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ArrayList<State> states = new ArrayList<>();
        for(int i = 0; i < POPULATION.length; i++){
            states.add(new State(STATES[i], POPULATION[i], COUNTRY_SIZE[i], HOUSE_REP_NUM[i]));
        }

        CustomListArrayAdapter mAdapter = new CustomListArrayAdapter(this, states);

        ListView listView = getListView();
        listView.setAdapter(mAdapter);
    }
}
