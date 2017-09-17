package com.knowledge.common.base;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * 作者:LiJiang
 * 邮箱:1755036940@qq.com
 * 作用:
 */


public class BaseApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        initARouter();
    }
    private void initARouter(){
        //打印日志
        ARouter.openLog();
        //开启调试模式
        ARouter.openDebug();
        ARouter.init(this);
    }
}

