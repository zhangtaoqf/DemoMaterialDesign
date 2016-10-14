package test.zt.com.demomaterialdesign;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/10/14.
 *
 * FloatingActionButton的上下滑效果
 *
 */

public class MFABBehavior extends CoordinatorLayout.Behavior {

    public MFABBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MFABBehavior() {
    }
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }
    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        if(dy<0)//上滑
        {
            ViewCompat.animate(child).translationY(0).start();
        }else{ //下滑
            ViewCompat.animate(child).translationY(child.getHeight() + 50).start();
        }
    }
}
