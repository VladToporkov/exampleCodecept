package com.actionmedia.autotest.selenium.ext;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;

import static java.util.concurrent.TimeUnit.SECONDS;

public class FindOrWaitElementLocatorFactory implements ElementLocatorFactory {
    private final SearchContext context;

    public FindOrWaitElementLocatorFactory(final SearchContext context) {
        this.context = context;
    }


    @Override
    public ElementLocator createLocator(final Field field) {
        return new FindOrWaitElementLocator(context, field, 10, SECONDS);
    }
}
