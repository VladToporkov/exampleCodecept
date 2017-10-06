/**
 * ActionBonusServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.actionbonus.proxyservice;

public class ActionBonusServiceLocator extends org.apache.axis.client.Service implements com.actionmedia.webservice.actionbonus.proxyservice.ActionBonusService {

    public ActionBonusServiceLocator() {
    }


    public ActionBonusServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ActionBonusServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BasicHttpBinding_IActionBonusService
    private java.lang.String BasicHttpBinding_IActionBonusService_address = "http://actionbonus-service-rt/ActionBonusService.svc/soap";

    public java.lang.String getBasicHttpBinding_IActionBonusServiceAddress() {
        return BasicHttpBinding_IActionBonusService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BasicHttpBinding_IActionBonusServiceWSDDServiceName = "BasicHttpBinding_IActionBonusService";

    public java.lang.String getBasicHttpBinding_IActionBonusServiceWSDDServiceName() {
        return BasicHttpBinding_IActionBonusServiceWSDDServiceName;
    }

    public void setBasicHttpBinding_IActionBonusServiceWSDDServiceName(java.lang.String name) {
        BasicHttpBinding_IActionBonusServiceWSDDServiceName = name;
    }

    public com.actionmedia.webservice.actionbonus.proxyservice.IActionBonusService getBasicHttpBinding_IActionBonusService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BasicHttpBinding_IActionBonusService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBasicHttpBinding_IActionBonusService(endpoint);
    }

    public com.actionmedia.webservice.actionbonus.proxyservice.IActionBonusService getBasicHttpBinding_IActionBonusService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.actionmedia.webservice.actionbonus.proxyservice.BasicHttpBinding_IActionBonusServiceStub _stub = new com.actionmedia.webservice.actionbonus.proxyservice.BasicHttpBinding_IActionBonusServiceStub(portAddress, this);
            _stub.setPortName(getBasicHttpBinding_IActionBonusServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBasicHttpBinding_IActionBonusServiceEndpointAddress(java.lang.String address) {
        BasicHttpBinding_IActionBonusService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.actionmedia.webservice.actionbonus.proxyservice.IActionBonusService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.actionmedia.webservice.actionbonus.proxyservice.BasicHttpBinding_IActionBonusServiceStub _stub = new com.actionmedia.webservice.actionbonus.proxyservice.BasicHttpBinding_IActionBonusServiceStub(new java.net.URL(BasicHttpBinding_IActionBonusService_address), this);
                _stub.setPortName(getBasicHttpBinding_IActionBonusServiceWSDDServiceName());
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
        if ("BasicHttpBinding_IActionBonusService".equals(inputPortName)) {
            return getBasicHttpBinding_IActionBonusService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "ActionBonusService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "BasicHttpBinding_IActionBonusService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BasicHttpBinding_IActionBonusService".equals(portName)) {
            setBasicHttpBinding_IActionBonusServiceEndpointAddress(address);
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
