/**
 * AttachmentRow.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.exportnpdservice;

public class AttachmentRow  implements java.io.Serializable {
    private java.lang.String artName;

    private java.lang.String artUrl;

    private org.apache.axis.types.UnsignedByte moduleID;

    private int ID;

    private java.lang.String mimeType;

    private java.lang.String formNumber;

    private java.lang.String OKUD;

    private java.lang.String KND;

    public AttachmentRow() {
    }

    public AttachmentRow(
           java.lang.String artName,
           java.lang.String artUrl,
           org.apache.axis.types.UnsignedByte moduleID,
           int ID,
           java.lang.String mimeType,
           java.lang.String formNumber,
           java.lang.String OKUD,
           java.lang.String KND) {
           this.artName = artName;
           this.artUrl = artUrl;
           this.moduleID = moduleID;
           this.ID = ID;
           this.mimeType = mimeType;
           this.formNumber = formNumber;
           this.OKUD = OKUD;
           this.KND = KND;
    }


    /**
     * Gets the artName value for this AttachmentRow.
     * 
     * @return artName
     */
    public java.lang.String getArtName() {
        return artName;
    }


    /**
     * Sets the artName value for this AttachmentRow.
     * 
     * @param artName
     */
    public void setArtName(java.lang.String artName) {
        this.artName = artName;
    }


    /**
     * Gets the artUrl value for this AttachmentRow.
     * 
     * @return artUrl
     */
    public java.lang.String getArtUrl() {
        return artUrl;
    }


    /**
     * Sets the artUrl value for this AttachmentRow.
     * 
     * @param artUrl
     */
    public void setArtUrl(java.lang.String artUrl) {
        this.artUrl = artUrl;
    }


    /**
     * Gets the moduleID value for this AttachmentRow.
     * 
     * @return moduleID
     */
    public org.apache.axis.types.UnsignedByte getModuleID() {
        return moduleID;
    }


    /**
     * Sets the moduleID value for this AttachmentRow.
     * 
     * @param moduleID
     */
    public void setModuleID(org.apache.axis.types.UnsignedByte moduleID) {
        this.moduleID = moduleID;
    }


    /**
     * Gets the ID value for this AttachmentRow.
     * 
     * @return ID
     */
    public int getID() {
        return ID;
    }


    /**
     * Sets the ID value for this AttachmentRow.
     * 
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }


    /**
     * Gets the mimeType value for this AttachmentRow.
     * 
     * @return mimeType
     */
    public java.lang.String getMimeType() {
        return mimeType;
    }


    /**
     * Sets the mimeType value for this AttachmentRow.
     * 
     * @param mimeType
     */
    public void setMimeType(java.lang.String mimeType) {
        this.mimeType = mimeType;
    }


    /**
     * Gets the formNumber value for this AttachmentRow.
     * 
     * @return formNumber
     */
    public java.lang.String getFormNumber() {
        return formNumber;
    }


    /**
     * Sets the formNumber value for this AttachmentRow.
     * 
     * @param formNumber
     */
    public void setFormNumber(java.lang.String formNumber) {
        this.formNumber = formNumber;
    }


    /**
     * Gets the OKUD value for this AttachmentRow.
     * 
     * @return OKUD
     */
    public java.lang.String getOKUD() {
        return OKUD;
    }


    /**
     * Sets the OKUD value for this AttachmentRow.
     * 
     * @param OKUD
     */
    public void setOKUD(java.lang.String OKUD) {
        this.OKUD = OKUD;
    }


    /**
     * Gets the KND value for this AttachmentRow.
     * 
     * @return KND
     */
    public java.lang.String getKND() {
        return KND;
    }


    /**
     * Sets the KND value for this AttachmentRow.
     * 
     * @param KND
     */
    public void setKND(java.lang.String KND) {
        this.KND = KND;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AttachmentRow)) return false;
        AttachmentRow other = (AttachmentRow) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.artName==null && other.getArtName()==null) || 
             (this.artName!=null &&
              this.artName.equals(other.getArtName()))) &&
            ((this.artUrl==null && other.getArtUrl()==null) || 
             (this.artUrl!=null &&
              this.artUrl.equals(other.getArtUrl()))) &&
            ((this.moduleID==null && other.getModuleID()==null) || 
             (this.moduleID!=null &&
              this.moduleID.equals(other.getModuleID()))) &&
            this.ID == other.getID() &&
            ((this.mimeType==null && other.getMimeType()==null) || 
             (this.mimeType!=null &&
              this.mimeType.equals(other.getMimeType()))) &&
            ((this.formNumber==null && other.getFormNumber()==null) || 
             (this.formNumber!=null &&
              this.formNumber.equals(other.getFormNumber()))) &&
            ((this.OKUD==null && other.getOKUD()==null) || 
             (this.OKUD!=null &&
              this.OKUD.equals(other.getOKUD()))) &&
            ((this.KND==null && other.getKND()==null) || 
             (this.KND!=null &&
              this.KND.equals(other.getKND())));
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
        if (getArtName() != null) {
            _hashCode += getArtName().hashCode();
        }
        if (getArtUrl() != null) {
            _hashCode += getArtUrl().hashCode();
        }
        if (getModuleID() != null) {
            _hashCode += getModuleID().hashCode();
        }
        _hashCode += getID();
        if (getMimeType() != null) {
            _hashCode += getMimeType().hashCode();
        }
        if (getFormNumber() != null) {
            _hashCode += getFormNumber().hashCode();
        }
        if (getOKUD() != null) {
            _hashCode += getOKUD().hashCode();
        }
        if (getKND() != null) {
            _hashCode += getKND().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AttachmentRow.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "AttachmentRow"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("artName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "ArtName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("artUrl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "ArtUrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("mimeType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "MimeType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "FormNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("OKUD");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "OKUD"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("KND");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "KND"));
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
