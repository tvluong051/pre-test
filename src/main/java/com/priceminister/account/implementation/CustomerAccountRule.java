/*
 * =============================================================================
 *
 *   PRICE MINISTER APPLICATION
 *   Copyright (c) 2000 Babelstore.
 *   All Rights Reserved.
 *
 *   $Source$
 *   $Revision$
 *   $Date$
 *   $Author$
 *
 * =============================================================================
 */
package com.priceminister.account.implementation;

import com.priceminister.account.*;

import java.math.BigDecimal;


public class CustomerAccountRule implements AccountRule {

    private static final BigDecimal MINIMUM_ALLOWED_BALANCE = BigDecimal.ZERO;

    /* (non-Javadoc)
     * @see com.priceminister.account.AccountRule#withdrawPermitted(java.lang.Double)
     */
    public boolean withdrawPermitted(BigDecimal resultingAccountBalance) {
        return MINIMUM_ALLOWED_BALANCE.compareTo(resultingAccountBalance) <= 0;
    }

}
