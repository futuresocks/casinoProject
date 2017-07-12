package com.example.colinbell.casino.players;

import com.example.colinbell.casino.cards.Deck;
import com.example.colinbell.casino.cards.Card;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by colinbell on 23/06/2017.
 */

public class User extends Player{
    public ArrayList<Card> hand;

    public User() {
        this.hand = new ArrayList<Card>();
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void clearHand(){
        this.hand.clear();
    }

    public void addCardtoHand(Card card){
        hand.add(card);
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
        return (handTotal() > 21);}

    public String showCard(int i){
        return this.hand.get(i).cardName();
    }

    public void burnCard(){
        this.hand.remove(0);
    }
}
