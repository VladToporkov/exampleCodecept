/**
 * DocAnnounce.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.exportnpdservice;

public class DocAnnounce  extends com.actionmedia.webservice.exportnpdservice.DocSpecification  implements java.io.Serializable {
    private java.util.Calendar announceDate;

    private java.lang.String announceTitle;

    private java.lang.String announceSnippet;

    private java.lang.String announceAnchor;

    public DocAnnounce() {
    }

    public DocAnnounce(
           org.apache.axis.types.UnsignedByte moduleID,
           int ID,
           java.util.Calendar announceDate,
           java.lang.String announceTitle,
           java.lang.String announceSnippet,
           java.lang.String announceAnchor) {
        super(
            moduleID,
            ID);
        this.announceDate = announceDate;
        this.announceTitle = announceTitle;
        this.announceSnippet = announceSnippet;
        this.announceAnchor = announceAnchor;
    }


    /**
     * Gets the announceDate value for this DocAnnounce.
     * 
     * @return announceDate
     */
    public java.util.Calendar getAnnounceDate() {
        return announceDate;
    }


    /**
     * Sets the announceDate value for this DocAnnounce.
     * 
     * @param announceDate
     */
    public void setAnnounceDate(java.util.Calendar announceDate) {
        this.announceDate = announceDate;
    }


    /**
     * Gets the announceTitle value for this DocAnnounce.
     * 
     * @return announceTitle
     */
    public java.lang.String getAnnounceTitle() {
        return announceTitle;
    }


    /**
     * Sets the announceTitle value for this DocAnnounce.
     * 
     * @param announceTitle
     */
    public void setAnnounceTitle(java.lang.String announceTitle) {
        this.announceTitle = announceTitle;
    }


    /**
     * Gets the announceSnippet value for this DocAnnounce.
     * 
     * @return announceSnippet
     */
    public java.lang.String getAnnounceSnippet() {
        return announceSnippet;
    }


    /**
     * Sets the announceSnippet value for this DocAnnounce.
     * 
     * @param announceSnippet
     */
    public void setAnnounceSnippet(java.lang.String announceSnippet) {
        this.announceSnippet = announceSnippet;
    }


    /**
     * Gets the announceAnchor value for this DocAnnounce.
     * 
     * @return announceAnchor
     */
    public java.lang.String getAnnounceAnchor() {
        return announceAnchor;
    }


    /**
     * Sets the announceAnchor value for this DocAnnounce.
     * 
     * @param announceAnchor
     */
    public void setAnnounceAnchor(java.lang.String announceAnchor) {
        this.announceAnchor = announceAnchor;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocAnnounce)) return false;
        DocAnnounce other = (DocAnnounce) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.announceDate==null && other.getAnnounceDate()==null) || 
             (this.announceDate!=null &&
              this.announceDate.equals(other.getAnnounceDate()))) &&
            ((this.announceTitle==null && other.getAnnounceTitle()==null) || 
             (this.announceTitle!=null &&
              this.announceTitle.equals(other.getAnnounceTitle()))) &&
            ((this.announceSnippet==null && other.getAnnounceSnippet()==null) || 
             (this.announceSnippet!=null &&
              this.announceSnippet.equals(other.getAnnounceSnippet()))) &&
            ((this.announceAnchor==null && other.getAnnounceAnchor()==null) || 
             (this.announceAnchor!=null &&
              this.announceAnchor.equals(other.getAnnounceAnchor())));
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
        if (getAnnounceDate() != null) {
            _hashCode += getAnnounceDate().hashCode();
        }
        if (getAnnounceTitle() != null) {
            _hashCode += getAnnounceTitle().hashCode();
        }
        if (getAnnounceSnippet() != null) {
            _hashCode += getAnnounceSnippet().hashCode();
        }
        if (getAnnounceAnchor() != null) {
            _hashCode += getAnnounceAnchor().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocAnnounce.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "DocAnnounce"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("announceDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "AnnounceDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("announceTitle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "AnnounceTitle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("announceSnippet");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "AnnounceSnippet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("announceAnchor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "AnnounceAnchor"));
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