package com.marketapp;

public class slipClass {

    private String dataSlip;
    private String datalog;
    private String dataprice;

    private String dataTime;

    private String dataDate;

    private String dataNameMarket;

    private String dataItem;

    public String getDataNameBoot() {
        return dataNameBoot;
    }

    public void setDataNameBoot(String dataNameBoot) {
        this.dataNameBoot = dataNameBoot;
    }

    private String dataNameBoot;


    public String getDataItem() {
        return dataItem;
    }

    public void setDataItem(String dataItem) {
        this.dataItem = dataItem;
    }

    public String getDataCount() {
        return dataCount;
    }

    public void setDataCount(String dataCount) {
        this.dataCount = dataCount;
    }

    private String dataCount;

    public String getDataNameMarket() {
        return dataNameMarket;
    }

    public void setDataNameMarket(String dataNameMarket) {
        this.dataNameMarket = dataNameMarket;
    }

    public String getDataDate() {
        return dataDate;
    }

    public void setDataDate(String dataDate) {
        this.dataDate = dataDate;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public slipClass(String dataSlip, String datalog,String datatime,String datadate,String dataNameMarket, String dataprice,String dataItem,String dataCount,String dataNameBoot) {
        this.dataSlip = dataSlip;
        this.datalog = datalog;
        this.dataprice = dataprice;
        this.dataTime = datatime;
        this.dataDate = datadate;
        this.dataNameMarket = dataNameMarket;
        this.dataItem= dataItem;
        this.dataCount = dataCount;
        this.dataNameBoot = dataNameBoot;

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

