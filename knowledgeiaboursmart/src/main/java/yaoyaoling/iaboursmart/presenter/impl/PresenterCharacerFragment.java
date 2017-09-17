package yaoyaoling.iaboursmart.presenter.impl;

import yaoyaoling.iaboursmart.presenter.IPresenterCharacerFragment;
import yaoyaoling.iaboursmart.view.IaboursmartCharacerFragmentView;
import yaoyaoling.iaboursmart.view.impl.IaboursmartCharacerFragment;

/**
 * 作者:LiJiang
 * 邮箱:1755036940@qq.com
 * 作用:控制层
 */

public class PresenterCharacerFragment implements IPresenterCharacerFragment {
    private IaboursmartCharacerFragmentView mIaboursmartCharacerFragment;


    public PresenterCharacerFragment(IaboursmartCharacerFragmentView iaboursmartCharacerFragment){
        this.mIaboursmartCharacerFragment=iaboursmartCharacerFragment;
    }

    @Override
    public void accretion() {
        mIaboursmartCharacerFragment.accretion();
    }
}
