package yaoyaoling.iaboursmart.view.impl;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.knowledge.common.base.BaseFragment;

import yaoyaoling.iaboursmart.R;
import yaoyaoling.iaboursmart.view.IaboursmartNaturaiLanguageFragmentView;

/**
 * 作者:LiJiang
 * 邮箱:1755036940@qq.com
 * 作用:自然语言
 */
@Route(path = "/iaboursmart/fragment/IaboursmartNaturaiLanguageFragment", name = "自然语言")
public class IaboursmartNaturaiLanguageFragment extends BaseFragment implements IaboursmartNaturaiLanguageFragmentView {
    @Override
    protected int getLayoutId() {
        return R.layout.iaboursmart_faceperception_fragment;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }
}
