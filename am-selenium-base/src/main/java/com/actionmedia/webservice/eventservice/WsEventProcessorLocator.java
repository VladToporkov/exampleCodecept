/**
 * WsEventProcessorLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.eventservice;

import org.apache.commons.logging.LogFactory;
import org.apache.axis.EngineConfiguration;
import org.apache.commons.logging.Log;

public class WsEventProcessorLocator extends org.apache.axis.client.Service implements WsEventProcessor {

    private final Log logger = LogFactory.getLog(getClass());

    public WsEventProcessorLocator() {
    }

    public WsEventProcessorLocator(EngineConfiguration config) {
        super(config);
    }

    public WsEventProcessorLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    private java.lang.String WsEventProcessorSoap12_address = "http://event-processor-service/ws-event-processor.asmx";

    public java.lang.String getWsEventProcessorSoap12Address() {
        return WsEventProcessorSoap12_address;
    }

    private java.lang.String WsEventProcessorSoap12WSDDServiceName = "WsEventProcessorSoap12";

    public java.lang.String getWsEventProcessorSoap12WSDDServiceName() {
        return WsEventProcessorSoap12WSDDServiceName;
    }

    public void setWsEventProcessorSoap12WSDDServiceName(java.lang.String name) {
        WsEventProcessorSoap12WSDDServiceName = name;
    }

    public com.actionmedia.webservice.eventservice.WsEventProcessorSoap_PortType getWsEventProcessorSoap12() throws javax.xml.rpc.ServiceException {
        java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WsEventProcessorSoap12_address);
        } catch (java.net.MalformedURLException e) {
            logger.error("MalformedURLException occurs", e);
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWsEventProcessorSoap12(endpoint);
    }

    public com.actionmedia.webservice.eventservice.WsEventProcessorSoap_PortType getWsEventProcessorSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.actionmedia.webservice.eventservice.WsEventProcessorSoap12Stub _stub = new com.actionmedia.webservice.eventservice.WsEventProcessorSoap12Stub(portAddress, this);
            _stub.setPortName(getWsEventProcessorSoap12WSDDServiceName());
            return _stub;
        } catch (org.apache.axis.AxisFault e) {
            logger.error("AxisFault occurs", e);
            return null;
        }
    }

    public void setWsEventProcessorSoap12EndpointAddress(java.lang.String address) {
        WsEventProcessorSoap12_address = address;
    }

    // Use to get a proxy class for WsEventProcessorSoap
    private String WsEventProcessorSoap_address = "http://event-processor-service/ws-event-processor.asmx";

    public String getWsEventProcessorSoapAddress() {
        return WsEventProcessorSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private String WsEventProcessorSoapWSDDServiceName = "WsEventProcessorSoap";

    public String getWsEventProcessorSoapWSDDServiceName() {
        return WsEventProcessorSoapWSDDServiceName;
    }

    public void setWsEventProcessorSoapWSDDServiceName(java.lang.String name) {
        WsEventProcessorSoapWSDDServiceName = name;
    }

    public com.actionmedia.webservice.eventservice.WsEventProcessorSoap_PortType getWsEventProcessorSoap() throws javax.xml.rpc.ServiceException {
        java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WsEventProcessorSoap_address);
        } catch (java.net.MalformedURLException e) {
            logger.error("MalformedURLException occurs", e);
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWsEventProcessorSoap(endpoint);
    }

    public com.actionmedia.webservice.eventservice.WsEventProcessorSoap_PortType getWsEventProcessorSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.actionmedia.webservice.eventservice.WsEventProcessorSoap_BindingStub _stub = new com.actionmedia.webservice.eventservice.WsEventProcessorSoap_BindingStub(portAddress, this);
            _stub.setPortName(getWsEventProcessorSoapWSDDServiceName());
            return _stub;
        } catch (org.apache.axis.AxisFault e) {
            logger.error("AxisFault occurs", e);
            return null;
        }
    }

    public void setWsEventProcessorSoapEndpointAddress(java.lang.String address) {
        WsEventProcessorSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.actionmedia.webservice.eventservice.WsEventProcessorSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.actionmedia.webservice.eventservice.WsEventProcessorSoap12Stub _stub = new com.actionmedia.webservice.eventservice.WsEventProcessorSoap12Stub(new java.net.URL(WsEventProcessorSoap12_address), this);
                _stub.setPortName(getWsEventProcessorSoap12WSDDServiceName());
                return _stub;
            }
            if (com.actionmedia.webservice.eventservice.WsEventProcessorSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.actionmedia.webservice.eventservice.WsEventProcessorSoap_BindingStub _stub = new com.actionmedia.webservice.eventservice.WsEventProcessorSoap_BindingStub(new java.net.URL(WsEventProcessorSoap_address), this);
                _stub.setPortName(getWsEventProcessorSoapWSDDServiceName());
                return _stub;
            }
        } catch (java.lang.Throwable t) {
            logger.error("Throwable occurs", t);
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WsEventProcessorSoap12".equals(inputPortName)) {
            return getWsEventProcessorSoap12();
        } else if ("WsEventProcessorSoap".equals(inputPortName)) {
            return getWsEventProcessorSoap();
        } else {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://action-media.ru/", "WsEventProcessor");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://action-media.ru/", "WsEventProcessorSoap12"));
            ports.add(new javax.xml.namespace.QName("http://action-media.ru/", "WsEventProcessorSoap"));
        }
        return ports.iterator();
    }

    /**
     * Set the endpoint address for the specified port name.
     */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {

        if ("WsEventProcessorSoap12".equals(portName)) {
            setWsEventProcessorSoap12EndpointAddress(address);
        } else if ("WsEventProcessorSoap".equals(portName)) {
            setWsEventProcessorSoapEndpointAddress(address);
        } else {
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
     * Set the endpoint address for the specified port name.
     */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }
}
