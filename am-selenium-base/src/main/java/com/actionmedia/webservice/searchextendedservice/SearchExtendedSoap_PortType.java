/**
 * SearchExtendedSoap_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchextendedservice;

public interface SearchExtendedSoap_PortType extends java.rmi.Remote {

    /**
     * Список номеров по введенной части номера
     */
    public com.actionmedia.webservice.searchextendedservice.NumbersResponseNumbersResult numbers(java.lang.String pattern) throws java.rmi.RemoteException;

    /**
     * Список номеров по введенной части номера (с указанием раздела:
     * 3-НПД, 13-АП)
     */
    public com.actionmedia.webservice.searchextendedservice.Numbers2ResponseNumbers2Result numbers2(org.apache.axis.types.UnsignedByte pubDivId, java.lang.String pattern) throws java.rmi.RemoteException;

    /**
     * Справочники инициализации
     */
    public com.actionmedia.webservice.searchextendedservice.CatalogResponseCatalogResult catalog(java.lang.String preferedRegionCode) throws java.rmi.RemoteException;

    /**
     * Справочники инициализации (с указанием раздела: 3-НПД, 13-АП)
     */
    public com.actionmedia.webservice.searchextendedservice.Catalog2ResponseCatalog2Result catalog2(org.apache.axis.types.UnsignedByte pubDivId, java.lang.String preferedRegionCode) throws java.rmi.RemoteException;

    /**
     * Фильтрация списков по значениям других списков
     */
    public com.actionmedia.webservice.searchextendedservice.FilterResponseFilterResult filter(java.lang.String preferedRegionCode, java.lang.String listType, java.lang.String lobbyIDs, java.lang.String regionIDs, java.lang.String typeIDs, boolean isActual) throws java.rmi.RemoteException;

    /**
     * Фильтрация списков по значениям других списков (с указанием
     * раздела: 3-НПД, 13-АП)
     */
    public com.actionmedia.webservice.searchextendedservice.Filter2ResponseFilter2Result filter2(org.apache.axis.types.UnsignedByte pubDivId, java.lang.String preferedRegionCode, java.lang.String listType, java.lang.String lobbyIDs, java.lang.String regionIDs, java.lang.String typeIDs, boolean isActual) throws java.rmi.RemoteException;

    /**
     * Поиск
     */
    public com.actionmedia.webservice.searchextendedservice.SearchResponseSearchResult search(java.lang.String searchString, java.lang.String docRegionIDList, java.lang.String docTypeIDList, java.lang.String docLobbyIDList, java.lang.String docNumber, java.lang.String pubDateStartedOn, java.lang.String pubDateEndedOn, boolean isActual, boolean isExtended) throws java.rmi.RemoteException;

    /**
     * Поиск (с указанием раздела: 3-НПД, 13-АП)
     */
    public com.actionmedia.webservice.searchextendedservice.Search2ResponseSearch2Result search2(org.apache.axis.types.UnsignedByte pubDivId, java.lang.String searchString, java.lang.String docRegionIDList, java.lang.String docTypeIDList, java.lang.String docLobbyIDList, java.lang.String docNumber, java.lang.String pubDateStartedOn, java.lang.String pubDateEndedOn, boolean isActual, boolean isExtended) throws java.rmi.RemoteException;
}
