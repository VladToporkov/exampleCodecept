package com.actionmedia.tests.experimental.loadsitetests;

import org.joda.time.DateTime;

/**
 * User: n.tyukavkin
 * Date: 07.12.2014
 * Time: 19:15
 */
public class RunResult {

    private String url;
    private int numberOfRun;
    private DateTime startTime;
    private DateTime endTime;
    private String errorMessage;

    public RunResult(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public int getNumberOfRun() {
        return numberOfRun;
    }

    public double getTime() {
        return (double) (endTime.getMillis() - startTime.getMillis()) / 1000;
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setNumberOfRun(int numberOfRun) {
        this.numberOfRun = numberOfRun;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(DateTime endTime) {
        this.endTime = endTime;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
