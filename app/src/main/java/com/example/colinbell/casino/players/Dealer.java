package com.example.colinbell.casino.players;

import com.example.colinbell.casino.cards.Card;
import com.example.colinbell.casino.cards.Deck;
import com.example.colinbell.casino.players.Player;

import java.util.ArrayList;

/**
 * Created by colinbell on 24/06/2017.
 */

public class Dealer extends Player {
    public ArrayList<Card> hand;

    public Dealer() {
        this.hand = new ArrayList<Card>();
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void clearHand(){
        this.hand.clear();
    }

    public void takeCard(Deck deck) {
        Card card = deck.remove(0);
        hand.add(card);
    }

    public void deal(Deck deck) {
        takeCard(deck);
        takeCard(deck);
    }

    public int countHand() {
        return hand.size();
    }

    public String showFirstCard() {
        ArrayList holding = new ArrayList<String>();
        for (Card card : hand) {
            holding.add(card.cardName());
        }
        return holding.get(0).toString();
    }

    public String showHand() {
        ArrayList holding = new ArrayList<String>();
        for (Card card : hand) {
            holding.add(card.cardName());
        }
        return holding.toString();
    }

    public int handTotal() {
        int total = 0;
        for (Card card : hand) {
            total += card.value();
        }
        if (total > 21) {
            for (Card card : hand) {
                if (card.value() == 11) {
                    total -= 10;
                }
            }
        }
        return total;
    }

    public boolean isBust() {
        return (handTotal() > 21);
    }

    public void dealerTurn(Deck deck) {
        while (handTotal() < 17) {
            takeCard(deck);
        }
    }


}
