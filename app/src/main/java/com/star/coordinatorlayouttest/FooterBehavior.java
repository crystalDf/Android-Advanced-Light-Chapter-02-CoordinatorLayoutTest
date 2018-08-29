package com.star.coordinatorlayouttest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;

public class FooterBehavior extends CoordinatorLayout.Behavior<View> {

    private int directionChange;

    public FooterBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return (axes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);

        if (dy * directionChange < 0) {
            child.animate().cancel();
            directionChange = 0;
        }

        directionChange += dy;

        if ((directionChange > child.getHeight()) && (child.getVisibility() == View.VISIBLE)) {

            hide(child);
        } else if ((directionChange < 0) && (child.getVisibility() == View.GONE)) {

            show(child);
        }
    }

    private void hide(View child) {

        ViewPropertyAnimator animator = child
                        .animate()
                        .translationY(child.getHeight())
                        .setInterpolator(new FastOutSlowInInterpolator())
                        .setDuration(200);
    }

    private void show(View child) {
    }
}
