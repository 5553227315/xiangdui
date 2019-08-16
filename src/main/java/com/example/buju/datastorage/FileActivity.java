package com.example.buju.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.buju.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileActivity extends AppCompatActivity {
    private EditText mEtName1;
    private Button mBtnSave1,mBtnShow1;
    private TextView mTvShow1;
    private final String mFileName1 = "text.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        mEtName1=findViewById(R.id.et_name1);
        mBtnSave1=findViewById(R.id.btn_sava1);
        mBtnShow1=findViewById(R.id.btn_show1);
        mTvShow1=findViewById(R.id.tv_show1);
        mBtnSave1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save(mEtName1.getText().toString());
            }
        });

        mBtnShow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTvShow1.setText(read());
            }
        });
    }

    //存储数据
    private void save(String content)  {
        FileOutputStream fileOutputStream=null;
        try {
//            fileOutputStream =openFileOutput(mFileName1,MODE_PRIVATE);
            //创建文件夹
            File dir =new File(Environment.getExternalStorageDirectory(),"skypan");
            if (!dir.exists()){
                dir.mkdirs();
            }
            //创建文件
            File file=new File(dir,mFileName1);
            if(!file.exists()){
                file.createNewFile();
            }
            fileOutputStream=new FileOutputStream(file);
            fileOutputStream.write(content.getBytes());
        }  catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    //读取数据
    private String read(){
        FileInputStream fileInputStream=null;
        try{
//            fileInputStream=openFileInput(mFileName1);
            File file=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"skypan",mFileName1);
            fileInputStream=new FileInputStream(file);
            byte[] buff=new byte[1024];
            StringBuffer sb=new StringBuffer("");
            int len=0;
            while ((len=fileInputStream.read(buff))>0){
                sb.append(new String(buff,0,len));
            }
            return sb.toString();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (fileInputStream!=null){
                try {
                    fileInputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
