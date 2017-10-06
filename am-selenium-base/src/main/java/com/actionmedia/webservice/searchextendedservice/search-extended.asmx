<?xml version="1.0" encoding="utf-8"?>
<wsdl:definitions xmlns:s="http://www.w3.org/2001/XMLSchema" xmlns:soap12="http://schemas.xmlsoap.org/wsdl/soap12/" xmlns:http="http://schemas.xmlsoap.org/wsdl/http/" xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/" xmlns:tns="http://search-extended.1kadry.ru" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:tm="http://microsoft.com/wsdl/mime/textMatching/" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/" targetNamespace="http://search-extended.1kadry.ru" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
  <wsdl:types>
    <s:schema elementFormDefault="qualified" targetNamespace="http://search-extended.1kadry.ru">
      <s:element name="Numbers">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Pattern" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="NumbersResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="NumbersResult">
              <s:complexType mixed="true">
                <s:sequence>
                  <s:any />
                </s:sequence>
              </s:complexType>
            </s:element>
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="Numbers2">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="pubDivId" type="s:unsignedByte" />
            <s:element minOccurs="0" maxOccurs="1" name="Pattern" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="Numbers2Response">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Numbers2Result">
              <s:complexType mixed="true">
                <s:sequence>
                  <s:any />
                </s:sequence>
              </s:complexType>
            </s:element>
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="Catalog">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="PreferedRegionCode" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="CatalogResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="CatalogResult">
              <s:complexType mixed="true">
                <s:sequence>
                  <s:any />
                </s:sequence>
              </s:complexType>
            </s:element>
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="Catalog2">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="pubDivId" type="s:unsignedByte" />
            <s:element minOccurs="0" maxOccurs="1" name="PreferedRegionCode" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="Catalog2Response">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Catalog2Result">
              <s:complexType mixed="true">
                <s:sequence>
                  <s:any />
                </s:sequence>
              </s:complexType>
            </s:element>
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="Filter">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="PreferedRegionCode" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ListType" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="LobbyIDs" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="RegionIDs" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="TypeIDs" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="IsActual" type="s:boolean" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="FilterResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="FilterResult">
              <s:complexType mixed="true">
                <s:sequence>
                  <s:any />
                </s:sequence>
              </s:complexType>
            </s:element>
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="Filter2">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="pubDivId" type="s:unsignedByte" />
            <s:element minOccurs="0" maxOccurs="1" name="PreferedRegionCode" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ListType" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="LobbyIDs" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="RegionIDs" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="TypeIDs" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="IsActual" type="s:boolean" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="Filter2Response">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Filter2Result">
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
            <s:element minOccurs="0" maxOccurs="1" name="DocRegionIDList" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="DocTypeIDList" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="DocLobbyIDList" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="DocNumber" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="PubDateStartedOn" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="PubDateEndedOn" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="IsActual" type="s:boolean" />
            <s:element minOccurs="1" maxOccurs="1" name="IsExtended" type="s:boolean" />
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
      <s:element name="Search2">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="pubDivId" type="s:unsignedByte" />
            <s:element minOccurs="0" maxOccurs="1" name="SearchString" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="DocRegionIDList" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="DocTypeIDList" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="DocLobbyIDList" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="DocNumber" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="PubDateStartedOn" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="PubDateEndedOn" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="IsActual" type="s:boolean" />
            <s:element minOccurs="1" maxOccurs="1" name="IsExtended" type="s:boolean" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="Search2Response">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="Search2Result">
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
  <wsdl:message name="NumbersSoapIn">
    <wsdl:part name="parameters" element="tns:Numbers" />
  </wsdl:message>
  <wsdl:message name="NumbersSoapOut">
    <wsdl:part name="parameters" element="tns:NumbersResponse" />
  </wsdl:message>
  <wsdl:message name="Numbers2SoapIn">
    <wsdl:part name="parameters" element="tns:Numbers2" />
  </wsdl:message>
  <wsdl:message name="Numbers2SoapOut">
    <wsdl:part name="parameters" element="tns:Numbers2Response" />
  </wsdl:message>
  <wsdl:message name="CatalogSoapIn">
    <wsdl:part name="parameters" element="tns:Catalog" />
  </wsdl:message>
  <wsdl:message name="CatalogSoapOut">
    <wsdl:part name="parameters" element="tns:CatalogResponse" />
  </wsdl:message>
  <wsdl:message name="Catalog2SoapIn">
    <wsdl:part name="parameters" element="tns:Catalog2" />
  </wsdl:message>
  <wsdl:message name="Catalog2SoapOut">
    <wsdl:part name="parameters" element="tns:Catalog2Response" />
  </wsdl:message>
  <wsdl:message name="FilterSoapIn">
    <wsdl:part name="parameters" element="tns:Filter" />
  </wsdl:message>
  <wsdl:message name="FilterSoapOut">
    <wsdl:part name="parameters" element="tns:FilterResponse" />
  </wsdl:message>
  <wsdl:message name="Filter2SoapIn">
    <wsdl:part name="parameters" element="tns:Filter2" />
  </wsdl:message>
  <wsdl:message name="Filter2SoapOut">
    <wsdl:part name="parameters" element="tns:Filter2Response" />
  </wsdl:message>
  <wsdl:message name="SearchSoapIn">
    <wsdl:part name="parameters" element="tns:Search" />
  </wsdl:message>
  <wsdl:message name="SearchSoapOut">
    <wsdl:part name="parameters" element="tns:SearchResponse" />
  </wsdl:message>
  <wsdl:message name="Search2SoapIn">
    <wsdl:part name="parameters" element="tns:Search2" />
  </wsdl:message>
  <wsdl:message name="Search2SoapOut">
    <wsdl:part name="parameters" element="tns:Search2Response" />
  </wsdl:message>
  <wsdl:portType name="SearchExtendedSoap">
    <wsdl:operation name="Numbers">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Список номеров по введенной части номера</wsdl:documentation>
      <wsdl:input message="tns:NumbersSoapIn" />
      <wsdl:output message="tns:NumbersSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="Numbers2">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Список номеров по введенной части номера (с указанием раздела: 3-НПД, 13-АП)</wsdl:documentation>
      <wsdl:input message="tns:Numbers2SoapIn" />
      <wsdl:output message="tns:Numbers2SoapOut" />
    </wsdl:operation>
    <wsdl:operation name="Catalog">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Справочники инициализации</wsdl:documentation>
      <wsdl:input message="tns:CatalogSoapIn" />
      <wsdl:output message="tns:CatalogSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="Catalog2">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Справочники инициализации (с указанием раздела: 3-НПД, 13-АП)</wsdl:documentation>
      <wsdl:input message="tns:Catalog2SoapIn" />
      <wsdl:output message="tns:Catalog2SoapOut" />
    </wsdl:operation>
    <wsdl:operation name="Filter">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Фильтрация списков по значениям других списков</wsdl:documentation>
      <wsdl:input message="tns:FilterSoapIn" />
      <wsdl:output message="tns:FilterSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="Filter2">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Фильтрация списков по значениям других списков (с указанием раздела: 3-НПД, 13-АП)</wsdl:documentation>
      <wsdl:input message="tns:Filter2SoapIn" />
      <wsdl:output message="tns:Filter2SoapOut" />
    </wsdl:operation>
    <wsdl:operation name="Search">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Поиск</wsdl:documentation>
      <wsdl:input message="tns:SearchSoapIn" />
      <wsdl:output message="tns:SearchSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="Search2">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Поиск (с указанием раздела: 3-НПД, 13-АП)</wsdl:documentation>
      <wsdl:input message="tns:Search2SoapIn" />
      <wsdl:output message="tns:Search2SoapOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:binding name="SearchExtendedSoap" type="tns:SearchExtendedSoap">
    <soap:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="Numbers">
      <soap:operation soapAction="http://search-extended.1kadry.ru/Numbers" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Numbers2">
      <soap:operation soapAction="http://search-extended.1kadry.ru/Numbers2" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Catalog">
      <soap:operation soapAction="http://search-extended.1kadry.ru/Catalog" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Catalog2">
      <soap:operation soapAction="http://search-extended.1kadry.ru/Catalog2" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Filter">
      <soap:operation soapAction="http://search-extended.1kadry.ru/Filter" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Filter2">
      <soap:operation soapAction="http://search-extended.1kadry.ru/Filter2" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Search">
      <soap:operation soapAction="http://search-extended.1kadry.ru/Search" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Search2">
      <soap:operation soapAction="http://search-extended.1kadry.ru/Search2" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="SearchExtendedSoap12" type="tns:SearchExtendedSoap">
    <soap12:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="Numbers">
      <soap12:operation soapAction="http://search-extended.1kadry.ru/Numbers" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Numbers2">
      <soap12:operation soapAction="http://search-extended.1kadry.ru/Numbers2" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Catalog">
      <soap12:operation soapAction="http://search-extended.1kadry.ru/Catalog" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Catalog2">
      <soap12:operation soapAction="http://search-extended.1kadry.ru/Catalog2" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Filter">
      <soap12:operation soapAction="http://search-extended.1kadry.ru/Filter" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Filter2">
      <soap12:operation soapAction="http://search-extended.1kadry.ru/Filter2" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Search">
      <soap12:operation soapAction="http://search-extended.1kadry.ru/Search" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Search2">
      <soap12:operation soapAction="http://search-extended.1kadry.ru/Search2" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:service name="SearchExtended">
    <wsdl:port name="SearchExtendedSoap" binding="tns:SearchExtendedSoap">
      <soap:address location="http://www.1gl.ru/service/search-extended.asmx" />
    </wsdl:port>
    <wsdl:port name="SearchExtendedSoap12" binding="tns:SearchExtendedSoap12">
      <soap12:address location="http://www.1gl.ru/service/search-extended.asmx" />
    </wsdl:port>
  </wsdl:service>
</wsdl:definitions>