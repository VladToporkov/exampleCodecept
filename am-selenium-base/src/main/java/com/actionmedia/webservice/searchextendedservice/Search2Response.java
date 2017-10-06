/**
 * Search2Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchextendedservice;

public class Search2Response  implements java.io.Serializable {
    private com.actionmedia.webservice.searchextendedservice.Search2ResponseSearch2Result search2Result;

    public Search2Response() {
    }

    public Search2Response(
           com.actionmedia.webservice.searchextendedservice.Search2ResponseSearch2Result search2Result) {
           this.search2Result = search2Result;
    }


    /**
     * Gets the search2Result value for this Search2Response.
     * 
     * @return search2Result
     */
    public com.actionmedia.webservice.searchextendedservice.Search2ResponseSearch2Result getSearch2Result() {
        return search2Result;
    }


    /**
     * Sets the search2Result value for this Search2Response.
     * 
     * @param search2Result
     */
    public void setSearch2Result(com.actionmedia.webservice.searchextendedservice.Search2ResponseSearch2Result search2Result) {
        this.search2Result = search2Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Search2Response)) return false;
        Search2Response other = (Search2Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.search2Result==null && other.getSearch2Result()==null) || 
             (this.search2Result!=null &&
              this.search2Result.equals(other.getSearch2Result())));
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
        if (getSearch2Result() != null) {
            _hashCode += getSearch2Result().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Search2Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">Search2Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("search2Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "Search2Result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">>Search2Response>Search2Result"));
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
