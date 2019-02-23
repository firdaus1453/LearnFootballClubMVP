package me.firdaus1453.footballclubmvp.ui.teams;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.firdaus1453.footballclubmvp.R;
import me.firdaus1453.footballclubmvp.model.TeamsItem;
import me.firdaus1453.footballclubmvp.ui.detail.DetailTeamActivity;
import me.firdaus1453.footballclubmvp.utils.Constants;

/**
 * Created by firdaus1453 on 2/21/2019.
 */
public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.ViewHolder> {

    private final Context context;
    private final List<TeamsItem> teamsItemList;


    public TeamsAdapter(Context context, List<TeamsItem> teamsItemList) {
        this.context = context;
        this.teamsItemList = teamsItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_team_football, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final TeamsItem teamsItem = teamsItemList.get(position);
        RequestOptions options = new RequestOptions().error(R.drawable.ic_broken_image).placeholder(R.drawable.ic_broken_image);

        Glide.with(context).load(teamsItem.getStrTeamBadge()).apply(options).into(holder.imgLogoTeam);
        holder.txtNameTeam.setText(teamsItem.getStrTeam());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailTeamActivity.class);
                intent.putExtra(Constants.KEY_DATA, teamsItem);
                context.startActivity(intent);
                ((Activity) context).overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        });

    }

    @Override
    public int getItemCount() {
        return teamsItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_logo_team)
        ImageView imgLogoTeam;
        @BindView(R.id.txt_name_team)
        TextView txtNameTeam;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}
