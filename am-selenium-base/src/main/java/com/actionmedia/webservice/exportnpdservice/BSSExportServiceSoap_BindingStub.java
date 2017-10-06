/**
 * BSSExportServiceSoap_BindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.exportnpdservice;

public class BSSExportServiceSoap_BindingStub extends org.apache.axis.client.Stub implements com.actionmedia.webservice.exportnpdservice.BSSExportServiceSoap_PortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[14];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetHyperLinkTargetByGuid");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.1gl.ru/", "LinkGuid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://microsoft.com/wsdl/types/", "guid"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetHyperLinkTargetByGuidResponse"));
        oper.setReturnClass(com.actionmedia.webservice.exportnpdservice.ExecuteGetHyperLinkTargetByGuidResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.1gl.ru/", "GetHyperLinkTargetByGuidResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetNpdAnnouncesForMonth");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.1gl.ru/", "pubIDList"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.1gl.ru/", "ArrayOfUnsignedByte"), org.apache.axis.types.UnsignedByte[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.1gl.ru/", "unsignedByte"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetNpdAnnouncesForMonthResponse"));
        oper.setReturnClass(com.actionmedia.webservice.exportnpdservice.ExecuteGetNpdAnnouncesForMonthResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.1gl.ru/", "GetNpdAnnouncesForMonthResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetDocAttributes");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.1gl.ru/", "ModuleID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.1gl.ru/", "ID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetDocAttrubutesResponse"));
        oper.setReturnClass(com.actionmedia.webservice.exportnpdservice.ExecuteGetDocAttrubutesResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.1gl.ru/", "GetDocAttributesResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ClearCache");
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetDocumentByType");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.1gl.ru/", "TypeID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.1gl.ru/", "PageNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.1gl.ru/", ">>GetDocumentByTypeResponse>GetDocumentByTypeResult"));
        oper.setReturnClass(com.actionmedia.webservice.exportnpdservice.GetDocumentByTypeResponseGetDocumentByTypeResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.1gl.ru/", "GetDocumentByTypeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetMagHyperlinksTable");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.1gl.ru/", "MagId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"), short.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.1gl.ru/", "TimeStamp"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"), byte[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetHyperlinksTableResponse"));
        oper.setReturnClass(com.actionmedia.webservice.exportnpdservice.ExecuteGetHyperlinksTableResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.1gl.ru/", "GetMagHyperlinksTableResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetMagList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.1gl.ru/", "MagazineId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.1gl.ru/", "MagazineNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.1gl.ru/", "MagazineDate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetMagListResponse"));
        oper.setReturnClass(com.actionmedia.webservice.exportnpdservice.ExecuteGetMagListResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.1gl.ru/", "GetMagListResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetDocumentPartById");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.1gl.ru/", "ModuleID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.1gl.ru/", "ID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.1gl.ru/", "PartID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.1gl.ru/", "HlinkTemplate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetDocumentPartByIdResponse"));
        oper.setReturnClass(com.actionmedia.webservice.exportnpdservice.ExecuteGetDocumentPartByIdResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.1gl.ru/", "GetDocumentPartByIdResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetNpdAnnouncesByIndustryForMonth");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.1gl.ru/", "IndustryKind"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.1gl.ru/", "eIndustryFlags"), java.lang.String[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetNpdAnnouncesByIndustryForMonthResponse"));
        oper.setReturnClass(com.actionmedia.webservice.exportnpdservice.ExecuteGetNpdAnnouncesByIndustryForMonthResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.1gl.ru/", "GetNpdAnnouncesByIndustryForMonthResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetNpdDocumentInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.1gl.ru/", "PubId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.1gl.ru/", "ModuleID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.1gl.ru/", "ID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.1gl.ru/", "Anchor"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.1gl.ru/", "HlinkTemplate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetNpdDocumentInfoResponse"));
        oper.setReturnClass(com.actionmedia.webservice.exportnpdservice.ExecuteGetNpdDocumentInfoResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.1gl.ru/", "GetNpdDocumentInfoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetDocTypes");
        oper.setReturnType(new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetDocTypesResponse"));
        oper.setReturnClass(com.actionmedia.webservice.exportnpdservice.ExecuteGetDocTypesResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.1gl.ru/", "GetDocTypesResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetHyperlinksTargets");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.1gl.ru/", "LinkGuids"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.1gl.ru/", "ArrayOfGuid"), java.lang.String[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.1gl.ru/", "guid"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetHyperLinksTargetsResponse"));
        oper.setReturnClass(com.actionmedia.webservice.exportnpdservice.ExecuteGetHyperLinksTargetsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.1gl.ru/", "GetHyperlinksTargetsResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetAnchorsToParts");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.1gl.ru/", "ModuleID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.1gl.ru/", "ID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetAnchorsToPartsResponse"));
        oper.setReturnClass(com.actionmedia.webservice.exportnpdservice.ExecuteGetAnchorsToPartsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.1gl.ru/", "GetAnchorsToPartsResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetDocAttributes2");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.1gl.ru/", "ModuleID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.1gl.ru/", "ID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetDocAttrubutesResponse2"));
        oper.setReturnClass(com.actionmedia.webservice.exportnpdservice.ExecuteGetDocAttrubutesResponse2.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.1gl.ru/", "GetDocAttributes2Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[13] = oper;

    }

    public BSSExportServiceSoap_BindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public BSSExportServiceSoap_BindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public BSSExportServiceSoap_BindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://microsoft.com/wsdl/types/", "guid");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/AbstractTypes", "StringArray");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", ">>GetDocumentByTypeResponse>GetDocumentByTypeResult");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.GetDocumentByTypeResponseGetDocumentByTypeResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", ">GetAnchorsToParts");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.GetAnchorsToParts.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", ">GetAnchorsToPartsResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.GetAnchorsToPartsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", ">GetDocAttributes2");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.GetDocAttributes2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", ">GetDocAttributes2Response");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.GetDocAttributes2Response.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", ">GetDocTypes");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.GetDocTypes.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", ">GetDocTypesResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.GetDocTypesResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", ">GetDocumentPartById");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.GetDocumentPartById.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", ">GetDocumentPartByIdResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.GetDocumentPartByIdResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", ">GetHyperlinksTargets");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.GetHyperlinksTargets.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", ">GetHyperlinksTargetsResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.GetHyperlinksTargetsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", ">GetMagHyperlinksTable");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.GetMagHyperlinksTable.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", ">GetMagHyperlinksTableResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.GetMagHyperlinksTableResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", ">GetMagList");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.GetMagList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", ">GetMagListResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.GetMagListResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", ">GetNpdAnnouncesByIndustryForMonth");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.GetNpdAnnouncesByIndustryForMonth.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", ">GetNpdAnnouncesByIndustryForMonthResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.GetNpdAnnouncesByIndustryForMonthResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", ">GetNpdDocumentInfo");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.GetNpdDocumentInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", ">GetNpdDocumentInfoResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.GetNpdDocumentInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "AnchorsToParts");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.AnchorsToParts.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "ArrayOfAttachBarcode");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.AttachBarcode[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "AttachBarcode");
            qName2 = new javax.xml.namespace.QName("http://www.1gl.ru/", "AttachBarcode");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "ArrayOfAttachment");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.Attachment[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "Attachment");
            qName2 = new javax.xml.namespace.QName("http://www.1gl.ru/", "Attachment");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "ArrayOfGuid");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://microsoft.com/wsdl/types/", "guid");
            qName2 = new javax.xml.namespace.QName("http://www.1gl.ru/", "guid");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "ArrayOfInt");
            cachedSerQNames.add(qName);
            cls = int[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int");
            qName2 = new javax.xml.namespace.QName("http://www.1gl.ru/", "int");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "ArrayOfUnsignedByte");
            cachedSerQNames.add(qName);
            cls = org.apache.axis.types.UnsignedByte[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte");
            qName2 = new javax.xml.namespace.QName("http://www.1gl.ru/", "unsignedByte");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "AttachBarcode");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.AttachBarcode.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "Attachment");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.Attachment.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "AttachmentRow");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.AttachmentRow.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "DocAnnounce");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.DocAnnounce.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "DocAnnounceWithIndustryFlag");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.DocAnnounceWithIndustryFlag.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "DocChainRow");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.DocChainRow.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "DocChainRow2");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.DocChainRow2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "DocSpecification");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.DocSpecification.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "DocumentAttribute");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.DocumentAttribute.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "DocumentChainItem");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.DocumentChainItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "DocumentLinkTarget");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.DocumentLinkTarget.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "DocumentLinkTargetItem");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.DocumentLinkTargetItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "DocumentType");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.DocumentType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "EHyperlinksModified");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.EHyperlinksModified.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "eIndustryFlags");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplelistsf);
            cachedDeserFactories.add(simplelistdf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "eIndustryFlags>null");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.EIndustryFlagsNull.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetAnchorsToPartsResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.ExecuteGetAnchorsToPartsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetDocAttrubutesResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.ExecuteGetDocAttrubutesResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetDocAttrubutesResponse2");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.ExecuteGetDocAttrubutesResponse2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetDocTypesResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.ExecuteGetDocTypesResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetDocumentPartByIdResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.ExecuteGetDocumentPartByIdResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetHyperlinksTableResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.ExecuteGetHyperlinksTableResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetHyperLinksTargetsResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.ExecuteGetHyperLinksTargetsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetHyperLinkTargetByGuidResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.ExecuteGetHyperLinkTargetByGuidResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetMagListResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.ExecuteGetMagListResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetNpdAnnouncesByIndustryForMonthResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.ExecuteGetNpdAnnouncesByIndustryForMonthResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetNpdAnnouncesForMonthResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.ExecuteGetNpdAnnouncesForMonthResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetNpdDocumentInfoResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.ExecuteGetNpdDocumentInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.ExecuteResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "Hyperlink");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.Hyperlink.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.1gl.ru/", "TimeMachinePosition");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.exportnpdservice.TimeMachinePosition.class;
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

    public com.actionmedia.webservice.exportnpdservice.ExecuteGetHyperLinkTargetByGuidResponse getHyperLinkTargetByGuid(java.lang.String linkGuid) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.1gl.ru/GetHyperLinkTargetByGuid");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.1gl.ru/", "GetHyperLinkTargetByGuid"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {linkGuid});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.exportnpdservice.ExecuteGetHyperLinkTargetByGuidResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.exportnpdservice.ExecuteGetHyperLinkTargetByGuidResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.exportnpdservice.ExecuteGetHyperLinkTargetByGuidResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.exportnpdservice.ExecuteGetNpdAnnouncesForMonthResponse getNpdAnnouncesForMonth(org.apache.axis.types.UnsignedByte[] pubIDList) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.1gl.ru/GetNpdAnnouncesForMonth");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.1gl.ru/", "GetNpdAnnouncesForMonth"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pubIDList});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.exportnpdservice.ExecuteGetNpdAnnouncesForMonthResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.exportnpdservice.ExecuteGetNpdAnnouncesForMonthResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.exportnpdservice.ExecuteGetNpdAnnouncesForMonthResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.exportnpdservice.ExecuteGetDocAttrubutesResponse getDocAttributes(org.apache.axis.types.UnsignedByte moduleID, int ID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.1gl.ru/GetDocAttributes");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.1gl.ru/", "GetDocAttributes"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {moduleID, new java.lang.Integer(ID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.exportnpdservice.ExecuteGetDocAttrubutesResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.exportnpdservice.ExecuteGetDocAttrubutesResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.exportnpdservice.ExecuteGetDocAttrubutesResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void clearCache() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.1gl.ru/ClearCache");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.1gl.ru/", "ClearCache"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.exportnpdservice.GetDocumentByTypeResponseGetDocumentByTypeResult getDocumentByType(int typeID, int pageNumber) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.1gl.ru/GetDocumentByType");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.1gl.ru/", "GetDocumentByType"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(typeID), new java.lang.Integer(pageNumber)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.exportnpdservice.GetDocumentByTypeResponseGetDocumentByTypeResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.exportnpdservice.GetDocumentByTypeResponseGetDocumentByTypeResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.exportnpdservice.GetDocumentByTypeResponseGetDocumentByTypeResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.exportnpdservice.ExecuteGetHyperlinksTableResponse getMagHyperlinksTable(short magId, byte[] timeStamp) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.1gl.ru/GetMagHyperlinksTable");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.1gl.ru/", "GetMagHyperlinksTable"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Short(magId), timeStamp});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.exportnpdservice.ExecuteGetHyperlinksTableResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.exportnpdservice.ExecuteGetHyperlinksTableResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.exportnpdservice.ExecuteGetHyperlinksTableResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.exportnpdservice.ExecuteGetMagListResponse getMagList(org.apache.axis.types.UnsignedByte magazineId, int magazineNumber, java.util.Calendar magazineDate) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.1gl.ru/GetMagList");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.1gl.ru/", "GetMagList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {magazineId, new java.lang.Integer(magazineNumber), magazineDate});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.exportnpdservice.ExecuteGetMagListResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.exportnpdservice.ExecuteGetMagListResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.exportnpdservice.ExecuteGetMagListResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.exportnpdservice.ExecuteGetDocumentPartByIdResponse getDocumentPartById(org.apache.axis.types.UnsignedByte moduleID, int ID, int partID, java.lang.String hlinkTemplate) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.1gl.ru/GetDocumentPartById");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.1gl.ru/", "GetDocumentPartById"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {moduleID, new java.lang.Integer(ID), new java.lang.Integer(partID), hlinkTemplate});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.exportnpdservice.ExecuteGetDocumentPartByIdResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.exportnpdservice.ExecuteGetDocumentPartByIdResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.exportnpdservice.ExecuteGetDocumentPartByIdResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.exportnpdservice.ExecuteGetNpdAnnouncesByIndustryForMonthResponse getNpdAnnouncesByIndustryForMonth(java.lang.String[] industryKind) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.1gl.ru/GetNpdAnnouncesByIndustryForMonth");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.1gl.ru/", "GetNpdAnnouncesByIndustryForMonth"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {industryKind});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.exportnpdservice.ExecuteGetNpdAnnouncesByIndustryForMonthResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.exportnpdservice.ExecuteGetNpdAnnouncesByIndustryForMonthResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.exportnpdservice.ExecuteGetNpdAnnouncesByIndustryForMonthResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.exportnpdservice.ExecuteGetNpdDocumentInfoResponse getNpdDocumentInfo(org.apache.axis.types.UnsignedByte pubId, org.apache.axis.types.UnsignedByte moduleID, int ID, java.lang.String anchor, java.lang.String hlinkTemplate) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.1gl.ru/GetNpdDocumentInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.1gl.ru/", "GetNpdDocumentInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pubId, moduleID, new java.lang.Integer(ID), anchor, hlinkTemplate});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.exportnpdservice.ExecuteGetNpdDocumentInfoResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.exportnpdservice.ExecuteGetNpdDocumentInfoResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.exportnpdservice.ExecuteGetNpdDocumentInfoResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.exportnpdservice.ExecuteGetDocTypesResponse getDocTypes() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.1gl.ru/GetDocTypes");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.1gl.ru/", "GetDocTypes"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.exportnpdservice.ExecuteGetDocTypesResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.exportnpdservice.ExecuteGetDocTypesResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.exportnpdservice.ExecuteGetDocTypesResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.exportnpdservice.ExecuteGetHyperLinksTargetsResponse getHyperlinksTargets(java.lang.String[] linkGuids) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.1gl.ru/GetHyperlinksTargets");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.1gl.ru/", "GetHyperlinksTargets"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {linkGuids});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.exportnpdservice.ExecuteGetHyperLinksTargetsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.exportnpdservice.ExecuteGetHyperLinksTargetsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.exportnpdservice.ExecuteGetHyperLinksTargetsResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.exportnpdservice.ExecuteGetAnchorsToPartsResponse getAnchorsToParts(org.apache.axis.types.UnsignedByte moduleID, int ID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.1gl.ru/GetAnchorsToParts");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.1gl.ru/", "GetAnchorsToParts"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {moduleID, new java.lang.Integer(ID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.exportnpdservice.ExecuteGetAnchorsToPartsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.exportnpdservice.ExecuteGetAnchorsToPartsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.exportnpdservice.ExecuteGetAnchorsToPartsResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.exportnpdservice.ExecuteGetDocAttrubutesResponse2 getDocAttributes2(org.apache.axis.types.UnsignedByte moduleID, int ID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.1gl.ru/GetDocAttributes2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.1gl.ru/", "GetDocAttributes2"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {moduleID, new java.lang.Integer(ID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.exportnpdservice.ExecuteGetDocAttrubutesResponse2) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.exportnpdservice.ExecuteGetDocAttrubutesResponse2) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.exportnpdservice.ExecuteGetDocAttrubutesResponse2.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
