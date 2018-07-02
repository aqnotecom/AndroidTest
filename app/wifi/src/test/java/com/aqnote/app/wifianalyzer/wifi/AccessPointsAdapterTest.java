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

import android.view.View;

import com.aqnote.app.wifianalyzer.BuildConfig;
import com.aqnote.app.wifianalyzer.MainActivity;
import com.aqnote.app.wifianalyzer.MainContextHelper;
import com.aqnote.app.wifianalyzer.R;
import com.aqnote.app.wifianalyzer.RobolectricUtil;
import com.aqnote.app.wifianalyzer.wifi.model.WiFiConnection;
import com.aqnote.app.wifianalyzer.wifi.model.WiFiData;
import com.aqnote.app.wifianalyzer.wifi.model.WiFiDetail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class AccessPointsAdapterTest {

    private MainActivity mainActivity;
    private AccessPointsAdapter fixture;
    private AccessPointsAdapterData accessPointsAdapterData;
    private AccessPointsDetail accessPointsDetail;

    @Before
    public void setUp() {
        mainActivity = RobolectricUtil.INSTANCE.getMainActivity();

        accessPointsAdapterData = mock(AccessPointsAdapterData.class);
        accessPointsDetail = mock(AccessPointsDetail.class);

        fixture = new AccessPointsAdapter(mainActivity);
        fixture.setAccessPointsAdapterData(accessPointsAdapterData);
        fixture.setAccessPointsDetail(accessPointsDetail);
    }

    @After
    public void tearDown() {
        MainContextHelper.INSTANCE.restore();
    }

    @Test
    public void testGetGroupViewWithNoChildren() throws Exception {
        // setup
        WiFiDetail wiFiDetail = WiFiDetail.EMPTY;
        when(accessPointsAdapterData.parent(1)).thenReturn(wiFiDetail);
        when(accessPointsAdapterData.childrenCount(1)).thenReturn(0);
        // execute
        View actual = fixture.getGroupView(1, false, null, null);
        // validate
        assertNotNull(actual);
        assertEquals(View.GONE, actual.findViewById(R.id.groupIndicator).getVisibility());
        verify(accessPointsDetail).setView(mainActivity.getResources(), actual, wiFiDetail, false);
        verify(accessPointsAdapterData).parent(1);
        verify(accessPointsAdapterData).childrenCount(1);
    }

    @Test
    public void testGetGroupViewWithChildren() throws Exception {
        // setup
        WiFiDetail wiFiDetail = WiFiDetail.EMPTY;
        when(accessPointsAdapterData.parent(1)).thenReturn(wiFiDetail);
        when(accessPointsAdapterData.childrenCount(1)).thenReturn(5);
        // execute
        View actual = fixture.getGroupView(1, false, null, null);
        // validate
        assertNotNull(actual);
        assertEquals(View.VISIBLE, actual.findViewById(R.id.groupIndicator).getVisibility());
        verify(accessPointsDetail).setView(mainActivity.getResources(), actual, wiFiDetail, false);
        verify(accessPointsAdapterData).parent(1);
        verify(accessPointsAdapterData).childrenCount(1);
    }

    @Test
    public void testGetChildView() throws Exception {
        // setup
        WiFiDetail wiFiDetail = WiFiDetail.EMPTY;
        when(accessPointsAdapterData.child(0, 0)).thenReturn(wiFiDetail);
        // execute
        View actual = fixture.getChildView(0, 0, false, null, null);
        // validate
        assertNotNull(actual);
        assertEquals(View.GONE, actual.findViewById(R.id.groupIndicator).getVisibility());
        verify(accessPointsDetail).setView(mainActivity.getResources(), actual, wiFiDetail, true);
        verify(accessPointsAdapterData).child(0, 0);
    }

    @Test
    public void testUpdate() throws Exception {
        // setup
        WiFiData wiFiData = new WiFiData(new ArrayList<WiFiDetail>(), WiFiConnection.EMPTY, new ArrayList<String>());
        // execute
        fixture.update(wiFiData);
        // validate
        verify(accessPointsAdapterData).update(wiFiData);
    }

    @Test
    public void testGetGroupCount() throws Exception {
        // setup
        int expected = 5;
        when(accessPointsAdapterData.parentsCount()).thenReturn(expected);
        // execute
        int actual = fixture.getGroupCount();
        // validate
        assertEquals(expected, actual);
        verify(accessPointsAdapterData).parentsCount();
    }

    @Test
    public void testGetChildrenCount() throws Exception {
        // setup
        int expected = 25;
        when(accessPointsAdapterData.childrenCount(1)).thenReturn(expected);
        // execute
        int actual = fixture.getChildrenCount(1);
        // validate
        assertEquals(expected, actual);
        verify(accessPointsAdapterData).childrenCount(1);
    }

    @Test
    public void testGetGroup() throws Exception {
        // setup
        WiFiDetail expected = WiFiDetail.EMPTY;
        when(accessPointsAdapterData.parent(3)).thenReturn(expected);
        // execute
        WiFiDetail actual = (WiFiDetail) fixture.getGroup(3);
        // validate
        assertEquals(expected, actual);
        verify(accessPointsAdapterData).parent(3);
    }

    @Test
    public void testGetChild() throws Exception {
        // setup
        WiFiDetail expected = WiFiDetail.EMPTY;
        when(accessPointsAdapterData.child(1, 2)).thenReturn(expected);
        // execute
        WiFiDetail actual = (WiFiDetail) fixture.getChild(1, 2);
        // validate
        assertEquals(expected, actual);
        verify(accessPointsAdapterData).child(1, 2);
    }

    @Test
    public void testGetGroupId() throws Exception {
        assertEquals(22, fixture.getGroupId(22));
    }

    @Test
    public void testGetChildId() throws Exception {
        assertEquals(11, fixture.getChildId(1, 11));
    }

    @Test
    public void testHasStableIds() throws Exception {
        assertTrue(fixture.hasStableIds());
    }

    @Test
    public void testIsChildSelectable() throws Exception {
        assertTrue(fixture.isChildSelectable(0, 0));
    }
}