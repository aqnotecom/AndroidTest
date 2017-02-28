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

package com.aqnote.app.wifianalyzer;

import android.content.Context;
import android.content.res.Resources;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;

import com.aqnote.app.wifianalyzer.settings.Settings;
import com.aqnote.app.wifianalyzer.vendor.model.Database;
import com.aqnote.app.wifianalyzer.vendor.model.VendorService;
import com.aqnote.app.wifianalyzer.wifi.scanner.Scanner;

public enum MainContext {
    INSTANCE;

    private Settings settings;
    private MainActivity mainActivity;
    private Resources resources;
    private Scanner scanner;
    private VendorService vendorService;
    private LayoutInflater layoutInflater;
    private Database database;
    private Logger logger;
    private Configuration configuration;

    public Settings getSettings() {
        return settings;
    }

    void setSettings(Settings settings) {
        this.settings = settings;
    }

    public VendorService getVendorService() {
        return vendorService;
    }

    void setVendorService(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    public Scanner getScanner() {
        return scanner;
    }

    void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public LayoutInflater getLayoutInflater() {
        return layoutInflater;
    }

    void setLayoutInflater(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    public Database getDatabase() {
        return database;
    }

    void setDatabase(Database database) {
        this.database = database;
    }

    public Resources getResources() {
        return resources;
    }

    void setResources(Resources resources) {
        this.resources = resources;
    }

    public MainActivity getMainActivity() {
        return mainActivity;
    }

    void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public Logger getLogger() {
        return logger;
    }

    void setLogger(Logger logger) {
        this.logger = logger;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    void initialize(@NonNull MainActivity mainActivity, boolean isLargeScreenLayout, boolean isDevelopment) {
        WifiManager wifiManager = (WifiManager) mainActivity.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        Handler handler = new Handler();
        Settings settings = new Settings(mainActivity);
        Configuration configuration = new Configuration(isLargeScreenLayout, isDevelopment);

        setMainActivity(mainActivity);
        setConfiguration(configuration);
        setResources(mainActivity.getResources());
        setDatabase(new Database(mainActivity));
        setSettings(settings);
        setVendorService(new VendorService());
        setLayoutInflater((LayoutInflater) mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
        setLogger(new Logger());
        setScanner(new Scanner(wifiManager, handler, settings));
    }
}
