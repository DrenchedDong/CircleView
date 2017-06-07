package dongting.bwei.com.circleview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
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
    private final Rect rect;

    public MyCircle(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();

        paint.setColor(Color.RED);
        paint.setAntiAlias(true);

        rect = new Rect();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(x,y,50,paint);

        rect.set((int)x-100,(int)y-100,(int)x+100,(int)y+100);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:

                break;

            case MotionEvent.ACTION_MOVE:

                //点击屏幕任何地方都可拖动圆形

               /* x = event.getX();
                y = event.getY();
                *//*System.out.println("x = " + x);
                System.out.println("y = " + y);
*//*
                //主线程调用刷新
                invalidate();
                //子线程 调用刷新
//                postInvalidate();*/


                //点击圆形区域才可拖动圆形 1.勾股定理两点距离

               /* float x_t=event.getX();
                float y_t=event.getY();
                float t=(x_t-x)*(x_t-x)+(y_t-y)*(y_t-y);

                float sqrt = (float) Math.sqrt(t);
                if(sqrt<=50){
                    x=event.getX();
                    y=event.getY();
                    invalidate();
                }*/


                //点击圆形区域才可拖动圆形 2.利用矩形

                float x_t=event.getX();
                float y_t=event.getY();

                if(x_t>rect.left && x_t<rect.right && y_t>rect.top && y_t<rect.bottom){

                    x=event.getX();
                    y=event.getY();
                    invalidate();
                }


                break;
            case MotionEvent.ACTION_UP:

                break;

        }
        return true;
    }
}
