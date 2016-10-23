package me.mrrobot97.swipeback;

import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

/**
 * Created by mrrobot on 16/10/15.
 */

public class SwipeBackActivity extends AppCompatActivity {
    private TouchHelepr mTouchHelepr;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if(mTouchHelepr==null)
            mTouchHelepr=new TouchHelepr(getWindow());
        boolean consume=mTouchHelepr.processTouchEvent(ev);
        if(!consume) return super.dispatchTouchEvent(ev);
        return false;
        //return super.dispatchTouchEvent(ev)||mTouchHelepr.processTouchEvent(ev);
    }
}
