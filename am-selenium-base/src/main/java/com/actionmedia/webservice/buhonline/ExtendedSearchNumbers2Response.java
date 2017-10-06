/**
 * ExtendedSearchNumbers2Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.buhonline;

public class ExtendedSearchNumbers2Response  implements java.io.Serializable {
    private com.actionmedia.webservice.buhonline.ExtendedSearchNumbers2ResponseExtendedSearchNumbers2Result extendedSearchNumbers2Result;

    public ExtendedSearchNumbers2Response() {
    }

    public ExtendedSearchNumbers2Response(
           com.actionmedia.webservice.buhonline.ExtendedSearchNumbers2ResponseExtendedSearchNumbers2Result extendedSearchNumbers2Result) {
           this.extendedSearchNumbers2Result = extendedSearchNumbers2Result;
    }


    /**
     * Gets the extendedSearchNumbers2Result value for this ExtendedSearchNumbers2Response.
     * 
     * @return extendedSearchNumbers2Result
     */
    public com.actionmedia.webservice.buhonline.ExtendedSearchNumbers2ResponseExtendedSearchNumbers2Result getExtendedSearchNumbers2Result() {
        return extendedSearchNumbers2Result;
    }


    /**
     * Sets the extendedSearchNumbers2Result value for this ExtendedSearchNumbers2Response.
     * 
     * @param extendedSearchNumbers2Result
     */
    public void setExtendedSearchNumbers2Result(com.actionmedia.webservice.buhonline.ExtendedSearchNumbers2ResponseExtendedSearchNumbers2Result extendedSearchNumbers2Result) {
        this.extendedSearchNumbers2Result = extendedSearchNumbers2Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExtendedSearchNumbers2Response)) return false;
        ExtendedSearchNumbers2Response other = (ExtendedSearchNumbers2Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.extendedSearchNumbers2Result==null && other.getExtendedSearchNumbers2Result()==null) || 
             (this.extendedSearchNumbers2Result!=null &&
              this.extendedSearchNumbers2Result.equals(other.getExtendedSearchNumbers2Result())));
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
        if (getExtendedSearchNumbers2Result() != null) {
            _hashCode += getExtendedSearchNumbers2Result().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExtendedSearchNumbers2Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">ExtendedSearchNumbers2Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extendedSearchNumbers2Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "ExtendedSearchNumbers2Result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>ExtendedSearchNumbers2Response>ExtendedSearchNumbers2Result"));
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
