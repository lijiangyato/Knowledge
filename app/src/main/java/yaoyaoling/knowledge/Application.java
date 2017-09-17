package yaoyaoling.knowledge;

import com.knowledge.common.base.BaseApplication;

/**
 * 作者:LiJiang
 * 邮箱:1755036940@qq.com
 * 作用:应用程序
 */

public class Application extends BaseApplication {
    public static Application mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }
}
