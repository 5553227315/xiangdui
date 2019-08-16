package com.example.buju.UI.jump;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.buju.R;

public class BActivity extends AppCompatActivity {
    private TextView mTv;
    private Button mBtnfinish,mBtnhuiA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Log.d("BActivity","----onCreate----");
        Log.d("BActivity","taskid:"+getTaskId()+" ,hash"+hashCode());
        logtaskName();
        mTv=findViewById(R.id.shuju);

        mBtnfinish=findViewById(R.id.btn_finish);
        Bundle bundle=new Bundle();
        bundle=getIntent().getExtras();
        String name=bundle.getString("name");
        int number=bundle.getInt("number");
        mTv.setText(name+number);

        mBtnfinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                Bundle bundle1=new Bundle();
                bundle1.putString("title","回来了");
                intent.putExtras(bundle1);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("BActivity","----onNewIntent----");
        Log.d("BActivity","taskid:"+getTaskId()+" ,hash"+hashCode());
    }

    private  void  logtaskName(){
        try {
            ActivityInfo info=getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("AActivity",info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
