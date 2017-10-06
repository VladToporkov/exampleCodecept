/**
 * GetDictionaryInfosResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class GetDictionaryInfosResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.searchservice.GetDictionaryInfosResponseGetDictionaryInfosResult getDictionaryInfosResult;

    public GetDictionaryInfosResponse() {
    }

    public GetDictionaryInfosResponse(
           com.actionmedia.webservice.searchservice.GetDictionaryInfosResponseGetDictionaryInfosResult getDictionaryInfosResult) {
           this.getDictionaryInfosResult = getDictionaryInfosResult;
    }


    /**
     * Gets the getDictionaryInfosResult value for this GetDictionaryInfosResponse.
     * 
     * @return getDictionaryInfosResult
     */
    public com.actionmedia.webservice.searchservice.GetDictionaryInfosResponseGetDictionaryInfosResult getGetDictionaryInfosResult() {
        return getDictionaryInfosResult;
    }


    /**
     * Sets the getDictionaryInfosResult value for this GetDictionaryInfosResponse.
     * 
     * @param getDictionaryInfosResult
     */
    public void setGetDictionaryInfosResult(com.actionmedia.webservice.searchservice.GetDictionaryInfosResponseGetDictionaryInfosResult getDictionaryInfosResult) {
        this.getDictionaryInfosResult = getDictionaryInfosResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetDictionaryInfosResponse)) return false;
        GetDictionaryInfosResponse other = (GetDictionaryInfosResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getDictionaryInfosResult==null && other.getGetDictionaryInfosResult()==null) || 
             (this.getDictionaryInfosResult!=null &&
              this.getDictionaryInfosResult.equals(other.getGetDictionaryInfosResult())));
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
        if (getGetDictionaryInfosResult() != null) {
            _hashCode += getGetDictionaryInfosResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetDictionaryInfosResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetDictionaryInfosResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getDictionaryInfosResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetDictionaryInfosResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetDictionaryInfosResponse>GetDictionaryInfosResult"));
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
