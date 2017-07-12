package com.example.colinbell.casino;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.colinbell.casino.games.blackjackActivity;
import com.example.colinbell.casino.games.drawHiLoActivity;
import com.example.colinbell.casino.nonGameScreens.aboutActivity;
import com.example.colinbell.casino.scoreData.SavedScores;

public class hiScoreActivity extends AppCompatActivity {

    TextView bjHiScore;
    TextView hiLoHiScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hi_score);

        bjHiScore = (TextView) findViewById(R.id.bjHiScore);
        hiLoHiScore = (TextView) findViewById(R.id.hiLoHiScore);

        bjHiScore.setText(String.valueOf(SavedScores.getScores(this,"bjHiScore")));
        hiLoHiScore.setText(String.valueOf(SavedScores.getScores(this, "hiLoHiScore")));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_hi_score, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.action_draw_hi_lo){
            Intent intent = new Intent(this, drawHiLoActivity.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.action_blackjack){
            Intent intentBj = new Intent(this, blackjackActivity.class);
            startActivity(intentBj);
        }
        if (item.getItemId() == R.id.action_about){
            Intent intentAbout = new Intent(this, aboutActivity.class);
            startActivity(intentAbout);
        }
        return super.onOptionsItemSelected(item);
    }


}
