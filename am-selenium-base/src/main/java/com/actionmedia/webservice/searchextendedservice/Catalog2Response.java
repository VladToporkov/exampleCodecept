/**
 * Catalog2Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchextendedservice;

public class Catalog2Response  implements java.io.Serializable {
    private com.actionmedia.webservice.searchextendedservice.Catalog2ResponseCatalog2Result catalog2Result;

    public Catalog2Response() {
    }

    public Catalog2Response(
           com.actionmedia.webservice.searchextendedservice.Catalog2ResponseCatalog2Result catalog2Result) {
           this.catalog2Result = catalog2Result;
    }


    /**
     * Gets the catalog2Result value for this Catalog2Response.
     * 
     * @return catalog2Result
     */
    public com.actionmedia.webservice.searchextendedservice.Catalog2ResponseCatalog2Result getCatalog2Result() {
        return catalog2Result;
    }


    /**
     * Sets the catalog2Result value for this Catalog2Response.
     * 
     * @param catalog2Result
     */
    public void setCatalog2Result(com.actionmedia.webservice.searchextendedservice.Catalog2ResponseCatalog2Result catalog2Result) {
        this.catalog2Result = catalog2Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Catalog2Response)) return false;
        Catalog2Response other = (Catalog2Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.catalog2Result==null && other.getCatalog2Result()==null) || 
             (this.catalog2Result!=null &&
              this.catalog2Result.equals(other.getCatalog2Result())));
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
        if (getCatalog2Result() != null) {
            _hashCode += getCatalog2Result().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Catalog2Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">Catalog2Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("catalog2Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "Catalog2Result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">>Catalog2Response>Catalog2Result"));
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
