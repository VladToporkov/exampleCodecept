package com.actionmedia.tests.services.currency;

import com.actionmedia.base.AbstractServicesTest;
import com.actionmedia.webservice.MessageElementConverter;
import com.actionmedia.webservice.NodeElement;
import com.actionmedia.webservice.ServiceResponse;
import org.apache.axis.message.MessageElement;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;

import static com.actionmedia.autotest.Group.currency;
import static com.actionmedia.autotest.Group.service;

/**
 * User: n.tyukavkin
 * Date: 31.01.2015
 * Time: 21:38
 */
public class CurrencyServiceTests extends AbstractServicesTest {

    @Test(groups = {service, currency})
    public void calcCrossRateTest() {
        String methodName = "CalcCrossRate";

        String customerToken = "a6bafe36-d965-4461-8826-36fc1828a632";
        Calendar date = Calendar.getInstance();
        Integer firstCurrencyNumber = 840;
        Integer secondCurrencyNumber = 643;
        BigDecimal sum = new BigDecimal(100);

        report("Тест для проверки метода '" + methodName + "'.");
        report("customerToken - " + customerToken);
        report("date - " + date.getTime().toString());
        report("firstCurrencyNumber - " + firstCurrencyNumber);
        report("secondCurrencyNumber - " + secondCurrencyNumber);
        report("sum - " + sum);

        try {
            MessageElement search = getCurrencyService(getUrl()).calcCrossRate(customerToken, date, firstCurrencyNumber, secondCurrencyNumber, sum, false).get_any()[0];
            ServiceResponse response = new MessageElementConverter(search).getResponse();

            List<NodeElement> actualDate = response.getNodeElementListByName("ActualDate");
            checkTagIsPresent(methodName, "ActualDate", actualDate);
            checkValueIsNotEmpty(methodName, actualDate);

            List<NodeElement> calcCrossRateResult = response.getNodeElementListByName("CalcCrossRateResult");
            checkTagIsPresent(methodName, "CalcCrossRateResult", calcCrossRateResult);
            if (!calcCrossRateResult.isEmpty()) {
                NodeElement calcCrossRateResultNode = calcCrossRateResult.get(0);
                checkAttributeIsPresent("calcSum", calcCrossRateResultNode.getAttributes(), methodName);
                checkAttributeIsPresent("crossRate", calcCrossRateResultNode.getAttributes(), methodName);
                checkAttributeIsPresent("date", calcCrossRateResultNode.getAttributes(), methodName);

                List<NodeElement> firstCurrency = calcCrossRateResultNode.getChildrenListByName("FirstCurrency");
                checkTagIsPresent(methodName, "FirstCurrency", firstCurrency);
                if (!firstCurrency.isEmpty()) {
                    NodeElement firstCurrencyNode = firstCurrency.get(0);
                    checkAttributeIsPresent("available", firstCurrencyNode.getAttributes(), methodName);

                    List<NodeElement> currency = firstCurrencyNode.getChildrenListByName("Currency");
                    checkTagIsPresent(methodName, "FirstCurrency >> Currency", currency);
                    if (!currency.isEmpty()) {
                        NodeElement currencyNode = currency.get(0);
                        checkAttributeIsPresent("numberCode", currencyNode.getAttributes(), methodName);
                        checkAttributeIsPresent("isoCode", currencyNode.getAttributes(), methodName);
                        checkAttributeIsPresent("rate", currencyNode.getAttributes(), methodName);
                        checkAttributeIsPresent("nameEng", currencyNode.getAttributes(), methodName);
                        checkAttributeIsPresent("nameRus", currencyNode.getAttributes(), methodName);
                        checkAttributeIsPresent("multiplier", currencyNode.getAttributes(), methodName);
                        checkAttributeIsPresent("multiplierPower", currencyNode.getAttributes(), methodName);
                        checkAttributeIsPresent("virtualIsoCode", currencyNode.getAttributes(), methodName);
                        checkAttributeIsPresent("orderId", currencyNode.getAttributes(), methodName);
                    }
                }

                List<NodeElement> secondCurrency = calcCrossRateResultNode.getChildrenListByName("SecondCurrency");
                checkTagIsPresent(methodName, "SecondCurrency", secondCurrency);
                if (!secondCurrency.isEmpty()) {
                    NodeElement secondCurrencyNode = secondCurrency.get(0);
                    checkAttributeIsPresent("available", secondCurrencyNode.getAttributes(), methodName);

                    List<NodeElement> currency = secondCurrencyNode.getChildrenListByName("Currency");
                    checkTagIsPresent(methodName, "SecondCurrency >> Currency", currency);
                    if (!currency.isEmpty()) {
                        NodeElement currencyNode = currency.get(0);
                        checkAttributeIsPresent("numberCode", currencyNode.getAttributes(), methodName);
                        checkAttributeIsPresent("isoCode", currencyNode.getAttributes(), methodName);
                        checkAttributeIsPresent("rate", currencyNode.getAttributes(), methodName);
                        checkAttributeIsPresent("nameEng", currencyNode.getAttributes(), methodName);
                        checkAttributeIsPresent("nameRus", currencyNode.getAttributes(), methodName);
                        checkAttributeIsPresent("multiplier", currencyNode.getAttributes(), methodName);
                        checkAttributeIsPresent("multiplierPower", currencyNode.getAttributes(), methodName);
                        checkAttributeIsPresent("virtualIsoCode", currencyNode.getAttributes(), methodName);
                        checkAttributeIsPresent("orderId", currencyNode.getAttributes(), methodName);
                    }
                }

                List<NodeElement> dateRateList = calcCrossRateResultNode.getChildrenListByName("DateRateList");
                checkTagIsPresent(methodName, "DateRateList", dateRateList);
                if (!dateRateList.isEmpty()) {
                    NodeElement dateRateListNode = dateRateList.get(0);
                    checkAttributeIsPresent("count", dateRateListNode.getAttributes(), methodName);
                    checkAttributeIsPresent("available", dateRateListNode.getAttributes(), methodName);

                    List<NodeElement> dateRate = dateRateListNode.getChildrenListByName("DateRate");
                    checkTagIsPresent(methodName, "DateRate", dateRate);
                    if (!dateRate.isEmpty()) {
                        NodeElement dateRateNode = dateRate.get(0);
                        checkAttributeIsPresent("date", dateRateNode.getAttributes(), methodName);
                        checkAttributeIsPresent("crossRate", dateRateNode.getAttributes(), methodName);
                        checkAttributeIsPresent("crossRateWithoutMultiplier", dateRateNode.getAttributes(), methodName);
                        checkAttributeIsPresent("multiplier1", dateRateNode.getAttributes(), methodName);
                        checkAttributeIsPresent("multiplier2", dateRateNode.getAttributes(), methodName);
                        checkAttributeIsPresent("crossMultiplier", dateRateNode.getAttributes(), methodName);
                    }
                }
            }
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }

    @Test(groups = {service, currency})
    public void getActualDateTest() {
        String methodName = "GetActualDate";

        String customerToken = "a6bafe36-d965-4461-8826-36fc1828a632";

        report("Тест для проверки метода '" + methodName + "'.");
        report("customerToken - " + customerToken);

        try {
            MessageElement search = getCurrencyService(getUrl()).getActualDate(customerToken).get_any()[0];
            ServiceResponse response = new MessageElementConverter(search).getResponse();

            List<NodeElement> actualDate = response.getNodeElementListByName("ActualDate");
            checkTagIsPresent(methodName, "ActualDate", actualDate);
            checkValueIsNotEmpty(methodName, actualDate);
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }

    @Test(groups = {service, currency})
    public void getCurrenciesForCurrentDayTest() {
        String methodName = "GetCurrencies";

        String customerToken = "a6bafe36-d965-4461-8826-36fc1828a632";
        Calendar date = Calendar.getInstance();

        report("Тест для проверки метода '" + methodName + "' для текущего дня");
        report("customerToken - " + customerToken);
        report("date - " + date.getTime().toString());

        try {
            MessageElement search = getCurrencyService(getUrl()).getCurrencies(customerToken, date).get_any()[0];
            ServiceResponse response = new MessageElementConverter(search).getResponse();

            List<NodeElement> actualDate = response.getNodeElementListByName("ActualDate");
            checkTagIsPresent(methodName, "ActualDate", actualDate);
            checkValueIsNotEmpty(methodName, actualDate);

            List<NodeElement> currencyList = response.getNodeElementListByName("CurrencyList");
            checkTagIsPresent(methodName, "CurrencyList", actualDate);
            if (!currencyList.isEmpty()) {
                NodeElement currencyListNode = currencyList.get(0);
                checkAttributeIsPresent("count", currencyListNode.getAttributes(), methodName);
                checkAttributeIsPresent("date", currencyListNode.getAttributes(), methodName);

                List<NodeElement> currency = response.getNodeElementListByName("Currency");
                checkTagIsPresent(methodName, "Currency", currency);
                for (NodeElement currencyNode : currency) {
                    checkAttributeIsPresent("numberCode", currencyNode.getAttributes(), methodName);
                    checkAttributeIsPresent("isoCode", currencyNode.getAttributes(), methodName);
                    checkAttributeIsPresent("rate", currencyNode.getAttributes(), methodName);
                    checkAttributeIsPresent("nameEng", currencyNode.getAttributes(), methodName);
                    checkAttributeIsPresent("nameRus", currencyNode.getAttributes(), methodName);
                    checkAttributeIsPresent("multiplier", currencyNode.getAttributes(), methodName);
                    checkAttributeIsPresent("multiplierPower", currencyNode.getAttributes(), methodName);
                    checkAttributeIsPresent("virtualIsoCode", currencyNode.getAttributes(), methodName);
                    checkAttributeIsPresent("orderId", currencyNode.getAttributes(), methodName);
                }
            }
        } catch (RemoteException e) {
            fail("SOAPException occurs ", e);
        }
    }

    private String getUrl() {
        if (getSettings().isRunProduction()) {
            return "http://currency-service.web/CurrencyService.svc/soap";
        } else if (getSettings().isRunTbd()) {
            return "http://currency-service.pro/CurrencyService.svc/soap";
        } else if (getSettings().isRunRT()) {
            return "http://currency-service-rt/CurrencyService.svc/soap";
        } else if (getSettings().isRunWeb13()) {
            return "http://currency-service.web13/CurrencyService.svc/soap";
        }else if (getSettings().isRunCI()){
            return "http://currency-service-ci/CurrencyService.svc/soap";
        } else {
            return "http://currency-service2/CurrencyService.svc/soap";
        }
    }
}
