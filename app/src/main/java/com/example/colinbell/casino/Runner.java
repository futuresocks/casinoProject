package com.example.colinbell.casino;

import com.example.colinbell.casino.games.Blackjack;

/**
 * Created by colinbell on 25/06/2017.
 */

public class Runner {

    public static void main(String[] args) {
        Blackjack game = new Blackjack();
        game.playGame();
    }
}
