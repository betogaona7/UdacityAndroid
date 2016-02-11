package alberto.gaona.navigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView textView = (TextView)findViewById(R.id.textview2);
        Intent intent = getIntent();
        String text = intent.getStringExtra(Tab2.EXTRA_TEXT);
        textView.setText(text);
    }
}
