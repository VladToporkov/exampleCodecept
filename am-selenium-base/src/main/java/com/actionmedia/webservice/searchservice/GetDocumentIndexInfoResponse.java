/**
 * GetDocumentIndexInfoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class GetDocumentIndexInfoResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.searchservice.GetDocumentIndexInfoResponseGetDocumentIndexInfoResult getDocumentIndexInfoResult;

    public GetDocumentIndexInfoResponse() {
    }

    public GetDocumentIndexInfoResponse(
           com.actionmedia.webservice.searchservice.GetDocumentIndexInfoResponseGetDocumentIndexInfoResult getDocumentIndexInfoResult) {
           this.getDocumentIndexInfoResult = getDocumentIndexInfoResult;
    }


    /**
     * Gets the getDocumentIndexInfoResult value for this GetDocumentIndexInfoResponse.
     * 
     * @return getDocumentIndexInfoResult
     */
    public com.actionmedia.webservice.searchservice.GetDocumentIndexInfoResponseGetDocumentIndexInfoResult getGetDocumentIndexInfoResult() {
        return getDocumentIndexInfoResult;
    }


    /**
     * Sets the getDocumentIndexInfoResult value for this GetDocumentIndexInfoResponse.
     * 
     * @param getDocumentIndexInfoResult
     */
    public void setGetDocumentIndexInfoResult(com.actionmedia.webservice.searchservice.GetDocumentIndexInfoResponseGetDocumentIndexInfoResult getDocumentIndexInfoResult) {
        this.getDocumentIndexInfoResult = getDocumentIndexInfoResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetDocumentIndexInfoResponse)) return false;
        GetDocumentIndexInfoResponse other = (GetDocumentIndexInfoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getDocumentIndexInfoResult==null && other.getGetDocumentIndexInfoResult()==null) || 
             (this.getDocumentIndexInfoResult!=null &&
              this.getDocumentIndexInfoResult.equals(other.getGetDocumentIndexInfoResult())));
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
        if (getGetDocumentIndexInfoResult() != null) {
            _hashCode += getGetDocumentIndexInfoResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetDocumentIndexInfoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetDocumentIndexInfoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getDocumentIndexInfoResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetDocumentIndexInfoResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetDocumentIndexInfoResponse>GetDocumentIndexInfoResult"));
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
