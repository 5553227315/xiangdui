package com.example.buju.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.buju.R;

public class LifeCycleActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Log.d("LifeCycle","----onCreate----制造");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle","----onStart----启动");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle","----onResume----（停顿之后）继续");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle","----onPause----暂停");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle","----onStop----停止");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle","----onRestart----");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle","----onDestroy----摧毁");
    }
}
