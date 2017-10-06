/**
 * DocumentLinkTargetItem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.exportnpdservice;

public class DocumentLinkTargetItem  extends com.actionmedia.webservice.exportnpdservice.DocumentLinkTarget  implements java.io.Serializable {
    private java.lang.String linkGuid;

    private org.apache.axis.types.UnsignedByte linkStatusId;

    public DocumentLinkTargetItem() {
    }

    public DocumentLinkTargetItem(
           int documentID,
           short moduleID,
           java.lang.String anchor,
           boolean isEmpty,
           boolean targetExists,
           java.lang.String attributesRow,
           java.lang.String linkGuid,
           org.apache.axis.types.UnsignedByte linkStatusId) {
        super(
            documentID,
            moduleID,
            anchor,
            isEmpty,
            targetExists,
            attributesRow);
        this.linkGuid = linkGuid;
        this.linkStatusId = linkStatusId;
    }


    /**
     * Gets the linkGuid value for this DocumentLinkTargetItem.
     * 
     * @return linkGuid
     */
    public java.lang.String getLinkGuid() {
        return linkGuid;
    }


    /**
     * Sets the linkGuid value for this DocumentLinkTargetItem.
     * 
     * @param linkGuid
     */
    public void setLinkGuid(java.lang.String linkGuid) {
        this.linkGuid = linkGuid;
    }


    /**
     * Gets the linkStatusId value for this DocumentLinkTargetItem.
     * 
     * @return linkStatusId
     */
    public org.apache.axis.types.UnsignedByte getLinkStatusId() {
        return linkStatusId;
    }


    /**
     * Sets the linkStatusId value for this DocumentLinkTargetItem.
     * 
     * @param linkStatusId
     */
    public void setLinkStatusId(org.apache.axis.types.UnsignedByte linkStatusId) {
        this.linkStatusId = linkStatusId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocumentLinkTargetItem)) return false;
        DocumentLinkTargetItem other = (DocumentLinkTargetItem) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.linkGuid==null && other.getLinkGuid()==null) || 
             (this.linkGuid!=null &&
              this.linkGuid.equals(other.getLinkGuid()))) &&
            ((this.linkStatusId==null && other.getLinkStatusId()==null) || 
             (this.linkStatusId!=null &&
              this.linkStatusId.equals(other.getLinkStatusId())));
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
        if (getLinkGuid() != null) {
            _hashCode += getLinkGuid().hashCode();
        }
        if (getLinkStatusId() != null) {
            _hashCode += getLinkStatusId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocumentLinkTargetItem.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "DocumentLinkTargetItem"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("linkGuid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "LinkGuid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("linkStatusId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "LinkStatusId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
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
