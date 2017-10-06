/**
 * BSSExportService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.exportnpdservice;

public interface BSSExportService extends javax.xml.rpc.Service {
    public java.lang.String getBSSExportServiceSoap12Address();

    public com.actionmedia.webservice.exportnpdservice.BSSExportServiceSoap_PortType getBSSExportServiceSoap12() throws javax.xml.rpc.ServiceException;

    public com.actionmedia.webservice.exportnpdservice.BSSExportServiceSoap_PortType getBSSExportServiceSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getBSSExportServiceSoapAddress();

    public com.actionmedia.webservice.exportnpdservice.BSSExportServiceSoap_PortType getBSSExportServiceSoap() throws javax.xml.rpc.ServiceException;

    public com.actionmedia.webservice.exportnpdservice.BSSExportServiceSoap_PortType getBSSExportServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
