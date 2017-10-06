package com.actionmedia.components;

/**
 * User: n.tyukavkin
 * Date: 11.09.13
 * Time: 18:26
 */
public class Link {

    private String url;
    private String header;
    private String locator;

    public Link(String url, String header) {
        this.url = url;
        this.header = header;
        this.locator = url;
    }

    public Link(String url) {
        this.url = url;
        this.locator = url;
    }

    public String getUrl() {
        return url;
    }

    public String getHeader() {
        return header;
    }

    public String getLocator() {
        return locator;
    }
}
