package com.example.colinbell.casino.scoreData;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.ShareActionProvider;

/**
 * Created by user on 10/07/2017.
 */

public class SavedScores {

    public static void saveScore(Context context, int score, String key){
        SharedPreferences scores = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = scores.edit();
        editor.putInt(key, score);
        editor.apply();
    }

    public static int getScores(Context context, String key){
        SharedPreferences scores = PreferenceManager.getDefaultSharedPreferences(context);
        return scores.getInt(key, 0);
    }
}
