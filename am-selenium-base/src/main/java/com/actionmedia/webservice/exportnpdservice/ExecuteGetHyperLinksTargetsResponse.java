/**
 * ExecuteGetHyperLinksTargetsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.exportnpdservice;

public class ExecuteGetHyperLinksTargetsResponse  extends com.actionmedia.webservice.exportnpdservice.ExecuteResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.exportnpdservice.DocumentLinkTargetItem[] linkTargets;

    public ExecuteGetHyperLinksTargetsResponse() {
    }

    public ExecuteGetHyperLinksTargetsResponse(
           long durationInMSec,
           com.actionmedia.webservice.exportnpdservice.DocumentLinkTargetItem[] linkTargets) {
        super(
            durationInMSec);
        this.linkTargets = linkTargets;
    }


    /**
     * Gets the linkTargets value for this ExecuteGetHyperLinksTargetsResponse.
     * 
     * @return linkTargets
     */
    public com.actionmedia.webservice.exportnpdservice.DocumentLinkTargetItem[] getLinkTargets() {
        return linkTargets;
    }


    /**
     * Sets the linkTargets value for this ExecuteGetHyperLinksTargetsResponse.
     * 
     * @param linkTargets
     */
    public void setLinkTargets(com.actionmedia.webservice.exportnpdservice.DocumentLinkTargetItem[] linkTargets) {
        this.linkTargets = linkTargets;
    }

    public com.actionmedia.webservice.exportnpdservice.DocumentLinkTargetItem getLinkTargets(int i) {
        return this.linkTargets[i];
    }

    public void setLinkTargets(int i, com.actionmedia.webservice.exportnpdservice.DocumentLinkTargetItem _value) {
        this.linkTargets[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExecuteGetHyperLinksTargetsResponse)) return false;
        ExecuteGetHyperLinksTargetsResponse other = (ExecuteGetHyperLinksTargetsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.linkTargets==null && other.getLinkTargets()==null) || 
             (this.linkTargets!=null &&
              java.util.Arrays.equals(this.linkTargets, other.getLinkTargets())));
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
        if (getLinkTargets() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLinkTargets());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLinkTargets(), i);
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
        new org.apache.axis.description.TypeDesc(ExecuteGetHyperLinksTargetsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetHyperLinksTargetsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("linkTargets");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "LinkTargets"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "DocumentLinkTargetItem"));
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
