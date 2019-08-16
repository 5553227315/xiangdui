package com.example.buju.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.example.buju.R;

public class TextViewActivity extends AppCompatActivity {

    private TextView mTv3,mTv5,mTv6,mTv7;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        mTv3=findViewById(R.id.text_3);
        mTv3.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);//设置中划线
        mTv3.getPaint().setAntiAlias(true);//去除锯齿

        mTv5=findViewById(R.id.text_5);
        mTv5.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//设置下划线

        mTv6=findViewById(R.id.text_6);
        mTv6.setText(Html.fromHtml("<u>我就不想跑</u>"));

        mTv7=findViewById(R.id.text_7);
        mTv7.setSelected(true);

    }

}
