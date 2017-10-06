/**
 * BuyResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.actionbonus.proxyservice;

public class BuyResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.actionbonus.proxyservice.BuyResponseBuyResult buyResult;

    public BuyResponse() {
    }

    public BuyResponse(
           com.actionmedia.webservice.actionbonus.proxyservice.BuyResponseBuyResult buyResult) {
           this.buyResult = buyResult;
    }


    /**
     * Gets the buyResult value for this BuyResponse.
     * 
     * @return buyResult
     */
    public com.actionmedia.webservice.actionbonus.proxyservice.BuyResponseBuyResult getBuyResult() {
        return buyResult;
    }


    /**
     * Sets the buyResult value for this BuyResponse.
     * 
     * @param buyResult
     */
    public void setBuyResult(com.actionmedia.webservice.actionbonus.proxyservice.BuyResponseBuyResult buyResult) {
        this.buyResult = buyResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BuyResponse)) return false;
        BuyResponse other = (BuyResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.buyResult==null && other.getBuyResult()==null) || 
             (this.buyResult!=null &&
              this.buyResult.equals(other.getBuyResult())));
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
        if (getBuyResult() != null) {
            _hashCode += getBuyResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BuyResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">BuyResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("buyResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "BuyResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>BuyResponse>BuyResult"));
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
