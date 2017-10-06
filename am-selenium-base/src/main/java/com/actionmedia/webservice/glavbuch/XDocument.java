/**
 * XDocument.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.glavbuch;

public class XDocument  implements java.io.Serializable {
    private org.apache.axis.types.UnsignedByte modId;

    private int docId;

    private java.lang.Boolean actual;

    public XDocument() {
    }

    public XDocument(
           org.apache.axis.types.UnsignedByte modId,
           int docId,
           java.lang.Boolean actual) {
           this.modId = modId;
           this.docId = docId;
           this.actual = actual;
    }


    /**
     * Gets the modId value for this XDocument.
     * 
     * @return modId
     */
    public org.apache.axis.types.UnsignedByte getModId() {
        return modId;
    }


    /**
     * Sets the modId value for this XDocument.
     * 
     * @param modId
     */
    public void setModId(org.apache.axis.types.UnsignedByte modId) {
        this.modId = modId;
    }


    /**
     * Gets the docId value for this XDocument.
     * 
     * @return docId
     */
    public int getDocId() {
        return docId;
    }


    /**
     * Sets the docId value for this XDocument.
     * 
     * @param docId
     */
    public void setDocId(int docId) {
        this.docId = docId;
    }


    /**
     * Gets the actual value for this XDocument.
     * 
     * @return actual
     */
    public java.lang.Boolean getActual() {
        return actual;
    }


    /**
     * Sets the actual value for this XDocument.
     * 
     * @param actual
     */
    public void setActual(java.lang.Boolean actual) {
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
            ((this.modId==null && other.getModId()==null) || 
             (this.modId!=null &&
              this.modId.equals(other.getModId()))) &&
            this.docId == other.getDocId() &&
            ((this.actual==null && other.getActual()==null) || 
             (this.actual!=null &&
              this.actual.equals(other.getActual())));
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
        if (getModId() != null) {
            _hashCode += getModId().hashCode();
        }
        _hashCode += getDocId();
        if (getActual() != null) {
            _hashCode += getActual().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(XDocument.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">XDocument"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "ModId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "DocId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("actual");
        elemField.setXmlName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "Actual"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
