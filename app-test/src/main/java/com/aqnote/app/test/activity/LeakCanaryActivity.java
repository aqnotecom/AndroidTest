package com.aqnote.app.test.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.aqnote.app.test.activity.leakcanary.TestActivity;


public class LeakCanaryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(LeakCanaryActivity.this);
        layout.setHorizontalGravity(Gravity.FILL_HORIZONTAL);
        layout.setVerticalGravity(Gravity.FILL_VERTICAL);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        Button btn1 = new Button(LeakCanaryActivity.this);
        btn1.setText("go to test");
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToTest();
            }
        });
        layout.addView(btn1, new LinearLayout.LayoutParams(
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
