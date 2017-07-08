package com.example.colinbell.casino.players;

import com.example.colinbell.blackjack.Cards.Card;
import com.example.colinbell.blackjack.Cards.Deck;
import com.example.colinbell.casino.Player;

import java.util.ArrayList;

/**
 * Created by colinbell on 24/06/2017.
 */

public class Dealer extends Player {
    public ArrayList<Card> hand;
    public String name;

    public Dealer(String name) {
        this.hand = new ArrayList<Card>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void takeCard(Deck deck) {
        Card card = deck.remove(0);
        hand.add(card);
    }

    public void deal(Deck deck) {

        takeCard(deck);
        takeCard(deck);
        System.out.println(getName() + " shows " + showFirstCard());
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
        return total;
    }

    public boolean isBust() {

//
//        if (handTotal() > 21) {
//            for (Card card : hand){
//            if (card.value() == 11){card.acesLow()}}
        return (handTotal() > 21);
    }

    public void dealerTurn(Deck deck) {

        System.out.println(getName() + " holds " + showHand());
        while (handTotal() < 17) {
            takeCard(deck);
            System.out.println(getName() + " draws a card and now holds " + showHand());
        }
        if (isBust()) {
            System.out.println(getName() + " has " + handTotal() + ", and is bust.");
        } else if (handTotal() <= 21) {
            System.out.println(getName() + " stands at " + handTotal());
        }
    }
}