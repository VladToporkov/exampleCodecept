/**
 * ExecuteGetDocumentPartByIdResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.exportnpdservice;

public class ExecuteGetDocumentPartByIdResponse  extends com.actionmedia.webservice.exportnpdservice.ExecuteResponse  implements java.io.Serializable {
    private boolean docExists;

    private boolean docPartExists;

    private java.lang.String content;

    private boolean isExternalContent;

    public ExecuteGetDocumentPartByIdResponse() {
    }

    public ExecuteGetDocumentPartByIdResponse(
           long durationInMSec,
           boolean docExists,
           boolean docPartExists,
           java.lang.String content,
           boolean isExternalContent) {
        super(
            durationInMSec);
        this.docExists = docExists;
        this.docPartExists = docPartExists;
        this.content = content;
        this.isExternalContent = isExternalContent;
    }


    /**
     * Gets the docExists value for this ExecuteGetDocumentPartByIdResponse.
     * 
     * @return docExists
     */
    public boolean isDocExists() {
        return docExists;
    }


    /**
     * Sets the docExists value for this ExecuteGetDocumentPartByIdResponse.
     * 
     * @param docExists
     */
    public void setDocExists(boolean docExists) {
        this.docExists = docExists;
    }


    /**
     * Gets the docPartExists value for this ExecuteGetDocumentPartByIdResponse.
     * 
     * @return docPartExists
     */
    public boolean isDocPartExists() {
        return docPartExists;
    }


    /**
     * Sets the docPartExists value for this ExecuteGetDocumentPartByIdResponse.
     * 
     * @param docPartExists
     */
    public void setDocPartExists(boolean docPartExists) {
        this.docPartExists = docPartExists;
    }


    /**
     * Gets the content value for this ExecuteGetDocumentPartByIdResponse.
     * 
     * @return content
     */
    public java.lang.String getContent() {
        return content;
    }


    /**
     * Sets the content value for this ExecuteGetDocumentPartByIdResponse.
     * 
     * @param content
     */
    public void setContent(java.lang.String content) {
        this.content = content;
    }


    /**
     * Gets the isExternalContent value for this ExecuteGetDocumentPartByIdResponse.
     * 
     * @return isExternalContent
     */
    public boolean isIsExternalContent() {
        return isExternalContent;
    }


    /**
     * Sets the isExternalContent value for this ExecuteGetDocumentPartByIdResponse.
     * 
     * @param isExternalContent
     */
    public void setIsExternalContent(boolean isExternalContent) {
        this.isExternalContent = isExternalContent;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExecuteGetDocumentPartByIdResponse)) return false;
        ExecuteGetDocumentPartByIdResponse other = (ExecuteGetDocumentPartByIdResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.docExists == other.isDocExists() &&
            this.docPartExists == other.isDocPartExists() &&
            ((this.content==null && other.getContent()==null) || 
             (this.content!=null &&
              this.content.equals(other.getContent()))) &&
            this.isExternalContent == other.isIsExternalContent();
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
        _hashCode += (isDocExists() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isDocPartExists() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getContent() != null) {
            _hashCode += getContent().hashCode();
        }
        _hashCode += (isIsExternalContent() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExecuteGetDocumentPartByIdResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetDocumentPartByIdResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docExists");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "DocExists"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docPartExists");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "DocPartExists"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("content");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "Content"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isExternalContent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "IsExternalContent"));
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
