/**
 * Filter2Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchextendedservice;

public class Filter2Response  implements java.io.Serializable {
    private com.actionmedia.webservice.searchextendedservice.Filter2ResponseFilter2Result filter2Result;

    public Filter2Response() {
    }

    public Filter2Response(
           com.actionmedia.webservice.searchextendedservice.Filter2ResponseFilter2Result filter2Result) {
           this.filter2Result = filter2Result;
    }


    /**
     * Gets the filter2Result value for this Filter2Response.
     * 
     * @return filter2Result
     */
    public com.actionmedia.webservice.searchextendedservice.Filter2ResponseFilter2Result getFilter2Result() {
        return filter2Result;
    }


    /**
     * Sets the filter2Result value for this Filter2Response.
     * 
     * @param filter2Result
     */
    public void setFilter2Result(com.actionmedia.webservice.searchextendedservice.Filter2ResponseFilter2Result filter2Result) {
        this.filter2Result = filter2Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Filter2Response)) return false;
        Filter2Response other = (Filter2Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.filter2Result==null && other.getFilter2Result()==null) || 
             (this.filter2Result!=null &&
              this.filter2Result.equals(other.getFilter2Result())));
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
        if (getFilter2Result() != null) {
            _hashCode += getFilter2Result().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Filter2Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">Filter2Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filter2Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "Filter2Result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">>Filter2Response>Filter2Result"));
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
