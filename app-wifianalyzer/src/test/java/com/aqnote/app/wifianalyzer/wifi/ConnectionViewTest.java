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

package com.aqnote.app.wifianalyzer.wifi;

import android.net.wifi.WifiInfo;
import android.view.View;
import android.widget.TextView;

import com.aqnote.app.wifianalyzer.BuildConfig;
import com.aqnote.app.wifianalyzer.Configuration;
import com.aqnote.app.wifianalyzer.MainActivity;
import com.aqnote.app.wifianalyzer.MainContextHelper;
import com.aqnote.app.wifianalyzer.R;
import com.aqnote.app.wifianalyzer.RobolectricUtil;
import com.aqnote.app.wifianalyzer.navigation.NavigationMenu;
import com.aqnote.app.wifianalyzer.settings.Settings;
import com.aqnote.app.wifianalyzer.wifi.band.WiFiWidth;
import com.aqnote.app.wifianalyzer.wifi.model.WiFiAdditional;
import com.aqnote.app.wifianalyzer.wifi.model.WiFiData;
import com.aqnote.app.wifianalyzer.wifi.model.WiFiDetail;
import com.aqnote.app.wifianalyzer.wifi.model.WiFiSignal;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class ConnectionViewTest {
    private MainActivity mainActivity;
    private ConnectionView fixture;

    private Configuration configuration;
    private Settings settings;

    private WiFiData wiFiData;
    private AccessPointsDetail accessPointsDetail;

    @Before
    public void setUp() {
        mainActivity = RobolectricUtil.INSTANCE.getMainActivity();

        accessPointsDetail = mock(AccessPointsDetail.class);
        wiFiData = mock(WiFiData.class);

        configuration = MainContextHelper.INSTANCE.getConfiguration();
        settings = MainContextHelper.INSTANCE.getSettings();

        fixture = new ConnectionView(mainActivity);
        fixture.setAccessPointsDetail(accessPointsDetail);
    }

    @After
    public void tearDown() {
        MainContextHelper.INSTANCE.restore();
        mainActivity.getNavigationMenuView().setCurrentNavigationMenu(NavigationMenu.ACCESS_POINTS);
    }

    @Test
    public void testConnectionGoneWithNoConnectionInformation() throws Exception {
        // setup
        WiFiDetail connection = withConnection(WiFiAdditional.EMPTY);
        when(wiFiData.getConnection()).thenReturn(connection);
        when(wiFiData.getWiFiDetails(settings.getWiFiBand(), settings.getSortBy())).thenReturn(new ArrayList<WiFiDetail>());
        // execute
        fixture.update(wiFiData);
        // validate
        View view = mainActivity.findViewById(R.id.connection);
        assertEquals(View.GONE, view.getVisibility());

        verify(wiFiData).getConnection();
        verify(configuration, never()).isLargeScreenLayout();
        verify(accessPointsDetail, never()).setView(mainActivity.getResources(), view, connection, false);
    }

    @Test
    public void testConnectionVisibleWithConnectionInformation() throws Exception {
        // setup
        WiFiAdditional wiFiAdditional = new WiFiAdditional(StringUtils.EMPTY, "IPADDRESS", 11);
        WiFiDetail connection = withConnection(wiFiAdditional);
        when(wiFiData.getConnection()).thenReturn(connection);
        when(wiFiData.getWiFiDetails(settings.getWiFiBand(), settings.getSortBy())).thenReturn(new ArrayList<WiFiDetail>());
        // execute
        fixture.update(wiFiData);
        // validate
        View view = mainActivity.findViewById(R.id.connection);
        assertEquals(View.VISIBLE, view.getVisibility());

        TextView ipAddressView = (TextView) view.findViewById(R.id.ipAddress);
        assertEquals(View.VISIBLE, ipAddressView.getVisibility());
        assertEquals(wiFiAdditional.getIPAddress(), ipAddressView.getText().toString());

        TextView linkSpeedView = (TextView) view.findViewById(R.id.linkSpeed);
        assertEquals(View.VISIBLE, linkSpeedView.getVisibility());
        assertEquals(wiFiAdditional.getLinkSpeed() + WifiInfo.LINK_SPEED_UNITS, linkSpeedView.getText().toString());

        verify(wiFiData).getConnection();
        verify(accessPointsDetail).setView(mainActivity.getResources(), view, connection, false);
    }

    @Test
    public void testNoDataIsVisibleWithNoWiFiDetails() throws Exception {
        // setup
        when(wiFiData.getConnection()).thenReturn(withConnection(WiFiAdditional.EMPTY));
        // execute
        fixture.update(wiFiData);
        // validate
        assertEquals(View.VISIBLE, mainActivity.findViewById(R.id.nodata).getVisibility());
        assertEquals(View.VISIBLE, mainActivity.findViewById(R.id.nodatageo).getVisibility());
        assertEquals(View.VISIBLE, mainActivity.findViewById(R.id.nodatageourl).getVisibility());
        verify(wiFiData).getWiFiDetails(settings.getWiFiBand(), settings.getSortBy());
        verify(wiFiData).getWiFiDetails();
    }

    @Test
    public void testNoDataIsGoneWithNonWiFiBandSwitchableNavigationMenu() throws Exception {
        // setup
        mainActivity.getNavigationMenuView().setCurrentNavigationMenu(NavigationMenu.VENDOR_LIST);
        when(wiFiData.getConnection()).thenReturn(withConnection(WiFiAdditional.EMPTY));
        // execute
        fixture.update(wiFiData);
        // validate
        assertEquals(View.GONE, mainActivity.findViewById(R.id.nodata).getVisibility());
        assertEquals(View.GONE, mainActivity.findViewById(R.id.nodatageo).getVisibility());
        assertEquals(View.GONE, mainActivity.findViewById(R.id.nodatageourl).getVisibility());
        verify(wiFiData, never()).getWiFiDetails(settings.getWiFiBand(), settings.getSortBy());
        verify(wiFiData, never()).getWiFiDetails();
    }

    @Test
    public void testNoDataIsGoneWithWiFiDetails() throws Exception {
        // setup
        WiFiDetail wiFiDetail = withConnection(WiFiAdditional.EMPTY);
        when(wiFiData.getConnection()).thenReturn(wiFiDetail);
        when(wiFiData.getWiFiDetails(settings.getWiFiBand(), settings.getSortBy())).thenReturn(Arrays.asList(wiFiDetail));
        // execute
        fixture.update(wiFiData);
        // validate
        assertEquals(View.GONE, mainActivity.findViewById(R.id.nodata).getVisibility());
        assertEquals(View.GONE, mainActivity.findViewById(R.id.nodatageo).getVisibility());
        assertEquals(View.GONE, mainActivity.findViewById(R.id.nodatageourl).getVisibility());
        verify(wiFiData).getWiFiDetails(settings.getWiFiBand(), settings.getSortBy());
        verify(wiFiData, never()).getWiFiDetails();
    }

    private WiFiDetail withConnection(WiFiAdditional wiFiAdditional) {
        return new WiFiDetail("SSID", "BSSID", StringUtils.EMPTY,
            new WiFiSignal(2435, 2435, WiFiWidth.MHZ_20, -55), wiFiAdditional);
    }

}