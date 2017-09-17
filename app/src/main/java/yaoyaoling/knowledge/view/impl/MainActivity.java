package yaoyaoling.knowledge.view.impl;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.knowledge.common.base.BaseActivity;
import com.knowledge.common.config.ConfigMainLooperManage;

import java.util.ArrayList;
import java.util.List;

import devlight.io.library.ntb.NavigationTabBar;
import yaoyaoling.knowledge.R;
import yaoyaoling.knowledge.adapter.AdapterMain;
import yaoyaoling.knowledge.animation.AnimationMain;
import yaoyaoling.knowledge.view.IMainView;

@Route(path = "/app/Activity/MainActivity", name = "主页面")
public class MainActivity extends BaseActivity implements IMainView {

    //视图寻呼机
    private ViewPager mViewPager;
    //导航标签栏
    private NavigationTabBar mNavigationTabBar;
    //片段寻呼机适配器
    private List<Fragment> mlistfragment;
    private DrawerLayout mDrawerLayou;
    private ActionBarDrawerToggle mActionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        intvid();
        initdrawer();
    }

    /*初始化id*/
    public void intvid() {
        mDrawerLayou = (DrawerLayout) findViewById(R.id.drawer_layout);
        mViewPager = (ViewPager) findViewById(R.id.name_horizontal_id);
        mNavigationTabBar = (NavigationTabBar) findViewById(R.id.ntb);
        initPaging();

    }

    public void initdrawer() {

        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayou, R.string.open_text, R.string.close_text);
        mDrawerLayou.addDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();
    }

    /*初始化视图*/
    @Override
    public void initView() {

    }

    /*初始化数据*/
    @Override
    public void initdata() {
    }

    /*更新方法*/
    @Override
    public void updateAAPP() {

    }

    @Override
    public void loadingError() {

    }

    /*通子线程来加载网络*/
    @Override
    public void initNetData() {
        ConfigMainLooperManage.runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    public void initPaging() {

        mlistfragment = new ArrayList<>();
        mlistfragment.add((Fragment) ARouter.getInstance().build("/iaboursmart/fragment/IaboursmartFragment").navigation());
        mlistfragment.add((Fragment) ARouter.getInstance().build("/hacker/fragment/HackerFragment").navigation());
        mlistfragment.add((Fragment) ARouter.getInstance().build("/harpy/fragment/HarpyFragment").navigation());
        mlistfragment.add((Fragment) ARouter.getInstance().build("/things/fragment/ThingsFragment").navigation());
        mlistfragment.add((Fragment) ARouter.getInstance().build("/unmanned/fragment/UnmannedFragment").navigation());
        mlistfragment.add((Fragment) ARouter.getInstance().build("/itwebgame/fragment/ItwebgameFragment").navigation());

        AdapterMain mAinAdapter = new AdapterMain(MainActivity.this.getSupportFragmentManager(), mlistfragment);
        mViewPager.setOffscreenPageLimit(5);
        mViewPager.setAdapter(mAinAdapter);
        mViewPager.setPageTransformer(true, new AnimationMain());
        final String[] colors = getResources().getStringArray(R.array.lijiang);
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_fifth),
                        Color.parseColor(colors[0]))
                        .title("人工智能")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(getResources()
                        .getDrawable(R.drawable.ic_second),
                        Color.parseColor(colors[1]))
                        .title("黑客")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(getResources()
                        .getDrawable(R.drawable.ic_third),
                        Color.parseColor(colors[2]))
                        .title("无人驾驶")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(getResources()
                        .getDrawable(R.drawable.ic_fourth),
                        Color.parseColor(colors[3]))
                        .title("物联网")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(getResources()
                        .getDrawable(R.drawable.ic_fifth),
                        Color.parseColor(colors[4]))
                        .title("无人机")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(getResources()
                        .getDrawable(R.drawable.ic_menu_camera),
                        Color.parseColor(colors[5]))
                        .title("IT")
                        .build()
        );


        mNavigationTabBar.setModels(models);
        mNavigationTabBar.setViewPager(mViewPager);
        mNavigationTabBar.setBehaviorEnabled(true);


        mNavigationTabBar.setOnTabBarSelectedIndexListener(new NavigationTabBar.OnTabBarSelectedIndexListener() {
            @Override
            public void onStartTabSelected(NavigationTabBar.Model model, int i) {
                model.hideBadge();
            }

            @Override
            public void onEndTabSelected(NavigationTabBar.Model model, int i) {

            }
        });

    }


}