package com.actionmedia.autotest.selenium.driver;

import com.google.common.base.Function;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.internal.WrapsElement;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static com.google.common.collect.Collections2.transform;
import static java.lang.reflect.Proxy.newProxyInstance;
import static org.testng.collections.Lists.newArrayList;

/**
 * This class is used to replace original WebElement behavior
 * to ease work with element from different frames.
 */
public class FrameAwareWebElementTransformer1 implements Function<WebElement, WebElement> {
    private static final String CLICK = "click";
    private final WebDriver driver;

    public FrameAwareWebElementTransformer1(final WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public WebElement apply(final WebElement element) {
        return (WebElement) newProxyInstance(
                getClass().getClassLoader(),
                new Class[]{WebElement.class, WrapsElement.class, Locatable.class},
                invocationHandlerFor(element)
        );
    }

    private InvocationHandler invocationHandlerFor(final WebElement element) {
        return new FrameAwareWebElementMethodInvocationHandler(element, driver);
    }

    private static class FrameAwareWebElementMethodInvocationHandler implements InvocationHandler {
        private final WebElement element;
        private final WebDriver driver;


        public FrameAwareWebElementMethodInvocationHandler(final WebElement element,
                                                           final WebDriver driver) {
            this.element = element;
            this.driver = driver;

        }

        @Override
        public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
            final String methodName = method.getName();
            if ("getWrappedElement".equals(methodName)) {
                return element;
            }
            if ("findElement".equals(methodName)) {
                final WebElement found = (WebElement) method.invoke(element, args);
                return transformerToFramesAwareWebElement().apply(found);
            }
            if ("findElements".equals(methodName)) {
                final List<WebElement> found = (List<WebElement>) method.invoke(element, args);
                return newArrayList(transform(found, transformerToFramesAwareWebElement()));
            }
            try {
                return method.invoke(element, args);
            } catch (InvocationTargetException e) {
                throw e.getCause();
            }
        }

        private FrameAwareWebElementTransformer1 transformerToFramesAwareWebElement() {
            return new FrameAwareWebElementTransformer1(driver);
        }
    }
}
