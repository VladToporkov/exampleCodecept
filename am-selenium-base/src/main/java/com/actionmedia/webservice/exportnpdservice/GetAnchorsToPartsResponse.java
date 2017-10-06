/**
 * GetAnchorsToPartsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.exportnpdservice;

public class GetAnchorsToPartsResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.exportnpdservice.ExecuteGetAnchorsToPartsResponse getAnchorsToPartsResult;

    public GetAnchorsToPartsResponse() {
    }

    public GetAnchorsToPartsResponse(
           com.actionmedia.webservice.exportnpdservice.ExecuteGetAnchorsToPartsResponse getAnchorsToPartsResult) {
           this.getAnchorsToPartsResult = getAnchorsToPartsResult;
    }


    /**
     * Gets the getAnchorsToPartsResult value for this GetAnchorsToPartsResponse.
     * 
     * @return getAnchorsToPartsResult
     */
    public com.actionmedia.webservice.exportnpdservice.ExecuteGetAnchorsToPartsResponse getGetAnchorsToPartsResult() {
        return getAnchorsToPartsResult;
    }


    /**
     * Sets the getAnchorsToPartsResult value for this GetAnchorsToPartsResponse.
     * 
     * @param getAnchorsToPartsResult
     */
    public void setGetAnchorsToPartsResult(com.actionmedia.webservice.exportnpdservice.ExecuteGetAnchorsToPartsResponse getAnchorsToPartsResult) {
        this.getAnchorsToPartsResult = getAnchorsToPartsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetAnchorsToPartsResponse)) return false;
        GetAnchorsToPartsResponse other = (GetAnchorsToPartsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getAnchorsToPartsResult==null && other.getGetAnchorsToPartsResult()==null) || 
             (this.getAnchorsToPartsResult!=null &&
              this.getAnchorsToPartsResult.equals(other.getGetAnchorsToPartsResult())));
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
        if (getGetAnchorsToPartsResult() != null) {
            _hashCode += getGetAnchorsToPartsResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetAnchorsToPartsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", ">GetAnchorsToPartsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getAnchorsToPartsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "GetAnchorsToPartsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetAnchorsToPartsResponse"));
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
