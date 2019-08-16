package com.example.buju;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.buju.datastorage.DataStorageActivity;
import com.example.buju.http.TextThread;
import com.example.buju.http.WWWActivity;
import com.example.buju.shijianjizhi.EventActivity;


public class MainActivity extends AppCompatActivity {
    private Button mBtnUI;
    private Button mBtnJZ;
    private Button mBtnDta;
    private Button mBtnHttp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnUI=findViewById(R.id.btn_ui);
        mBtnJZ=findViewById(R.id.btn_jizhi);
        mBtnDta=findViewById(R.id.btn_data);
        mBtnHttp=findViewById(R.id.btn_http);


        OnClick onClick=new OnClick();
        mBtnUI.setOnClickListener(onClick);
        mBtnJZ.setOnClickListener(onClick);
        mBtnDta.setOnClickListener(onClick);
        mBtnHttp.setOnClickListener(onClick);


        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);

    }
    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_ui:
                    intent=new Intent(MainActivity.this, UIActivity.class);
                    break;
                case R.id.btn_jizhi:
                    intent=new Intent(MainActivity.this, EventActivity.class);
                    break;
                case R.id.btn_data:
                    intent=new Intent(MainActivity.this, DataStorageActivity.class);
                    break;
                case R.id.btn_http:
                    intent=new Intent(MainActivity.this, WWWActivity.class);

            }
            startActivity(intent);
        }
        
    }
}
