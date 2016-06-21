package com.cyoutrip.ui;

import android.app.Activity;
import android.media.MediaCodec;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.cyoutrip.AppContext;
import com.cyoutrip.R;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class FirstInActivity extends Activity implements View.OnClickListener{
    private final static String TAG="FirstInActivity";
    UMShareAPI umShareAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_in);
        ButterKnife.bind(this);
        umShareAPI=UMShareAPI.get(AppContext.getInstance());
    }

    @Override
    @OnClick(R.id.ib_wx_login)
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_wx_login:
                this.wxLogin();break;
        }
    }

    private void wxLogin(){
        umShareAPI.doOauthVerify(this, SHARE_MEDIA.WEIXIN, new UMAuthListener() {
            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                Toast.makeText( FirstInActivity.this, "Authorize succeed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                Log.e(TAG,"微信登录取消");
                Toast.makeText( FirstInActivity.this, "Authorize fail", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {
                Log.e(TAG,"微信登录取消");
                Toast.makeText(  FirstInActivity.this, "Authorize cancel", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
