package com.example.colinbell.casino.cards;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by colinbell on 23/06/2017.
 */

public class Deck {
    ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();
        populate();
        shuffle();
    }

    public void populate() {
        for (Rank ranks : Rank.values()) {
            for (Suit suits : Suit.values()) {
                cards.add(new Card(ranks, suits));
            }
        }
    }

    public Card remove(int index) {
        Card card = this.cards.remove(index);
        return card;
    }

    public int getDeckSize() {
        return this.cards.size();
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

}

