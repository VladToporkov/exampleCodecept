package com.actionmedia.tests.services.comparesearchresults;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.util.DBUtils;

import javax.xml.soap.*;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class SendRequest {

    public static String getResponse(String serviceUrl, String sortOrderParam, String query, String pubId, String pubDivId) {
        String response = "";
        try {
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send SOAP Message to SOAP Server
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(sortOrderParam, query, pubId, pubDivId), serviceUrl);

            // Process the SOAP Response
            response = getSOAPResponse(soapResponse);
            soapConnection.close();
        } catch (Exception e) {
            System.err.println("Error occurred while sending SOAP Request to Server");
            e.printStackTrace();
        }
        return response;
    }

    /**
     * pubId = new UnsignedByte(6);
     * int[] moduleIdList = new int[]{11, 12, 14, 86, 111, 112, 117, 123, 184, 186, 190, 193, 199, 201, 202, 204, 210};
     * int[] searchTagList = new int[]{};
     * UnsignedByte sortOrder = new UnsignedByte(getSortOrder());
     * UnsignedByte searchOptionFlags = new UnsignedByte(0);
     * int snippetSize = 25;
     * int docPosition = 1;
     * int pageSize = 100;
     * String searchType = "7230";
     * <p/>
     * <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sear="http://actiondigital.ru/searchservice/">
     * <soapenv:Header/>
     * <soapenv:Body>
     * <sear:SearchActionDigital>
     * <sear:searchString>закон</sear:searchString>
     * <sear:pubId>6</sear:pubId>
     * <sear:moduleIdList>
     * <sear:int>11</sear:int>
     * <sear:int>12</sear:int>
     * <sear:int>14</sear:int>
     * <sear:int>86</sear:int>
     * <sear:int>111</sear:int>
     * <sear:int>112</sear:int>
     * <sear:int>117</sear:int>
     * <sear:int>123</sear:int>
     * <sear:int>184</sear:int>
     * <sear:int>186</sear:int>
     * <sear:int>190</sear:int>
     * <sear:int>193</sear:int>
     * <sear:int>199</sear:int>
     * <sear:int>201</sear:int>
     * <sear:int>202</sear:int>
     * <sear:int>204</sear:int>
     * <sear:int>210</sear:int>
     * </sear:moduleIdList>
     * <sear:searchTagList>
     * </sear:searchTagList>
     * <sear:sortOrder>0</sear:sortOrder>
     * <sear:searchOptionFlags>0</sear:searchOptionFlags>
     * <sear:snippetSize>25</sear:snippetSize>
     * <sear:docPosition>1</sear:docPosition>
     * <sear:pageSize>100</sear:pageSize>
     * <sear:searchType>7230</sear:searchType>
     * </sear:SearchActionDigital>
     * </soapenv:Body>
     * </soapenv:Envelope>
     */
    private static SOAPMessage createSOAPRequest(String sortOrderParam, String query, String pubId, String pubDivId) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://actiondigital.ru/searchservice/";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("sear", serverURI);

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement searchActionDigital = soapBody.addChildElement("SearchActionDigital", "sear");
        searchActionDigital.addChildElement("searchString", "sear").addTextNode(query);
        searchActionDigital.addChildElement("pubId", "sear").addTextNode(pubId);

        SOAPElement moduleIdList = searchActionDigital.addChildElement("moduleIdList", "sear");

        List<String> moduleIdListByPubDibId = DBUtils.getModuleIdListByPubDibId(pubDivId, SystemPubs.getSystemPubsById(Integer.parseInt(pubId)));

        for (String moduleId : moduleIdListByPubDibId) {
            moduleIdList.addChildElement("int", "sear").addTextNode(moduleId);
        }

        searchActionDigital.addChildElement("searchTagList", "sear");

        searchActionDigital.addChildElement("sortOrder", "sear").addTextNode(sortOrderParam);

        searchActionDigital.addChildElement("searchOptionFlags", "sear").addTextNode("0");

        searchActionDigital.addChildElement("snippetSize", "sear").addTextNode("25");

        searchActionDigital.addChildElement("docPosition", "sear").addTextNode("1");

        searchActionDigital.addChildElement("pageSize", "sear").addTextNode("100");

        searchActionDigital.addChildElement("searchType", "sear").addTextNode("7230");

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI + "SearchActionDigital");

        soapMessage.saveChanges();

        return soapMessage;
    }

    /**
     * Method used to print the SOAP Response
     */
    private static String getSOAPResponse(SOAPMessage soapResponse) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        Source sourceContent = soapResponse.getSOAPPart().getContent();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        StreamResult r = new StreamResult(outputStream);
        transformer.transform(sourceContent, r);
        return new String(outputStream.toByteArray());
    }
}
