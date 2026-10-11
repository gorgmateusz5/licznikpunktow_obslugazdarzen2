package com.example.licznikpunktow_obslugazdarzen;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvScoreA;
    private TextView tvScoreB;

    private int scoreA = 0;
    private int scoreB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvScoreA = findViewById(R.id.tvScoreA);
        tvScoreB = findViewById(R.id.tvScoreB);

        View.OnClickListener scoreListener =
                v -> handleScoreClick(v);

        int[] scoreButtonIds = {
                R.id.btnA1,
                R.id.btnA2,
                R.id.btnA3,
                R.id.btnAMinus,
                R.id.btnB1,
                R.id.btnB2,
                R.id.btnB3,
                R.id.btnBMinus
        };

        for (int id : scoreButtonIds) {
            findViewById(id).setOnClickListener(scoreListener);
        }

        findViewById(R.id.btnReset)
                .setOnClickListener(v -> resetScores());

        updateScores();
    }

    private void handleScoreClick(View v) {
        boolean teamA =
                v.getId() == R.id.btnA1
                        || v.getId() == R.id.btnA2
                        || v.getId() == R.id.btnA3
                        || v.getId() == R.id.btnAMinus;

        int change;

        if (v.getId() == R.id.btnA1
                || v.getId() == R.id.btnB1) {
            change = 1;
        } else if (v.getId() == R.id.btnA2
                || v.getId() == R.id.btnB2) {
            change = 2;
        } else if (v.getId() == R.id.btnA3
                || v.getId() == R.id.btnB3) {
            change = 3;
        } else {
            change = -1;
        }

        if (teamA) {
            if (scoreA + change < 0) {
                showNegativeScoreError();
                return;
            }

            scoreA += change;
        } else {
            if (scoreB + change < 0) {
                showNegativeScoreError();
                return;
            }

            scoreB += change;
        }

        updateScores();
    }

    private void updateScores() {
        tvScoreA.setText(String.valueOf(scoreA));
        tvScoreB.setText(String.valueOf(scoreB));
    }

    private void showNegativeScoreError() {
        Toast.makeText(
                this,
                R.string.negative_score_error,
                Toast.LENGTH_SHORT
        ).show();
    }

    private void resetScores() {
        scoreA = 0;
        scoreB = 0;

        updateScores();

        Toast.makeText(
                this,
                R.string.reset_message,
                Toast.LENGTH_SHORT
        ).show();
    }
}