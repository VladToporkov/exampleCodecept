/**
 * DocumentResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.buhonline;

public class DocumentResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.buhonline.DocumentResponseDocumentResult documentResult;

    public DocumentResponse() {
    }

    public DocumentResponse(
           com.actionmedia.webservice.buhonline.DocumentResponseDocumentResult documentResult) {
           this.documentResult = documentResult;
    }


    /**
     * Gets the documentResult value for this DocumentResponse.
     * 
     * @return documentResult
     */
    public com.actionmedia.webservice.buhonline.DocumentResponseDocumentResult getDocumentResult() {
        return documentResult;
    }


    /**
     * Sets the documentResult value for this DocumentResponse.
     * 
     * @param documentResult
     */
    public void setDocumentResult(com.actionmedia.webservice.buhonline.DocumentResponseDocumentResult documentResult) {
        this.documentResult = documentResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocumentResponse)) return false;
        DocumentResponse other = (DocumentResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.documentResult==null && other.getDocumentResult()==null) || 
             (this.documentResult!=null &&
              this.documentResult.equals(other.getDocumentResult())));
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
        if (getDocumentResult() != null) {
            _hashCode += getDocumentResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocumentResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">DocumentResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "DocumentResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>DocumentResponse>DocumentResult"));
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
