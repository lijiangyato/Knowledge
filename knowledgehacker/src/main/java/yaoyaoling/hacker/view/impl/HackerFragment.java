package yaoyaoling.hacker.view.impl;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.knowledge.common.base.BaseFragment;

import yaoyaoling.hacker.R;
import yaoyaoling.hacker.view.IHackerFragmentView;

/**
 * 作者:LiJiang
 * 邮箱:1755036940@qq.com
 * 作用:
 */
@Route(path = "/hacker/fragment/HackerFragment", name = "黑客")
public class HackerFragment extends BaseFragment implements IHackerFragmentView {

  private TextView mTxtView;
    private Button button;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hacker;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
     mTxtView= (TextView) view.findViewById(R.id.name_commontaoobal_id);
        mTxtView.setText("黑客");

    }

    @Override
    protected void initData() {

    }
}