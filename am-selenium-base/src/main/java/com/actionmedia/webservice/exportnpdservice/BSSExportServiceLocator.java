/**
 * BSSExportServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.exportnpdservice;

public class BSSExportServiceLocator extends org.apache.axis.client.Service implements com.actionmedia.webservice.exportnpdservice.BSSExportService {

    public BSSExportServiceLocator() {
    }


    public BSSExportServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BSSExportServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BSSExportServiceSoap12
    private java.lang.String BSSExportServiceSoap12_address = "http://bssexport.1gl.ru/BssExportService.asmx";

    public java.lang.String getBSSExportServiceSoap12Address() {
        return BSSExportServiceSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BSSExportServiceSoap12WSDDServiceName = "BSSExportServiceSoap12";

    public java.lang.String getBSSExportServiceSoap12WSDDServiceName() {
        return BSSExportServiceSoap12WSDDServiceName;
    }

    public void setBSSExportServiceSoap12WSDDServiceName(java.lang.String name) {
        BSSExportServiceSoap12WSDDServiceName = name;
    }

    public com.actionmedia.webservice.exportnpdservice.BSSExportServiceSoap_PortType getBSSExportServiceSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BSSExportServiceSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBSSExportServiceSoap12(endpoint);
    }

    public com.actionmedia.webservice.exportnpdservice.BSSExportServiceSoap_PortType getBSSExportServiceSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.actionmedia.webservice.exportnpdservice.BSSExportServiceSoap12Stub _stub = new com.actionmedia.webservice.exportnpdservice.BSSExportServiceSoap12Stub(portAddress, this);
            _stub.setPortName(getBSSExportServiceSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBSSExportServiceSoap12EndpointAddress(java.lang.String address) {
        BSSExportServiceSoap12_address = address;
    }


    // Use to get a proxy class for BSSExportServiceSoap
    private java.lang.String BSSExportServiceSoap_address = "http://bssexport.1gl.ru/BssExportService.asmx";

    public java.lang.String getBSSExportServiceSoapAddress() {
        return BSSExportServiceSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BSSExportServiceSoapWSDDServiceName = "BSSExportServiceSoap";

    public java.lang.String getBSSExportServiceSoapWSDDServiceName() {
        return BSSExportServiceSoapWSDDServiceName;
    }

    public void setBSSExportServiceSoapWSDDServiceName(java.lang.String name) {
        BSSExportServiceSoapWSDDServiceName = name;
    }

    public com.actionmedia.webservice.exportnpdservice.BSSExportServiceSoap_PortType getBSSExportServiceSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BSSExportServiceSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBSSExportServiceSoap(endpoint);
    }

    public com.actionmedia.webservice.exportnpdservice.BSSExportServiceSoap_PortType getBSSExportServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.actionmedia.webservice.exportnpdservice.BSSExportServiceSoap_BindingStub _stub = new com.actionmedia.webservice.exportnpdservice.BSSExportServiceSoap_BindingStub(portAddress, this);
            _stub.setPortName(getBSSExportServiceSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBSSExportServiceSoapEndpointAddress(java.lang.String address) {
        BSSExportServiceSoap_address = address;
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
            if (com.actionmedia.webservice.exportnpdservice.BSSExportServiceSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.actionmedia.webservice.exportnpdservice.BSSExportServiceSoap12Stub _stub = new com.actionmedia.webservice.exportnpdservice.BSSExportServiceSoap12Stub(new java.net.URL(BSSExportServiceSoap12_address), this);
                _stub.setPortName(getBSSExportServiceSoap12WSDDServiceName());
                return _stub;
            }
            if (com.actionmedia.webservice.exportnpdservice.BSSExportServiceSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.actionmedia.webservice.exportnpdservice.BSSExportServiceSoap_BindingStub _stub = new com.actionmedia.webservice.exportnpdservice.BSSExportServiceSoap_BindingStub(new java.net.URL(BSSExportServiceSoap_address), this);
                _stub.setPortName(getBSSExportServiceSoapWSDDServiceName());
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
        if ("BSSExportServiceSoap12".equals(inputPortName)) {
            return getBSSExportServiceSoap12();
        }
        else if ("BSSExportServiceSoap".equals(inputPortName)) {
            return getBSSExportServiceSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.1gl.ru/", "BSSExportService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.1gl.ru/", "BSSExportServiceSoap12"));
            ports.add(new javax.xml.namespace.QName("http://www.1gl.ru/", "BSSExportServiceSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BSSExportServiceSoap12".equals(portName)) {
            setBSSExportServiceSoap12EndpointAddress(address);
        }
        else 
if ("BSSExportServiceSoap".equals(portName)) {
            setBSSExportServiceSoapEndpointAddress(address);
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
