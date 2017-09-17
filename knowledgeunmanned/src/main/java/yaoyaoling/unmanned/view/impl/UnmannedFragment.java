package yaoyaoling.unmanned.view.impl;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.knowledge.common.base.BaseFragment;

import yaoyaoling.unmanned.R;
import yaoyaoling.unmanned.view.IUnmannedFragmentView;

/**
 * 作者:LiJiang
 * 邮箱:1755036940@qq.com
 * 作用:
 */
@Route(path = "/unmanned/fragment/UnmannedFragment", name = "无人机")
public class UnmannedFragment  extends BaseFragment implements IUnmannedFragmentView{
 private TextView mTextView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_unmanned;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mTextView= (TextView) view.findViewById(R.id.name_commontaoobal_id);
        mTextView.setText("无人机");
    }

    @Override
    protected void initData() {

    }
}
