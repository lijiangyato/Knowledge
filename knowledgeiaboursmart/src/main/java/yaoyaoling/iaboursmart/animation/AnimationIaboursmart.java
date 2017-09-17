package yaoyaoling.iaboursmart.animation;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

import yaoyaoling.iaboursmart.R;


/**
 * 作者:LiJiang
 * 邮箱:1755036940@qq.com
 * 作用:动画
 */

public class AnimationIaboursmart implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {
        int pageWidth = page.getWidth();
        View view_one0 = page.findViewById(R.id.Layout_laoli);
        View view_one1 = page.findViewById(R.id.Layout_laoli1);
        View view_one2 = page.findViewById(R.id.Layout_laoli2);


        if (2 <= position && position < 3) {
            ViewHelper.setTranslationX(page, pageWidth * (-position));
        }
        if (1 <= position && position < 2) {
            ViewHelper.setTranslationX(page, pageWidth * (-position));
            Log.e("ingo", "000" + position);
        }
        if (0 <= position && position < 1) {
            //[-1 , 0][1 , 0]右侧page处理,抵消page本身的滑动动画
            ViewHelper.setTranslationX(page, pageWidth * (-position));
            Log.e("ingo", "0001" + position);
        }
        if (-1 <= position && position < 0) {
            ViewHelper.setTranslationX(page, pageWidth * (-position));
        }
        if (-2 < position && position < -1) {
            Log.e("ingo", "0002" + position);
            //[-1 , 0]左侧page处理,抵消page本身的滑动动画
            ViewHelper.setTranslationX(page, pageWidth * -position);
        }
        if (-3.5 < position && position < -2) {
            ViewHelper.setTranslationX(page, pageWidth * -position);
            Log.e("ingo", "0003" + position);
        }
        if (position <= -2.0f || position >= 1.0f) {
            Log.e("ingo", "0004");
            ViewHelper.setTranslationX(page, pageWidth * -position);
            //(-& ~ -1),(1 ~ +&)不可见部分不作处理
        } else if (position == 0) {
            ViewHelper.setTranslationX(page, pageWidth * -position);


        } else {
            if (view_one0 != null) {
                Log.e("ingo", "0005");
                ViewHelper.setAlpha(view_one0, 1.0f - Math.abs(position));
            }
            if (view_one1 != null) {
                ViewHelper.setAlpha(view_one1, 1.0f - Math.abs(position));
            }
            if (view_one2 != null) {
                ViewHelper.setAlpha(view_one2, 1.0f - Math.abs(position));
            }
            /*if (view_one3 != null) {
                ViewHelper.setAlpha(view_one3, 1.0f - Math.abs(position));
            }
            if (view_one4 != null) {
                ViewHelper.setAlpha(view_one4, 1.0f - Math.abs(position));
            }*/

        }
    }
}
