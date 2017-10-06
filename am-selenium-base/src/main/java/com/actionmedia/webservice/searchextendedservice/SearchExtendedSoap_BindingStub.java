/**
 * SearchExtendedSoap_BindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchextendedservice;

public class SearchExtendedSoap_BindingStub extends org.apache.axis.client.Stub implements com.actionmedia.webservice.searchextendedservice.SearchExtendedSoap_PortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[8];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Numbers");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "Pattern"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">>NumbersResponse>NumbersResult"));
        oper.setReturnClass(com.actionmedia.webservice.searchextendedservice.NumbersResponseNumbersResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "NumbersResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Numbers2");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "pubDivId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "Pattern"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">>Numbers2Response>Numbers2Result"));
        oper.setReturnClass(com.actionmedia.webservice.searchextendedservice.Numbers2ResponseNumbers2Result.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "Numbers2Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Catalog");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "PreferedRegionCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">>CatalogResponse>CatalogResult"));
        oper.setReturnClass(com.actionmedia.webservice.searchextendedservice.CatalogResponseCatalogResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "CatalogResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Catalog2");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "pubDivId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "PreferedRegionCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">>Catalog2Response>Catalog2Result"));
        oper.setReturnClass(com.actionmedia.webservice.searchextendedservice.Catalog2ResponseCatalog2Result.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "Catalog2Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Filter");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "PreferedRegionCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "ListType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "LobbyIDs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "RegionIDs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "TypeIDs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "IsActual"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">>FilterResponse>FilterResult"));
        oper.setReturnClass(com.actionmedia.webservice.searchextendedservice.FilterResponseFilterResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "FilterResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Filter2");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "pubDivId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "PreferedRegionCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "ListType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "LobbyIDs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "RegionIDs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "TypeIDs"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "IsActual"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">>Filter2Response>Filter2Result"));
        oper.setReturnClass(com.actionmedia.webservice.searchextendedservice.Filter2ResponseFilter2Result.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "Filter2Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Search");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "SearchString"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "DocRegionIDList"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "DocTypeIDList"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "DocLobbyIDList"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "DocNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "PubDateStartedOn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "PubDateEndedOn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "IsActual"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "IsExtended"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">>SearchResponse>SearchResult"));
        oper.setReturnClass(com.actionmedia.webservice.searchextendedservice.SearchResponseSearchResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "SearchResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Search2");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "pubDivId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "SearchString"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "DocRegionIDList"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "DocTypeIDList"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "DocLobbyIDList"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "DocNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "PubDateStartedOn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "PubDateEndedOn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "IsActual"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "IsExtended"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">>Search2Response>Search2Result"));
        oper.setReturnClass(com.actionmedia.webservice.searchextendedservice.Search2ResponseSearch2Result.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "Search2Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

    }

    public SearchExtendedSoap_BindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public SearchExtendedSoap_BindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public SearchExtendedSoap_BindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.1");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">>Catalog2Response>Catalog2Result");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.searchextendedservice.Catalog2ResponseCatalog2Result.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">>CatalogResponse>CatalogResult");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.searchextendedservice.CatalogResponseCatalogResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">>Filter2Response>Filter2Result");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.searchextendedservice.Filter2ResponseFilter2Result.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">>FilterResponse>FilterResult");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.searchextendedservice.FilterResponseFilterResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">>Numbers2Response>Numbers2Result");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.searchextendedservice.Numbers2ResponseNumbers2Result.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">>NumbersResponse>NumbersResult");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.searchextendedservice.NumbersResponseNumbersResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">>Search2Response>Search2Result");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.searchextendedservice.Search2ResponseSearch2Result.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">>SearchResponse>SearchResult");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.searchextendedservice.SearchResponseSearchResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">Catalog");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.searchextendedservice.Catalog.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">Catalog2");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.searchextendedservice.Catalog2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">Catalog2Response");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.searchextendedservice.Catalog2Response.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">CatalogResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.searchextendedservice.CatalogResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">Filter");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.searchextendedservice.Filter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">Filter2");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.searchextendedservice.Filter2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">Filter2Response");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.searchextendedservice.Filter2Response.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">FilterResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.searchextendedservice.FilterResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">Numbers2");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.searchextendedservice.Numbers2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">Numbers2Response");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.searchextendedservice.Numbers2Response.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">Search");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.searchextendedservice.Search.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">Search2");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.searchextendedservice.Search2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">Search2Response");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.searchextendedservice.Search2Response.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">SearchResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.searchextendedservice.SearchResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.actionmedia.webservice.searchextendedservice.NumbersResponseNumbersResult numbers(java.lang.String pattern) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://search-extended.1kadry.ru/Numbers");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "Numbers"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pattern});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.searchextendedservice.NumbersResponseNumbersResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.searchextendedservice.NumbersResponseNumbersResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.searchextendedservice.NumbersResponseNumbersResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.searchextendedservice.Numbers2ResponseNumbers2Result numbers2(org.apache.axis.types.UnsignedByte pubDivId, java.lang.String pattern) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://search-extended.1kadry.ru/Numbers2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "Numbers2"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pubDivId, pattern});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.searchextendedservice.Numbers2ResponseNumbers2Result) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.searchextendedservice.Numbers2ResponseNumbers2Result) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.searchextendedservice.Numbers2ResponseNumbers2Result.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.searchextendedservice.CatalogResponseCatalogResult catalog(java.lang.String preferedRegionCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://search-extended.1kadry.ru/Catalog");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "Catalog"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {preferedRegionCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.searchextendedservice.CatalogResponseCatalogResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.searchextendedservice.CatalogResponseCatalogResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.searchextendedservice.CatalogResponseCatalogResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.searchextendedservice.Catalog2ResponseCatalog2Result catalog2(org.apache.axis.types.UnsignedByte pubDivId, java.lang.String preferedRegionCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://search-extended.1kadry.ru/Catalog2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "Catalog2"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pubDivId, preferedRegionCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.searchextendedservice.Catalog2ResponseCatalog2Result) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.searchextendedservice.Catalog2ResponseCatalog2Result) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.searchextendedservice.Catalog2ResponseCatalog2Result.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.searchextendedservice.FilterResponseFilterResult filter(java.lang.String preferedRegionCode, java.lang.String listType, java.lang.String lobbyIDs, java.lang.String regionIDs, java.lang.String typeIDs, boolean isActual) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://search-extended.1kadry.ru/Filter");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "Filter"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {preferedRegionCode, listType, lobbyIDs, regionIDs, typeIDs, new java.lang.Boolean(isActual)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.searchextendedservice.FilterResponseFilterResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.searchextendedservice.FilterResponseFilterResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.searchextendedservice.FilterResponseFilterResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.searchextendedservice.Filter2ResponseFilter2Result filter2(org.apache.axis.types.UnsignedByte pubDivId, java.lang.String preferedRegionCode, java.lang.String listType, java.lang.String lobbyIDs, java.lang.String regionIDs, java.lang.String typeIDs, boolean isActual) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://search-extended.1kadry.ru/Filter2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "Filter2"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pubDivId, preferedRegionCode, listType, lobbyIDs, regionIDs, typeIDs, new java.lang.Boolean(isActual)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.searchextendedservice.Filter2ResponseFilter2Result) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.searchextendedservice.Filter2ResponseFilter2Result) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.searchextendedservice.Filter2ResponseFilter2Result.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.searchextendedservice.SearchResponseSearchResult search(java.lang.String searchString, java.lang.String docRegionIDList, java.lang.String docTypeIDList, java.lang.String docLobbyIDList, java.lang.String docNumber, java.lang.String pubDateStartedOn, java.lang.String pubDateEndedOn, boolean isActual, boolean isExtended) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://search-extended.1kadry.ru/Search");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "Search"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {searchString, docRegionIDList, docTypeIDList, docLobbyIDList, docNumber, pubDateStartedOn, pubDateEndedOn, new java.lang.Boolean(isActual), new java.lang.Boolean(isExtended)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.searchextendedservice.SearchResponseSearchResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.searchextendedservice.SearchResponseSearchResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.searchextendedservice.SearchResponseSearchResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.searchextendedservice.Search2ResponseSearch2Result search2(org.apache.axis.types.UnsignedByte pubDivId, java.lang.String searchString, java.lang.String docRegionIDList, java.lang.String docTypeIDList, java.lang.String docLobbyIDList, java.lang.String docNumber, java.lang.String pubDateStartedOn, java.lang.String pubDateEndedOn, boolean isActual, boolean isExtended) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://search-extended.1kadry.ru/Search2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "Search2"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pubDivId, searchString, docRegionIDList, docTypeIDList, docLobbyIDList, docNumber, pubDateStartedOn, pubDateEndedOn, new java.lang.Boolean(isActual), new java.lang.Boolean(isExtended)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.searchextendedservice.Search2ResponseSearch2Result) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.searchextendedservice.Search2ResponseSearch2Result) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.searchextendedservice.Search2ResponseSearch2Result.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
