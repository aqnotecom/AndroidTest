package com.aqnote.androidtest.activity;

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

import com.aqnote.androidtest.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private List<String> adapterNameList = new ArrayList<>();
    private ListView listView;
    private ArrayAdapter<String> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");

        this.setTitle("AQNote's Android Demo Index");
        this.setContentView(R.layout.activity_main);
        this.addListView();
    }

    private void addListView() {
        listView = (ListView) findViewById(R.id.main_listview);

        adapterNameList.add("AboutActivity");
        adapterNameList.add("SysWebViewActivity");
        adapterNameList.add("UCWebViewActivity");
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
            String activityName = "com.aqnote.androidtest.activity." + adapterNameList.get(position);
            try {
                MainActivity.this.startActivity(new Intent(MainActivity.this, Class.forName(activityName)));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
