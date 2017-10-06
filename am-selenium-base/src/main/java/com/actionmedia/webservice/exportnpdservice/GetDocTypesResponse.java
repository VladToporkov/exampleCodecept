/**
 * GetDocTypesResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.exportnpdservice;

public class GetDocTypesResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.exportnpdservice.ExecuteGetDocTypesResponse getDocTypesResult;

    public GetDocTypesResponse() {
    }

    public GetDocTypesResponse(
           com.actionmedia.webservice.exportnpdservice.ExecuteGetDocTypesResponse getDocTypesResult) {
           this.getDocTypesResult = getDocTypesResult;
    }


    /**
     * Gets the getDocTypesResult value for this GetDocTypesResponse.
     * 
     * @return getDocTypesResult
     */
    public com.actionmedia.webservice.exportnpdservice.ExecuteGetDocTypesResponse getGetDocTypesResult() {
        return getDocTypesResult;
    }


    /**
     * Sets the getDocTypesResult value for this GetDocTypesResponse.
     * 
     * @param getDocTypesResult
     */
    public void setGetDocTypesResult(com.actionmedia.webservice.exportnpdservice.ExecuteGetDocTypesResponse getDocTypesResult) {
        this.getDocTypesResult = getDocTypesResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetDocTypesResponse)) return false;
        GetDocTypesResponse other = (GetDocTypesResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getDocTypesResult==null && other.getGetDocTypesResult()==null) || 
             (this.getDocTypesResult!=null &&
              this.getDocTypesResult.equals(other.getGetDocTypesResult())));
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
        if (getGetDocTypesResult() != null) {
            _hashCode += getGetDocTypesResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetDocTypesResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", ">GetDocTypesResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getDocTypesResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "GetDocTypesResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetDocTypesResponse"));
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
