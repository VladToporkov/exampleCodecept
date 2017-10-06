/**
 * EIndustryFlagsNull.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.exportnpdservice;

public class EIndustryFlagsNull implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected EIndustryFlagsNull(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _Empty = "Empty";
    public static final java.lang.String _Commerce = "Commerce";
    public static final java.lang.String _Budget = "Budget";
    public static final java.lang.String _SmallBusiness = "SmallBusiness";
    public static final java.lang.String _Luxury = "Luxury";
    public static final java.lang.String _Personnel = "Personnel";
    public static final java.lang.String _Uss = "Uss";
    public static final java.lang.String _Fss = "Fss";
    public static final java.lang.String _KssBU = "KssBU";
    public static final java.lang.String _KssLux = "KssLux";
    public static final java.lang.String _All = "All";
    public static final EIndustryFlagsNull Empty = new EIndustryFlagsNull(_Empty);
    public static final EIndustryFlagsNull Commerce = new EIndustryFlagsNull(_Commerce);
    public static final EIndustryFlagsNull Budget = new EIndustryFlagsNull(_Budget);
    public static final EIndustryFlagsNull SmallBusiness = new EIndustryFlagsNull(_SmallBusiness);
    public static final EIndustryFlagsNull Luxury = new EIndustryFlagsNull(_Luxury);
    public static final EIndustryFlagsNull Personnel = new EIndustryFlagsNull(_Personnel);
    public static final EIndustryFlagsNull Uss = new EIndustryFlagsNull(_Uss);
    public static final EIndustryFlagsNull Fss = new EIndustryFlagsNull(_Fss);
    public static final EIndustryFlagsNull KssBU = new EIndustryFlagsNull(_KssBU);
    public static final EIndustryFlagsNull KssLux = new EIndustryFlagsNull(_KssLux);
    public static final EIndustryFlagsNull All = new EIndustryFlagsNull(_All);
    public java.lang.String getValue() { return _value_;}
    public static EIndustryFlagsNull fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        EIndustryFlagsNull enumeration = (EIndustryFlagsNull)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static EIndustryFlagsNull fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EIndustryFlagsNull.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.1gl.ru/", "eIndustryFlags>null"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
