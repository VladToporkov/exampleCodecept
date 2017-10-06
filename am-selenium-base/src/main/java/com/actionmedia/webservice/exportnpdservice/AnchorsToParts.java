/**
 * AnchorsToParts.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.exportnpdservice;

public class AnchorsToParts  implements java.io.Serializable {
    private java.lang.String anchorName;

    private int partID;

    public AnchorsToParts() {
    }

    public AnchorsToParts(
           java.lang.String anchorName,
           int partID) {
           this.anchorName = anchorName;
           this.partID = partID;
    }


    /**
     * Gets the anchorName value for this AnchorsToParts.
     * 
     * @return anchorName
     */
    public java.lang.String getAnchorName() {
        return anchorName;
    }


    /**
     * Sets the anchorName value for this AnchorsToParts.
     * 
     * @param anchorName
     */
    public void setAnchorName(java.lang.String anchorName) {
        this.anchorName = anchorName;
    }


    /**
     * Gets the partID value for this AnchorsToParts.
     * 
     * @return partID
     */
    public int getPartID() {
        return partID;
    }


    /**
     * Sets the partID value for this AnchorsToParts.
     * 
     * @param partID
     */
    public void setPartID(int partID) {
        this.partID = partID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AnchorsToParts)) return false;
        AnchorsToParts other = (AnchorsToParts) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.anchorName==null && other.getAnchorName()==null) || 
             (this.anchorName!=null &&
              this.anchorName.equals(other.getAnchorName()))) &&
            this.partID == other.getPartID();
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
        if (getAnchorName() != null) {
            _hashCode += getAnchorName().hashCode();
        }
        _hashCode += getPartID();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AnchorsToParts.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "AnchorsToParts"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anchorName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "AnchorName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "PartID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
