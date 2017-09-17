package com.example.knowledgeharpy.view.impl;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.knowledgeharpy.R;
import com.example.knowledgeharpy.view.IHarpyFragment;
import com.knowledge.common.base.BaseFragment;

/**
 * Created by admin on 2017/9/17.
 */
@Route(path = "/harpy/fragment/HarpyFragment", name = "无人驾驶")
public class HarpyFragment extends BaseFragment implements IHarpyFragment{
    private TextView mTextView;
    @Override
    protected int getLayoutId() {
        return R.layout.harpy_fragment;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mTextView= (TextView) view.findViewById(R.id.name_commontaoobal_id);
        mTextView.setText("无人驾驶");
    }

    @Override
    protected void initData() {

    }
}
