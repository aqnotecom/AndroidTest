package com.aqnote.app.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.aqnote.app.test.activity.leakcanary.TestActivity;

/**
 *
 * 模拟内存泄漏页面
 *
 * @author "Peng Li"<aqnote@aqnote.com>
 */
public class LeakCanaryActivity extends AQNoteActivity {

    private static final String TAG = LeakCanaryActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button btn1 = new Button(LeakCanaryActivity.this);
        btn1.setText("go to test");
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToTest();
            }
        });
        alayout.addView(btn1, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
    }

    private void goToTest() {
        Intent intent = new Intent(this, TestActivity.class);
        startActivity(intent);
    }

    private static final int MENU_ITEM_ITEM1 = 1;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, MENU_ITEM_ITEM1, Menu.NONE, "test");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == MENU_ITEM_ITEM1) {
            goToTest();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
