package com.example.buju;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private boolean isRun = true;
    private TextView number;
    private Handler mHandler;
    private long mSecond = 3;
    private Handler timeHandler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==1) {
                mSecond--;
                number.setText(mSecond+"");
                if (mSecond==0) {

                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        number=findViewById(R.id.shu);

        mHandler=new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Main2Activity.this,MainActivity.class);
                Main2Activity.this.finish();
                startActivity(intent);

            }
        },3000);


        new Thread(){
            @Override
            public void run() {
                super.run();
                Message message=new Message();
                message.what=1;
                mHandler.sendMessage(message);
            }
        }.start();
        startRun();

    }
    private void startRun() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (isRun) {
                    try {
                        Thread.sleep(1000); // sleep 1000ms
                        Message message = Message.obtain();
                        message.what = 1;
                        timeHandler.sendMessage(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
