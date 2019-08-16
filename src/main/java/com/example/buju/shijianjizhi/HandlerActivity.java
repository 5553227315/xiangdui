package com.example.buju.shijianjizhi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.buju.R;
import com.example.buju.UI.ButtonActivity;
import com.example.buju.util.ToastUtil;

public class HandlerActivity extends AppCompatActivity {
    private TextView  secondsTv;
    private RelativeLayout countDown;
    private Handler mHandler;
    private boolean isRun = true;
    private long mSecond = 3;
    private Handler timeHandler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==1) {
                computeTime();
                secondsTv.setText(mSecond+"");
                if (mSecond==0) {

                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        secondsTv=findViewById(R.id.seconds_tv);
        mHandler=new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(HandlerActivity.this, ButtonActivity.class);
                HandlerActivity.this.finish();
                startActivity(intent);

            }
        },3000);
        mHandler=new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case 1:
                        ToastUtil.showMsg(HandlerActivity.this,"线程通信成功");
                        break;
                }
            }
        };
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

    /**
     * 倒计时计算
     */
    private void computeTime() {
        mSecond--;
    }

}
