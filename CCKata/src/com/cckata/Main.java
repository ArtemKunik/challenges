package com.cckata;

import java.util.Currency;

public class Main {

    public static void main(String[] args) {

        Double previousEodBalance = 1000.0;
        Currency ccy = Currency.getInstance("USD");
        CardTransaction firstTransaction = getDailyTransaction(ccy);


    }

    private static CardTransaction getDailyTransaction(Currency ccy) {
        /*
        1. Client bought bus ticket for 1.5$ and went to shopping mall
        2. Client bought jacket and two pair of jeans for 150$
        3. Client ate at cafeteria for 10$
        4. Client decided to return one pair of jeans, so his card has been debited for 45$
        5. Client went for casual shopping in grocery for 33.15$.
        6. Client bought bus ticket for 1.5$ amd went back home
        7. Client apparently has been charged again for 10$ by cafeteria
        8. Client receives refund from Ebay transaction for 198.18$
        9. Client noticed ed charge at p.7 and calls merchant with complaint, so they cancel transaction

         */

        String customerId = "Customer1";

        CardTransaction fisrt = new CardTransaction(-1.5, ccy, "Transaction1", customerId, "Bus");
        CardTransaction second = new CardTransaction(-150.0, ccy, "Transaction2", customerId, "ClothesStore");
        fisrt.next = second;
        CardTransaction third = new CardTransaction(-10.0, ccy, "Transaction3", customerId, "Cafeteria");
        second.next = third;
        CardTransaction fourth = new CardTransaction(45.0, ccy, "Transaction4", customerId, "ClothesStore");
        third.next = fourth;
        CardTransaction fifth = new CardTransaction(-33.15, ccy, "Transaction5", customerId, "Grocery");
        fourth.next = fifth;
        CardTransaction sixth = new CardTransaction(-1.5, ccy, "Transaction6", customerId, "Bus");
        fifth.next = sixth;
        CardTransaction seventh = new CardTransaction(-10.0, ccy, "Transaction7", customerId, "Cafeteria");
        sixth.next = seventh;
        CardTransaction eight = new CardTransaction(198.18, ccy, "Transaction8", customerId, "EBay");
        seventh.next = eight;
        CardTransaction nine = new CardTransaction(10.0, ccy, "Transaction7", customerId, "Cafeteria");
        eight.next = nine;
        return fisrt;
    }


}
