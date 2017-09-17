package com.knowledge.common.config;


import android.os.Handler;
import android.os.Looper;

/**
 * 作者:LiJiang
 * 邮箱:1755036940@qq.com
 * 作用:
 */

public class ConfigMainLooperManage extends Handler{
    private static ConfigMainLooperManage mainLooperManage =new ConfigMainLooperManage(Looper.getMainLooper());

    public ConfigMainLooperManage(Looper mainLooper) {
        super(mainLooper);
    }
    public static ConfigMainLooperManage getInstance(){
        return  mainLooperManage;
    }


    public static void runOnUiThread(Runnable runnable){
        if (Looper.getMainLooper().equals(Looper.myLooper())){
            runnable.run();
        }else {
            mainLooperManage.post(runnable);
        }
    }
}
