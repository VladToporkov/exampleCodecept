/**
 * SearchCodeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class SearchCodeResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.searchservice.SearchCodeResponseSearchCodeResult searchCodeResult;

    public SearchCodeResponse() {
    }

    public SearchCodeResponse(
           com.actionmedia.webservice.searchservice.SearchCodeResponseSearchCodeResult searchCodeResult) {
           this.searchCodeResult = searchCodeResult;
    }


    /**
     * Gets the searchCodeResult value for this SearchCodeResponse.
     * 
     * @return searchCodeResult
     */
    public com.actionmedia.webservice.searchservice.SearchCodeResponseSearchCodeResult getSearchCodeResult() {
        return searchCodeResult;
    }


    /**
     * Sets the searchCodeResult value for this SearchCodeResponse.
     * 
     * @param searchCodeResult
     */
    public void setSearchCodeResult(com.actionmedia.webservice.searchservice.SearchCodeResponseSearchCodeResult searchCodeResult) {
        this.searchCodeResult = searchCodeResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchCodeResponse)) return false;
        SearchCodeResponse other = (SearchCodeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.searchCodeResult==null && other.getSearchCodeResult()==null) || 
             (this.searchCodeResult!=null &&
              this.searchCodeResult.equals(other.getSearchCodeResult())));
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
        if (getSearchCodeResult() != null) {
            _hashCode += getSearchCodeResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchCodeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SearchCodeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchCodeResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SearchCodeResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>SearchCodeResponse>SearchCodeResult"));
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
