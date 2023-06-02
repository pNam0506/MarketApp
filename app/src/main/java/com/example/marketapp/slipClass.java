package com.example.marketapp;

public class slipClass {

    private String dataSlip;
    private String datalog;
    private String dataprice;

    public slipClass(String dataSlip, String datalog, String dataprice) {
        this.dataSlip = dataSlip;
        this.datalog = datalog;
        this.dataprice = dataprice;
    }

    public String getDataSlip() {
        return dataSlip;
    }

    public String getDatalog() {
        return datalog;
    }

    public String getDataprice() {
        return dataprice;
    }

    public void setDataSlip(String dataSlip) {
        this.dataSlip = dataSlip;
    }

    public void setDatalog(String datalog) {
        this.datalog = datalog;
    }

    public void setDataprice(String dataprice) {
        this.dataprice = dataprice;
    }

    public slipClass(){

    }
}

