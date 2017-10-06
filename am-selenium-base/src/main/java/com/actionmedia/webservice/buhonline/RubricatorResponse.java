/**
 * RubricatorResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.buhonline;

public class RubricatorResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.buhonline.RubricatorResponseRubricatorResult rubricatorResult;

    public RubricatorResponse() {
    }

    public RubricatorResponse(
           com.actionmedia.webservice.buhonline.RubricatorResponseRubricatorResult rubricatorResult) {
           this.rubricatorResult = rubricatorResult;
    }


    /**
     * Gets the rubricatorResult value for this RubricatorResponse.
     * 
     * @return rubricatorResult
     */
    public com.actionmedia.webservice.buhonline.RubricatorResponseRubricatorResult getRubricatorResult() {
        return rubricatorResult;
    }


    /**
     * Sets the rubricatorResult value for this RubricatorResponse.
     * 
     * @param rubricatorResult
     */
    public void setRubricatorResult(com.actionmedia.webservice.buhonline.RubricatorResponseRubricatorResult rubricatorResult) {
        this.rubricatorResult = rubricatorResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RubricatorResponse)) return false;
        RubricatorResponse other = (RubricatorResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.rubricatorResult==null && other.getRubricatorResult()==null) || 
             (this.rubricatorResult!=null &&
              this.rubricatorResult.equals(other.getRubricatorResult())));
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
        if (getRubricatorResult() != null) {
            _hashCode += getRubricatorResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RubricatorResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">RubricatorResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rubricatorResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "RubricatorResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>RubricatorResponse>RubricatorResult"));
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
