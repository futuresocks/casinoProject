package com.example.colinbell.casino;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.colinbell.casino.cards.Deck;
import com.example.colinbell.casino.games.Console;
import com.example.colinbell.casino.players.Dealer;
import com.example.colinbell.casino.players.User;

public class blackjackActivity extends AppCompatActivity {

    Button deal;
    TextView dealerHand;
    TextView playerHand;
    TextView dealerTotal;
    TextView playerTotal;
    TextView playerScore;
    TextView dealerScore;
    TextView winner;
    User user;
    Dealer dealer;
    Deck deck;
    Console console;
    Button hit;
    Button stick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blackjack);

        dealerTotal = (TextView) findViewById(R.id.dealerTotal);
        playerTotal = (TextView) findViewById(R.id.playerTotal);
        dealerHand = (TextView) findViewById(R.id.dealerHand);
        playerHand = (TextView) findViewById(R.id.playerHand);
        playerScore = (TextView) findViewById(R.id.playerScore);
        dealerScore = (TextView) findViewById(R.id.dealerScore);
        winner = (TextView) findViewById(R.id.winner);

        stick = (Button) findViewById(R.id.stick);
        hit = (Button) findViewById(R.id.hit);
        deal = (Button) findViewById(R.id.deal);

        user = new User();
        dealer = new Dealer();
        deck = new Deck();
        console = new Console();

        hit.setVisibility(View.INVISIBLE);
        stick.setVisibility(View.INVISIBLE);
        dealerTotal.setVisibility(View.INVISIBLE);


        console.setUserScore(SavedScores.getScores(this, "userScore"));
        console.setDealerScore(SavedScores.getScores(this, "dealerScore"));
        dealerScore.setText(String.valueOf(console.getDealerScore()));
        playerScore.setText(String.valueOf(console.getUserScore()));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_blackjack, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.action_draw_hi_lo){
            Intent intent = new Intent(this, drawHiLoActivity.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.action_about){
            Intent intentAbout = new Intent(this, aboutActivity.class);
            startActivity(intentAbout);
        }
        return super.onOptionsItemSelected(item);
    }


    public void onButtonDeal(View deal) {
        if (deck.getDeckSize() < 10) {
            deck.populate();
            deck.shuffle();
        }
        dealerTotal.setVisibility(View.INVISIBLE);
        winner.setVisibility(View.INVISIBLE);
        deal.setVisibility(View.INVISIBLE);
        user.deal(deck);
        dealer.deal(deck);
        dealerHand.setText(dealer.showFirstCard());
        playerHand.setText(user.showHand());
        console.displayHandTotal(playerTotal, user);
        if (checkBlackjack(user, dealer)) {
            endGame();
        } else {
            hit.setVisibility(View.VISIBLE);
            stick.setVisibility(View.VISIBLE);
        }
    }

    public void onButtonHit(View hit) {
        user.takeCard(deck);
        playerHand.setText(user.showHand());
        console.displayHandTotal(playerTotal, user);
        if (user.isBust()) {
            endGame();
        }
    }

    public void onButtonStick(View stick) {
        hit.setVisibility(View.INVISIBLE);
        stick.setVisibility(View.INVISIBLE);
        dealerHand.setText(dealer.showHand());
        console.displayHandTotal(dealerTotal, dealer);
        dealerTurn();
        endGame();
    }


    public void dealerTurn() {
        dealerHand.setText(dealer.showHand());
        dealerTotal.setVisibility(View.VISIBLE);
        while (dealer.handTotal() < 17) {
            dealer.takeCard(deck);
            dealerHand.setText(dealer.showHand());
            console.displayHandTotal(dealerTotal, dealer);
        }
    }


    public void endGame() {
        hit.setVisibility(View.INVISIBLE);
        stick.setVisibility(View.INVISIBLE);

        console.displayHandTotal(dealerTotal, dealer);
        dealerHand.setText(dealer.showHand());
        dealerTotal.setVisibility(View.VISIBLE);

        int outcome = compareHands(user, dealer);
        console.declareWinner(winner, outcome);
        console.updateScore(outcome);
        playerScore.setText(String.valueOf(console.getUserScore()));
        dealerScore.setText(String.valueOf(console.getDealerScore()));
        user.clearHand();
        dealer.clearHand();
        deal.setVisibility(View.VISIBLE);

        SavedScores.saveScore(this, console.getDealerScore(), "dealerScore");
        SavedScores.saveScore(this, console.getUserScore(), "userScore");

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
            outcome = 3;
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


