package yaoyaoling.knowledge.view.impl;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.knowledge.common.base.BaseActivity;

import yaoyaoling.knowledge.view.IMainSchemeFilterView;

/**
 * 作者:LiJiang
 * 邮箱:1755036940@qq.com
 * 作用:
 */

public class MainSchemeFilterActivity extends BaseActivity implements IMainSchemeFilterView{
    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Uri uri = getIntent().getData();
        ARouter.getInstance().build(uri).navigation(this, new NavigationCallback() {
            @Override
            public void onFound(Postcard postcard) {
                finish();
            }

            @Override
            public void onLost(Postcard postcard) {
                finish();
            }

            @Override
            public void onArrival(Postcard postcard) {

            }

            @Override
            public void onInterrupt(Postcard postcard) {
                finish();
            }
        });
    }
    @Override
    public void initView() {

    }

    @Override
    public void initdata() {

    }
}
