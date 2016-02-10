package alberto.gaona.menu;


import android.app.Activity;
import android.content.ClipData;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class DragDripClass2 extends Activity{

    private TextView opt1, opt2, opt3, chs1, chs2, chs3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drag_drop_2);

        opt1 = (TextView)findViewById(R.id.option1);
        opt2 = (TextView)findViewById(R.id.option2);
        opt3 = (TextView)findViewById(R.id.option3);

        chs1 = (TextView)findViewById(R.id.choice1);
        chs2 = (TextView)findViewById(R.id.choice2);
        chs3 = (TextView)findViewById(R.id.choice3);


        opt1.setOnTouchListener(new ChoiceTouchListener());
        opt2.setOnTouchListener(new ChoiceTouchListener());
        opt3.setOnTouchListener(new ChoiceTouchListener());

        chs1.setOnDragListener(new ChoiceDragListener());
        chs2.setOnDragListener(new ChoiceDragListener());
        chs3.setOnDragListener(new ChoiceDragListener());
    }

    //Create inner class
    private final class ChoiceTouchListener implements View.OnTouchListener{
        //This class will allow the app to detect users touching particular View.

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            //Check what Motion Event has triggered
            if(MotionEvent.ACTION_DOWN == motionEvent.getAction()){
                //We're only interested in cses where the user has touched the View to drag it.
                ClipData data = ClipData.newPlainText("","");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                //Start dragging the item touched
                view.startDrag(data, shadowBuilder, view, 0);
                return true;
            }else {
                return false;
            }
        }
    }

    //Another inner class
    private final class ChoiceDragListener implements View.OnDragListener{

        @Override
        public boolean onDrag(View v, DragEvent event) {

            switch (event.getAction()){
                case DragEvent.ACTION_DRAG_STARTED:
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    //Handle the dragged view being dropped over a target view
                    View view = (View)event.getLocalState();
                    //Stop displaying the view where it was before it was dragged
                    view.setVisibility(View.INVISIBLE);
                    //View dragged item is being dropped on
                    TextView dropTarget = (TextView)v;
                    //view being dragged and dropped
                    TextView dropped = (TextView) view;
                    //Update the text in the target view to reflect the data being dropped
                    dropTarget.setText(dropped.getText());
                    //Make it bold to highlight the fact that an item has been dropped
                    dropTarget.setTypeface(Typeface.DEFAULT_BOLD);

                    //if an item has already been dropped here, there will be a tag
                    Object tag = dropTarget.getTag();
                    //If there is already an item here, set it back visible in its original place
                    if(tag != null){
                        //The tag is the view id already dropped here
                        int existingID = (Integer)tag;
                        //Set the original view visible again
                        findViewById(existingID).setVisibility(View.VISIBLE);
                    }
                    //set the tag in the target view to the ID of the view being dropped
                    dropTarget.setTag(dropped.getId());
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    break;
                default:
                    break;
            }
            return true;
        }
    }
}
