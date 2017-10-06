<?xml version="1.0" encoding="utf-8"?>
<wsdl:definitions xmlns:s="http://www.w3.org/2001/XMLSchema" xmlns:soap12="http://schemas.xmlsoap.org/wsdl/soap12/" xmlns:http="http://schemas.xmlsoap.org/wsdl/http/" xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/" xmlns:tns="http://glavbukh.ru.1gl.ru" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:tm="http://microsoft.com/wsdl/mime/textMatching/" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/" targetNamespace="http://glavbukh.ru.1gl.ru" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
  <wsdl:types>
    <s:schema elementFormDefault="qualified" targetNamespace="http://glavbukh.ru.1gl.ru">
      <s:element name="PacketRubricator">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="PubDivId" type="s:unsignedByte" />
            <s:element minOccurs="1" maxOccurs="1" name="PacketId" nillable="true" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="PacketRubricatorResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="PacketRubricatorResult">
              <s:complexType mixed="true">
                <s:sequence>
                  <s:any />
                </s:sequence>
              </s:complexType>
            </s:element>
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="Search">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="SearchString" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="PubDivId" type="s:unsignedByte" />
            <s:element minOccurs="1" maxOccurs="1" name="PageNumber" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="SearchResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="SearchResult">
              <s:complexType mixed="true">
                <s:sequence>
                  <s:any />
                </s:sequence>
              </s:complexType>
            </s:element>
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="Pubs">
        <s:complexType />
      </s:element>
      <s:element name="PubsResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="PubsResult">
              <s:complexType mixed="true">
                <s:sequence>
                  <s:any />
                </s:sequence>
              </s:complexType>
            </s:element>
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="XDocument">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="ModId" type="s:unsignedByte" />
            <s:element minOccurs="1" maxOccurs="1" name="DocId" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="Actual" nillable="true" type="s:boolean" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="XDocumentResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="XDocumentResult">
              <s:complexType mixed="true">
                <s:sequence>
                  <s:any />
                </s:sequence>
              </s:complexType>
            </s:element>
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="WizardStep">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="ModId" type="s:unsignedByte" />
            <s:element minOccurs="1" maxOccurs="1" name="DocId" type="s:int" />
            <s:element minOccurs="0" maxOccurs="1" name="AnswersCSV" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="WizardStepResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="WizardStepResult">
              <s:complexType mixed="true">
                <s:sequence>
                  <s:any />
                </s:sequence>
              </s:complexType>
            </s:element>
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="Rubricator">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="PubDivId" type="s:unsignedByte" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="RubricatorResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="RubricatorResult">
              <s:complexType mixed="true">
                <s:sequence>
                  <s:any />
                </s:sequence>
              </s:complexType>
            </s:element>
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="Settings">
        <s:complexType />
      </s:element>
      <s:element name="SettingsResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="SettingsResult">
              <s:complexType mixed="true">
                <s:sequence>
                  <s:any />
                </s:sequence>
              </s:complexType>
            </s:element>
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="Attachment">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="ModuleId" type="s:unsignedByte" />
            <s:element minOccurs="1" maxOccurs="1" name="AttachId" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="AttachmentResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="AttachmentResult">
              <s:complexType mixed="true">
                <s:sequence>
                  <s:any />
                </s:sequence>
              </s:complexType>
            </s:element>
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="PacketSearch">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="SearchString" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="PubDivId" type="s:unsignedByte" />
            <s:element minOccurs="1" maxOccurs="1" name="PageNumber" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="PacketId" nillable="true" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="PacketSearchResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="PacketSearchResult">
              <s:complexType mixed="true">
                <s:sequence>
                  <s:any />
                </s:sequence>
              </s:complexType>
            </s:element>
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="Tab">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="PubDivId" type="s:unsignedByte" />
            <s:element minOccurs="1" maxOccurs="1" name="Period" nillable="true" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="Date" nillable="true" type="s:dateTime" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="TabResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="TabResult">
              <s:complexType mixed="true">
                <s:sequence>
                  <s:any />
                </s:sequence>
              </s:complexType>
            </s:element>
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="PacketTab">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="PubDivId" type="s:unsignedByte" />
            <s:element minOccurs="1" maxOccurs="1" name="Period" nillable="true" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="Date" nillable="true" type="s:dateTime" />
            <s:element minOccurs="1" maxOccurs="1" name="PacketId" nillable="true" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="PacketTabResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="PacketTabResult">
              <s:complexType mixed="true">
                <s:sequence>
                  <s:any />
                </s:sequence>
              </s:complexType>
            </s:element>
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetCalendar">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="year" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="month" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetCalendarResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetCalendarResult">
              <s:complexType mixed="true">
                <s:sequence>
                  <s:any />
                </s:sequence>
              </s:complexType>
            </s:element>
          </s:sequence>
        </s:complexType>
      </s:element>
    </s:schema>
  </wsdl:types>
  <wsdl:message name="PacketRubricatorSoapIn">
    <wsdl:part name="parameters" element="tns:PacketRubricator" />
  </wsdl:message>
  <wsdl:message name="PacketRubricatorSoapOut">
    <wsdl:part name="parameters" element="tns:PacketRubricatorResponse" />
  </wsdl:message>
  <wsdl:message name="SearchSoapIn">
    <wsdl:part name="parameters" element="tns:Search" />
  </wsdl:message>
  <wsdl:message name="SearchSoapOut">
    <wsdl:part name="parameters" element="tns:SearchResponse" />
  </wsdl:message>
  <wsdl:message name="PubsSoapIn">
    <wsdl:part name="parameters" element="tns:Pubs" />
  </wsdl:message>
  <wsdl:message name="PubsSoapOut">
    <wsdl:part name="parameters" element="tns:PubsResponse" />
  </wsdl:message>
  <wsdl:message name="XDocumentSoapIn">
    <wsdl:part name="parameters" element="tns:XDocument" />
  </wsdl:message>
  <wsdl:message name="XDocumentSoapOut">
    <wsdl:part name="parameters" element="tns:XDocumentResponse" />
  </wsdl:message>
  <wsdl:message name="WizardStepSoapIn">
    <wsdl:part name="parameters" element="tns:WizardStep" />
  </wsdl:message>
  <wsdl:message name="WizardStepSoapOut">
    <wsdl:part name="parameters" element="tns:WizardStepResponse" />
  </wsdl:message>
  <wsdl:message name="RubricatorSoapIn">
    <wsdl:part name="parameters" element="tns:Rubricator" />
  </wsdl:message>
  <wsdl:message name="RubricatorSoapOut">
    <wsdl:part name="parameters" element="tns:RubricatorResponse" />
  </wsdl:message>
  <wsdl:message name="SettingsSoapIn">
    <wsdl:part name="parameters" element="tns:Settings" />
  </wsdl:message>
  <wsdl:message name="SettingsSoapOut">
    <wsdl:part name="parameters" element="tns:SettingsResponse" />
  </wsdl:message>
  <wsdl:message name="AttachmentSoapIn">
    <wsdl:part name="parameters" element="tns:Attachment" />
  </wsdl:message>
  <wsdl:message name="AttachmentSoapOut">
    <wsdl:part name="parameters" element="tns:AttachmentResponse" />
  </wsdl:message>
  <wsdl:message name="PacketSearchSoapIn">
    <wsdl:part name="parameters" element="tns:PacketSearch" />
  </wsdl:message>
  <wsdl:message name="PacketSearchSoapOut">
    <wsdl:part name="parameters" element="tns:PacketSearchResponse" />
  </wsdl:message>
  <wsdl:message name="TabSoapIn">
    <wsdl:part name="parameters" element="tns:Tab" />
  </wsdl:message>
  <wsdl:message name="TabSoapOut">
    <wsdl:part name="parameters" element="tns:TabResponse" />
  </wsdl:message>
  <wsdl:message name="PacketTabSoapIn">
    <wsdl:part name="parameters" element="tns:PacketTab" />
  </wsdl:message>
  <wsdl:message name="PacketTabSoapOut">
    <wsdl:part name="parameters" element="tns:PacketTabResponse" />
  </wsdl:message>
  <wsdl:message name="GetCalendarSoapIn">
    <wsdl:part name="parameters" element="tns:GetCalendar" />
  </wsdl:message>
  <wsdl:message name="GetCalendarSoapOut">
    <wsdl:part name="parameters" element="tns:GetCalendarResponse" />
  </wsdl:message>
  <wsdl:portType name="GlavbukhSoap">
    <wsdl:operation name="PacketRubricator">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Получение рубикаторов пакета</wsdl:documentation>
      <wsdl:input message="tns:PacketRubricatorSoapIn" />
      <wsdl:output message="tns:PacketRubricatorSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="Search">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Поиск по разделу</wsdl:documentation>
      <wsdl:input message="tns:SearchSoapIn" />
      <wsdl:output message="tns:SearchSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="Pubs">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Получение списка изданий</wsdl:documentation>
      <wsdl:input message="tns:PubsSoapIn" />
      <wsdl:output message="tns:PubsSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="XDocument">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Получение формы в XML-формате</wsdl:documentation>
      <wsdl:input message="tns:XDocumentSoapIn" />
      <wsdl:output message="tns:XDocumentSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="WizardStep">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Получение шага мастера</wsdl:documentation>
      <wsdl:input message="tns:WizardStepSoapIn" />
      <wsdl:output message="tns:WizardStepSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="Rubricator">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Получение рубикатора</wsdl:documentation>
      <wsdl:input message="tns:RubricatorSoapIn" />
      <wsdl:output message="tns:RubricatorSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="Settings">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Получение настроек</wsdl:documentation>
      <wsdl:input message="tns:SettingsSoapIn" />
      <wsdl:output message="tns:SettingsSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="Attachment">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Получение приложения</wsdl:documentation>
      <wsdl:input message="tns:AttachmentSoapIn" />
      <wsdl:output message="tns:AttachmentSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="PacketSearch">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Поиск по разделу пакета</wsdl:documentation>
      <wsdl:input message="tns:PacketSearchSoapIn" />
      <wsdl:output message="tns:PacketSearchSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="Tab">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Получение раздела</wsdl:documentation>
      <wsdl:input message="tns:TabSoapIn" />
      <wsdl:output message="tns:TabSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="PacketTab">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Получение раздела для пакета</wsdl:documentation>
      <wsdl:input message="tns:PacketTabSoapIn" />
      <wsdl:output message="tns:PacketTabSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetCalendar">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Получить календарь</wsdl:documentation>
      <wsdl:input message="tns:GetCalendarSoapIn" />
      <wsdl:output message="tns:GetCalendarSoapOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:binding name="GlavbukhSoap" type="tns:GlavbukhSoap">
    <soap:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="PacketRubricator">
      <soap:operation soapAction="http://glavbukh.ru.1gl.ru/PacketRubricator" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Search">
      <soap:operation soapAction="http://glavbukh.ru.1gl.ru/Search" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Pubs">
      <soap:operation soapAction="http://glavbukh.ru.1gl.ru/Pubs" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="XDocument">
      <soap:operation soapAction="http://glavbukh.ru.1gl.ru/XDocument" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="WizardStep">
      <soap:operation soapAction="http://glavbukh.ru.1gl.ru/WizardStep" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Rubricator">
      <soap:operation soapAction="http://glavbukh.ru.1gl.ru/Rubricator" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Settings">
      <soap:operation soapAction="http://glavbukh.ru.1gl.ru/Settings" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Attachment">
      <soap:operation soapAction="http://glavbukh.ru.1gl.ru/Attachment" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="PacketSearch">
      <soap:operation soapAction="http://glavbukh.ru.1gl.ru/PacketSearch" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Tab">
      <soap:operation soapAction="http://glavbukh.ru.1gl.ru/Tab" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="PacketTab">
      <soap:operation soapAction="http://glavbukh.ru.1gl.ru/PacketTab" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetCalendar">
      <soap:operation soapAction="http://glavbukh.ru.1gl.ru/GetCalendar" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="GlavbukhSoap12" type="tns:GlavbukhSoap">
    <soap12:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="PacketRubricator">
      <soap12:operation soapAction="http://glavbukh.ru.1gl.ru/PacketRubricator" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Search">
      <soap12:operation soapAction="http://glavbukh.ru.1gl.ru/Search" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Pubs">
      <soap12:operation soapAction="http://glavbukh.ru.1gl.ru/Pubs" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="XDocument">
      <soap12:operation soapAction="http://glavbukh.ru.1gl.ru/XDocument" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="WizardStep">
      <soap12:operation soapAction="http://glavbukh.ru.1gl.ru/WizardStep" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Rubricator">
      <soap12:operation soapAction="http://glavbukh.ru.1gl.ru/Rubricator" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Settings">
      <soap12:operation soapAction="http://glavbukh.ru.1gl.ru/Settings" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Attachment">
      <soap12:operation soapAction="http://glavbukh.ru.1gl.ru/Attachment" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="PacketSearch">
      <soap12:operation soapAction="http://glavbukh.ru.1gl.ru/PacketSearch" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Tab">
      <soap12:operation soapAction="http://glavbukh.ru.1gl.ru/Tab" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="PacketTab">
      <soap12:operation soapAction="http://glavbukh.ru.1gl.ru/PacketTab" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetCalendar">
      <soap12:operation soapAction="http://glavbukh.ru.1gl.ru/GetCalendar" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:service name="Glavbukh">
    <wsdl:port name="GlavbukhSoap" binding="tns:GlavbukhSoap">
      <soap:address location="http://bss-rt.actiondigital.ru/service/glavbukh.ru.asmx" />
    </wsdl:port>
    <wsdl:port name="GlavbukhSoap12" binding="tns:GlavbukhSoap12">
      <soap12:address location="http://bss-rt.actiondigital.ru/service/glavbukh.ru.asmx" />
    </wsdl:port>
  </wsdl:service>
</wsdl:definitions>