package com.priceminister.account;


import java.math.BigDecimal;

public class IllegalBalanceException extends Exception {
    
    private static final long serialVersionUID = -9204191749972551939L;
    
	private BigDecimal balance;
    
    public IllegalBalanceException(BigDecimal illegalBalance) {
        balance = illegalBalance;
    }
    
    public String toString() {
        return "Illegal account balance: " + balance;
    }
}
