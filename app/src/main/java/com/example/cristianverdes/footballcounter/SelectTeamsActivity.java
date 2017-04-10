package com.example.cristianverdes.footballcounter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.cristianverdes.footballcounter.model.Team;
import com.example.cristianverdes.footballcounter.model.adapters.TeamsAdapter;

import java.util.ArrayList;

public class SelectTeamsActivity extends AppCompatActivity {
    private final String teams_names[] = {
            "Alaves",
            "Athletic Bilbao",
            "Atletico Madrid",
            "Barcelona",
            "Celta de Vigo",
            "Deportivo de La Coruna",
            "Eibar",
            "Granada CF",
            "Las Palmas",
            "Leganes",
            "Malaga",
            "Osasuna",
            "RCD Espanyol",
            "Real Betis",
            "Real Madrid",
            "Real Sociedad",
            "Real Sporting de Gijon",
            "Sevilla",
            "Valencia",
            "Villarreal"
    };

    private final int teams_logos[] = {
            R.drawable.alavez,
            R.drawable.athletic_bilbao,
            R.drawable.atletico_madrid,
            R.drawable.barcelona,
            R.drawable.celta_de_vigo,
            R.drawable.deportivo_de_la_coruna,
            R.drawable.eibar,
            R.drawable.granada_cf,
            R.drawable.las_palmas,
            R.drawable.leganes,
            R.drawable.malaga,
            R.drawable.osasuna,
            R.drawable.rcd_espanyol,
            R.drawable.real_betis,
            R.drawable.real_madrid,
            R.drawable.real_sociedad,
            R.drawable.real_sporting_de_gijon,
            R.drawable.sevilla,
            R.drawable.valencia,
            R.drawable.villarreal
    };

    public static void start(Context context) {
        Intent starter = new Intent(context, SelectTeamsActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_teams);
        initViews();
        getSupportActionBar().setTitle("La Liga");
    }
    private void initViews(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Team> teams = prepareData();
        TeamsAdapter adapter = new TeamsAdapter(this, teams);
        recyclerView.setAdapter(adapter);

    }
    private ArrayList<Team> prepareData(){
        ArrayList<Team> android_version = new ArrayList<>();
        for(int i = 0; i< teams_names.length; i++){
            Team team = new Team();
            team.setTeamName(teams_names[i]);
            team.setTeamLogo(teams_logos[i]);
            android_version.add(team);
        }
        return android_version;
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
                Toast.makeText(this, "Select by tapping the logo of \n " +
                        "the two teams for the match.", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
