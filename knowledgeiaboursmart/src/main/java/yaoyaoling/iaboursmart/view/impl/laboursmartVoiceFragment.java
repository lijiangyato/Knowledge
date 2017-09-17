package yaoyaoling.iaboursmart.view.impl;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.knowledge.common.base.BaseFragment;

import yaoyaoling.iaboursmart.R;
import yaoyaoling.iaboursmart.view.IaboursmartVoiceView;

/**
 * 作者:LiJiang
 * 邮箱:1755036940@qq.com
 * 作用:语音技术
 */
@Route(path = "/iaboursmart/fragment/laboursmartVoiceFragment", name = "语音技术")
public class laboursmartVoiceFragment extends BaseFragment implements IaboursmartVoiceView {
    @Override
    protected int getLayoutId() {
        return R.layout.iaboursmrt_image_audit_fragment;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }
}
