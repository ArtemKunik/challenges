package com.artem;

import java.text.MessageFormat;

public  class TransactionMachine {
    public static void PrintTransactions(CardTransaction node){
        CardTransaction current = node;
        while (current!=null)
        {
            if (current.value < 0)  System.out.println(MessageFormat.format("You spent {0} {1} on {2} today", current.value*-1.0,current.currency,current.ARN));
            if (current.value >= 0)  System.out.println(MessageFormat.format("You received {0} {1} for {2} today", current.value,current.currency,current.ARN));
            current = current.next;
        }
    }
}
