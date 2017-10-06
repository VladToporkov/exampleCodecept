/**
 * Attachment.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.exportnpdservice;

public class Attachment  implements java.io.Serializable {
    private int id;

    private java.lang.String name;

    private java.lang.String mimeType;

    private java.lang.String formNumber;

    private java.lang.String okud;

    private java.lang.String knd;

    public Attachment() {
    }

    public Attachment(
           int id,
           java.lang.String name,
           java.lang.String mimeType,
           java.lang.String formNumber,
           java.lang.String okud,
           java.lang.String knd) {
           this.id = id;
           this.name = name;
           this.mimeType = mimeType;
           this.formNumber = formNumber;
           this.okud = okud;
           this.knd = knd;
    }


    /**
     * Gets the id value for this Attachment.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this Attachment.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the name value for this Attachment.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Attachment.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the mimeType value for this Attachment.
     * 
     * @return mimeType
     */
    public java.lang.String getMimeType() {
        return mimeType;
    }


    /**
     * Sets the mimeType value for this Attachment.
     * 
     * @param mimeType
     */
    public void setMimeType(java.lang.String mimeType) {
        this.mimeType = mimeType;
    }


    /**
     * Gets the formNumber value for this Attachment.
     * 
     * @return formNumber
     */
    public java.lang.String getFormNumber() {
        return formNumber;
    }


    /**
     * Sets the formNumber value for this Attachment.
     * 
     * @param formNumber
     */
    public void setFormNumber(java.lang.String formNumber) {
        this.formNumber = formNumber;
    }


    /**
     * Gets the okud value for this Attachment.
     * 
     * @return okud
     */
    public java.lang.String getOkud() {
        return okud;
    }


    /**
     * Sets the okud value for this Attachment.
     * 
     * @param okud
     */
    public void setOkud(java.lang.String okud) {
        this.okud = okud;
    }


    /**
     * Gets the knd value for this Attachment.
     * 
     * @return knd
     */
    public java.lang.String getKnd() {
        return knd;
    }


    /**
     * Sets the knd value for this Attachment.
     * 
     * @param knd
     */
    public void setKnd(java.lang.String knd) {
        this.knd = knd;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Attachment)) return false;
        Attachment other = (Attachment) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.id == other.getId() &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.mimeType==null && other.getMimeType()==null) || 
             (this.mimeType!=null &&
              this.mimeType.equals(other.getMimeType()))) &&
            ((this.formNumber==null && other.getFormNumber()==null) || 
             (this.formNumber!=null &&
              this.formNumber.equals(other.getFormNumber()))) &&
            ((this.okud==null && other.getOkud()==null) || 
             (this.okud!=null &&
              this.okud.equals(other.getOkud()))) &&
            ((this.knd==null && other.getKnd()==null) || 
             (this.knd!=null &&
              this.knd.equals(other.getKnd())));
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
        _hashCode += getId();
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getMimeType() != null) {
            _hashCode += getMimeType().hashCode();
        }
        if (getFormNumber() != null) {
            _hashCode += getFormNumber().hashCode();
        }
        if (getOkud() != null) {
            _hashCode += getOkud().hashCode();
        }
        if (getKnd() != null) {
            _hashCode += getKnd().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Attachment.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "Attachment"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "Id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "Name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("okud");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "Okud"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("knd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "Knd"));
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
