package com.finance.report.model;

public class BankDetails {
    private String name;
    private String address;

    public BankDetails(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() { return name; }
    public String getAddress() { return address; }
}
