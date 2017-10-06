/**
 * ExtendedSearchCatalog2Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.buhonline;

public class ExtendedSearchCatalog2Response  implements java.io.Serializable {
    private com.actionmedia.webservice.buhonline.ExtendedSearchCatalog2ResponseExtendedSearchCatalog2Result extendedSearchCatalog2Result;

    public ExtendedSearchCatalog2Response() {
    }

    public ExtendedSearchCatalog2Response(
           com.actionmedia.webservice.buhonline.ExtendedSearchCatalog2ResponseExtendedSearchCatalog2Result extendedSearchCatalog2Result) {
           this.extendedSearchCatalog2Result = extendedSearchCatalog2Result;
    }


    /**
     * Gets the extendedSearchCatalog2Result value for this ExtendedSearchCatalog2Response.
     * 
     * @return extendedSearchCatalog2Result
     */
    public com.actionmedia.webservice.buhonline.ExtendedSearchCatalog2ResponseExtendedSearchCatalog2Result getExtendedSearchCatalog2Result() {
        return extendedSearchCatalog2Result;
    }


    /**
     * Sets the extendedSearchCatalog2Result value for this ExtendedSearchCatalog2Response.
     * 
     * @param extendedSearchCatalog2Result
     */
    public void setExtendedSearchCatalog2Result(com.actionmedia.webservice.buhonline.ExtendedSearchCatalog2ResponseExtendedSearchCatalog2Result extendedSearchCatalog2Result) {
        this.extendedSearchCatalog2Result = extendedSearchCatalog2Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExtendedSearchCatalog2Response)) return false;
        ExtendedSearchCatalog2Response other = (ExtendedSearchCatalog2Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.extendedSearchCatalog2Result==null && other.getExtendedSearchCatalog2Result()==null) || 
             (this.extendedSearchCatalog2Result!=null &&
              this.extendedSearchCatalog2Result.equals(other.getExtendedSearchCatalog2Result())));
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
        if (getExtendedSearchCatalog2Result() != null) {
            _hashCode += getExtendedSearchCatalog2Result().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExtendedSearchCatalog2Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">ExtendedSearchCatalog2Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extendedSearchCatalog2Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "ExtendedSearchCatalog2Result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>ExtendedSearchCatalog2Response>ExtendedSearchCatalog2Result"));
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
