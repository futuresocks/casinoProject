package com.example.colinbell.casino.games;

import android.view.View;
import android.widget.TextView;

import com.example.colinbell.casino.cards.Card;

import static com.example.colinbell.casino.R.string.dealerWins;
import static com.example.colinbell.casino.R.string.draw;
import static com.example.colinbell.casino.R.string.playerWins;

/**
 * Created by user on 08/07/2017.
 */

public class Console {

    public Console(){
    }

    public void declareWinner(TextView view, int outcome){
        switch (outcome){
            case 0:
                view.setText(draw);
            case 1:
                view.setText(playerWins);
            case -1:
                view.setText(dealerWins);
        }

    }

    public void displayCard(View view, Card card){

    }
}
