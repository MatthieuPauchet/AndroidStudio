package com.afpa.quizzgame;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.afpa.quizzgame.model.User;

import static java.lang.System.out;

public class MainActivity extends AppCompatActivity {

    private TextView mainWelcomeTxtv;
    private EditText mainNameEtxt;
    private Button mainPlayBtn;

    private User user;

    public static final int GAME_ACTIVITY_REQUEST_CODE = 42;

    private SharedPreferences preferences;

    public static final String PREF_KEY_SCORE = "PREF_KEY_SCORE";
    public static final String PREF_KEY_FIRSTNAME = "PREF_KEY_FIRSTNAME";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainWelcomeTxtv = findViewById(R.id.main_question_txtv);
        mainNameEtxt = findViewById(R.id.main_answer_etxt);
        mainPlayBtn = findViewById(R.id.main_play_btn);
        mainPlayBtn.setEnabled(false);

        mainNameEtxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                mainPlayBtn.setEnabled(true);
            }
        });
    }

    public void StartGame(View view){
        user.setPrenom(mainNameEtxt.getText().toString());

        Intent gameActivityInt = new Intent(MainActivity.this, GameActivity.class);
        startActivityForResult(gameActivityInt, GAME_ACTIVITY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (GAME_ACTIVITY_REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
            // Fetch the score from the Intent
            int score = data.getIntExtra(GameActivity.BUNDLE_EXTRA_SCORE, 0);

            preferences.edit().putInt(PREF_KEY_SCORE, score).apply();

            greetUser();
        }
    }

    private void greetUser() {
        String firstname = preferences.getString(PREF_KEY_FIRSTNAME, null);

        if (null != firstname) {
            int score = preferences.getInt(PREF_KEY_SCORE, 0);

            String fulltext = "Welcome back, " + firstname
                    + "!\nYour last score was " + score
                    + ", will you do better this time?";
            mainWelcomeTxtv.setText(fulltext);
            mainNameEtxt.setText(firstname);
            mainNameEtxt.setSelection(firstname.length());
            mainPlayBtn.setEnabled(true);
        }
    }


    @Override
    protected void onStart() {
        super.onStart();

        out.println("MainActivity::onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        out.println("MainActivity::onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        out.println("MainActivity::onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        out.println("MainActivity::onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        out.println("MainActivity::onDestroy()");
    }
}
