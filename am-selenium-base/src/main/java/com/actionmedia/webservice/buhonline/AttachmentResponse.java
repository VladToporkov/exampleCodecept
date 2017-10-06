/**
 * AttachmentResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.buhonline;

public class AttachmentResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.buhonline.AttachmentResponseAttachmentResult attachmentResult;

    public AttachmentResponse() {
    }

    public AttachmentResponse(
           com.actionmedia.webservice.buhonline.AttachmentResponseAttachmentResult attachmentResult) {
           this.attachmentResult = attachmentResult;
    }


    /**
     * Gets the attachmentResult value for this AttachmentResponse.
     * 
     * @return attachmentResult
     */
    public com.actionmedia.webservice.buhonline.AttachmentResponseAttachmentResult getAttachmentResult() {
        return attachmentResult;
    }


    /**
     * Sets the attachmentResult value for this AttachmentResponse.
     * 
     * @param attachmentResult
     */
    public void setAttachmentResult(com.actionmedia.webservice.buhonline.AttachmentResponseAttachmentResult attachmentResult) {
        this.attachmentResult = attachmentResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AttachmentResponse)) return false;
        AttachmentResponse other = (AttachmentResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.attachmentResult==null && other.getAttachmentResult()==null) || 
             (this.attachmentResult!=null &&
              this.attachmentResult.equals(other.getAttachmentResult())));
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
        if (getAttachmentResult() != null) {
            _hashCode += getAttachmentResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AttachmentResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">AttachmentResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attachmentResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "AttachmentResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>AttachmentResponse>AttachmentResult"));
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
