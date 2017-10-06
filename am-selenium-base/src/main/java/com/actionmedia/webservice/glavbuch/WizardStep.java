/**
 * WizardStep.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.glavbuch;

public class WizardStep  implements java.io.Serializable {
    private org.apache.axis.types.UnsignedByte modId;

    private int docId;

    private java.lang.String answersCSV;

    public WizardStep() {
    }

    public WizardStep(
           org.apache.axis.types.UnsignedByte modId,
           int docId,
           java.lang.String answersCSV) {
           this.modId = modId;
           this.docId = docId;
           this.answersCSV = answersCSV;
    }


    /**
     * Gets the modId value for this WizardStep.
     * 
     * @return modId
     */
    public org.apache.axis.types.UnsignedByte getModId() {
        return modId;
    }


    /**
     * Sets the modId value for this WizardStep.
     * 
     * @param modId
     */
    public void setModId(org.apache.axis.types.UnsignedByte modId) {
        this.modId = modId;
    }


    /**
     * Gets the docId value for this WizardStep.
     * 
     * @return docId
     */
    public int getDocId() {
        return docId;
    }


    /**
     * Sets the docId value for this WizardStep.
     * 
     * @param docId
     */
    public void setDocId(int docId) {
        this.docId = docId;
    }


    /**
     * Gets the answersCSV value for this WizardStep.
     * 
     * @return answersCSV
     */
    public java.lang.String getAnswersCSV() {
        return answersCSV;
    }


    /**
     * Sets the answersCSV value for this WizardStep.
     * 
     * @param answersCSV
     */
    public void setAnswersCSV(java.lang.String answersCSV) {
        this.answersCSV = answersCSV;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WizardStep)) return false;
        WizardStep other = (WizardStep) obj;
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
            ((this.answersCSV==null && other.getAnswersCSV()==null) || 
             (this.answersCSV!=null &&
              this.answersCSV.equals(other.getAnswersCSV())));
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
        if (getAnswersCSV() != null) {
            _hashCode += getAnswersCSV().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WizardStep.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">WizardStep"));
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
        elemField.setFieldName("answersCSV");
        elemField.setXmlName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "AnswersCSV"));
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
