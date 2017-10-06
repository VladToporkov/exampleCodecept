/**
 * DocumentPartResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.buhonline;

public class DocumentPartResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.buhonline.DocumentPartResponseDocumentPartResult documentPartResult;

    public DocumentPartResponse() {
    }

    public DocumentPartResponse(
           com.actionmedia.webservice.buhonline.DocumentPartResponseDocumentPartResult documentPartResult) {
           this.documentPartResult = documentPartResult;
    }


    /**
     * Gets the documentPartResult value for this DocumentPartResponse.
     * 
     * @return documentPartResult
     */
    public com.actionmedia.webservice.buhonline.DocumentPartResponseDocumentPartResult getDocumentPartResult() {
        return documentPartResult;
    }


    /**
     * Sets the documentPartResult value for this DocumentPartResponse.
     * 
     * @param documentPartResult
     */
    public void setDocumentPartResult(com.actionmedia.webservice.buhonline.DocumentPartResponseDocumentPartResult documentPartResult) {
        this.documentPartResult = documentPartResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocumentPartResponse)) return false;
        DocumentPartResponse other = (DocumentPartResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.documentPartResult==null && other.getDocumentPartResult()==null) || 
             (this.documentPartResult!=null &&
              this.documentPartResult.equals(other.getDocumentPartResult())));
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
        if (getDocumentPartResult() != null) {
            _hashCode += getDocumentPartResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocumentPartResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">DocumentPartResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentPartResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "DocumentPartResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>DocumentPartResponse>DocumentPartResult"));
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
