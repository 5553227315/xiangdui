package com.example.buju;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.view.View.OnClickListener;
import com.example.buju.UI.UIFragment;
import com.example.buju.datastorage.ShuJuFragment;
import com.example.buju.http.WebFragment;
import com.example.buju.shijianjizhi.ShiJianFragment;

public class M1Activity extends FragmentActivity implements OnClickListener {
    private UIFragment uiFragment;
    private WebFragment webFragment;
    private ShuJuFragment shuJuFragment;
    private ShiJianFragment shiJianFragment;
    private RadioButton radioButton1,radioButton2,radioButton3,radioButton4;
    FragmentManager fManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m1);
        fManager = getSupportFragmentManager();
        initViews();
        FragmentTransaction transaction2 = fManager.beginTransaction();
        hideFragments(transaction2);
        uiFragment = new UIFragment();
        transaction2.add(R.id.content, uiFragment);
        transaction2.commit();



    }
    public void initViews(){
        radioButton1=findViewById(R.id.btn1);
        radioButton2=findViewById(R.id.btn2);
        radioButton3=findViewById(R.id.btn3);
        radioButton4=findViewById(R.id.btn4);
        radioButton1.setOnClickListener(this);
        radioButton2.setOnClickListener(this);
        radioButton3.setOnClickListener(this);
        radioButton4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                setChioceItem(0);
                break;
            case R.id.btn2:
                setChioceItem(1);
                break;
            case R.id.btn3:
                setChioceItem(2);
                break;
            case R.id.btn4:
                setChioceItem(3);
        }

    }
    public void setChioceItem(int index)
    {
        FragmentTransaction transaction = fManager.beginTransaction();
        hideFragments(transaction);

        switch (index) {
            case 0:
                if (uiFragment == null) {
                    // 如果zuoFragment为空，则创建一个并添加到界面上
                    uiFragment = new UIFragment();
                    transaction.add(R.id.content, uiFragment);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(uiFragment);
                }
                break;
            case 1:
                if (shiJianFragment == null) {
                    // 如果fg1为空，则创建一个并添加到界面上
                    shiJianFragment = new ShiJianFragment();
                    transaction.add(R.id.content, shiJianFragment);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(shiJianFragment);
                }
                break;
            case 2:
                if (shuJuFragment == null) {
                    // 如果fg1为空，则创建一个并添加到界面上
                    shuJuFragment = new ShuJuFragment();
                    transaction.add(R.id.content, shuJuFragment);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(shuJuFragment);
                }
                break;
            case 3:
                if (webFragment == null){
                    webFragment = new WebFragment();
                    transaction.add(R.id.content,webFragment);
                }else {
                    transaction.show(webFragment);
                }
        }
        transaction.commit();
    }
    private void hideFragments(FragmentTransaction transaction) {
        if (uiFragment != null) {
            transaction.hide(uiFragment);
        }
        if (shuJuFragment != null) {
            transaction.hide(shuJuFragment);
        }
        if (shiJianFragment != null) {
            transaction.hide(shiJianFragment);
        }
        if (webFragment != null){
            transaction.hide(webFragment);
        }
    }
}
