package com.example.colinbell.casino.cards;

/**
 * Created by colinbell on 23/06/2017.
 */

public enum Rank {
    TWO(2, "2", 1),

    THREE(3, "3", 2),

    FOUR(4, "4", 3),

    FIVE(5, "5", 4),

    SIX(6, "6", 5),

    SEVEN(7, "7", 6),

    EIGHT(8, "8", 7),

    NINE(9, "9", 8),

    TEN(10, "10", 9),

    JACK(10, "J", 10),

    QUEEN(10, "Q", 11),

    KING(10, "K", 12),

    ACE(11, "A", 13);

    private int value;
    private String displayValue;
    private int ranking;

    Rank(int value, String displayValue, int ranking) {
        this.value = value;
        this.displayValue = displayValue;
        this.ranking = ranking;
    }

    public int getValue() {
        return this.value;
    }

    public String getDisplayValue(){
        return this.displayValue;
    }

    public int getRanking() {
        return ranking;
    }
}