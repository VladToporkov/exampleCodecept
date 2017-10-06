/**
 * GetLogSettingsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class GetLogSettingsResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.searchservice.GetLogSettingsResponseGetLogSettingsResult getLogSettingsResult;

    public GetLogSettingsResponse() {
    }

    public GetLogSettingsResponse(
           com.actionmedia.webservice.searchservice.GetLogSettingsResponseGetLogSettingsResult getLogSettingsResult) {
           this.getLogSettingsResult = getLogSettingsResult;
    }


    /**
     * Gets the getLogSettingsResult value for this GetLogSettingsResponse.
     * 
     * @return getLogSettingsResult
     */
    public com.actionmedia.webservice.searchservice.GetLogSettingsResponseGetLogSettingsResult getGetLogSettingsResult() {
        return getLogSettingsResult;
    }


    /**
     * Sets the getLogSettingsResult value for this GetLogSettingsResponse.
     * 
     * @param getLogSettingsResult
     */
    public void setGetLogSettingsResult(com.actionmedia.webservice.searchservice.GetLogSettingsResponseGetLogSettingsResult getLogSettingsResult) {
        this.getLogSettingsResult = getLogSettingsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetLogSettingsResponse)) return false;
        GetLogSettingsResponse other = (GetLogSettingsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getLogSettingsResult==null && other.getGetLogSettingsResult()==null) || 
             (this.getLogSettingsResult!=null &&
              this.getLogSettingsResult.equals(other.getGetLogSettingsResult())));
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
        if (getGetLogSettingsResult() != null) {
            _hashCode += getGetLogSettingsResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetLogSettingsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetLogSettingsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getLogSettingsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetLogSettingsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetLogSettingsResponse>GetLogSettingsResult"));
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
