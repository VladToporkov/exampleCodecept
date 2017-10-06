/**
 * BuhonlineSoap_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.buhonline;

public interface BuhonlineSoap_PortType extends java.rmi.Remote {

    /**
     * Поиск НПД по реквизитам
     */
    public com.actionmedia.webservice.buhonline.ExtendedSearchResponseExtendedSearchResult extendedSearch(java.lang.String searchString, int pageNumber, int pageSize, com.actionmedia.webservice.buhonline.ExtendedSearchParameters parameters) throws java.rmi.RemoteException;

    /**
     * Поиск НПД по реквизитам (с указанием раздела: 3-НПД, 13-АП)
     */
    public com.actionmedia.webservice.buhonline.ExtendedSearch2ResponseExtendedSearch2Result extendedSearch2(org.apache.axis.types.UnsignedByte pubDivId, java.lang.String searchString, int pageNumber, int pageSize, com.actionmedia.webservice.buhonline.ExtendedSearchParameters parameters) throws java.rmi.RemoteException;

    /**
     * Поиск по разделу
     */
    public com.actionmedia.webservice.buhonline.SearchResponseSearchResult search(org.apache.axis.types.UnsignedByte pubDivId, java.lang.String searchString, int pageNumber, int pageSize) throws java.rmi.RemoteException;

    /**
     * Поиск НПД по реквизитам: Взаимная фильтрация списков реквизитов
     */
    public com.actionmedia.webservice.buhonline.ExtendedSearchFilterResponseExtendedSearchFilterResult extendedSearchFilter(com.actionmedia.webservice.buhonline.FilterType variableAttribute, int regionID, int typeID, int lobbyID, boolean isActual, java.lang.String preferedRegionCode) throws java.rmi.RemoteException;

    /**
     * Поиск НПД по реквизитам: Взаимная фильтрация списков реквизитов
     * (с указанием раздела: 3-НПД, 13-АП)
     */
    public com.actionmedia.webservice.buhonline.ExtendedSearchFilter2ResponseExtendedSearchFilter2Result extendedSearchFilter2(org.apache.axis.types.UnsignedByte pubDivId, com.actionmedia.webservice.buhonline.FilterType variableAttribute, int regionID, int typeID, int lobbyID, boolean isActual, java.lang.String preferedRegionCode) throws java.rmi.RemoteException;

    /**
     * Аттачмент
     */
    public com.actionmedia.webservice.buhonline.AttachmentResponseAttachmentResult attachment(org.apache.axis.types.UnsignedByte moduleId, int attachId) throws java.rmi.RemoteException;

    /**
     * Оглавление журнала
     */
    public com.actionmedia.webservice.buhonline.TableOfContentEMagazineResponseTableOfContentEMagazineResult tableOfContentEMagazine(int epMagID) throws java.rmi.RemoteException;

    /**
     * Получить календарь
     */
    public com.actionmedia.webservice.buhonline.GetCalendarResponseGetCalendarResult getCalendar(int year, int month) throws java.rmi.RemoteException;

    /**
     * Текущие настройки
     */
    public com.actionmedia.webservice.buhonline.SettingsResponseSettingsResult settings() throws java.rmi.RemoteException;

    /**
     * Оглавление статьи
     */
    public com.actionmedia.webservice.buhonline.TableOfContentDocumentResponseTableOfContentDocumentResult tableOfContentDocument(org.apache.axis.types.UnsignedByte moduleID, int ID) throws java.rmi.RemoteException;

    /**
     * Часть документа
     */
    public com.actionmedia.webservice.buhonline.DocumentPartResponseDocumentPartResult documentPart(org.apache.axis.types.UnsignedByte moduleID, int ID, short partID) throws java.rmi.RemoteException;

    /**
     * Рубрикатор
     */
    public com.actionmedia.webservice.buhonline.RubricatorResponseRubricatorResult rubricator(org.apache.axis.types.UnsignedByte rubricatorID) throws java.rmi.RemoteException;

    /**
     * Поиск НПД по реквизитам: Список номеров по введенной части
     * номера
     */
    public com.actionmedia.webservice.buhonline.ExtendedSearchNumbersResponseExtendedSearchNumbersResult extendedSearchNumbers(java.lang.String pattern) throws java.rmi.RemoteException;

    /**
     * Поиск НПД по реквизитам: Список номеров по введенной части
     * номера (с указанием раздела: 3-НПД, 13-АП)
     */
    public com.actionmedia.webservice.buhonline.ExtendedSearchNumbers2ResponseExtendedSearchNumbers2Result extendedSearchNumbers2(org.apache.axis.types.UnsignedByte pubDivId, java.lang.String pattern) throws java.rmi.RemoteException;

    /**
     * Поиск НПД по реквизитам: Справочники
     */
    public com.actionmedia.webservice.buhonline.ExtendedSearchCatalogResponseExtendedSearchCatalogResult extendedSearchCatalog(java.lang.String preferedRegionCode) throws java.rmi.RemoteException;

    /**
     * Поиск НПД по реквизитам: Справочники (с указанием раздела:
     * 3-НПД, 13-АП)
     */
    public com.actionmedia.webservice.buhonline.ExtendedSearchCatalog2ResponseExtendedSearchCatalog2Result extendedSearchCatalog2(org.apache.axis.types.UnsignedByte pubDivId, java.lang.String preferedRegionCode) throws java.rmi.RemoteException;

    /**
     * Анонсы
     */
    public com.actionmedia.webservice.buhonline.NewsResponseNewsResult news(org.apache.axis.types.UnsignedByte pubDivId, int period, java.util.Calendar dateOn) throws java.rmi.RemoteException;

    /**
     * Документ
     */
    public com.actionmedia.webservice.buhonline.DocumentResponseDocumentResult document(org.apache.axis.types.UnsignedByte moduleID, int ID, java.lang.String anchor, boolean actual) throws java.rmi.RemoteException;

    /**
     * Документ в формате XML
     */
    public com.actionmedia.webservice.buhonline.XDocumentResponseXDocumentResult XDocument(org.apache.axis.types.UnsignedByte moduleID, int ID, java.lang.String anchor, boolean actual) throws java.rmi.RemoteException;
}
