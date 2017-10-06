/**
 * SearchExtendedLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchextendedservice;

public class SearchExtendedLocator extends org.apache.axis.client.Service implements com.actionmedia.webservice.searchextendedservice.SearchExtended {

    public SearchExtendedLocator() {
    }


    public SearchExtendedLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SearchExtendedLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SearchExtendedSoap
    private java.lang.String SearchExtendedSoap_address = "http://www.1gl.ru/service/search-extended.asmx";

    public java.lang.String getSearchExtendedSoapAddress() {
        return SearchExtendedSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SearchExtendedSoapWSDDServiceName = "SearchExtendedSoap";

    public java.lang.String getSearchExtendedSoapWSDDServiceName() {
        return SearchExtendedSoapWSDDServiceName;
    }

    public void setSearchExtendedSoapWSDDServiceName(java.lang.String name) {
        SearchExtendedSoapWSDDServiceName = name;
    }

    public com.actionmedia.webservice.searchextendedservice.SearchExtendedSoap_PortType getSearchExtendedSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SearchExtendedSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSearchExtendedSoap(endpoint);
    }

    public com.actionmedia.webservice.searchextendedservice.SearchExtendedSoap_PortType getSearchExtendedSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.actionmedia.webservice.searchextendedservice.SearchExtendedSoap_BindingStub _stub = new com.actionmedia.webservice.searchextendedservice.SearchExtendedSoap_BindingStub(portAddress, this);
            _stub.setPortName(getSearchExtendedSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSearchExtendedSoapEndpointAddress(java.lang.String address) {
        SearchExtendedSoap_address = address;
    }


    // Use to get a proxy class for SearchExtendedSoap12
    private java.lang.String SearchExtendedSoap12_address = "http://www.1gl.ru/service/search-extended.asmx";

    public java.lang.String getSearchExtendedSoap12Address() {
        return SearchExtendedSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SearchExtendedSoap12WSDDServiceName = "SearchExtendedSoap12";

    public java.lang.String getSearchExtendedSoap12WSDDServiceName() {
        return SearchExtendedSoap12WSDDServiceName;
    }

    public void setSearchExtendedSoap12WSDDServiceName(java.lang.String name) {
        SearchExtendedSoap12WSDDServiceName = name;
    }

    public com.actionmedia.webservice.searchextendedservice.SearchExtendedSoap_PortType getSearchExtendedSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SearchExtendedSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSearchExtendedSoap12(endpoint);
    }

    public com.actionmedia.webservice.searchextendedservice.SearchExtendedSoap_PortType getSearchExtendedSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.actionmedia.webservice.searchextendedservice.SearchExtendedSoap12Stub _stub = new com.actionmedia.webservice.searchextendedservice.SearchExtendedSoap12Stub(portAddress, this);
            _stub.setPortName(getSearchExtendedSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSearchExtendedSoap12EndpointAddress(java.lang.String address) {
        SearchExtendedSoap12_address = address;
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
            if (com.actionmedia.webservice.searchextendedservice.SearchExtendedSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.actionmedia.webservice.searchextendedservice.SearchExtendedSoap_BindingStub _stub = new com.actionmedia.webservice.searchextendedservice.SearchExtendedSoap_BindingStub(new java.net.URL(SearchExtendedSoap_address), this);
                _stub.setPortName(getSearchExtendedSoapWSDDServiceName());
                return _stub;
            }
            if (com.actionmedia.webservice.searchextendedservice.SearchExtendedSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.actionmedia.webservice.searchextendedservice.SearchExtendedSoap12Stub _stub = new com.actionmedia.webservice.searchextendedservice.SearchExtendedSoap12Stub(new java.net.URL(SearchExtendedSoap12_address), this);
                _stub.setPortName(getSearchExtendedSoap12WSDDServiceName());
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
        if ("SearchExtendedSoap".equals(inputPortName)) {
            return getSearchExtendedSoap();
        }
        else if ("SearchExtendedSoap12".equals(inputPortName)) {
            return getSearchExtendedSoap12();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "SearchExtended");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "SearchExtendedSoap"));
            ports.add(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "SearchExtendedSoap12"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SearchExtendedSoap".equals(portName)) {
            setSearchExtendedSoapEndpointAddress(address);
        }
        else 
if ("SearchExtendedSoap12".equals(portName)) {
            setSearchExtendedSoap12EndpointAddress(address);
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
