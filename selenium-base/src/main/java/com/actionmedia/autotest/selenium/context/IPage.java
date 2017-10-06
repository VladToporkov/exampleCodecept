package com.actionmedia.autotest.selenium.context;

public interface IPage extends IPageElement {
    void load();

    void load(String path);
}
