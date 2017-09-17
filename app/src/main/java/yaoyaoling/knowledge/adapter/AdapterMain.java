package yaoyaoling.knowledge.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * 作者:LiJiang
 * 邮箱:1755036940@qq.com
 * 作用:适配器
 */
public class AdapterMain extends FragmentStatePagerAdapter {
    private List<Fragment> mFragments;


    public AdapterMain(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }


}
