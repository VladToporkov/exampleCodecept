/**
 * IActionBonusService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.actionbonus.proxyservice;

public interface IActionBonusService extends java.rmi.Remote {
    public com.actionmedia.webservice.actionbonus.proxyservice.GetShowcaseResponseGetShowcaseResult getShowcase() throws java.rmi.RemoteException;
    public com.actionmedia.webservice.actionbonus.proxyservice.BuyResponseBuyResult buy(java.lang.String customerToken, java.lang.String productCode, java.util.Calendar activateOn) throws java.rmi.RemoteException;
    public com.actionmedia.webservice.actionbonus.proxyservice.GetPointsResponseGetPointsResult getPoints(java.lang.String customerToken) throws java.rmi.RemoteException;
    public com.actionmedia.webservice.actionbonus.proxyservice.GetCertificatesResponseGetCertificatesResult getCertificates(java.lang.String customerToken) throws java.rmi.RemoteException;
}
