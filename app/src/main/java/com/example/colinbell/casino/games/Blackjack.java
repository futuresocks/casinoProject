package com.example.colinbell.casino.games;

import com.example.colinbell.casino.cards.Deck;
import com.example.colinbell.casino.players.Dealer;
import com.example.colinbell.casino.players.User;

/**
 * Created by colinbell on 23/06/2017.
 */

public class Blackjack implements Game {
    Deck deck;
    User player;
    Dealer dealer;

    public Blackjack() {
        deck = new Deck();
        player = new User("Colin");
        dealer = new Dealer("Dealer");
    }


    public void playGame() {
        deck.populate();
        deck.shuffle();
        player.deal(deck);
        dealer.deal(deck);
        if (checkBlackjack(player, dealer)) {
            System.out.println("BLACKJACK!");
            declareWinner(player, dealer);
        }
        {
            player.userTurn(deck);
            dealer.dealerTurn(deck);
            declareWinner(player, dealer);
        }
    }

    public void declareWinner(User player, Dealer dealer) {
        if ((dealer.countHand() == 2 && dealer.handTotal() == 21 && player.handTotal() != 21)) {
            System.out.println(dealer.getName() + " wins with blackjack, " + player.getName() + " had " + player.handTotal());
        } else if (player.countHand() == 2 && player.handTotal() == 21 && dealer.handTotal() != 21) {
            System.out.println(player.getName() + " wins with blackjack, " + dealer.getName() + " had " + dealer.handTotal());
        } else if (player.handTotal() == dealer.handTotal()) {
            System.out.println("Draw game!");
        } else if (dealer.isBust() && player.isBust()) {
            System.out.println("Everyone bust, draw game!");
        } else if (dealer.isBust() && !player.isBust()) {
            System.out.println(dealer.getName() + " is bust, " + player.getName() + " wins with " + player.handTotal());
        } else if (!dealer.isBust() && player.isBust()) {
            System.out.println(player.getName() + " is bust, " + dealer.getName() + " wins with " + dealer.handTotal());
        } else if (!dealer.isBust() && !player.isBust()) {
            if (player.handTotal() > dealer.handTotal()) {
                System.out.println(player.getName() + " has " + player.handTotal() + ", " + dealer.getName() + " has " + dealer.handTotal() + ", " + player.getName() + " wins!");
            } else
                System.out.println(dealer.getName() + " has " + dealer.handTotal() + ", " + player.getName() + " has " + player.handTotal() + ", " + dealer.getName() + " wins!");
        }
    }

    public boolean checkBlackjack(User player, Dealer dealer) {
        return player.handTotal() == 21 || dealer.handTotal() == 21;
    }
}