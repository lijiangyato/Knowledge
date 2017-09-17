package yaoyaoling.knowledge.view.impl;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.knowledge.common.base.BaseActivity;
import com.knowledge.common.tools.log.LogErayicLog;
import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnChangeListener;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnRightOutListener;

import java.util.ArrayList;

import yaoyaoling.knowledge.R;
import yaoyaoling.knowledge.view.IMainGuidanceView;


/**
 * 作者:LiJiang
 * 邮箱:1755036940@qq.com
 * 作用:
 */
@Route(path = "/index/activity/MainGuidanceActivity", name = "引导")
public class MainGuidanceActivity extends BaseActivity implements IMainGuidanceView {
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_guidance_activity);


        fragmentManager = getSupportFragmentManager();

        final PaperOnboardingFragment onBoardingFragment = PaperOnboardingFragment.newInstance(getDataForOnboarding());

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, onBoardingFragment);
        fragmentTransaction.commit();

        onBoardingFragment.setOnRightOutListener(new PaperOnboardingOnRightOutListener() {
            @Override
            public void onRightOut() {
                ARouter.getInstance().build("/app/Activity/MainActivity").navigation();
            }
        });
        onBoardingFragment.setOnChangeListener(new PaperOnboardingOnChangeListener() {
            @Override
            public void onPageChanged(int oldElementIndex, int newElementIndex) {
                LogErayicLog.d("info","000x1"+oldElementIndex+newElementIndex);
            }
        });
    }

    @Override
    public void initView() {

    }

    @Override
    public void initdata() {

    }

    private ArrayList<PaperOnboardingPage> getDataForOnboarding() {

        PaperOnboardingPage scr1 = new PaperOnboardingPage("人工智能", "1111111",
                Color.parseColor("#24b768"), R.drawable.ascendent,R.drawable.wallet);
        PaperOnboardingPage scr2 = new PaperOnboardingPage("黑客", "2222222",
                Color.parseColor("#65B0B4"), R.drawable.ascendent, R.drawable.wallet);
        PaperOnboardingPage scr3 = new PaperOnboardingPage("无人驾驶", "333333333",
                Color.parseColor("#9B90BC"), R.drawable.ascendent, R.drawable.shopping_cart);
        PaperOnboardingPage scr4 = new PaperOnboardingPage("物联网", "777777777777",
                Color.parseColor("#9B90BC"), R.drawable.ascendent, R.drawable.shopping_cart);

        ArrayList<PaperOnboardingPage> elements = new ArrayList<>();
        elements.add(scr1);
        elements.add(scr2);
        elements.add(scr3);
        elements.add(scr4);
        return elements;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
