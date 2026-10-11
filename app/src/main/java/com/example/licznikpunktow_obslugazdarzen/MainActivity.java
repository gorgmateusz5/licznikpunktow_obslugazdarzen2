
package com.example.licznikpunktow_obslugazdarzen;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    private int scoreA = 0;
    private int scoreB = 0;

    private TextView tvScoreA;
    private TextView tvScoreB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvScoreA = findViewById(R.id.tvScoreA);
        tvScoreB = findViewById(R.id.tvScoreB);

        // Jeden listener obsługuje przyciski obu drużyn.
        findViewById(R.id.btnA1).setOnClickListener(this);
        findViewById(R.id.btnA2).setOnClickListener(this);
        findViewById(R.id.btnA3).setOnClickListener(this);
        findViewById(R.id.btnAMinus).setOnClickListener(this);

        findViewById(R.id.btnB1).setOnClickListener(this);
        findViewById(R.id.btnB2).setOnClickListener(this);
        findViewById(R.id.btnB3).setOnClickListener(this);
        findViewById(R.id.btnBMinus).setOnClickListener(this);

        findViewById(R.id.btnReset).setOnClickListener(this);

        updateScores();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.btnReset) {
            resetScores();
            return;
        }

        int change = 0;
        boolean teamA = false;

        if (id == R.id.btnA1) {
            change = 1;
            teamA = true;
        } else if (id == R.id.btnA2) {
            change = 2;
            teamA = true;
        } else if (id == R.id.btnA3) {
            change = 3;
            teamA = true;
        } else if (id == R.id.btnAMinus) {
            change = -1;
            teamA = true;
        } else if (id == R.id.btnB1) {
            change = 1;
        } else if (id == R.id.btnB2) {
            change = 2;
        } else if (id == R.id.btnB3) {
            change = 3;
        } else if (id == R.id.btnBMinus) {
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

    private void showNegativeScoreError() {
        Toast.makeText(
                this,
                R.string.negative_score_error,
                Toast.LENGTH_SHORT
        ).show();
    }
}

