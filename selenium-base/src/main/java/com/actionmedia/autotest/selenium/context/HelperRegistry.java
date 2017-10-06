package com.actionmedia.autotest.selenium.context;

public interface HelperRegistry {
    <E extends IPage> E getPageHelper(Class<E> helperClass);

    <E extends IComponent> E getComponentHelper(Class<E> helperClass);

    <E> E getBean(Class<E> beanClass);
}
