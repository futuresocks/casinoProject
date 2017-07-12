package com.example.colinbell.casino.cards;

/**
 * Created by colinbell on 23/06/2017.
 */

public class Card {
    private Rank rank;
    private Suit suit;


    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public String cardName() {
        return this.rank + " of " + this.suit;
    }

    public int value() {
        return this.rank.getValue();
    }

}

