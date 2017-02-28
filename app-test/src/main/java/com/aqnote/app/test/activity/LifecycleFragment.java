package com.aqnote.app.test.activity;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aqnote.app.test.R;

import static com.aqnote.app.test.log.LifecycleLog.*;
import static com.aqnote.app.test.log.LifecycleLog.LifecycleState.CALL_TO_SUPER;
import static com.aqnote.app.test.log.LifecycleLog.LifecycleState.RETURN_FROM_SUPER;


/**
 * Created by madding on 2/23/17.
 */
public class LifecycleFragment extends Fragment {

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            recLifeCycle(getClass(), CALL_TO_SUPER);
            super.onActivityCreated(savedInstanceState);
            recLifeCycle(getClass(), RETURN_FROM_SUPER);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            recLifeCycle(getClass(), CALL_TO_SUPER);
            LinearLayout layout = new LinearLayout(LifecycleFragment.this.getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);

            TextView textView = new TextView(LifecycleFragment.this.getActivity());
            textView.setText(R.string.activity_lifecycle_message);
            textView.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams textViewLayoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            layout.addView(textView, textViewLayoutParams);
            recLifeCycle(getClass(), RETURN_FROM_SUPER);

            return layout;
        }

        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            recLifeCycle(getClass(), CALL_TO_SUPER);
            super.onViewCreated(view, savedInstanceState);
            recLifeCycle(getClass(), RETURN_FROM_SUPER);

        }

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            recLifeCycle(getClass(), CALL_TO_SUPER);
            super.onActivityResult(requestCode, resultCode, data);
            recLifeCycle(getClass(), RETURN_FROM_SUPER);

        }

        @Override
        public void onAttach(Context context) {
            recLifeCycle(getClass(), CALL_TO_SUPER);
            super.onAttach(context);
            recLifeCycle(getClass(), RETURN_FROM_SUPER);
        }

        @Override
        public void onConfigurationChanged(Configuration newConfig) {
            recLifeCycle(getClass(), CALL_TO_SUPER);
            super.onConfigurationChanged(newConfig);
            recLifeCycle(getClass(), RETURN_FROM_SUPER);
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            recLifeCycle(getClass(), CALL_TO_SUPER);
            super.onCreate(savedInstanceState);
            recLifeCycle(getClass(), RETURN_FROM_SUPER);
            setHasOptionsMenu(true);
        }

        @Override
        public void onCreateOptionsMenu(final Menu menu, final MenuInflater inflater) {
            recLifeCycle(getClass(), CALL_TO_SUPER);
            super.onCreateOptionsMenu(menu, inflater);
            recLifeCycle(getClass(), RETURN_FROM_SUPER);
        }

        @Override
        public void onDestroy() {
            recLifeCycle(getClass(), CALL_TO_SUPER);
            super.onDestroy();
            recLifeCycle(getClass(), RETURN_FROM_SUPER);
        }

        @Override
        public void onDestroyOptionsMenu() {
            recLifeCycle(getClass(), CALL_TO_SUPER);
            super.onDestroyOptionsMenu();
            recLifeCycle(getClass(), RETURN_FROM_SUPER);
        }

        @Override
        public void onDestroyView() {
            recLifeCycle(getClass(), CALL_TO_SUPER);
            super.onDestroyView();
            recLifeCycle(getClass(), RETURN_FROM_SUPER);
        }

        @Override
        public void onDetach() {
            recLifeCycle(getClass(), CALL_TO_SUPER);
            super.onDetach();
            recLifeCycle(getClass(), RETURN_FROM_SUPER);
        }

        @Override
        public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
            recLifeCycle(getClass(), CALL_TO_SUPER);
            super.onInflate(context, attrs, savedInstanceState);
            recLifeCycle(getClass(), RETURN_FROM_SUPER);
        }

        @Override
        public void onPause() {
            recLifeCycle(getClass(), CALL_TO_SUPER);
            super.onPause();
            recLifeCycle(getClass(), RETURN_FROM_SUPER);
        }

        @Override
        public void onPrepareOptionsMenu(final Menu menu) {
            recLifeCycle(getClass(), CALL_TO_SUPER);
            super.onPrepareOptionsMenu(menu);
            recLifeCycle(getClass(), RETURN_FROM_SUPER);
        }

        @Override
        public void onResume() {
            recLifeCycle(getClass(), CALL_TO_SUPER);
            super.onResume();
            recLifeCycle(getClass(), RETURN_FROM_SUPER);
        }

        @Override
        public void onSaveInstanceState(Bundle outState) {
            recLifeCycle(getClass(), CALL_TO_SUPER);
            super.onSaveInstanceState(outState);
            recLifeCycle(getClass(), RETURN_FROM_SUPER);
        }

        @Override
        public void onStart() {
            recLifeCycle(getClass(), CALL_TO_SUPER);
            super.onStart();
            recLifeCycle(getClass(), RETURN_FROM_SUPER);
        }

        @Override
        public void onStop() {
            recLifeCycle(getClass(), CALL_TO_SUPER);
            super.onStop();

            recLifeCycle(getClass(), RETURN_FROM_SUPER);
        }

        @Override
        public void onViewStateRestored(Bundle savedInstanceState) {
            recLifeCycle(getClass(), CALL_TO_SUPER);
            super.onViewStateRestored(savedInstanceState);
            recLifeCycle(getClass(), RETURN_FROM_SUPER);
        }
    }
