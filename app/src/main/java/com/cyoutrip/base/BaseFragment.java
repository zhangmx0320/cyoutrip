package com.cyoutrip.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by zhangmx on 2016/7/3.
 */
public class BaseFragment extends Fragment implements View.OnClickListener{
    protected View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutId(), null);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        initView(rootView);
    }

    protected int getLayoutId(){
        return 0;
    }

    /**
     * 初始化视图控件
     */
    protected void initView(View view){

    }

    @Override
    public void onClick(View v) {

    }
}
