package tw.brad.brad15;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by brad on 16/5/31.
 */
public class GameView extends View {
    private float ballX, ballY;
    private Paint paint;

    public GameView(Context context, AttributeSet set){
        super(context, set);
        setBackgroundColor(Color.BLACK);

        paint = new Paint();
        paint.setColor(Color.YELLOW);

        ballX = ballY = 100;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(ballX, ballY, 40, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ballX = event.getX(); ballY = event.getY();
        sendXY();
        invalidate();
        return true;
    }
    private void sendXY(){
        new Thread(){
            @Override
            public void run() {
                try{
                    MultipartUtility mu =
                            new MultipartUtility(
                                    "http://www.brad.tw/iii2001/brad01.php","UTF-8");
                    mu.addFormField("x",ballX+"");
                    mu.addFormField("y",""+ballY);
                    mu.finish();
                }catch(Exception e){

                }
            }
        }.start();
    }

}
