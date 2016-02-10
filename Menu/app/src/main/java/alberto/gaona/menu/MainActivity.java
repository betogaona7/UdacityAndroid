package alberto.gaona.menu;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//Practice 2
        btn = (Button)findViewById(R.id.menu_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create the instance of PopupMenu
                PopupMenu popup = new PopupMenu(MainActivity.this, btn);
                //Inflate the popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());

                //Registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    public boolean onMenuItemClick(MenuItem item){
                        Toast.makeText(MainActivity.this,"You CLicked: " + item.getTitle(), Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
                popup.show();//Showing the popup
            }//closing the setOnClickListener method
        });
        //Practice 3
        TextView txt = (TextView)findViewById(R.id.text_one);
        txt.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //Toast.makeText(MainActivity.this, "Long click :D", Toast.LENGTH_LONG).show();
                //return false;

                // Send to the Practice 4
                Intent dragdrop = new Intent(MainActivity.this, DragDropClass.class);
                startActivity(dragdrop);
                return true;
            }
        });
        txt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(MainActivity.this, "Not long click :(",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout main_view = (RelativeLayout)findViewById(R.id.main_view);

        switch (item.getItemId()){
            case R.id.menu_red:
                if(item.isChecked()){
                    item.setChecked(false);
                }else{
                    item.setChecked(true);
                }
                main_view.setBackgroundColor(Color.RED);
                return true;
            case R.id.menu_green:
                if(item.isChecked()){
                    item.setChecked(false);
                }else{
                    item.setChecked(true);
                }
                main_view.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.menu_yellow:
                if(item.isChecked()){
                    item.setChecked(false);
                }else{
                    item.setChecked(true);
                }
                main_view.setBackgroundColor(Color.YELLOW);
                return true;
            case R.id.dragdrop2:
                Intent drag2 = new Intent(MainActivity.this, DragDripClass2.class);
                startActivity(drag2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
