/**
 * WsEventProcessorSoap_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.eventservice;

public interface WsEventProcessorSoap_PortType extends java.rmi.Remote {

    /**
     * Получить список типов событий
     */
    public String[] getEventTypeList() throws java.rmi.RemoteException;

    /**
     * Обработать событие
     */
    public DropEventResponseDropEventResult dropEvent(DropEventAEventParametersNode aEventParametersNode) throws java.rmi.RemoteException;
}
