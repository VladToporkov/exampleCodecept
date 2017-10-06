/**
 * ExecuteGetAnchorsToPartsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.exportnpdservice;

public class ExecuteGetAnchorsToPartsResponse  extends com.actionmedia.webservice.exportnpdservice.ExecuteResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.exportnpdservice.AnchorsToParts[] anchorsToPartsList;

    public ExecuteGetAnchorsToPartsResponse() {
    }

    public ExecuteGetAnchorsToPartsResponse(
           long durationInMSec,
           com.actionmedia.webservice.exportnpdservice.AnchorsToParts[] anchorsToPartsList) {
        super(
            durationInMSec);
        this.anchorsToPartsList = anchorsToPartsList;
    }


    /**
     * Gets the anchorsToPartsList value for this ExecuteGetAnchorsToPartsResponse.
     * 
     * @return anchorsToPartsList
     */
    public com.actionmedia.webservice.exportnpdservice.AnchorsToParts[] getAnchorsToPartsList() {
        return anchorsToPartsList;
    }


    /**
     * Sets the anchorsToPartsList value for this ExecuteGetAnchorsToPartsResponse.
     * 
     * @param anchorsToPartsList
     */
    public void setAnchorsToPartsList(com.actionmedia.webservice.exportnpdservice.AnchorsToParts[] anchorsToPartsList) {
        this.anchorsToPartsList = anchorsToPartsList;
    }

    public com.actionmedia.webservice.exportnpdservice.AnchorsToParts getAnchorsToPartsList(int i) {
        return this.anchorsToPartsList[i];
    }

    public void setAnchorsToPartsList(int i, com.actionmedia.webservice.exportnpdservice.AnchorsToParts _value) {
        this.anchorsToPartsList[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExecuteGetAnchorsToPartsResponse)) return false;
        ExecuteGetAnchorsToPartsResponse other = (ExecuteGetAnchorsToPartsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.anchorsToPartsList==null && other.getAnchorsToPartsList()==null) || 
             (this.anchorsToPartsList!=null &&
              java.util.Arrays.equals(this.anchorsToPartsList, other.getAnchorsToPartsList())));
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
        if (getAnchorsToPartsList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAnchorsToPartsList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAnchorsToPartsList(), i);
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
        new org.apache.axis.description.TypeDesc(ExecuteGetAnchorsToPartsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetAnchorsToPartsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anchorsToPartsList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "AnchorsToPartsList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "AnchorsToParts"));
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
