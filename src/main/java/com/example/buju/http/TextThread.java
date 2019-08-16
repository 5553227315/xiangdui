package com.example.buju.http;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.buju.R;

public class TextThread extends AppCompatActivity {
    private Button mBtnzuse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        mBtnzuse=findViewById(R.id.btnweb);

        mBtnzuse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(){
                    public void run(){
                        while (true){
                            try {
                                sleep(2000);
                                Log.d("TextThread",">>>>>>>>>>>Tick");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }


                    };
                }.start();
//                try {
//                    Thread.sleep(2000);
//                    Log.d("TextThread",">>>>>>>>>>>Tick");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        });
    }
}
