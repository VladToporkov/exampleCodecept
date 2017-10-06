/**
 * GetMagHyperlinksTableResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.exportnpdservice;

public class GetMagHyperlinksTableResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.exportnpdservice.ExecuteGetHyperlinksTableResponse getMagHyperlinksTableResult;

    public GetMagHyperlinksTableResponse() {
    }

    public GetMagHyperlinksTableResponse(
           com.actionmedia.webservice.exportnpdservice.ExecuteGetHyperlinksTableResponse getMagHyperlinksTableResult) {
           this.getMagHyperlinksTableResult = getMagHyperlinksTableResult;
    }


    /**
     * Gets the getMagHyperlinksTableResult value for this GetMagHyperlinksTableResponse.
     * 
     * @return getMagHyperlinksTableResult
     */
    public com.actionmedia.webservice.exportnpdservice.ExecuteGetHyperlinksTableResponse getGetMagHyperlinksTableResult() {
        return getMagHyperlinksTableResult;
    }


    /**
     * Sets the getMagHyperlinksTableResult value for this GetMagHyperlinksTableResponse.
     * 
     * @param getMagHyperlinksTableResult
     */
    public void setGetMagHyperlinksTableResult(com.actionmedia.webservice.exportnpdservice.ExecuteGetHyperlinksTableResponse getMagHyperlinksTableResult) {
        this.getMagHyperlinksTableResult = getMagHyperlinksTableResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetMagHyperlinksTableResponse)) return false;
        GetMagHyperlinksTableResponse other = (GetMagHyperlinksTableResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getMagHyperlinksTableResult==null && other.getGetMagHyperlinksTableResult()==null) || 
             (this.getMagHyperlinksTableResult!=null &&
              this.getMagHyperlinksTableResult.equals(other.getGetMagHyperlinksTableResult())));
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
        if (getGetMagHyperlinksTableResult() != null) {
            _hashCode += getGetMagHyperlinksTableResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetMagHyperlinksTableResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", ">GetMagHyperlinksTableResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getMagHyperlinksTableResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "GetMagHyperlinksTableResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetHyperlinksTableResponse"));
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
