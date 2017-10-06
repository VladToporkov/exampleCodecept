/**
 * BSSExportServiceSoap_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.exportnpdservice;

public interface BSSExportServiceSoap_PortType extends java.rmi.Remote {

    /**
     * Информация о  цели гиперссылки
     */
    public com.actionmedia.webservice.exportnpdservice.ExecuteGetHyperLinkTargetByGuidResponse getHyperLinkTargetByGuid(java.lang.String linkGuid) throws java.rmi.RemoteException;

    /**
     * Получение списка анонсов за последний месяц по списку изданий
     */
    public com.actionmedia.webservice.exportnpdservice.ExecuteGetNpdAnnouncesForMonthResponse getNpdAnnouncesForMonth(org.apache.axis.types.UnsignedByte[] pubIDList) throws java.rmi.RemoteException;

    /**
     * Получение атрибутов документа
     */
    public com.actionmedia.webservice.exportnpdservice.ExecuteGetDocAttrubutesResponse getDocAttributes(org.apache.axis.types.UnsignedByte moduleID, int ID) throws java.rmi.RemoteException;

    /**
     * Очистака кэша
     */
    public void clearCache() throws java.rmi.RemoteException;

    /**
     * Возвращает список докуменов по типу
     */
    public com.actionmedia.webservice.exportnpdservice.GetDocumentByTypeResponseGetDocumentByTypeResult getDocumentByType(int typeID, int pageNumber) throws java.rmi.RemoteException;

    /**
     * Проверяет, есть ли обновление гиперссылок по номеру журнала
     * с момента последнего запроса. Если изменение произошло, возвращает
     * таблицу гиперссылок по запрошенному номеру журнала.
     */
    public com.actionmedia.webservice.exportnpdservice.ExecuteGetHyperlinksTableResponse getMagHyperlinksTable(short magId, byte[] timeStamp) throws java.rmi.RemoteException;

    /**
     * Получение информации о номере журнала
     */
    public com.actionmedia.webservice.exportnpdservice.ExecuteGetMagListResponse getMagList(org.apache.axis.types.UnsignedByte magazineId, int magazineNumber, java.util.Calendar magazineDate) throws java.rmi.RemoteException;

    /**
     * Чтение контента части документа НПД
     */
    public com.actionmedia.webservice.exportnpdservice.ExecuteGetDocumentPartByIdResponse getDocumentPartById(org.apache.axis.types.UnsignedByte moduleID, int ID, int partID, java.lang.String hlinkTemplate) throws java.rmi.RemoteException;

    /**
     * Получение списка анонсов за последний месяц по изданиям
     */
    public com.actionmedia.webservice.exportnpdservice.ExecuteGetNpdAnnouncesByIndustryForMonthResponse getNpdAnnouncesByIndustryForMonth(java.lang.String[] industryKind) throws java.rmi.RemoteException;

    /**
     * Информация об атрибутах документа НПД и список его частей
     */
    public com.actionmedia.webservice.exportnpdservice.ExecuteGetNpdDocumentInfoResponse getNpdDocumentInfo(org.apache.axis.types.UnsignedByte pubId, org.apache.axis.types.UnsignedByte moduleID, int ID, java.lang.String anchor, java.lang.String hlinkTemplate) throws java.rmi.RemoteException;

    /**
     * Возврщает список типов
     */
    public com.actionmedia.webservice.exportnpdservice.ExecuteGetDocTypesResponse getDocTypes() throws java.rmi.RemoteException;

    /**
     * Массив целей гиперссылок по массиву токенов ссылок.
     */
    public com.actionmedia.webservice.exportnpdservice.ExecuteGetHyperLinksTargetsResponse getHyperlinksTargets(java.lang.String[] linkGuids) throws java.rmi.RemoteException;

    /**
     * Список соответствия частей документа якорям.
     */
    public com.actionmedia.webservice.exportnpdservice.ExecuteGetAnchorsToPartsResponse getAnchorsToParts(org.apache.axis.types.UnsignedByte moduleID, int ID) throws java.rmi.RemoteException;

    /**
     * Получение атрибутов документа
     */
    public com.actionmedia.webservice.exportnpdservice.ExecuteGetDocAttrubutesResponse2 getDocAttributes2(org.apache.axis.types.UnsignedByte moduleID, int ID) throws java.rmi.RemoteException;
}
