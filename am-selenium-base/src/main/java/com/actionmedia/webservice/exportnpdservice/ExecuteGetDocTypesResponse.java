/**
 * ExecuteGetDocTypesResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.exportnpdservice;

public class ExecuteGetDocTypesResponse  extends com.actionmedia.webservice.exportnpdservice.ExecuteResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.exportnpdservice.DocumentType[] docType;

    public ExecuteGetDocTypesResponse() {
    }

    public ExecuteGetDocTypesResponse(
           long durationInMSec,
           com.actionmedia.webservice.exportnpdservice.DocumentType[] docType) {
        super(
            durationInMSec);
        this.docType = docType;
    }


    /**
     * Gets the docType value for this ExecuteGetDocTypesResponse.
     * 
     * @return docType
     */
    public com.actionmedia.webservice.exportnpdservice.DocumentType[] getDocType() {
        return docType;
    }


    /**
     * Sets the docType value for this ExecuteGetDocTypesResponse.
     * 
     * @param docType
     */
    public void setDocType(com.actionmedia.webservice.exportnpdservice.DocumentType[] docType) {
        this.docType = docType;
    }

    public com.actionmedia.webservice.exportnpdservice.DocumentType getDocType(int i) {
        return this.docType[i];
    }

    public void setDocType(int i, com.actionmedia.webservice.exportnpdservice.DocumentType _value) {
        this.docType[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExecuteGetDocTypesResponse)) return false;
        ExecuteGetDocTypesResponse other = (ExecuteGetDocTypesResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.docType==null && other.getDocType()==null) || 
             (this.docType!=null &&
              java.util.Arrays.equals(this.docType, other.getDocType())));
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
        if (getDocType() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDocType());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDocType(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExecuteGetDocTypesResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetDocTypesResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "DocType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "DocumentType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
