package com.cyoutrip.ui;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.cyoutrip.R;
import com.cyoutrip.base.BaseActivity;
import com.cyoutrip.widget.MyFragmentTabHost;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(android.R.id.tabhost)
    MyFragmentTabHost mTabHost;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        this.initView();
    }


    protected void initView() {
        mTabHost.setup(this,getSupportFragmentManager(),R.id.realtabcontent);
        this.initTabs();
    }

    private void initTabs(){
        MainTab[] tabs=MainTab.values();
        for (int i=0;i<tabs.length;i++){
            MainTab mainTab = tabs[i];
            TabHost.TabSpec tab = mTabHost.newTabSpec(getString(mainTab.getResName()));
            View indicator = View.inflate(this, R.layout.tab_indicator, null);
            TextView title = (TextView) indicator.findViewById(R.id.tab_title);
            ImageView icon = (ImageView) indicator.findViewById(R.id.iv_icon);
//
//            Drawable drawable = this.getResources().getDrawable(this.g);
//            icon.setImageDrawable(drawable);
            tab.setContent(new TabHost.TabContentFactory() {

                @Override
                public View createTabContent(String tag) {
                    return new View(MainActivity.this);
                }
            });
            title.setText(mainTab.getResName());
            icon.setImageResource(mainTab.getResIcon());
            tab.setIndicator(indicator);
            mTabHost.addTab(tab, mainTab.getClz(), null);
            mTabHost.getTabWidget().setDividerDrawable(null);
        }
    }
}
