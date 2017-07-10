package com.example.colinbell.casino;

import com.example.colinbell.casino.cards.Deck;
import com.example.colinbell.casino.players.User;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 10/07/2017.
 */

public class TestUser {

    User user;
    Deck deck;

    @Before
    public void before(){
        user = new User();
        deck = new Deck();
        user.takeCard(deck);
    }

    @Test
    public void canClearHand() throws Exception {
        assertEquals(1, user.countHand());
        user.clearHand();
        assertEquals(0, user.countHand());
    }
}
