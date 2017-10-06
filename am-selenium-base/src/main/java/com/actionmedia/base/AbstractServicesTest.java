package com.actionmedia.base;

import com.actionmedia.autotest.event.postpone.failure.PostponedFailureEvent;
import com.actionmedia.autotest.event.postpone.failure.StorePostponeFailureSubscriber;
import com.actionmedia.autotest.listeners.ReportTestInvocationListener;
import com.actionmedia.autotest.listeners.ServicesMailSenderListener;
import com.actionmedia.autotest.listeners.ServicesPostponedFailureListener;
import com.actionmedia.autotest.selenium.context.ErrorSender;
import com.actionmedia.autotest.spring.SeleniumSettings;
import com.actionmedia.util.TestUtils;
import com.actionmedia.webservice.NodeElement;
import com.actionmedia.webservice.buhonline.BuhonlineLocator;
import com.actionmedia.webservice.buhonline.BuhonlineSoap_PortType;
import com.actionmedia.webservice.currency.CurrencyServiceLocator;
import com.actionmedia.webservice.currency.ICurrencyService;
import com.actionmedia.webservice.eventservice.WsEventProcessorLocator;
import com.actionmedia.webservice.eventservice.WsEventProcessorSoap_PortType;
import com.actionmedia.webservice.exportnpdservice.BSSExportServiceLocator;
import com.actionmedia.webservice.exportnpdservice.BSSExportServiceSoap_PortType;
import com.actionmedia.webservice.glavbuch.GlavbukhLocator;
import com.actionmedia.webservice.glavbuch.GlavbukhSoap_PortType;
import com.actionmedia.webservice.searchextendedservice.SearchExtendedLocator;
import com.actionmedia.webservice.searchextendedservice.SearchExtendedSoap_PortType;
import com.actionmedia.webservice.searchservice.ISearchService;
import com.actionmedia.webservice.searchservice.SearchServiceLocator;
import org.apache.axis.client.Stub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import ru.yandex.qatools.allure.annotations.Step;

import javax.xml.rpc.ServiceException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * User: n.tyukavkin
 * Date: 23.12.13
 * Time: 17:04
 */
@ContextConfiguration(locations = {
        "classpath*:/META-INF/spring/context-selenium.xml",
        "classpath*:/META-INF/spring/mail.xml"})
@Listeners({
        ReportTestInvocationListener.class,
        ServicesPostponedFailureListener.class,
        ServicesMailSenderListener.class
})
public class AbstractServicesTest extends AbstractTestNGSpringContextTests implements ErrorSender {

    @Autowired
    private PostponedFailureEvent postponeFailureEvent;

    @Autowired
    private SeleniumSettings settings;

    @Qualifier("mailProperties")
    @Autowired
    private Properties mailProperties;

    @BeforeMethod(alwaysRun = true)
    public final void beforeMethod(final Method test, final Object[] params, final ITestContext context) {
        postponeFailureEvent.subscribe(new StorePostponeFailureSubscriber(test, params, context));
    }

    @BeforeMethod(alwaysRun = true)
    public final void setMailProperties(final ITestContext context) {
        context.setAttribute("mailProperties", mailProperties);
    }

    @AfterMethod(alwaysRun = true)
    public final void afterMethod() {
        postponeFailureEvent.unsubscribeAll();
    }

    public synchronized ISearchService getSearchService() {
        ISearchService searchService = null;
        try {
            SearchServiceLocator locator = new SearchServiceLocator();
            locator.setBasicHttpBinding_ISearchServiceEndpointAddress(settings.getSearchServiceUrl());
            locator.setBasicHttpBinding_ISearchServiceEndpointAddress(settings.getSearchServiceUrl());
            searchService = locator.getBasicHttpBinding_ISearchService();
        } catch (ServiceException e) {
            logger.error("ServiceException occurs", e);
        }
        return searchService;
    }

    public synchronized GlavbukhSoap_PortType getGlavbukhService() {
        GlavbukhSoap_PortType glavbukhService = null;
        try {
            GlavbukhLocator locator = new GlavbukhLocator();
            locator.setGlavbukhSoapEndpointAddress(settings.getGlavbukhServiceUrl());
            locator.setGlavbukhSoap12EndpointAddress(settings.getGlavbukhServiceUrl());
            glavbukhService = locator.getGlavbukhSoap();
        } catch (ServiceException e) {
            logger.error("ServiceException occurs", e);
        }
        return glavbukhService;
    }

    public synchronized SearchExtendedSoap_PortType getSearchExtendedService(String system) {
        SearchExtendedSoap_PortType searchExtendedService = null;
        try {
            SearchExtendedLocator locator = new SearchExtendedLocator();
            locator.setSearchExtendedSoapEndpointAddress(settings.getSearchExtendedServiceUrl(system));
            locator.setSearchExtendedSoap12EndpointAddress(settings.getSearchExtendedServiceUrl(system));
            searchExtendedService = locator.getSearchExtendedSoap();
        } catch (ServiceException e) {
            logger.error("ServiceException occurs", e);
        }
        return searchExtendedService;
    }

    public synchronized WsEventProcessorSoap_PortType getEventProcessorService() {
        WsEventProcessorSoap_PortType eventProcessorService = null;
        try {
            WsEventProcessorLocator locator = new WsEventProcessorLocator();
            eventProcessorService = locator.getWsEventProcessorSoap();
        } catch (ServiceException e) {
            logger.error("ServiceException occurs", e);
        }
        return eventProcessorService;
    }

    public synchronized BSSExportServiceSoap_PortType getExportNPDService() {
        BSSExportServiceSoap_PortType exportNPDService = null;
        try {
            BSSExportServiceLocator locator = new BSSExportServiceLocator();
            locator.setBSSExportServiceSoapEndpointAddress(settings.getExportNPDServiceUrl());
            locator.setBSSExportServiceSoap12EndpointAddress(settings.getExportNPDServiceUrl());
            locator.getEngine().setOption("sendMultiRefs", false);
            exportNPDService = locator.getBSSExportServiceSoap();
            org.apache.axis.client.Stub stub = (Stub) exportNPDService;
            stub.setTimeout(60000);
            stub.getTimeout();
        } catch (ServiceException e) {
            logger.error("ServiceException occurs", e);
        }
        return exportNPDService;
    }

    public synchronized BuhonlineSoap_PortType getBuhOnlineService() {
        BuhonlineSoap_PortType buhonlineService = null;
        try {
            BuhonlineLocator locator = new BuhonlineLocator();
            locator.setBuhonlineSoapEndpointAddress(settings.getBuhOnLineServiceUrl());
            locator.setBuhonlineSoap12EndpointAddress(settings.getBuhOnLineServiceUrl());
            buhonlineService = locator.getBuhonlineSoap();
        } catch (ServiceException e) {
            logger.error("ServiceException occurs", e);
        }
        return buhonlineService;
    }

    public synchronized ICurrencyService getCurrencyService(String serviceUrl) {
        ICurrencyService currencyService = null;
        try {
            CurrencyServiceLocator locator = new CurrencyServiceLocator();
            locator.setBasicHttpBinding_ICurrencyServiceEndpointAddress(serviceUrl);
            currencyService = locator.getBasicHttpBinding_ICurrencyService();
        } catch (ServiceException e) {
            logger.error("ServiceException occurs", e);
        }
        return currencyService;
    }

    public void setPostponedTestFail(final String message) {
        postponeFailureEvent.fire(message);
    }

    protected void assertNull(Object object, String errorMessage) {
        try {
            Assert.assertNull(object, errorMessage);
        } catch (AssertionError e) {
            logger.error("AssertionError occurs", e);
            fail(e.getMessage());
        }
    }

    protected void assertNotNull(Object object, String errorMessage) {
        try {
            Assert.assertNotNull(object, errorMessage);
        } catch (AssertionError e) {
            logger.error("AssertionError occurs", e);
            fail(e.getMessage());
        }
    }

    protected void assertTrue(boolean condition, String errorMessage) {
        try {
            Assert.assertTrue(condition, errorMessage);
        } catch (AssertionError e) {
            logger.error("AssertionError occurs", e);
            fail(e.getMessage());
        }
    }

    protected void assertFalse(boolean condition, String errorMessage) {
        try {
            Assert.assertFalse(condition, errorMessage);
        } catch (AssertionError e) {
            logger.error("AssertionError occurs", e);
            fail(e.getMessage());
        }
    }

    protected void assertEquals(Object actual, Object expected, String errorMessage) {
        try {
            Assert.assertEquals(actual, expected, errorMessage);
        } catch (AssertionError e) {
            logger.error("AssertionError occurs", e);
            fail(e.getMessage());
        }
    }

    protected void assertNotEquals(Object actual, Object expected, String errorMessage) {
        try {
            Assert.assertNotEquals(actual, expected, errorMessage);
        } catch (AssertionError e) {
            logger.error("AssertionError occurs", e);
            fail(e.getMessage());
        }
    }

    protected void assertContains(String actual, String expected, String errorMessage) {
        try {
            Assert.assertTrue(expected.contains(actual), errorMessage);
        } catch (AssertionError e) {
            logger.error("AssertionError occurs", e);
            fail(e.getMessage());
        }
    }

    protected void postponedAssertNotNull(Object object, String errorMessage) {
        try {
            Assert.assertNotNull(object, errorMessage);
        } catch (AssertionError e) {
            logger.info("AssertionError occurs");
            setPostponedTestFail(e.getMessage());
        }
    }

    protected void postponedAssertNull(Object object, String errorMessage) {
        try {
            Assert.assertNull(object, (errorMessage));
        } catch (AssertionError e) {
            logger.info("AssertionError occurs");
            setPostponedTestFail(e.getMessage());
        }
    }

    protected void postponedAssertTrue(boolean condition, String errorMessage) {
        try {
            Assert.assertTrue(condition, errorMessage);
        } catch (AssertionError e) {
            logger.info("AssertionError occurs");
            setPostponedTestFail(e.getMessage());
        }
    }

    protected void postponedAssertFalse(boolean condition, String errorMessage) {
        try {
            Assert.assertFalse(condition, errorMessage);
        } catch (AssertionError e) {
            logger.info("AssertionError occurs");
            setPostponedTestFail(e.getMessage());
        }
    }

    protected void postponedAssertEquals(Object actual, Object expected, String errorMessage) {
        try {
            Assert.assertEquals(actual, expected, errorMessage);
        } catch (AssertionError e) {
            logger.info("AssertionError occurs");
            setPostponedTestFail(e.getMessage());
        }
    }

    @Step("{0}")
    protected final void fail(final String errorMessage) {
        report(errorMessage);
        throw new AssertionError(errorMessage);
    }

    @Step("{0}")
    protected final void fail(final String errorMessage, Throwable cause) {
        report(errorMessage + cause.getMessage());
        throw new Error(errorMessage + cause.getMessage(), cause);
    }

    @Step("{0}")
    public void report(final String message) {
        Reporter.log(message);
    }

    @Step("{0}")
    public void error(final String message) {
        report("ERROR: " + message);
    }

    @Step("{0}")
    public void warning(final String message) {
        report("Warning: " + message);
    }

    @Step("{0}")
    public void success(final String message) {
        report("SUCCESS: " + message);
    }

    public void checkTagIsPresent(String methodName, String tagName, List<NodeElement> nodeElementList) {
        postponedAssertTrue(!nodeElementList.isEmpty(), "Неправильный формат ответного xml для метода '" + methodName + "'. Отсутствует тэг '" + tagName + "'");
    }

    public void checkValueIsNotEmpty(String methodName, List<NodeElement> nodeElementList) {
        for (NodeElement nodeElement : nodeElementList) {
            if (nodeElement.getName() != null && nodeElement.getValue() != null) {
                postponedAssertTrue(!nodeElement.getValue().isEmpty(), "Неправильный формат ответного xml для метода '" + methodName + "'. Отсутствует значение для тэга '" + nodeElement.getName() + "'");
            } else {
                setPostponedTestFail("Неправильный формат ответного xml для метода '" + methodName + "'. Отсутствует значение для тэга '" + nodeElement.getName() + "'");
            }
        }
    }

    public void checkAttributeValue(String name, String value, Map<String, String> attribute, String methodName) {
        postponedAssertEquals(attribute.get(name), value, "Неверный формат ответного xml для метода '" + methodName + "'. Неверное значение для свойства '" + name + "'");
    }

    public void checkAttributeIsPresent(String name, Map<String, String> attribute, String methodName) {
        String value = attribute.get(name);
        if (value != null) {
            postponedAssertTrue(!value.isEmpty(), "Неверный формат ответного xml для метода '" + methodName + "'. Значение для свойства '" + name + "' пустое");
        } else {
            setPostponedTestFail("Неверный формат ответного xml для метода '" + methodName + "'. Отсутствует свойство '" + name + "'");
        }
    }

    public void checkIntValue(Integer value, String methodName, String valueName) {
        try {
            postponedAssertNotNull(value, "Неправильный формат ответного xml для метода '" + methodName + "'. Отсутствует тэг '" + valueName + "'");
            if (value != null) {
                Integer.valueOf(value);
            }
        } catch (NumberFormatException e) {
            setPostponedTestFail("Неправильный формат ответного xml для метода '" + methodName + "'. Неправильный формат значения в тэге '" + valueName + "'");
        }
    }

    public void checkStringValue(String value, String methodName, String valueName) {
        postponedAssertNotNull(value, "Неправильный формат ответного xml для метода '" + methodName + "'. Отсутствует тэг '" + valueName + "'");
        postponedAssertTrue(!value.isEmpty(), "Неправильный формат ответного xml для метода '" + methodName + "'. Отсутствует значение для тэга '" + valueName + "'");
    }

    public Calendar getCalendarByDateString(String dateString, String pattern) {
        Date date = TestUtils.parseDate(dateString, pattern);
        Calendar calendar = Calendar.getInstance(new Locale("ru"));
        calendar.setTime(date);
        return calendar;
    }

    public String convertArrayToString(int[] array) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(String.valueOf(array[i]));
            if (i == array.length - 1) {
                builder.append("");
            } else {
                builder.append(", ");
            }
        }
        return builder.toString();
    }

    public String convertArrayToString(String[] array) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(String.valueOf(array[i]));
            if (i == array.length - 1) {
                builder.append("");
            } else {
                builder.append(", ");
            }
        }
        return builder.toString();
    }

    public SeleniumSettings getSettings() {
        return settings;
    }

    public static void log(final String message) {
        Reporter.log(message);
        System.out.println(message);
    }

    private void waitForSomeSeconds() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
