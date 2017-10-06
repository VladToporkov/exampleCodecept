/**
 * Catalog2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchextendedservice;

public class Catalog2  implements java.io.Serializable {
    private org.apache.axis.types.UnsignedByte pubDivId;

    private java.lang.String preferedRegionCode;

    public Catalog2() {
    }

    public Catalog2(
           org.apache.axis.types.UnsignedByte pubDivId,
           java.lang.String preferedRegionCode) {
           this.pubDivId = pubDivId;
           this.preferedRegionCode = preferedRegionCode;
    }


    /**
     * Gets the pubDivId value for this Catalog2.
     * 
     * @return pubDivId
     */
    public org.apache.axis.types.UnsignedByte getPubDivId() {
        return pubDivId;
    }


    /**
     * Sets the pubDivId value for this Catalog2.
     * 
     * @param pubDivId
     */
    public void setPubDivId(org.apache.axis.types.UnsignedByte pubDivId) {
        this.pubDivId = pubDivId;
    }


    /**
     * Gets the preferedRegionCode value for this Catalog2.
     * 
     * @return preferedRegionCode
     */
    public java.lang.String getPreferedRegionCode() {
        return preferedRegionCode;
    }


    /**
     * Sets the preferedRegionCode value for this Catalog2.
     * 
     * @param preferedRegionCode
     */
    public void setPreferedRegionCode(java.lang.String preferedRegionCode) {
        this.preferedRegionCode = preferedRegionCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Catalog2)) return false;
        Catalog2 other = (Catalog2) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.pubDivId==null && other.getPubDivId()==null) || 
             (this.pubDivId!=null &&
              this.pubDivId.equals(other.getPubDivId()))) &&
            ((this.preferedRegionCode==null && other.getPreferedRegionCode()==null) || 
             (this.preferedRegionCode!=null &&
              this.preferedRegionCode.equals(other.getPreferedRegionCode())));
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
        if (getPubDivId() != null) {
            _hashCode += getPubDivId().hashCode();
        }
        if (getPreferedRegionCode() != null) {
            _hashCode += getPreferedRegionCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Catalog2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">Catalog2"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubDivId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "pubDivId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preferedRegionCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "PreferedRegionCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
