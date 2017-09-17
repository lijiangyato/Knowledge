package yaoyaoling.things.view.impl;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.knowledge.common.base.BaseFragment;

import yaoyaoling.things.R;
import yaoyaoling.things.view.IThingsFragmentView;

/**
 * 作者:LiJiang
 * 邮箱:1755036940@qq.com
 * 作用:
 */
@Route(path = "/things/fragment/ThingsFragment", name = "物联网")
public class ThingsFragment extends BaseFragment implements IThingsFragmentView {

    private TextView mTextView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_things;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mTextView = (TextView) view.findViewById(R.id.name_commontaoobal_id);
        mTextView.setText("物联网");
    }

    @Override
    protected void initData() {

    }
}
