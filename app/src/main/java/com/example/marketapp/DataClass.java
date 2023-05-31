package com.example.marketapp;

public class DataClass {
    private String dataSir;
    private String dataNameManager;
    private String dataNameMarket;
    private String dataLocationMarket;
    private String dataImage;

    private String dataRules;

    private String dataTime_Booking;

    private String dataTime_Market;

    private String dataphoneNumber;

    private String dataEmail;

    public String getDataphoneNumber() {
        return dataphoneNumber;
    }

    public String getDataEmail() {
        return dataEmail;
    }

    public String getDataTime_Booking() {
        return dataTime_Booking;
    }

    public String getDataTime_Market() {
        return dataTime_Market;
    }



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




    public DataClass(String dataSir, String dataNameManager, String dataNameMarket, String dataLocationMarket,String dataRules,String dataTimeB,String dataTimeM,String dataphone,String dataE, String dataImage) {
        this.dataSir = dataSir;
        this.dataNameManager = dataNameManager;
        this.dataNameMarket = dataNameMarket;
        this.dataLocationMarket = dataLocationMarket;
        this.dataRules = dataRules;
        this.dataImage = dataImage;
        this.dataTime_Market = "เวลาเปิดปิดตลาด:"+dataTimeM;
        this.dataTime_Booking = "เวลาเปิดปิดการจอง"+dataTimeB;
        this.dataphoneNumber = "เบอร์โทร:"+dataphone;
        this.dataEmail = "อีเมล:"+ dataE;

    }


    public DataClass(){

    }




}