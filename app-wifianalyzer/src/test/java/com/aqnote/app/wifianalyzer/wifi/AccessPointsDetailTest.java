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
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.aqnote.app.wifianalyzer.BuildConfig;
import com.aqnote.app.wifianalyzer.MainActivity;
import com.aqnote.app.wifianalyzer.MainContext;
import com.aqnote.app.wifianalyzer.R;
import com.aqnote.app.wifianalyzer.RobolectricUtil;
import com.aqnote.app.wifianalyzer.wifi.band.WiFiWidth;
import com.aqnote.app.wifianalyzer.wifi.model.WiFiAdditional;
import com.aqnote.app.wifianalyzer.wifi.model.WiFiDetail;
import com.aqnote.app.wifianalyzer.wifi.model.WiFiSignal;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class AccessPointsDetailTest {
    private MainActivity mainActivity;

    private View view;
    private AccessPointsDetail fixture;

    @Before
    public void setUp() {
        mainActivity = RobolectricUtil.INSTANCE.getMainActivity();
        view = MainContext.INSTANCE.getLayoutInflater().inflate(R.layout.access_points_details, null);
        assertNotNull(view);
        fixture = new AccessPointsDetail();
    }

    @Test
    public void testSetViewWithIpAddressAndLinkSpeedGone() throws Exception {
        // setup
        WiFiAdditional wiFiAdditional = new WiFiAdditional(StringUtils.EMPTY, "IPAddress", 22);
        WiFiDetail wiFiDetail = withWiFiDetail("SSID", wiFiAdditional);
        // execute
        fixture.setView(mainActivity.getResources(), view, wiFiDetail, false);
        // validate
        assertEquals(View.GONE, view.findViewById(R.id.ipAddress).getVisibility());
        assertEquals(View.GONE, view.findViewById(R.id.linkSpeed).getVisibility());
    }

    @Test
    public void testSetViewWithConfiguredImageVisible() throws Exception {
        // setup
        WiFiAdditional wiFiAdditional = new WiFiAdditional(StringUtils.EMPTY, "IPAddress", 22);
        WiFiDetail wiFiDetail = withWiFiDetail("SSID", wiFiAdditional);
        // execute
        fixture.setView(mainActivity.getResources(), view, wiFiDetail, false);
        // validate
        assertEquals(View.VISIBLE, view.findViewById(R.id.configuredImage).getVisibility());
    }

    @Test
    public void testSetViewWithTabGone() throws Exception {
        // setup
        WiFiAdditional wiFiAdditional = new WiFiAdditional(StringUtils.EMPTY, "IPAddress", 22);
        WiFiDetail wiFiDetail = withWiFiDetail("SSID", wiFiAdditional);
        // execute
        fixture.setView(mainActivity.getResources(), view, wiFiDetail, false);
        // validate
        assertEquals(View.GONE, view.findViewById(R.id.tab).getVisibility());
    }

    @Test
    public void testSetViewWithGroupIndicatorGone() throws Exception {
        // setup
        WiFiAdditional wiFiAdditional = new WiFiAdditional(StringUtils.EMPTY, "IPAddress", 22);
        WiFiDetail wiFiDetail = withWiFiDetail("SSID", wiFiAdditional);
        // execute
        fixture.setView(mainActivity.getResources(), view, wiFiDetail, false);
        // validate
        assertEquals(View.GONE, view.findViewById(R.id.groupIndicator).getVisibility());
    }

    @Test
    public void testSetViewWithVendorNameVisible() throws Exception {
        // setup
        WiFiDetail wiFiDetail = withWiFiDetail("SSID", new WiFiAdditional("VendorName", false));
        // execute
        fixture.setView(mainActivity.getResources(), view, wiFiDetail, false);
        // validate
        assertEquals(View.VISIBLE, view.findViewById(R.id.vendor).getVisibility());
    }

    @Test
    public void testSetViewWithVendorNameMaximumSize() throws Exception {
        // setup
        String vendorName = "VendorName-VendorName";
        WiFiDetail wiFiDetail = withWiFiDetail("SSID", new WiFiAdditional(vendorName, false));
        // execute
        fixture.setView(mainActivity.getResources(), view, wiFiDetail, false);
        // validate
        validateTextViewValue(vendorName.substring(0, 12), R.id.vendor);
    }

    @Test
    public void testSetViewWithTabVisible() throws Exception {
        // setup
        WiFiDetail wiFiDetail = withWiFiDetail(StringUtils.EMPTY, new WiFiAdditional(StringUtils.EMPTY, false));
        // execute
        fixture.setView(mainActivity.getResources(), view, wiFiDetail, true);
        // validate
        assertEquals(View.VISIBLE, view.findViewById(R.id.tab).getVisibility());
    }

    @Test
    public void testSetViewWithWiFiDetailAndEmptySSID() throws Exception {
        // setup
        WiFiDetail wiFiDetail = withWiFiDetail(StringUtils.EMPTY, new WiFiAdditional(StringUtils.EMPTY, false));
        // execute
        fixture.setView(mainActivity.getResources(), view, wiFiDetail, false);
        // validate
        validateTextViewValues(wiFiDetail, "***");
    }

    @Test
    public void testSetViewWithWiFiDetail() throws Exception {
        // setup
        String ssid = "SSID";
        WiFiDetail wiFiDetail = withWiFiDetail(ssid, new WiFiAdditional(StringUtils.EMPTY, false));
        // execute
        fixture.setView(mainActivity.getResources(), view, wiFiDetail, false);
        // validate
        validateTextViewValues(wiFiDetail, ssid);
    }

    private WiFiDetail withWiFiDetail(String SSID, WiFiAdditional wiFiAdditional) {
        return new WiFiDetail(SSID, "BSSID", "capabilities", new WiFiSignal(1, 1, WiFiWidth.MHZ_40, 2), wiFiAdditional);
    }

    private void validateTextViewValues(@NonNull WiFiDetail wiFiDetail, @NonNull String ssid) {
        WiFiSignal wiFiSignal = wiFiDetail.getWiFiSignal();
        validateTextViewValue(ssid + " (" + wiFiDetail.getBSSID() + ")", R.id.ssid);
        validateTextViewValue(wiFiSignal.getLevel() + "dBm", R.id.level);
        validateTextViewValue(wiFiSignal.getChannelDisplay(), R.id.channel);
        validateTextViewValue(wiFiSignal.getPrimaryFrequency() + WifiInfo.FREQUENCY_UNITS, R.id.primaryFrequency);
        validateTextViewValue(wiFiSignal.getFrequencyStart() + " - " + wiFiSignal.getFrequencyEnd(), R.id.channel_frequency_range);
        validateTextViewValue("(" + wiFiSignal.getWiFiWidth().getFrequencyWidth() + WifiInfo.FREQUENCY_UNITS + ")", R.id.width);
        validateTextViewValue(String.format("%.1fm", wiFiSignal.getDistance()), R.id.distance);
        validateTextViewValue(wiFiDetail.getCapabilities(), R.id.capabilities);
    }

    private void validateTextViewValue(@NonNull String expected, int id) {
        assertEquals(expected, ((TextView) view.findViewById(id)).getText().toString());
    }
}