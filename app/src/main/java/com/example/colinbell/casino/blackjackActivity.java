package com.example.colinbell.casino;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.colinbell.casino.cards.Deck;
import com.example.colinbell.casino.games.Blackjack;
import com.example.colinbell.casino.games.Console;
import com.example.colinbell.casino.players.Dealer;
import com.example.colinbell.casino.players.User;

import org.w3c.dom.Text;

public class blackjackActivity extends AppCompatActivity {

    Button deal;
    TextView dealerHand;
    TextView playerHand;
    TextView winner;
    User user;
    Dealer dealer;
    Deck deck;
    Blackjack blackjack;
    Console console;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blackjack);

        dealerHand = (TextView)findViewById(R.id.dealerHand);
        playerHand = (TextView)findViewById(R.id.playerHand);
        deal = (Button)findViewById(R.id.deal);
        winner = (TextView)findViewById(R.id.winner);
        User user = new User("Colin");
        Dealer dealer = new Dealer("Dealer");
        Deck deck = new Deck();
        Blackjack blackjack = new Blackjack();
        Console console = new Console();

        user.deal(deck);
        dealer.deal(deck);
        dealerHand.setText(dealer.showHand());
        playerHand.setText(user.showHand());
        int outcome = blackjack.compareHands(user, dealer);
        console.declareWinner(winner, outcome);

    }

}
