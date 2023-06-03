package com.example.marketapp;

public class userClass {
    private String dataNameUser,dataNameBoot;

    public String getDataNameUser() {
        return dataNameUser;
    }

    public String getDataNameBoot() {
        return dataNameBoot;
    }

    public userClass(String dataNameUser, String dataNameBoot) {
        this.dataNameUser = dataNameUser;
        this.dataNameBoot = dataNameBoot;
    }

    public void setDataNameUser(String dataNameUser) {
        this.dataNameUser = dataNameUser;
    }

    public void setDataNameBoot(String dataNameBoot) {
        this.dataNameBoot = dataNameBoot;
    }
    public userClass(){

    }
}
