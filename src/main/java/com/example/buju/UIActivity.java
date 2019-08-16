package com.example.buju;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.buju.UI.customDialog.CustomDialogActivity;
import com.example.buju.UI.jump.AActivity;
import com.example.buju.UI.ButtonActivity;
import com.example.buju.UI.CheckboxActivity;
import com.example.buju.UI.DialogActivity;
import com.example.buju.UI.EditTextActivity;
import com.example.buju.UI.ImageViewActivity;
import com.example.buju.UI.LifeCycleActivity;
import com.example.buju.UI.PopupWindowActivity;
import com.example.buju.UI.ProgressActivity;
import com.example.buju.UI.RatioButtonActivity;
import com.example.buju.UI.TextViewActivity;
import com.example.buju.UI.ToastActivity;
import com.example.buju.UI.WebViewActivity;
import com.example.buju.UI.fragment.ContainerActivity;
import com.example.buju.UI.gridview.GridViewActivity;
import com.example.buju.UI.listview.ListViewActivity;
import com.example.buju.UI.recyclerview.RecyclerViewActivity;

public class UIActivity extends AppCompatActivity {
    private Button mBtnTextView;
    private Button mBtnButton;
    private Button mBtnEditText;
    private Button mBtnRatioButton;
    private Button mBtnCheckbox;
    private Button mBtnImageView;
    private Button mBtnListView;
    private Button mBtnGridView;
    private Button mBtnRecyclerView;
    private Button mBtnWebView;
    private Button mBtnToast;
    private Button mBtnDialog;
    private Button mBtnProgress;
    private Button mBtnCustomDialog;
    private Button mBtnPopupWindow;
    private Button mBtnLifeCycle;
    private Button mBtnJump;
    private Button mBtnFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        mBtnTextView = findViewById(R.id.btn_view1);
        mBtnButton=findViewById(R.id.btn_button);
        mBtnEditText=findViewById(R.id.editText);
        mBtnRatioButton=findViewById(R.id.radiobutton);
        mBtnCheckbox=findViewById(R.id.checkboxbutton);
        mBtnImageView=findViewById(R.id.imageviewbutton);
        mBtnListView=findViewById(R.id.listviewbutton);
        mBtnGridView=findViewById(R.id.gridviewbutton);
        mBtnRecyclerView=findViewById(R.id.recyclerviewbutton);
        mBtnWebView=findViewById(R.id.webviewbutton);
        mBtnToast=findViewById(R.id.toastbutton);
        mBtnDialog=findViewById(R.id.dialogbutton);
        mBtnProgress=findViewById(R.id.progress);
        mBtnCustomDialog=findViewById(R.id.customdialogbutton);
        mBtnPopupWindow=findViewById(R.id.popupwindowbutton);
        mBtnLifeCycle=findViewById(R.id.lifecycle);
        mBtnJump=findViewById(R.id.jumpbutton);
        mBtnFragment=findViewById(R.id.framgmentbutton);
        setListeners();


    }

    private void setListeners(){
        OnCilck onCilck=new OnCilck();
        mBtnTextView.setOnClickListener(onCilck);
        mBtnEditText.setOnClickListener(onCilck);
        mBtnButton.setOnClickListener(onCilck);
        mBtnRatioButton.setOnClickListener(onCilck);
        mBtnCheckbox.setOnClickListener(onCilck);
        mBtnImageView.setOnClickListener(onCilck);
        mBtnListView.setOnClickListener(onCilck);
        mBtnGridView.setOnClickListener(onCilck);
        mBtnRecyclerView.setOnClickListener(onCilck);
        mBtnWebView.setOnClickListener(onCilck);
        mBtnToast.setOnClickListener(onCilck);
        mBtnDialog.setOnClickListener(onCilck);
        mBtnProgress.setOnClickListener(onCilck);
        mBtnCustomDialog.setOnClickListener(onCilck);
        mBtnPopupWindow.setOnClickListener(onCilck);
        mBtnLifeCycle.setOnClickListener(onCilck);
        mBtnJump.setOnClickListener(onCilck);
        mBtnFragment.setOnClickListener(onCilck);
    }
    private class OnCilck implements View.OnClickListener{
        public void onClick(View v){
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_view1:
                    //跳转到TextView演示画面
                    intent=new Intent(UIActivity.this, TextViewActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_button:
                    //跳转到Button演示界面
                    intent=new Intent(UIActivity.this, ButtonActivity.class);
                    startActivity(intent);
                    break;
                case R.id.editText:
                    //跳转到EditText演示界面
                    intent=new Intent(UIActivity.this, EditTextActivity.class);
                    startActivity(intent);
                    break;
                case R.id.radiobutton:
                    //跳转到RadioButton演示界面
                    intent=new Intent(UIActivity.this, RatioButtonActivity.class);
                    break;
                case R.id.checkboxbutton:
                    //跳转到CheckBox演示界面
                    intent=new Intent(UIActivity.this, CheckboxActivity.class);
                    break;
                case R.id.imageviewbutton:
                    //跳转到ImageView演示界面
                    intent=new Intent(UIActivity.this, ImageViewActivity.class);
                    break;
                case R.id.listviewbutton:
                     //跳转到ListView演示界面
                    intent=new Intent(UIActivity.this,ListViewActivity.class);
                    break;
                case R.id.gridviewbutton:
                    //跳转到GridView演示界面
                    intent=new Intent(UIActivity.this, GridViewActivity.class);
                    break;
                case R.id.recyclerviewbutton:
                    //跳转到RecyclerView演示界面
                    intent=new Intent(UIActivity.this, RecyclerViewActivity.class);
                    break;
                case R.id.webviewbutton:
                    //跳转到WebView演示界面
                    intent=new Intent(UIActivity.this, WebViewActivity.class);
                    break;
                case R.id.toastbutton:
                    //跳转到Toast演示界面
                    intent=new Intent(UIActivity.this, ToastActivity.class);
                    break;
                case R.id.dialogbutton:
                    //跳转到Dialog演示界面
                    intent=new Intent(UIActivity.this, DialogActivity.class);
                    break;
                case R.id.progress:
                    //跳转到Progress演示界面
                    intent=new Intent(UIActivity.this, ProgressActivity.class);
                    break;
                case R.id.customdialogbutton:
                    //跳转到CustomDialog演示画面
                    intent=new Intent(UIActivity.this, CustomDialogActivity.class);
                    break;
                case R.id.popupwindowbutton:
                    //跳转到PopupWindow演示画面
                    intent=new Intent(UIActivity.this, PopupWindowActivity.class);
                    break;
                case R.id.lifecycle:
                    //跳转到LifeCycle演示画面
                    intent=new Intent(UIActivity.this, LifeCycleActivity.class);
                    break;
                case R.id.jumpbutton:
                    //跳转到Jump演示界面
                    intent=new Intent(UIActivity.this, AActivity.class);
                    break;
                case R.id.framgmentbutton:
                    //跳转到Fragment演示界面
                    intent=new Intent(UIActivity.this, ContainerActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}


















