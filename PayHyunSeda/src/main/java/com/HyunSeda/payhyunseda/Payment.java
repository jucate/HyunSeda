package com.hyunseda.payhyunseda;
public class Payment {
    private double payValue;
    private int idClient;
    private int idPayDocument;

    public Payment() {
    }

    public double getPayValue() {
        return payValue;
    }

    public void setPayValue(double payValue) {
        this.payValue = payValue;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdPayDocument() {
        return idPayDocument;
    }

    public void setIdPayDocument(int idPayDocument) {
        this.idPayDocument = idPayDocument;
    }
}
