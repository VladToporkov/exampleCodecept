/**
 * SearchServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class SearchServiceLocator extends org.apache.axis.client.Service implements com.actionmedia.webservice.searchservice.SearchService {

    public SearchServiceLocator() {
    }


    public SearchServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SearchServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BasicHttpBinding_ISearchService
    private java.lang.String BasicHttpBinding_ISearchService_address = "http://search-service-actiondigital/SearchService.svc";

    public java.lang.String getBasicHttpBinding_ISearchServiceAddress() {
        return BasicHttpBinding_ISearchService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BasicHttpBinding_ISearchServiceWSDDServiceName = "BasicHttpBinding_ISearchService";

    public java.lang.String getBasicHttpBinding_ISearchServiceWSDDServiceName() {
        return BasicHttpBinding_ISearchServiceWSDDServiceName;
    }

    public void setBasicHttpBinding_ISearchServiceWSDDServiceName(java.lang.String name) {
        BasicHttpBinding_ISearchServiceWSDDServiceName = name;
    }

    public com.actionmedia.webservice.searchservice.ISearchService getBasicHttpBinding_ISearchService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BasicHttpBinding_ISearchService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBasicHttpBinding_ISearchService(endpoint);
    }

    public com.actionmedia.webservice.searchservice.ISearchService getBasicHttpBinding_ISearchService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.actionmedia.webservice.searchservice.BasicHttpBinding_ISearchServiceStub _stub = new com.actionmedia.webservice.searchservice.BasicHttpBinding_ISearchServiceStub(portAddress, this);
            _stub.setPortName(getBasicHttpBinding_ISearchServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBasicHttpBinding_ISearchServiceEndpointAddress(java.lang.String address) {
        BasicHttpBinding_ISearchService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.actionmedia.webservice.searchservice.ISearchService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.actionmedia.webservice.searchservice.BasicHttpBinding_ISearchServiceStub _stub = new com.actionmedia.webservice.searchservice.BasicHttpBinding_ISearchServiceStub(new java.net.URL(BasicHttpBinding_ISearchService_address), this);
                _stub.setPortName(getBasicHttpBinding_ISearchServiceWSDDServiceName());
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
        if ("BasicHttpBinding_ISearchService".equals(inputPortName)) {
            return getBasicHttpBinding_ISearchService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "SearchService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "BasicHttpBinding_ISearchService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BasicHttpBinding_ISearchService".equals(portName)) {
            setBasicHttpBinding_ISearchServiceEndpointAddress(address);
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
