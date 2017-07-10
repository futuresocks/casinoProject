package com.example.colinbell.casino.games;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import com.example.colinbell.casino.players.Player;

import static com.example.colinbell.casino.R.string.dealerBlackjack;
import static com.example.colinbell.casino.R.string.dealerBust;
import static com.example.colinbell.casino.R.string.dealerWins;
import static com.example.colinbell.casino.R.string.draw;
import static com.example.colinbell.casino.R.string.everyoneBust;
import static com.example.colinbell.casino.R.string.playerBlackjack;
import static com.example.colinbell.casino.R.string.playerBust;
import static com.example.colinbell.casino.R.string.playerWins;

/**
 * Created by user on 08/07/2017.
 */

public class Console {
    private int userScore;
    private int dealerScore;

    public Console() {
        this.userScore = 0;
        this.dealerScore = 0;
    }

    public int getUserScore() {
        return userScore;
    }

    public int getDealerScore() {
        return dealerScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public void setDealerScore(int dealerScore) {
        this.dealerScore = dealerScore;
    }

    public void updateScore(int outcome) {
        if (outcome < 0) {
            this.dealerScore += 1;
        }
        if (outcome > 1) {
            this.userScore += 1;
        }
    }

    public void declareWinner(TextView view, int outcome) {
        view.setVisibility(View.VISIBLE);
        if (outcome == -3) {
            view.setText(dealerWins);
            Snackbar dealerWinPlayerBust = Snackbar.make(view, playerBust, Snackbar.LENGTH_LONG);
            dealerWinPlayerBust.show();
        }
        if (outcome == -2) {
            view.setText(dealerWins);
            Snackbar dealerWinBlackjack = Snackbar.make(view, dealerBlackjack, Snackbar.LENGTH_LONG);
            dealerWinBlackjack.show();
        }
        if (outcome == -1) {
            view.setText(dealerWins);
        }
        if (outcome == 0) {
            view.setText(draw);
        }
        if (outcome == 1) {
            view.setText(draw);
            Snackbar drawAllBust = Snackbar.make(view, everyoneBust, Snackbar.LENGTH_LONG);
            drawAllBust.show();
        }
        if (outcome == 2) {
            view.setText(playerWins);
        }
        if (outcome == 3) {
            view.setText(playerWins);
            Snackbar playerWinDealerBust = Snackbar.make(view, dealerBust, Snackbar.LENGTH_LONG);
            playerWinDealerBust.show();
        }
        if (outcome == 4) {
            view.setText(playerWins);
            Snackbar playerWinBlackjack = Snackbar.make(view, playerBlackjack, Snackbar.LENGTH_LONG);
            playerWinBlackjack.show();
        }
    }


//    public void displayHand(TextView view1, TextView view2, TextView view3, TextView view4, Playable player) {
//        displayCard(view1, view2, player.getHand().get(0));
//        displayCard(view3, view4, player.getHand().get(1));
//    }

//    public void displayCard(TextView view1, TextView view2, Card card) {
//        view1.setText(card.getSuit());
//        view2.setText(card.getRank().getDisplayValue());
//    }
//
    public void displayHandTotal(TextView view, Player player) {
        StringBuilder sb = new StringBuilder();
        sb.append(player.getName());
        sb.append("'s hand totals ");
        sb.append(String.valueOf(player.handTotal()));
        view.setText(sb);
    }
}

