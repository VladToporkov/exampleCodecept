/**
 * SearchSiteResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class SearchSiteResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.searchservice.SearchSiteResponseSearchSiteResult searchSiteResult;

    public SearchSiteResponse() {
    }

    public SearchSiteResponse(
           com.actionmedia.webservice.searchservice.SearchSiteResponseSearchSiteResult searchSiteResult) {
           this.searchSiteResult = searchSiteResult;
    }


    /**
     * Gets the searchSiteResult value for this SearchSiteResponse.
     * 
     * @return searchSiteResult
     */
    public com.actionmedia.webservice.searchservice.SearchSiteResponseSearchSiteResult getSearchSiteResult() {
        return searchSiteResult;
    }


    /**
     * Sets the searchSiteResult value for this SearchSiteResponse.
     * 
     * @param searchSiteResult
     */
    public void setSearchSiteResult(com.actionmedia.webservice.searchservice.SearchSiteResponseSearchSiteResult searchSiteResult) {
        this.searchSiteResult = searchSiteResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchSiteResponse)) return false;
        SearchSiteResponse other = (SearchSiteResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.searchSiteResult==null && other.getSearchSiteResult()==null) || 
             (this.searchSiteResult!=null &&
              this.searchSiteResult.equals(other.getSearchSiteResult())));
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
        if (getSearchSiteResult() != null) {
            _hashCode += getSearchSiteResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchSiteResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SearchSiteResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchSiteResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SearchSiteResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>SearchSiteResponse>SearchSiteResult"));
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
