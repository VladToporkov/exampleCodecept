/**
 * SetSubstitutingServer.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class SetSubstitutingServer  implements java.io.Serializable {
    private java.lang.String substitutingServer;

    public SetSubstitutingServer() {
    }

    public SetSubstitutingServer(
           java.lang.String substitutingServer) {
           this.substitutingServer = substitutingServer;
    }


    /**
     * Gets the substitutingServer value for this SetSubstitutingServer.
     * 
     * @return substitutingServer
     */
    public java.lang.String getSubstitutingServer() {
        return substitutingServer;
    }


    /**
     * Sets the substitutingServer value for this SetSubstitutingServer.
     * 
     * @param substitutingServer
     */
    public void setSubstitutingServer(java.lang.String substitutingServer) {
        this.substitutingServer = substitutingServer;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SetSubstitutingServer)) return false;
        SetSubstitutingServer other = (SetSubstitutingServer) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.substitutingServer==null && other.getSubstitutingServer()==null) || 
             (this.substitutingServer!=null &&
              this.substitutingServer.equals(other.getSubstitutingServer())));
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
        if (getSubstitutingServer() != null) {
            _hashCode += getSubstitutingServer().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SetSubstitutingServer.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SetSubstitutingServer"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("substitutingServer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "substitutingServer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
