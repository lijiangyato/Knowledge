package com.knowledge.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * 作者:LiJiang
 * 邮箱:1755036940@qq.com
 * 作用:
 */

public abstract class BaseFragment  extends Fragment{
    private View view;
    protected abstract int getLayoutId();
    protected abstract void initView(View view,Bundle savedInstanceState);
    protected abstract void  initData();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.openDebug();
        ARouter.getInstance().inject(this);//初始化ARouter

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view==null){
            view=inflater.inflate(getLayoutId(),container,false);
             initView(view,savedInstanceState);
            initData();
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent!=null){
            parent.removeView(view);
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


}
