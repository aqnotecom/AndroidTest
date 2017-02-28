package com.aqnote.app.test.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.LoaderManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.aqnote.app.test.R;

import static com.aqnote.app.test.log.LifecycleLog.*;
import static com.aqnote.app.test.log.LifecycleLog.LifecycleState.CALL_TO_SUPER;
import static com.aqnote.app.test.log.LifecycleLog.LifecycleState.RETURN_FROM_SUPER;

/**
 * Created by madding on 2/23/17.
 */

@TargetApi(Build.VERSION_CODES.N)
public class LifecycleActivity extends Activity {

    private static final int CONTENT_VIEW_ID = 0x02000000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        recLifeCycle(getClass(), CALL_TO_SUPER);
        super.onCreate(savedInstanceState);
        recLifeCycle(getClass(), RETURN_FROM_SUPER);

        // add layout
        RelativeLayout layout = new RelativeLayout(LifecycleActivity.this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(16, 16, 16, 16);
        layout.setLayoutParams(layoutParams);
        this.setContentView(layout);


        FrameLayout frameLayout= new FrameLayout(this);
        frameLayout.setId(CONTENT_VIEW_ID);
        LinearLayout.LayoutParams frameLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layout.addView(frameLayout, frameLayoutParams);

        LifecycleFragment testFragment = new LifecycleFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(frameLayout.getId(), testFragment).commit();

        FragmentManager.enableDebugLogging(true);
        LoaderManager.enableDebugLogging(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        recLifeCycle(getClass(), CALL_TO_SUPER);
        MenuItem menuItem = menu.add(Menu.NONE, Menu.NONE, 100, R.string.menu_settings);
        menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
        recLifeCycle(getClass(), RETURN_FROM_SUPER);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        recLifeCycle(getClass(), CALL_TO_SUPER);
        super.onActivityResult(requestCode, resultCode, data);
        recLifeCycle(getClass(), RETURN_FROM_SUPER);
    }

    @Override
    public void onAttachedToWindow() {
        recLifeCycle(getClass(), CALL_TO_SUPER);
        super.onAttachedToWindow();
        recLifeCycle(getClass(), RETURN_FROM_SUPER);
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        recLifeCycle(getClass(), CALL_TO_SUPER);
        super.onAttachFragment(fragment);
        recLifeCycle(getClass(), RETURN_FROM_SUPER);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        recLifeCycle(getClass(), CALL_TO_SUPER);
        super.onConfigurationChanged(newConfig);
        recLifeCycle(getClass(), RETURN_FROM_SUPER);
    }

    @Override
    public void onContentChanged() {
        recLifeCycle(getClass(), CALL_TO_SUPER);
        super.onContentChanged();
        recLifeCycle(getClass(), RETURN_FROM_SUPER);
    }

    @Override
    protected void onDestroy() {
        recLifeCycle(getClass(), CALL_TO_SUPER);
        super.onDestroy();
        recLifeCycle(getClass(), RETURN_FROM_SUPER);
    }

    @Override
    public void onDetachedFromWindow() {
        recLifeCycle(getClass(), CALL_TO_SUPER);
        super.onDetachedFromWindow();
        recLifeCycle(getClass(), RETURN_FROM_SUPER);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        recLifeCycle(getClass(), CALL_TO_SUPER);
        super.onNewIntent(intent);
        recLifeCycle(getClass(), RETURN_FROM_SUPER);
    }

    @Override
    protected void onPause() {
        recLifeCycle(getClass(), CALL_TO_SUPER);
        super.onPause();
        recLifeCycle(getClass(), RETURN_FROM_SUPER);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        recLifeCycle(getClass(), CALL_TO_SUPER);
        super.onPostCreate(savedInstanceState);
        recLifeCycle(getClass(), RETURN_FROM_SUPER);

    }

    @Override
    protected void onPostResume() {
        recLifeCycle(getClass(), CALL_TO_SUPER);
        super.onPostResume();
        recLifeCycle(getClass(), RETURN_FROM_SUPER);
    }

    @Override
    public boolean onPrepareOptionsMenu(final Menu menu) {
        recLifeCycle(getClass(), CALL_TO_SUPER);
        boolean result = super.onPrepareOptionsMenu(menu);
        recLifeCycle(getClass(), RETURN_FROM_SUPER);

        return result;
    }

    @Override
    protected void onRestart() {
        recLifeCycle(getClass(), CALL_TO_SUPER);
        super.onRestart();
        recLifeCycle(getClass(), RETURN_FROM_SUPER);
    }

    @Override
    protected void onResume() {
        recLifeCycle(getClass(), CALL_TO_SUPER);
        super.onResume();
        recLifeCycle(getClass(), RETURN_FROM_SUPER);
    }

    @Override
    protected void onRestoreInstanceState(final Bundle savedInstanceState) {
        recLifeCycle(getClass(), CALL_TO_SUPER);
        super.onRestoreInstanceState(savedInstanceState);
        recLifeCycle(getClass(), RETURN_FROM_SUPER);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        recLifeCycle(getClass(), CALL_TO_SUPER);
        super.onWindowFocusChanged(hasFocus);
        recLifeCycle(getClass(), RETURN_FROM_SUPER);
    }

    @Override
    protected void onUserLeaveHint() {
        recLifeCycle(getClass(), CALL_TO_SUPER);
        super.onUserLeaveHint();
        recLifeCycle(getClass(), RETURN_FROM_SUPER);
    }

    @Override
    protected void onStart() {
        recLifeCycle(getClass(), CALL_TO_SUPER);
        super.onStart();
        recLifeCycle(getClass(), RETURN_FROM_SUPER);

    }

    @Override
    protected void onStop() {
        recLifeCycle(getClass(), CALL_TO_SUPER);
        super.onStop();
        recLifeCycle(getClass(), RETURN_FROM_SUPER);
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        recLifeCycle(getClass(), CALL_TO_SUPER);
        super.onSaveInstanceState(outState);
        recLifeCycle(getClass(), RETURN_FROM_SUPER);
    }

    @Override
    public void onUserInteraction() {
        recLifeCycle(getClass(), CALL_TO_SUPER);
        super.onUserInteraction();
        recLifeCycle(getClass(), RETURN_FROM_SUPER);
    }
}
