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

public class EvenEndActivity extends AppCompatActivity {

    public static void start(Context context, int teamALogo, String teamAName, int teamBLogo, String teamBName) {
        Intent starter = new Intent(context, EvenEndActivity.class);
        starter.putExtra("teamALogo", teamALogo);
        starter.putExtra("teamAName", teamAName);
        starter.putExtra("teamBLogo", teamBLogo);
        starter.putExtra("teamBName", teamBName);
        context.startActivity(starter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_even_end);

        ImageView teamALogo = (ImageView) findViewById(R.id.team_a_logo);
        TextView teamAName = (TextView) findViewById(R.id.team_a_name);

        ImageView teamBLogo = (ImageView) findViewById(R.id.team_b_logo);
        TextView teamBName = (TextView) findViewById(R.id.team_b_name);

        int teamALogoResource = getIntent().getIntExtra("teamALogo", 0);
        String teamANameResource = getIntent().getStringExtra("teamAName");

        int teamBLogoResource = getIntent().getIntExtra("teamBLogo", 0);
        String teamBNameResource = getIntent().getStringExtra("teamBName");

        teamALogo.setImageResource(teamALogoResource);
        teamAName.setText(teamANameResource);

        teamBLogo.setImageResource(teamBLogoResource);
        teamBName.setText(teamBNameResource);
    }

    @Override
    public void onBackPressed() {
        SelectTeamsActivity.start(this);
    }
}
