/**
 * ExtendedSearchFilter2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.buhonline;

public class ExtendedSearchFilter2  implements java.io.Serializable {
    private org.apache.axis.types.UnsignedByte pubDivId;

    private com.actionmedia.webservice.buhonline.FilterType variableAttribute;

    private java.lang.Integer regionID;

    private java.lang.Integer typeID;

    private java.lang.Integer lobbyID;

    private boolean isActual;

    private java.lang.String preferedRegionCode;

    public ExtendedSearchFilter2() {
    }

    public ExtendedSearchFilter2(
           org.apache.axis.types.UnsignedByte pubDivId,
           com.actionmedia.webservice.buhonline.FilterType variableAttribute,
           java.lang.Integer regionID,
           java.lang.Integer typeID,
           java.lang.Integer lobbyID,
           boolean isActual,
           java.lang.String preferedRegionCode) {
           this.pubDivId = pubDivId;
           this.variableAttribute = variableAttribute;
           this.regionID = regionID;
           this.typeID = typeID;
           this.lobbyID = lobbyID;
           this.isActual = isActual;
           this.preferedRegionCode = preferedRegionCode;
    }


    /**
     * Gets the pubDivId value for this ExtendedSearchFilter2.
     * 
     * @return pubDivId
     */
    public org.apache.axis.types.UnsignedByte getPubDivId() {
        return pubDivId;
    }


    /**
     * Sets the pubDivId value for this ExtendedSearchFilter2.
     * 
     * @param pubDivId
     */
    public void setPubDivId(org.apache.axis.types.UnsignedByte pubDivId) {
        this.pubDivId = pubDivId;
    }


    /**
     * Gets the variableAttribute value for this ExtendedSearchFilter2.
     * 
     * @return variableAttribute
     */
    public com.actionmedia.webservice.buhonline.FilterType getVariableAttribute() {
        return variableAttribute;
    }


    /**
     * Sets the variableAttribute value for this ExtendedSearchFilter2.
     * 
     * @param variableAttribute
     */
    public void setVariableAttribute(com.actionmedia.webservice.buhonline.FilterType variableAttribute) {
        this.variableAttribute = variableAttribute;
    }


    /**
     * Gets the regionID value for this ExtendedSearchFilter2.
     * 
     * @return regionID
     */
    public java.lang.Integer getRegionID() {
        return regionID;
    }


    /**
     * Sets the regionID value for this ExtendedSearchFilter2.
     * 
     * @param regionID
     */
    public void setRegionID(java.lang.Integer regionID) {
        this.regionID = regionID;
    }


    /**
     * Gets the typeID value for this ExtendedSearchFilter2.
     * 
     * @return typeID
     */
    public java.lang.Integer getTypeID() {
        return typeID;
    }


    /**
     * Sets the typeID value for this ExtendedSearchFilter2.
     * 
     * @param typeID
     */
    public void setTypeID(java.lang.Integer typeID) {
        this.typeID = typeID;
    }


    /**
     * Gets the lobbyID value for this ExtendedSearchFilter2.
     * 
     * @return lobbyID
     */
    public java.lang.Integer getLobbyID() {
        return lobbyID;
    }


    /**
     * Sets the lobbyID value for this ExtendedSearchFilter2.
     * 
     * @param lobbyID
     */
    public void setLobbyID(java.lang.Integer lobbyID) {
        this.lobbyID = lobbyID;
    }


    /**
     * Gets the isActual value for this ExtendedSearchFilter2.
     * 
     * @return isActual
     */
    public boolean isIsActual() {
        return isActual;
    }


    /**
     * Sets the isActual value for this ExtendedSearchFilter2.
     * 
     * @param isActual
     */
    public void setIsActual(boolean isActual) {
        this.isActual = isActual;
    }


    /**
     * Gets the preferedRegionCode value for this ExtendedSearchFilter2.
     * 
     * @return preferedRegionCode
     */
    public java.lang.String getPreferedRegionCode() {
        return preferedRegionCode;
    }


    /**
     * Sets the preferedRegionCode value for this ExtendedSearchFilter2.
     * 
     * @param preferedRegionCode
     */
    public void setPreferedRegionCode(java.lang.String preferedRegionCode) {
        this.preferedRegionCode = preferedRegionCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExtendedSearchFilter2)) return false;
        ExtendedSearchFilter2 other = (ExtendedSearchFilter2) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.pubDivId==null && other.getPubDivId()==null) || 
             (this.pubDivId!=null &&
              this.pubDivId.equals(other.getPubDivId()))) &&
            ((this.variableAttribute==null && other.getVariableAttribute()==null) || 
             (this.variableAttribute!=null &&
              this.variableAttribute.equals(other.getVariableAttribute()))) &&
            ((this.regionID==null && other.getRegionID()==null) || 
             (this.regionID!=null &&
              this.regionID.equals(other.getRegionID()))) &&
            ((this.typeID==null && other.getTypeID()==null) || 
             (this.typeID!=null &&
              this.typeID.equals(other.getTypeID()))) &&
            ((this.lobbyID==null && other.getLobbyID()==null) || 
             (this.lobbyID!=null &&
              this.lobbyID.equals(other.getLobbyID()))) &&
            this.isActual == other.isIsActual() &&
            ((this.preferedRegionCode==null && other.getPreferedRegionCode()==null) || 
             (this.preferedRegionCode!=null &&
              this.preferedRegionCode.equals(other.getPreferedRegionCode())));
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
        if (getPubDivId() != null) {
            _hashCode += getPubDivId().hashCode();
        }
        if (getVariableAttribute() != null) {
            _hashCode += getVariableAttribute().hashCode();
        }
        if (getRegionID() != null) {
            _hashCode += getRegionID().hashCode();
        }
        if (getTypeID() != null) {
            _hashCode += getTypeID().hashCode();
        }
        if (getLobbyID() != null) {
            _hashCode += getLobbyID().hashCode();
        }
        _hashCode += (isIsActual() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getPreferedRegionCode() != null) {
            _hashCode += getPreferedRegionCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExtendedSearchFilter2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">ExtendedSearchFilter2"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubDivId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "pubDivId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("variableAttribute");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "VariableAttribute"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "FilterType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("regionID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "RegionID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("typeID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "TypeID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lobbyID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "LobbyID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isActual");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "IsActual"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preferedRegionCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "PreferedRegionCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
