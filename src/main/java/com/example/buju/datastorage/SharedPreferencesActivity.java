package com.example.buju.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.buju.R;
import com.example.buju.UI.listview.MylistAdapter;
import com.example.buju.util.ToastUtil;

public class SharedPreferencesActivity extends AppCompatActivity {
    private EditText mEtName;
    private Button mBtnSave,mBtnShow;
    private TextView mTvShow;
    private SharedPreferences mSharedPereferences;
    private SharedPreferences.Editor mEditr;
    private Button mBtnSave1;
    private ListView mListView;
    private EditText mEtcount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        mEtName=findViewById(R.id.et_name);
        mBtnSave=findViewById(R.id.btn_sava);
        mBtnShow=findViewById(R.id.btn_show);
        mTvShow=findViewById(R.id.tv_show );
        mBtnSave1=findViewById(R.id.save2);
        mListView=findViewById(R.id.listview);
        mEtcount=findViewById(R.id.etsave2);

        mSharedPereferences = getSharedPreferences("Data",MODE_PRIVATE);
        mEditr = mSharedPereferences.edit();

        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditr.putString("name",mEtName.getText().toString());
                mEditr.apply();
                ToastUtil.showMsg(SharedPreferencesActivity.this,"已保存");
            }
        });
        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTvShow.setText(mSharedPereferences.getString("name",""));
            }
        });
        mListView.setAdapter(new MylistAdapter23(SharedPreferencesActivity.this));

    }



}
class MylistAdapter23 extends BaseAdapter{
    private Context mContext;
    private LayoutInflater mLayoutInflateer;
    MylistAdapter23(Context context){
        this.mContext=context;
        mLayoutInflateer=LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    static class ViewHolder{
        public ImageView imageView;
        public TextView tvTitle,tvTime,tvContent;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MylistAdapter.ViewHolder holder=null;
        if(convertView==null){

            convertView=mLayoutInflateer.inflate(R.layout.layout_list_item,null);
            holder=new MylistAdapter.ViewHolder();
            holder.imageView=convertView.findViewById(R.id.iv);
            holder.tvTitle=convertView.findViewById(R.id.tv_title);
            holder.tvTime=convertView.findViewById(R.id.tv_time);
            holder.tvContent=convertView.findViewById(R.id.tv_content);
            convertView.setTag(holder);
        }else {
            holder=(MylistAdapter.ViewHolder)convertView.getTag();
        }
        //给控件赋值
        holder.tvTitle.setText("这是标题");
        holder.tvTime.setText("2888-08-08");
        holder.tvContent.setText("这是内容");
        Glide.with(mContext).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1564219340371&di=cbe55a5ea20b3625ea2b36b0c0d47936&imgtype=0&src=http%3A%2F%2Fimg1.gtimg.com%2F11%2F1155%2F115549%2F11554911_1200x1000_0.jpg").into(holder.imageView);
        return convertView;

    }
}
