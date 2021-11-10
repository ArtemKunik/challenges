package com.cckata;

import java.util.Currency;

public class CardTransaction extends ListNode<Double> {
    String ARN;
    String CustomerId;
    Currency currency;
    CardTransaction next;
    String merchant;

    public CardTransaction(Double _value, Currency ccy, String ARN, String customerId, String merchant) {
        super(_value);
        this.ARN = ARN;
        this.CustomerId = customerId;
        this.currency = ccy;
        this.merchant = merchant;
    }
}
