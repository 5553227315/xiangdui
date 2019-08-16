package com.example.buju.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.buju.R;

public class ButtonActivity extends AppCompatActivity {


    private Button btn3;
    private Button btn2;
    private TextView td;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        btn3=findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonActivity.this,"你再点一下你试试",Toast.LENGTH_SHORT).show();
            }

        });
        td=findViewById(R.id.textd);
        td.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonActivity.this,"我是文本你也点",Toast.LENGTH_SHORT).show();
            }
        });

        btn2=findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonActivity.this,"你瞅啥",Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void showToast(View view){

        Toast.makeText(this,"你点我干嘛",Toast.LENGTH_SHORT).show();

    }
}
