package com.example.colinbell.casino.players;

import com.example.colinbell.casino.cards.Deck;
import com.example.colinbell.casino.cards.Card;

import java.util.ArrayList;

/**
 * Created by colinbell on 23/06/2017.
 */

public abstract class Player {
    private ArrayList<Card> hand;

    public Player() {
        this.hand = new ArrayList<Card>();
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    abstract void takeCard(Deck deck);

    abstract void deal(Deck deck);

    abstract int countHand();

    abstract String showHand();

    public int handTotal() {
        int total = 0;
        for (Card card : hand) {
            total += card.value();
        }
        return total;
    }

    public boolean isBust() {
        return (handTotal() > 21);}

}
