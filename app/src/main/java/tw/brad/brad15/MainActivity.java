package tw.brad.brad15;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText account, passwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        account = (EditText)findViewById(R.id.account);
        passwd = (EditText)findViewById(R.id.passwd);
    }

    public void login(View v){
        new Thread(){
            @Override
            public void run() {
                doLogin();
            }
        }.start();
    }

    private void doLogin(){
        String strAccount = account.getText().toString();
        String strPasswd = passwd.getText().toString();
        try{
            MultipartUtility mu = new MultipartUtility(
                    "http://10.0.3.2/ming0531/brad08.php",
                    "UTF-8");
            mu.addFormField("account",strAccount);
            mu.addFormField("passwd",strPasswd);

            List<String> ret = mu.finish();
            String result = ret.get(0);

            if (result.equals("OK")){
                Log.i("brad", "OK");
                Intent it = new Intent(this,
                        GameActivity.class);
                startActivity(it);
            }else{
                Log.i("brad", "XX");
            }


        }catch(Exception e){
            Log.i("brad", e.toString());
        }
    }
    public void gotoUnder(View v){
        Intent it = new Intent(this, UnderActivity.class);
        startActivity(it);
    }

}
