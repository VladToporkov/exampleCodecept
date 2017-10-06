/**
 * Numbers2Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchextendedservice;

public class Numbers2Response  implements java.io.Serializable {
    private com.actionmedia.webservice.searchextendedservice.Numbers2ResponseNumbers2Result numbers2Result;

    public Numbers2Response() {
    }

    public Numbers2Response(
           com.actionmedia.webservice.searchextendedservice.Numbers2ResponseNumbers2Result numbers2Result) {
           this.numbers2Result = numbers2Result;
    }


    /**
     * Gets the numbers2Result value for this Numbers2Response.
     * 
     * @return numbers2Result
     */
    public com.actionmedia.webservice.searchextendedservice.Numbers2ResponseNumbers2Result getNumbers2Result() {
        return numbers2Result;
    }


    /**
     * Sets the numbers2Result value for this Numbers2Response.
     * 
     * @param numbers2Result
     */
    public void setNumbers2Result(com.actionmedia.webservice.searchextendedservice.Numbers2ResponseNumbers2Result numbers2Result) {
        this.numbers2Result = numbers2Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Numbers2Response)) return false;
        Numbers2Response other = (Numbers2Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.numbers2Result==null && other.getNumbers2Result()==null) || 
             (this.numbers2Result!=null &&
              this.numbers2Result.equals(other.getNumbers2Result())));
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
        if (getNumbers2Result() != null) {
            _hashCode += getNumbers2Result().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Numbers2Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">Numbers2Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numbers2Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "Numbers2Result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">>Numbers2Response>Numbers2Result"));
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
