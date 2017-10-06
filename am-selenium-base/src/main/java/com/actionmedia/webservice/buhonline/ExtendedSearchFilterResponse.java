/**
 * ExtendedSearchFilterResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.buhonline;

public class ExtendedSearchFilterResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.buhonline.ExtendedSearchFilterResponseExtendedSearchFilterResult extendedSearchFilterResult;

    public ExtendedSearchFilterResponse() {
    }

    public ExtendedSearchFilterResponse(
           com.actionmedia.webservice.buhonline.ExtendedSearchFilterResponseExtendedSearchFilterResult extendedSearchFilterResult) {
           this.extendedSearchFilterResult = extendedSearchFilterResult;
    }


    /**
     * Gets the extendedSearchFilterResult value for this ExtendedSearchFilterResponse.
     * 
     * @return extendedSearchFilterResult
     */
    public com.actionmedia.webservice.buhonline.ExtendedSearchFilterResponseExtendedSearchFilterResult getExtendedSearchFilterResult() {
        return extendedSearchFilterResult;
    }


    /**
     * Sets the extendedSearchFilterResult value for this ExtendedSearchFilterResponse.
     * 
     * @param extendedSearchFilterResult
     */
    public void setExtendedSearchFilterResult(com.actionmedia.webservice.buhonline.ExtendedSearchFilterResponseExtendedSearchFilterResult extendedSearchFilterResult) {
        this.extendedSearchFilterResult = extendedSearchFilterResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExtendedSearchFilterResponse)) return false;
        ExtendedSearchFilterResponse other = (ExtendedSearchFilterResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.extendedSearchFilterResult==null && other.getExtendedSearchFilterResult()==null) || 
             (this.extendedSearchFilterResult!=null &&
              this.extendedSearchFilterResult.equals(other.getExtendedSearchFilterResult())));
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
        if (getExtendedSearchFilterResult() != null) {
            _hashCode += getExtendedSearchFilterResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExtendedSearchFilterResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">ExtendedSearchFilterResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extendedSearchFilterResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "ExtendedSearchFilterResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>ExtendedSearchFilterResponse>ExtendedSearchFilterResult"));
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
