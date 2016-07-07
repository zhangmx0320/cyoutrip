package com.cyoutrip.fragment;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.cyoutrip.R;
import com.cyoutrip.base.BaseViewPagerFragment;
import com.cyoutrip.ui.MainTab;

import butterknife.Bind;

/**
 * Created by zhangmx on 2016/7/3.
 */
public class GoTripFragment extends BaseViewPagerFragment{
    @Bind(R.id.tool_bar)
    Toolbar toolbar;

    @Bind(R.id.title)
    TextView title;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_go_trip;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        title.setText(MainTab.TOUR.getResName());
//        if(toolbar!=null){
//            ((AppCompatActivity)this.getActivity()).setSupportActionBar(toolbar);
//        }
    }
}
