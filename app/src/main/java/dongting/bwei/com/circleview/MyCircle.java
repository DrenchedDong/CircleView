package dongting.bwei.com.circleview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 作者:${董婷}
 * 日期:2017/6/6
 * 描述:
 */

public class MyCircle extends View {

    private final Paint paint;
    private float x =100;
    private float y =100;

    public MyCircle(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();

        paint.setColor(Color.RED);
        paint.setAntiAlias(true);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(x,y,10,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:

                break;

            case MotionEvent.ACTION_MOVE:

                x = event.getX();
                y = event.getY();
                /*System.out.println("x = " + x);
                System.out.println("y = " + y);
*/
                //主线程调用刷新
                invalidate();
                //子线程 调用刷新
//                postInvalidate();

                break;
            case MotionEvent.ACTION_UP:

                break;

        }
        return true;
    }
}
