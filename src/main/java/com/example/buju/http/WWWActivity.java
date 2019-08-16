package com.example.buju.http;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.buju.R;

public class WWWActivity extends AppCompatActivity {
    private Button mBtnThrad;
    private Button mBtnAsyncTask;
    private Button mBtnHttpG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_www);
        mBtnThrad=findViewById(R.id.xiancheng);
        mBtnAsyncTask=findViewById(R.id.btn_SocketClient);
        mBtnHttpG=findViewById(R.id.btn_http);

        OnClick onClick=new OnClick();
        mBtnThrad.setOnClickListener(onClick);
        mBtnAsyncTask.setOnClickListener(onClick);
        mBtnHttpG.setOnClickListener(onClick);

    }
    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()){
                case R.id.xiancheng:
                    intent=new Intent(WWWActivity.this,TextThread.class);
                    break;
                case R.id.btn_SocketClient:
                    intent=new Intent(WWWActivity.this,SocketClientActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
