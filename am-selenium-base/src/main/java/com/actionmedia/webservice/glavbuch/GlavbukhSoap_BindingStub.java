/**
 * GlavbukhSoap_BindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.glavbuch;

public class GlavbukhSoap_BindingStub extends org.apache.axis.client.Stub implements com.actionmedia.webservice.glavbuch.GlavbukhSoap_PortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[12];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("PacketRubricator");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "PubDivId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "PacketId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">>PacketRubricatorResponse>PacketRubricatorResult"));
        oper.setReturnClass(com.actionmedia.webservice.glavbuch.PacketRubricatorResponsePacketRubricatorResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "PacketRubricatorResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Search");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "SearchString"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "PubDivId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "PageNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">>SearchResponse>SearchResult"));
        oper.setReturnClass(com.actionmedia.webservice.glavbuch.SearchResponseSearchResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "SearchResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Pubs");
        oper.setReturnType(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">>PubsResponse>PubsResult"));
        oper.setReturnClass(com.actionmedia.webservice.glavbuch.PubsResponsePubsResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "PubsResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("XDocument");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "ModId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "DocId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "Actual"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">>XDocumentResponse>XDocumentResult"));
        oper.setReturnClass(com.actionmedia.webservice.glavbuch.XDocumentResponseXDocumentResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "XDocumentResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("WizardStep");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "ModId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "DocId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "AnswersCSV"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">>WizardStepResponse>WizardStepResult"));
        oper.setReturnClass(com.actionmedia.webservice.glavbuch.WizardStepResponseWizardStepResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "WizardStepResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Rubricator");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "PubDivId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">>RubricatorResponse>RubricatorResult"));
        oper.setReturnClass(com.actionmedia.webservice.glavbuch.RubricatorResponseRubricatorResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "RubricatorResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Settings");
        oper.setReturnType(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">>SettingsResponse>SettingsResult"));
        oper.setReturnClass(com.actionmedia.webservice.glavbuch.SettingsResponseSettingsResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "SettingsResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Attachment");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "ModuleId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "AttachId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">>AttachmentResponse>AttachmentResult"));
        oper.setReturnClass(com.actionmedia.webservice.glavbuch.AttachmentResponseAttachmentResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "AttachmentResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("PacketSearch");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "SearchString"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "PubDivId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "PageNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "PacketId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), java.lang.Integer.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">>PacketSearchResponse>PacketSearchResult"));
        oper.setReturnClass(com.actionmedia.webservice.glavbuch.PacketSearchResponsePacketSearchResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "PacketSearchResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Tab");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "PubDivId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "Period"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "Date"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">>TabResponse>TabResult"));
        oper.setReturnClass(com.actionmedia.webservice.glavbuch.TabResponseTabResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "TabResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("PacketTab");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "PubDivId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "Period"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "Date"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "PacketId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">>PacketTabResponse>PacketTabResult"));
        oper.setReturnClass(com.actionmedia.webservice.glavbuch.PacketTabResponsePacketTabResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "PacketTabResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetCalendar");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "year"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "month"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">>GetCalendarResponse>GetCalendarResult"));
        oper.setReturnClass(com.actionmedia.webservice.glavbuch.GetCalendarResponseGetCalendarResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "GetCalendarResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

    }

    public GlavbukhSoap_BindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public GlavbukhSoap_BindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public GlavbukhSoap_BindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">>AttachmentResponse>AttachmentResult");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.AttachmentResponseAttachmentResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">>GetCalendarResponse>GetCalendarResult");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.GetCalendarResponseGetCalendarResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">>PacketRubricatorResponse>PacketRubricatorResult");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.PacketRubricatorResponsePacketRubricatorResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">>PacketSearchResponse>PacketSearchResult");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.PacketSearchResponsePacketSearchResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">>PacketTabResponse>PacketTabResult");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.PacketTabResponsePacketTabResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">>PubsResponse>PubsResult");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.PubsResponsePubsResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">>RubricatorResponse>RubricatorResult");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.RubricatorResponseRubricatorResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">>SearchResponse>SearchResult");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.SearchResponseSearchResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">>SettingsResponse>SettingsResult");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.SettingsResponseSettingsResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">>TabResponse>TabResult");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.TabResponseTabResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">>WizardStepResponse>WizardStepResult");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.WizardStepResponseWizardStepResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">>XDocumentResponse>XDocumentResult");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.XDocumentResponseXDocumentResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">Attachment");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.Attachment.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">AttachmentResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.AttachmentResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">GetCalendar");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.GetCalendar.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">GetCalendarResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.GetCalendarResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">PacketSearch");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.PacketSearch.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">PacketSearchResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.PacketSearchResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">PacketTab");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.PacketTab.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">PacketTabResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.PacketTabResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">Pubs");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.Pubs.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">PubsResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.PubsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">Rubricator");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.Rubricator.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">RubricatorResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.RubricatorResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">Search");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.Search.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">SearchResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.SearchResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">Settings");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.Settings.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">SettingsResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.SettingsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">Tab");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.Tab.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">TabResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.TabResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">WizardStep");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.WizardStep.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">WizardStepResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.WizardStepResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">XDocument");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.XDocument.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">XDocumentResponse");
            cachedSerQNames.add(qName);
            cls = com.actionmedia.webservice.glavbuch.XDocumentResponse.class;
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

    public com.actionmedia.webservice.glavbuch.PacketRubricatorResponsePacketRubricatorResult packetRubricator(org.apache.axis.types.UnsignedByte pubDivId, int packetId) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://glavbukh.ru.1gl.ru/PacketRubricator");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "PacketRubricator"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pubDivId, new java.lang.Integer(packetId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.glavbuch.PacketRubricatorResponsePacketRubricatorResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.glavbuch.PacketRubricatorResponsePacketRubricatorResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.glavbuch.PacketRubricatorResponsePacketRubricatorResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.glavbuch.SearchResponseSearchResult search(java.lang.String searchString, org.apache.axis.types.UnsignedByte pubDivId, int pageNumber) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://glavbukh.ru.1gl.ru/Search");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "Search"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {searchString, pubDivId, new java.lang.Integer(pageNumber)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.glavbuch.SearchResponseSearchResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.glavbuch.SearchResponseSearchResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.glavbuch.SearchResponseSearchResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.glavbuch.PubsResponsePubsResult pubs() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://glavbukh.ru.1gl.ru/Pubs");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "Pubs"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.glavbuch.PubsResponsePubsResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.glavbuch.PubsResponsePubsResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.glavbuch.PubsResponsePubsResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.glavbuch.XDocumentResponseXDocumentResult XDocument(org.apache.axis.types.UnsignedByte modId, int docId, boolean actual) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://glavbukh.ru.1gl.ru/XDocument");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "XDocument"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {modId, new java.lang.Integer(docId), new java.lang.Boolean(actual)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.glavbuch.XDocumentResponseXDocumentResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.glavbuch.XDocumentResponseXDocumentResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.glavbuch.XDocumentResponseXDocumentResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.glavbuch.WizardStepResponseWizardStepResult wizardStep(org.apache.axis.types.UnsignedByte modId, int docId, java.lang.String answersCSV) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://glavbukh.ru.1gl.ru/WizardStep");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "WizardStep"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {modId, new java.lang.Integer(docId), answersCSV});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.glavbuch.WizardStepResponseWizardStepResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.glavbuch.WizardStepResponseWizardStepResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.glavbuch.WizardStepResponseWizardStepResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.glavbuch.RubricatorResponseRubricatorResult rubricator(org.apache.axis.types.UnsignedByte pubDivId) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://glavbukh.ru.1gl.ru/Rubricator");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "Rubricator"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pubDivId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.glavbuch.RubricatorResponseRubricatorResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.glavbuch.RubricatorResponseRubricatorResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.glavbuch.RubricatorResponseRubricatorResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.glavbuch.SettingsResponseSettingsResult settings() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://glavbukh.ru.1gl.ru/Settings");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "Settings"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.glavbuch.SettingsResponseSettingsResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.glavbuch.SettingsResponseSettingsResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.glavbuch.SettingsResponseSettingsResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.glavbuch.AttachmentResponseAttachmentResult attachment(org.apache.axis.types.UnsignedByte moduleId, int attachId) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://glavbukh.ru.1gl.ru/Attachment");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "Attachment"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {moduleId, new java.lang.Integer(attachId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.glavbuch.AttachmentResponseAttachmentResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.glavbuch.AttachmentResponseAttachmentResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.glavbuch.AttachmentResponseAttachmentResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.glavbuch.PacketSearchResponsePacketSearchResult packetSearch(java.lang.String searchString, org.apache.axis.types.UnsignedByte pubDivId, Integer pageNumber, Integer packetId, boolean isBss) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://glavbukh.ru.1gl.ru/PacketSearch");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "PacketSearch"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {searchString, pubDivId, new java.lang.Integer(pageNumber), isBss ?  new java.lang.Integer(packetId): null});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.glavbuch.PacketSearchResponsePacketSearchResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.glavbuch.PacketSearchResponsePacketSearchResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.glavbuch.PacketSearchResponsePacketSearchResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.glavbuch.TabResponseTabResult tab(org.apache.axis.types.UnsignedByte pubDivId, int period, java.util.Calendar date) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://glavbukh.ru.1gl.ru/Tab");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "Tab"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pubDivId, new java.lang.Integer(period), date});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.glavbuch.TabResponseTabResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.glavbuch.TabResponseTabResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.glavbuch.TabResponseTabResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.glavbuch.PacketTabResponsePacketTabResult packetTab(org.apache.axis.types.UnsignedByte pubDivId, int period, java.util.Calendar date, int packetId) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://glavbukh.ru.1gl.ru/PacketTab");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "PacketTab"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pubDivId, new java.lang.Integer(period), date, new java.lang.Integer(packetId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.glavbuch.PacketTabResponsePacketTabResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.glavbuch.PacketTabResponsePacketTabResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.glavbuch.PacketTabResponsePacketTabResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.actionmedia.webservice.glavbuch.GetCalendarResponseGetCalendarResult getCalendar(int year, int month) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://glavbukh.ru.1gl.ru/GetCalendar");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "GetCalendar"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(year), new java.lang.Integer(month)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.actionmedia.webservice.glavbuch.GetCalendarResponseGetCalendarResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.actionmedia.webservice.glavbuch.GetCalendarResponseGetCalendarResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.actionmedia.webservice.glavbuch.GetCalendarResponseGetCalendarResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
