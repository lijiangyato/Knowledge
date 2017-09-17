package yaoyaoling.iaboursmart.view.impl;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.knowledge.common.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import yaoyaoling.iaboursmart.R;
import yaoyaoling.iaboursmart.adapter.AdapterIaboursmart;
import yaoyaoling.iaboursmart.animation.AnimationIaboursmart;
import yaoyaoling.iaboursmart.view.IaboursmartFragmentView;


/**
 * 作者:LiJiang
 * 邮箱:1755036940@qq.com
 * 作用:
 */
@Route(path = "/iaboursmart/fragment/IaboursmartFragment", name = "人工智能")
public class IaboursmartFragment extends BaseFragment implements IaboursmartFragmentView {

    private View mView;
    private TextView mTextView;
    private ViewPager mTiewPager;
    private TabLayout mTabLayout;
    private List<Fragment> mIistFragment;
    private List<String> mIistString;
    private AdapterIaboursmart mAdapterIaboursmartFragment;
    private LinearLayout mLinearLayout;


    /*初始化获取视图*/
    @Override
    protected int getLayoutId() {
        return R.layout.iaboursmart_fragment;
    }

    /*初始化视图*/
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        this.mView = view;
        initViewId();
    }

    /*初始化数据*/
    @Override
    protected void initData() {
        mTextView.setText("人工智能");
        initFragment();
        initString();
        initViewPager();
    }

    /*初始化ID*/
    public void initViewId() {
        mTextView = (TextView) mView.findViewById(R.id.name_commontaoobal_id);
        mTiewPager = (ViewPager) mView.findViewById(R.id.name_viewpager_id);
        mTabLayout = (TabLayout) mView.findViewById(R.id.name_tablayout_id);
        mLinearLayout= (LinearLayout) mView.findViewById(R.id.name_linearlayout_id);

    }

    /*初始页面数量*/
    public void initFragment() {
        mIistFragment = new ArrayList<>();
        mIistFragment.add((Fragment) ARouter.getInstance().build("/iaboursmart/fragment/IaboursmartCharacerFragment").navigation());
        mIistFragment.add((Fragment) ARouter.getInstance().build("/iaboursmart/fragment/IaboursmartNaturaiLanguageFragment").navigation());
        mIistFragment.add((Fragment) ARouter.getInstance().build("/iaboursmart/fragment/laboursmartVoiceFragment").navigation());
    }

    /*初始化条目数据*/
    public void initString() {
        mIistString = new ArrayList<>();
        mIistString.add(getString(R.string.headline_title1));
        mIistString.add(getString(R.string.headline_title2));
        mIistString.add(getString(R.string.headline_title3));
    }

    /*适配添加处理*/
    public void initViewPager() {
        mAdapterIaboursmartFragment = new AdapterIaboursmart(getChildFragmentManager(), mIistFragment, mIistString);
        mTiewPager.setOffscreenPageLimit(2);
        mTiewPager.setAdapter(mAdapterIaboursmartFragment);
        mTiewPager.setPageTransformer(true, new AnimationIaboursmart());
        mTabLayout.setupWithViewPager(mTiewPager);

    }

}
