package alberto.gaona.navigation;


import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends Activity {

    private static String VALUE = "myValue";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        String value = getIntent().getExtras().getString(VALUE);
        Toast.makeText(SecondActivity.this, value, Toast.LENGTH_SHORT).show();
    }
}
