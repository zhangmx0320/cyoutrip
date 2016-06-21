package com.cyoutrip.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.cyoutrip.AppContext;
import com.cyoutrip.R;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

/**
 * Created by zhangmx on 2016/6/20.
 */
public class WXEntryActivity extends Activity{
    private final static String TAG="WXEntryActivity";
    UMShareAPI umShareAPI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weixin_entry);
        handleIntent(getIntent());
    }

    private void handleIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        SendAuth.Resp resp = new SendAuth.Resp(intent.getExtras());
        if (resp.errCode == BaseResp.ErrCode.ERR_OK) {

            //用户同意
            String code = resp.code;
            String state = resp.state;
            // 如果不是登录
            umShareAPI=UMShareAPI.get(AppContext.getInstance());
            umShareAPI.getPlatformInfo(this, SHARE_MEDIA.WEIXIN, new UMAuthListener() {
                @Override
                public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                    Log.e(TAG,"info:"+map);
                }

                @Override
                public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

                }

                @Override
                public void onCancel(SHARE_MEDIA share_media, int i) {

                }
            });

            if (!"wechat_login".equals(state)) {
                finish();
            }
            //上面的code就是接入指南里要拿到的code
//            getAccessTokenAndOpenId(code);
        }else if(resp.errCode == BaseResp.ErrCode.ERR_USER_CANCEL){
            Log.e(TAG,"微信登录取消");
            Toast.makeText(  WXEntryActivity.this, "Authorize cancel", Toast.LENGTH_SHORT).show();
        } else {
            finish();
        }
    }
}
