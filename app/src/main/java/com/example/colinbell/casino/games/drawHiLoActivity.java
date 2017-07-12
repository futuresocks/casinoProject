package com.example.colinbell.casino.games;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.colinbell.casino.R;
import com.example.colinbell.casino.scoreData.SavedScores;
import com.example.colinbell.casino.nonGameScreens.aboutActivity;
import com.example.colinbell.casino.cards.Deck;
import com.example.colinbell.casino.cards.Guess;
import com.example.colinbell.casino.players.User;

import static com.example.colinbell.casino.R.string.draw;
import static com.example.colinbell.casino.R.string.playerLoses;
import static com.example.colinbell.casino.R.string.playerWins;

public class drawHiLoActivity extends AppCompatActivity {

    Button high;
    Button lower;
    Button deal;
    TextView showCard;
    TextView showStreak;
    TextView winLose;
    Console console;
    User player;
    Deck deck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_hi_lo);

        high = (Button) findViewById(R.id.high);
        lower = (Button) findViewById(R.id.lo);
        deal = (Button) findViewById(R.id.deal);
        showCard = (TextView) findViewById(R.id.showCard);
        showStreak = (TextView) findViewById(R.id.playerStreak);
        winLose = (TextView) findViewById(R.id.outcome);
        console = new Console();
        player = new User();
        deck = new Deck();


        console.setUserScore(SavedScores.getScores(this, "playerStreak"));
        showStreak.setText(String.valueOf(console.getUserScore()));

        high.setVisibility(View.INVISIBLE);
        lower.setVisibility(View.INVISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_draw_hi_lo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.action_blackjack){
            Intent intent = new Intent(this, blackjackActivity.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.action_about){
            Intent intentAbout = new Intent(this, aboutActivity.class);
            startActivity(intentAbout);
        }
        return super.onOptionsItemSelected(item);
    }


    public void onClickDeal(View view) {
        if (player.countHand() == 1) {
            player.takeCard(deck);
        } else {
            player.deal(deck);
        }
        showCard.setText(player.showCard(0));
        high.setVisibility(View.VISIBLE);
        lower.setVisibility(View.VISIBLE);
        deal.setVisibility(View.INVISIBLE);
    }

    public void onHiLoClick(View view) {
        Guess playerGuess = null;
        if (view == high) {
            playerGuess = Guess.HIGHER;
        }
        if (view == lower) {
            playerGuess = Guess.LOWER;
        }
        high.setVisibility(View.INVISIBLE);
        lower.setVisibility(View.INVISIBLE);
        endGame(playerGuess);
    }

    public void endGame(Guess playerGuess) {
        showCard.setText(player.showCard(1));
        Guess outcome = null;
        if (player.getHand().get(0).getRank().getRanking() > player.getHand().get(1).getRank().getRanking()) {
            outcome = Guess.LOWER;
        }
        if (player.getHand().get(0).getRank().getRanking() < player.getHand().get(1).getRank().getRanking()) {
            outcome = Guess.HIGHER;
        }
        if (player.getHand().get(0).getRank().getRanking() == player.getHand().get(1).getRank().getRanking()) {
            outcome = null;
        }
        if (outcome == null){winLose.setText(draw);}
        else if (outcome == playerGuess) {
            console.updateScore(2);
            winLose.setText(playerWins);
        } else {
            console.setUserScore(0);
            winLose.setText(playerLoses);
        }

        player.burnCard();
        deal.setVisibility(View.VISIBLE);
        showStreak.setText(String.valueOf(console.getUserScore()));
        SavedScores.saveScore(this, console.getUserScore(), "playerStreak");
    }




}
