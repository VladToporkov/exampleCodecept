/**
 * BuhonlineSoap12Stub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.buhonline;

public class BuhonlineSoap12Stub extends org.apache.axis.client.Stub implements com.actionmedia.webservice.buhonline.BuhonlineSoap_PortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[19];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ExtendedSearch");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "SearchString"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "pageNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "pageSize"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://buhonline.1gl.ru", "ExtendedSearchParameters"), com.actionmedia.webservice.buhonline.ExtendedSearchParameters.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>ExtendedSearchResponse>ExtendedSearchResult"));
        oper.setReturnClass(com.actionmedia.webservice.buhonline.ExtendedSearchResponseExtendedSearchResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "ExtendedSearchResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ExtendedSearch2");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "pubDivId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "SearchString"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "pageNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "pageSize"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "parameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://buhonline.1gl.ru", "ExtendedSearchParameters"), com.actionmedia.webservice.buhonline.ExtendedSearchParameters.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>ExtendedSearch2Response>ExtendedSearch2Result"));
        oper.setReturnClass(com.actionmedia.webservice.buhonline.ExtendedSearch2ResponseExtendedSearch2Result.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "ExtendedSearch2Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Search");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "pubDivId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "searchString"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "pageNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "pageSize"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>SearchResponse>SearchResult"));
        oper.setReturnClass(com.actionmedia.webservice.buhonline.SearchResponseSearchResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "SearchResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ExtendedSearchFilter");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "VariableAttribute"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://buhonline.1gl.ru", "FilterType"), com.actionmedia.webservice.buhonline.FilterType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "RegionID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "TypeID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "LobbyID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "IsActual"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "PreferedRegionCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>ExtendedSearchFilterResponse>ExtendedSearchFilterResult"));
        oper.setReturnClass(com.actionmedia.webservice.buhonline.ExtendedSearchFilterResponseExtendedSearchFilterResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "ExtendedSearchFilterResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ExtendedSearchFilter2");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "pubDivId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "VariableAttribute"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://buhonline.1gl.ru", "FilterType"), com.actionmedia.webservice.buhonline.FilterType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "RegionID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "TypeID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "LobbyID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "IsActual"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "PreferedRegionCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>ExtendedSearchFilter2Response>ExtendedSearchFilter2Result"));
        oper.setReturnClass(com.actionmedia.webservice.buhonline.ExtendedSearchFilter2ResponseExtendedSearchFilter2Result.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "ExtendedSearchFilter2Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Attachment");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "ModuleId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "AttachId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>AttachmentResponse>AttachmentResult"));
        oper.setReturnClass(com.actionmedia.webservice.buhonline.AttachmentResponseAttachmentResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "AttachmentResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("TableOfContentEMagazine");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "epMagID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>TableOfContentEMagazineResponse>TableOfContentEMagazineResult"));
        oper.setReturnClass(com.actionmedia.webservice.buhonline.TableOfContentEMagazineResponseTableOfContentEMagazineResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "TableOfContentEMagazineResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetCalendar");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "year"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "month"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>GetCalendarResponse>GetCalendarResult"));
        oper.setReturnClass(com.actionmedia.webservice.buhonline.GetCalendarResponseGetCalendarResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "GetCalendarResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Settings");
        oper.setReturnType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>SettingsResponse>SettingsResult"));
        oper.setReturnClass(com.actionmedia.webservice.buhonline.SettingsResponseSettingsResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "SettingsResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("TableOfContentDocument");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "moduleID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "ID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>TableOfContentDocumentResponse>TableOfContentDocumentResult"));
        oper.setReturnClass(com.actionmedia.webservice.buhonline.TableOfContentDocumentResponseTableOfContentDocumentResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "TableOfContentDocumentResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DocumentPart");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "moduleID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "ID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "partID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"), short.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>DocumentPartResponse>DocumentPartResult"));
        oper.setReturnClass(com.actionmedia.webservice.buhonline.DocumentPartResponseDocumentPartResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "DocumentPartResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Rubricator");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "rubricatorID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>RubricatorResponse>RubricatorResult"));
        oper.setReturnClass(com.actionmedia.webservice.buhonline.RubricatorResponseRubricatorResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "RubricatorResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ExtendedSearchNumbers");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "Pattern"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>ExtendedSearchNumbersResponse>ExtendedSearchNumbersResult"));
        oper.setReturnClass(com.actionmedia.webservice.buhonline.ExtendedSearchNumbersResponseExtendedSearchNumbersResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "ExtendedSearchNumbersResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ExtendedSearchNumbers2");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "pubDivId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "Pattern"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>ExtendedSearchNumbers2Response>ExtendedSearchNumbers2Result"));
        oper.setReturnClass(com.actionmedia.webservice.buhonline.ExtendedSearchNumbers2ResponseExtendedSearchNumbers2Result.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "ExtendedSearchNumbers2Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ExtendedSearchCatalog");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "PreferedRegionCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>ExtendedSearchCatalogResponse>ExtendedSearchCatalogResult"));
        oper.setReturnClass(com.actionmedia.webservice.buhonline.ExtendedSearchCatalogResponseExtendedSearchCatalogResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "ExtendedSearchCatalogResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ExtendedSearchCatalog2");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "pubDivId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "PreferedRegionCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>ExtendedSearchCatalog2Response>ExtendedSearchCatalog2Result"));
        oper.setReturnClass(com.actionmedia.webservice.buhonline.ExtendedSearchCatalog2ResponseExtendedSearchCatalog2Result.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "ExtendedSearchCatalog2Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("News");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "pubDivId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "period"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "dateOn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>NewsResponse>NewsResult"));
        oper.setReturnClass(com.actionmedia.webservice.buhonline.NewsResponseNewsResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "NewsResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Document");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "moduleID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "ID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "anchor"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "actual"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>DocumentResponse>DocumentResult"));
        oper.setReturnClass(com.actionmedia.webservice.buhonline.DocumentResponseDocumentResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "DocumentResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("XDocument");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "moduleID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "ID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "anchor"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "actual"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>XDocumentResponse>XDocumentResult"));
        oper.setReturnClass(com.actionmedia.webservice.buhonline.XDocumentResponseXDocumentResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "XDocumentResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[18] = oper;

    }

    public BuhonlineSoap12Stub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public BuhonlineSoap12Stub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public BuhonlineSoap12Stub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>AttachmentResponse>AttachmentResult");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.AttachmentResponseAttachmentResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>DocumentPartResponse>DocumentPartResult");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.DocumentPartResponseDocumentPartResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>DocumentResponse>DocumentResult");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.DocumentResponseDocumentResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>ExtendedSearch2Response>ExtendedSearch2Result");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.ExtendedSearch2ResponseExtendedSearch2Result.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>ExtendedSearchCatalog2Response>ExtendedSearchCatalog2Result");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.ExtendedSearchCatalog2ResponseExtendedSearchCatalog2Result.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>ExtendedSearchCatalogResponse>ExtendedSearchCatalogResult");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.ExtendedSearchCatalogResponseExtendedSearchCatalogResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>ExtendedSearchFilter2Response>ExtendedSearchFilter2Result");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.ExtendedSearchFilter2ResponseExtendedSearchFilter2Result.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>ExtendedSearchFilterResponse>ExtendedSearchFilterResult");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.ExtendedSearchFilterResponseExtendedSearchFilterResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>ExtendedSearchNumbers2Response>ExtendedSearchNumbers2Result");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.ExtendedSearchNumbers2ResponseExtendedSearchNumbers2Result.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>ExtendedSearchNumbersResponse>ExtendedSearchNumbersResult");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.ExtendedSearchNumbersResponseExtendedSearchNumbersResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>ExtendedSearchResponse>ExtendedSearchResult");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.ExtendedSearchResponseExtendedSearchResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>GetCalendarResponse>GetCalendarResult");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.GetCalendarResponseGetCalendarResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>NewsResponse>NewsResult");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.NewsResponseNewsResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>RubricatorResponse>RubricatorResult");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.RubricatorResponseRubricatorResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>SearchResponse>SearchResult");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.SearchResponseSearchResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>SettingsResponse>SettingsResult");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.SettingsResponseSettingsResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>TableOfContentDocumentResponse>TableOfContentDocumentResult");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.TableOfContentDocumentResponseTableOfContentDocumentResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>TableOfContentEMagazineResponse>TableOfContentEMagazineResult");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.TableOfContentEMagazineResponseTableOfContentEMagazineResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>XDocumentResponse>XDocumentResult");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.XDocumentResponseXDocumentResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">Attachment");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.Attachment.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">AttachmentResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.AttachmentResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">Document");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.Document.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">DocumentPart");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.DocumentPart.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">DocumentPartResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.DocumentPartResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">DocumentResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.DocumentResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">ExtendedSearch2");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.ExtendedSearch2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">ExtendedSearch2Response");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.ExtendedSearch2Response.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">ExtendedSearchCatalog");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.ExtendedSearchCatalog.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">ExtendedSearchCatalog2");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.ExtendedSearchCatalog2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">ExtendedSearchCatalog2Response");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.ExtendedSearchCatalog2Response.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">ExtendedSearchCatalogResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.ExtendedSearchCatalogResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">ExtendedSearchFilter");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.ExtendedSearchFilter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">ExtendedSearchFilter2");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.ExtendedSearchFilter2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">ExtendedSearchFilter2Response");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.ExtendedSearchFilter2Response.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">ExtendedSearchFilterResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.ExtendedSearchFilterResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">ExtendedSearchNumbers");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.ExtendedSearchNumbers.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">ExtendedSearchNumbers2");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.ExtendedSearchNumbers2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">ExtendedSearchNumbers2Response");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.ExtendedSearchNumbers2Response.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">ExtendedSearchNumbersResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.ExtendedSearchNumbersResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">GetCalendar");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.GetCalendar.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">GetCalendarResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.GetCalendarResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">News");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.News.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">NewsResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.NewsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">Rubricator");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.Rubricator.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">RubricatorResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.RubricatorResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">Search");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.Search.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">SearchResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.SearchResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">Settings");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.Settings.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">SettingsResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.SettingsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">TableOfContentDocument");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.TableOfContentDocument.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">TableOfContentDocumentResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.TableOfContentDocumentResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">TableOfContentEMagazine");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.TableOfContentEMagazine.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">TableOfContentEMagazineResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.TableOfContentEMagazineResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">XDocument");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.XDocument.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">XDocumentResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.XDocumentResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", "ExtendedSearchParameters");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.ExtendedSearchParameters.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://buhonline.1gl.ru", "FilterType");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.buhonline.FilterType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

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

    public com.actionmedia.webservice.buhonline.ExtendedSearchResponseExtendedSearchResult extendedSearch(java.lang.String searchString, int pageNumber, int pageSize, com.actionmedia.webservice.buhonline.ExtendedSearchParameters parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://buhonline.1gl.ru/ExtendedSearch");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "ExtendedSearch"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {searchString, new java.lang.Integer(pageNumber), new java.lang.Integer(pageSize), parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.buhonline.ExtendedSearchResponseExtendedSearchResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.buhonline.ExtendedSearchResponseExtendedSearchResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.buhonline.ExtendedSearchResponseExtendedSearchResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.buhonline.ExtendedSearch2ResponseExtendedSearch2Result extendedSearch2(org.apache.axis.types.UnsignedByte pubDivId, java.lang.String searchString, int pageNumber, int pageSize, com.actionmedia.webservice.buhonline.ExtendedSearchParameters parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://buhonline.1gl.ru/ExtendedSearch2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "ExtendedSearch2"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pubDivId, searchString, new java.lang.Integer(pageNumber), new java.lang.Integer(pageSize), parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.buhonline.ExtendedSearch2ResponseExtendedSearch2Result) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.buhonline.ExtendedSearch2ResponseExtendedSearch2Result) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.buhonline.ExtendedSearch2ResponseExtendedSearch2Result.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.buhonline.SearchResponseSearchResult search(org.apache.axis.types.UnsignedByte pubDivId, java.lang.String searchString, int pageNumber, int pageSize) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://buhonline.1gl.ru/Search");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "Search"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pubDivId, searchString, new java.lang.Integer(pageNumber), new java.lang.Integer(pageSize)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.buhonline.SearchResponseSearchResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.buhonline.SearchResponseSearchResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.buhonline.SearchResponseSearchResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.buhonline.ExtendedSearchFilterResponseExtendedSearchFilterResult extendedSearchFilter(com.actionmedia.webservice.buhonline.FilterType variableAttribute, int regionID, int typeID, int lobbyID, boolean isActual, java.lang.String preferedRegionCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://buhonline.1gl.ru/ExtendedSearchFilter");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "ExtendedSearchFilter"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {variableAttribute, new java.lang.Integer(regionID), new java.lang.Integer(typeID), new java.lang.Integer(lobbyID), new java.lang.Boolean(isActual), preferedRegionCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.buhonline.ExtendedSearchFilterResponseExtendedSearchFilterResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.buhonline.ExtendedSearchFilterResponseExtendedSearchFilterResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.buhonline.ExtendedSearchFilterResponseExtendedSearchFilterResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.buhonline.ExtendedSearchFilter2ResponseExtendedSearchFilter2Result extendedSearchFilter2(org.apache.axis.types.UnsignedByte pubDivId, com.actionmedia.webservice.buhonline.FilterType variableAttribute, int regionID, int typeID, int lobbyID, boolean isActual, java.lang.String preferedRegionCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://buhonline.1gl.ru/ExtendedSearchFilter2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "ExtendedSearchFilter2"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pubDivId, variableAttribute, new java.lang.Integer(regionID), new java.lang.Integer(typeID), new java.lang.Integer(lobbyID), new java.lang.Boolean(isActual), preferedRegionCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.buhonline.ExtendedSearchFilter2ResponseExtendedSearchFilter2Result) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.buhonline.ExtendedSearchFilter2ResponseExtendedSearchFilter2Result) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.buhonline.ExtendedSearchFilter2ResponseExtendedSearchFilter2Result.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.buhonline.AttachmentResponseAttachmentResult attachment(org.apache.axis.types.UnsignedByte moduleId, int attachId) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://buhonline.1gl.ru/Attachment");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "Attachment"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {moduleId, new java.lang.Integer(attachId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.buhonline.AttachmentResponseAttachmentResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.buhonline.AttachmentResponseAttachmentResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.buhonline.AttachmentResponseAttachmentResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.buhonline.TableOfContentEMagazineResponseTableOfContentEMagazineResult tableOfContentEMagazine(int epMagID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://buhonline.1gl.ru/TableOfContentEMagazine");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "TableOfContentEMagazine"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(epMagID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.buhonline.TableOfContentEMagazineResponseTableOfContentEMagazineResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.buhonline.TableOfContentEMagazineResponseTableOfContentEMagazineResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.buhonline.TableOfContentEMagazineResponseTableOfContentEMagazineResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.buhonline.GetCalendarResponseGetCalendarResult getCalendar(int year, int month) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://buhonline.1gl.ru/GetCalendar");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "GetCalendar"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(year), new java.lang.Integer(month)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.buhonline.GetCalendarResponseGetCalendarResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.buhonline.GetCalendarResponseGetCalendarResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.buhonline.GetCalendarResponseGetCalendarResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.buhonline.SettingsResponseSettingsResult settings() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://buhonline.1gl.ru/Settings");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "Settings"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.buhonline.SettingsResponseSettingsResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.buhonline.SettingsResponseSettingsResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.buhonline.SettingsResponseSettingsResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.buhonline.TableOfContentDocumentResponseTableOfContentDocumentResult tableOfContentDocument(org.apache.axis.types.UnsignedByte moduleID, int ID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://buhonline.1gl.ru/TableOfContentDocument");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "TableOfContentDocument"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {moduleID, new java.lang.Integer(ID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.buhonline.TableOfContentDocumentResponseTableOfContentDocumentResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.buhonline.TableOfContentDocumentResponseTableOfContentDocumentResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.buhonline.TableOfContentDocumentResponseTableOfContentDocumentResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.buhonline.DocumentPartResponseDocumentPartResult documentPart(org.apache.axis.types.UnsignedByte moduleID, int ID, short partID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://buhonline.1gl.ru/DocumentPart");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "DocumentPart"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {moduleID, new java.lang.Integer(ID), new java.lang.Short(partID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.buhonline.DocumentPartResponseDocumentPartResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.buhonline.DocumentPartResponseDocumentPartResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.buhonline.DocumentPartResponseDocumentPartResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.buhonline.RubricatorResponseRubricatorResult rubricator(org.apache.axis.types.UnsignedByte rubricatorID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://buhonline.1gl.ru/Rubricator");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "Rubricator"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {rubricatorID});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.buhonline.RubricatorResponseRubricatorResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.buhonline.RubricatorResponseRubricatorResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.buhonline.RubricatorResponseRubricatorResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.buhonline.ExtendedSearchNumbersResponseExtendedSearchNumbersResult extendedSearchNumbers(java.lang.String pattern) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://buhonline.1gl.ru/ExtendedSearchNumbers");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "ExtendedSearchNumbers"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pattern});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.buhonline.ExtendedSearchNumbersResponseExtendedSearchNumbersResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.buhonline.ExtendedSearchNumbersResponseExtendedSearchNumbersResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.buhonline.ExtendedSearchNumbersResponseExtendedSearchNumbersResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.buhonline.ExtendedSearchNumbers2ResponseExtendedSearchNumbers2Result extendedSearchNumbers2(org.apache.axis.types.UnsignedByte pubDivId, java.lang.String pattern) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://buhonline.1gl.ru/ExtendedSearchNumbers2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "ExtendedSearchNumbers2"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pubDivId, pattern});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.buhonline.ExtendedSearchNumbers2ResponseExtendedSearchNumbers2Result) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.buhonline.ExtendedSearchNumbers2ResponseExtendedSearchNumbers2Result) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.buhonline.ExtendedSearchNumbers2ResponseExtendedSearchNumbers2Result.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.buhonline.ExtendedSearchCatalogResponseExtendedSearchCatalogResult extendedSearchCatalog(java.lang.String preferedRegionCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://buhonline.1gl.ru/ExtendedSearchCatalog");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "ExtendedSearchCatalog"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {preferedRegionCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.buhonline.ExtendedSearchCatalogResponseExtendedSearchCatalogResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.buhonline.ExtendedSearchCatalogResponseExtendedSearchCatalogResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.buhonline.ExtendedSearchCatalogResponseExtendedSearchCatalogResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.buhonline.ExtendedSearchCatalog2ResponseExtendedSearchCatalog2Result extendedSearchCatalog2(org.apache.axis.types.UnsignedByte pubDivId, java.lang.String preferedRegionCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://buhonline.1gl.ru/ExtendedSearchCatalog2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "ExtendedSearchCatalog2"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pubDivId, preferedRegionCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.buhonline.ExtendedSearchCatalog2ResponseExtendedSearchCatalog2Result) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.buhonline.ExtendedSearchCatalog2ResponseExtendedSearchCatalog2Result) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.buhonline.ExtendedSearchCatalog2ResponseExtendedSearchCatalog2Result.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.buhonline.NewsResponseNewsResult news(org.apache.axis.types.UnsignedByte pubDivId, int period, java.util.Calendar dateOn) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://buhonline.1gl.ru/News");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "News"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pubDivId, new java.lang.Integer(period), dateOn});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.buhonline.NewsResponseNewsResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.buhonline.NewsResponseNewsResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.buhonline.NewsResponseNewsResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.buhonline.DocumentResponseDocumentResult document(org.apache.axis.types.UnsignedByte moduleID, int ID, java.lang.String anchor, boolean actual) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://buhonline.1gl.ru/Document");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "Document"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {moduleID, new java.lang.Integer(ID), anchor, new java.lang.Boolean(actual)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.buhonline.DocumentResponseDocumentResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.buhonline.DocumentResponseDocumentResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.buhonline.DocumentResponseDocumentResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.buhonline.XDocumentResponseXDocumentResult XDocument(org.apache.axis.types.UnsignedByte moduleID, int ID, java.lang.String anchor, boolean actual) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://buhonline.1gl.ru/XDocument");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "XDocument"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {moduleID, new java.lang.Integer(ID), anchor, new java.lang.Boolean(actual)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.buhonline.XDocumentResponseXDocumentResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.buhonline.XDocumentResponseXDocumentResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.buhonline.XDocumentResponseXDocumentResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
