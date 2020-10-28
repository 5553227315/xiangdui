package com.example.buju.UI;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.buju.R;
import com.example.buju.UI.customDialog.CustomDialogActivity;
import com.example.buju.UI.fragment.ContainerActivity;
import com.example.buju.UI.gridview.GridViewActivity;
import com.example.buju.UI.jump.AActivity;
import com.example.buju.UI.listview.ListViewActivity;
import com.example.buju.UI.recyclerview.RecyclerViewActivity;
import com.example.buju.UIActivity;

public class UIFragment extends Fragment {
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_ui, container,false);

        mBtnTextView=view.findViewById(R.id.btn_view1);
        mBtnButton=view.findViewById(R.id.btn_button);
        mBtnEditText=view.findViewById(R.id.editText);
        mBtnRatioButton=view.findViewById(R.id.radiobutton);
        mBtnCheckbox=view.findViewById(R.id.checkboxbutton);
        mBtnImageView=view.findViewById(R.id.imageviewbutton);
        mBtnListView=view.findViewById(R.id.listviewbutton);
        mBtnGridView=view.findViewById(R.id.gridviewbutton);
        mBtnRecyclerView=view.findViewById(R.id.recyclerviewbutton);
        mBtnWebView=view.findViewById(R.id.webviewbutton);
        mBtnToast=view.findViewById(R.id.toastbutton);
        mBtnDialog=view.findViewById(R.id.dialogbutton);
        mBtnProgress=view.findViewById(R.id.progress);
        mBtnCustomDialog=view.findViewById(R.id.customdialogbutton);
        mBtnPopupWindow=view.findViewById(R.id.popupwindowbutton);
        mBtnLifeCycle=view.findViewById(R.id.lifecycle);
        mBtnJump=view.findViewById(R.id.jumpbutton);
        mBtnFragment=view.findViewById(R.id.framgmentbutton);
        setListeners();
        return view;
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
            Context context = getActivity();
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_view1:
                    //跳转到TextView演示画面
                    intent=new Intent(context, TextViewActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_button:
                    //跳转到Button演示界面
                    intent=new Intent(context, ButtonActivity.class);
                    startActivity(intent);
                    break;
                case R.id.editText:
                    //跳转到EditText演示界面
                    intent=new Intent(context, EditTextActivity.class);
                    startActivity(intent);
                    break;
                case R.id.radiobutton:
                    //跳转到RadioButton演示界面
                    intent=new Intent(context, RatioButtonActivity.class);
                    break;
                case R.id.checkboxbutton:
                    //跳转到CheckBox演示界面
                    intent=new Intent(context, CheckboxActivity.class);
                    break;
                case R.id.imageviewbutton:
                    //跳转到ImageView演示界面
                    intent=new Intent(context, ImageViewActivity.class);
                    break;
                case R.id.listviewbutton:
                    //跳转到ListView演示界面
                    intent=new Intent(context, ListViewActivity.class);
                    break;
                case R.id.gridviewbutton:
                    //跳转到GridView演示界面
                    intent=new Intent(context, GridViewActivity.class);
                    break;
                case R.id.recyclerviewbutton:
                    //跳转到RecyclerView演示界面
                    intent=new Intent(context, RecyclerViewActivity.class);
                    break;
                case R.id.webviewbutton:
                    //跳转到WebView演示界面
                    intent=new Intent(context, WebViewActivity.class);
                    break;
                case R.id.toastbutton:
                    //跳转到Toast演示界面
                    intent=new Intent(context, ToastActivity.class);
                    break;
                case R.id.dialogbutton:
                    //跳转到Dialog演示界面
                    intent=new Intent(context, DialogActivity.class);
                    break;
                case R.id.progress:
                    //跳转到Progress演示界面
                    intent=new Intent(context, ProgressActivity.class);
                    break;
                case R.id.customdialogbutton:
                    //跳转到CustomDialog演示画面
                    intent=new Intent(context, CustomDialogActivity.class);
                    break;
                case R.id.popupwindowbutton:
                    //跳转到PopupWindow演示画面
                    intent=new Intent(context, PopupWindowActivity.class);
                    break;
                case R.id.lifecycle:
                    //跳转到LifeCycle演示画面
                    intent=new Intent(context, LifeCycleActivity.class);
                    break;
                case R.id.jumpbutton:
                    //跳转到Jump演示界面
                    intent=new Intent(context, AActivity.class);
                    break;
                case R.id.framgmentbutton:
                    //跳转到Fragment演示界面
                    intent=new Intent(context, ContainerActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }


}