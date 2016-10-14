package test.zt.com.demomaterialdesign;

import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.view.View;

/**
 * Created by Administrator on 2016/10/14.
 */

public class MBehavior extends CoordinatorLayout.Behavior {

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        if(dy>0)
        {
            ViewCompat.animate(child).translationY(-child.getHeight()).start();
        }else{
            ViewCompat.animate(child).translationY(0).start();
        }
    }
}
