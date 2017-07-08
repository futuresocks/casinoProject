package com.example.colinbell.casino.players;

import com.example.colinbell.casino.cards.Deck;
import com.example.colinbell.casino.cards.Card;

import java.util.ArrayList;

/**
 * Created by colinbell on 23/06/2017.
 */

abstract class Player {
    private ArrayList<Card> hand;

    public Player() {
        this.hand = new ArrayList<Card>();
    }

    abstract String getName();

    abstract void takeCard(Deck deck);

    abstract void deal(Deck deck);

    abstract int countHand();

    abstract String showHand();

    abstract int handTotal();

    abstract boolean isBust();

}
