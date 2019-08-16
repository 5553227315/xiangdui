package com.example.buju.shijianjizhi;

import android.app.Activity;
import android.view.View;

import com.example.buju.util.ToastUtil;

public class MyClickListener implements View.OnClickListener {
    private Activity mactivity;
    public MyClickListener(Activity activity){
        this.mactivity=activity;

    }
    @Override
    public void onClick(View view) {
        ToastUtil.showMsg(mactivity,"用外部类点击");

    }
}
