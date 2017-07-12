package com.example.colinbell.casino.games;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.colinbell.casino.R;

public class twoCardDragActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_card_drag);
    }

    //    Deck deck;
//
//    public TwoCardDrag() {
//        user = new User();
//        dealer = new Dealer();
//        deck = new Deck();
//    }
//
//    public int playGame() {
//        Card userCard = deck.remove(0);
//        Card dealerCard = deck.remove(0);
//        int result = compareCards(userCard, dealerCard);
//        return result;
//    }
//
//    private int compareCards(Card userCard, Card dealerCard) {
//        int outcome = 0;
//        if (userCard.getRank().getValue() == dealerCard.getRank().getValue()) {
//            outcome = 0;
//        }
//        if (userCard.getRank().getValue() < dealerCard.getRank().getValue()) {
//            outcome = -1;
//        }
//        if (userCard.getRank().getValue() < dealerCard.getRank().getValue()) {
//            outcome = 2;
//        }
//        return outcome;
//    }


}
