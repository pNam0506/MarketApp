package com.example.marketapp;

public class DataClass {
    private String dataSir;
    private String dataNameManager;
    private String dataNameMarket;
    private String dataLocationMarket;
    private String dataImage;

    private String dataRules;

    public String getDataSir() {
        return dataSir;
    }

    public String getDataNameManager() {
        return dataNameManager;
    }

    public String getDataNameMarket() {
        return dataNameMarket;
    }

    public String getDataLocationMarket() {
        return dataLocationMarket;
    }

    public String getDataImage() {
        return dataImage;
    }
    public String getDataRules() {
        return dataRules;
    }

    public DataClass(String dataSir, String dataNameManager, String dataNameMarket, String dataLocationMarket, String dataImage) {
        this.dataSir = dataSir;
        this.dataNameManager = dataNameManager;
        this.dataNameMarket = dataNameMarket;
        this.dataLocationMarket = dataLocationMarket;
        this.dataImage = dataImage;
    }

    public DataClass(String dataRules){
        this.dataRules = dataRules;

    }
}