/**
 * ExtendedSearchNumbersResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.buhonline;

public class ExtendedSearchNumbersResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.buhonline.ExtendedSearchNumbersResponseExtendedSearchNumbersResult extendedSearchNumbersResult;

    public ExtendedSearchNumbersResponse() {
    }

    public ExtendedSearchNumbersResponse(
           com.actionmedia.webservice.buhonline.ExtendedSearchNumbersResponseExtendedSearchNumbersResult extendedSearchNumbersResult) {
           this.extendedSearchNumbersResult = extendedSearchNumbersResult;
    }


    /**
     * Gets the extendedSearchNumbersResult value for this ExtendedSearchNumbersResponse.
     * 
     * @return extendedSearchNumbersResult
     */
    public com.actionmedia.webservice.buhonline.ExtendedSearchNumbersResponseExtendedSearchNumbersResult getExtendedSearchNumbersResult() {
        return extendedSearchNumbersResult;
    }


    /**
     * Sets the extendedSearchNumbersResult value for this ExtendedSearchNumbersResponse.
     * 
     * @param extendedSearchNumbersResult
     */
    public void setExtendedSearchNumbersResult(com.actionmedia.webservice.buhonline.ExtendedSearchNumbersResponseExtendedSearchNumbersResult extendedSearchNumbersResult) {
        this.extendedSearchNumbersResult = extendedSearchNumbersResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExtendedSearchNumbersResponse)) return false;
        ExtendedSearchNumbersResponse other = (ExtendedSearchNumbersResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.extendedSearchNumbersResult==null && other.getExtendedSearchNumbersResult()==null) || 
             (this.extendedSearchNumbersResult!=null &&
              this.extendedSearchNumbersResult.equals(other.getExtendedSearchNumbersResult())));
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
        if (getExtendedSearchNumbersResult() != null) {
            _hashCode += getExtendedSearchNumbersResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExtendedSearchNumbersResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">ExtendedSearchNumbersResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extendedSearchNumbersResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "ExtendedSearchNumbersResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>ExtendedSearchNumbersResponse>ExtendedSearchNumbersResult"));
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
