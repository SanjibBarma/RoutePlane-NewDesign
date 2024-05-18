package com.example.ecrm3routeplan.helper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.recyclerview.widget.RecyclerView;

public class NonScrollableRecyclerView extends RecyclerView {

    public NonScrollableRecyclerView(Context context) {
        super(context);
    }

    public NonScrollableRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NonScrollableRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        // Prevent RecyclerView from intercepting touch events
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        // Prevent RecyclerView from handling touch events
        return false;
    }

    @Override
    public void onScrollStateChanged(int state) {
        // Prevent RecyclerView from changing scroll state
        if (state == SCROLL_STATE_DRAGGING) {
            stopScroll();
        }
        super.onScrollStateChanged(state);
    }
}
