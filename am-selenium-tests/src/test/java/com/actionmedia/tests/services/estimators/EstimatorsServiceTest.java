package com.actionmedia.tests.services.estimators;

import com.actionmedia.base.AbstractServicesTest;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.io.IOUtils;
import org.apache.xerces.dom.DeferredElementImpl;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.ws.rs.core.MediaType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import static com.actionmedia.autotest.Group.estimators;
import static com.actionmedia.autotest.Group.service;

public class EstimatorsServiceTest extends AbstractServicesTest {

    private static final String CALC_CROSS_RATE_METHOD_NAME = "CalcCrossRate";
    private static final String CALC_CROSS_RATE_BY_RANGE_METHOD_NAME = "CalcCrossRateByRange";
    private static final String GET_ACTUAL_DATE_METHOD_NAME = "GetActualDate";
    private static final String GET_CURRENCIES_METHOD_NAME = "GetCurrencies";
    private static final String CALC_ACTUAL_RATES_METHOD_NAME = "CalcActualRates";

    @Test(groups = {service, estimators})
    public void calcCrossRate_test() {
        String date = "2016-02-03T00:00:00";
        int firstCurrencyNumber = 840;
        int secondCurrencyNumber = 643;
        int sum = 100;
        boolean calcBaseSum = true;
        boolean allowGroup = false;
        String lang = "ru";

        String errorMessage = "Неправильный формат ответного xml для метода '" + CALC_CROSS_RATE_METHOD_NAME + "'";
        report("Тест для проверки метода '" + CALC_CROSS_RATE_METHOD_NAME + "' для текущего дня");
        report("Date - " + date);
        report("FirstCurrencyNumber - " + firstCurrencyNumber);
        report("SecondCurrencyNumber - " + secondCurrencyNumber);
        report("Sum - " + sum);
        report("CalcBaseSum - " + calcBaseSum);
        report("AllowGroup - " + allowGroup);
        report("lang - " + lang);

        Client client = Client.create();
        WebResource webResource = client.resource(getUrl() + "calc-cross-rate/?Date=" + date + "&FirstCurrencyNumber=" + firstCurrencyNumber + "&SecondCurrencyNumber=" + secondCurrencyNumber + "&Sum=" + sum + "&CalcBaseSum=" + calcBaseSum + "&AllowGroup=" + allowGroup + "&lang=" + lang);
        ClientResponse response = webResource.accept(MediaType.TEXT_XML).get(ClientResponse.class);

        assertEquals(response.getStatus(), HttpStatus.SC_OK, "Ошибка при вызове метода '" + CALC_CROSS_RATE_METHOD_NAME + "'. Неправильный статус ответа.");

        try {
            DeferredElementImpl responseRootNode = getResponseRootNode(response);

            NodeList parametersNodeList = responseRootNode.getElementsByTagName("parameters");
            assertTrue(parametersNodeList.getLength() > 0, errorMessage + " Отсутствует тэг 'ActualDate'");
            Node parametersNode = parametersNodeList.item(0);

            NodeList dateNodeList = ((DeferredElementImpl) parametersNode).getElementsByTagName("date");
            NodeList firstCurrencyNumberNodeList = ((DeferredElementImpl) parametersNode).getElementsByTagName("firstCurrencyNumber");
            NodeList secondCurrencyNumberNodeList = ((DeferredElementImpl) parametersNode).getElementsByTagName("secondCurrencyNumber");
            NodeList sumNodeList = ((DeferredElementImpl) parametersNode).getElementsByTagName("sum");
            NodeList calcBaseSumNodeList = ((DeferredElementImpl) parametersNode).getElementsByTagName("calcBaseSum");
            NodeList allowGroupNodeList = ((DeferredElementImpl) parametersNode).getElementsByTagName("allowGroup");
            NodeList countNodeList = ((DeferredElementImpl) parametersNode).getElementsByTagName("count");

            postponedAssertTrue(dateNodeList.getLength() > 0, errorMessage + " Отсутствует тэг 'date'");
            if (dateNodeList.getLength() > 0) {
                postponedAssertFalse(dateNodeList.item(0).getFirstChild().getNodeValue().isEmpty(), errorMessage + " Отсутствует значение в тэге 'date'");
            }
            postponedAssertTrue(firstCurrencyNumberNodeList.getLength() > 0, errorMessage + " Отсутствует тэг 'firstCurrencyNumber'");
            if (firstCurrencyNumberNodeList.getLength() > 0) {
                postponedAssertFalse(firstCurrencyNumberNodeList.item(0).getFirstChild().getNodeValue().isEmpty(), errorMessage + " Отсутствует значение в тэге 'firstCurrencyNumber'");
            }
            postponedAssertTrue(secondCurrencyNumberNodeList.getLength() > 0, errorMessage + " Отсутствует тэг 'secondCurrencyNumber'");
            if (secondCurrencyNumberNodeList.getLength() > 0) {
                postponedAssertFalse(secondCurrencyNumberNodeList.item(0).getFirstChild().getNodeValue().isEmpty(), errorMessage + " Отсутствует значение в тэге 'secondCurrencyNumber'");
            }
            postponedAssertTrue(sumNodeList.getLength() > 0, errorMessage + " Отсутствует тэг 'sum'");
            if (sumNodeList.getLength() > 0) {
                postponedAssertFalse(sumNodeList.item(0).getFirstChild().getNodeValue().isEmpty(), errorMessage + " Отсутствует значение в тэге 'sum'");
            }
            postponedAssertTrue(calcBaseSumNodeList.getLength() > 0, errorMessage + " Отсутствует тэг 'calcBaseSum'");
            if (calcBaseSumNodeList.getLength() > 0) {
                postponedAssertFalse(calcBaseSumNodeList.item(0).getFirstChild().getNodeValue().isEmpty(), errorMessage + " Отсутствует значение в тэге 'calcBaseSum'");
            }
            postponedAssertTrue(allowGroupNodeList.getLength() > 0, errorMessage + " Отсутствует тэг 'allowGroup'");
            if (allowGroupNodeList.getLength() > 0) {
                postponedAssertFalse(allowGroupNodeList.item(0).getFirstChild().getNodeValue().isEmpty(), errorMessage + " Отсутствует значение в тэге 'allowGroup'");
            }
            postponedAssertTrue(countNodeList.getLength() > 0, errorMessage + " Отсутствует тэг 'count'");
            if (countNodeList.getLength() > 0) {
                postponedAssertFalse(countNodeList.item(0).getFirstChild().getNodeValue().isEmpty(), errorMessage + " Отсутствует значение в тэге 'count'");
            }

            NodeList actualDateNodeList = responseRootNode.getElementsByTagName("ActualDate");
            postponedAssertTrue(actualDateNodeList.getLength() > 0, errorMessage + " Отсутствует тэг 'ActualDate'");
            if (actualDateNodeList.getLength() > 0) {
                postponedAssertFalse(actualDateNodeList.item(0).getFirstChild().getNodeValue().isEmpty(), errorMessage + " Отсутствует значение в тэге 'ActualDate'");
            }

            NodeList calcCrossRateResultNodeList = responseRootNode.getElementsByTagName("CalcCrossRateResult");
            postponedAssertTrue(calcCrossRateResultNodeList.getLength() > 0, errorMessage + " Отсутствует тэг 'CalcCrossRateResult'");
            if (calcCrossRateResultNodeList.getLength() > 0) {
                Node calcCrossNode = calcCrossRateResultNodeList.item(0);
                Node calcSumNode = calcCrossNode.getAttributes().getNamedItem("calcSum");
                Node crossRateNode = calcCrossNode.getAttributes().getNamedItem("crossRate");
                Node dateNode = calcCrossNode.getAttributes().getNamedItem("date");

                postponedAssertNotNull(calcSumNode, errorMessage + " Отсутствует атрибут 'calcSum' в тэге 'CalcCrossRateResult'");
                if (crossRateNode != null) {
                    postponedAssertFalse(calcSumNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'calcSum' в тэге 'CalcCrossRateResult'");
                }
                postponedAssertNotNull(crossRateNode, errorMessage + " Отсутствует атрибут 'crossRate' в тэге 'CalcCrossRateResult'");
                if (crossRateNode != null) {
                    postponedAssertFalse(crossRateNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'crossRate' в тэге 'CalcCrossRateResult'");
                }
                postponedAssertNotNull(dateNode, errorMessage + " Отсутствует атрибут 'date' в тэге 'CalcCrossRateResult'");
                if (dateNode != null) {
                    postponedAssertFalse(dateNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'date' в тэге 'CalcCrossRateResult'");
                }

                NodeList firstCurrencyNodeList = ((DeferredElementImpl) calcCrossNode).getElementsByTagName("FirstCurrency");
                checkCurrencyNode(errorMessage, firstCurrencyNodeList, "FirstCurrency");

                NodeList secondCurrencyNodeList = ((DeferredElementImpl) calcCrossNode).getElementsByTagName("SecondCurrency");
                checkCurrencyNode(errorMessage, secondCurrencyNodeList, "SecondCurrency");

                NodeList dateRateListNodeList = ((DeferredElementImpl) calcCrossNode).getElementsByTagName("DateRateList");
                checkDateRateListNode(errorMessage, dateRateListNodeList);
            }

            checkMessagesNode(errorMessage, responseRootNode);
        } catch (IOException e) {
            fail("Ошибка при вызове метода '" + CALC_CROSS_RATE_METHOD_NAME + ". " + e.getMessage());
        } catch (ParserConfigurationException e) {
            fail("Ошибка при вызове метода '" + CALC_CROSS_RATE_METHOD_NAME + ". " + e.getMessage());
        } catch (SAXException e) {
            fail("Ошибка при вызове метода '" + CALC_CROSS_RATE_METHOD_NAME + ". " + e.getMessage());
        }
    }

    @Test(groups = {service, estimators})
    public void calcCrossRateByRange_test() {
        String begDate = "2016-01-10T00:00:00";
        String endDate = "2016-02-03T00:00:00";
        int firstCurrencyNumber = 840;
        int secondCurrencyNumber = 643;
        boolean allowGroup = false;
        String lang = "ru";

        String errorMessage = "Неправильный формат ответного xml для метода '" + CALC_CROSS_RATE_BY_RANGE_METHOD_NAME + "'";
        report("Тест для проверки метода '" + CALC_CROSS_RATE_BY_RANGE_METHOD_NAME + "' для текущего дня");
        report("begDate - " + begDate);
        report("endDate - " + endDate);
        report("FirstCurrencyNumber - " + firstCurrencyNumber);
        report("SecondCurrencyNumber - " + secondCurrencyNumber);
        report("AllowGroup - " + allowGroup);
        report("lang - " + lang);

        Client client = Client.create();
        WebResource webResource = client.resource(getUrl() + "calc-cross-rate-by-range?begDate=" + begDate + "&endDate=" + endDate + "&FirstCurrencyNumber=" + firstCurrencyNumber + "&SecondCurrencyNumber=" + secondCurrencyNumber + "&AllowGroup=" + allowGroup + "&lang=" + lang);
        ClientResponse response = webResource.accept(MediaType.TEXT_XML).get(ClientResponse.class);

        assertEquals(response.getStatus(), HttpStatus.SC_OK, "Ошибка при вызове метода '" + CALC_CROSS_RATE_BY_RANGE_METHOD_NAME + "'. Неправильный статус ответа.");

        try {
            DeferredElementImpl responseRootNode = getResponseRootNode(response);

            NodeList parametersNodeList = responseRootNode.getElementsByTagName("parameters");
            assertTrue(parametersNodeList.getLength() > 0, errorMessage + " Отсутствует тэг 'ActualDate'");
            Node parametersNode = parametersNodeList.item(0);

            NodeList begDateNodeList = ((DeferredElementImpl) parametersNode).getElementsByTagName("begDate");
            NodeList endDateNodeList = ((DeferredElementImpl) parametersNode).getElementsByTagName("endDate");
            NodeList firstCurrencyNumberNodeList = ((DeferredElementImpl) parametersNode).getElementsByTagName("firstCurrencyNumber");
            NodeList secondCurrencyNumberNodeList = ((DeferredElementImpl) parametersNode).getElementsByTagName("secondCurrencyNumber");
            NodeList allowGroupNodeList = ((DeferredElementImpl) parametersNode).getElementsByTagName("allowGroup");
            NodeList countNodeList = ((DeferredElementImpl) parametersNode).getElementsByTagName("count");
            NodeList allowTruncateNodeList = ((DeferredElementImpl) parametersNode).getElementsByTagName("allowTruncate");

            postponedAssertTrue(begDateNodeList.getLength() > 0, errorMessage + " Отсутствует тэг 'begDate'");
            if (begDateNodeList.getLength() > 0) {
                postponedAssertFalse(begDateNodeList.item(0).getFirstChild().getNodeValue().isEmpty(), errorMessage + "' Отсутствует значение в тэге 'begDate'");
            }
            postponedAssertTrue(endDateNodeList.getLength() > 0, errorMessage + " Отсутствует тэг 'endDate'");
            if (endDateNodeList.getLength() > 0) {
                postponedAssertFalse(endDateNodeList.item(0).getFirstChild().getNodeValue().isEmpty(), errorMessage + "' Отсутствует значение в тэге 'endDate'");
            }
            postponedAssertTrue(firstCurrencyNumberNodeList.getLength() > 0, errorMessage + " Отсутствует тэг 'firstCurrencyNumber'");
            if (firstCurrencyNumberNodeList.getLength() > 0) {
                postponedAssertFalse(firstCurrencyNumberNodeList.item(0).getFirstChild().getNodeValue().isEmpty(), errorMessage + "' Отсутствует значение в тэге 'firstCurrencyNumber'");
            }
            postponedAssertTrue(secondCurrencyNumberNodeList.getLength() > 0, errorMessage + " Отсутствует тэг 'secondCurrencyNumber'");
            if (secondCurrencyNumberNodeList.getLength() > 0) {
                postponedAssertFalse(secondCurrencyNumberNodeList.item(0).getFirstChild().getNodeValue().isEmpty(), errorMessage + "' Отсутствует значение в тэге 'secondCurrencyNumber'");
            }
            postponedAssertTrue(allowGroupNodeList.getLength() > 0, errorMessage + " Отсутствует тэг 'allowGroup'");
            if (allowGroupNodeList.getLength() > 0) {
                postponedAssertFalse(allowGroupNodeList.item(0).getFirstChild().getNodeValue().isEmpty(), errorMessage + "' Отсутствует значение в тэге 'allowGroup'");
            }
            postponedAssertTrue(countNodeList.getLength() > 0, errorMessage + " Отсутствует тэг 'count'");
            if (countNodeList.getLength() > 0) {
                postponedAssertFalse(countNodeList.item(0).getFirstChild().getNodeValue().isEmpty(), errorMessage + "' Отсутствует значение в тэге 'count'");
            }
            postponedAssertTrue(allowTruncateNodeList.getLength() > 0, errorMessage + " Отсутствует тэг 'allowTruncate'");
            if (allowTruncateNodeList.getLength() > 0) {
                postponedAssertFalse(allowTruncateNodeList.item(0).getFirstChild().getNodeValue().isEmpty(), errorMessage + "' Отсутствует значение в тэге 'allowTruncate'");
            }

            NodeList actualDateNodeList = responseRootNode.getElementsByTagName("ActualDate");
            postponedAssertTrue(actualDateNodeList.getLength() > 0, errorMessage + " Отсутствует тэг 'ActualDate'");
            if (actualDateNodeList.getLength() > 0) {
                postponedAssertFalse(actualDateNodeList.item(0).getFirstChild().getNodeValue().isEmpty(), errorMessage + "' Отсутствует значение в тэге 'ActualDate'");
            }

            NodeList calcCrossRateByRangeResultNodeList = responseRootNode.getElementsByTagName("CalcCrossRateByRangeResult");
            postponedAssertTrue(calcCrossRateByRangeResultNodeList.getLength() > 0, errorMessage + " Отсутствует тэг 'CalcCrossRateByRangeResult'");
            if (calcCrossRateByRangeResultNodeList.getLength() > 0) {
                Node calcCrossNode = calcCrossRateByRangeResultNodeList.item(0);

                NodeList firstCurrencyNodeList = ((DeferredElementImpl) calcCrossNode).getElementsByTagName("FirstCurrency");
                checkCurrencyNode(errorMessage, firstCurrencyNodeList, "FirstCurrency");

                NodeList secondCurrencyNodeList = ((DeferredElementImpl) calcCrossNode).getElementsByTagName("SecondCurrency");
                checkCurrencyNode(errorMessage, secondCurrencyNodeList, "SecondCurrency");

                NodeList dateRateListNodeList = ((DeferredElementImpl) calcCrossNode).getElementsByTagName("DateRateList");
                checkDateRateListNode(errorMessage, dateRateListNodeList);
            }

            checkMessagesNode(errorMessage, responseRootNode);
        } catch (IOException e) {
            fail("Ошибка при вызове метода '" + CALC_CROSS_RATE_BY_RANGE_METHOD_NAME + ". " + e.getMessage());
        } catch (ParserConfigurationException e) {
            fail("Ошибка при вызове метода '" + CALC_CROSS_RATE_BY_RANGE_METHOD_NAME + ". " + e.getMessage());
        } catch (SAXException e) {
            fail("Ошибка при вызове метода '" + CALC_CROSS_RATE_BY_RANGE_METHOD_NAME + ". " + e.getMessage());
        }
    }

    @Test(groups = {service, estimators})
    public void getCurrencies_test() {
        String date = "2016-02-03T00:00:00";
        String lang = "ru";

        String errorMessage = "Неправильный формат ответного xml для метода '" + GET_CURRENCIES_METHOD_NAME + "'";
        report("Тест для проверки метода '" + GET_CURRENCIES_METHOD_NAME + "' для текущего дня");
        report("Date - " + date);
        report("lang - " + lang);

        Client client = Client.create();
        WebResource webResource = client.resource(getUrl() + "get-currencies?Date=" + date + "&lang=" + lang);
        ClientResponse response = webResource.accept(MediaType.TEXT_XML).get(ClientResponse.class);

        assertEquals(response.getStatus(), HttpStatus.SC_OK, "Ошибка при вызове метода '" + GET_CURRENCIES_METHOD_NAME + "'. Неправильный статус ответа.");

        try {
            DeferredElementImpl responseRootNode = getResponseRootNode(response);

            NodeList currencyListNodeList = responseRootNode.getElementsByTagName("CurrencyList");
            postponedAssertTrue(currencyListNodeList.getLength() > 0, errorMessage + " Отсутствует тэг 'CurrencyList'");
            if (currencyListNodeList.getLength() > 0) {
                Node currencyListNode = currencyListNodeList.item(0);
                Node countNode = currencyListNode.getAttributes().getNamedItem("count");
                Node dateNode = currencyListNode.getAttributes().getNamedItem("date");
                Node actualDate = currencyListNode.getAttributes().getNamedItem("actualDate");

                postponedAssertNotNull(countNode, errorMessage + " Отсутствует атрибут 'count' в тэге 'CurrencyList'");
                if (countNode != null) {
                    postponedAssertFalse(countNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'count' в тэге 'CurrencyList'");
                }
                postponedAssertNotNull(dateNode, errorMessage + " Отсутствует атрибут 'date' в тэге 'CurrencyList'");
                if (dateNode != null) {
                    postponedAssertFalse(dateNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'date' в тэге 'CurrencyList'");
                }
                postponedAssertNotNull(actualDate, errorMessage + " Отсутствует атрибут 'actualDate' в тэге 'CurrencyList'");
                if (actualDate != null) {
                    postponedAssertFalse(actualDate.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'actualDate' в тэге 'CurrencyList'");
                }

                NodeList currencyNodeList = ((DeferredElementImpl) currencyListNode).getElementsByTagName("Currency");
                postponedAssertTrue(currencyNodeList.getLength() > 0, errorMessage + " Отсутствует тэг 'Currency'");
                for (int i = 0; i < currencyNodeList.getLength(); i++) {
                    Node currencyNode = currencyNodeList.item(i);
                    Node numberCodeNode = currencyNode.getAttributes().getNamedItem("numberCode");
                    Node isoCodeNode = currencyNode.getAttributes().getNamedItem("isoCode");
                    Node rateNode = currencyNode.getAttributes().getNamedItem("rate");
                    Node nameEngNode = currencyNode.getAttributes().getNamedItem("nameEng");
                    Node nameRusNode = currencyNode.getAttributes().getNamedItem("nameRus");
                    Node multiplierNode = currencyNode.getAttributes().getNamedItem("multiplier");
                    Node multiplierPowerNode = currencyNode.getAttributes().getNamedItem("multiplierPower");
                    Node virtualIsoCodeNode = currencyNode.getAttributes().getNamedItem("virtualIsoCode");
                    Node orderIdNode = currencyNode.getAttributes().getNamedItem("orderId");

                    postponedAssertNotNull(numberCodeNode, errorMessage + " Отсутствует атрибут 'numberCode' в тэге 'CurrencyList > Currency' для " + i + " элемента в списке");
                    if (numberCodeNode != null) {
                        postponedAssertFalse(numberCodeNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'numberCode' в тэге 'CurrencyList > Currency' для " + i + " элемента в списке");
                    }
                    postponedAssertNotNull(isoCodeNode, errorMessage + " Отсутствует атрибут 'isoCode' в тэге 'CurrencyList > Currency' для " + i + " элемента в списке");
                    if (isoCodeNode != null) {
                        postponedAssertFalse(isoCodeNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'isoCode' в тэге 'CurrencyList > Currency' для " + i + " элемента в списке");
                    }
                    postponedAssertNotNull(rateNode, errorMessage + " Отсутствует атрибут 'rate' в тэге 'CurrencyList > Currency' для " + i + " элемента в списке");
                    if (rateNode != null) {
                        postponedAssertFalse(rateNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'rate' в тэге 'CurrencyList > Currency' для " + i + " элемента в списке");
                    }
                    postponedAssertNotNull(nameEngNode, errorMessage + " Отсутствует атрибут 'nameEng' в тэге 'CurrencyList > Currency' для " + i + " элемента в списке");
                    if (nameEngNode != null) {
                        postponedAssertFalse(nameEngNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'nameEng' в тэге 'CurrencyList > Currency' для " + i + " элемента в списке");
                    }
                    postponedAssertNotNull(nameRusNode, errorMessage + " Отсутствует атрибут 'nameRus' в тэге 'CurrencyList > Currency' для " + i + " элемента в списке");
                    if (nameRusNode != null) {
                        postponedAssertFalse(nameRusNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'nameRus' в тэге 'CurrencyList > Currency' для " + i + " элемента в списке");
                    }
                    postponedAssertNotNull(multiplierNode, errorMessage + " Отсутствует атрибут 'multiplier' в тэге 'CurrencyList > Currency' для " + i + " элемента в списке");
                    if (multiplierNode != null) {
                        postponedAssertFalse(multiplierNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'multiplier' в тэге 'CurrencyList > Currency' для " + i + " элемента в списке");
                    }
                    postponedAssertNotNull(multiplierPowerNode, errorMessage + " Отсутствует атрибут 'multiplierPower' в тэге 'CurrencyList > Currency' для " + i + " элемента в списке");
                    if (multiplierPowerNode != null) {
                        postponedAssertFalse(multiplierPowerNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'multiplierPower' в тэге 'CurrencyList > Currency' для " + i + " элемента в списке");
                    }
                    postponedAssertNotNull(virtualIsoCodeNode, errorMessage + " Отсутствует атрибут 'virtualIsoCode' в тэге 'CurrencyList > Currency' для " + i + " элемента в списке");
                    if (virtualIsoCodeNode != null) {
                        postponedAssertFalse(virtualIsoCodeNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'virtualIsoCode' в тэге 'CurrencyList > Currency' для " + i + " элемента в списке");
                    }
                    postponedAssertNotNull(orderIdNode, errorMessage + " Отсутствует атрибут 'orderId' в тэге 'CurrencyList > Currency' для " + i + " элемента в списке");
                    if (orderIdNode != null) {
                        postponedAssertFalse(orderIdNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'orderId' в тэге 'CurrencyList > Currency' для " + i + " элемента в списке");
                    }
                }
            }

            checkMessagesNode(errorMessage, responseRootNode);
        } catch (IOException e) {
            fail("Ошибка при вызове метода '" + GET_CURRENCIES_METHOD_NAME + ". " + e.getMessage());
        } catch (ParserConfigurationException e) {
            fail("Ошибка при вызове метода '" + GET_CURRENCIES_METHOD_NAME + ". " + e.getMessage());
        } catch (SAXException e) {
            fail("Ошибка при вызове метода '" + GET_CURRENCIES_METHOD_NAME + ". " + e.getMessage());
        }
    }

    @Test(groups = {service, estimators})
    public void getActualDate_test() {
        String lang = "ru";

        report("Тест для проверки метода '" + GET_ACTUAL_DATE_METHOD_NAME + "' для текущего дня");
        report("lang - " + lang);

        String errorMessage = "Неправильный формат ответного xml для метода '" + GET_ACTUAL_DATE_METHOD_NAME + "'";

        Client client = Client.create();
        WebResource webResource = client.resource(getUrl() + "get-actual-date/?lang=" + lang);
        ClientResponse response = webResource.accept(MediaType.TEXT_XML).get(ClientResponse.class);

        assertEquals(response.getStatus(), HttpStatus.SC_OK, "Ошибка при вызове метода '" + GET_ACTUAL_DATE_METHOD_NAME + "'. Неправильный статус ответа.");

        try {
            DeferredElementImpl responseRootNode = getResponseRootNode(response);

            NodeList actualDateNodeList = responseRootNode.getElementsByTagName("ActualDate");
            postponedAssertTrue(actualDateNodeList.getLength() > 0, errorMessage + " Отсутствует тэг 'ActualDate'");
            if (actualDateNodeList.getLength() > 0) {
                postponedAssertFalse(actualDateNodeList.item(0).getFirstChild().getNodeValue().isEmpty(), errorMessage + " Отсутствует значение в тэге 'ActualDate'");
            }

            checkMessagesNode(errorMessage, responseRootNode);
        } catch (IOException e) {
            fail("Ошибка при вызове метода '" + GET_ACTUAL_DATE_METHOD_NAME + ". " + e.getMessage());
        } catch (ParserConfigurationException e) {
            fail("Ошибка при вызове метода '" + GET_ACTUAL_DATE_METHOD_NAME + ". " + e.getMessage());
        } catch (SAXException e) {
            fail("Ошибка при вызове метода '" + GET_ACTUAL_DATE_METHOD_NAME + ". " + e.getMessage());
        }
    }

    @Test(groups = {service, estimators})
    public void calcActualRates_test() {
        String date = "2016-01-01";
        String lang = "ru";

        report("Тест для проверки метода '" + CALC_ACTUAL_RATES_METHOD_NAME + "' для текущего дня");
        report("Date - " + date);
        report("lang - " + lang);

        String errorMessage = "Неправильный формат ответного xml для метода '" + CALC_ACTUAL_RATES_METHOD_NAME + "'";

        Client client = Client.create();
        WebResource webResource = client.resource(getUrl() + "get-actual-rates/?DateOn=" + date + "&lang=" + lang);
        ClientResponse response = webResource.accept(MediaType.TEXT_XML).get(ClientResponse.class);

        assertEquals(response.getStatus(), HttpStatus.SC_OK, "Ошибка при вызове метода '" + CALC_ACTUAL_RATES_METHOD_NAME + "'. Неправильный статус ответа.");

        try {
            DeferredElementImpl responseRootNode = getResponseRootNode(response);

            NodeList ratesNodeList = responseRootNode.getElementsByTagName("rates");
            postponedAssertTrue(ratesNodeList.getLength() > 0, errorMessage + " Отсутствует тэг 'rates'");
            if (ratesNodeList.getLength() > 0) {
                Node ratesNode = ratesNodeList.item(0);
                Node serviceNode = ratesNode.getAttributes().getNamedItem("service");
                Node methodNode = ratesNode.getAttributes().getNamedItem("method");
                Node dateOnNode = ratesNode.getAttributes().getNamedItem("dateOn");
                Node lastUpdateDateNode = ratesNode.getAttributes().getNamedItem("lastUpdateDate");

                postponedAssertNotNull(serviceNode, errorMessage + " Отсутствует атрибут 'service' в тэге 'rates'");
                if (serviceNode != null) {
                    postponedAssertFalse(serviceNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'service' в тэге 'rates'");
                }
                postponedAssertNotNull(methodNode, errorMessage + " Отсутствует атрибут 'method' в тэге 'rates'");
                if (methodNode != null) {
                    postponedAssertFalse(methodNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'method' в тэге 'rates'");
                }
                postponedAssertNotNull(dateOnNode, errorMessage + " Отсутствует атрибут 'dateOn' в тэге 'rates'");
                if (dateOnNode != null) {
                    postponedAssertFalse(dateOnNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'dateOn' в тэге 'rates'");
                }
                postponedAssertNotNull(lastUpdateDateNode, errorMessage + " Отсутствует атрибут 'lastUpdateDate' в тэге 'rates'");
                if (lastUpdateDateNode != null) {
                    postponedAssertFalse(lastUpdateDateNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'lastUpdateDate' в тэге 'rates'");
                }

                NodeList rateNodeList = ((DeferredElementImpl) ratesNode).getElementsByTagName("rate");
                postponedAssertTrue(rateNodeList.getLength() > 0, errorMessage + " Отсутствует тэг 'rate'");
                for (int i = 0; i < rateNodeList.getLength(); i++) {
                    Node rateNode = rateNodeList.item(i);
                    Node codeNode = rateNode.getAttributes().getNamedItem("code");
                    Node vCodeNode = rateNode.getAttributes().getNamedItem("vCode");
                    Node multiplierNode = rateNode.getAttributes().getNamedItem("multiplier");
                    Node descriptionNode = rateNode.getAttributes().getNamedItem("description");
                    Node priorityNode = rateNode.getAttributes().getNamedItem("priority");

                    postponedAssertNotNull(codeNode, errorMessage + " Отсутствует атрибут 'code' в тэге 'rates > rate'");
                    if (codeNode != null) {
                        postponedAssertFalse(codeNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'code' в тэге 'rates > rate'");
                    }
                    postponedAssertNotNull(vCodeNode, errorMessage + " Отсутствует атрибут 'vCode' в тэге 'rates > rate'");
                    if (vCodeNode != null) {
                        postponedAssertFalse(vCodeNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'vCode' в тэге 'rates > rate'");
                    }
                    postponedAssertNotNull(multiplierNode, errorMessage + " Отсутствует атрибут 'multiplier' в тэге 'rates > rate'");
                    if (multiplierNode != null) {
                        postponedAssertFalse(multiplierNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'multiplier' в тэге 'rates > rate'");
                    }
                    postponedAssertNotNull(descriptionNode, errorMessage + " Отсутствует атрибут 'description' в тэге 'rates > rate'");
                    if (descriptionNode != null) {
                        postponedAssertFalse(descriptionNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'description' в тэге 'rates > rate'");
                    }
                    postponedAssertNotNull(priorityNode, errorMessage + " Отсутствует атрибут 'priority' в тэге 'rates > rate'");
                    if (priorityNode != null) {
                        postponedAssertFalse(priorityNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'priority' в тэге 'rates > rate'");
                    }

                    postponedAssertFalse(rateNode.getFirstChild().getNodeValue().isEmpty(), errorMessage + " Отсутствует значение в тэге 'rate'");
                }
            }

            checkMessagesNode(errorMessage, responseRootNode);
        } catch (IOException e) {
            fail("Ошибка при вызове метода '" + CALC_ACTUAL_RATES_METHOD_NAME + ". " + e.getMessage());
        } catch (ParserConfigurationException e) {
            fail("Ошибка при вызове метода '" + CALC_ACTUAL_RATES_METHOD_NAME + ". " + e.getMessage());
        } catch (SAXException e) {
            fail("Ошибка при вызове метода '" + CALC_ACTUAL_RATES_METHOD_NAME + ". " + e.getMessage());
        }
    }

    private void checkCurrencyNode(String errorMessage, NodeList currencyNumberNodeList, final String currencyNumberName) {
        postponedAssertTrue(currencyNumberNodeList.getLength() > 0, errorMessage + " Отсутствует тэг '" + currencyNumberName + "'");
        if (currencyNumberNodeList.getLength() > 0) {
            Node firstCurrencyNode = currencyNumberNodeList.item(0);
            NodeList currencyNodeList = ((DeferredElementImpl) firstCurrencyNode).getElementsByTagName("Currency");
            postponedAssertTrue(currencyNodeList.getLength() > 0, errorMessage + " Отсутствует тэг '" + currencyNumberName + " > Currency'");
            if (currencyNodeList.getLength() > 0) {
                Node currencyNode = currencyNodeList.item(0);
                Node numberCodeNode = currencyNode.getAttributes().getNamedItem("numberCode");
                Node isoCodeNode = currencyNode.getAttributes().getNamedItem("isoCode");
                Node rateNode = currencyNode.getAttributes().getNamedItem("rate");
                Node nameEngNode = currencyNode.getAttributes().getNamedItem("nameEng");
                Node nameRusNode = currencyNode.getAttributes().getNamedItem("nameRus");
                Node multiplierNode = currencyNode.getAttributes().getNamedItem("multiplier");
                Node multiplierPowerNode = currencyNode.getAttributes().getNamedItem("multiplierPower");
                Node virtualIsoCodeNode = currencyNode.getAttributes().getNamedItem("virtualIsoCode");
                Node orderIdNode = currencyNode.getAttributes().getNamedItem("orderId");

                postponedAssertNotNull(numberCodeNode, errorMessage + " Отсутствует атрибут 'numberCode' в тэге '" + currencyNumberName + " > Currency'");
                if (numberCodeNode != null) {
                    postponedAssertFalse(numberCodeNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'numberCode' в тэге '" + currencyNumberName + " > Currency'");
                }
                postponedAssertNotNull(isoCodeNode, errorMessage + " Отсутствует атрибут 'isoCode' в тэге '" + currencyNumberName + " > Currency'");
                if (isoCodeNode != null) {
                    postponedAssertFalse(isoCodeNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'isoCode' в тэге '" + currencyNumberName + " > Currency'");
                }
                postponedAssertNotNull(rateNode, errorMessage + " Отсутствует атрибут 'rate' в тэге '" + currencyNumberName + " > Currency'");
                if (rateNode != null) {
                    postponedAssertFalse(rateNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'rate' в тэге '" + currencyNumberName + " > Currency'");
                }
                postponedAssertNotNull(nameEngNode, errorMessage + " Отсутствует атрибут 'nameEng' в тэге '" + currencyNumberName + " > Currency'");
                if (nameEngNode != null) {
                    postponedAssertFalse(nameEngNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'nameEng' в тэге '" + currencyNumberName + " > Currency'");
                }
                postponedAssertNotNull(nameRusNode, errorMessage + " Отсутствует атрибут 'nameRus' в тэге '" + currencyNumberName + " > Currency'");
                if (nameRusNode != null) {
                    postponedAssertFalse(nameRusNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'nameRus' в тэге '" + currencyNumberName + " > Currency'");
                }
                postponedAssertNotNull(multiplierNode, errorMessage + " Отсутствует атрибут 'multiplier' в тэге '" + currencyNumberName + " > Currency'");
                if (multiplierNode != null) {
                    postponedAssertFalse(multiplierNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'multiplier' в тэге '" + currencyNumberName + " > Currency'");
                }
                postponedAssertNotNull(multiplierPowerNode, errorMessage + " Отсутствует атрибут 'multiplierPower' в тэге '" + currencyNumberName + " > Currency'");
                if (multiplierPowerNode != null) {
                    postponedAssertFalse(multiplierPowerNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'multiplierPower' в тэге '" + currencyNumberName + " > Currency'");
                }
                postponedAssertNotNull(virtualIsoCodeNode, errorMessage + " Отсутствует атрибут 'virtualIsoCode' в тэге '" + currencyNumberName + " > Currency'");
                if (virtualIsoCodeNode != null) {
                    postponedAssertFalse(virtualIsoCodeNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'virtualIsoCode' в тэге '" + currencyNumberName + " > Currency'");
                }
                postponedAssertNotNull(orderIdNode, errorMessage + " Отсутствует атрибут 'orderId' в тэге '" + currencyNumberName + " > Currency'");
                if (orderIdNode != null) {
                    postponedAssertFalse(orderIdNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'orderId' в тэге '" + currencyNumberName + " > Currency'");
                }
            }
        }
    }

    private void checkDateRateListNode(String errorMessage, NodeList dateRateListNodeList) {
        postponedAssertTrue(dateRateListNodeList.getLength() > 0, errorMessage + " Отсутствует тэг 'DateRateList'");
        if (dateRateListNodeList.getLength() > 0) {
            Node dateRateListNode = dateRateListNodeList.item(0);
            NodeList dateRateNodeList = ((DeferredElementImpl) dateRateListNode).getElementsByTagName("DateRate");
            postponedAssertTrue(dateRateNodeList.getLength() > 0, errorMessage + " Отсутствует тэг 'DateRateList > DateRate'");
            for (int i = 0; i < dateRateNodeList.getLength(); i++) {
                Node dateRateNode = dateRateNodeList.item(i);
                Node dateAttrNode = dateRateNode.getAttributes().getNamedItem("date");
                Node rateNode = dateRateNode.getAttributes().getNamedItem("rate");
                Node crossRateAttrNode = dateRateNode.getAttributes().getNamedItem("crossRate");
                Node crossRateWithoutMultiplierNode = dateRateNode.getAttributes().getNamedItem("crossRateWithoutMultiplier");
                Node multiplier1Node = dateRateNode.getAttributes().getNamedItem("multiplier1");
                Node multiplier2Node = dateRateNode.getAttributes().getNamedItem("multiplier2");
                Node crossMultiplierNode = dateRateNode.getAttributes().getNamedItem("crossMultiplier");
                Node multiplierNode = dateRateNode.getAttributes().getNamedItem("multiplier");

                postponedAssertNotNull(dateAttrNode, errorMessage + " Отсутствует атрибут 'date' в тэге 'DateRateList > DateRate' для " + i);
                if (dateAttrNode != null) {
                    postponedAssertFalse(dateAttrNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'date' в тэге 'DateRateList > DateRate' для " + i);
                }
                postponedAssertNotNull(rateNode, errorMessage + " Отсутствует атрибут 'rate' в тэге 'DateRateList > DateRate' для " + i);
                if (rateNode != null) {
                    postponedAssertFalse(rateNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'rate' в тэге 'DateRateList > DateRate' для " + i);
                }
                postponedAssertNotNull(crossRateAttrNode, errorMessage + " Отсутствует атрибут 'crossRate' в тэге 'DateRateList > DateRate'  для " + i);
                if (crossRateAttrNode != null) {
                    postponedAssertFalse(crossRateAttrNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'crossRate' в тэге 'DateRateList > DateRate' для " + i);
                }
                postponedAssertNotNull(crossRateWithoutMultiplierNode, errorMessage + " Отсутствует атрибут 'crossRateWithoutMultiplier' в тэге 'DateRateList > DateRate' для " + i);
                if (crossRateWithoutMultiplierNode != null) {
                    postponedAssertFalse(crossRateWithoutMultiplierNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'crossRateWithoutMultiplier' в тэге 'DateRateList > DateRate' для " + i);
                }
                postponedAssertNotNull(multiplier1Node, errorMessage + " Отсутствует атрибут 'multiplier1' в тэге 'DateRateList > DateRate' для " + i);
                if (multiplier1Node != null) {
                    postponedAssertFalse(multiplier1Node.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'multiplier1' в тэге 'DateRateList > DateRate' для " + i);
                }
                postponedAssertNotNull(multiplier2Node, errorMessage + " Отсутствует атрибут 'multiplier2' в тэге 'DateRateList > DateRate' для " + i);
                if (multiplier2Node != null) {
                    postponedAssertFalse(multiplier2Node.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'multiplier2' в тэге 'DateRateList > DateRate' для " + i);
                }
                postponedAssertNotNull(crossMultiplierNode, errorMessage + " Отсутствует атрибут 'crossMultiplier' в тэге 'DateRateList > DateRate' для " + i);
                if (crossMultiplierNode != null) {
                    postponedAssertFalse(crossMultiplierNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'crossMultiplier' в тэге 'DateRateList > DateRate' для " + i);
                }
                postponedAssertNotNull(multiplierNode, errorMessage + " Отсутствует атрибут 'multiplier' в тэге 'DateRateList > DateRate' для " + i);
                if (multiplierNode != null) {
                    postponedAssertFalse(multiplierNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'multiplier' в тэге 'DateRateList > DateRate' для " + i);
                }
            }
        }
    }

    private void checkMessagesNode(String errorMessage, DeferredElementImpl responseRootNode) {
        NodeList messagesNodeList = responseRootNode.getElementsByTagName("Messages");
        assertTrue(messagesNodeList.getLength() > 0, errorMessage + " Отсутствует тэг 'Messages'");
        NodeList warningListNodeList = ((DeferredElementImpl) messagesNodeList.item(0)).getElementsByTagName("WarningList");
        NodeList errorListNodeList = ((DeferredElementImpl) messagesNodeList.item(0)).getElementsByTagName("ErrorList");

        postponedAssertTrue(warningListNodeList.getLength() > 0, errorMessage + " Отсутствует тэг 'WarningList'");
        if (warningListNodeList.getLength() > 0) {
            Node uidNode = warningListNodeList.item(0).getAttributes().getNamedItem("uid");
            postponedAssertNotNull(uidNode, errorMessage + " Отсутствует атрибут 'uid' в тэге 'WarningList'");
            if (uidNode != null) {
                postponedAssertFalse(uidNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'uid' в тэге 'WarningList'");
            }
        }

        postponedAssertTrue(errorListNodeList.getLength() > 0, errorMessage + " Отсутствует тэг 'ErrorList'");
        if (warningListNodeList.getLength() > 0) {
            Node uidNode = warningListNodeList.item(0).getAttributes().getNamedItem("uid");
            postponedAssertNotNull(uidNode, errorMessage + " Отсутствует атрибут 'uid' в тэге 'ErrorList'");
            if (uidNode != null) {
                postponedAssertFalse(uidNode.getNodeValue().isEmpty(), errorMessage + " Отсутствует значение для атрибута 'uid' в тэге 'ErrorList'");
            }
        }
    }

    private DeferredElementImpl getResponseRootNode(ClientResponse response) throws IOException, ParserConfigurationException, SAXException {
        StringWriter writer = new StringWriter();
        IOUtils.copy(response.getEntityInputStream(), writer);
        String responseString = writer.toString();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(responseString)));
        return (DeferredElementImpl) document.getChildNodes().item(0);
    }

    private String getUrl() {
        if (getSettings().isRunProduction()) {
            return "http://estimators-service/currency/";
        } else if (getSettings().isRunTbd()) {
            return "http://estimators-service.pro/currency/";
        } else if (getSettings().isRunRT()) {
            return "http://estimators-service-rt/currency/";
        } else {
            return "http://estimators-service/currency/";
        }
    }
}
