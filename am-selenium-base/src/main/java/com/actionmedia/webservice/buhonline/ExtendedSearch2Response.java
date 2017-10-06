/**
 * ExtendedSearch2Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.buhonline;

public class ExtendedSearch2Response  implements java.io.Serializable {
    private com.actionmedia.webservice.buhonline.ExtendedSearch2ResponseExtendedSearch2Result extendedSearch2Result;

    public ExtendedSearch2Response() {
    }

    public ExtendedSearch2Response(
           com.actionmedia.webservice.buhonline.ExtendedSearch2ResponseExtendedSearch2Result extendedSearch2Result) {
           this.extendedSearch2Result = extendedSearch2Result;
    }


    /**
     * Gets the extendedSearch2Result value for this ExtendedSearch2Response.
     * 
     * @return extendedSearch2Result
     */
    public com.actionmedia.webservice.buhonline.ExtendedSearch2ResponseExtendedSearch2Result getExtendedSearch2Result() {
        return extendedSearch2Result;
    }


    /**
     * Sets the extendedSearch2Result value for this ExtendedSearch2Response.
     * 
     * @param extendedSearch2Result
     */
    public void setExtendedSearch2Result(com.actionmedia.webservice.buhonline.ExtendedSearch2ResponseExtendedSearch2Result extendedSearch2Result) {
        this.extendedSearch2Result = extendedSearch2Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExtendedSearch2Response)) return false;
        ExtendedSearch2Response other = (ExtendedSearch2Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.extendedSearch2Result==null && other.getExtendedSearch2Result()==null) || 
             (this.extendedSearch2Result!=null &&
              this.extendedSearch2Result.equals(other.getExtendedSearch2Result())));
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
        if (getExtendedSearch2Result() != null) {
            _hashCode += getExtendedSearch2Result().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExtendedSearch2Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">ExtendedSearch2Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extendedSearch2Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "ExtendedSearch2Result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>ExtendedSearch2Response>ExtendedSearch2Result"));
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
