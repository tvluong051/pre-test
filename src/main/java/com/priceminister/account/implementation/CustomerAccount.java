package com.priceminister.account.implementation;

import com.priceminister.account.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;


public class CustomerAccount implements Account {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerAccount.class);

    private BigDecimal balance;

    public CustomerAccount() {
        this.balance = BigDecimal.ZERO;
    }

    public CustomerAccount(BigDecimal initialAmount) {
        this.balance = initialAmount;
    }

    public void add(BigDecimal addedAmount) {
        LOGGER.info("Request to add amount: {}", addedAmount);
        if(BigDecimal.ZERO.compareTo(addedAmount) <= 0) {
            this.balance = this.balance.add(addedAmount);
            LOGGER.info("Amount added");
        }
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public BigDecimal withdrawAndReportBalance(BigDecimal withdrawnAmount, AccountRule rule)
    		throws IllegalBalanceException {
        LOGGER.info("Request to withdraw amount: {}", withdrawnAmount);
        BigDecimal resultingBalance = this.balance.subtract(withdrawnAmount);
        if(rule.withdrawPermitted(resultingBalance)) {
            this.balance = resultingBalance;
            LOGGER.info("Amount withdrawed. New balance: {}", resultingBalance);
        } else {
            IllegalBalanceException illegalBalanceException = new IllegalBalanceException(this.balance);
            LOGGER.error(illegalBalanceException.toString());
            throw illegalBalanceException;
        }
        return this.balance;
    }

}
