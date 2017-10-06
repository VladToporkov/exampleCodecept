/**
 * DropEventAEventParametersNode.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.eventservice;

import org.apache.axis.encoding.AnyContentType;
import org.apache.axis.encoding.MixedContentType;
import org.apache.axis.message.MessageElement;

import java.util.Arrays;

public class DropEventAEventParametersNode implements java.io.Serializable, AnyContentType, MixedContentType {

    private MessageElement[] _any;

    public DropEventAEventParametersNode() {
    }

    public DropEventAEventParametersNode(MessageElement[] _any) {
        this._any = new MessageElement[_any.length];
        System.arraycopy(_any, 0, this._any, 0, _any.length);
    }

    /**
     * Gets the _any value for this DropEventAEventParametersNode.
     *
     * @return _any
     */
    public MessageElement[] get_any() {
        return _any;
    }

    /**
     * Sets the _any value for this DropEventAEventParametersNode.
     *
     * @param _any
     */
    public void set_any(MessageElement[] _any) {
        this._any = new MessageElement[_any.length];
        System.arraycopy(_any, 0, this._any, 0, _any.length);
    }

    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(DropEventAEventParametersNode.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://action-media.ru/", ">>DropEvent>aEventParametersNode"));
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

        DropEventAEventParametersNode that = (DropEventAEventParametersNode) o;

        return Arrays.equals(_any, that._any);
    }

    @Override
    public int hashCode() {
        return _any != null ? Arrays.hashCode(_any) : 0;
    }
}
