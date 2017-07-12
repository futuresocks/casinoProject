package com.example.colinbell.casino;

import com.example.colinbell.casino.cards.Card;
import com.example.colinbell.casino.cards.Deck;
import com.example.colinbell.casino.cards.Rank;
import com.example.colinbell.casino.cards.Suit;
import com.example.colinbell.casino.players.User;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 10/07/2017.
 */

public class TestUser {

    User user;
    Deck deck;
    Card card1;
    Card card2;
    Deck spyDeck;
    User spyUser;

    @Before
    public void before(){
        user = new User();
        deck = new Deck();
        card1 = new Card(Rank.ACE, Suit.SPADES);
        card2 = new Card(Rank.KING, Suit.DIAMONDS);
        spyDeck = Mockito.spy(deck);
        spyUser = Mockito.spy(user);
    }

    @Test
    public void canTakeCard() throws Exception {
        user.takeCard(deck);
        assertEquals(1, user.countHand());
    }

    @Test
    public void canCountHand() throws Exception {
        user.takeCard(deck);
        user.takeCard(deck);
        assertEquals(2, user.countHand());
    }

    @Test
    public void canTakeDeal() throws Exception {
        user.deal(deck);
        assertEquals(2, user.countHand());
    }

    @Test
    public void handTotal() throws Exception {
        user.addCardtoHand(card1);
        user.addCardtoHand(card2);
        assertEquals(21, user.handTotal());
    }

    @Test
    public void showHand() throws Exception {
        spyUser.deal(deck);
        Mockito.when(spyUser.showHand()).thenReturn("TWO of DIAMONDS, FOUR of CLUBS");
        assertEquals("TWO of DIAMONDS, FOUR of CLUBS", spyUser.showHand());
    }

    @Test
    public void canClearHand() throws Exception {
        user.takeCard(deck);
        assertEquals(1, user.countHand());
        user.clearHand();
        assertEquals(0, user.countHand());
    }

    @Test
    public void isBust() throws Exception {
        Mockito.when(spyUser.handTotal()).thenReturn(24);
        assertEquals(true, spyUser.isBust());
    }
}
