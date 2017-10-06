package com.actionmedia.autotest.selenium.context;

public interface IComponent extends IPageElement {
    ComponentProvider getComponentProvider();

    void setComponentProvider(ComponentProvider componentProvider);
}
