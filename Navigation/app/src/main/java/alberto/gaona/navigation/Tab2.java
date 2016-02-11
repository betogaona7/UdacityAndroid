package alberto.gaona.navigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Tab2 extends Fragment implements AdapterView.OnItemClickListener{

    private ListView listView;
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

        listView = (ListView) view.findViewById(R.id.sportsList);
        listView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
        Toast.makeText(getContext(), ((TextView)view).getText(), Toast.LENGTH_LONG).show();
    }
}
