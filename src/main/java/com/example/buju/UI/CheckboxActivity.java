package com.example.buju.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.buju.R;

public class CheckboxActivity extends AppCompatActivity {
    private CheckBox cb5;
    private CheckBox cb6;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);
        cb5=findViewById(R.id.checkbox_5);
        cb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(CheckboxActivity.this,b?"5选中":"5未选中",Toast.LENGTH_SHORT).show();
            }
        });
        cb6=findViewById(R.id.checkbox_6);
        cb6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(CheckboxActivity.this,b?"6选中":"6未选中",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
