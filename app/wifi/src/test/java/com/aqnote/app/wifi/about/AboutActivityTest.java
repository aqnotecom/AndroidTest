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
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.aqnote.app.wifi.BuildConfig;
import com.aqnote.app.wifi.MainActivity;
import com.aqnote.app.wifi.MainContext;
import com.aqnote.app.wifi.R;
import com.aqnote.app.wifi.RobolectricUtil;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class AboutActivityTest {

    private AboutActivity fixture;
    private boolean isDevelopmentMode;

    @Before
    public void setUp() {
        RobolectricUtil.INSTANCE.getMainActivity();

        fixture = Robolectric.setupActivity(AboutActivity.class);

        isDevelopmentMode = MainContext.INSTANCE.getConfiguration().isDevelopmentMode();
    }

    @Test
    public void testTitle() throws Exception {
        // setup
        String expected = fixture.getResources().getString(R.string.action_about);
        // execute
        ActionBar actual = fixture.getSupportActionBar();
        // validate
        assertNotNull(actual);
        assertEquals(expected, actual.getTitle());
        assertNull(fixture.getActionBar());
    }

    @Test
    public void testOnOptionsItemSelectedWithHome() throws Exception {
        // setup
        MenuItem menuItem = mock(MenuItem.class);
        when(menuItem.getItemId()).thenReturn(android.R.id.home);
        // execute
        boolean actual = fixture.onOptionsItemSelected(menuItem);
        // validate
        assertTrue(actual);
        verify(menuItem).getItemId();
    }

    @Test
    public void testOnOptionsItemSelected() throws Exception {
        // setup
        MenuItem menuItem = mock(MenuItem.class);
        // execute
        boolean actual = fixture.onOptionsItemSelected(menuItem);
        // validate
        assertFalse(actual);
    }

    @Test
    public void testVersionNumber() throws Exception {
        // setup
        String packageName = fixture.getPackageName();
        PackageInfo packageInfo = fixture.getPackageManager().getPackageInfo(packageName, 0);
        String expected = packageInfo.versionName;
        if (isDevelopmentMode) {
            expected += " - " + packageInfo.versionCode + " SDK:" + Build.VERSION.SDK_INT;
        }
        // execute
        TextView actual = (TextView) fixture.findViewById(R.id.about_version_info);
        // validate
        assertNotNull(actual);
        assertEquals(expected, actual.getText());
    }

    @Test
    public void testPackageName() throws Exception {
        // setup
        String expectedName = StringUtils.EMPTY;
        int expectedVisibility = View.GONE;
        if (isDevelopmentMode) {
            expectedName = fixture.getPackageName();
            expectedVisibility = View.VISIBLE;
        }
        // execute
        TextView actual = (TextView) fixture.findViewById(R.id.about_package_name);
        // validate
        assertNotNull(actual);
        assertEquals(expectedVisibility, actual.getVisibility());
        assertEquals(expectedName, actual.getText());
    }

    @Test
    public void testApplicationName() throws Exception {
        // setup
        String expectedName = fixture.getString(R.string.app_name);
        if (isDevelopmentMode) {
            expectedName += " " + MainActivity.WI_FI_ANALYZER_BETA;
        }
        // execute
        TextView actual = (TextView) fixture.findViewById(R.id.about_app_name);
        // validate
        assertNotNull(actual);
        assertEquals(View.VISIBLE, actual.getVisibility());
        assertEquals(expectedName, actual.getText());
    }
}