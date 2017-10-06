package com.actionmedia.components;

/**
 * User: n.tyukavkin
 * Date: 18.08.2014
 * Time: 22:01
 */
public class KbkTable {

    String code;
    int idPayment;
    boolean isTax;
    boolean isPenalties;
    boolean isFine;

    public KbkTable(String code, int idPayment, boolean isTax, boolean isPenalties, boolean isFine) {
        this.code = code;
        this.idPayment = idPayment;
        this.isTax = isTax;
        this.isPenalties = isPenalties;
        this.isFine = isFine;
    }

    public String getCode() {
        return code;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public boolean isTax() {
        return isTax;
    }

    public boolean isPenalties() {
        return isPenalties;
    }

    public boolean isFine() {
        return isFine;
    }
}
