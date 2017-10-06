/**
 * SearchActionDigitalResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class SearchActionDigitalResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.searchservice.SearchActionDigitalResponseSearchActionDigitalResult searchActionDigitalResult;

    public SearchActionDigitalResponse() {
    }

    public SearchActionDigitalResponse(
           com.actionmedia.webservice.searchservice.SearchActionDigitalResponseSearchActionDigitalResult searchActionDigitalResult) {
           this.searchActionDigitalResult = searchActionDigitalResult;
    }


    /**
     * Gets the searchActionDigitalResult value for this SearchActionDigitalResponse.
     * 
     * @return searchActionDigitalResult
     */
    public com.actionmedia.webservice.searchservice.SearchActionDigitalResponseSearchActionDigitalResult getSearchActionDigitalResult() {
        return searchActionDigitalResult;
    }


    /**
     * Sets the searchActionDigitalResult value for this SearchActionDigitalResponse.
     * 
     * @param searchActionDigitalResult
     */
    public void setSearchActionDigitalResult(com.actionmedia.webservice.searchservice.SearchActionDigitalResponseSearchActionDigitalResult searchActionDigitalResult) {
        this.searchActionDigitalResult = searchActionDigitalResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchActionDigitalResponse)) return false;
        SearchActionDigitalResponse other = (SearchActionDigitalResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.searchActionDigitalResult==null && other.getSearchActionDigitalResult()==null) || 
             (this.searchActionDigitalResult!=null &&
              this.searchActionDigitalResult.equals(other.getSearchActionDigitalResult())));
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
        if (getSearchActionDigitalResult() != null) {
            _hashCode += getSearchActionDigitalResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchActionDigitalResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SearchActionDigitalResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchActionDigitalResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SearchActionDigitalResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>SearchActionDigitalResponse>SearchActionDigitalResult"));
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
