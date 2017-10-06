/**
 * GetSearchHighlightsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class GetSearchHighlightsResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.searchservice.GetSearchHighlightsResponseGetSearchHighlightsResult getSearchHighlightsResult;

    public GetSearchHighlightsResponse() {
    }

    public GetSearchHighlightsResponse(
           com.actionmedia.webservice.searchservice.GetSearchHighlightsResponseGetSearchHighlightsResult getSearchHighlightsResult) {
           this.getSearchHighlightsResult = getSearchHighlightsResult;
    }


    /**
     * Gets the getSearchHighlightsResult value for this GetSearchHighlightsResponse.
     * 
     * @return getSearchHighlightsResult
     */
    public com.actionmedia.webservice.searchservice.GetSearchHighlightsResponseGetSearchHighlightsResult getGetSearchHighlightsResult() {
        return getSearchHighlightsResult;
    }


    /**
     * Sets the getSearchHighlightsResult value for this GetSearchHighlightsResponse.
     * 
     * @param getSearchHighlightsResult
     */
    public void setGetSearchHighlightsResult(com.actionmedia.webservice.searchservice.GetSearchHighlightsResponseGetSearchHighlightsResult getSearchHighlightsResult) {
        this.getSearchHighlightsResult = getSearchHighlightsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetSearchHighlightsResponse)) return false;
        GetSearchHighlightsResponse other = (GetSearchHighlightsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getSearchHighlightsResult==null && other.getGetSearchHighlightsResult()==null) || 
             (this.getSearchHighlightsResult!=null &&
              this.getSearchHighlightsResult.equals(other.getGetSearchHighlightsResult())));
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
        if (getGetSearchHighlightsResult() != null) {
            _hashCode += getGetSearchHighlightsResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetSearchHighlightsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetSearchHighlightsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getSearchHighlightsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetSearchHighlightsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetSearchHighlightsResponse>GetSearchHighlightsResult"));
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
