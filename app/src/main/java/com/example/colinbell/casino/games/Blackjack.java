package com.example.colinbell.casino.games;

import com.example.colinbell.casino.cards.Deck;
import com.example.colinbell.casino.players.Dealer;
import com.example.colinbell.casino.players.User;

/**
 * Created by colinbell on 23/06/2017.
 */

public class Blackjack {

    public Blackjack() {
    }


    public void playGame() {
//        player.deal(deck);
//        dealer.deal(deck);
//        if (checkBlackjack(player, dealer)) {
//            compareHands(player, dealer);
//        }
//        {
//            player.userTurn(deck);
//            dealer.dealerTurn(deck);
//            compareHands(player, dealer);
//        }
    }

    public int compareHands(User player, Dealer dealer) {
        int outcome = 0;
        if ((dealer.countHand() == 2 && dealer.handTotal() == 21 && player.handTotal() != 21)) {
            outcome = -2;
        } else if (player.countHand() == 2 && player.handTotal() == 21 && dealer.handTotal() != 21) {
            outcome = 4;
        } else if (player.handTotal() == dealer.handTotal()) {
            outcome = 0;
        } else if (dealer.isBust() && player.isBust()) {
            outcome = 1;
        } else if (dealer.isBust() && !player.isBust()) {
            outcome = 3 ;
        } else if (!dealer.isBust() && player.isBust()) {
            outcome = -3;
        } else if (!dealer.isBust() && !player.isBust()) {
            if (player.handTotal() > dealer.handTotal()) {
                outcome = 2;
            } else
                outcome = -1;
        }
        return outcome;
    }

    public boolean checkBlackjack(User player, Dealer dealer) {
        return player.handTotal() == 21 || dealer.handTotal() == 21;
    }
}