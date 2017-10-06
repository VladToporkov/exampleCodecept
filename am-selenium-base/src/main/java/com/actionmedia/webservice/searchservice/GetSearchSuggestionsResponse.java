/**
 * GetSearchSuggestionsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class GetSearchSuggestionsResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.searchservice.GetSearchSuggestionsResponseGetSearchSuggestionsResult getSearchSuggestionsResult;

    public GetSearchSuggestionsResponse() {
    }

    public GetSearchSuggestionsResponse(
           com.actionmedia.webservice.searchservice.GetSearchSuggestionsResponseGetSearchSuggestionsResult getSearchSuggestionsResult) {
           this.getSearchSuggestionsResult = getSearchSuggestionsResult;
    }


    /**
     * Gets the getSearchSuggestionsResult value for this GetSearchSuggestionsResponse.
     * 
     * @return getSearchSuggestionsResult
     */
    public com.actionmedia.webservice.searchservice.GetSearchSuggestionsResponseGetSearchSuggestionsResult getGetSearchSuggestionsResult() {
        return getSearchSuggestionsResult;
    }


    /**
     * Sets the getSearchSuggestionsResult value for this GetSearchSuggestionsResponse.
     * 
     * @param getSearchSuggestionsResult
     */
    public void setGetSearchSuggestionsResult(com.actionmedia.webservice.searchservice.GetSearchSuggestionsResponseGetSearchSuggestionsResult getSearchSuggestionsResult) {
        this.getSearchSuggestionsResult = getSearchSuggestionsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetSearchSuggestionsResponse)) return false;
        GetSearchSuggestionsResponse other = (GetSearchSuggestionsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getSearchSuggestionsResult==null && other.getGetSearchSuggestionsResult()==null) || 
             (this.getSearchSuggestionsResult!=null &&
              this.getSearchSuggestionsResult.equals(other.getGetSearchSuggestionsResult())));
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
        if (getGetSearchSuggestionsResult() != null) {
            _hashCode += getGetSearchSuggestionsResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetSearchSuggestionsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetSearchSuggestionsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getSearchSuggestionsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetSearchSuggestionsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetSearchSuggestionsResponse>GetSearchSuggestionsResult"));
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
