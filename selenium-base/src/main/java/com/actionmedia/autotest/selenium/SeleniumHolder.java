package com.actionmedia.autotest.selenium;

import com.actionmedia.autotest.utils.Pair;
import com.actionmedia.autotest.utils.SystemPubs;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public final class SeleniumHolder {

    /**
     * private constructor for utils class
     */
    private SeleniumHolder() {
    }

    private static final ThreadLocal<WebDriver> driverHolder = new ThreadLocal<WebDriver>();
    private static final ThreadLocal<String> driverName = new ThreadLocal<String>();
    private static final ThreadLocal<String> parameterBrowserName = new ThreadLocal<String>();
    //    private static final ThreadLocal<BrowserMobProxy> server = new ThreadLocal<BrowserMobProxy>();
    private static final ThreadLocal<Pair<SystemPubs, List<String>>> docUrls = new ThreadLocal<Pair<SystemPubs, List<String>>>();
    private static final ThreadLocal<Pair<SystemPubs, Map<String, List<String>>>> docUrlsMap = new ThreadLocal<Pair<SystemPubs, Map<String, List<String>>>>();
    private static String host;

    public static WebDriver getWebDriver() {
        return driverHolder.get();
    }

    public static void setWebDriver(final WebDriver value) {
        driverHolder.set(value);
    }

    public static String getDriverName() {
        return driverName.get();
    }

    public static void setDriverName(String value) {
        driverName.set(value);
    }

//    public static BrowserMobProxy getServer() {
//        return server.get();
//    }
//
//    public static void setServer(BrowserMobProxy value) {
//        server.set(value);
//    }

    public static String getHost() {
        return host;
    }

    public static void setHost(String host) {
        SeleniumHolder.host = host;
    }

    public static void setDocUrls(Pair<SystemPubs, List<String>> pair) {
        docUrls.set(pair);
    }

    public static ThreadLocal<Pair<SystemPubs, List<String>>> getDocUrls() {
        return docUrls;
    }

    public static void setDocUrlsMap(Pair<SystemPubs, Map<String, List<String>>> pair) {
        docUrlsMap.set(pair);
    }

    public static ThreadLocal<Pair<SystemPubs, Map<String, List<String>>>> getDocUrlsMap() {
        return docUrlsMap;
    }

    public static String getParameterBrowserName() {
        return parameterBrowserName.get();
    }

    public static void setParameterBrowserName(String browserName) {
        parameterBrowserName.set(browserName);
    }
}
