package com.example.colinbell.casino;

import com.example.colinbell.casino.cards.Card;
import com.example.colinbell.casino.cards.Deck;
import com.example.colinbell.casino.cards.Rank;
import com.example.colinbell.casino.cards.Suit;
import com.example.colinbell.casino.players.Player;
import com.example.colinbell.casino.players.User;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by user on 12/07/2017.
 */

public class TestDeck {
    Deck deck;
    Deck spyDeck;
    Card card;
    User user;


    @Before
    public void before(){
//        deck populates and shuffles on creation
        deck = new Deck();
        spyDeck = Mockito.spy(deck);
        card = new Card(Rank.TWO, Suit.DIAMONDS);
    }

    @Test
    public void deckCanPopulate() throws Exception {
        assertEquals(52, deck.getDeckSize());
    }

    @Test
    public void canRemove() throws Exception {
        Mockito.when(spyDeck.remove(0)).thenReturn(card);
        assertEquals(card, spyDeck.remove(0));
    }

    @Test
    public void canShuffle() throws Exception {
        assertNotEquals("TWO of DIAMONDS", deck.remove(0).cardName());
    }
}
