package com.knowledge.common.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.launcher.ARouter;
//import com.idescout.sql.SqlScoutServer;

import com.jaeger.library.StatusBarUtil;

import butterknife.ButterKnife;
import cn.bingoogolapple.swipebacklayout.BGASwipeBackHelper;
import yaoyaoling.common.R;

/**
 * 作者:LiJiang
 * 邮箱:1755036940@qq.com
 * 作用:基类
 */

public abstract class BaseActivity extends AppCompatActivity implements BGASwipeBackHelper.Delegate {
    protected BGASwipeBackHelper mSwipeBackHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        initSwipeBackFinish();
        super.onCreate(savedInstanceState);
        //数据库sqliteExplorer
        //SqlScoutServer.create(this, getPackageName());
        initroute();
        initView();
        initStantusBar();
        initdata();
    }

    /*路由机制初始化*/
    public void initroute() {
       /* ARouter.openDebug();
        ARouter.getInstance().inject(this);*/
        ARouter.openDebug();
        //ARouter.init(getApplication());
        ARouter.getInstance().inject(this);//初始化ARouter
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        ButterKnife.bind(this);
    }

    /*视图初始化*/
    public abstract void initView();

    /*数据初始化*/
    public abstract void initdata();

    /*状态栏初始化*/
    protected void initStantusBar() {
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.app_base_bar_background), StatusBarUtil.DEFAULT_STATUS_BAR_ALPHA);
    }
    /*实现滑动关闭当前Activity*/
    public void initSwipeBackFinish(){
        mSwipeBackHelper = new BGASwipeBackHelper(this,this);
        //设置返回是否可用，默认值为true
        mSwipeBackHelper.setSwipeBackEnable(true);
        //设置是否仅仅跟踪左测边缘的滑动返回，默认值为true
        mSwipeBackHelper.setIsOnlyTrackingLeftEdge(true);
        //设置是否微信滑动返回样式，默认值为true
        mSwipeBackHelper.setIsWeChatStyle(true);
        //设置阴影资源ID.默认值
        mSwipeBackHelper.setShadowResId(R.drawable.bga_sbl_shadow);
        //设置是否显示滑动返回的阴影效果
        mSwipeBackHelper.setIsNeedShowShadow(true);
        //设置阴影区域的透明是否根据滑动的距离渐变默认值为true
        mSwipeBackHelper.setIsShadowAlphaGradient(true);
        //设置触发释放后自动滑动返回值，默认值为0.3f
        mSwipeBackHelper.setSwipeBackThreshold(0.3f);
    }

    /*
     是否支持滑动返回。这里在父类中默认返回 true 来支持滑动返回，
     如果某个界面不想支持滑动返回则重写该方法返回 false 即可
     @return*/
    @Override
    public boolean isSupportSwipeBack() {
        return true;
    }

     /*正在滑动返回
     @param slideOffset 从 0 到 1*/

    @Override
    public void onSwipeBackLayoutSlide(float slideOffset) {

    }

    /* 没达到滑动返回的阈值，取消滑动返回动作，回到默认状态*/

    @Override
    public void onSwipeBackLayoutCancel() {

    }

     /* 滑动返回执行完毕，销毁当前 Activity*/
    @Override
    public void onSwipeBackLayoutExecuted() {
        mSwipeBackHelper.swipeBackward();
    }

    @Override
    public void onBackPressed() {
        // 正在滑动返回的时候取消返回按钮事件
        if (mSwipeBackHelper.isSliding()){
            return;
        }
        mSwipeBackHelper.backward();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
