/**
 * TableOfContentEMagazineResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.buhonline;

public class TableOfContentEMagazineResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.buhonline.TableOfContentEMagazineResponseTableOfContentEMagazineResult tableOfContentEMagazineResult;

    public TableOfContentEMagazineResponse() {
    }

    public TableOfContentEMagazineResponse(
           com.actionmedia.webservice.buhonline.TableOfContentEMagazineResponseTableOfContentEMagazineResult tableOfContentEMagazineResult) {
           this.tableOfContentEMagazineResult = tableOfContentEMagazineResult;
    }


    /**
     * Gets the tableOfContentEMagazineResult value for this TableOfContentEMagazineResponse.
     * 
     * @return tableOfContentEMagazineResult
     */
    public com.actionmedia.webservice.buhonline.TableOfContentEMagazineResponseTableOfContentEMagazineResult getTableOfContentEMagazineResult() {
        return tableOfContentEMagazineResult;
    }


    /**
     * Sets the tableOfContentEMagazineResult value for this TableOfContentEMagazineResponse.
     * 
     * @param tableOfContentEMagazineResult
     */
    public void setTableOfContentEMagazineResult(com.actionmedia.webservice.buhonline.TableOfContentEMagazineResponseTableOfContentEMagazineResult tableOfContentEMagazineResult) {
        this.tableOfContentEMagazineResult = tableOfContentEMagazineResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TableOfContentEMagazineResponse)) return false;
        TableOfContentEMagazineResponse other = (TableOfContentEMagazineResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.tableOfContentEMagazineResult==null && other.getTableOfContentEMagazineResult()==null) || 
             (this.tableOfContentEMagazineResult!=null &&
              this.tableOfContentEMagazineResult.equals(other.getTableOfContentEMagazineResult())));
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
        if (getTableOfContentEMagazineResult() != null) {
            _hashCode += getTableOfContentEMagazineResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TableOfContentEMagazineResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">TableOfContentEMagazineResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tableOfContentEMagazineResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://buhonline.1gl.ru", "TableOfContentEMagazineResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://buhonline.1gl.ru", ">>TableOfContentEMagazineResponse>TableOfContentEMagazineResult"));
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
