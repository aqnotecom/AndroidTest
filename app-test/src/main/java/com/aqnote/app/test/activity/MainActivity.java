package com.aqnote.app.test.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.aqnote.app.test.R;
import com.aqnote.app.test.util.AssertUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String _ACTIVITY = "_activity";

    private List<String> adapterNameList = new ArrayList<>();
    private ListView listView;
    private ArrayAdapter<String> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");

        this.setTitle(TAG);
        this.setContentView(R.layout.activity_main);
        this.addListView();

        AssertUtil.getAssetFileINode("id.png", this);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String activityClassString = data.getStringExtra(_ACTIVITY);
        if(activityClassString == null || "".equalsIgnoreCase(activityClassString)) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction(activityClassString);
        intent.putExtra(_ACTIVITY, activityClassString);
        this.startActivityForResult(intent, requestCode);
    }

    private void addListView() {
        listView = (ListView) findViewById(R.id.main_listview);

        adapterNameList.add(AboutActivity.class.getSimpleName());
        adapterNameList.add(WebViewActivity.class.getSimpleName());
        adapterNameList.add(TaskActivity.class.getSimpleName());
        adapterNameList.add(SpeechActivity.class.getSimpleName());

        adapter = new AQAdapter<String>(this, adapterNameList);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AQAdapterView());
    }


    public class AQAdapter<T> extends ArrayAdapter<T> {

        public AQAdapter(Context context, List<T> adapterNameList) {
            super(context, android.R.layout.simple_list_item_1, android.R.id.text1, adapterNameList);
        }
    }

    public class AQAdapterView implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String activityName = "com.aqnote.app.test.activity." + adapterNameList.get(position);
            MainActivity.this.startActivity(new Intent(MainActivity.this, MainActivity.getClass(activityName)));
        }
    }

    private static Class<?> getClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
