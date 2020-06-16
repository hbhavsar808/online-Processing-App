package com.example.spleshanimataiontest.datamodel;

public class ListItem {
    private String customername;//service name
    private String date;
    private String price;
    private String time;
    private String status;
    private String offerprice;
    private String discount;
    private String qty;

    public ListItem() {

    }

    public ListItem(String customername, String date, String price, String time, String status, String offerprice, String discount, String qty) {
        this.customername = customername;
        this.date = date;
        this.price = price;
        this.time = time;
        this.status = status;
        this.offerprice = offerprice;
        this.discount = discount;
        this.qty = qty;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOfferprice() {
        return offerprice;
    }

    public void setOfferprice(String offerprice) {
        this.offerprice = offerprice;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }
}
