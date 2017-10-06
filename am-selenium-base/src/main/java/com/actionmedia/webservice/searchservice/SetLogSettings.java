/**
 * SetLogSettings.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class SetLogSettings  implements java.io.Serializable {
    private java.lang.String logLevel;

    private org.apache.axis.types.UnsignedByte[] pubList;

    public SetLogSettings() {
    }

    public SetLogSettings(
           java.lang.String logLevel,
           org.apache.axis.types.UnsignedByte[] pubList) {
           this.logLevel = logLevel;
           this.pubList = pubList;
    }


    /**
     * Gets the logLevel value for this SetLogSettings.
     * 
     * @return logLevel
     */
    public java.lang.String getLogLevel() {
        return logLevel;
    }


    /**
     * Sets the logLevel value for this SetLogSettings.
     * 
     * @param logLevel
     */
    public void setLogLevel(java.lang.String logLevel) {
        this.logLevel = logLevel;
    }


    /**
     * Gets the pubList value for this SetLogSettings.
     * 
     * @return pubList
     */
    public org.apache.axis.types.UnsignedByte[] getPubList() {
        return pubList;
    }


    /**
     * Sets the pubList value for this SetLogSettings.
     * 
     * @param pubList
     */
    public void setPubList(org.apache.axis.types.UnsignedByte[] pubList) {
        this.pubList = pubList;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SetLogSettings)) return false;
        SetLogSettings other = (SetLogSettings) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.logLevel==null && other.getLogLevel()==null) || 
             (this.logLevel!=null &&
              this.logLevel.equals(other.getLogLevel()))) &&
            ((this.pubList==null && other.getPubList()==null) || 
             (this.pubList!=null &&
              java.util.Arrays.equals(this.pubList, other.getPubList())));
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
        if (getLogLevel() != null) {
            _hashCode += getLogLevel().hashCode();
        }
        if (getPubList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPubList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPubList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SetLogSettings.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SetLogSettings"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("logLevel");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "logLevel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "pubList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "unsignedByte"));
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
