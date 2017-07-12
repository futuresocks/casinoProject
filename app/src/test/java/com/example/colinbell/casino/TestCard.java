package com.example.colinbell.casino;

import com.example.colinbell.casino.cards.Card;

import org.junit.Before;
import org.junit.Test;

import static com.example.colinbell.casino.cards.Rank.ACE;
import static com.example.colinbell.casino.cards.Rank.TWO;
import static com.example.colinbell.casino.cards.Suit.DIAMONDS;
import static com.example.colinbell.casino.cards.Suit.SPADES;
import static org.junit.Assert.assertEquals;

/**
 * Created by user on 12/07/2017.
 */

public class TestCard {

    Card card1;
    Card card2;

    @Before
    public void before(){
        card1 = new Card(TWO,DIAMONDS);
        card2 = new Card(ACE, SPADES);
    }

    @Test
    public void cardHasSuit() throws Exception {
        assertEquals(DIAMONDS, card1.getSuit());
    }

    @Test
    public void cardHasRank() throws Exception{
        assertEquals(TWO, card1.getRank());
    }

    @Test
    public void rankHasValue() throws Exception {
        assertEquals(2, card1.getRank().getValue());
    }

    @Test
    public void rankHasRanking() throws Exception {
        assertEquals(13, card2.getRank().getRanking());
    }

    @Test
    public void cardHasValue() throws Exception {
        assertEquals(2, card1.value());
    }

    @Test
    public void rankHasDisplayValue() throws Exception {
        assertEquals("A", card2.getRank().getDisplayValue());
    }
}
