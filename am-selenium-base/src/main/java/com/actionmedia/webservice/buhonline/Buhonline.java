/**
 * Buhonline.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.buhonline;

public interface Buhonline extends javax.xml.rpc.Service {
    public java.lang.String getBuhonlineSoap12Address();

    public com.actionmedia.webservice.buhonline.BuhonlineSoap_PortType getBuhonlineSoap12() throws javax.xml.rpc.ServiceException;

    public com.actionmedia.webservice.buhonline.BuhonlineSoap_PortType getBuhonlineSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getBuhonlineSoapAddress();

    public com.actionmedia.webservice.buhonline.BuhonlineSoap_PortType getBuhonlineSoap() throws javax.xml.rpc.ServiceException;

    public com.actionmedia.webservice.buhonline.BuhonlineSoap_PortType getBuhonlineSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
