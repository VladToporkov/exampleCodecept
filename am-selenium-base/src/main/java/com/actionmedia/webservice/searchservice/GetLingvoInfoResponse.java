/**
 * GetLingvoInfoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class GetLingvoInfoResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.searchservice.GetLingvoInfoResponseGetLingvoInfoResult getLingvoInfoResult;

    public GetLingvoInfoResponse() {
    }

    public GetLingvoInfoResponse(
           com.actionmedia.webservice.searchservice.GetLingvoInfoResponseGetLingvoInfoResult getLingvoInfoResult) {
           this.getLingvoInfoResult = getLingvoInfoResult;
    }


    /**
     * Gets the getLingvoInfoResult value for this GetLingvoInfoResponse.
     * 
     * @return getLingvoInfoResult
     */
    public com.actionmedia.webservice.searchservice.GetLingvoInfoResponseGetLingvoInfoResult getGetLingvoInfoResult() {
        return getLingvoInfoResult;
    }


    /**
     * Sets the getLingvoInfoResult value for this GetLingvoInfoResponse.
     * 
     * @param getLingvoInfoResult
     */
    public void setGetLingvoInfoResult(com.actionmedia.webservice.searchservice.GetLingvoInfoResponseGetLingvoInfoResult getLingvoInfoResult) {
        this.getLingvoInfoResult = getLingvoInfoResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetLingvoInfoResponse)) return false;
        GetLingvoInfoResponse other = (GetLingvoInfoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getLingvoInfoResult==null && other.getGetLingvoInfoResult()==null) || 
             (this.getLingvoInfoResult!=null &&
              this.getLingvoInfoResult.equals(other.getGetLingvoInfoResult())));
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
        if (getGetLingvoInfoResult() != null) {
            _hashCode += getGetLingvoInfoResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetLingvoInfoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetLingvoInfoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getLingvoInfoResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetLingvoInfoResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetLingvoInfoResponse>GetLingvoInfoResult"));
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
