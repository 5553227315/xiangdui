package com.example.buju.UI.jump;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.example.buju.UI.jump.BActivity;
import com.example.buju.R;

public class AActivity extends AppCompatActivity {
    private Button mBtnjumpa,mBtnA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Log.d("AActivity","----onCreate----");
        Log.d("AActivity","taskid:"+getTaskId()+" ,hash"+hashCode());
        logtaskName();
        mBtnjumpa=findViewById(R.id.jumpa);
        mBtnA=findViewById(R.id.btn_yuanwei);
        mBtnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AActivity.this,AActivity.class);
                startActivity(intent);
            }
        });
        mBtnjumpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //显示1
               Intent intent=new Intent(AActivity.this, BActivity.class);
               Bundle bundle=new Bundle();
               bundle.putString("name","过来了");
               bundle.putInt("number",678);
               intent.putExtras(bundle);
                //startActivity(intent);
                startActivityForResult(intent,0);

                //显示2
//                Intent intent=new Intent();
//                intent.setClass(AActivity.this ,BActivity.class);
//                startActivity(intent);

                //显示3
//                Intent intent=new Intent();
//             intent.setClassName(AActivity.this,"com.example.buju.UI.jump.BActivity");
//                startActivity(intent);

                //显示4
//                Intent intent=new Intent();
//          intent.setComponent(new ComponentName(AActivity.this,"com.example.buju..UI.jump.BActivity"));
//                startActivity(intent);

                //隐示
//                Intent intent=new Intent();
//                intent.setAction("");
//                startActivity(intent);


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(AActivity.this,data.getExtras().getString("title"),Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("AActivity","----onNewIntent----");
        Log.d("AActivity","taskid:"+getTaskId()+" ,hash"+hashCode());
        logtaskName();
    }

    private  void  logtaskName(){
        try {
            ActivityInfo info=getPackageManager().getActivityInfo(getComponentName(),PackageManager.GET_META_DATA);
            Log.d("AActivity",info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
