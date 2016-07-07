package com.cyoutrip.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zhangmx on 2016/7/3.
 */
public class BaseViewPagerFragment extends BaseFragment{
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return super.getLayoutId();
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
    }
}
