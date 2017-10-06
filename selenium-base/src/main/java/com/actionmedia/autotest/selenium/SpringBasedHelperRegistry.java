package com.actionmedia.autotest.selenium;

import com.actionmedia.autotest.selenium.context.HelperRegistry;
import com.actionmedia.autotest.selenium.context.IComponent;
import com.actionmedia.autotest.selenium.context.IPage;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringBasedHelperRegistry implements HelperRegistry, ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public <E extends IPage> E getPageHelper(final Class<E> helperClass) {
        for (Object bean : applicationContext.getBeansOfType(helperClass).values()) {
            if (bean.getClass() == helperClass) {
                return (E) bean;
            }
        }
        return null;
    }

    @Override
    public <E extends IComponent> E getComponentHelper(final Class<E> helperClass) {
        return applicationContext.getBean(helperClass);
    }

    @Override
    public <E> E getBean(Class<E> beanClass) {
        return applicationContext.getBean(beanClass);
    }

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
