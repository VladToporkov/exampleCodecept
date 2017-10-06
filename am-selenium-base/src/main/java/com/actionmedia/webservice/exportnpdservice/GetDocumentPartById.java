/**
 * GetDocumentPartById.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.exportnpdservice;

public class GetDocumentPartById  implements java.io.Serializable {
    private org.apache.axis.types.UnsignedByte moduleID;

    private int ID;

    private int partID;

    private java.lang.String hlinkTemplate;

    public GetDocumentPartById() {
    }

    public GetDocumentPartById(
           org.apache.axis.types.UnsignedByte moduleID,
           int ID,
           int partID,
           java.lang.String hlinkTemplate) {
           this.moduleID = moduleID;
           this.ID = ID;
           this.partID = partID;
           this.hlinkTemplate = hlinkTemplate;
    }


    /**
     * Gets the moduleID value for this GetDocumentPartById.
     * 
     * @return moduleID
     */
    public org.apache.axis.types.UnsignedByte getModuleID() {
        return moduleID;
    }


    /**
     * Sets the moduleID value for this GetDocumentPartById.
     * 
     * @param moduleID
     */
    public void setModuleID(org.apache.axis.types.UnsignedByte moduleID) {
        this.moduleID = moduleID;
    }


    /**
     * Gets the ID value for this GetDocumentPartById.
     * 
     * @return ID
     */
    public int getID() {
        return ID;
    }


    /**
     * Sets the ID value for this GetDocumentPartById.
     * 
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }


    /**
     * Gets the partID value for this GetDocumentPartById.
     * 
     * @return partID
     */
    public int getPartID() {
        return partID;
    }


    /**
     * Sets the partID value for this GetDocumentPartById.
     * 
     * @param partID
     */
    public void setPartID(int partID) {
        this.partID = partID;
    }


    /**
     * Gets the hlinkTemplate value for this GetDocumentPartById.
     * 
     * @return hlinkTemplate
     */
    public java.lang.String getHlinkTemplate() {
        return hlinkTemplate;
    }


    /**
     * Sets the hlinkTemplate value for this GetDocumentPartById.
     * 
     * @param hlinkTemplate
     */
    public void setHlinkTemplate(java.lang.String hlinkTemplate) {
        this.hlinkTemplate = hlinkTemplate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetDocumentPartById)) return false;
        GetDocumentPartById other = (GetDocumentPartById) obj;
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
            this.partID == other.getPartID() &&
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
        if (getModuleID() != null) {
            _hashCode += getModuleID().hashCode();
        }
        _hashCode += getID();
        _hashCode += getPartID();
        if (getHlinkTemplate() != null) {
            _hashCode += getHlinkTemplate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetDocumentPartById.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", ">GetDocumentPartById"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("partID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "PartID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
