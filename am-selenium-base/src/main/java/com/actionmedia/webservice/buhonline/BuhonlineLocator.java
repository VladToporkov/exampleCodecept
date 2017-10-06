/**
 * BuhonlineLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.buhonline;

public class BuhonlineLocator extends org.apache.axis.client.Service implements com.actionmedia.webservice.buhonline.Buhonline {

    public BuhonlineLocator() {
    }


    public BuhonlineLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BuhonlineLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BuhonlineSoap12
    private java.lang.String BuhonlineSoap12_address = "http://vip.1gl.ru/service/buhonline.asmx";

    public java.lang.String getBuhonlineSoap12Address() {
        return BuhonlineSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BuhonlineSoap12WSDDServiceName = "BuhonlineSoap12";

    public java.lang.String getBuhonlineSoap12WSDDServiceName() {
        return BuhonlineSoap12WSDDServiceName;
    }

    public void setBuhonlineSoap12WSDDServiceName(java.lang.String name) {
        BuhonlineSoap12WSDDServiceName = name;
    }

    public com.actionmedia.webservice.buhonline.BuhonlineSoap_PortType getBuhonlineSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BuhonlineSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBuhonlineSoap12(endpoint);
    }

    public com.actionmedia.webservice.buhonline.BuhonlineSoap_PortType getBuhonlineSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.actionmedia.webservice.buhonline.BuhonlineSoap12Stub _stub = new com.actionmedia.webservice.buhonline.BuhonlineSoap12Stub(portAddress, this);
            _stub.setPortName(getBuhonlineSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBuhonlineSoap12EndpointAddress(java.lang.String address) {
        BuhonlineSoap12_address = address;
    }


    // Use to get a proxy class for BuhonlineSoap
    private java.lang.String BuhonlineSoap_address = "http://vip.1gl.ru/service/buhonline.asmx";

    public java.lang.String getBuhonlineSoapAddress() {
        return BuhonlineSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BuhonlineSoapWSDDServiceName = "BuhonlineSoap";

    public java.lang.String getBuhonlineSoapWSDDServiceName() {
        return BuhonlineSoapWSDDServiceName;
    }

    public void setBuhonlineSoapWSDDServiceName(java.lang.String name) {
        BuhonlineSoapWSDDServiceName = name;
    }

    public com.actionmedia.webservice.buhonline.BuhonlineSoap_PortType getBuhonlineSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BuhonlineSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBuhonlineSoap(endpoint);
    }

    public com.actionmedia.webservice.buhonline.BuhonlineSoap_PortType getBuhonlineSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.actionmedia.webservice.buhonline.BuhonlineSoap_BindingStub _stub = new com.actionmedia.webservice.buhonline.BuhonlineSoap_BindingStub(portAddress, this);
            _stub.setPortName(getBuhonlineSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBuhonlineSoapEndpointAddress(java.lang.String address) {
        BuhonlineSoap_address = address;
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
            if (com.actionmedia.webservice.buhonline.BuhonlineSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.actionmedia.webservice.buhonline.BuhonlineSoap12Stub _stub = new com.actionmedia.webservice.buhonline.BuhonlineSoap12Stub(new java.net.URL(BuhonlineSoap12_address), this);
                _stub.setPortName(getBuhonlineSoap12WSDDServiceName());
                return _stub;
            }
            if (com.actionmedia.webservice.buhonline.BuhonlineSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.actionmedia.webservice.buhonline.BuhonlineSoap_BindingStub _stub = new com.actionmedia.webservice.buhonline.BuhonlineSoap_BindingStub(new java.net.URL(BuhonlineSoap_address), this);
                _stub.setPortName(getBuhonlineSoapWSDDServiceName());
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
        if ("BuhonlineSoap12".equals(inputPortName)) {
            return getBuhonlineSoap12();
        }
        else if ("BuhonlineSoap".equals(inputPortName)) {
            return getBuhonlineSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://buhonline.1gl.ru", "Buhonline");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "BuhonlineSoap12"));
            ports.add(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "BuhonlineSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BuhonlineSoap12".equals(portName)) {
            setBuhonlineSoap12EndpointAddress(address);
        }
        else 
if ("BuhonlineSoap".equals(portName)) {
            setBuhonlineSoapEndpointAddress(address);
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
