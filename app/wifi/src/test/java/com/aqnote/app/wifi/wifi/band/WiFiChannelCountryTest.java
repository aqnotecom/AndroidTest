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

package com.aqnote.app.wifi.wifi.band;

import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WiFiChannelCountryTest {

    @Test
    public void testIsChannelAvailableWithTrue() throws Exception {
        assertTrue(WiFiChannelCountry.find(Locale.US.getCountry()).isChannelAvailableGHZ2(1));
        assertTrue(WiFiChannelCountry.find(Locale.US.getCountry()).isChannelAvailableGHZ2(11));

        assertTrue(WiFiChannelCountry.find(Locale.US.getCountry()).isChannelAvailableGHZ5(36));
        assertTrue(WiFiChannelCountry.find(Locale.US.getCountry()).isChannelAvailableGHZ5(165));

        assertTrue(WiFiChannelCountry.find(Locale.UK.getCountry()).isChannelAvailableGHZ2(1));
        assertTrue(WiFiChannelCountry.find(Locale.UK.getCountry()).isChannelAvailableGHZ2(13));

        assertTrue(WiFiChannelCountry.find(Locale.UK.getCountry()).isChannelAvailableGHZ5(36));
        assertTrue(WiFiChannelCountry.find(Locale.UK.getCountry()).isChannelAvailableGHZ5(140));
    }

    @Test
    public void testIsChannelAvailableWithGHZ2() throws Exception {
        assertFalse(WiFiChannelCountry.find(Locale.US.getCountry()).isChannelAvailableGHZ2(0));
        assertFalse(WiFiChannelCountry.find(Locale.US.getCountry()).isChannelAvailableGHZ2(12));

        assertFalse(WiFiChannelCountry.find(Locale.UK.getCountry()).isChannelAvailableGHZ2(0));
        assertFalse(WiFiChannelCountry.find(Locale.UK.getCountry()).isChannelAvailableGHZ2(14));
    }

    @Test
    public void testIsChannelAvailableWithGHZ5() throws Exception {
        assertTrue(WiFiChannelCountry.find(Locale.US.getCountry()).isChannelAvailableGHZ5(36));
        assertTrue(WiFiChannelCountry.find(Locale.US.getCountry()).isChannelAvailableGHZ5(165));

        assertTrue(WiFiChannelCountry.find(Locale.UK.getCountry()).isChannelAvailableGHZ5(36));
        assertTrue(WiFiChannelCountry.find(Locale.UK.getCountry()).isChannelAvailableGHZ5(140));

        assertTrue(WiFiChannelCountry.find("AE").isChannelAvailableGHZ5(36));
        assertTrue(WiFiChannelCountry.find("AE").isChannelAvailableGHZ5(64));
    }

    @Test
    public void testFind() throws Exception {
        assertEquals("US", WiFiChannelCountry.find(Locale.US.getCountry()).getCountryCode());
    }

    @Test
    public void testFindFailes() throws Exception {
        // setup
        String countryCode = "11";
        // execute
        WiFiChannelCountry actual = WiFiChannelCountry.find(countryCode);
        // validate
        assertEquals(countryCode, actual.getCountryCode());
        assertEquals(WiFiChannelCountry.UNKNOWN, actual.getCountryName());
        assertArrayEquals(WiFiChannelCountry.DEFAULT_CHANNELS_GHZ2.toArray(), actual.getChannelsGHZ2().toArray());
        assertArrayEquals(WiFiChannelCountry.DEFAULT_CHANNELS_GHZ5.toArray(), actual.getChannelsGHZ5().toArray());
    }

}