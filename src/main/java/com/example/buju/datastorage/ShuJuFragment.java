package com.example.buju.datastorage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.buju.R;
import com.example.buju.UI.UIFragment;

public class ShuJuFragment extends Fragment {
    private Button mBtnSharedPerecens;
    private Button mFile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_data_storage, container,false);
        mBtnSharedPerecens=view.findViewById(R.id.btn_sharedpreferences);
        mFile=view.findViewById(R.id.btn_file);
        setListeners();
        return view;
    }
    private void setListeners() {
       OnCilck onCilck = new OnCilck();
        mFile.setOnClickListener(onCilck);
        mBtnSharedPerecens.setOnClickListener(onCilck);
    }

    private class OnCilck implements View.OnClickListener {
        public void onClick(View view) {
            Context context = getActivity();
            Intent intent = null;
            switch (view.getId()) {
                case R.id.btn_sharedpreferences:
                    intent = new Intent(context, SharedPreferencesActivity.class);
                    break;
                case R.id.btn_file:
                    intent = new Intent(context, FileActivity.class);
                    break;
            }
            startActivity(intent);
        }

    }
}