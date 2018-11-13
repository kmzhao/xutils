package com.anky.xutils.swipelayout;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class XViewPager extends ViewPager {

    private int mLastX, mLastY;


    public XViewPager(Context context) {
        super(context);
    }

    public XViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        boolean intercept = false;
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                if (isHorizontalScroll(x, y)) {
                    if (isReactFirstPage() && isScrollRight(x)) {
                        intercept = false;
                    } else if (isReachLastPage() && isScrollLeft(x)) {
                        intercept = false;
                    } else {
                        intercept = true;
                    }

                } else {

                }
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }

        mLastX = x;
        mLastY = y;

        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(ev);
        return intercept || onInterceptTouchEvent;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }

    private boolean isHorizontalScroll(int x, int y) {
        return Math.abs(y - mLastY) < Math.abs(x - mLastX);
    }

    private boolean isReachLastPage() {
        PagerAdapter adapter = getAdapter();
        if (null != adapter && adapter.getCount() - 1 == getCurrentItem()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isReactFirstPage() {
        if (getCurrentItem() == 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isScrollLeft(int x) {
        return x - mLastX < 0;
    }

    private boolean isScrollRight(int x) {
        return x - mLastX > 0;
    }
}
