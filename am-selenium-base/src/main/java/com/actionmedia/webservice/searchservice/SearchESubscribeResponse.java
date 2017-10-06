/**
 * SearchESubscribeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class SearchESubscribeResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.searchservice.SearchESubscribeResponseSearchESubscribeResult searchESubscribeResult;

    public SearchESubscribeResponse() {
    }

    public SearchESubscribeResponse(
           com.actionmedia.webservice.searchservice.SearchESubscribeResponseSearchESubscribeResult searchESubscribeResult) {
           this.searchESubscribeResult = searchESubscribeResult;
    }


    /**
     * Gets the searchESubscribeResult value for this SearchESubscribeResponse.
     * 
     * @return searchESubscribeResult
     */
    public com.actionmedia.webservice.searchservice.SearchESubscribeResponseSearchESubscribeResult getSearchESubscribeResult() {
        return searchESubscribeResult;
    }


    /**
     * Sets the searchESubscribeResult value for this SearchESubscribeResponse.
     * 
     * @param searchESubscribeResult
     */
    public void setSearchESubscribeResult(com.actionmedia.webservice.searchservice.SearchESubscribeResponseSearchESubscribeResult searchESubscribeResult) {
        this.searchESubscribeResult = searchESubscribeResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchESubscribeResponse)) return false;
        SearchESubscribeResponse other = (SearchESubscribeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.searchESubscribeResult==null && other.getSearchESubscribeResult()==null) || 
             (this.searchESubscribeResult!=null &&
              this.searchESubscribeResult.equals(other.getSearchESubscribeResult())));
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
        if (getSearchESubscribeResult() != null) {
            _hashCode += getSearchESubscribeResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchESubscribeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SearchESubscribeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchESubscribeResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SearchESubscribeResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>SearchESubscribeResponse>SearchESubscribeResult"));
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
