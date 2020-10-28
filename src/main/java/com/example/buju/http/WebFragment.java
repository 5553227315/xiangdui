package com.example.buju.http;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.buju.R;

public class WebFragment extends Fragment {
    private Button mBtnThrad;
    private Button mBtnAsyncTask;
    private Button mBtnHttpG;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_www, container,false);
        mBtnThrad=view.findViewById(R.id.xiancheng);
        mBtnAsyncTask=view.findViewById(R.id.btn_SocketClient);
        mBtnHttpG=view.findViewById(R.id.btn_http);

       OnClick onClick=new OnClick();
        mBtnThrad.setOnClickListener(onClick);
        mBtnAsyncTask.setOnClickListener(onClick);
        mBtnHttpG.setOnClickListener(onClick);
        return view;
    }

    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Context context = getActivity();
            Intent intent = null;
            switch (view.getId()){
                case R.id.xiancheng:
                    intent=new Intent(context,TextThread.class);
                    break;
                case R.id.btn_SocketClient:
                    intent=new Intent(context,SocketClientActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }

}