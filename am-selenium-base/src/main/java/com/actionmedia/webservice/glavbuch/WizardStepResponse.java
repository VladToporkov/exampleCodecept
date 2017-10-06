/**
 * WizardStepResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.actionmedia.webservice.glavbuch;

public class WizardStepResponse  implements java.io.Serializable {
    private com.actionmedia.webservice.glavbuch.WizardStepResponseWizardStepResult wizardStepResult;

    public WizardStepResponse() {
    }

    public WizardStepResponse(
           com.actionmedia.webservice.glavbuch.WizardStepResponseWizardStepResult wizardStepResult) {
           this.wizardStepResult = wizardStepResult;
    }


    /**
     * Gets the wizardStepResult value for this WizardStepResponse.
     * 
     * @return wizardStepResult
     */
    public com.actionmedia.webservice.glavbuch.WizardStepResponseWizardStepResult getWizardStepResult() {
        return wizardStepResult;
    }


    /**
     * Sets the wizardStepResult value for this WizardStepResponse.
     * 
     * @param wizardStepResult
     */
    public void setWizardStepResult(com.actionmedia.webservice.glavbuch.WizardStepResponseWizardStepResult wizardStepResult) {
        this.wizardStepResult = wizardStepResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WizardStepResponse)) return false;
        WizardStepResponse other = (WizardStepResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.wizardStepResult==null && other.getWizardStepResult()==null) || 
             (this.wizardStepResult!=null &&
              this.wizardStepResult.equals(other.getWizardStepResult())));
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
        if (getWizardStepResult() != null) {
            _hashCode += getWizardStepResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WizardStepResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">WizardStepResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wizardStepResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", "WizardStepResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://glavbukh.ru.1gl.ru", ">>WizardStepResponse>WizardStepResult"));
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
