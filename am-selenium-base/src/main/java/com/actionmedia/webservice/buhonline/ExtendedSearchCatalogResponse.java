/**
 * ExtendedSearchCatalogResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.buhonline;

public class ExtendedSearchCatalogResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.buhonline.ExtendedSearchCatalogResponseExtendedSearchCatalogResult extendedSearchCatalogResult;

    public ExtendedSearchCatalogResponse() {
    }

    public ExtendedSearchCatalogResponse(
           com.actionmedia.webservice.buhonline.ExtendedSearchCatalogResponseExtendedSearchCatalogResult extendedSearchCatalogResult) {
           this.extendedSearchCatalogResult = extendedSearchCatalogResult;
    }


    /**
     * Gets the extendedSearchCatalogResult value for this ExtendedSearchCatalogResponse.
     * 
     * @return extendedSearchCatalogResult
     */
    public com.actionmedia.webservice.buhonline.ExtendedSearchCatalogResponseExtendedSearchCatalogResult getExtendedSearchCatalogResult() {
        return extendedSearchCatalogResult;
    }


    /**
     * Sets the extendedSearchCatalogResult value for this ExtendedSearchCatalogResponse.
     * 
     * @param extendedSearchCatalogResult
     */
    public void setExtendedSearchCatalogResult(com.actionmedia.webservice.buhonline.ExtendedSearchCatalogResponseExtendedSearchCatalogResult extendedSearchCatalogResult) {
        this.extendedSearchCatalogResult = extendedSearchCatalogResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExtendedSearchCatalogResponse)) return false;
        ExtendedSearchCatalogResponse other = (ExtendedSearchCatalogResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.extendedSearchCatalogResult==null && other.getExtendedSearchCatalogResult()==null) || 
             (this.extendedSearchCatalogResult!=null &&
              this.extendedSearchCatalogResult.equals(other.getExtendedSearchCatalogResult())));
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
        if (getExtendedSearchCatalogResult() != null) {
            _hashCode += getExtendedSearchCatalogResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExtendedSearchCatalogResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">ExtendedSearchCatalogResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extendedSearchCatalogResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "ExtendedSearchCatalogResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>ExtendedSearchCatalogResponse>ExtendedSearchCatalogResult"));
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
