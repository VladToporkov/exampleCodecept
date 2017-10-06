/**
 * GetCertificatesResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.actionbonus.proxyservice;

public class GetCertificatesResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.actionbonus.proxyservice.GetCertificatesResponseGetCertificatesResult getCertificatesResult;

    public GetCertificatesResponse() {
    }

    public GetCertificatesResponse(
           com.actionmedia.webservice.actionbonus.proxyservice.GetCertificatesResponseGetCertificatesResult getCertificatesResult) {
           this.getCertificatesResult = getCertificatesResult;
    }


    /**
     * Gets the getCertificatesResult value for this GetCertificatesResponse.
     * 
     * @return getCertificatesResult
     */
    public com.actionmedia.webservice.actionbonus.proxyservice.GetCertificatesResponseGetCertificatesResult getGetCertificatesResult() {
        return getCertificatesResult;
    }


    /**
     * Sets the getCertificatesResult value for this GetCertificatesResponse.
     * 
     * @param getCertificatesResult
     */
    public void setGetCertificatesResult(com.actionmedia.webservice.actionbonus.proxyservice.GetCertificatesResponseGetCertificatesResult getCertificatesResult) {
        this.getCertificatesResult = getCertificatesResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetCertificatesResponse)) return false;
        GetCertificatesResponse other = (GetCertificatesResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getCertificatesResult==null && other.getGetCertificatesResult()==null) || 
             (this.getCertificatesResult!=null &&
              this.getCertificatesResult.equals(other.getGetCertificatesResult())));
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
        if (getGetCertificatesResult() != null) {
            _hashCode += getGetCertificatesResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetCertificatesResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetCertificatesResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getCertificatesResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetCertificatesResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetCertificatesResponse>GetCertificatesResult"));
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
