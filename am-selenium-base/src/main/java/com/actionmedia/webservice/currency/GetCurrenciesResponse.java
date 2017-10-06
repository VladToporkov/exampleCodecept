/**
 * GetCurrenciesResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.currency;

public class GetCurrenciesResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.currency.GetCurrenciesResponseGetCurrenciesResult getCurrenciesResult;

    public GetCurrenciesResponse() {
    }

    public GetCurrenciesResponse(
           com.actionmedia.webservice.currency.GetCurrenciesResponseGetCurrenciesResult getCurrenciesResult) {
           this.getCurrenciesResult = getCurrenciesResult;
    }


    /**
     * Gets the getCurrenciesResult value for this GetCurrenciesResponse.
     * 
     * @return getCurrenciesResult
     */
    public com.actionmedia.webservice.currency.GetCurrenciesResponseGetCurrenciesResult getGetCurrenciesResult() {
        return getCurrenciesResult;
    }


    /**
     * Sets the getCurrenciesResult value for this GetCurrenciesResponse.
     * 
     * @param getCurrenciesResult
     */
    public void setGetCurrenciesResult(com.actionmedia.webservice.currency.GetCurrenciesResponseGetCurrenciesResult getCurrenciesResult) {
        this.getCurrenciesResult = getCurrenciesResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetCurrenciesResponse)) return false;
        GetCurrenciesResponse other = (GetCurrenciesResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getCurrenciesResult==null && other.getGetCurrenciesResult()==null) || 
             (this.getCurrenciesResult!=null &&
              this.getCurrenciesResult.equals(other.getGetCurrenciesResult())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getGetCurrenciesResult() != null) {
            _hashCode += getGetCurrenciesResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetCurrenciesResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetCurrenciesResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getCurrenciesResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetCurrenciesResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetCurrenciesResponse>GetCurrenciesResult"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
