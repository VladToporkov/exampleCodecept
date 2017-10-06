/**
 * XDocument.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.buhonline;

public class XDocument  implements java.io.Serializable {
    private org.apache.axis.types.UnsignedByte moduleID;

    private int ID;

    private java.lang.String anchor;

    private boolean actual;

    public XDocument() {
    }

    public XDocument(
           org.apache.axis.types.UnsignedByte moduleID,
           int ID,
           java.lang.String anchor,
           boolean actual) {
           this.moduleID = moduleID;
           this.ID = ID;
           this.anchor = anchor;
           this.actual = actual;
    }


    /**
     * Gets the moduleID value for this XDocument.
     * 
     * @return moduleID
     */
    public org.apache.axis.types.UnsignedByte getModuleID() {
        return moduleID;
    }


    /**
     * Sets the moduleID value for this XDocument.
     * 
     * @param moduleID
     */
    public void setModuleID(org.apache.axis.types.UnsignedByte moduleID) {
        this.moduleID = moduleID;
    }


    /**
     * Gets the ID value for this XDocument.
     * 
     * @return ID
     */
    public int getID() {
        return ID;
    }


    /**
     * Sets the ID value for this XDocument.
     * 
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }


    /**
     * Gets the anchor value for this XDocument.
     * 
     * @return anchor
     */
    public java.lang.String getAnchor() {
        return anchor;
    }


    /**
     * Sets the anchor value for this XDocument.
     * 
     * @param anchor
     */
    public void setAnchor(java.lang.String anchor) {
        this.anchor = anchor;
    }


    /**
     * Gets the actual value for this XDocument.
     * 
     * @return actual
     */
    public boolean isActual() {
        return actual;
    }


    /**
     * Sets the actual value for this XDocument.
     * 
     * @param actual
     */
    public void setActual(boolean actual) {
        this.actual = actual;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof XDocument)) return false;
        XDocument other = (XDocument) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.moduleID==null && other.getModuleID()==null) || 
             (this.moduleID!=null &&
              this.moduleID.equals(other.getModuleID()))) &&
            this.ID == other.getID() &&
            ((this.anchor==null && other.getAnchor()==null) || 
             (this.anchor!=null &&
              this.anchor.equals(other.getAnchor()))) &&
            this.actual == other.isActual();
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
        if (getModuleID() != null) {
            _hashCode += getModuleID().hashCode();
        }
        _hashCode += getID();
        if (getAnchor() != null) {
            _hashCode += getAnchor().hashCode();
        }
        _hashCode += (isActual() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(XDocument.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">XDocument"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moduleID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "moduleID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anchor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "anchor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("actual");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "actual"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
