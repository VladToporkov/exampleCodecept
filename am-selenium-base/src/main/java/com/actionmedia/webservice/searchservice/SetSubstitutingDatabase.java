/**
 * SetSubstitutingDatabase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchservice;

public class SetSubstitutingDatabase  implements java.io.Serializable {
    private java.lang.String originalDatabase;

    private java.lang.String substitutingDatabase;

    public SetSubstitutingDatabase() {
    }

    public SetSubstitutingDatabase(
           java.lang.String originalDatabase,
           java.lang.String substitutingDatabase) {
           this.originalDatabase = originalDatabase;
           this.substitutingDatabase = substitutingDatabase;
    }


    /**
     * Gets the originalDatabase value for this SetSubstitutingDatabase.
     * 
     * @return originalDatabase
     */
    public java.lang.String getOriginalDatabase() {
        return originalDatabase;
    }


    /**
     * Sets the originalDatabase value for this SetSubstitutingDatabase.
     * 
     * @param originalDatabase
     */
    public void setOriginalDatabase(java.lang.String originalDatabase) {
        this.originalDatabase = originalDatabase;
    }


    /**
     * Gets the substitutingDatabase value for this SetSubstitutingDatabase.
     * 
     * @return substitutingDatabase
     */
    public java.lang.String getSubstitutingDatabase() {
        return substitutingDatabase;
    }


    /**
     * Sets the substitutingDatabase value for this SetSubstitutingDatabase.
     * 
     * @param substitutingDatabase
     */
    public void setSubstitutingDatabase(java.lang.String substitutingDatabase) {
        this.substitutingDatabase = substitutingDatabase;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SetSubstitutingDatabase)) return false;
        SetSubstitutingDatabase other = (SetSubstitutingDatabase) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.originalDatabase==null && other.getOriginalDatabase()==null) || 
             (this.originalDatabase!=null &&
              this.originalDatabase.equals(other.getOriginalDatabase()))) &&
            ((this.substitutingDatabase==null && other.getSubstitutingDatabase()==null) || 
             (this.substitutingDatabase!=null &&
              this.substitutingDatabase.equals(other.getSubstitutingDatabase())));
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
        if (getOriginalDatabase() != null) {
            _hashCode += getOriginalDatabase().hashCode();
        }
        if (getSubstitutingDatabase() != null) {
            _hashCode += getSubstitutingDatabase().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SetSubstitutingDatabase.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SetSubstitutingDatabase"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originalDatabase");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "originalDatabase"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("substitutingDatabase");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "substitutingDatabase"));
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
