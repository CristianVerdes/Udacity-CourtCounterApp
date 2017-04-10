package com.example.cristianverdes.footballcounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Cristian Verdes on 4/10/2017.
 */

public class MatchActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int foulsTeamA = 0;
    int scoreTeamB = 0;
    int foulsTeamB = 0;
    TextView teamAName;
    TextView teamBName;
    String teamName = "";
    int teamLogo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        Intent intent = getIntent();
        ImageView teamALogo = (ImageView) findViewById(R.id.team_a_image);
        teamALogo.setImageResource(intent.getIntExtra("teamALogo", 0));

        ImageView teamBLogo = (ImageView) findViewById(R.id.team_b_image);
        teamBLogo.setImageResource(intent.getIntExtra("teamBLogo", 0));

        teamAName = (TextView) findViewById(R.id.team_a_name);
        teamBName = (TextView) findViewById(R.id.team_b_name);

        teamAName.setText(intent.getStringExtra("teamAName"));
        teamBName.setText(intent.getStringExtra("teamBName"));

        getSupportActionBar().setTitle("Match");

    }

    @Override
    public void onBackPressed() {
        SelectTeamsActivity.start(this);
    }

    // Display
    public void displayGoalForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayFoulForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_fouls);
        scoreView.setText(String.valueOf(score));
    }

    public void displayGoalForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayFoulForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_fouls);
        scoreView.setText(String.valueOf(score));
    }

    // Team A
    public void displayTeamAGoal(View view){
        scoreTeamA = scoreTeamA + 1;
        displayGoalForTeamA(scoreTeamA);
    }
    public void displayTeamAFoul(View view){
        foulsTeamA = foulsTeamA + 1;
        displayFoulForTeamA(foulsTeamA);
    }

    // Team B
    public void displayTeamBGoal(View view){
        scoreTeamB = scoreTeamB + 1;
        displayGoalForTeamB(scoreTeamB);
    }
    public void displayTeamBFoul(View view){
        foulsTeamB = foulsTeamB + 1;
        displayFoulForTeamB(foulsTeamB);
    }

    // Reset
    public void endGame(View view){
        if (scoreTeamA < scoreTeamB){
            WinningTeamActivity.start(this, getIntent().getIntExtra("teamBLogo", 0), getIntent().getStringExtra("teamBName"));
        } else if (scoreTeamA == scoreTeamB){
            EvenEndActivity.start(this,
                    getIntent().getIntExtra("teamALogo", 0),
                    getIntent().getStringExtra("teamAName"),
                    getIntent().getIntExtra("teamBLogo", 0),
                    getIntent().getStringExtra("teamBName"));
        } else if (scoreTeamA > scoreTeamB){
            WinningTeamActivity.start(this, getIntent().getIntExtra("teamALogo", 0), getIntent().getStringExtra("teamAName"));

        }

        scoreTeamA = 0;
        scoreTeamB = 0;
        foulsTeamA = 0;
        foulsTeamB = 0;
        displayGoalForTeamA(scoreTeamA);
        displayGoalForTeamB(scoreTeamB);
        displayFoulForTeamA(foulsTeamA);
        displayFoulForTeamB(foulsTeamB);

    }

    // Here we add the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.help:
                Toast.makeText(this, "Use the GOAL button to add a goal and\n" +
                        "use FOULTS to add a foult.", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
