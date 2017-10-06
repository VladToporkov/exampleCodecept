package com.actionmedia.autotest.screenshots;

public class ScreenshotInfo {
    private String path;
    private String message;

    public ScreenshotInfo(final String path, final String message) {
        this.message = message;
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }
}
