package yaoyaoling.iaboursmart.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * 作者:LiJiang
 * 邮箱:1755036940@qq.com
 * 作用:
 */

public class AdapterIaboursmart extends FragmentStatePagerAdapter {
    private List<Fragment> mIistFragment;
    private List<String> mIistString;
    public AdapterIaboursmart(FragmentManager fm, List<Fragment> listfragment, List<String> liststring) {
        super(fm);
        this.mIistFragment=listfragment;
        this.mIistString=liststring;
    }

    @Override
    public Fragment getItem(int position) {
        return mIistFragment.get(position);
    }

    @Override
    public int getCount() {
        return mIistFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (mIistString!=null){
           return mIistString.get(position);

        }
        return null;

    }
}
