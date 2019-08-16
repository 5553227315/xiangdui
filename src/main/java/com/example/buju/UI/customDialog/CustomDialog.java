package com.example.buju.UI.customDialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.buju.R;


public class CustomDialog extends Dialog implements View.OnClickListener {
    private TextView mTvTittle,mTvMessage,mTvCancel,mTvConfirm;

    private String title,message,cancel,confirm;

    private IOnCancelListener cancelListener;
    private IOnConfirmListener confirmListener;


    public CustomDialog (Context context) {
        super(context);
    }
    public CustomDialog (Context context,int themeResId) {
        super(context,themeResId);

    }
    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    public CustomDialog setCancel(String cancel,IOnCancelListener cancellistener) {
        this.cancel = cancel;
        this.cancelListener=cancellistener;
        return this;
    }

    public CustomDialog setConfirm(String confirm,IOnConfirmListener confirmlistener) {
        this.confirm = confirm;
        this.confirmListener=confirmlistener;
        return this;
    }

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.layout_custom_dialog);

        //设置宽度
        WindowManager manager=getWindow().getWindowManager();
        Display display=manager.getDefaultDisplay();
        WindowManager.LayoutParams params =getWindow().getAttributes();
        Point size=new Point();
        display.getSize(size);
        params.width=(int)(size.x*0.8);//设置dialog的宽度为当前手机屏幕的0.8
        getWindow().setAttributes(params);

        mTvTittle=findViewById(R.id.tv_title);
        mTvMessage=findViewById(R.id.tv_message);
        mTvCancel=findViewById(R.id.tv_cancel);
        mTvConfirm=findViewById(R.id.tv_confirm);
        if (!TextUtils.isEmpty(title)) {
            mTvTittle.setText(title);
        }
        if (!TextUtils.isEmpty(message)){
            mTvMessage.setText(message);
        }
        if (!TextUtils.isEmpty(cancel)){
            mTvCancel.setText(cancel);
        }
        if (!TextUtils.isEmpty(confirm)){
            mTvConfirm.setText(confirm);
        }
        mTvCancel.setOnClickListener(this);
        mTvConfirm.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_cancel:
                if (cancelListener!=null){
                    cancelListener.onCancel(this);
                    dismiss();
                }
                break;
            case R.id.tv_confirm:
                if (confirmListener!=null){
                    confirmListener.onConfirm(this);
                    dismiss();

                }
                break;



        }
    }


    public interface IOnCancelListener{
       public void onCancel (CustomDialog dialog);

    }
    public interface IOnConfirmListener{
        public void onConfirm (CustomDialog dialog);

    }
}
