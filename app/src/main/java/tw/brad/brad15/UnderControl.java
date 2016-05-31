package tw.brad.brad15;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by brad on 16/5/31.
 */
public class UnderControl extends View {
    private float ballX, ballY;
    private Paint paint;

    public UnderControl(Context c, AttributeSet set){
        super(c, set);
        setBackgroundColor(Color.BLACK);

        paint = new Paint();
        paint.setColor(Color.RED);

        ballX = ballY = 100;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(ballX, ballY, 40, paint);
    }
}
