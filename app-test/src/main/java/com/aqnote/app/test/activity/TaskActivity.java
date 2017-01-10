package com.aqnote.app.test.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.aqnote.app.test.R;
import com.aqnote.app.test.util.AssertUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by madding on 6/30/16.
 */
public class TaskActivity extends Activity {

    private static final String TAG = TaskActivity.class.getSimpleName();
    private static final String _ACTIVITY = "_activity";

    private List<String> adapterNameList = new ArrayList<>();
    private ListView             listView;
    private ArrayAdapter<String> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");

        this.setTitle(TAG);
        this.setContentView(R.layout.activity_task);
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
        listView = (ListView) findViewById(R.id.task_listview);

        adapterNameList.add("NewTaskActivity");
        adapterNameList.add("ClearTopActivity");
        adapterNameList.add("TODO");

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
            String activityShortName = adapterNameList.get(position);
            String activityName = "com.aqnote.test.activity.task." + activityShortName;
            Intent intent = new Intent(TaskActivity.this, TaskActivity.getClass(activityName));
            if("NewTaskActivity".equalsIgnoreCase(activityShortName)) {
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            } else if("ClearTopActivity".equalsIgnoreCase(activityShortName)) {
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
            startActivity(intent);
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
