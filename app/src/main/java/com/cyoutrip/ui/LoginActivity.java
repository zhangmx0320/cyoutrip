package com.cyoutrip.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.cyoutrip.R;
import com.cyoutrip.base.BaseActivity;

import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected boolean hasBackButton() {
        return true;
    }

    @Override
    protected int getActionBarTitle() {
        return R.string.phone_login;
    }

    @Override
    @OnClick({R.id.reg_text,R.id.login_btn})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.reg_text:
                break;
            case R.id.login_btn:
                this.startActivity(new Intent(this,MainActivity.class));break;
        }
    }
}
