package com.knowledge.common.database.configure;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * 作者:LiJiang
 * 邮箱:1755036940@qq.com
 * 作用:初始话
 */

public class ConfigureApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);
    }
}
