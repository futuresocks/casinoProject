package com.example.colinbell.casino;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.colinbell.casino.R.id.about;
import static com.example.colinbell.casino.R.id.blackjack;
import static com.example.colinbell.casino.R.id.drawHiLo;

public class launchScreen extends AppCompatActivity {

    Button blackjack;
    Button drawHiLo;
    Button about;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_screen);

        blackjack = (Button) findViewById(R.id.blackjack);
        drawHiLo = (Button) findViewById(R.id.drawHiLo);
        about = (Button) findViewById(R.id.about);
    }

    public void onLaunchClick(View view) {
        if (view == blackjack) {
            Intent  goBlackjack= new Intent(this, blackjackActivity.class);
            startActivity(goBlackjack);
        }
        if (view == drawHiLo) {
            Intent drawHiLo = new Intent(this, drawHiLoActivity.class);
            startActivity(drawHiLo);
        }
        if (view == about) {
            Intent about = new Intent(this, aboutActivity.class);
            startActivity(about);
    }
}

}
