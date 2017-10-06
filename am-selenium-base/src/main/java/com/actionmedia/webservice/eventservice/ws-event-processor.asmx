<?xml version="1.0" encoding="utf-8"?>
<wsdl:definitions xmlns:s="http://www.w3.org/2001/XMLSchema" xmlns:soap12="http://schemas.xmlsoap.org/wsdl/soap12/" xmlns:http="http://schemas.xmlsoap.org/wsdl/http/" xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/" xmlns:tns="http://action-media.ru/" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:tm="http://microsoft.com/wsdl/mime/textMatching/" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/" targetNamespace="http://action-media.ru/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
  <wsdl:types>
    <s:schema elementFormDefault="qualified" targetNamespace="http://action-media.ru/">
      <s:element name="GetEventTypeList">
        <s:complexType />
      </s:element>
      <s:element name="GetEventTypeListResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetEventTypeListResult" type="tns:ArrayOfString" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ArrayOfString">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="string" nillable="true" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:element name="DropEvent">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="aEventParametersNode">
              <s:complexType mixed="true">
                <s:sequence>
                  <s:any />
                </s:sequence>
              </s:complexType>
            </s:element>
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="DropEventResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="DropEventResult">
              <s:complexType mixed="true">
                <s:sequence>
                  <s:any />
                </s:sequence>
              </s:complexType>
            </s:element>
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ArrayOfString" nillable="true" type="tns:ArrayOfString" />
    </s:schema>
  </wsdl:types>
  <wsdl:message name="GetEventTypeListSoapIn">
    <wsdl:part name="parameters" element="tns:GetEventTypeList" />
  </wsdl:message>
  <wsdl:message name="GetEventTypeListSoapOut">
    <wsdl:part name="parameters" element="tns:GetEventTypeListResponse" />
  </wsdl:message>
  <wsdl:message name="DropEventSoapIn">
    <wsdl:part name="parameters" element="tns:DropEvent" />
  </wsdl:message>
  <wsdl:message name="DropEventSoapOut">
    <wsdl:part name="parameters" element="tns:DropEventResponse" />
  </wsdl:message>
  <wsdl:message name="GetEventTypeListHttpGetIn" />
  <wsdl:message name="GetEventTypeListHttpGetOut">
    <wsdl:part name="Body" element="tns:ArrayOfString" />
  </wsdl:message>
  <wsdl:message name="GetEventTypeListHttpPostIn" />
  <wsdl:message name="GetEventTypeListHttpPostOut">
    <wsdl:part name="Body" element="tns:ArrayOfString" />
  </wsdl:message>
  <wsdl:portType name="WsEventProcessorSoap">
    <wsdl:operation name="GetEventTypeList">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Получить список типов событий</wsdl:documentation>
      <wsdl:input message="tns:GetEventTypeListSoapIn" />
      <wsdl:output message="tns:GetEventTypeListSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="DropEvent">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Обработать событие</wsdl:documentation>
      <wsdl:input message="tns:DropEventSoapIn" />
      <wsdl:output message="tns:DropEventSoapOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:portType name="WsEventProcessorHttpGet">
    <wsdl:operation name="GetEventTypeList">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Получить список типов событий</wsdl:documentation>
      <wsdl:input message="tns:GetEventTypeListHttpGetIn" />
      <wsdl:output message="tns:GetEventTypeListHttpGetOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:portType name="WsEventProcessorHttpPost">
    <wsdl:operation name="GetEventTypeList">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Получить список типов событий</wsdl:documentation>
      <wsdl:input message="tns:GetEventTypeListHttpPostIn" />
      <wsdl:output message="tns:GetEventTypeListHttpPostOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:binding name="WsEventProcessorSoap" type="tns:WsEventProcessorSoap">
    <soap:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="GetEventTypeList">
      <soap:operation soapAction="http://action-media.ru/GetEventTypeList" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="DropEvent">
      <soap:operation soapAction="http://action-media.ru/DropEvent" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="WsEventProcessorSoap12" type="tns:WsEventProcessorSoap">
    <soap12:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="GetEventTypeList">
      <soap12:operation soapAction="http://action-media.ru/GetEventTypeList" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="DropEvent">
      <soap12:operation soapAction="http://action-media.ru/DropEvent" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="WsEventProcessorHttpGet" type="tns:WsEventProcessorHttpGet">
    <http:binding verb="GET" />
    <wsdl:operation name="GetEventTypeList">
      <http:operation location="/GetEventTypeList" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="WsEventProcessorHttpPost" type="tns:WsEventProcessorHttpPost">
    <http:binding verb="POST" />
    <wsdl:operation name="GetEventTypeList">
      <http:operation location="/GetEventTypeList" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:service name="WsEventProcessor">
    <wsdl:port name="WsEventProcessorSoap" binding="tns:WsEventProcessorSoap">
      <soap:address location="http://event-processor-service/ws-event-processor.asmx" />
    </wsdl:port>
    <wsdl:port name="WsEventProcessorSoap12" binding="tns:WsEventProcessorSoap12">
      <soap12:address location="http://event-processor-service/ws-event-processor.asmx" />
    </wsdl:port>
    <wsdl:port name="WsEventProcessorHttpGet" binding="tns:WsEventProcessorHttpGet">
      <http:address location="http://event-processor-service/ws-event-processor.asmx" />
    </wsdl:port>
    <wsdl:port name="WsEventProcessorHttpPost" binding="tns:WsEventProcessorHttpPost">
      <http:address location="http://event-processor-service/ws-event-processor.asmx" />
    </wsdl:port>
  </wsdl:service>
</wsdl:definitions>