package com.actionmedia.autotest.selenium.ext.internal;

import com.actionmedia.autotest.selenium.elements.Element;
import com.actionmedia.autotest.selenium.ext.ElementFactory;
import com.actionmedia.autotest.selenium.ext.ExtendedElementException;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebElement;

import java.lang.reflect.InvocationTargetException;

import static java.text.MessageFormat.format;

public class DefaultElementFactory implements ElementFactory {

    private final Log logger = LogFactory.getLog(getClass());

    @Override
    public <T extends Element> T create(final Class<T> classOfElement, final WebElement wrappedElement) {
        try {
            return findImplementationFor(classOfElement).getDeclaredConstructor(WebElement.class).newInstance(wrappedElement);
        } catch (InstantiationException e) {
            logger.error("InstantiationException occurs", e);
            throw new ExtendedElementException("InstantiationException is happened! " + e);
        } catch (IllegalAccessException e) {
            logger.error("IllegalAccessException occurs", e);
            throw new ExtendedElementException("IllegalAccessException is happened! " + e);
        } catch (InvocationTargetException e) {
            logger.error("InvocationTargetException occurs", e);
            throw new ExtendedElementException("InvocationTargetException is happened! " + e);
        } catch (NoSuchMethodException e) {
            logger.error("NoSuchMethodException occurs", e);
            throw new ExtendedElementException("NoSuchMethodException is happened! " + e);
        }
    }

    private <T extends Element> Class<T> findImplementationFor(final Class<T> classOfElement) {
        try {
            return (Class<T>) Class.forName(format("{0}.{1}Impl", getClass().getPackage().getName(), classOfElement.getSimpleName()));
        } catch (ClassNotFoundException e) {
            logger.error("ClassNotFoundException occurs", e);
            throw new ExtendedElementException("ClassNotFoundException is happened! " + e);
        }
    }
}
