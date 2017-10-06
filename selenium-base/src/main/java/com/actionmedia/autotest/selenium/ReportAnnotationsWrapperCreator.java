package com.actionmedia.autotest.selenium;

import com.actionmedia.autotest.selenium.annotations.Report;
import com.actionmedia.autotest.selenium.context.AbstractPageElement;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public final class ReportAnnotationsWrapperCreator {

    /**
     * private constructor for utils class
     */
    private ReportAnnotationsWrapperCreator() {
    }

    @SuppressWarnings("unchecked")
    public static <T> T getReportingProxy(Class<T> klass, T original) {
        return (T) Enhancer.create(klass, new ReportingMethodInterceptor<T>(original));
    }

    private static final class ReportingMethodInterceptor<T> implements MethodInterceptor {

        private T original;

        private ReportingMethodInterceptor(T original) {
            this.original = original;
        }

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            if (method.isAnnotationPresent(Report.class) &&
                    original instanceof AbstractPageElement) {
                String reportMessage = method.getAnnotation(Report.class).value();
                ((AbstractPageElement) original).report(reportMessage);
            }
            Object result = methodProxy.invoke(original, objects);
            if (result == original) {
                return o;
            }
            return result;
        }
    }
}
