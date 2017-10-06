/**
 * Filter2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchextendedservice;

public class Filter2  implements java.io.Serializable {
    private org.apache.axis.types.UnsignedByte pubDivId;

    private java.lang.String preferedRegionCode;

    private java.lang.String listType;

    private java.lang.String lobbyIDs;

    private java.lang.String regionIDs;

    private java.lang.String typeIDs;

    private boolean isActual;

    public Filter2() {
    }

    public Filter2(
           org.apache.axis.types.UnsignedByte pubDivId,
           java.lang.String preferedRegionCode,
           java.lang.String listType,
           java.lang.String lobbyIDs,
           java.lang.String regionIDs,
           java.lang.String typeIDs,
           boolean isActual) {
           this.pubDivId = pubDivId;
           this.preferedRegionCode = preferedRegionCode;
           this.listType = listType;
           this.lobbyIDs = lobbyIDs;
           this.regionIDs = regionIDs;
           this.typeIDs = typeIDs;
           this.isActual = isActual;
    }


    /**
     * Gets the pubDivId value for this Filter2.
     * 
     * @return pubDivId
     */
    public org.apache.axis.types.UnsignedByte getPubDivId() {
        return pubDivId;
    }


    /**
     * Sets the pubDivId value for this Filter2.
     * 
     * @param pubDivId
     */
    public void setPubDivId(org.apache.axis.types.UnsignedByte pubDivId) {
        this.pubDivId = pubDivId;
    }


    /**
     * Gets the preferedRegionCode value for this Filter2.
     * 
     * @return preferedRegionCode
     */
    public java.lang.String getPreferedRegionCode() {
        return preferedRegionCode;
    }


    /**
     * Sets the preferedRegionCode value for this Filter2.
     * 
     * @param preferedRegionCode
     */
    public void setPreferedRegionCode(java.lang.String preferedRegionCode) {
        this.preferedRegionCode = preferedRegionCode;
    }


    /**
     * Gets the listType value for this Filter2.
     * 
     * @return listType
     */
    public java.lang.String getListType() {
        return listType;
    }


    /**
     * Sets the listType value for this Filter2.
     * 
     * @param listType
     */
    public void setListType(java.lang.String listType) {
        this.listType = listType;
    }


    /**
     * Gets the lobbyIDs value for this Filter2.
     * 
     * @return lobbyIDs
     */
    public java.lang.String getLobbyIDs() {
        return lobbyIDs;
    }


    /**
     * Sets the lobbyIDs value for this Filter2.
     * 
     * @param lobbyIDs
     */
    public void setLobbyIDs(java.lang.String lobbyIDs) {
        this.lobbyIDs = lobbyIDs;
    }


    /**
     * Gets the regionIDs value for this Filter2.
     * 
     * @return regionIDs
     */
    public java.lang.String getRegionIDs() {
        return regionIDs;
    }


    /**
     * Sets the regionIDs value for this Filter2.
     * 
     * @param regionIDs
     */
    public void setRegionIDs(java.lang.String regionIDs) {
        this.regionIDs = regionIDs;
    }


    /**
     * Gets the typeIDs value for this Filter2.
     * 
     * @return typeIDs
     */
    public java.lang.String getTypeIDs() {
        return typeIDs;
    }


    /**
     * Sets the typeIDs value for this Filter2.
     * 
     * @param typeIDs
     */
    public void setTypeIDs(java.lang.String typeIDs) {
        this.typeIDs = typeIDs;
    }


    /**
     * Gets the isActual value for this Filter2.
     * 
     * @return isActual
     */
    public boolean isIsActual() {
        return isActual;
    }


    /**
     * Sets the isActual value for this Filter2.
     * 
     * @param isActual
     */
    public void setIsActual(boolean isActual) {
        this.isActual = isActual;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Filter2)) return false;
        Filter2 other = (Filter2) obj;
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
            ((this.preferedRegionCode==null && other.getPreferedRegionCode()==null) || 
             (this.preferedRegionCode!=null &&
              this.preferedRegionCode.equals(other.getPreferedRegionCode()))) &&
            ((this.listType==null && other.getListType()==null) || 
             (this.listType!=null &&
              this.listType.equals(other.getListType()))) &&
            ((this.lobbyIDs==null && other.getLobbyIDs()==null) || 
             (this.lobbyIDs!=null &&
              this.lobbyIDs.equals(other.getLobbyIDs()))) &&
            ((this.regionIDs==null && other.getRegionIDs()==null) || 
             (this.regionIDs!=null &&
              this.regionIDs.equals(other.getRegionIDs()))) &&
            ((this.typeIDs==null && other.getTypeIDs()==null) || 
             (this.typeIDs!=null &&
              this.typeIDs.equals(other.getTypeIDs()))) &&
            this.isActual == other.isIsActual();
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
        if (getPreferedRegionCode() != null) {
            _hashCode += getPreferedRegionCode().hashCode();
        }
        if (getListType() != null) {
            _hashCode += getListType().hashCode();
        }
        if (getLobbyIDs() != null) {
            _hashCode += getLobbyIDs().hashCode();
        }
        if (getRegionIDs() != null) {
            _hashCode += getRegionIDs().hashCode();
        }
        if (getTypeIDs() != null) {
            _hashCode += getTypeIDs().hashCode();
        }
        _hashCode += (isIsActual() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Filter2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">Filter2"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubDivId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "pubDivId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preferedRegionCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "PreferedRegionCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "ListType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lobbyIDs");
        elemField.setXmlName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "LobbyIDs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("regionIDs");
        elemField.setXmlName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "RegionIDs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("typeIDs");
        elemField.setXmlName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "TypeIDs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isActual");
        elemField.setXmlName(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", "IsActual"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
