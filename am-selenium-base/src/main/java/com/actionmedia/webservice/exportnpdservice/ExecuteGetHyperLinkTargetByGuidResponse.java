/**
 * ExecuteGetHyperLinkTargetByGuidResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.exportnpdservice;

public class ExecuteGetHyperLinkTargetByGuidResponse  extends com.actionmedia.webservice.exportnpdservice.ExecuteResponse  implements java.io.Serializable {
    private int documentID;

    private short moduleID;

    private java.lang.String anchor;

    private boolean targetExists;

    public ExecuteGetHyperLinkTargetByGuidResponse() {
    }

    public ExecuteGetHyperLinkTargetByGuidResponse(
           long durationInMSec,
           int documentID,
           short moduleID,
           java.lang.String anchor,
           boolean targetExists) {
        super(
            durationInMSec);
        this.documentID = documentID;
        this.moduleID = moduleID;
        this.anchor = anchor;
        this.targetExists = targetExists;
    }


    /**
     * Gets the documentID value for this ExecuteGetHyperLinkTargetByGuidResponse.
     * 
     * @return documentID
     */
    public int getDocumentID() {
        return documentID;
    }


    /**
     * Sets the documentID value for this ExecuteGetHyperLinkTargetByGuidResponse.
     * 
     * @param documentID
     */
    public void setDocumentID(int documentID) {
        this.documentID = documentID;
    }


    /**
     * Gets the moduleID value for this ExecuteGetHyperLinkTargetByGuidResponse.
     * 
     * @return moduleID
     */
    public short getModuleID() {
        return moduleID;
    }


    /**
     * Sets the moduleID value for this ExecuteGetHyperLinkTargetByGuidResponse.
     * 
     * @param moduleID
     */
    public void setModuleID(short moduleID) {
        this.moduleID = moduleID;
    }


    /**
     * Gets the anchor value for this ExecuteGetHyperLinkTargetByGuidResponse.
     * 
     * @return anchor
     */
    public java.lang.String getAnchor() {
        return anchor;
    }


    /**
     * Sets the anchor value for this ExecuteGetHyperLinkTargetByGuidResponse.
     * 
     * @param anchor
     */
    public void setAnchor(java.lang.String anchor) {
        this.anchor = anchor;
    }


    /**
     * Gets the targetExists value for this ExecuteGetHyperLinkTargetByGuidResponse.
     * 
     * @return targetExists
     */
    public boolean isTargetExists() {
        return targetExists;
    }


    /**
     * Sets the targetExists value for this ExecuteGetHyperLinkTargetByGuidResponse.
     * 
     * @param targetExists
     */
    public void setTargetExists(boolean targetExists) {
        this.targetExists = targetExists;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExecuteGetHyperLinkTargetByGuidResponse)) return false;
        ExecuteGetHyperLinkTargetByGuidResponse other = (ExecuteGetHyperLinkTargetByGuidResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.documentID == other.getDocumentID() &&
            this.moduleID == other.getModuleID() &&
            ((this.anchor==null && other.getAnchor()==null) || 
             (this.anchor!=null &&
              this.anchor.equals(other.getAnchor()))) &&
            this.targetExists == other.isTargetExists();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        _hashCode += getDocumentID();
        _hashCode += getModuleID();
        if (getAnchor() != null) {
            _hashCode += getAnchor().hashCode();
        }
        _hashCode += (isTargetExists() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExecuteGetHyperLinkTargetByGuidResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetHyperLinkTargetByGuidResponse"));
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
        elemField.setFieldName("targetExists");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "TargetExists"));
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
