package alberto.gaona.menu;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class DragDropClass extends Activity implements View.OnTouchListener, View.OnDragListener {
    private static final String FLAG = "drag_drop";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drag_drop);
        findViewById(R.id.pink_layout).setOnDragListener(this);
        findViewById(R.id.yellow_layout).setOnDragListener(this);
        findViewById(R.id.text_dd).setOnTouchListener(this);
    }

    @Override
    public boolean onDrag(View layoutView, DragEvent dragEvent) {
        int action = dragEvent.getAction();
        switch (action){
            case DragEvent.ACTION_DRAG_STARTED:
                Log.d(FLAG, "Drag event started");
                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                Log.d(FLAG, "Drag event entered into " + layoutView.toString());
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                Log.d(FLAG, "Drag event exited from " + layoutView.toString());
                break;
            case DragEvent.ACTION_DROP:
                Log.d(FLAG, "Dropped");
                View view = (View) dragEvent.getLocalState();
                ViewGroup owner = (ViewGroup) view.getParent();
                owner.removeView(view);

                LinearLayout container = (LinearLayout) layoutView;
                container.addView(view);
                view.setVisibility(View.VISIBLE);
                break;
            case DragEvent.ACTION_DRAG_ENDED:
                Log.d(FLAG, "Drag ended");
            default:
                break;
        }
        return true;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(null, shadowBuilder, view, 0);
            view.setVisibility(View.INVISIBLE);
            return true;
        }else{
            return false;
        }
    }
}

