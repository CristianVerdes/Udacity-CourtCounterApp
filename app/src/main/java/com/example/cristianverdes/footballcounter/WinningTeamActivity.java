package com.example.cristianverdes.footballcounter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Cristian Verdes on 4/10/2017.
 */

public class WinningTeamActivity extends AppCompatActivity {

    public static void start(Context context, int teamLogo, String teamName) {
        Intent starter = new Intent(context, WinningTeamActivity.class);
        starter.putExtra("teamLogo", teamLogo);
        starter.putExtra("teamName", teamName);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winning_team);

        ImageView teamLogo = (ImageView) findViewById(R.id.team_logo);
        TextView teamName = (TextView) findViewById(R.id.team_name);

        int teamLogoResource = getIntent().getIntExtra("teamLogo", 0);
        String teamNameResource = getIntent().getStringExtra("teamName");

        teamLogo.setImageResource(teamLogoResource);
        teamName.setText(teamNameResource);

    }

    @Override
    public void onBackPressed() {
        SelectTeamsActivity.start(this);
    }
}
