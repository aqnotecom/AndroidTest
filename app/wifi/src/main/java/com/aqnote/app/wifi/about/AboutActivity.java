/*
 * WiFi Analyzer
 * Copyright (C) 2016  VREM Software Development <VREMSoftwareDevelopment@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.aqnote.app.wifi.about;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.aqnote.app.wifi.Configuration;
import com.aqnote.app.wifi.MainActivity;
import com.aqnote.app.wifi.MainContext;
import com.aqnote.app.wifi.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setCustomTheme();

        super.onCreate(savedInstanceState);

        setContentView(R.layout.about_content);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setApplicationName();
        setPackageName();
        setVersionNumber();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setCustomTheme() {
    }

    private void setVersionNumber() {
        MainContext mainContext = MainContext.INSTANCE;
        try {
            PackageManager packageManager = getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(), 0);
            String versionInfo = packageInfo.versionName;
            Configuration configuration = mainContext.getConfiguration();
            if (configuration != null && configuration.isDevelopmentMode()) {
                versionInfo += " - " + packageInfo.versionCode + " SDK:" + Build.VERSION.SDK_INT;
            }
            ((TextView) findViewById(R.id.about_version_info)).setText(versionInfo);
        } catch (PackageManager.NameNotFoundException e) {
            mainContext.getLogger().error(this, "Version Information", e);
        }
    }

    private void setPackageName() {
        Configuration configuration = MainContext.INSTANCE.getConfiguration();
        if (configuration != null && configuration.isDevelopmentMode()) {
            TextView textView = (TextView) findViewById(R.id.about_package_name);
            textView.setText(getPackageName());
            textView.setVisibility(View.VISIBLE);
        }
    }

    private void setApplicationName() {
        Configuration configuration = MainContext.INSTANCE.getConfiguration();
        if (configuration != null && configuration.isDevelopmentMode()) {
            TextView textView = (TextView) findViewById(R.id.about_app_name);
            textView.setText(textView.getText() + " " + MainActivity.WI_FI_ANALYZER_BETA);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
