/**
 * SetSubstitutingServerResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class SetSubstitutingServerResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.searchservice.SetSubstitutingServerResponseSetSubstitutingServerResult setSubstitutingServerResult;

    public SetSubstitutingServerResponse() {
    }

    public SetSubstitutingServerResponse(
           com.actionmedia.webservice.searchservice.SetSubstitutingServerResponseSetSubstitutingServerResult setSubstitutingServerResult) {
           this.setSubstitutingServerResult = setSubstitutingServerResult;
    }


    /**
     * Gets the setSubstitutingServerResult value for this SetSubstitutingServerResponse.
     * 
     * @return setSubstitutingServerResult
     */
    public com.actionmedia.webservice.searchservice.SetSubstitutingServerResponseSetSubstitutingServerResult getSetSubstitutingServerResult() {
        return setSubstitutingServerResult;
    }


    /**
     * Sets the setSubstitutingServerResult value for this SetSubstitutingServerResponse.
     * 
     * @param setSubstitutingServerResult
     */
    public void setSetSubstitutingServerResult(com.actionmedia.webservice.searchservice.SetSubstitutingServerResponseSetSubstitutingServerResult setSubstitutingServerResult) {
        this.setSubstitutingServerResult = setSubstitutingServerResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SetSubstitutingServerResponse)) return false;
        SetSubstitutingServerResponse other = (SetSubstitutingServerResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.setSubstitutingServerResult==null && other.getSetSubstitutingServerResult()==null) || 
             (this.setSubstitutingServerResult!=null &&
              this.setSubstitutingServerResult.equals(other.getSetSubstitutingServerResult())));
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
        if (getSetSubstitutingServerResult() != null) {
            _hashCode += getSetSubstitutingServerResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SetSubstitutingServerResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SetSubstitutingServerResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("setSubstitutingServerResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SetSubstitutingServerResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>SetSubstitutingServerResponse>SetSubstitutingServerResult"));
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
