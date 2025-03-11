package com.finance.report.model;

//package com.finance.report.model;

public class User {
    private String id;
    private String name;
    private String email;
    private String address;
    private String accountNumber;

    public User(String id, String name, String email, String address, String accountNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.accountNumber = accountNumber;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public String getAccountNumber() { return accountNumber; }
}
