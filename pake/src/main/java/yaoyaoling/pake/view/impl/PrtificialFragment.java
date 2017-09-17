package yaoyaoling.pake.view.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.View;


import com.alibaba.android.arouter.facade.annotation.Route;
import com.knowledge.common.base.BaseFragment;




import yaoyaoling.pake.R;




/**
 * 作者:LiJiang
 * 邮箱:1755036940@qq.com
 * 作用:
 */

@Route(path = "/artificial/fragment/PrtificialFragment", name = "人工智能")
public class PrtificialFragment extends BaseFragment  {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.artificial_fragment;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {


    }



    @Override
    protected void initData() {

    }


}
