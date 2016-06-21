package com.cyoutrip;

import android.app.Application;

import com.umeng.socialize.PlatformConfig;

/**
 * Created by zhangmx on 2016/6/21.
 */
public class AppContext extends Application {
    private static AppContext instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        PlatformConfig.setWeixin("wx17b577520d49c3d7","cec87b9ab856323688c2d8faaa8ccf65");
    }

    /**
     * 获得当前app运行的AppContext
     *
     * @return
     */
    public static AppContext getInstance() {
        return instance;
    }
}
