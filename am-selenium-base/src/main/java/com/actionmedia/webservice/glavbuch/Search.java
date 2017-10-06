/**
 * Search.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.glavbuch;

public class Search  implements java.io.Serializable {
    private java.lang.String searchString;

    private org.apache.axis.types.UnsignedByte pubDivId;

    private int pageNumber;

    public Search() {
    }

    public Search(
           java.lang.String searchString,
           org.apache.axis.types.UnsignedByte pubDivId,
           int pageNumber) {
           this.searchString = searchString;
           this.pubDivId = pubDivId;
           this.pageNumber = pageNumber;
    }


    /**
     * Gets the searchString value for this Search.
     * 
     * @return searchString
     */
    public java.lang.String getSearchString() {
        return searchString;
    }


    /**
     * Sets the searchString value for this Search.
     * 
     * @param searchString
     */
    public void setSearchString(java.lang.String searchString) {
        this.searchString = searchString;
    }


    /**
     * Gets the pubDivId value for this Search.
     * 
     * @return pubDivId
     */
    public org.apache.axis.types.UnsignedByte getPubDivId() {
        return pubDivId;
    }


    /**
     * Sets the pubDivId value for this Search.
     * 
     * @param pubDivId
     */
    public void setPubDivId(org.apache.axis.types.UnsignedByte pubDivId) {
        this.pubDivId = pubDivId;
    }


    /**
     * Gets the pageNumber value for this Search.
     * 
     * @return pageNumber
     */
    public int getPageNumber() {
        return pageNumber;
    }


    /**
     * Sets the pageNumber value for this Search.
     * 
     * @param pageNumber
     */
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Search)) return false;
        Search other = (Search) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.searchString==null && other.getSearchString()==null) || 
             (this.searchString!=null &&
              this.searchString.equals(other.getSearchString()))) &&
            ((this.pubDivId==null && other.getPubDivId()==null) || 
             (this.pubDivId!=null &&
              this.pubDivId.equals(other.getPubDivId()))) &&
            this.pageNumber == other.getPageNumber();
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
        if (getSearchString() != null) {
            _hashCode += getSearchString().hashCode();
        }
        if (getPubDivId() != null) {
            _hashCode += getPubDivId().hashCode();
        }
        _hashCode += getPageNumber();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Search.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">Search"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchString");
        elemField.setXmlName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "SearchString"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubDivId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "PubDivId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pageNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "PageNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
