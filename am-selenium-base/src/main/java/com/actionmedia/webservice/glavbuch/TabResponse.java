/**
 * TabResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.glavbuch;

public class TabResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.glavbuch.TabResponseTabResult tabResult;

    public TabResponse() {
    }

    public TabResponse(
           com.actionmedia.webservice.glavbuch.TabResponseTabResult tabResult) {
           this.tabResult = tabResult;
    }


    /**
     * Gets the tabResult value for this TabResponse.
     * 
     * @return tabResult
     */
    public com.actionmedia.webservice.glavbuch.TabResponseTabResult getTabResult() {
        return tabResult;
    }


    /**
     * Sets the tabResult value for this TabResponse.
     * 
     * @param tabResult
     */
    public void setTabResult(com.actionmedia.webservice.glavbuch.TabResponseTabResult tabResult) {
        this.tabResult = tabResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TabResponse)) return false;
        TabResponse other = (TabResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.tabResult==null && other.getTabResult()==null) || 
             (this.tabResult!=null &&
              this.tabResult.equals(other.getTabResult())));
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
        if (getTabResult() != null) {
            _hashCode += getTabResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TabResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">TabResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tabResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "TabResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">>TabResponse>TabResult"));
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
