package com.finance.report.model;

public class AccountSummary {
    private double totalDeposits;
    private double totalWithdrawals;
    private double endingBalance;

    public AccountSummary(double totalDeposits, double totalWithdrawals, double endingBalance) {
        this.totalDeposits = totalDeposits;
        this.totalWithdrawals = totalWithdrawals;
        this.endingBalance = endingBalance;
    }

    public double getTotalDeposits() { return totalDeposits; }
    public double getTotalWithdrawals() { return totalWithdrawals; }
    public double getEndingBalance() { return endingBalance; }
}
