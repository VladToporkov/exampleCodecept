/**
 * DropEventResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.eventservice;

public class DropEventResponse implements java.io.Serializable {

    private DropEventResponseDropEventResult dropEventResult;

    public DropEventResponse() {
    }

    public DropEventResponse(
            DropEventResponseDropEventResult dropEventResult) {
        this.dropEventResult = dropEventResult;
    }

    /**
     * Gets the dropEventResult value for this DropEventResponse.
     *
     * @return dropEventResult
     */
    public DropEventResponseDropEventResult getDropEventResult() {
        return dropEventResult;
    }

    /**
     * Sets the dropEventResult value for this DropEventResponse.
     *
     * @param dropEventResult
     */
    public void setDropEventResult(DropEventResponseDropEventResult dropEventResult) {
        this.dropEventResult = dropEventResult;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(DropEventResponse.class, true);

    static {

        typeDesc.setXmlType(new javax.xml.namespace.QName("http://action-media.ru/", ">DropEventResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dropEventResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://action-media.ru/", "DropEventResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://action-media.ru/", ">>DropEventResponse>DropEventResult"));
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
                new org.apache.axis.encoding.ser.BeanSerializer(
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
                new org.apache.axis.encoding.ser.BeanDeserializer(
                        _javaType, _xmlType, typeDesc);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DropEventResponse that = (DropEventResponse) o;

        return !(dropEventResult != null ? !dropEventResult.equals(that.dropEventResult) : that.dropEventResult != null);
    }

    @Override
    public int hashCode() {
        return dropEventResult != null ? dropEventResult.hashCode() : 0;
    }
}
