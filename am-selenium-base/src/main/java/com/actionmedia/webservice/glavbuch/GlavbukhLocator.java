/**
 * GlavbukhLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.glavbuch;

public class GlavbukhLocator extends org.apache.axis.client.Service implements com.actionmedia.webservice.glavbuch.Glavbukh {

    public GlavbukhLocator() {
    }


    public GlavbukhLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public GlavbukhLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for GlavbukhSoap
    private java.lang.String GlavbukhSoap_address = "http://bss-rt.actiondigital.ru/service/glavbukh.ru.asmx";

    public java.lang.String getGlavbukhSoapAddress() {
        return GlavbukhSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String GlavbukhSoapWSDDServiceName = "GlavbukhSoap";

    public java.lang.String getGlavbukhSoapWSDDServiceName() {
        return GlavbukhSoapWSDDServiceName;
    }

    public void setGlavbukhSoapWSDDServiceName(java.lang.String name) {
        GlavbukhSoapWSDDServiceName = name;
    }

    public com.actionmedia.webservice.glavbuch.GlavbukhSoap_PortType getGlavbukhSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(GlavbukhSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getGlavbukhSoap(endpoint);
    }

    public com.actionmedia.webservice.glavbuch.GlavbukhSoap_PortType getGlavbukhSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.actionmedia.webservice.glavbuch.GlavbukhSoap_BindingStub _stub = new com.actionmedia.webservice.glavbuch.GlavbukhSoap_BindingStub(portAddress, this);
            _stub.setPortName(getGlavbukhSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setGlavbukhSoapEndpointAddress(java.lang.String address) {
        GlavbukhSoap_address = address;
    }


    // Use to get a proxy class for GlavbukhSoap12
    private java.lang.String GlavbukhSoap12_address = "http://bss-rt.actiondigital.ru/service/glavbukh.ru.asmx";

    public java.lang.String getGlavbukhSoap12Address() {
        return GlavbukhSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String GlavbukhSoap12WSDDServiceName = "GlavbukhSoap12";

    public java.lang.String getGlavbukhSoap12WSDDServiceName() {
        return GlavbukhSoap12WSDDServiceName;
    }

    public void setGlavbukhSoap12WSDDServiceName(java.lang.String name) {
        GlavbukhSoap12WSDDServiceName = name;
    }

    public com.actionmedia.webservice.glavbuch.GlavbukhSoap_PortType getGlavbukhSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(GlavbukhSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getGlavbukhSoap12(endpoint);
    }

    public com.actionmedia.webservice.glavbuch.GlavbukhSoap_PortType getGlavbukhSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.actionmedia.webservice.glavbuch.GlavbukhSoap12Stub _stub = new com.actionmedia.webservice.glavbuch.GlavbukhSoap12Stub(portAddress, this);
            _stub.setPortName(getGlavbukhSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setGlavbukhSoap12EndpointAddress(java.lang.String address) {
        GlavbukhSoap12_address = address;
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
            if (com.actionmedia.webservice.glavbuch.GlavbukhSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.actionmedia.webservice.glavbuch.GlavbukhSoap_BindingStub _stub = new com.actionmedia.webservice.glavbuch.GlavbukhSoap_BindingStub(new java.net.URL(GlavbukhSoap_address), this);
                _stub.setPortName(getGlavbukhSoapWSDDServiceName());
                return _stub;
            }
            if (com.actionmedia.webservice.glavbuch.GlavbukhSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.actionmedia.webservice.glavbuch.GlavbukhSoap12Stub _stub = new com.actionmedia.webservice.glavbuch.GlavbukhSoap12Stub(new java.net.URL(GlavbukhSoap12_address), this);
                _stub.setPortName(getGlavbukhSoap12WSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
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
        if ("GlavbukhSoap".equals(inputPortName)) {
            return getGlavbukhSoap();
        }
        else if ("GlavbukhSoap12".equals(inputPortName)) {
            return getGlavbukhSoap12();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "Glavbukh");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "GlavbukhSoap"));
            ports.add(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "GlavbukhSoap12"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("GlavbukhSoap".equals(portName)) {
            setGlavbukhSoapEndpointAddress(address);
        }
        else 
if ("GlavbukhSoap12".equals(portName)) {
            setGlavbukhSoap12EndpointAddress(address);
        }
        else 
{ // Unknown Port Name
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
