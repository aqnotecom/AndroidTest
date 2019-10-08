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

import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.aqnote.app.wifi.BuildConfig;
import com.aqnote.app.wifi.MainActivity;
import com.aqnote.app.wifi.MainContextHelper;
import com.aqnote.app.wifi.R;
import com.aqnote.app.wifi.RobolectricUtil;
import com.aqnote.app.wifi.settings.Settings;
import com.aqnote.app.wifi.wifi.band.WiFiBand;
import com.aqnote.app.wifi.wifi.band.WiFiChannel;
import com.aqnote.app.wifi.wifi.model.ChannelRating;
import com.aqnote.app.wifi.wifi.model.SortBy;
import com.aqnote.app.wifi.wifi.model.Strength;
import com.aqnote.app.wifi.wifi.model.WiFiConnection;
import com.aqnote.app.wifi.wifi.model.WiFiData;
import com.aqnote.app.wifi.wifi.model.WiFiDetail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class ChannelRatingAdapterTest {

    private ChannelRatingAdapter fixture;
    private Settings settings;
    private ChannelRating channelRating;

    @Before
    public void setUp() {
        MainActivity mainActivity = RobolectricUtil.INSTANCE.getMainActivity();

        channelRating = mock(ChannelRating.class);
        TextView bestChannels = mock(TextView.class);

        settings = MainContextHelper.INSTANCE.getSettings();

        fixture = new ChannelRatingAdapter(mainActivity, bestChannels);
        fixture.setChannelRating(channelRating);
    }

    @After
    public void tearDown() {
        MainContextHelper.INSTANCE.restore();
    }

    @Test
    public void testGetView() throws Exception {
        // setup
        int expectedSize = Strength.values().length;
        Strength expectedStrength = Strength.reverse(Strength.FOUR);
        WiFiChannel wiFiChannel = new WiFiChannel(1, 2);
        fixture.add(wiFiChannel);
        when(channelRating.getCount(wiFiChannel)).thenReturn(5);
        when(channelRating.getStrength(wiFiChannel)).thenReturn(Strength.FOUR);
        // execute
        View actual = fixture.getView(0, null, null);
        // validate
        assertNotNull(actual);

        assertEquals("1", ((TextView) actual.findViewById(R.id.channelNumber)).getText());
        assertEquals("5", ((TextView) actual.findViewById(R.id.accessPointCount)).getText());

        RatingBar ratingBar = (RatingBar) actual.findViewById(R.id.channelRating);
        assertEquals(expectedSize, ratingBar.getMax());
        assertEquals(expectedSize, ratingBar.getNumStars());
        assertEquals(expectedStrength.ordinal() + 1, (int) ratingBar.getRating());

        verify(channelRating).getCount(wiFiChannel);
        verify(channelRating).getStrength(wiFiChannel);
    }

    @Test
    public void testUpdate() throws Exception {
        // setup
        WiFiData wiFiData = new WiFiData(new ArrayList<WiFiDetail>(), WiFiConnection.EMPTY, new ArrayList<String>());
        List<WiFiDetail> wiFiDetails = wiFiData.getWiFiDetails(WiFiBand.GHZ5, SortBy.STRENGTH);
        when(settings.getWiFiBand()).thenReturn(WiFiBand.GHZ5);
        when(settings.getCountryCode()).thenReturn(Locale.US.getCountry());
        // execute
        fixture.update(wiFiData);
        // validate
        verify(channelRating).setWiFiDetails(wiFiDetails);
        verify(settings).getWiFiBand();
        verify(settings).getCountryCode();
    }

    @Test
    public void testBestChannelsGHZ2() throws Exception {
        // setup
        List<WiFiChannel> wiFiChannels = new ArrayList<>();
        List<ChannelRating.ChannelAPCount> channelAPCounts = new ArrayList<>();
        when(channelRating.getBestChannels(wiFiChannels)).thenReturn(channelAPCounts);
        // execute
        fixture.bestChannels(WiFiBand.GHZ2, wiFiChannels);
        // validate
        verify(channelRating).getBestChannels(wiFiChannels);
    }

    @Test
    public void testBestChannelsGHZ5() throws Exception {
        // setup
        List<WiFiChannel> wiFiChannels = new ArrayList<>();
        List<ChannelRating.ChannelAPCount> channelAPCounts = new ArrayList<>();
        when(channelRating.getBestChannels(wiFiChannels)).thenReturn(channelAPCounts);
        // execute
        fixture.bestChannels(WiFiBand.GHZ5, wiFiChannels);
        // validate
        verify(channelRating).getBestChannels(wiFiChannels);
    }

}