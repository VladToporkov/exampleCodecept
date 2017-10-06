package com.actionmedia.tests.functional.oss.hotline;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.soap.*;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.actionmedia.autotest.Group.regression;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;

/**
 * Created by Pavel on 04/04/16.
 */
public class OSS_1634_VerifyHolidaysAndWeekends extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1634", testCaseVersion = "1")
    public void oss_1634_test() {
        updateSystemInfo(SystemPubs.bss);
        report("Проверяется отправка запроса на ГЛ БСС КУ");
        test(BusinessDays.WORKDAY);
        test(BusinessDays.WEEKEND);
        test(BusinessDays.HOLIDAY);

        updateLoginToInfo("vip");
        report("Проверяется отправка запроса на ГЛ БСС ВИП");
        test(BusinessDays.WORKDAY);
        test(BusinessDays.WEEKEND);
        test(BusinessDays.HOLIDAY);

        updateSystemInfo(SystemPubs.kss);
        report("Проверяется отправка запроса на ГЛ КСС КУ");
        test(BusinessDays.WORKDAY);
        test(BusinessDays.WEEKEND);
        test(BusinessDays.HOLIDAY);

        updateLoginToInfo("vip");
        report("Проверяется отправка запроса на ГЛ КСС ВИП");
        test(BusinessDays.WORKDAY);
        test(BusinessDays.WEEKEND);
        test(BusinessDays.HOLIDAY);

        updateSystemInfo(SystemPubs.uss);
        report("Проверяется отправка запроса на ГЛ ЮСС КУ");
        test(BusinessDays.WORKDAY);
        test(BusinessDays.WEEKEND);
        test(BusinessDays.HOLIDAY);

        updateSystemInfo(SystemPubs.edu);
        report("Проверяется отправка запроса на ГЛ МЦФЭР ОБР КУ");
        test(BusinessDays.WORKDAY);
        test(BusinessDays.WEEKEND);
        test(BusinessDays.HOLIDAY);

        updateSystemInfo(SystemPubs.gf);
        report("Проверяется отправка запроса на ГЛ МЦФЭР ГФ КУ");
        test(BusinessDays.WORKDAY);
        test(BusinessDays.WEEKEND);
        test(BusinessDays.HOLIDAY);

        updateSystemInfo(SystemPubs.go);
        report("Проверяется отправка запроса на ГЛ МЦФЭР ГЗ КУ");
        test(BusinessDays.WORKDAY);
        test(BusinessDays.WEEKEND);
        test(BusinessDays.HOLIDAY);

        updateSystemInfo(SystemPubs.ehs);
        report("Проверяется отправка запроса на ГЛ МЦФЭР ОТ КУ");
        test(BusinessDays.WORKDAY);
        test(BusinessDays.WEEKEND);
        test(BusinessDays.HOLIDAY);
    }

    private void test(BusinessDays day) {
        String formattedDate = getDate(day);
        Document document = null;
        try {
            document = sendRequest(formattedDate);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String notNull = document.select("#resources").text();
        assertNotNull(notNull, "Ошибка при получении страницы горячей линии");
    }

    private Document sendRequest(String date) throws IOException {
        String partHotlineServiceUrl = "/site/hotline2/?now=";
        String host = getSettings().getHost();
        return Jsoup.connect("http://" + host + partHotlineServiceUrl + date).timeout(30000).get();
    }

    private String getDate(BusinessDays days) {
        final String wsdlService = "http://organizer-service/CalendarService.svc?wsdl";
        report("Ищем случайный " + days.getName());
        Date dateNumber = new Date();
        String formattedDate;

        if (days == BusinessDays.WORKDAY) {
            dateNumber = getWorkDayOrWeekend(false);
        }
        if (days == BusinessDays.WEEKEND) {
            dateNumber = getWorkDayOrWeekend(true);
        }
        if (days == BusinessDays.HOLIDAY) {
            try {
                // Create SOAP Connection
                SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
                SOAPConnection soapConnection = soapConnectionFactory.createConnection();

                // Send SOAP Message to SOAP Server
                SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(), wsdlService);

                // Process the SOAP Response
                String day = getHoliday(soapResponse);
                Date now = new Date();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                formattedDate = df.format(now);

                if (day.length() == 1) {
                    day = "0" + day;
                }

                formattedDate = formattedDate.replaceAll(formattedDate.substring(7, 11), String.format("-%sT", day));

                soapConnection.close();
                return formattedDate;
            } catch (Exception e) {
                fail("Ошибка при обращении к методу GetForPeriod сервиса CalendarService. " + e.getMessage());
            }
        }

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        formattedDate = df.format(dateNumber);

        return formattedDate;
    }

    private Date getWorkDayOrWeekend(boolean isWeekend) {
        Calendar startDate = Calendar.getInstance();
        for (int i = 1; i < 7; i++) { //first 7 days of the current month
            startDate.set(startDate.get(Calendar.YEAR), startDate.get(Calendar.MONTH), i);
            if (startDate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
                    startDate.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                if (isWeekend) {
                    return startDate.getTime();
                } else {
                    return startDate.getTime();
                }
            }
        }
        throw new IllegalStateException("Don't get any day");
    }

    private SOAPMessage createSOAPRequest() throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://tempuri.org/";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("tem", serverURI);

        String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        String month = String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1);
        if (month.length() == 1) {
            month = "0" + month;
        }

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("GetForPeriod", "tem");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("StartYear", "tem");
        soapBodyElem1.addTextNode(year);
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("StartMonth", "tem");
        soapBodyElem2.addTextNode(month);

        SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("EndYear", "tem");
        soapBodyElem3.addTextNode(year);
        SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("EndMonth", "tem");
        soapBodyElem4.addTextNode(month);

        SOAPElement soapBodyElem5 = soapBodyElem.addChildElement("systemId", "tem");
        soapBodyElem5.addTextNode("1");

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI + "ICalendarService/GetForPeriod");

        soapMessage.saveChanges();

        /* Print the request message */
        return soapMessage;
    }

    private String getHoliday(SOAPMessage soapResponse) throws TransformerException, SOAPException, IOException {
        String dayNumber = "";
        StringWriter stringWriter = new StringWriter();
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        Source sourceContent = soapResponse.getSOAPPart().getContent();
        StreamResult result = new StreamResult(stringWriter);
        transformer.transform(sourceContent, result);
        StringBuffer sb = stringWriter.getBuffer();

        MessageFactory factory = MessageFactory.newInstance();
        SOAPMessage message = factory.createMessage(
                new MimeHeaders(),
                new ByteArrayInputStream(sb.toString().getBytes(Charset
                        .forName("UTF-8"))));

        SOAPBody body = message.getSOAPBody();

        NodeList returnList = body.getElementsByTagName("day");

        List<Node> holidaysNodes = new ArrayList<Node>();

        boolean isSuccess = false;
        for (int k = 0; k < returnList.getLength(); k++) {
            NamedNodeMap namedNodeMap = returnList.item(k).getAttributes();
            if (namedNodeMap.getNamedItem("type").getNodeValue().equals("Holiday")) {
                holidaysNodes.add(returnList.item(k));
                isSuccess = true;
            }
        }

        if (isSuccess) {
            Random random = new Random();
            Node randomNode = holidaysNodes.get(random.nextInt(holidaysNodes.size()));
            NamedNodeMap nodeAttributes = randomNode.getAttributes();
            dayNumber = nodeAttributes.getNamedItem("number").getNodeValue();
        } else {
            throw new IllegalArgumentException("No one holiday is found from the SOAP response");
        }

        return dayNumber;
    }

    private enum BusinessDays {
        WORKDAY("рабочий день"),
        WEEKEND("выходной"),
        HOLIDAY("праздничный день");

        private String name;

        BusinessDays(String name) {
            this.name = name;
        }

        protected String getName() {
            return name;
        }
    }
}
