package com.example.colinbell.casino.cards;

/**
 * Created by colinbell on 23/06/2017.
 */

public enum Rank {
    TWO(2, "2"),

    THREE(3, "3"),

    FOUR(4, "4"),

    FIVE(5, "5"),

    SIX(6, "6"),

    SEVEN(7, "7"),

    EIGHT(8, "8"),

    NINE(9, "9"),

    TEN(10, "10"),

    JACK(10, "J"),

    QUEEN(10, "Q"),

    KING(10, "K"),

    ACE(11, "A");

    private int value;
    private String displayValue;

    Rank(int value, String displayValue) {
        this.value = value;
        this.displayValue = displayValue;
    }

    public int getValue() {
        return this.value;
    }

    public String getDisplayValue(){
        return this.displayValue;
    }

    public void aceChange() {
        this.value = 1;
    }
}