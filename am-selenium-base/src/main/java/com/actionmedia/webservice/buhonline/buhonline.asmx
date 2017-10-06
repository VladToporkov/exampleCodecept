<?xml version="1.0" encoding="utf-8"?>
<wsdl:definitions xmlns:s="http://www.w3.org/2001/XMLSchema" xmlns:soap12="http://schemas.xmlsoap.org/wsdl/soap12/" xmlns:http="http://schemas.xmlsoap.org/wsdl/http/" xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/" xmlns:tns="http://buhonline.1gl.ru" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:tm="http://microsoft.com/wsdl/mime/textMatching/" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/" targetNamespace="http://buhonline.1gl.ru" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
  <wsdl:types>
    <s:schema elementFormDefault="qualified" targetNamespace="http://buhonline.1gl.ru">
      <s:element name="ExtendedSearch">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="SearchString" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="pageNumber" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="pageSize" type="s:int" />
            <s:element minOccurs="0" maxOccurs="1" name="parameters" type="tns:ExtendedSearchParameters" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ExtendedSearchParameters">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="RegionID" nillable="true" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="TypeID" nillable="true" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="LobbyID" nillable="true" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="DocNumber" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="PubDateStartedOn" nillable="true" type="s:dateTime" />
          <s:element minOccurs="1" maxOccurs="1" name="PubDateEndedOn" nillable="true" type="s:dateTime" />
          <s:element minOccurs="1" maxOccurs="1" name="IsActual" type="s:boolean" />
        </s:sequence>
      </s:complexType>
      <s:element name="ExtendedSearchResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="ExtendedSearchResult">
              <s:complexType mixed="true">
                <s:sequence>
                  <s:any />
                </s:sequence>
              </s:complexType>
            </s:element>
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ExtendedSearch2">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="pubDivId" type="s:unsignedByte" />
            <s:element minOccurs="0" maxOccurs="1" name="SearchString" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="pageNumber" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="pageSize" type="s:int" />
            <s:element minOccurs="0" maxOccurs="1" name="parameters" type="tns:ExtendedSearchParameters" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ExtendedSearch2Response">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="ExtendedSearch2Result">
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
            <s:element minOccurs="1" maxOccurs="1" name="pubDivId" type="s:unsignedByte" />
            <s:element minOccurs="0" maxOccurs="1" name="searchString" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="pageNumber" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="pageSize" type="s:int" />
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
      <s:element name="ExtendedSearchFilter">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="VariableAttribute" type="tns:FilterType" />
            <s:element minOccurs="1" maxOccurs="1" name="RegionID" nillable="true" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="TypeID" nillable="true" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="LobbyID" nillable="true" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="IsActual" type="s:boolean" />
            <s:element minOccurs="0" maxOccurs="1" name="PreferedRegionCode" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:simpleType name="FilterType">
        <s:restriction base="s:string">
          <s:enumeration value="None" />
          <s:enumeration value="Lobby" />
          <s:enumeration value="Region" />
          <s:enumeration value="Type" />
        </s:restriction>
      </s:simpleType>
      <s:element name="ExtendedSearchFilterResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="ExtendedSearchFilterResult">
              <s:complexType mixed="true">
                <s:sequence>
                  <s:any />
                </s:sequence>
              </s:complexType>
            </s:element>
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ExtendedSearchFilter2">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="pubDivId" type="s:unsignedByte" />
            <s:element minOccurs="1" maxOccurs="1" name="VariableAttribute" type="tns:FilterType" />
            <s:element minOccurs="1" maxOccurs="1" name="RegionID" nillable="true" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="TypeID" nillable="true" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="LobbyID" nillable="true" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="IsActual" type="s:boolean" />
            <s:element minOccurs="0" maxOccurs="1" name="PreferedRegionCode" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ExtendedSearchFilter2Response">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="ExtendedSearchFilter2Result">
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
      <s:element name="TableOfContentEMagazine">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="epMagID" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="TableOfContentEMagazineResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="TableOfContentEMagazineResult">
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
      <s:element name="TableOfContentDocument">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="moduleID" type="s:unsignedByte" />
            <s:element minOccurs="1" maxOccurs="1" name="ID" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="TableOfContentDocumentResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="TableOfContentDocumentResult">
              <s:complexType mixed="true">
                <s:sequence>
                  <s:any />
                </s:sequence>
              </s:complexType>
            </s:element>
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="DocumentPart">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="moduleID" type="s:unsignedByte" />
            <s:element minOccurs="1" maxOccurs="1" name="ID" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="partID" type="s:short" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="DocumentPartResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="DocumentPartResult">
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
            <s:element minOccurs="1" maxOccurs="1" name="rubricatorID" type="s:unsignedByte" />
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
      <s:element name="ExtendedSearchNumbers">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Pattern" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ExtendedSearchNumbersResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="ExtendedSearchNumbersResult">
              <s:complexType mixed="true">
                <s:sequence>
                  <s:any />
                </s:sequence>
              </s:complexType>
            </s:element>
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ExtendedSearchNumbers2">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="pubDivId" type="s:unsignedByte" />
            <s:element minOccurs="0" maxOccurs="1" name="Pattern" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ExtendedSearchNumbers2Response">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="ExtendedSearchNumbers2Result">
              <s:complexType mixed="true">
                <s:sequence>
                  <s:any />
                </s:sequence>
              </s:complexType>
            </s:element>
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ExtendedSearchCatalog">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="PreferedRegionCode" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ExtendedSearchCatalogResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="ExtendedSearchCatalogResult">
              <s:complexType mixed="true">
                <s:sequence>
                  <s:any />
                </s:sequence>
              </s:complexType>
            </s:element>
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ExtendedSearchCatalog2">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="pubDivId" type="s:unsignedByte" />
            <s:element minOccurs="0" maxOccurs="1" name="PreferedRegionCode" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ExtendedSearchCatalog2Response">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="ExtendedSearchCatalog2Result">
              <s:complexType mixed="true">
                <s:sequence>
                  <s:any />
                </s:sequence>
              </s:complexType>
            </s:element>
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="News">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="pubDivId" type="s:unsignedByte" />
            <s:element minOccurs="1" maxOccurs="1" name="period" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="dateOn" nillable="true" type="s:dateTime" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="NewsResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="NewsResult">
              <s:complexType mixed="true">
                <s:sequence>
                  <s:any />
                </s:sequence>
              </s:complexType>
            </s:element>
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="Document">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="moduleID" type="s:unsignedByte" />
            <s:element minOccurs="1" maxOccurs="1" name="ID" type="s:int" />
            <s:element minOccurs="0" maxOccurs="1" name="anchor" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="actual" type="s:boolean" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="DocumentResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="DocumentResult">
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
            <s:element minOccurs="1" maxOccurs="1" name="moduleID" type="s:unsignedByte" />
            <s:element minOccurs="1" maxOccurs="1" name="ID" type="s:int" />
            <s:element minOccurs="0" maxOccurs="1" name="anchor" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="actual" type="s:boolean" />
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
    </s:schema>
  </wsdl:types>
  <wsdl:message name="ExtendedSearchSoapIn">
    <wsdl:part name="parameters" element="tns:ExtendedSearch" />
  </wsdl:message>
  <wsdl:message name="ExtendedSearchSoapOut">
    <wsdl:part name="parameters" element="tns:ExtendedSearchResponse" />
  </wsdl:message>
  <wsdl:message name="ExtendedSearch2SoapIn">
    <wsdl:part name="parameters" element="tns:ExtendedSearch2" />
  </wsdl:message>
  <wsdl:message name="ExtendedSearch2SoapOut">
    <wsdl:part name="parameters" element="tns:ExtendedSearch2Response" />
  </wsdl:message>
  <wsdl:message name="SearchSoapIn">
    <wsdl:part name="parameters" element="tns:Search" />
  </wsdl:message>
  <wsdl:message name="SearchSoapOut">
    <wsdl:part name="parameters" element="tns:SearchResponse" />
  </wsdl:message>
  <wsdl:message name="ExtendedSearchFilterSoapIn">
    <wsdl:part name="parameters" element="tns:ExtendedSearchFilter" />
  </wsdl:message>
  <wsdl:message name="ExtendedSearchFilterSoapOut">
    <wsdl:part name="parameters" element="tns:ExtendedSearchFilterResponse" />
  </wsdl:message>
  <wsdl:message name="ExtendedSearchFilter2SoapIn">
    <wsdl:part name="parameters" element="tns:ExtendedSearchFilter2" />
  </wsdl:message>
  <wsdl:message name="ExtendedSearchFilter2SoapOut">
    <wsdl:part name="parameters" element="tns:ExtendedSearchFilter2Response" />
  </wsdl:message>
  <wsdl:message name="AttachmentSoapIn">
    <wsdl:part name="parameters" element="tns:Attachment" />
  </wsdl:message>
  <wsdl:message name="AttachmentSoapOut">
    <wsdl:part name="parameters" element="tns:AttachmentResponse" />
  </wsdl:message>
  <wsdl:message name="TableOfContentEMagazineSoapIn">
    <wsdl:part name="parameters" element="tns:TableOfContentEMagazine" />
  </wsdl:message>
  <wsdl:message name="TableOfContentEMagazineSoapOut">
    <wsdl:part name="parameters" element="tns:TableOfContentEMagazineResponse" />
  </wsdl:message>
  <wsdl:message name="GetCalendarSoapIn">
    <wsdl:part name="parameters" element="tns:GetCalendar" />
  </wsdl:message>
  <wsdl:message name="GetCalendarSoapOut">
    <wsdl:part name="parameters" element="tns:GetCalendarResponse" />
  </wsdl:message>
  <wsdl:message name="SettingsSoapIn">
    <wsdl:part name="parameters" element="tns:Settings" />
  </wsdl:message>
  <wsdl:message name="SettingsSoapOut">
    <wsdl:part name="parameters" element="tns:SettingsResponse" />
  </wsdl:message>
  <wsdl:message name="TableOfContentDocumentSoapIn">
    <wsdl:part name="parameters" element="tns:TableOfContentDocument" />
  </wsdl:message>
  <wsdl:message name="TableOfContentDocumentSoapOut">
    <wsdl:part name="parameters" element="tns:TableOfContentDocumentResponse" />
  </wsdl:message>
  <wsdl:message name="DocumentPartSoapIn">
    <wsdl:part name="parameters" element="tns:DocumentPart" />
  </wsdl:message>
  <wsdl:message name="DocumentPartSoapOut">
    <wsdl:part name="parameters" element="tns:DocumentPartResponse" />
  </wsdl:message>
  <wsdl:message name="RubricatorSoapIn">
    <wsdl:part name="parameters" element="tns:Rubricator" />
  </wsdl:message>
  <wsdl:message name="RubricatorSoapOut">
    <wsdl:part name="parameters" element="tns:RubricatorResponse" />
  </wsdl:message>
  <wsdl:message name="ExtendedSearchNumbersSoapIn">
    <wsdl:part name="parameters" element="tns:ExtendedSearchNumbers" />
  </wsdl:message>
  <wsdl:message name="ExtendedSearchNumbersSoapOut">
    <wsdl:part name="parameters" element="tns:ExtendedSearchNumbersResponse" />
  </wsdl:message>
  <wsdl:message name="ExtendedSearchNumbers2SoapIn">
    <wsdl:part name="parameters" element="tns:ExtendedSearchNumbers2" />
  </wsdl:message>
  <wsdl:message name="ExtendedSearchNumbers2SoapOut">
    <wsdl:part name="parameters" element="tns:ExtendedSearchNumbers2Response" />
  </wsdl:message>
  <wsdl:message name="ExtendedSearchCatalogSoapIn">
    <wsdl:part name="parameters" element="tns:ExtendedSearchCatalog" />
  </wsdl:message>
  <wsdl:message name="ExtendedSearchCatalogSoapOut">
    <wsdl:part name="parameters" element="tns:ExtendedSearchCatalogResponse" />
  </wsdl:message>
  <wsdl:message name="ExtendedSearchCatalog2SoapIn">
    <wsdl:part name="parameters" element="tns:ExtendedSearchCatalog2" />
  </wsdl:message>
  <wsdl:message name="ExtendedSearchCatalog2SoapOut">
    <wsdl:part name="parameters" element="tns:ExtendedSearchCatalog2Response" />
  </wsdl:message>
  <wsdl:message name="NewsSoapIn">
    <wsdl:part name="parameters" element="tns:News" />
  </wsdl:message>
  <wsdl:message name="NewsSoapOut">
    <wsdl:part name="parameters" element="tns:NewsResponse" />
  </wsdl:message>
  <wsdl:message name="DocumentSoapIn">
    <wsdl:part name="parameters" element="tns:Document" />
  </wsdl:message>
  <wsdl:message name="DocumentSoapOut">
    <wsdl:part name="parameters" element="tns:DocumentResponse" />
  </wsdl:message>
  <wsdl:message name="XDocumentSoapIn">
    <wsdl:part name="parameters" element="tns:XDocument" />
  </wsdl:message>
  <wsdl:message name="XDocumentSoapOut">
    <wsdl:part name="parameters" element="tns:XDocumentResponse" />
  </wsdl:message>
  <wsdl:portType name="BuhonlineSoap">
    <wsdl:operation name="ExtendedSearch">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Поиск НПД по реквизитам</wsdl:documentation>
      <wsdl:input message="tns:ExtendedSearchSoapIn" />
      <wsdl:output message="tns:ExtendedSearchSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="ExtendedSearch2">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Поиск НПД по реквизитам (с указанием раздела: 3-НПД, 13-АП)</wsdl:documentation>
      <wsdl:input message="tns:ExtendedSearch2SoapIn" />
      <wsdl:output message="tns:ExtendedSearch2SoapOut" />
    </wsdl:operation>
    <wsdl:operation name="Search">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Поиск по разделу</wsdl:documentation>
      <wsdl:input message="tns:SearchSoapIn" />
      <wsdl:output message="tns:SearchSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="ExtendedSearchFilter">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Поиск НПД по реквизитам: Взаимная фильтрация списков реквизитов</wsdl:documentation>
      <wsdl:input message="tns:ExtendedSearchFilterSoapIn" />
      <wsdl:output message="tns:ExtendedSearchFilterSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="ExtendedSearchFilter2">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Поиск НПД по реквизитам: Взаимная фильтрация списков реквизитов (с указанием раздела: 3-НПД, 13-АП)</wsdl:documentation>
      <wsdl:input message="tns:ExtendedSearchFilter2SoapIn" />
      <wsdl:output message="tns:ExtendedSearchFilter2SoapOut" />
    </wsdl:operation>
    <wsdl:operation name="Attachment">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Аттачмент</wsdl:documentation>
      <wsdl:input message="tns:AttachmentSoapIn" />
      <wsdl:output message="tns:AttachmentSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="TableOfContentEMagazine">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Оглавление журнала</wsdl:documentation>
      <wsdl:input message="tns:TableOfContentEMagazineSoapIn" />
      <wsdl:output message="tns:TableOfContentEMagazineSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetCalendar">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Получить календарь</wsdl:documentation>
      <wsdl:input message="tns:GetCalendarSoapIn" />
      <wsdl:output message="tns:GetCalendarSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="Settings">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Текущие настройки</wsdl:documentation>
      <wsdl:input message="tns:SettingsSoapIn" />
      <wsdl:output message="tns:SettingsSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="TableOfContentDocument">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Оглавление статьи</wsdl:documentation>
      <wsdl:input message="tns:TableOfContentDocumentSoapIn" />
      <wsdl:output message="tns:TableOfContentDocumentSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="DocumentPart">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Часть документа</wsdl:documentation>
      <wsdl:input message="tns:DocumentPartSoapIn" />
      <wsdl:output message="tns:DocumentPartSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="Rubricator">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Рубрикатор</wsdl:documentation>
      <wsdl:input message="tns:RubricatorSoapIn" />
      <wsdl:output message="tns:RubricatorSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="ExtendedSearchNumbers">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Поиск НПД по реквизитам: Список номеров по введенной части номера</wsdl:documentation>
      <wsdl:input message="tns:ExtendedSearchNumbersSoapIn" />
      <wsdl:output message="tns:ExtendedSearchNumbersSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="ExtendedSearchNumbers2">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Поиск НПД по реквизитам: Список номеров по введенной части номера (с указанием раздела: 3-НПД, 13-АП)</wsdl:documentation>
      <wsdl:input message="tns:ExtendedSearchNumbers2SoapIn" />
      <wsdl:output message="tns:ExtendedSearchNumbers2SoapOut" />
    </wsdl:operation>
    <wsdl:operation name="ExtendedSearchCatalog">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Поиск НПД по реквизитам: Справочники</wsdl:documentation>
      <wsdl:input message="tns:ExtendedSearchCatalogSoapIn" />
      <wsdl:output message="tns:ExtendedSearchCatalogSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="ExtendedSearchCatalog2">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Поиск НПД по реквизитам: Справочники (с указанием раздела: 3-НПД, 13-АП)</wsdl:documentation>
      <wsdl:input message="tns:ExtendedSearchCatalog2SoapIn" />
      <wsdl:output message="tns:ExtendedSearchCatalog2SoapOut" />
    </wsdl:operation>
    <wsdl:operation name="News">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Анонсы</wsdl:documentation>
      <wsdl:input message="tns:NewsSoapIn" />
      <wsdl:output message="tns:NewsSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="Document">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Документ</wsdl:documentation>
      <wsdl:input message="tns:DocumentSoapIn" />
      <wsdl:output message="tns:DocumentSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="XDocument">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Документ в формате XML</wsdl:documentation>
      <wsdl:input message="tns:XDocumentSoapIn" />
      <wsdl:output message="tns:XDocumentSoapOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:binding name="BuhonlineSoap" type="tns:BuhonlineSoap">
    <soap:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="ExtendedSearch">
      <soap:operation soapAction="http://buhonline.1gl.ru/ExtendedSearch" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ExtendedSearch2">
      <soap:operation soapAction="http://buhonline.1gl.ru/ExtendedSearch2" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Search">
      <soap:operation soapAction="http://buhonline.1gl.ru/Search" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ExtendedSearchFilter">
      <soap:operation soapAction="http://buhonline.1gl.ru/ExtendedSearchFilter" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ExtendedSearchFilter2">
      <soap:operation soapAction="http://buhonline.1gl.ru/ExtendedSearchFilter2" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Attachment">
      <soap:operation soapAction="http://buhonline.1gl.ru/Attachment" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="TableOfContentEMagazine">
      <soap:operation soapAction="http://buhonline.1gl.ru/TableOfContentEMagazine" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetCalendar">
      <soap:operation soapAction="http://buhonline.1gl.ru/GetCalendar" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Settings">
      <soap:operation soapAction="http://buhonline.1gl.ru/Settings" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="TableOfContentDocument">
      <soap:operation soapAction="http://buhonline.1gl.ru/TableOfContentDocument" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="DocumentPart">
      <soap:operation soapAction="http://buhonline.1gl.ru/DocumentPart" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Rubricator">
      <soap:operation soapAction="http://buhonline.1gl.ru/Rubricator" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ExtendedSearchNumbers">
      <soap:operation soapAction="http://buhonline.1gl.ru/ExtendedSearchNumbers" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ExtendedSearchNumbers2">
      <soap:operation soapAction="http://buhonline.1gl.ru/ExtendedSearchNumbers2" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ExtendedSearchCatalog">
      <soap:operation soapAction="http://buhonline.1gl.ru/ExtendedSearchCatalog" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ExtendedSearchCatalog2">
      <soap:operation soapAction="http://buhonline.1gl.ru/ExtendedSearchCatalog2" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="News">
      <soap:operation soapAction="http://buhonline.1gl.ru/News" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Document">
      <soap:operation soapAction="http://buhonline.1gl.ru/Document" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="XDocument">
      <soap:operation soapAction="http://buhonline.1gl.ru/XDocument" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="BuhonlineSoap12" type="tns:BuhonlineSoap">
    <soap12:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="ExtendedSearch">
      <soap12:operation soapAction="http://buhonline.1gl.ru/ExtendedSearch" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ExtendedSearch2">
      <soap12:operation soapAction="http://buhonline.1gl.ru/ExtendedSearch2" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Search">
      <soap12:operation soapAction="http://buhonline.1gl.ru/Search" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ExtendedSearchFilter">
      <soap12:operation soapAction="http://buhonline.1gl.ru/ExtendedSearchFilter" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ExtendedSearchFilter2">
      <soap12:operation soapAction="http://buhonline.1gl.ru/ExtendedSearchFilter2" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Attachment">
      <soap12:operation soapAction="http://buhonline.1gl.ru/Attachment" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="TableOfContentEMagazine">
      <soap12:operation soapAction="http://buhonline.1gl.ru/TableOfContentEMagazine" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetCalendar">
      <soap12:operation soapAction="http://buhonline.1gl.ru/GetCalendar" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Settings">
      <soap12:operation soapAction="http://buhonline.1gl.ru/Settings" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="TableOfContentDocument">
      <soap12:operation soapAction="http://buhonline.1gl.ru/TableOfContentDocument" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="DocumentPart">
      <soap12:operation soapAction="http://buhonline.1gl.ru/DocumentPart" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Rubricator">
      <soap12:operation soapAction="http://buhonline.1gl.ru/Rubricator" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ExtendedSearchNumbers">
      <soap12:operation soapAction="http://buhonline.1gl.ru/ExtendedSearchNumbers" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ExtendedSearchNumbers2">
      <soap12:operation soapAction="http://buhonline.1gl.ru/ExtendedSearchNumbers2" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ExtendedSearchCatalog">
      <soap12:operation soapAction="http://buhonline.1gl.ru/ExtendedSearchCatalog" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ExtendedSearchCatalog2">
      <soap12:operation soapAction="http://buhonline.1gl.ru/ExtendedSearchCatalog2" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="News">
      <soap12:operation soapAction="http://buhonline.1gl.ru/News" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Document">
      <soap12:operation soapAction="http://buhonline.1gl.ru/Document" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="XDocument">
      <soap12:operation soapAction="http://buhonline.1gl.ru/XDocument" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:service name="Buhonline">
    <wsdl:port name="BuhonlineSoap" binding="tns:BuhonlineSoap">
      <soap:address location="http://vip.1gl.ru/service/buhonline.asmx" />
    </wsdl:port>
    <wsdl:port name="BuhonlineSoap12" binding="tns:BuhonlineSoap12">
      <soap12:address location="http://vip.1gl.ru/service/buhonline.asmx" />
    </wsdl:port>
  </wsdl:service>
</wsdl:definitions>