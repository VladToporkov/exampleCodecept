package com.actionmedia.tests.services.glavbuchservice;

import com.actionmedia.base.AbstractServicesTest;
import com.actionmedia.webservice.MessageElementConverter;
import com.actionmedia.webservice.NodeElement;
import com.actionmedia.webservice.ServiceResponse;
import org.apache.axis.message.MessageElement;
import org.apache.axis.types.UnsignedByte;
import org.testng.annotations.Test;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import static com.actionmedia.autotest.Group.glavbukh;
import static com.actionmedia.autotest.Group.service;

/**
 * User: n.tyukavkin
 * Date: 21.01.14
 * Time: 18:23
 */
public class Tab extends AbstractServicesTest {

    private static final String METHOD_NAME = "Tab";

    @Test(groups = {glavbukh, service})
    public void tab_test() {
        UnsignedByte pubDivId = new UnsignedByte(1);
        int period = 30;
        Calendar date = Calendar.getInstance(new Locale("ru"));

        report("Тест для проверки метода '" + METHOD_NAME + "'");
        report("URL: " + getSettings().getGlavbukhServiceUrl());
        report("pubDivId - " + pubDivId);
        report("period - " + pubDivId);
        report("date - " + date.getTime().toString());

        try {
            MessageElement messageElement = getGlavbukhService().tab(pubDivId, period, date).get_any()[0];
            ServiceResponse response = new MessageElementConverter(messageElement).getResponse();

            if (getSettings().isRunBss()) {
                checkForBss(response);
            } else if (getSettings().isRunKss()) {
                checkForKss(response);
            } else if (getSettings().isRunUss()) {
                checkForUss(response);
            } else if (getSettings().isRunFss()) {
                checkForFss(response);
            }
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }

    private void checkForBss(ServiceResponse response) {
        List<NodeElement> pubTagList = response.getNodeElementListByName("pub");
        List<NodeElement> pubDivListTagList = response.getNodeElementListByName("pubDivList");
        List<NodeElement> ratesNewspaperTagList = response.getNodeElementListByName("rates");

        checkTagIsPresent(METHOD_NAME, "pub", pubTagList);
        checkTagIsPresent(METHOD_NAME, "pubDivList", pubDivListTagList);
        checkTagIsPresent(METHOD_NAME, "rates", ratesNewspaperTagList);
    }

    private void checkForKss(ServiceResponse response) {
        List<NodeElement> pubTagList = response.getNodeElementListByName("pub");
        List<NodeElement> pubDivListTagList = response.getNodeElementListByName("pubDivList");
        List<NodeElement> widgetAnswerOfDayTagList = response.getNodeElementListByName("widgetAnswerOfDay");
        List<NodeElement> widgetNewspaperTagList = response.getNodeElementListByName("widgetNewspaper");
        List<NodeElement> ratesNewspaperTagList = response.getNodeElementListByName("rates");

        checkTagIsPresent(METHOD_NAME, "pub", pubTagList);
        checkTagIsPresent(METHOD_NAME, "pubDivList", pubDivListTagList);
        checkTagIsPresent(METHOD_NAME, "widgetAnswerOfDay", widgetAnswerOfDayTagList);
        checkTagIsPresent(METHOD_NAME, "widgetNewspaper", widgetNewspaperTagList);
        checkTagIsPresent(METHOD_NAME, "rates", ratesNewspaperTagList);
    }

    private void checkForUss(ServiceResponse response) {
        List<NodeElement> pubTagList = response.getNodeElementListByName("pub");
        List<NodeElement> pubDivListTagList = response.getNodeElementListByName("pubDivList");
        List<NodeElement> ratesNewspaperTagList = response.getNodeElementListByName("rates");

        checkTagIsPresent(METHOD_NAME, "pub", pubTagList);
        checkTagIsPresent(METHOD_NAME, "pubDivList", pubDivListTagList);
        checkTagIsPresent(METHOD_NAME, "rates", ratesNewspaperTagList);
    }

    private void checkForFss(ServiceResponse response) {
        List<NodeElement> pubDivListTagList = response.getNodeElementListByName("pubDivList");
        List<NodeElement> changeListTagList = response.getNodeElementListByName("changeList");
        List<NodeElement> calendarTagList = response.getNodeElementListByName("calendar");
        List<NodeElement> ratesNewspaperTagList = response.getNodeElementListByName("rates");

        checkTagIsPresent(METHOD_NAME, "pubDivList", pubDivListTagList);
        checkTagIsPresent(METHOD_NAME, "changeList", changeListTagList);
        checkTagIsPresent(METHOD_NAME, "calendar", calendarTagList);
        checkTagIsPresent(METHOD_NAME, "rates", ratesNewspaperTagList);
    }
}
