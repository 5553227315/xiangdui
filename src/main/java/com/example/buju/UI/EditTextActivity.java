package com.example.buju.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.buju.R;

public class EditTextActivity extends AppCompatActivity {
    private Button btnd;
    private EditText yonghu;
    private EditText mima;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        btnd=findViewById(R.id.denglu);
        btnd.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Toast.makeText(EditTextActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
            }
        });
        yonghu=findViewById(R.id.et_1);
        yonghu.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            Log.d("edittext", charSequence.toString());

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    });
        mima=findViewById(R.id.et_2);
        mima.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("edittext",charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



    }
}
