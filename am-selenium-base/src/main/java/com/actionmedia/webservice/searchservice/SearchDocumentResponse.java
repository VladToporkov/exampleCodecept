/**
 * SearchDocumentResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class SearchDocumentResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.searchservice.SearchDocumentResponseSearchDocumentResult searchDocumentResult;

    public SearchDocumentResponse() {
    }

    public SearchDocumentResponse(
           com.actionmedia.webservice.searchservice.SearchDocumentResponseSearchDocumentResult searchDocumentResult) {
           this.searchDocumentResult = searchDocumentResult;
    }


    /**
     * Gets the searchDocumentResult value for this SearchDocumentResponse.
     * 
     * @return searchDocumentResult
     */
    public com.actionmedia.webservice.searchservice.SearchDocumentResponseSearchDocumentResult getSearchDocumentResult() {
        return searchDocumentResult;
    }


    /**
     * Sets the searchDocumentResult value for this SearchDocumentResponse.
     * 
     * @param searchDocumentResult
     */
    public void setSearchDocumentResult(com.actionmedia.webservice.searchservice.SearchDocumentResponseSearchDocumentResult searchDocumentResult) {
        this.searchDocumentResult = searchDocumentResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchDocumentResponse)) return false;
        SearchDocumentResponse other = (SearchDocumentResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.searchDocumentResult==null && other.getSearchDocumentResult()==null) || 
             (this.searchDocumentResult!=null &&
              this.searchDocumentResult.equals(other.getSearchDocumentResult())));
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
        if (getSearchDocumentResult() != null) {
            _hashCode += getSearchDocumentResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchDocumentResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SearchDocumentResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchDocumentResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SearchDocumentResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>SearchDocumentResponse>SearchDocumentResult"));
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
