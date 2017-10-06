/**
 * DocumentLinkTarget.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.exportnpdservice;

public class DocumentLinkTarget  implements java.io.Serializable {
    private int documentID;

    private short moduleID;

    private java.lang.String anchor;

    private boolean isEmpty;

    private boolean targetExists;

    private java.lang.String attributesRow;

    public DocumentLinkTarget() {
    }

    public DocumentLinkTarget(
           int documentID,
           short moduleID,
           java.lang.String anchor,
           boolean isEmpty,
           boolean targetExists,
           java.lang.String attributesRow) {
           this.documentID = documentID;
           this.moduleID = moduleID;
           this.anchor = anchor;
           this.isEmpty = isEmpty;
           this.targetExists = targetExists;
           this.attributesRow = attributesRow;
    }


    /**
     * Gets the documentID value for this DocumentLinkTarget.
     * 
     * @return documentID
     */
    public int getDocumentID() {
        return documentID;
    }


    /**
     * Sets the documentID value for this DocumentLinkTarget.
     * 
     * @param documentID
     */
    public void setDocumentID(int documentID) {
        this.documentID = documentID;
    }


    /**
     * Gets the moduleID value for this DocumentLinkTarget.
     * 
     * @return moduleID
     */
    public short getModuleID() {
        return moduleID;
    }


    /**
     * Sets the moduleID value for this DocumentLinkTarget.
     * 
     * @param moduleID
     */
    public void setModuleID(short moduleID) {
        this.moduleID = moduleID;
    }


    /**
     * Gets the anchor value for this DocumentLinkTarget.
     * 
     * @return anchor
     */
    public java.lang.String getAnchor() {
        return anchor;
    }


    /**
     * Sets the anchor value for this DocumentLinkTarget.
     * 
     * @param anchor
     */
    public void setAnchor(java.lang.String anchor) {
        this.anchor = anchor;
    }


    /**
     * Gets the isEmpty value for this DocumentLinkTarget.
     * 
     * @return isEmpty
     */
    public boolean isIsEmpty() {
        return isEmpty;
    }


    /**
     * Sets the isEmpty value for this DocumentLinkTarget.
     * 
     * @param isEmpty
     */
    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }


    /**
     * Gets the targetExists value for this DocumentLinkTarget.
     * 
     * @return targetExists
     */
    public boolean isTargetExists() {
        return targetExists;
    }


    /**
     * Sets the targetExists value for this DocumentLinkTarget.
     * 
     * @param targetExists
     */
    public void setTargetExists(boolean targetExists) {
        this.targetExists = targetExists;
    }


    /**
     * Gets the attributesRow value for this DocumentLinkTarget.
     * 
     * @return attributesRow
     */
    public java.lang.String getAttributesRow() {
        return attributesRow;
    }


    /**
     * Sets the attributesRow value for this DocumentLinkTarget.
     * 
     * @param attributesRow
     */
    public void setAttributesRow(java.lang.String attributesRow) {
        this.attributesRow = attributesRow;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocumentLinkTarget)) return false;
        DocumentLinkTarget other = (DocumentLinkTarget) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.documentID == other.getDocumentID() &&
            this.moduleID == other.getModuleID() &&
            ((this.anchor==null && other.getAnchor()==null) || 
             (this.anchor!=null &&
              this.anchor.equals(other.getAnchor()))) &&
            this.isEmpty == other.isIsEmpty() &&
            this.targetExists == other.isTargetExists() &&
            ((this.attributesRow==null && other.getAttributesRow()==null) || 
             (this.attributesRow!=null &&
              this.attributesRow.equals(other.getAttributesRow())));
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
        _hashCode += getDocumentID();
        _hashCode += getModuleID();
        if (getAnchor() != null) {
            _hashCode += getAnchor().hashCode();
        }
        _hashCode += (isIsEmpty() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isTargetExists() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getAttributesRow() != null) {
            _hashCode += getAttributesRow().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocumentLinkTarget.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "DocumentLinkTarget"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "DocumentID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moduleID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "ModuleID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anchor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "Anchor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isEmpty");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "IsEmpty"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("targetExists");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "TargetExists"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attributesRow");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "AttributesRow"));
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
