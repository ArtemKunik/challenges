package com.artem;

import java.util.Currency;

public class CardTransaction extends ListNode<Double>{
    String ARN;
    String CustomerId;
    Currency currency;
    CardTransaction next;

    public CardTransaction(Double _value, Currency ccy, String ARN, String customerId) {
        super(_value);
        this.ARN = ARN;
        this.CustomerId = customerId;
        this.currency = ccy;
    }
}