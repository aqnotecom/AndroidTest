package com.aqnote.app.test.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.aqnote.module.container.util.AssertUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import dalvik.system.DexFile;

/**
 *
 * 入口页面
 *
 * @author "Peng Li"<aqnote@aqnote.com>
 */
public class MainActivity extends Activity {

    private static final String TAG              = MainActivity.class.getSimpleName();
    private static final String _ACTIVITY        = "_activity";
    private static final String _PACKAGE         = MainActivity.class.getPackage().getName();
    private static final String ACTIVITY_PACKAGE = _PACKAGE + ".";

    private List<String> adapterNameList = new ArrayList<>();
    private ListView             listView;
    private ArrayAdapter<String> adapter;

    private LinearLayout layout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");

        this.setTitle(TAG);

        layout = new LinearLayout(MainActivity.this);
        layout.setHorizontalGravity(Gravity.FILL_HORIZONTAL);
        layout.setVerticalGravity(Gravity.FILL_VERTICAL);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        addListView();

        AssertUtil.getAssetFileINode("id.png", this);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String activityClassString = data.getStringExtra(_ACTIVITY);
        if (activityClassString == null || "".equalsIgnoreCase(activityClassString)) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction(activityClassString);
        intent.putExtra(_ACTIVITY, activityClassString);
        this.startActivityForResult(intent, requestCode);
    }

    private void addListView() {
        listView = new ListView(MainActivity.this);

//        List<String> clazzStringList = MultiDexUtil.getAllClasses(MainActivity.this);
//        for(String clazzString : clazzStringList) {
//            Class clazz = getClass(clazzString);
//            if(_PACKAGE.equals(clazz.getPackage().getName())) {
//                adapterNameList.add(clazz.getSimpleName());
//            }
//        }
        adapterNameList.add(AboutActivity.class.getSimpleName());
        adapterNameList.add(WebViewActivity.class.getSimpleName());
        adapterNameList.add(TaskActivity.class.getSimpleName());
        adapterNameList.add(SpeechActivity.class.getSimpleName());
        adapterNameList.add(AccountActivity.class.getSimpleName());
        adapterNameList.add(LifecycleActivity.class.getSimpleName());
        adapterNameList.add(HttpsActivity.class.getSimpleName());
        adapterNameList.add(LeakCanaryActivity.class.getSimpleName());
        adapterNameList.add(TelephonyActivity.class.getSimpleName());
        adapterNameList.add(DeviceActivity.class.getSimpleName());
        adapterNameList.add(ExternalStorageActivity.class.getSimpleName());
        adapterNameList.add(IdentifiersActivity.class.getSimpleName());
        adapter = new AQAdapter<String>(this, adapterNameList);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AQAdapterView());

        LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layout.addView(listView, textViewParams);
    }


    public class AQAdapter<T> extends ArrayAdapter<T> {

        public AQAdapter(Context context, List<T> adapterNameList) {
            super(context, android.R.layout.simple_list_item_1, android.R.id.text1, adapterNameList);
        }
    }

    public class AQAdapterView implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String activityName = ACTIVITY_PACKAGE + adapterNameList.get(position);
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

    public List<Class> getClassName(String packageName) {
        List<Class> classNameList = new ArrayList<Class>();
        try {

            DexFile df = new DexFile(getPackageCodePath());//通过DexFile查找当前的APK中可执行文件
            Enumeration<String> enumeration = df.entries();//获取df中的元素  这里包含了所有可执行的类名 该类名包含了包名+类名的方式
            while (enumeration.hasMoreElements()) {//遍历
                String className = (String) enumeration.nextElement();

                if (className.contains(packageName)) {//在当前所有可执行的类里面查找包含有该包名的所有类
                    Class clazz = getClass(className);
                    if (clazz != null) {
                        classNameList.add(clazz);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classNameList;
    }

}
