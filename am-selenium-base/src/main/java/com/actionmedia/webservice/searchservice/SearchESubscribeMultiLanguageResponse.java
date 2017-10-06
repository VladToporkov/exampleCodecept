/**
 * SearchESubscribeMultiLanguageResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class SearchESubscribeMultiLanguageResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.searchservice.SearchESubscribeMultiLanguageResponseSearchESubscribeMultiLanguageResult searchESubscribeMultiLanguageResult;

    public SearchESubscribeMultiLanguageResponse() {
    }

    public SearchESubscribeMultiLanguageResponse(
           com.actionmedia.webservice.searchservice.SearchESubscribeMultiLanguageResponseSearchESubscribeMultiLanguageResult searchESubscribeMultiLanguageResult) {
           this.searchESubscribeMultiLanguageResult = searchESubscribeMultiLanguageResult;
    }


    /**
     * Gets the searchESubscribeMultiLanguageResult value for this SearchESubscribeMultiLanguageResponse.
     * 
     * @return searchESubscribeMultiLanguageResult
     */
    public com.actionmedia.webservice.searchservice.SearchESubscribeMultiLanguageResponseSearchESubscribeMultiLanguageResult getSearchESubscribeMultiLanguageResult() {
        return searchESubscribeMultiLanguageResult;
    }


    /**
     * Sets the searchESubscribeMultiLanguageResult value for this SearchESubscribeMultiLanguageResponse.
     * 
     * @param searchESubscribeMultiLanguageResult
     */
    public void setSearchESubscribeMultiLanguageResult(com.actionmedia.webservice.searchservice.SearchESubscribeMultiLanguageResponseSearchESubscribeMultiLanguageResult searchESubscribeMultiLanguageResult) {
        this.searchESubscribeMultiLanguageResult = searchESubscribeMultiLanguageResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchESubscribeMultiLanguageResponse)) return false;
        SearchESubscribeMultiLanguageResponse other = (SearchESubscribeMultiLanguageResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.searchESubscribeMultiLanguageResult==null && other.getSearchESubscribeMultiLanguageResult()==null) || 
             (this.searchESubscribeMultiLanguageResult!=null &&
              this.searchESubscribeMultiLanguageResult.equals(other.getSearchESubscribeMultiLanguageResult())));
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
        if (getSearchESubscribeMultiLanguageResult() != null) {
            _hashCode += getSearchESubscribeMultiLanguageResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchESubscribeMultiLanguageResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SearchESubscribeMultiLanguageResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchESubscribeMultiLanguageResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SearchESubscribeMultiLanguageResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>SearchESubscribeMultiLanguageResponse>SearchESubscribeMultiLanguageResult"));
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
