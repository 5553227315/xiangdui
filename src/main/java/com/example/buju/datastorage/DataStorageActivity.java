package com.example.buju.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.buju.R;

public class DataStorageActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnSharedPerecens;
    private Button mFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);
        mBtnSharedPerecens=findViewById(R.id.btn_sharedpreferences);
        mFile=findViewById(R.id.btn_file);
        mBtnSharedPerecens.setOnClickListener(this);
        mFile.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent=null;
        switch (view.getId()){
            case R.id.btn_sharedpreferences:
                intent=new Intent(DataStorageActivity.this, SharedPreferencesActivity.class);
                break;
            case R.id.btn_file:
                intent=new Intent(DataStorageActivity.this, FileActivity.class);
                break;
        }
        startActivity(intent);
    }
}
