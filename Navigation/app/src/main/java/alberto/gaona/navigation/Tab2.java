package alberto.gaona.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Tab2 extends Fragment implements AdapterView.OnItemClickListener{

    private static final String ARG_SECTION_NUMBER = "section_number";

    public static Tab2 newInstance(int sectionNumber){
        Tab2 fragment = new Tab2();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2,container,false);

        String[] myArray = {"A.M","Being There", "Summerteeth", "Yankee Hotel Foxtrot",
            "A Ghost Is Born", "Kicking Television: Live in Chicago", "Sky Blue Sky",
            "Wilco (The Album)", "The whole Lovem", "Star Wars"};

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(getContext(), R.layout.list_item, myArray);

        ListView listView = (ListView) view.findViewById(R.id.listview);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(this);


        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {

        TextView clickedTextView = (TextView)view.findViewById(R.id.textview);
        String text = clickedTextView.getText().toString();
        startDetailActivity(text);
    }


    public static final String EXTRA_TEXT = "myExtraText";

    public void startDetailActivity(String text){
        Intent intent = new Intent(getContext(), DetailActivity.class);
        intent.putExtra(EXTRA_TEXT, text);
        startActivity(intent);
    }
}
