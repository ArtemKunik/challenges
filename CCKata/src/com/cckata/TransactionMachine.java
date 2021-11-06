package com.cckata;

import java.text.MessageFormat;

public class TransactionMachine {
    public static void PrintTransactions(CardTransaction node) {
        CardTransaction current = node;
        while (current != null) {
            if (current.value < 0)
                System.out.println(MessageFormat.format("You spent {0} {1} on {2} today in {3}", current.value * -1.0, current.currency, current.ARN, current.merchant));
            if (current.value >= 0)
                System.out.println(MessageFormat.format("You received {0} {1} for {2} today from {3}", current.value, current.currency, current.ARN, current.merchant));
            current = current.next;
        }
        System.out.println("End of transaction list");
    }

    public static double calculateBalance(double previousEOD, CardTransaction node) {
        CardTransaction current = node;

        while (current != null) {
            previousEOD += current.value;
            current = current.next;
        }
        return previousEOD;
    }
}
