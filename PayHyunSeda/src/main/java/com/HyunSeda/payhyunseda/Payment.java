package com.hyunseda.payhyunseda;
public class Payment {
    private boolean payValue;
    private int idClient;
    private int idPayDocument;

    public boolean isPayValue() {
        return payValue;
    }

    public void setPayValue(boolean payValue) {
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
