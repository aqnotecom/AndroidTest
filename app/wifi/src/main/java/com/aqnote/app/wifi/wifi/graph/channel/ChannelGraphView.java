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

package com.aqnote.app.wifi.wifi.graph.channel;

import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import android.view.View;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.TitleLineGraphSeries;
import com.aqnote.app.wifi.Configuration;
import com.aqnote.app.wifi.MainActivity;
import com.aqnote.app.wifi.MainContext;
import com.aqnote.app.wifi.R;
import com.aqnote.app.wifi.settings.Settings;
import com.aqnote.app.wifi.wifi.band.WiFiBand;
import com.aqnote.app.wifi.wifi.band.WiFiChannel;
import com.aqnote.app.wifi.wifi.band.WiFiChannels;
import com.aqnote.app.wifi.wifi.graph.tools.GraphColor;
import com.aqnote.app.wifi.wifi.graph.tools.GraphLegend;
import com.aqnote.app.wifi.wifi.graph.tools.GraphViewBuilder;
import com.aqnote.app.wifi.wifi.graph.tools.GraphViewNotifier;
import com.aqnote.app.wifi.wifi.graph.tools.GraphViewWrapper;
import com.aqnote.app.wifi.wifi.model.SortBy;
import com.aqnote.app.wifi.wifi.model.WiFiData;
import com.aqnote.app.wifi.wifi.model.WiFiDetail;
import com.aqnote.app.wifi.wifi.model.WiFiSignal;

import java.util.Set;
import java.util.TreeSet;

class ChannelGraphView implements GraphViewNotifier {
    private static final int CNT_X_SMALL_2 = 16;
    private static final int CNT_X_SMALL_5 = 18;
    private static final int CNT_X_LARGE = 24;
    private static final int THICKNESS_INVISIBLE = 0;

    private final WiFiBand wiFiBand;
    private final Pair<WiFiChannel, WiFiChannel> wiFiChannelPair;
    private GraphViewWrapper graphViewWrapper;

    ChannelGraphView(@NonNull WiFiBand wiFiBand, @NonNull Pair<WiFiChannel, WiFiChannel> wiFiChannelPair) {
        this.wiFiBand = wiFiBand;
        this.wiFiChannelPair = wiFiChannelPair;
        this.graphViewWrapper = makeGraphViewWrapper();
    }

    @Override
    public void update(@NonNull WiFiData wiFiData) {
        Settings settings = MainContext.INSTANCE.getSettings();
        GraphLegend channelGraphLegend = settings.getChannelGraphLegend();
        SortBy sortBy = settings.getSortBy();
        Set<WiFiDetail> newSeries = new TreeSet<>();
        for (WiFiDetail wiFiDetail : wiFiData.getWiFiDetails(wiFiBand, sortBy)) {
            if (isInRange(wiFiDetail.getWiFiSignal().getCenterFrequency(), wiFiChannelPair)) {
                newSeries.add(wiFiDetail);
                addData(wiFiDetail);
            }
        }
        graphViewWrapper.removeSeries(newSeries);
        graphViewWrapper.updateLegend(channelGraphLegend);
        graphViewWrapper.setVisibility(isSelected() ? View.VISIBLE : View.GONE);
    }

    private boolean isInRange(int frequency, Pair<WiFiChannel, WiFiChannel> wiFiChannelPair) {
        return frequency >= wiFiChannelPair.first.getFrequency() && frequency <= wiFiChannelPair.second.getFrequency();
    }

    private boolean isSelected() {
        Settings settings = MainContext.INSTANCE.getSettings();
        WiFiBand wiFiBand = settings.getWiFiBand();
        Configuration configuration = MainContext.INSTANCE.getConfiguration();
        Pair<WiFiChannel, WiFiChannel> wiFiChannelPair = configuration.getWiFiChannelPair();
        return this.wiFiBand.equals(wiFiBand) && (WiFiBand.GHZ2.equals(this.wiFiBand) || this.wiFiChannelPair.equals(wiFiChannelPair));
    }

    private void addData(@NonNull WiFiDetail wiFiDetail) {
        DataPoint[] dataPoints = createDataPoints(wiFiDetail);
        TitleLineGraphSeries<DataPoint> series = new TitleLineGraphSeries<>(dataPoints);
        if (graphViewWrapper.addSeries(wiFiDetail, series, dataPoints)) {
            GraphColor graphColor = graphViewWrapper.getColor();
            series.setColor((int) graphColor.getPrimary());
            series.setBackgroundColor((int) graphColor.getBackground());
        }
    }

    private DataPoint[] createDataPoints(@NonNull WiFiDetail wiFiDetail) {
        WiFiChannels wiFiChannels = wiFiBand.getWiFiChannels();
        int frequencySpread = wiFiChannels.getFrequencySpread();
        WiFiSignal wiFiSignal = wiFiDetail.getWiFiSignal();
        int frequency = wiFiSignal.getCenterFrequency();
        int frequencyStart = wiFiSignal.getFrequencyStart();
        int frequencyEnd = wiFiSignal.getFrequencyEnd();
        int level = wiFiSignal.getLevel();
        return new DataPoint[]{
            new DataPoint(frequencyStart, GraphViewBuilder.MIN_Y),
            new DataPoint(frequencyStart + frequencySpread, level),
            new DataPoint(frequency, level),
            new DataPoint(frequencyEnd - frequencySpread, level),
            new DataPoint(frequencyEnd, GraphViewBuilder.MIN_Y)
        };
    }

    @Override
    public GraphView getGraphView() {
        return graphViewWrapper.getGraphView();
    }

    private int getNumX() {
        int numX = CNT_X_LARGE;
        Configuration configuration = MainContext.INSTANCE.getConfiguration();
        if (!configuration.isLargeScreenLayout()) {
            numX = WiFiBand.GHZ2.equals(wiFiBand) ? CNT_X_SMALL_2 : CNT_X_SMALL_5;
        }
        WiFiChannels wiFiChannels = wiFiBand.getWiFiChannels();
        int channelFirst = wiFiChannelPair.first.getChannel() - wiFiChannels.getChannelOffset();
        int channelLast = wiFiChannelPair.second.getChannel() + wiFiChannels.getChannelOffset();
        return Math.min(numX, channelLast - channelFirst + 1);
    }

    private GraphView makeGraphView() {
        Resources resources = MainContext.INSTANCE.getResources();
        MainActivity mainActivity = MainContext.INSTANCE.getMainActivity();
        return new GraphViewBuilder(mainActivity, getNumX())
            .setLabelFormatter(new ChannelAxisLabel(wiFiBand, wiFiChannelPair))
            .setVerticalTitle(resources.getString(R.string.graph_axis_y))
            .setHorizontalTitle(resources.getString(R.string.graph_channel_axis_x))
            .build();
    }

    private GraphViewWrapper makeGraphViewWrapper() {
        Settings settings = MainContext.INSTANCE.getSettings();
        graphViewWrapper = new GraphViewWrapper(makeGraphView(), settings.getChannelGraphLegend());

        WiFiChannels wiFiChannels = wiFiBand.getWiFiChannels();
        int frequencyOffset = wiFiChannels.getFrequencyOffset();
        int minX = wiFiChannelPair.first.getFrequency() - frequencyOffset;
        int maxX = minX + (graphViewWrapper.getViewportCntX() * wiFiChannels.getFrequencySpread());
        graphViewWrapper.setViewport(minX, maxX);

        DataPoint[] dataPoints = new DataPoint[]{
            new DataPoint(minX, GraphViewBuilder.MIN_Y),
            new DataPoint(wiFiChannelPair.second.getFrequency() + frequencyOffset, GraphViewBuilder.MIN_Y)
        };

        TitleLineGraphSeries<DataPoint> series = new TitleLineGraphSeries<>(dataPoints);
        series.setColor((int) GraphColor.TRANSPARENT.getPrimary());
        series.setThickness(THICKNESS_INVISIBLE);
        graphViewWrapper.addSeries(series);
        return graphViewWrapper;
    }

    void setGraphViewWrapper(@NonNull GraphViewWrapper graphViewWrapper) {
        this.graphViewWrapper = graphViewWrapper;
    }

}
