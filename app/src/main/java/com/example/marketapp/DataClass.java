package com.example.marketapp;

public class DataClass {
    private String dataSir;
    private String dataNameManager;
    private String dataNameMarket;
    private String dataLocationMarket;
    private String dataImage;

    private String dataRules;

    public String getDataRules() {return dataRules;}


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




    public DataClass(String dataSir, String dataNameManager, String dataNameMarket, String dataLocationMarket,String dataRules, String dataImage) {
        this.dataSir = dataSir;
        this.dataNameManager = dataNameManager;
        this.dataNameMarket = dataNameMarket;
        this.dataLocationMarket = dataLocationMarket;
        this.dataRules = dataRules;
        this.dataImage = dataImage;
    }

    public DataClass(String dataSir, String dataNameManager, String dataNameMarket, String dataLocationMarket,String dataRules) {
        this.dataSir = dataSir;
        this.dataNameManager = dataNameManager;
        this.dataNameMarket = dataNameMarket;
        this.dataLocationMarket = dataLocationMarket;
        this.dataRules = dataRules;
    }

    public DataClass(){

    }




}