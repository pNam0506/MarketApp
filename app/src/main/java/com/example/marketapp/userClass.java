package com.example.marketapp;

public class userClass {
    private String dataNameUser,dataNameBoot,dataEmailUser,dataPhoneUser,dataProduct;


    public userClass(){


    }

    public String getDataNameUser() {
        return dataNameUser;
    }

    public void setDataNameUser(String dataNameUser) {
        this.dataNameUser = dataNameUser;
    }

    public String getDataNameBoot() {
        return dataNameBoot;
    }

    public void setDataNameBoot(String dataNameBoot) {
        this.dataNameBoot = dataNameBoot;
    }

    public String getDataEmailUser() {
        return dataEmailUser;
    }

    public void setDataEmailUser(String dataEmailUser) {
        this.dataEmailUser = dataEmailUser;
    }

    public String getDataPhoneUser() {
        return dataPhoneUser;
    }

    public void setDataPhoneUser(String dataPhoneUser) {
        this.dataPhoneUser = dataPhoneUser;
    }

    public String getDataProduct() {
        return dataProduct;
    }

    public void setDataProduct(String dataProduct) {
        this.dataProduct = dataProduct;
    }

    public userClass(String dataNameUser, String dataNameBoot, String dataEmailUser, String dataPhoneUser, String dataProduct) {
        this.dataNameUser = dataNameUser;
        this.dataNameBoot = dataNameBoot;
        this.dataEmailUser = dataEmailUser;
        this.dataPhoneUser = dataPhoneUser;
        this.dataProduct = dataProduct;
    }
}
