/**
 * Filter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.searchextendedservice;

public class Filter  implements java.io.Serializable {
    private java.lang.String preferedRegionCode;

    private java.lang.String listType;

    private java.lang.String lobbyIDs;

    private java.lang.String regionIDs;

    private java.lang.String typeIDs;

    private boolean isActual;

    public Filter() {
    }

    public Filter(
           java.lang.String preferedRegionCode,
           java.lang.String listType,
           java.lang.String lobbyIDs,
           java.lang.String regionIDs,
           java.lang.String typeIDs,
           boolean isActual) {
           this.preferedRegionCode = preferedRegionCode;
           this.listType = listType;
           this.lobbyIDs = lobbyIDs;
           this.regionIDs = regionIDs;
           this.typeIDs = typeIDs;
           this.isActual = isActual;
    }


    /**
     * Gets the preferedRegionCode value for this Filter.
     * 
     * @return preferedRegionCode
     */
    public java.lang.String getPreferedRegionCode() {
        return preferedRegionCode;
    }


    /**
     * Sets the preferedRegionCode value for this Filter.
     * 
     * @param preferedRegionCode
     */
    public void setPreferedRegionCode(java.lang.String preferedRegionCode) {
        this.preferedRegionCode = preferedRegionCode;
    }


    /**
     * Gets the listType value for this Filter.
     * 
     * @return listType
     */
    public java.lang.String getListType() {
        return listType;
    }


    /**
     * Sets the listType value for this Filter.
     * 
     * @param listType
     */
    public void setListType(java.lang.String listType) {
        this.listType = listType;
    }


    /**
     * Gets the lobbyIDs value for this Filter.
     * 
     * @return lobbyIDs
     */
    public java.lang.String getLobbyIDs() {
        return lobbyIDs;
    }


    /**
     * Sets the lobbyIDs value for this Filter.
     * 
     * @param lobbyIDs
     */
    public void setLobbyIDs(java.lang.String lobbyIDs) {
        this.lobbyIDs = lobbyIDs;
    }


    /**
     * Gets the regionIDs value for this Filter.
     * 
     * @return regionIDs
     */
    public java.lang.String getRegionIDs() {
        return regionIDs;
    }


    /**
     * Sets the regionIDs value for this Filter.
     * 
     * @param regionIDs
     */
    public void setRegionIDs(java.lang.String regionIDs) {
        this.regionIDs = regionIDs;
    }


    /**
     * Gets the typeIDs value for this Filter.
     * 
     * @return typeIDs
     */
    public java.lang.String getTypeIDs() {
        return typeIDs;
    }


    /**
     * Sets the typeIDs value for this Filter.
     * 
     * @param typeIDs
     */
    public void setTypeIDs(java.lang.String typeIDs) {
        this.typeIDs = typeIDs;
    }


    /**
     * Gets the isActual value for this Filter.
     * 
     * @return isActual
     */
    public boolean isIsActual() {
        return isActual;
    }


    /**
     * Sets the isActual value for this Filter.
     * 
     * @param isActual
     */
    public void setIsActual(boolean isActual) {
        this.isActual = isActual;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Filter)) return false;
        Filter other = (Filter) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
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
        new org.apache.axis.description.TypeDesc(Filter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://search-extended.1kadry.ru", ">Filter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
