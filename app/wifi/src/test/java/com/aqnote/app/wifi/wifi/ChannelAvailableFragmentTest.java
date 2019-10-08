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

package com.aqnote.app.wifi.wifi;

import com.aqnote.app.wifi.BuildConfig;
import com.aqnote.app.wifi.Configuration;
import com.aqnote.app.wifi.MainContextHelper;
import com.aqnote.app.wifi.RobolectricUtil;
import com.aqnote.app.wifi.settings.Settings;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;

import java.util.Locale;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class ChannelAvailableFragmentTest {

    private Configuration configuration;
    private Settings settings;
    private ChannelAvailableFragment fixture;

    @Before
    public void setUp() {
        RobolectricUtil.INSTANCE.getMainActivity();

        configuration = MainContextHelper.INSTANCE.getConfiguration();
        settings = MainContextHelper.INSTANCE.getSettings();

        when(settings.getCountryCode()).thenReturn(Locale.US.getCountry());

        fixture = new ChannelAvailableFragment();
    }

    @After
    public void tearDown() {
        verify(configuration, atLeastOnce()).isDevelopmentMode();
        verify(settings, atLeastOnce()).getCountryCode();
        MainContextHelper.INSTANCE.restore();
    }

    @Test
    public void testOnCreateView() throws Exception {
        // setup
        when(configuration.isDevelopmentMode()).thenReturn(false);
        // execute
        SupportFragmentTestUtil.startFragment(fixture);
        // validate
        assertNotNull(fixture);
    }

    @Test
    public void testOnCreateViewInDevelopmentMode() throws Exception {
        // setup
        when(configuration.isDevelopmentMode()).thenReturn(true);
        // execute
        SupportFragmentTestUtil.startFragment(fixture);
        // validate
        assertNotNull(fixture);
    }

}