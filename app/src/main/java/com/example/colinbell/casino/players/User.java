package com.example.colinbell.casino.players;

import com.example.colinbell.casino.cards.Deck;
import com.example.colinbell.casino.cards.Card;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by colinbell on 23/06/2017.
 */

public class User extends Player {
    public ArrayList<Card> hand;
    public String name;
    public Scanner sc;

    public User(String name) {
        this.hand = new ArrayList<Card>();
        this.name = name;
        sc = new Scanner(System.in);
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
        return total;
    }

    public boolean isBust() {
        return handTotal() > 21;
    }

    public void userTurn(Deck deck) {
        System.out.println(getName() + ", your hand is worth " + handTotal() + ". Hit or Stick?");
        String input = sc.nextLine().toUpperCase();
        char choice = input.charAt(0);
        switch (choice) {
            case 'H':
                takeCard(deck);
                System.out.println(getName() + " now holds " + showHand());
                if (isBust()) {
                    System.out.println(getName() + " has " + handTotal() + ", and is bust.");
                } else {
                    userTurn(deck);
                }
                break;
            case 'S':
                System.out.println(getName() + " stands at " + handTotal());
        }
    }
}
