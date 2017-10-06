/**
 * GlavbukhSoap_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.glavbuch;

public interface GlavbukhSoap_PortType extends java.rmi.Remote {

    /**
     * Получение рубикаторов пакета
     */
    public com.actionmedia.webservice.glavbuch.PacketRubricatorResponsePacketRubricatorResult packetRubricator(org.apache.axis.types.UnsignedByte pubDivId, int packetId) throws java.rmi.RemoteException;

    /**
     * Поиск по разделу
     */
    public com.actionmedia.webservice.glavbuch.SearchResponseSearchResult search(java.lang.String searchString, org.apache.axis.types.UnsignedByte pubDivId, int pageNumber) throws java.rmi.RemoteException;

    /**
     * Получение списка изданий
     */
    public com.actionmedia.webservice.glavbuch.PubsResponsePubsResult pubs() throws java.rmi.RemoteException;

    /**
     * Получение формы в XML-формате
     */
    public com.actionmedia.webservice.glavbuch.XDocumentResponseXDocumentResult XDocument(org.apache.axis.types.UnsignedByte modId, int docId, boolean actual) throws java.rmi.RemoteException;

    /**
     * Получение шага мастера
     */
    public com.actionmedia.webservice.glavbuch.WizardStepResponseWizardStepResult wizardStep(org.apache.axis.types.UnsignedByte modId, int docId, java.lang.String answersCSV) throws java.rmi.RemoteException;

    /**
     * Получение рубикатора
     */
    public com.actionmedia.webservice.glavbuch.RubricatorResponseRubricatorResult rubricator(org.apache.axis.types.UnsignedByte pubDivId) throws java.rmi.RemoteException;

    /**
     * Получение настроек
     */
    public com.actionmedia.webservice.glavbuch.SettingsResponseSettingsResult settings() throws java.rmi.RemoteException;

    /**
     * Получение приложения
     */
    public com.actionmedia.webservice.glavbuch.AttachmentResponseAttachmentResult attachment(org.apache.axis.types.UnsignedByte moduleId, int attachId) throws java.rmi.RemoteException;

    /**
     * Поиск по разделу пакета
     */
    public com.actionmedia.webservice.glavbuch.PacketSearchResponsePacketSearchResult packetSearch(java.lang.String searchString, org.apache.axis.types.UnsignedByte pubDivId, Integer pageNumber, Integer packetId, boolean isBss) throws java.rmi.RemoteException;

    /**
     * Получение раздела
     */
    public com.actionmedia.webservice.glavbuch.TabResponseTabResult tab(org.apache.axis.types.UnsignedByte pubDivId, int period, java.util.Calendar date) throws java.rmi.RemoteException;

    /**
     * Получение раздела для пакета
     */
    public com.actionmedia.webservice.glavbuch.PacketTabResponsePacketTabResult packetTab(org.apache.axis.types.UnsignedByte pubDivId, int period, java.util.Calendar date, int packetId) throws java.rmi.RemoteException;

    /**
     * Получить календарь
     */
    public com.actionmedia.webservice.glavbuch.GetCalendarResponseGetCalendarResult getCalendar(int year, int month) throws java.rmi.RemoteException;
}
