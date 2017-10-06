/**
 * GetSubstitutingEnvironmentResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class GetSubstitutingEnvironmentResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.searchservice.GetSubstitutingEnvironmentResponseGetSubstitutingEnvironmentResult getSubstitutingEnvironmentResult;

    public GetSubstitutingEnvironmentResponse() {
    }

    public GetSubstitutingEnvironmentResponse(
           com.actionmedia.webservice.searchservice.GetSubstitutingEnvironmentResponseGetSubstitutingEnvironmentResult getSubstitutingEnvironmentResult) {
           this.getSubstitutingEnvironmentResult = getSubstitutingEnvironmentResult;
    }


    /**
     * Gets the getSubstitutingEnvironmentResult value for this GetSubstitutingEnvironmentResponse.
     * 
     * @return getSubstitutingEnvironmentResult
     */
    public com.actionmedia.webservice.searchservice.GetSubstitutingEnvironmentResponseGetSubstitutingEnvironmentResult getGetSubstitutingEnvironmentResult() {
        return getSubstitutingEnvironmentResult;
    }


    /**
     * Sets the getSubstitutingEnvironmentResult value for this GetSubstitutingEnvironmentResponse.
     * 
     * @param getSubstitutingEnvironmentResult
     */
    public void setGetSubstitutingEnvironmentResult(com.actionmedia.webservice.searchservice.GetSubstitutingEnvironmentResponseGetSubstitutingEnvironmentResult getSubstitutingEnvironmentResult) {
        this.getSubstitutingEnvironmentResult = getSubstitutingEnvironmentResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetSubstitutingEnvironmentResponse)) return false;
        GetSubstitutingEnvironmentResponse other = (GetSubstitutingEnvironmentResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getSubstitutingEnvironmentResult==null && other.getGetSubstitutingEnvironmentResult()==null) || 
             (this.getSubstitutingEnvironmentResult!=null &&
              this.getSubstitutingEnvironmentResult.equals(other.getGetSubstitutingEnvironmentResult())));
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
        if (getGetSubstitutingEnvironmentResult() != null) {
            _hashCode += getGetSubstitutingEnvironmentResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetSubstitutingEnvironmentResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetSubstitutingEnvironmentResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getSubstitutingEnvironmentResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetSubstitutingEnvironmentResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetSubstitutingEnvironmentResponse>GetSubstitutingEnvironmentResult"));
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
