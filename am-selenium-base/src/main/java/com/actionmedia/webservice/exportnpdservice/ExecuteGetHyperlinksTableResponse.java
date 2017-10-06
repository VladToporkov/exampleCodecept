/**
 * ExecuteGetHyperlinksTableResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.exportnpdservice;

public class ExecuteGetHyperlinksTableResponse  extends com.actionmedia.webservice.exportnpdservice.ExecuteResponse  implements java.io.Serializable {
    private boolean isMagFound;

    private com.actionmedia.webservice.exportnpdservice.EHyperlinksModified EModified;

    private byte[] timestamp;

    private com.actionmedia.webservice.exportnpdservice.Hyperlink[] hyperlinks;

    public ExecuteGetHyperlinksTableResponse() {
    }

    public ExecuteGetHyperlinksTableResponse(
           long durationInMSec,
           boolean isMagFound,
           com.actionmedia.webservice.exportnpdservice.EHyperlinksModified EModified,
           byte[] timestamp,
           com.actionmedia.webservice.exportnpdservice.Hyperlink[] hyperlinks) {
        super(
            durationInMSec);
        this.isMagFound = isMagFound;
        this.EModified = EModified;
        this.timestamp = timestamp;
        this.hyperlinks = hyperlinks;
    }


    /**
     * Gets the isMagFound value for this ExecuteGetHyperlinksTableResponse.
     * 
     * @return isMagFound
     */
    public boolean isIsMagFound() {
        return isMagFound;
    }


    /**
     * Sets the isMagFound value for this ExecuteGetHyperlinksTableResponse.
     * 
     * @param isMagFound
     */
    public void setIsMagFound(boolean isMagFound) {
        this.isMagFound = isMagFound;
    }


    /**
     * Gets the EModified value for this ExecuteGetHyperlinksTableResponse.
     * 
     * @return EModified
     */
    public com.actionmedia.webservice.exportnpdservice.EHyperlinksModified getEModified() {
        return EModified;
    }


    /**
     * Sets the EModified value for this ExecuteGetHyperlinksTableResponse.
     * 
     * @param EModified
     */
    public void setEModified(com.actionmedia.webservice.exportnpdservice.EHyperlinksModified EModified) {
        this.EModified = EModified;
    }


    /**
     * Gets the timestamp value for this ExecuteGetHyperlinksTableResponse.
     * 
     * @return timestamp
     */
    public byte[] getTimestamp() {
        return timestamp;
    }


    /**
     * Sets the timestamp value for this ExecuteGetHyperlinksTableResponse.
     * 
     * @param timestamp
     */
    public void setTimestamp(byte[] timestamp) {
        this.timestamp = timestamp;
    }


    /**
     * Gets the hyperlinks value for this ExecuteGetHyperlinksTableResponse.
     * 
     * @return hyperlinks
     */
    public com.actionmedia.webservice.exportnpdservice.Hyperlink[] getHyperlinks() {
        return hyperlinks;
    }


    /**
     * Sets the hyperlinks value for this ExecuteGetHyperlinksTableResponse.
     * 
     * @param hyperlinks
     */
    public void setHyperlinks(com.actionmedia.webservice.exportnpdservice.Hyperlink[] hyperlinks) {
        this.hyperlinks = hyperlinks;
    }

    public com.actionmedia.webservice.exportnpdservice.Hyperlink getHyperlinks(int i) {
        return this.hyperlinks[i];
    }

    public void setHyperlinks(int i, com.actionmedia.webservice.exportnpdservice.Hyperlink _value) {
        this.hyperlinks[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExecuteGetHyperlinksTableResponse)) return false;
        ExecuteGetHyperlinksTableResponse other = (ExecuteGetHyperlinksTableResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.isMagFound == other.isIsMagFound() &&
            ((this.EModified==null && other.getEModified()==null) || 
             (this.EModified!=null &&
              this.EModified.equals(other.getEModified()))) &&
            ((this.timestamp==null && other.getTimestamp()==null) || 
             (this.timestamp!=null &&
              java.util.Arrays.equals(this.timestamp, other.getTimestamp()))) &&
            ((this.hyperlinks==null && other.getHyperlinks()==null) || 
             (this.hyperlinks!=null &&
              java.util.Arrays.equals(this.hyperlinks, other.getHyperlinks())));
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
        _hashCode += (isIsMagFound() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getEModified() != null) {
            _hashCode += getEModified().hashCode();
        }
        if (getTimestamp() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTimestamp());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTimestamp(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getHyperlinks() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getHyperlinks());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getHyperlinks(), i);
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
        new org.apache.axis.description.TypeDesc(ExecuteGetHyperlinksTableResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "ExecuteGetHyperlinksTableResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isMagFound");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "IsMagFound"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("EModified");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "EModified"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "EHyperlinksModified"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timestamp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "Timestamp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hyperlinks");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.1gl.ru/", "Hyperlinks"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "Hyperlink"));
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
