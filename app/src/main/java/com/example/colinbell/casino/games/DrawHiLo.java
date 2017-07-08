package com.example.colinbell.casino.games;

import com.example.colinbell.casino.cards.Deck;
import com.example.colinbell.casino.players.User;

/**
 * Created by colinbell on 07/07/2017.
 */

public class DrawHiLo implements Game {

    public DrawHiLo(){}

    public int playGame(User user, Deck deck){
        user.deal(deck);
    }





}
