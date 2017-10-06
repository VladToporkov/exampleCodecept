/**
 * SearchCode.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class SearchCode  implements java.io.Serializable {
    private java.lang.String codeTypeAlias;

    private java.lang.String searchString;

    public SearchCode() {
    }

    public SearchCode(
           java.lang.String codeTypeAlias,
           java.lang.String searchString) {
           this.codeTypeAlias = codeTypeAlias;
           this.searchString = searchString;
    }


    /**
     * Gets the codeTypeAlias value for this SearchCode.
     * 
     * @return codeTypeAlias
     */
    public java.lang.String getCodeTypeAlias() {
        return codeTypeAlias;
    }


    /**
     * Sets the codeTypeAlias value for this SearchCode.
     * 
     * @param codeTypeAlias
     */
    public void setCodeTypeAlias(java.lang.String codeTypeAlias) {
        this.codeTypeAlias = codeTypeAlias;
    }


    /**
     * Gets the searchString value for this SearchCode.
     * 
     * @return searchString
     */
    public java.lang.String getSearchString() {
        return searchString;
    }


    /**
     * Sets the searchString value for this SearchCode.
     * 
     * @param searchString
     */
    public void setSearchString(java.lang.String searchString) {
        this.searchString = searchString;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchCode)) return false;
        SearchCode other = (SearchCode) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codeTypeAlias==null && other.getCodeTypeAlias()==null) || 
             (this.codeTypeAlias!=null &&
              this.codeTypeAlias.equals(other.getCodeTypeAlias()))) &&
            ((this.searchString==null && other.getSearchString()==null) || 
             (this.searchString!=null &&
              this.searchString.equals(other.getSearchString())));
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
        if (getCodeTypeAlias() != null) {
            _hashCode += getCodeTypeAlias().hashCode();
        }
        if (getSearchString() != null) {
            _hashCode += getSearchString().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchCode.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SearchCode"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codeTypeAlias");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "codeTypeAlias"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchString");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "searchString"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
