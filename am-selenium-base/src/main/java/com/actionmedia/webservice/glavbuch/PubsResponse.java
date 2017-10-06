/**
 * PubsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.glavbuch;

public class PubsResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.glavbuch.PubsResponsePubsResult pubsResult;

    public PubsResponse() {
    }

    public PubsResponse(
           com.actionmedia.webservice.glavbuch.PubsResponsePubsResult pubsResult) {
           this.pubsResult = pubsResult;
    }


    /**
     * Gets the pubsResult value for this PubsResponse.
     * 
     * @return pubsResult
     */
    public com.actionmedia.webservice.glavbuch.PubsResponsePubsResult getPubsResult() {
        return pubsResult;
    }


    /**
     * Sets the pubsResult value for this PubsResponse.
     * 
     * @param pubsResult
     */
    public void setPubsResult(com.actionmedia.webservice.glavbuch.PubsResponsePubsResult pubsResult) {
        this.pubsResult = pubsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PubsResponse)) return false;
        PubsResponse other = (PubsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.pubsResult==null && other.getPubsResult()==null) || 
             (this.pubsResult!=null &&
              this.pubsResult.equals(other.getPubsResult())));
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
        if (getPubsResult() != null) {
            _hashCode += getPubsResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PubsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">PubsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "PubsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">>PubsResponse>PubsResult"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
