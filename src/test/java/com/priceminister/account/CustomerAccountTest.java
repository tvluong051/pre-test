package com.priceminister.account;


import static org.junit.Assert.*;

import org.junit.*;

import com.priceminister.account.implementation.*;

import java.math.BigDecimal;


/**
 * Please create the business code, starting from the unit tests below.
 * Implement the first test, the develop the code that makes it pass.
 * Then focus on the second test, and so on.
 * 
 * We want to see how you "think code", and how you organize and structure a simple application.
 * 
 * When you are done, please zip the whole project (incl. source-code) and send it to recrutement-dev@priceminister.com
 * 
 */
public class CustomerAccountTest {

    private static final BigDecimal INITIAL_AMOUNT = BigDecimal.TEN;
    private static final BigDecimal POSITIVE_AMOUNT = new BigDecimal("42");
    private static final BigDecimal NEGATIVE_AMOUNT = new BigDecimal("-5");

    Account customerAccount;
    AccountRule rule;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        customerAccount = new CustomerAccount();
    }
    
    /**
     * Tests that an empty account always has a balance of 0.0, not a NULL.
     */
    @Test
    public void testAccountWithoutMoneyHasZeroBalance() {
        assertEquals(BigDecimal.ZERO, customerAccount.getBalance());
    }
    
    /**
     * Adds money to the account and checks that the new balance is as expected.
     */
    @Test
    public void testAddPositiveAmountEmptyAccount() {
        customerAccount.add(POSITIVE_AMOUNT);
        assertEquals(POSITIVE_AMOUNT, customerAccount.getBalance());
    }

    @Test
    public void testAddPositiveAmountNotEmptyAccount() {
        customerAccount = new CustomerAccount(INITIAL_AMOUNT);
        customerAccount.add(POSITIVE_AMOUNT);
        assertEquals(INITIAL_AMOUNT.add(POSITIVE_AMOUNT), customerAccount.getBalance());
    }

    @Test
    public void testMultipleAddPositiveAmountEmptyAccount() {
        customerAccount.add(INITIAL_AMOUNT);
        customerAccount.add(POSITIVE_AMOUNT);
        assertEquals(INITIAL_AMOUNT.add(POSITIVE_AMOUNT), customerAccount.getBalance());
    }

    @Test
    public void testAddNegativeAmountDoNotChangeBalance() {
        customerAccount = new CustomerAccount(INITIAL_AMOUNT);
        customerAccount.add(NEGATIVE_AMOUNT);
        assertEquals(INITIAL_AMOUNT, customerAccount.getBalance());
    }
    
    /**
     * Tests that an illegal withdrawal throws the expected exception.
     * Use the logic contained in CustomerAccountRule; feel free to refactor the existing code.
     */
    @Test
    public void testWithdrawAndReportBalanceIllegalBalance() {
    }
    
    // Also implement missing unit tests for the above functionalities.

}
