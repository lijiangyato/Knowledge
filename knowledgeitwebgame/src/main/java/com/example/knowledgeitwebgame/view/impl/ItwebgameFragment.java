package com.example.knowledgeitwebgame.view.impl;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.knowledgeitwebgame.R;
import com.example.knowledgeitwebgame.view.IItwebgameFragment;
import com.knowledge.common.base.BaseFragment;

/**
 * Created by admin on 2017/9/17.
 */
@Route(path = "/itwebgame/fragment/ItwebgameFragment", name = "IT")

public class ItwebgameFragment extends BaseFragment implements IItwebgameFragment {
    private TextView mTextView;
    @Override
    protected int getLayoutId() {
        return R.layout.itwebgame_fragment;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mTextView= (TextView) view.findViewById(R.id.name_commontaoobal_id);
        mTextView.setText("IT");
    }

    @Override
    protected void initData() {

    }
}
