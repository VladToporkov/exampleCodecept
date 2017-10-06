/**
 * GetNpdDocumentInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.exportnpdservice;

public class GetNpdDocumentInfo  implements java.io.Serializable {
    private org.apache.axis.types.UnsignedByte pubId;

    private org.apache.axis.types.UnsignedByte moduleID;

    private int ID;

    private java.lang.String anchor;

    private java.lang.String hlinkTemplate;

    public GetNpdDocumentInfo() {
    }

    public GetNpdDocumentInfo(
           org.apache.axis.types.UnsignedByte pubId,
           org.apache.axis.types.UnsignedByte moduleID,
           int ID,
           java.lang.String anchor,
           java.lang.String hlinkTemplate) {
           this.pubId = pubId;
           this.moduleID = moduleID;
           this.ID = ID;
           this.anchor = anchor;
           this.hlinkTemplate = hlinkTemplate;
    }


    /**
     * Gets the pubId value for this GetNpdDocumentInfo.
     * 
     * @return pubId
     */
    public org.apache.axis.types.UnsignedByte getPubId() {
        return pubId;
    }


    /**
     * Sets the pubId value for this GetNpdDocumentInfo.
     * 
     * @param pubId
     */
    public void setPubId(org.apache.axis.types.UnsignedByte pubId) {
        this.pubId = pubId;
    }


    /**
     * Gets the moduleID value for this GetNpdDocumentInfo.
     * 
     * @return moduleID
     */
    public org.apache.axis.types.UnsignedByte getModuleID() {
        return moduleID;
    }


    /**
     * Sets the moduleID value for this GetNpdDocumentInfo.
     * 
     * @param moduleID
     */
    public void setModuleID(org.apache.axis.types.UnsignedByte moduleID) {
        this.moduleID = moduleID;
    }


    /**
     * Gets the ID value for this GetNpdDocumentInfo.
     * 
     * @return ID
     */
    public int getID() {
        return ID;
    }


    /**
     * Sets the ID value for this GetNpdDocumentInfo.
     * 
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }


    /**
     * Gets the anchor value for this GetNpdDocumentInfo.
     * 
     * @return anchor
     */
    public java.lang.String getAnchor() {
        return anchor;
    }


    /**
     * Sets the anchor value for this GetNpdDocumentInfo.
     * 
     * @param anchor
     */
    public void setAnchor(java.lang.String anchor) {
        this.anchor = anchor;
    }


    /**
     * Gets the hlinkTemplate value for this GetNpdDocumentInfo.
     * 
     * @return hlinkTemplate
     */
    public java.lang.String getHlinkTemplate() {
        return hlinkTemplate;
    }


    /**
     * Sets the hlinkTemplate value for this GetNpdDocumentInfo.
     * 
     * @param hlinkTemplate
     */
    public void setHlinkTemplate(java.lang.String hlinkTemplate) {
        this.hlinkTemplate = hlinkTemplate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetNpdDocumentInfo)) return false;
        GetNpdDocumentInfo other = (GetNpdDocumentInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.pubId==null && other.getPubId()==null) || 
             (this.pubId!=null &&
              this.pubId.equals(other.getPubId()))) &&
            ((this.moduleID==null && other.getModuleID()==null) || 
             (this.moduleID!=null &&
              this.moduleID.equals(other.getModuleID()))) &&
            this.ID == other.getID() &&
            ((this.anchor==null && other.getAnchor()==null) || 
             (this.anchor!=null &&
              this.anchor.equals(other.getAnchor()))) &&
            ((this.hlinkTemplate==null && other.getHlinkTemplate()==null) || 
             (this.hlinkTemplate!=null &&
              this.hlinkTemplate.equals(other.getHlinkTemplate())));
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
        if (getPubId() != null) {
            _hashCode += getPubId().hashCode();
        }
        if (getModuleID() != null) {
            _hashCode += getModuleID().hashCode();
        }
        _hashCode += getID();
        if (getAnchor() != null) {
            _hashCode += getAnchor().hashCode();
        }
        if (getHlinkTemplate() != null) {
            _hashCode += getHlinkTemplate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetNpdDocumentInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", ">GetNpdDocumentInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "PubId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moduleID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "ModuleID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("hlinkTemplate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "HlinkTemplate"));
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
