/**
 * GetHyperlinksTargets.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.exportnpdservice;

public class GetHyperlinksTargets  implements java.io.Serializable {
    private java.lang.String[] linkGuids;

    public GetHyperlinksTargets() {
    }

    public GetHyperlinksTargets(
           java.lang.String[] linkGuids) {
           this.linkGuids = linkGuids;
    }


    /**
     * Gets the linkGuids value for this GetHyperlinksTargets.
     * 
     * @return linkGuids
     */
    public java.lang.String[] getLinkGuids() {
        return linkGuids;
    }


    /**
     * Sets the linkGuids value for this GetHyperlinksTargets.
     * 
     * @param linkGuids
     */
    public void setLinkGuids(java.lang.String[] linkGuids) {
        this.linkGuids = linkGuids;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetHyperlinksTargets)) return false;
        GetHyperlinksTargets other = (GetHyperlinksTargets) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.linkGuids==null && other.getLinkGuids()==null) || 
             (this.linkGuids!=null &&
              java.util.Arrays.equals(this.linkGuids, other.getLinkGuids())));
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
        if (getLinkGuids() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLinkGuids());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLinkGuids(), i);
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
        new org.apache.axis.description.TypeDesc(GetHyperlinksTargets.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", ">GetHyperlinksTargets"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("linkGuids");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "LinkGuids"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://microsoft.com/wsdl/types/", "guid"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.1gl.ru/", "guid"));
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
