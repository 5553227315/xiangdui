package com.example.buju.shijianjizhi;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import com.example.buju.util.ToastUtil;

public class MyClickListener implements View.OnClickListener {
    private Context context;
    public MyClickListener(Context context){
        this.context=context;

    }

    @Override
    public void onClick(View view) {
        ToastUtil.showMsg(context,"用外部类点击");

    }
}
