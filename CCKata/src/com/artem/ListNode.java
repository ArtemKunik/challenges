package com.artem;

public class ListNode<T> {
    T value;
    ListNode<T> next;
    public ListNode(T _value){
        value = _value;
        next = null;
    }
    public ListNode(){
        value = null;
        next = null;
    }
    public ListNode(T _value, ListNode _next){
        value = _value;
        next = _next;
    }
}