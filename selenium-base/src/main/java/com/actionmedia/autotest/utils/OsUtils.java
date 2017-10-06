package com.actionmedia.autotest.utils;

/**
 * Created by popovpavel on 09/09/16.
 */
public class OsUtils {

    private static String OS = null;

    public static String getOsName() {
        if(OS == null) { OS = System.getProperty("os.name"); }
        return OS;
    }

    public static boolean isWindows() {
        return getOsName().startsWith("Windows");
    }

    public static boolean isMac() {
        return getOsName().startsWith("Mac");
    }
}
