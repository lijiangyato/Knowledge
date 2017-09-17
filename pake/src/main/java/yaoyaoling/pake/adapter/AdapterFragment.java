package yaoyaoling.pake.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * 作者:LiJiang
 * 邮箱:1755036940@qq.com
 * 作用:适配器
 */
public class AdapterFragment extends FragmentStatePagerAdapter {
    private List<Fragment> mFragments;
    private List<String> mlistString;

    public AdapterFragment(FragmentManager fm, List<Fragment> fragments, List<String> strings) {
        super(fm);
        this.mFragments = fragments;
        this.mlistString=strings;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (mlistString!=null){
            return mlistString.get(position);
        }
        return null;
    }
}
