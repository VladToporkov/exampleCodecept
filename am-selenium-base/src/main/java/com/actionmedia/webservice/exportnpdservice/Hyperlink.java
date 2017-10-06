/**
 * Hyperlink.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.exportnpdservice;

public class Hyperlink  implements java.io.Serializable {
    private java.lang.String id;

    private org.apache.axis.types.UnsignedByte moduleTo;

    private int idTo;

    private java.lang.String anchorTo;

    private java.lang.String title;

    public Hyperlink() {
    }

    public Hyperlink(
           java.lang.String id,
           org.apache.axis.types.UnsignedByte moduleTo,
           int idTo,
           java.lang.String anchorTo,
           java.lang.String title) {
           this.id = id;
           this.moduleTo = moduleTo;
           this.idTo = idTo;
           this.anchorTo = anchorTo;
           this.title = title;
    }


    /**
     * Gets the id value for this Hyperlink.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this Hyperlink.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the moduleTo value for this Hyperlink.
     * 
     * @return moduleTo
     */
    public org.apache.axis.types.UnsignedByte getModuleTo() {
        return moduleTo;
    }


    /**
     * Sets the moduleTo value for this Hyperlink.
     * 
     * @param moduleTo
     */
    public void setModuleTo(org.apache.axis.types.UnsignedByte moduleTo) {
        this.moduleTo = moduleTo;
    }


    /**
     * Gets the idTo value for this Hyperlink.
     * 
     * @return idTo
     */
    public int getIdTo() {
        return idTo;
    }


    /**
     * Sets the idTo value for this Hyperlink.
     * 
     * @param idTo
     */
    public void setIdTo(int idTo) {
        this.idTo = idTo;
    }


    /**
     * Gets the anchorTo value for this Hyperlink.
     * 
     * @return anchorTo
     */
    public java.lang.String getAnchorTo() {
        return anchorTo;
    }


    /**
     * Sets the anchorTo value for this Hyperlink.
     * 
     * @param anchorTo
     */
    public void setAnchorTo(java.lang.String anchorTo) {
        this.anchorTo = anchorTo;
    }


    /**
     * Gets the title value for this Hyperlink.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this Hyperlink.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Hyperlink)) return false;
        Hyperlink other = (Hyperlink) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.moduleTo==null && other.getModuleTo()==null) || 
             (this.moduleTo!=null &&
              this.moduleTo.equals(other.getModuleTo()))) &&
            this.idTo == other.getIdTo() &&
            ((this.anchorTo==null && other.getAnchorTo()==null) || 
             (this.anchorTo!=null &&
              this.anchorTo.equals(other.getAnchorTo()))) &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle())));
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getModuleTo() != null) {
            _hashCode += getModuleTo().hashCode();
        }
        _hashCode += getIdTo();
        if (getAnchorTo() != null) {
            _hashCode += getAnchorTo().hashCode();
        }
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Hyperlink.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "Hyperlink"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "Id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moduleTo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "ModuleTo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "IdTo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anchorTo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "AnchorTo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "Title"));
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
