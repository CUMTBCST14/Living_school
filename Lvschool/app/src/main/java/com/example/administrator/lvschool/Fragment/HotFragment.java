package com.example.administrator.lvschool.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.lvschool.R;

/**
 * Created by Administrator on 2017/2/15.
 */

public class HotFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflaterAndSetupView(inflater,container,savedInstanceState, R.layout.hot_fragment);
    }
    private View inflaterAndSetupView(LayoutInflater inflater,ViewGroup container,Bundle savedIstanceState,int layoutResourceID){
        View layout = inflater.inflate(layoutResourceID,container,false);
        return  layout;
    }

}
