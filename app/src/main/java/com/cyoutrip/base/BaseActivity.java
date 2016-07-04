package com.cyoutrip.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

import com.cyoutrip.R;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/6/22.
 */
public class BaseActivity extends AppCompatActivity  implements View.OnClickListener{

    protected ActionBar mActionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mActionBar = getSupportActionBar();
        if (hasActionBar()) {
            initActionBar(mActionBar);
        }
        ButterKnife.bind(this);
        this.initView();
    }

    protected  int getLayoutId(){
        return 0;
    }

    protected boolean hasBackButton(){
        return false;
    }

    protected boolean hasActionBar() {
        return getSupportActionBar() != null;
    }

    protected int getActionBarTitle() {
        return R.string.app_name;
    }

    protected void initActionBar(ActionBar actionBar) {
        if (actionBar == null)
            return;
        if (hasBackButton()) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
            mActionBar.setHomeButtonEnabled(true);
        } else {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE);
            actionBar.setDisplayUseLogoEnabled(false);
        }
        int titleRes = getActionBarTitle();
        if (titleRes != 0) {
            actionBar.setTitle(titleRes);
        }
    }

    protected void initView(){

    }


    @Override
    public void onClick(View v) {

    }
}
