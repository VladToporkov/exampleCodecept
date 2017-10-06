/**
 * ICurrencyService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.currency;

public interface ICurrencyService extends java.rmi.Remote {
    public com.actionmedia.webservice.currency.CalcCrossRateResponseCalcCrossRateResult calcCrossRate(java.lang.String customerToken, java.util.Calendar date, java.lang.Integer firstCurrencyNumber, java.lang.Integer secondCurrencyNumber, java.math.BigDecimal sum, java.lang.Boolean calcBaseSum) throws java.rmi.RemoteException;
    public com.actionmedia.webservice.currency.GetCurrenciesResponseGetCurrenciesResult getCurrencies(java.lang.String customerToken, java.util.Calendar date) throws java.rmi.RemoteException;
    public com.actionmedia.webservice.currency.GetActualDateResponseGetActualDateResult getActualDate(java.lang.String customerToken) throws java.rmi.RemoteException;
}
