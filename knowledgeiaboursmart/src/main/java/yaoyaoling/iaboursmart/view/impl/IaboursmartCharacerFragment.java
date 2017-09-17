package yaoyaoling.iaboursmart.view.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;

import com.knowledge.common.base.BaseFragment;

import com.knowledge.common.config.ConfigLinearLayoutManager;
import com.knowledge.common.config.ConfigMainLooperManage;
import com.knowledge.common.database.surface.SurfaceUserData;

import com.knowledge.common.utli.UtliDecoration;
import com.knowledge.common.view.SectionedSpanSizeLookup;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

import com.raizlabs.android.dbflow.structure.ModelAdapter;


import java.util.ArrayList;
import java.util.List;

import yaoyaoling.iaboursmart.R;
import yaoyaoling.iaboursmart.adapter.AdapterCharacer;
import yaoyaoling.iaboursmart.entity.EntityCharacer;
import yaoyaoling.iaboursmart.presenter.IPresenterCharacerFragment;
import yaoyaoling.iaboursmart.presenter.impl.PresenterCharacerFragment;
import yaoyaoling.iaboursmart.view.IaboursmartCharacerFragmentView;

/**
 * 作者:LiJiang
 * 邮箱:1755036940@qq.com
 * 作用:图像技术
 */

@Route(path = "/iaboursmart/fragment/IaboursmartCharacerFragment", name = "图像技术")
public class IaboursmartCharacerFragment extends BaseFragment implements IaboursmartCharacerFragmentView {
    private IPresenterCharacerFragment mIPresenterCharacerFragment;
    private View mView;
    private RecyclerView mRecyclerView;
    private SurfaceUserData mSurfaceUserData;
    private AdapterCharacer mAdapterCharacer;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FlowManager.init(new FlowConfig.Builder(getContext()).build());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.iaboursmart_characer_fragment;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        this.mView = view;
        initViewId();
        initRecyclerView();
    }

    @Override
    protected void initData() {
        /*初始化控制成*/
        mIPresenterCharacerFragment = new PresenterCharacerFragment(IaboursmartCharacerFragment.this);
        mIPresenterCharacerFragment.accretion();

    }

    public void initViewId() {
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.name_characer_id);


    }

    /*初始话布局*/
    public void initRecyclerView() {



        //使用线性布局管理器
        GridLayoutManager manager=new GridLayoutManager(getActivity(),1);
        //ConfigLinearLayoutManager manager = new ConfigLinearLayoutManager(this.getContext());

        //滑动监听
        mRecyclerView.setLayoutManager(manager);
        mAdapterCharacer = new AdapterCharacer(this.getContext(), null);
        mRecyclerView.setAdapter(mAdapterCharacer);
        mRecyclerView.addItemDecoration(new UtliDecoration(this.getContext(), UtliDecoration.VERTICAL_LIST, UtliDecoration.DividerType.TYPE_F2F2F2));

    }

    /*动态添加数据*/
    @Override
    public void accretion() {
        ConfigMainLooperManage.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                List<EntityCharacer> mList = new ArrayList<>();
                EntityCharacer mEntityCharacer = new EntityCharacer();
                mEntityCharacer.setInemtType(EntityCharacer.TYPE_ONE);
                mList.add(mEntityCharacer);
                mList.add(mEntityCharacer);
                mList.add(mEntityCharacer);
                mList.add(mEntityCharacer);
                mList.add(mEntityCharacer);
                mList.add(mEntityCharacer);
                mList.add(mEntityCharacer);
                mList.add(mEntityCharacer);
                mList.add(mEntityCharacer);


                mAdapterCharacer.setNewData(mList);
            }
        });
    }
}

