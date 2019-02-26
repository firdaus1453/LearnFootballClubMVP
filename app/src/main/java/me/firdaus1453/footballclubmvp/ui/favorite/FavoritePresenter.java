package me.firdaus1453.footballclubmvp.ui.favorite;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import me.firdaus1453.footballclubmvp.data.local.FootballDatabase;
import me.firdaus1453.footballclubmvp.model.TeamsItem;

/**
 * Created by firdaus1453 on 2/21/2019.
 */
public class FavoritePresenter implements FavoriteContract.Presenter{

    private final FavoriteContract.View view;
    private FootballDatabase footballDatabase;

    public FavoritePresenter(FavoriteContract.View view) {
        this.view = view;
    }

    @Override
    public void getDataListTeams(Context context) {
        footballDatabase = FootballDatabase.getFootballDatabase(context);
        if (footballDatabase.footballDao().selectFavorite() != null){
            view.showDataList(footballDatabase.footballDao().selectFavorite());
        }else {
            view.showFailureMessage("Tidak ada data favorite");
        }
        view.hideRefresh();

    }

    @Override
    public void searchTeams(Context context,String searchText) {
        if (!searchText.isEmpty()) {
            footballDatabase = FootballDatabase.getFootballDatabase(context);
            List<TeamsItem> teamsItemList = footballDatabase.footballDao().selectFavorite();
            List<TeamsItem> mTeamsItemsList = new ArrayList<>();

            if (teamsItemList != null) {
                for (TeamsItem data: teamsItemList){
                    String namaTeam = data.getStrTeam().toLowerCase();
                    Log.i("cek nama perulangan", namaTeam);
                    if (namaTeam.contains(searchText.toLowerCase())){
                        Log.i("isi data loop",data.getStrTeam() );
                        mTeamsItemsList.add(data);
                    }
                }
                Log.i("Isi mTeamList for", mTeamsItemsList.toString());
                view.showDataList(mTeamsItemsList);
            }
        }else {
            getDataListTeams(context);
        }
    }
}
