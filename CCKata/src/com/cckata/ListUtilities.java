package com.cckata;

public class ListUtilities {
    public static CardTransaction reverseList(CardTransaction start) {
        if (start.next == null) return start;
        CardTransaction previous = null;
        CardTransaction current = start;
        CardTransaction next = start.next;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        start = previous;
        return start;
    }
}
