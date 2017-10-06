package com.actionmedia.autotest.selenium.context;

import com.actionmedia.autotest.selenium.ext.FindOrWaitElementLocator;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.internal.WrapsElement;
import org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.concurrent.TimeUnit;

public abstract class AbstractComponent<P extends AbstractComponent> extends AbstractPageElement<P> implements IComponent {
    private final Log logger = LogFactory.getLog(getClass());

    private ComponentProvider componentProvider;

    public ComponentProvider getComponentProvider() {
        return componentProvider;
    }

    public void setComponentProvider(final ComponentProvider componentProviderParameter) {
        this.componentProvider = componentProviderParameter;
    }

    protected void initWebElementField(final String fieldName, final By locator) {
        try {
            final Field field = getClass().getDeclaredField(fieldName);
            final InvocationHandler handler = new LocatingElementHandler(new FindOrWaitElementLocator(getDriver(), locator, field, getTimeout().intValue(), TimeUnit.SECONDS));
            field.setAccessible(true);
            field.set(this, Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{WebElement.class, WrapsElement.class, Locatable.class}, handler));
        } catch (NoSuchFieldException e) {
            logger.error("NoSuchFieldException occurs", e);
            fail("Unable to find field");
        } catch (IllegalAccessException e) {
            logger.error("IllegalAccessException occurs", e);
            fail("Unable to init field");
        }
    }
}
