package com.example.buju.UI;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.buju.R;
import com.example.buju.util.ToastUtil;

public class DialogActivity extends AppCompatActivity {
    private Button mBtnDialog1,mBtnDialog2,mBtnDialog3,mBtnDialog4 ,mBtnDialog5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dlalog);
        mBtnDialog1=findViewById(R.id.btn_dialg_1);
        mBtnDialog2=findViewById(R.id.btn_dialg_2);
        mBtnDialog3=findViewById(R.id.btn_dialg_3);
        mBtnDialog4=findViewById(R.id.btn_dialg_4);
        mBtnDialog5=findViewById(R.id.btn_dialg_5);
        OnClick onClick=new OnClick();
        mBtnDialog1.setOnClickListener(onClick);
        mBtnDialog2.setOnClickListener(onClick);
        mBtnDialog3.setOnClickListener(onClick);
        mBtnDialog4.setOnClickListener(onClick);
        mBtnDialog5.setOnClickListener(onClick);

    }
    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_dialg_1:
                    AlertDialog.Builder builder=new AlertDialog.Builder(DialogActivity.this);
                    builder.setTitle("请回答").setMessage("你觉得如何?")
                            .setIcon(R.mipmap.yonghu)
                    .setPositiveButton("棒", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ToastUtil.showMsg(DialogActivity.this,"你很诚实");
                        }
                    }).setNeutralButton("还行", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ToastUtil.showMsg(DialogActivity.this,"你再瞅瞅");
                        }
                    })
                    .setNegativeButton("不好", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ToastUtil.showMsg(DialogActivity.this,"睁眼说瞎话");
                        }
                    }).show();
                    break;
                case R.id.btn_dialg_2:
                    final String[]array2=new String[]{"男","女"};
                    AlertDialog.Builder builder2=new AlertDialog.Builder(DialogActivity.this);
                    builder2.setTitle("选择性别").setItems(array2, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ToastUtil.showMsg(DialogActivity.this,array2[i]);
                        }
                    }).show();
                    break;
                case R.id.btn_dialg_3:
                    final String[]array3=new String[]{"男","女"};
                    AlertDialog.Builder builder3=new AlertDialog.Builder(DialogActivity.this);
                    builder3.setTitle("选择性别").setSingleChoiceItems(array3, 1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ToastUtil.showMsg(DialogActivity.this,array3[i]);
                            dialogInterface.dismiss();
                        }
                    }).setCancelable(false).show();
                    break;
                case R.id.btn_dialg_4:
                    final String[]array4=new String[]{"唱歌","跳舞","写代码"};
                    final boolean[] isSelected=new boolean[]{false,false,true};
                    AlertDialog.Builder builder4=new AlertDialog.Builder(DialogActivity.this);
                    builder4.setTitle("选择兴趣").setMultiChoiceItems(array4, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                            ToastUtil.showMsg(DialogActivity.this,array4[i]+":"+b);
                        }
                    }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    }).setNegativeButton("取消",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    }).setCancelable(false).show();
                    break;
                case R.id.btn_dialg_5:
                    AlertDialog.Builder builder5=new AlertDialog.Builder(DialogActivity.this);
                    View view=LayoutInflater.from(DialogActivity.this).inflate(R.layout.layout_dialog,null);
                    final EditText editTextName=view.findViewById(R.id.et_username);
                    Button btnlogin=view.findViewById(R.id.btn_login);
                    btnlogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String l=editTextName.getText().toString();
                            ToastUtil.showMsg(DialogActivity.this,"用户名"+editTextName.getText().toString()+"登录成功");
                        }
                    });
                    EditText editTextPassword=view.findViewById(R.id.et_password);

                    builder5.setTitle("请先登录").setView(view).setCancelable(false).show();
                    break;



            }
        }
    }
}
