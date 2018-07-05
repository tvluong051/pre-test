package com.priceminister.account.implementation;

import com.priceminister.account.*;

import java.math.BigDecimal;


public class CustomerAccount implements Account {

    private BigDecimal balance;

    public CustomerAccount() {
        this.balance = BigDecimal.ZERO;
    }

    public void add(BigDecimal addedAmount) {
        // TODO Auto-generated method stub
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public BigDecimal withdrawAndReportBalance(BigDecimal withdrawnAmount, AccountRule rule)
    		throws IllegalBalanceException {
        // TODO Auto-generated method stub
        return null;
    }

}
