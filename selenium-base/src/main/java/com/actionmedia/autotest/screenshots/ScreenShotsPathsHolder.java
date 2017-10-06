package com.actionmedia.autotest.screenshots;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ScreenShotsPathsHolder {
    private static ThreadLocal<Map<String, List<ScreenshotInfo>>> pathsHolder = new ThreadLocal<Map<String, List<ScreenshotInfo>>>(){
        @Override
        protected Map<String, List<ScreenshotInfo>> initialValue() {
            return new HashMap<String, List<ScreenshotInfo>>();
        }
    };

    private ScreenShotsPathsHolder() {
    }

    public static void addScreenShotPathForTest(final String testName, final String path, final String message) {
        List<ScreenshotInfo> screenshotsInfo;
        if (pathsHolder.get().containsKey(testName)) {
            screenshotsInfo = pathsHolder.get().get(testName);
        } else {
            screenshotsInfo = new ArrayList<ScreenshotInfo>();
            pathsHolder.get().put(testName, screenshotsInfo);
        }

        screenshotsInfo.add(new ScreenshotInfo(path, message));
    }

    public static List<ScreenshotInfo> getScreenShotPathsForTest(final String testName) {
        return getScreenShotInfoList(testName);
    }

    private static List<ScreenshotInfo> getScreenShotInfoList(final String testName) {
        List<ScreenshotInfo> screenShotInfoList = new ArrayList<ScreenshotInfo>();
        for (Map.Entry<String, List<ScreenshotInfo>> entry : pathsHolder.get().entrySet()) {
            if (testName.contains(entry.getKey().split("test.")[0])) {
                screenShotInfoList.addAll(entry.getValue());
            }
        }
        return screenShotInfoList;
    }

    public static void clear(){
        pathsHolder.get().clear();
    }
}
