/**
 * GetSearchHighlightsByPhraseResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class GetSearchHighlightsByPhraseResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.searchservice.GetSearchHighlightsByPhraseResponseGetSearchHighlightsByPhraseResult getSearchHighlightsByPhraseResult;

    public GetSearchHighlightsByPhraseResponse() {
    }

    public GetSearchHighlightsByPhraseResponse(
           com.actionmedia.webservice.searchservice.GetSearchHighlightsByPhraseResponseGetSearchHighlightsByPhraseResult getSearchHighlightsByPhraseResult) {
           this.getSearchHighlightsByPhraseResult = getSearchHighlightsByPhraseResult;
    }


    /**
     * Gets the getSearchHighlightsByPhraseResult value for this GetSearchHighlightsByPhraseResponse.
     * 
     * @return getSearchHighlightsByPhraseResult
     */
    public com.actionmedia.webservice.searchservice.GetSearchHighlightsByPhraseResponseGetSearchHighlightsByPhraseResult getGetSearchHighlightsByPhraseResult() {
        return getSearchHighlightsByPhraseResult;
    }


    /**
     * Sets the getSearchHighlightsByPhraseResult value for this GetSearchHighlightsByPhraseResponse.
     * 
     * @param getSearchHighlightsByPhraseResult
     */
    public void setGetSearchHighlightsByPhraseResult(com.actionmedia.webservice.searchservice.GetSearchHighlightsByPhraseResponseGetSearchHighlightsByPhraseResult getSearchHighlightsByPhraseResult) {
        this.getSearchHighlightsByPhraseResult = getSearchHighlightsByPhraseResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetSearchHighlightsByPhraseResponse)) return false;
        GetSearchHighlightsByPhraseResponse other = (GetSearchHighlightsByPhraseResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getSearchHighlightsByPhraseResult==null && other.getGetSearchHighlightsByPhraseResult()==null) || 
             (this.getSearchHighlightsByPhraseResult!=null &&
              this.getSearchHighlightsByPhraseResult.equals(other.getGetSearchHighlightsByPhraseResult())));
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
        if (getGetSearchHighlightsByPhraseResult() != null) {
            _hashCode += getGetSearchHighlightsByPhraseResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetSearchHighlightsByPhraseResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetSearchHighlightsByPhraseResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getSearchHighlightsByPhraseResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetSearchHighlightsByPhraseResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetSearchHighlightsByPhraseResponse>GetSearchHighlightsByPhraseResult"));
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
