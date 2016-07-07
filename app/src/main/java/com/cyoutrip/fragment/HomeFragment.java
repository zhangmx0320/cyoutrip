package com.cyoutrip.fragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.cyoutrip.R;
import com.cyoutrip.base.BaseViewPagerFragment;
import com.cyoutrip.ui.CitySelectActivity;
import com.cyoutrip.ui.MainActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by zhangmx on 2016/7/3.
 */
public class HomeFragment extends BaseViewPagerFragment{
    @Bind(R.id.home_toolbar)
    Toolbar toolbar;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        toolbar.setTitle("");
        if(toolbar!=null){
            ((AppCompatActivity)this.getActivity()).setSupportActionBar(toolbar);
        }
    }

    @Override
    @OnClick(R.id.location_city)
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.location_city:
                this.startActivity(new Intent(getActivity(),CitySelectActivity.class));break;
        }
    }
}
