package com.example.cristianverdes.footballcounter.model.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cristianverdes.footballcounter.MatchActivity;
import com.example.cristianverdes.footballcounter.R;
import com.example.cristianverdes.footballcounter.model.Team;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
/**
 * Created by Cristian Verdes on 4/10/2017.
 */

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.ViewHolder> {
    static int indexTeams = 0;
    private ArrayList<Team> teams;
    private Context context;
    private Intent intent;

    public TeamsAdapter(Context context, ArrayList<Team> teams) {
        this.teams = teams;
        this.context = context;
        intent = new Intent(context, MatchActivity.class);
    }

    @Override
    public TeamsAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TeamsAdapter.ViewHolder viewHolder, int i) {
        final int position = i;

        viewHolder.teamName.setText(teams.get(i).getTeamName());
        Picasso.with(context)
                .load(teams.get(i).getTeamLogo())
                .resize(300, 340).into(viewHolder.teamLogo);

        viewHolder.teamLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (indexTeams == 0){
                    intent.putExtra("teamALogo", teams.get(position).getTeamLogo());
                    intent.putExtra("teamAName", teams.get(position).getTeamName());
                    indexTeams++;
                    teams.remove(position);
                    TeamsAdapter.this.notifyDataSetChanged();
                } else {
                    intent.putExtra("teamBLogo", teams.get(position).getTeamLogo());
                    intent.putExtra("teamBName", teams.get(position).getTeamName());
                    indexTeams = 0;
                    context.startActivity(intent);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView teamName;
        private ImageView teamLogo;
        public ViewHolder(View view) {
            super(view);

            teamName = (TextView)view.findViewById(R.id.tv_android);
            teamLogo = (ImageView) view.findViewById(R.id.img_android);
        }
    }
}