package tw.brad.brad15;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class UnderActivity extends AppCompatActivity {
    private Timer timer;
    private UnderControl under;
    private UIHandler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_under);

        under= (UnderControl)findViewById(R.id.underC);
        timer = new Timer();
        timer.schedule(new MyTask(),1000,100);
    }
    private class MyTask extends TimerTask{
        @Override
        public void run() {
            try {
                MultipartUtility mu = new MultipartUtility("http://www.brad.tw/iii2001/brad02.php","UTF-8");
               List<String> ret = mu.finish();
                String data = ret.get(0);
                String[] xy = data.split(":");//看到冒號切
                float x = new Float(xy[0]);
                float y = new Float(xy[1]);
                Log.i("ming",x+"x"+y);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private class UIHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);



        }
    }
    @Override
    public void finish() {
        if(timer!=null){
            timer.cancel();
            timer.purge();
            timer = null;
        }
        super.finish();
    }
}
